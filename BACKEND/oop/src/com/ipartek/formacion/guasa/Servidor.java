package com.ipartek.formacion.guasa;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Servidor {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Servidor GUASA");
		
		frame.setBounds(0, 0, 500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //.DISPOSE_ON_CLOSE);

//		frame.addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosed(WindowEvent e) {
//				System.exit(0);
//			}
//		});
		
		JTextArea textArea = new JTextArea();
		frame.add(textArea);
		
		frame.setVisible(true);
		
		try (ServerSocket serverSocket = new ServerSocket(1234)) {
			ConexionUsuario conexion;

			Socket socket;
			Thread hilo;

			do {
				socket = serverSocket.accept();

				conexion = new ConexionUsuario(socket, textArea);

				hilo = new Thread(conexion);

				hilo.start();
			} while (true);

		} catch (IOException e) {
			System.out.println("Error en el servidor");
		}
	}

}
