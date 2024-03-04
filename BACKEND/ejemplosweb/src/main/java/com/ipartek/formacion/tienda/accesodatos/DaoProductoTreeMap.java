package com.ipartek.formacion.tienda.accesodatos;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.TreeMap;

import com.ipartek.formacion.tienda.entidades.Producto;

public class DaoProductoTreeMap implements DaoProducto {

	private static final TreeMap<Long, Producto> productos = new TreeMap<>();

	static {
		productos.put(1L, new Producto(1L, "Producto1", new BigDecimal("11"), LocalDate.of(2025, 1, 1)));
		productos.put(2L, new Producto(2L, "Producto2", new BigDecimal("12"), LocalDate.of(2026, 1, 1)));
		productos.put(3L, new Producto(3L, "Producto3", new BigDecimal("13"), LocalDate.of(2027, 1, 1)));
	}

	// SINGLETON
	private DaoProductoTreeMap() {
	}

	private static final DaoProductoTreeMap INSTANCIA = new DaoProductoTreeMap();

	public static DaoProductoTreeMap getInstancia() {
		return INSTANCIA;
	}
	// FIN SINGLETON

	@Override
	public Iterable<Producto> obtenerTodos() {
		return productos.values();
	}

	@Override
	public Producto obtenerPorId(Long id) {
		return productos.get(id);
	}

	@Override
	public Producto insertar(Producto producto) {
		Long id = productos.size() > 0 ? productos.lastKey() + 1L : 1L;

		producto.setId(id);

		productos.put(id, producto);

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		productos.put(producto.getId(), producto);

		return producto;
	}

	@Override
	public void borrar(Long id) {
		productos.remove(id);
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		return productos.values().stream().filter(p -> p.getNombre().contains(nombre)).toList();
	}

}
