package com.ipartek.formacion.tienda.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.tienda.entidades.Producto;

public class DaoProductoSqlite implements DaoProducto {
	private static final String URL = "jdbc:sqlite:";
	private static final String USER = "";
	private static final String PASS = "";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";
	
	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, fecha_caducidad) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	private String fichero;

	public DaoProductoSqlite(String fichero) {
		this.fichero = fichero;
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL + fichero, USER, PASS);
		} catch (SQLException e) {
			throw new AccesoDatosException("No se ha podido conectar a la base de datos", e);
		}
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT);
				ResultSet rs = pst.executeQuery()) {
			var productos = new ArrayList<Producto>();
			Producto producto;
			
			while(rs.next()) {
				producto = filaAProducto(rs);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (Exception e) {
			throw new AccesoDatosException("No han podido obtener los productos", e);
		}
	}

	@Override
	public Producto obtenerPorId(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);
				) {
			pst.setLong(1, id);
			
			ResultSet rs = pst.executeQuery();

			if(rs.next()) {
				return filaAProducto(rs);
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido obtener el producto " + id, e);
		}
	}

	@Override
	public Producto insertar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_INSERT);
				) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getFechaCaducidad().toString());
			
			pst.executeUpdate();
			
			return producto;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido insertar el producto " + producto, e);
		}
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_UPDATE);
				) {
			pst.setString(1, producto.getNombre());
			pst.setBigDecimal(2, producto.getPrecio());
			pst.setString(3, producto.getFechaCaducidad().toString());
			
			pst.setLong(4, producto.getId());
			
			pst.executeUpdate();
			
			return producto;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido modificar el producto " + producto, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_DELETE);
				) {
			pst.setLong(1, id);
			
			pst.executeUpdate();
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido borrar el producto con id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		try (Connection con = obtenerConexion();
				PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);
				) {
			pst.setString(1, "%" + nombre + "%");
			
			ResultSet rs = pst.executeQuery();

			var productos = new ArrayList<Producto>();
			Producto producto;
			
			while(rs.next()) {
				producto = filaAProducto(rs);
				
				productos.add(producto);
			}
			
			return productos;
		} catch (Exception e) {
			throw new AccesoDatosException("No han podido obtener los productos con nombre " + nombre, e);
		}
	}
	
	private Producto filaAProducto(ResultSet rs) throws SQLException {
		String textoFecha = rs.getString("fecha_caducidad");
		LocalDate fechaCaducidad = textoFecha == null ? null : LocalDate.parse(textoFecha);
		
		return new Producto(rs.getLong("id"), rs.getString("nombre"), rs.getBigDecimal("precio"),
				fechaCaducidad);
	}

}
