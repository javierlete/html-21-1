package com.ipartek.formacion.guasa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

import javax.swing.JTextArea;

public class ConexionUsuario implements Runnable {
	private static final boolean AUTO_FLUSH = true;
	
	private Socket socket;
	private boolean cerrar;
	private JTextArea textArea;
	
	public ConexionUsuario(Socket socket, JTextArea textArea) {
		this.socket = socket;
		this.textArea = textArea;
	}

	public boolean isCerrar() {
		return cerrar;
	}

	public void setCerrar(boolean cerrar) {
		this.cerrar = cerrar;
	}

	@Override
	public void run() {
		try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), AUTO_FLUSH);
				Scanner sc = new Scanner(socket.getInputStream())) {
			pw.println("Bienvenido a GUASA. Dime tu nombre.");

			String nombre = sc.nextLine();

			boolean salir = false;

			do {
				String texto = sc.nextLine();

				switch (texto) {
				case "CERRAR_SERVIDOR":
					setCerrar(true);
				case "":
					salir = true;
					break;
				default:
					textArea.append(String.format("%s (%s): %s\n", LocalTime.now(), nombre, texto));
				}
			} while (!salir);

			pw.close();
			sc.close();
		} catch (IOException e) {
			textArea.append("Error de conexión");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				textArea.append("Error de cierre de socket");
			}
		}
	}

}
