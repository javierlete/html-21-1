package com.ipartek.formacion.tienda.accesodatos;

import com.ipartek.formacion.tienda.modelos.Rol;

import static com.ipartek.formacion.tienda.accesodatos.GlobalesAccesoDatos.*;

public class DaoRolJpa implements DaoRol {

	@Override
	public Rol insertar(Rol rol) {
		var em = EMF.createEntityManager();
		var t = em.getTransaction();
		t.begin();

		em.persist(rol);

		t.commit();
		em.close();

		return rol;
	}

}
