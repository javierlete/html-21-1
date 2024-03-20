package com.ipartek.formacion.ejemplospring.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
