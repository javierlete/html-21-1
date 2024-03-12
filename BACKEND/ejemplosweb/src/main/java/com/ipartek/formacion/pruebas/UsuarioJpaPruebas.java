package com.ipartek.formacion.pruebas;

import com.ipartek.formacion.tienda.modelos.Rol;
import com.ipartek.formacion.tienda.modelos.Usuario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UsuarioJpaPruebas {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.ipartek.formacion.tienda.modelos");
		EntityManager em = emf.createEntityManager();

		EntityTransaction t = em.getTransaction();

		t.begin();

		var admin = Rol.builder().nombre("ADMIN").build();
		em.persist(admin);
		
		var user = Rol.builder().nombre("USER").build();
		em.persist(user);
		
		t.commit();

		t = em.getTransaction();
		t.begin();

		var javier = Usuario.builder().nombre("Javier Lete").email("javier@email.net").password("contra").rol(admin).build();
		em.persist(javier);
		
		var pepe = Usuario.builder().nombre("Pepe Pérez").email("pepe@email.net").password("perez").rol(user).build();
		em.persist(pepe);

		var juan = Usuario.builder().nombre("Juan González").email("juan@email.net").password("gonzalez").rol(user).build();
		em.persist(juan);
		
		t.commit();

		t = em.getTransaction();
		t.begin();

		for(var r: em.createQuery("from Rol", Rol.class).getResultList()) {
			System.out.println(r);
		}
		
		t.commit();
		
		em.close();
		
		em = emf.createEntityManager();
		t = em.getTransaction();
		t.begin();
		
		for(var u: em.createQuery("from Usuario u join fetch u.rol", Usuario.class).getResultList()) {
			System.out.println(u.getNombre());
			System.out.println(u.getRol().getNombre());
		}
		
		t.commit();

		em.close();
		emf.close();
	}
}
