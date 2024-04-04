package com.ipartek.formacion.ipartindek.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ipartek.formacion.ipartindek.entidades.Contacto;

import jakarta.transaction.Transactional;

@RepositoryRestResource(collectionResourceRel = "contactos", path = "contactos")
public interface ContactoRepository extends JpaRepository<Contacto, Long> {
	Contacto findByEmail(String email);
	
	@Query("select c.leGusta from Contacto c where c.id=:id")
	List<Contacto> listadoCompleto(@Param(value = "id") Long id);

	@Modifying
	@Query(value = "INSERT INTO contactos_le_gusta (contacto_id,le_gusta_id) VALUES (:id,:idLeGusta)", nativeQuery = true)
	@Transactional
	int leGusta(@Param("id") Long id, @Param("idLeGusta") Long idLeGusta);
	
	@Modifying
	@Query(value = "DELETE FROM contactos_le_gusta WHERE contacto_id=:id AND le_gusta_id=:idLeGusta", nativeQuery = true)
	@Transactional
	int noLeGusta(@Param("id") Long id, @Param("idLeGusta") Long idLeGusta);
	
	@Modifying
	@Query(value = "INSERT INTO contactos_matches (contacto_id,matches_id) VALUES (:id,:matchId)", nativeQuery = true)
	@Transactional	
	int matches(@Param("id") Long id, @Param("matchId") Long matchId);
	
	@Modifying
	@Query(value = "INSERT INTO contactos_peticiones_de_match (contacto_id,peticiones_de_match_id) VALUES (:id,:peticionId)", nativeQuery = true)
	@Transactional
	int peticionesDeMatch(@Param("id") Long id, @Param("peticionId") Long peticionId);
}
