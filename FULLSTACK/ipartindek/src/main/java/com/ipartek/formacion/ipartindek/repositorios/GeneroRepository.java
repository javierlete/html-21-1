package com.ipartek.formacion.ipartindek.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ipartindek.entidades.Genero;

@RepositoryRestResource(collectionResourceRel = "generos", path = "generos")
public interface GeneroRepository extends JpaRepository<Genero, Long>{

}
