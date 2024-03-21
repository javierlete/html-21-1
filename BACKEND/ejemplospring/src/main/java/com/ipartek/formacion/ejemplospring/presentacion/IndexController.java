package com.ipartek.formacion.ejemplospring.presentacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ipartek.formacion.ejemplospring.servicios.AnonimoService;

@Controller
@RequestMapping("/")
public class IndexController {
	
	@Autowired
	private AnonimoService anonimoService;
	
	@GetMapping
	public String index(Model modelo) {
		var productos = anonimoService.listarProductos();
		
		modelo.addAttribute("productos", productos);
		
		return "index";
	}
	
	@GetMapping("/carrito")
	public String carrito(Long id, Model modelo) {
		var producto = anonimoService.verDetalleProducto(id);
		
		modelo.addAttribute("producto", producto);
		
		return "carrito";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
