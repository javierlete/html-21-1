package com.ipartek.formacion.ejemplospring.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ejemplospring.entidades.Producto;
import com.ipartek.formacion.ejemplospring.servicios.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService servicio;
	
	@GetMapping
	public String index(Model modelo) {
		var productos = servicio.listarProductos();
		
		modelo.addAttribute("productos", productos);
		
		return "admin/listado";
	}
	
	@GetMapping("/formulario")
	public String formulario(Producto producto) {
		return "admin/formulario";
	}
	
	@GetMapping("/formulario/{id}")
	public String formularioConProducto(@PathVariable Long id, Model modelo) {
		var producto = servicio.verDetalleProducto(id);
		
		modelo.addAttribute("producto", producto);
		
		return "admin/formulario";
	}
	
	@PostMapping("/formulario")
	public String formularioPost(Producto producto) {
		
		if(producto.getId() == null) {
			servicio.agregarProducto(producto);
		} else {
			servicio.modificarProducto(producto);
		}
		
		return "redirect:/admin";
	}
}
