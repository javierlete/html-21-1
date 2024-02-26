package com.ipartek.formacion.guasa;

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
		String nombre = null;
		
		try (PrintWriter pw = new PrintWriter(socket.getOutputStream(), AUTO_FLUSH);
				Scanner sc = new Scanner(socket.getInputStream())) {
			pw.println("Bienvenido a GUASA. Dime tu nombre.");

			nombre = sc.nextLine();

			mensaje(nombre, "SE HA CONECTADO");
			
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
					mensaje(nombre, texto);
				}
			} while (!salir);

			pw.close();
			sc.close();
		} catch (Exception e) {
			nombre = nombre != null ? nombre : "DESCONOCIDO";
			mensaje(nombre, "SE HA DESCONECTADO");
		} finally {
			try {
				socket.close();
			} catch (Exception e) {
				textArea.append("Error de cierre de socket");
			}
		}
	}

	private void mensaje(String nombre, String texto) {
		textArea.append(String.format("%s (%s): %s\n", LocalTime.now(), nombre, texto));
	}

}
