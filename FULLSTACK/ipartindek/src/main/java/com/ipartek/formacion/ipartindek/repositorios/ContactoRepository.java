package com.ipartek.formacion.ipartindek.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ipartindek.entidades.Contacto;

@RepositoryRestResource(collectionResourceRel = "contactos", path = "contactos")
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
	Contacto findByEmail(String email);
}
