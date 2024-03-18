package com.ipartek.formacion.ejemplospring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ipartek.formacion.ejemplospring.servicios.AdminService;

@SpringBootApplication
public class EjemplospringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}

//	@Autowired
//	private ProductoRepository productoRepository;
	
	@Autowired
	private AdminService adminService;
	
	@Override
	public void run(String... args) throws Exception {
//		adminService.agregarProducto(Producto.builder().nombre("Producto4").precio(new BigDecimal("4234.5")).build());
//		adminService.agregarProducto(Producto.builder().nombre("Producto5").precio(new BigDecimal("5234.5")).build());
		
		for(var producto: adminService.listarProductos()) {
			System.out.println(producto);
		}
		
//		productoRepository.save(Producto.builder().nombre("Producto1").precio(new BigDecimal("1234")).build());
//		productoRepository.save(Producto.builder().nombre("Producto2").precio(new BigDecimal("2234")).build());
//		productoRepository.save(Producto.builder().nombre("Producto3").precio(new BigDecimal("3234")).build());
		
//		for(var producto: productoRepository.findAll()) {
//			System.out.println(producto);
//		}
//		
//		System.out.println(productoRepository.findByNombreContains("ucto2"));
	}

}
