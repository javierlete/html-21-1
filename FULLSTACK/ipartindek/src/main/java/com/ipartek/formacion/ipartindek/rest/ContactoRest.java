package com.ipartek.formacion.ipartindek.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ipartek.formacion.ipartindek.entidades.Contacto;
import com.ipartek.formacion.ipartindek.repositorios.ContactoRepository;

@RestController
@RequestMapping("/api/contactos/search")
public class ContactoRest {
	@Autowired
	private ContactoRepository repo;
	
	@GetMapping("/congenero")
	public List<Contacto> get() {
		return repo.findAll();
	}
}
