package com.ipartek.formacion.tienda.accesodatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.ipartek.formacion.tienda.modelos.Producto;

public class DaoProductoMySql implements DaoProducto {
	private static final String URL = "jdbc:mysql://";

	private static final String SQL_SELECT = "SELECT * FROM productos";
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	private static final String SQL_SELECT_NOMBRE = SQL_SELECT + " WHERE nombre LIKE ?";

	private static final String SQL_INSERT = "INSERT INTO productos (nombre, precio, fecha_caducidad) VALUES (?,?,?)";
	private static final String SQL_UPDATE = "UPDATE productos SET nombre=?, precio=?, fecha_caducidad=? WHERE id=?";
	private static final String SQL_DELETE = "DELETE FROM productos WHERE id=?";

	private final String baseDeDatos;
	private final String usuario;
	private final String password;

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new AccesoDatosException("No se ha podido encontrar el driver de MySQL", e);
		}
	}
	
	public DaoProductoMySql(String baseDeDatos, String usuario, String password) {
		this.baseDeDatos = baseDeDatos;
		this.usuario = usuario;
		this.password = password;
	}

	private Connection obtenerConexion() {
		try {
			return DriverManager.getConnection(URL + baseDeDatos, usuario, password);
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

			while (rs.next()) {
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
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_ID);) {
			pst.setLong(1, id);

			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
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
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_INSERT);) {
			productoAFila(producto, pst);

			pst.executeUpdate();

			return producto;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido insertar el producto " + producto, e);
		}
	}

	private void productoAFila(Producto producto, PreparedStatement pst) throws SQLException {
		pst.setString(1, producto.getNombre());
		pst.setBigDecimal(2, producto.getPrecio());
		
		LocalDate fecha = producto.getFechaCaducidad();
		
		pst.setString(3, fecha == null ? null : fecha.toString());
	}

	@Override
	public Producto modificar(Producto producto) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_UPDATE);) {
			productoAFila(producto, pst);

			pst.setLong(4, producto.getId());

			pst.executeUpdate();

			return producto;
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido modificar el producto " + producto, e);
		}
	}

	@Override
	public void borrar(Long id) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_DELETE);) {
			pst.setLong(1, id);

			pst.executeUpdate();
		} catch (Exception e) {
			throw new AccesoDatosException("No ha podido borrar el producto con id " + id, e);
		}
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		try (Connection con = obtenerConexion(); PreparedStatement pst = con.prepareStatement(SQL_SELECT_NOMBRE);) {
			pst.setString(1, "%" + nombre + "%");

			ResultSet rs = pst.executeQuery();

			var productos = new ArrayList<Producto>();
			Producto producto;

			while (rs.next()) {
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
