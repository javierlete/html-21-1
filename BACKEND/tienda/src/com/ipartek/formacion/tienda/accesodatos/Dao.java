package com.ipartek.formacion.tienda.accesodatos;

// CRUD: Create, Read, Update, Delete
// Data Access Object
public interface Dao<T> {
	Iterable<T> obtenerTodos();
	T obtenerPorId(Long id);
	
	T insertar(T objeto);
	T modificar(T objeto);
	void borrar(Long id);
}
