package com.ipartek.formacion.tienda.accesodatos;

import static com.ipartek.formacion.tienda.accesodatos.GlobalesAccesoDatos.EMF;

import com.ipartek.formacion.tienda.modelos.Producto;

public class DaoProductoJpa implements DaoProducto {

	@Override
	public Iterable<Producto> obtenerTodos() {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var productos = em.createQuery("from Producto", Producto.class).getResultList();

		t.commit();
		em.close();

		return productos;
	}

	@Override
	public Producto obtenerPorId(Long id) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var producto = em.find(Producto.class, id);

		t.commit();
		em.close();

		return producto;
	}

	@Override
	public Producto insertar(Producto producto) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.persist(producto);

		t.commit();
		em.close();

		return producto;
	}

	@Override
	public Producto modificar(Producto producto) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.merge(producto);

		t.commit();
		em.close();

		return producto;
	}

	@Override
	public void borrar(Long id) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.remove(em.find(Producto.class, id));

		t.commit();
		em.close();
	}

	@Override
	public Iterable<Producto> buscarPorNombre(String nombre) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		var productos = em.createQuery("from Producto where nombre like :nombre", Producto.class)
				.setParameter("nombre", "%" + nombre + "%").getResultList();

		t.commit();
		em.close();

		return productos;
	}

}
