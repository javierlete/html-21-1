package com.ipartek.formacion.guasa;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.util.Scanner;

public class Servidor {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) throws IOException {
		ServerSocket ss = new ServerSocket(1234);

		Socket s;

		boolean cerrar = false;

		do {
			s = ss.accept();

			PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
			Scanner sc = new Scanner(s.getInputStream());

			pw.println("Bienvenido a GUASA. Dime tu nombre.");

			String nombre = sc.nextLine();

			boolean salir = false;

			do {
				String texto = sc.nextLine();

				switch (texto) {
				case "CERRAR_SERVIDOR":
					cerrar = true;
				case "":
					salir = true;
					break;
				default:
					System.out.printf("%s (%s): %s\n", LocalTime.now(), nombre, texto);
				}
			} while (!salir);

			pw.close();
			sc.close();
			s.close();
		} while (!cerrar);

		ss.close();
	}
}
