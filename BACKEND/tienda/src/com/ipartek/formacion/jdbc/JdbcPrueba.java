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

	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		PreparedStatement pst = con.prepareStatement(SQL_SELECT);
		ResultSet rs = pst.executeQuery();

		while (rs.next()) {
			System.out.printf("%20s %20s %20s %20s\n", rs.getLong("id"), rs.getString("nombre"),
					rs.getBigDecimal("precio"), rs.getString("fecha_caducidad"));
		}

		rs.close();
		pst.close();

		pst = con.prepareStatement(SQL_SELECT_ID);

		Long id = 2L;

		pst.setLong(1, id);
		rs = pst.executeQuery();

		if (rs.next()) {
			System.out.printf("%20s %20s %20s %20s\n", rs.getLong("id"), rs.getString("nombre"),
					rs.getBigDecimal("precio"), rs.getString("fecha_caducidad"));
		} else {
			System.out.println("No se ha encontrado");
		}

		rs.close();
		pst.close();

		pst = con.prepareStatement(SQL_INSERT);

		String nombre = "Producto Nuevo";
		BigDecimal precio = new BigDecimal("132435");
		String fecha = "2026-01-02";

		pst.setString(1, nombre);
		pst.setBigDecimal(2, precio);
		pst.setString(3, fecha);

		int numeroRegistrosModificados = pst.executeUpdate();

		pst.close();

		System.out.println(numeroRegistrosModificados);

		pst = con.prepareStatement(SQL_UPDATE);

		nombre = "Modificado";
		precio = BigDecimal.ONE;
		fecha = "2027-01-01";

		id = 1L;

		pst.setString(1, nombre);
		pst.setBigDecimal(2, precio);
		pst.setString(3, fecha);

		pst.setLong(4, id);

		numeroRegistrosModificados = pst.executeUpdate();
		
		pst.close();
		
		System.out.println(numeroRegistrosModificados);
		
		id = 2L;
		
		pst = con.prepareStatement(SQL_DELETE);
		
		pst.setLong(1, id);
		
		numeroRegistrosModificados = pst.executeUpdate();
		
		pst.close();
		
		System.out.println(numeroRegistrosModificados);
	}
}
