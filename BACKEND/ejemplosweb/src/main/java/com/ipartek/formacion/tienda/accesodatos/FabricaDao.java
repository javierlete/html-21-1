package com.ipartek.formacion.tienda.accesodatos;

public interface FabricaDao {
	DaoProducto getDaoProducto();
	DaoUsuario getDaoUsuario();
	DaoRol getDaoRol();
}