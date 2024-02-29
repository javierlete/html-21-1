package com.ipartek.formacion.tienda.presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import com.ipartek.formacion.tienda.accesodatos.DaoProducto;
import com.ipartek.formacion.tienda.accesodatos.FabricaDao;
import com.ipartek.formacion.tienda.entidades.Producto;

public class PresentacionSwing {
	private static final DaoProducto DAO = new FabricaDao().getDaoProducto();

	private DefaultTableModel tableModel;
	
	private JFrame frame;
	private JTable tListado;
	private JTextField tfId;
	private JTextField tfNombre;
	private JTextField tfPrecio;
	private JTextField tfFecha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PresentacionSwing window = new PresentacionSwing();
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
	public PresentacionSwing() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		initialize();

		tableModel = new DefaultTableModel();

		tableModel.addColumn("Id");
		tableModel.addColumn("Nombre");
		tableModel.addColumn("Precio");
		tableModel.addColumn("Fecha de caducidad");

		for (var p : DAO.obtenerTodos()) {
			tableModel.addRow(new Object[] { p.getId(), p.getNombre(), p.getPrecio(), p.getFechaCaducidad() });
		}

		tListado.setModel(tableModel);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 707, 331);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);

		JPanel pFormulario = new JPanel();
		splitPane.setRightComponent(pFormulario);
		GridBagLayout gbl_pFormulario = new GridBagLayout();
		gbl_pFormulario.columnWidths = new int[] { 0, 0, 0 };
		gbl_pFormulario.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_pFormulario.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_pFormulario.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pFormulario.setLayout(gbl_pFormulario);

		JLabel lblId = new JLabel("Id");
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		pFormulario.add(lblId, gbc_lblId);

		tfId = new JTextField();
		GridBagConstraints gbc_tfId = new GridBagConstraints();
		gbc_tfId.insets = new Insets(0, 0, 5, 0);
		gbc_tfId.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfId.gridx = 1;
		gbc_tfId.gridy = 0;
		pFormulario.add(tfId, gbc_tfId);
		tfId.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 0;
		gbc_lblNombre.gridy = 1;
		pFormulario.add(lblNombre, gbc_lblNombre);

		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.anchor = GridBagConstraints.NORTH;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 0);
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.gridx = 1;
		gbc_tfNombre.gridy = 1;
		pFormulario.add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);

		JLabel lblPrecio = new JLabel("Precio");
		GridBagConstraints gbc_lblPrecio = new GridBagConstraints();
		gbc_lblPrecio.anchor = GridBagConstraints.EAST;
		gbc_lblPrecio.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrecio.gridx = 0;
		gbc_lblPrecio.gridy = 2;
		pFormulario.add(lblPrecio, gbc_lblPrecio);

		tfPrecio = new JTextField();
		GridBagConstraints gbc_tfPrecio = new GridBagConstraints();
		gbc_tfPrecio.insets = new Insets(0, 0, 5, 0);
		gbc_tfPrecio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPrecio.gridx = 1;
		gbc_tfPrecio.gridy = 2;
		pFormulario.add(tfPrecio, gbc_tfPrecio);
		tfPrecio.setColumns(10);

		JLabel lblFecha = new JLabel("Fecha de caducidad");
		GridBagConstraints gbc_lblFecha = new GridBagConstraints();
		gbc_lblFecha.anchor = GridBagConstraints.EAST;
		gbc_lblFecha.insets = new Insets(0, 0, 5, 5);
		gbc_lblFecha.gridx = 0;
		gbc_lblFecha.gridy = 3;
		pFormulario.add(lblFecha, gbc_lblFecha);

		tfFecha = new JTextField();
		GridBagConstraints gbc_tfFecha = new GridBagConstraints();
		gbc_tfFecha.anchor = GridBagConstraints.NORTH;
		gbc_tfFecha.insets = new Insets(0, 0, 5, 0);
		gbc_tfFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFecha.gridx = 1;
		gbc_tfFecha.gridy = 3;
		pFormulario.add(tfFecha, gbc_tfFecha);
		tfFecha.setColumns(10);

		JPanel pBotonera = new JPanel();
		GridBagConstraints gbc_pBotonera = new GridBagConstraints();
		gbc_pBotonera.fill = GridBagConstraints.BOTH;
		gbc_pBotonera.gridx = 1;
		gbc_pBotonera.gridy = 4;
		pFormulario.add(pBotonera, gbc_pBotonera);
		pBotonera.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Producto p = new Producto();
				
				p.setId(Long.parseLong(tfId.getText()));
				p.setNombre(tfNombre.getText());
				p.setPrecio(new BigDecimal(tfPrecio.getText()));
				p.setFechaCaducidad(LocalDate.parse(tfFecha.getText()));
				
				DAO.insertar(p);
				
				tableModel.addRow(new Object[] { p.getId(), p.getNombre(), p.getPrecio(), p.getFechaCaducidad() });
			}
		});
		pBotonera.add(btnAceptar);

		tListado = new JTable();
		splitPane.setLeftComponent(tListado);
	}

}
