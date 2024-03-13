package com.ipartek.formacion.tienda.negocio;

import com.ipartek.formacion.tienda.modelos.Producto;
import com.ipartek.formacion.tienda.modelos.Usuario;

public interface AnonimoNegocio {
	Usuario verificarLogin(String email, String password);
	
	Iterable<Producto> listarProductos();
	Producto verDetalleProducto(Long id);
	
	Iterable<Producto> listarProductosCarrito();
	void agregarProductoACarrito(Producto producto);
}
