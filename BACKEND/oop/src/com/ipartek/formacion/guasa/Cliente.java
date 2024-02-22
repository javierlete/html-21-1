package com.ipartek.formacion.guasa;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cliente {

	private JFrame frame;
	private JTextField tfNombre;
	private JTextField tfMensaje;

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
		tfNombre.setBounds(73, 27, 192, 19);
		frame.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		JLabel lblMensaje = new JLabel("Mensaje");
		lblMensaje.setBounds(22, 56, 41, 13);
		frame.getContentPane().add(lblMensaje);
		
		tfMensaje = new JTextField();
		tfMensaje.setBounds(73, 53, 268, 19);
		frame.getContentPane().add(tfMensaje);
		tfMensaje.setColumns(10);
		
		JButton btnNombre = new JButton("Cambiar nombre");
		btnNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Cambiar nombre");
				System.out.println(tfNombre.getText());
			}
		});
		btnNombre.setBounds(275, 26, 161, 21);
		frame.getContentPane().add(btnNombre);
		
		JButton btnEnviar = new JButton("Enviar");
		btnEnviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Enviar");
				System.out.println(tfMensaje.getText());
			}
		});
		btnEnviar.setBounds(351, 52, 85, 21);
		frame.getContentPane().add(btnEnviar);
	}
}
