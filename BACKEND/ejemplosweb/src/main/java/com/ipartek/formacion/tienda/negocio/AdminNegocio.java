package com.ipartek.formacion.tienda.negocio;

import com.ipartek.formacion.tienda.modelos.Producto;

public interface AdminNegocio extends AnonimoNegocio {
	Producto agregarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
}
