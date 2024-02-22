package com.ipartek.formacion.guasa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class ConexionUsuario implements Runnable {
	private static final boolean AUTO_FLUSH = true;
	
	private Socket socket;
	private boolean cerrar;
	
	public ConexionUsuario(Socket socket) {
		this.socket = socket;
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
					System.out.printf("%s (%s): %s\n", LocalTime.now(), nombre, texto);
				}
			} while (!salir);

			pw.close();
			sc.close();
		} catch (IOException e) {
			System.out.println("Error de conexión");
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
				System.out.println("Error de cierre de socket");
			}
		}
	}

}
