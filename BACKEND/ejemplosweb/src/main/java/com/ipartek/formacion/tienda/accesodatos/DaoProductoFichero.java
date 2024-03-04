package com.ipartek.formacion.tienda.accesodatos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.ipartek.formacion.tienda.entidades.Producto;

public class DaoProductoFichero implements DaoProducto {

	private String path;

	public DaoProductoFichero(String path) {
		this.path = path;
	}

	@Override
	public Iterable<Producto> obtenerTodos() {
		return leerProductos().values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		var productos = leerProductos();

		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		var productos = leerProductos();

		Long id = productos.size() > 0 ? productos.lastKey() + 1L : 1L;

		producto.setId(id);

		productos.put(id, producto);

		guardarProductos(productos);

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		var productos = leerProductos();

		productos.put(producto.getId(), producto);

		guardarProductos(productos);

		return producto;
	}

	@Override
	public void borrar(Long id) {
		var productos = leerProductos();

		productos.remove(id);

		guardarProductos(productos);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		var productos = leerProductos();

		return productos.values().stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

	@SuppressWarnings("unchecked")
	private TreeMap<Long, Producto> leerProductos() {
		TreeMap<Long, Producto> productos;

		try (var fis = new FileInputStream(path); var ois = new ObjectInputStream(fis)) {
			productos = (TreeMap<Long, Producto>) ois.readObject();
		} catch (FileNotFoundException e) {
			guardarProductos(productos = new TreeMap<Long, Producto>());
		} catch (ClassNotFoundException | IOException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}

		return productos;
	}

	private void guardarProductos(TreeMap<Long, Producto> productos) {
		try (var fos = new FileOutputStream(path); var oos = new ObjectOutputStream(fos)) {
			oos.writeObject(productos);
		} catch (IOException e) {
			throw new AccesoDatosException("No se han podido guardar los cambios", e);
		}
	}

}
