package com.ipartek.formacion.tienda.accesodatos;

import com.ipartek.formacion.tienda.modelos.Producto;

public interface DaoProducto extends Dao<Producto> {
	Iterable<Producto> buscarPorNombre(String nombre);
}
