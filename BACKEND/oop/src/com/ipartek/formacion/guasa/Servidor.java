package com.ipartek.formacion.guasa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	public static void main(String[] args) {
		System.out.println("Arranque del servidor GUASA");
		
		try (ServerSocket ss = new ServerSocket(1234)) {
			ConexionUsuario conexion;

			Socket s;
			Thread hilo;

			do {
				s = ss.accept();

				conexion = new ConexionUsuario(s);

				hilo = new Thread(conexion);

				hilo.start();
			} while (true);

		} catch (IOException e) {
			System.out.println("Error en el servidor");
		}
	}

}
