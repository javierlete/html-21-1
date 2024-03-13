package com.ipartek.formacion.tienda.negocio;

import static com.ipartek.formacion.tienda.negocio.GlobalesNegocio.DAO_PRODUCTO;

import com.ipartek.formacion.tienda.modelos.Producto;

import lombok.extern.java.Log;

@Log
public class AdminNegocioImpl extends AnonimoNegocioImpl implements AdminNegocio {

	// private static final Logger log = Logger.getLogger(AdminNegocioImpl.class.getName());
	
	@Override
	public Iterable<Producto> listarProductos() {
		log.info("Se van a listar los productos");
		return super.listarProductos();
	}

	@Override
	public Producto verDetalleProducto(Long id) {
		log.info("Se va a pedir el producto " + id);
		return super.verDetalleProducto(id);
	}

	@Override
	public Producto agregarProducto(Producto producto) {
		log.info("Se va a guardar el producto " + producto);
		return DAO_PRODUCTO.insertar(producto);
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		log.info("Se va a modificar el producto " + producto);
		return DAO_PRODUCTO.modificar(producto);
	}

	@Override
	public void borrarProducto(Long id) {
		log.info("Se va a borrar el producto " + id);
		DAO_PRODUCTO.borrar(id);
	}
}
