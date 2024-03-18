package com.ipartek.formacion.ejemplospring.servicios;

import com.ipartek.formacion.ejemplospring.entidades.Producto;

public interface AdminService extends AnonimoService {
	Producto agregarProducto(Producto producto);
	Producto modificarProducto(Producto producto);
	void borrarProducto(Long id);
}
