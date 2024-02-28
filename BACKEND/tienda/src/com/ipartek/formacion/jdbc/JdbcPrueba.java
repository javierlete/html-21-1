package com.ipartek.formacion.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcPrueba {

	private static final String URL = "jdbc:sqlite:tienda.db";
	private static final String USER = "";
	private static final String PASS = "";
	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, fecha_caducidad) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	public static void main(String[] args) {
		try (Connection con = DriverManager.getConnection(URL, USER, PASS);) {
			try (PreparedStatement pst = con.prepareStatement(SQL_SELECT); ResultSet rs = pst.executeQuery();) {
				while (rs.next()) {
					System.out.printf("%20s %20s %20s %20s\n", rs.getLong("id"), rs.getString("nombre"),
							rs.getBigDecimal("precio"), rs.getString("fecha_caducidad"));
				}
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
				Long id = 2L;

				pst.setLong(1, id);

				try (ResultSet rs = pst.executeQuery()) {
					if (rs.next()) {
						System.out.printf("%20s %20s %20s %20s\n", rs.getLong("id"), rs.getString("nombre"),
								rs.getBigDecimal("precio"), rs.getString("fecha_caducidad"));
					} else {
						System.out.println("No se ha encontrado");
					}
				}
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {

				String nombre = "Producto Nuevo";
				BigDecimal precio = new BigDecimal("132435");
				String fecha = "2026-01-02";

				pst.setString(1, nombre);
				pst.setBigDecimal(2, precio);
				pst.setString(3, fecha);

				int numeroRegistrosModificados = pst.executeUpdate();

				System.out.println(numeroRegistrosModificados);
			}

			try (PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {

				String nombre = "Modificado";
				BigDecimal precio = BigDecimal.ONE;
				String fecha = "2027-01-01";

				Long id = 1L;

				pst.setString(1, nombre);
				pst.setBigDecimal(2, precio);
				pst.setString(3, fecha);

				pst.setLong(4, id);

				int numeroRegistrosModificados = pst.executeUpdate();

				System.out.println(numeroRegistrosModificados);
			}

			Long id = 2L;

			try (PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {

				pst.setLong(1, id);

				int numeroRegistrosModificados = pst.executeUpdate();

				System.out.println(numeroRegistrosModificados);
			}
		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
	}
}
