package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.modelos.Producto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class JpaPruebas {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("org.ipartek.formacion.tienda.modelos");
		EntityManager em = emf.createEntityManager();
		
		EntityTransaction t = em.getTransaction();
		
		t.begin();
		
		em.persist(Producto.builder().nombre("Producto1").precio(new BigDecimal("1234")).build());
		em.persist(Producto.builder().nombre("Producto2").precio(new BigDecimal("2234")).build());
		em.persist(Producto.builder().nombre("Producto3").precio(new BigDecimal("3234")).build());
		
		t.commit();
		
		t = em.getTransaction();
		
		t.begin();

		em.remove(em.find(Producto.class, 2L));
		
		t.commit();

		t = em.getTransaction();
		
		t.begin();
		
		em.merge(Producto.builder().id(1L).nombre("Modificado").precio(new BigDecimal("2234")).fechaCaducidad(LocalDate.now()).build());
		
		t.commit();
		
		t = em.getTransaction();
		
		t.begin();
		
		var productos = em.createQuery("from Producto", Producto.class).getResultList();
		
		for(var producto: productos) {
			System.out.println(producto);
		}
		
		t.commit();
		
		em.close();
		
		em = emf.createEntityManager();
		
		t = em.getTransaction();
		
		t.begin();
		
		var producto = em.find(Producto.class, 1L);
		
		System.out.println(producto);
		
		t.commit();
		
		em.close();
		
		em = emf.createEntityManager();
		
		t = em.getTransaction();
		
		t.begin();
		
		String nombre = "rodu";
		productos = em.createQuery("from Producto p where p.nombre like :nombre", Producto.class).setParameter("nombre", "%" + nombre + "%").getResultList();
		
		for(var p: productos) {
			System.out.println(p);
		}
		
		emf.close();
	}
}
