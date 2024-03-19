package com.ipartek.formacion.ejemplospring.repositorios;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ejemplospring.entidades.Rol;

@RepositoryRestResource(path = "roles", collectionResourceRel = "roles")
public interface RolRepository extends CrudRepository<Rol, Long> {

}
