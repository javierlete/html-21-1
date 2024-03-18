package com.ipartek.formacion.ejemplospring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoRest {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping
	public Iterable<Producto> get() {
		return adminService.listarProductos();
	}
	
	@GetMapping("{id}")
	public Producto getId(@PathVariable Long id) {
		var producto = adminService.verDetalleProducto(id);
		
		if(producto == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
		return producto;
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public Producto post(@RequestBody Producto producto) {
		return adminService.agregarProducto(producto);
	}
	
	@PutMapping("{id}")
	public Producto put(@PathVariable Long id, @RequestBody Producto producto) {
		producto.setId(id);
		
		return adminService.modificarProducto(producto);
	}
	
	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		adminService.borrarProducto(id);
	}
}
