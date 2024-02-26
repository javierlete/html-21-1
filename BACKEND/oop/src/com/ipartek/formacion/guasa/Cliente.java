package com.ipartek.formacion.guasa;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Cliente {

	private static final boolean AUTO_FLUSH = true;
	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfMensaje;

	private Socket socket;
	private PrintWriter pw;
	private Scanner sc;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cliente window = new Cliente();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Cliente() {
		try {
			UIManager.setLookAndFeel(
			        UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 460, 130);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(22, 30, 41, 13);
		frame.getContentPane().add(lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setBounds(73, 27, 268, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(22, 56, 41, 13);
		frame.getContentPane().add(lblMensaje);
		
		tfMensaje = new JTextField();
		tfMensaje.setBounds(73, 53, 268, 19);
		frame.getContentPane().add(tfMensaje);
		tfMensaje.setColumns(10);
		
		JButton btnConectar = new JButton("Conectar");
		btnConectar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					socket = new Socket("localhost", 1234);
					
					pw = new PrintWriter(socket.getOutputStream(), AUTO_FLUSH);
					sc = new Scanner(socket.getInputStream());
					
					sc.nextLine();
					
					pw.println(tfNombre.getText());
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(frame, "Ha habido un error en el cliente");
					e1.printStackTrace();
				}
			}
		});
		btnConectar.setBounds(351, 26, 85, 21);
		frame.getContentPane().add(btnConectar);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pw.println(tfMensaje.getText());
			}
		});
		btnEnviar.setBounds(351, 52, 85, 21);
		frame.getContentPane().add(btnEnviar);
	}
}
