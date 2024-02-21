package com.ipartek.formacion.flujos;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServidorSocket {
	private static final boolean AUTO_FLUSH = true;

	public static void main(String[] args) {
		System.out.println("Arranque del servidor");
		
		try (ServerSocket ss = new ServerSocket(1234);
				Socket s = ss.accept();
				PrintWriter pw = new PrintWriter(s.getOutputStream(), AUTO_FLUSH);
				Scanner sc = new Scanner(s.getInputStream())) {
			pw.println("Bienvenido a MAYUSCULATOR");
			
			String texto = sc.nextLine();
			
			System.out.println("Se ha recibido el texto " + texto);
			
			pw.println(texto.toUpperCase());
		} catch (IOException e) {
			System.out.println("Error en el servidor MAYUSCULATOR");
		}
		
		
	}
}
