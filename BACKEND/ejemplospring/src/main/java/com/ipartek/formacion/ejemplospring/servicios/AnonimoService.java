package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.entidades.Usuario;

public interface AnonimoService {
	Usuario verificarLogin(String email, String password);
	
	Iterable<Producto> listarProductos();
	Producto verDetalleProducto(Long id);
	
	Iterable<Producto> listarProductosCarrito();	
	void agregarProductoACarrito(Long idProducto);
	void agregarProductoACarrito(Producto producto);
	void quitarProductoDeCarrito(Long id);
}
