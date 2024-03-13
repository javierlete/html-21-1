package com.ipartek.formacion.tienda.accesodatos;

// CRUD: Create, Read, Update, Delete
// Data Access Object
public interface Dao<T> {
	default Iterable<T> obtenerTodos() {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T obtenerPorId(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T insertar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default T modificar(T objeto) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}

	default void borrar(Long id) {
		throw new AccesoDatosException("NO IMPLEMENTADO");
	}
}
