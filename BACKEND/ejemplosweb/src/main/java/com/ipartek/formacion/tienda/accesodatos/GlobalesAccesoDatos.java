package com.ipartek.formacion.tienda.accesodatos;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class GlobalesAccesoDatos {
	static final EntityManagerFactory EMF = Persistence
			.createEntityManagerFactory("com.ipartek.formacion.tienda.modelos");
}
