package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;

import com.ipartek.formacion.tienda.accesodatos.FabricaDaoImpl;
import com.ipartek.formacion.tienda.modelos.Producto;

public class ProductoDaoPruebas {
	public static void main(String[] args) {
		var dao = new FabricaDaoImpl().getDaoProducto();
		
		dao.insertar(Producto.builder().nombre("Prueba1").precio(new BigDecimal("1234")).build());
		dao.insertar(Producto.builder().nombre("Prueba2").precio(new BigDecimal("2234")).build());
		dao.insertar(Producto.builder().nombre("Prueba3").precio(new BigDecimal("3234")).build());
		
		dao.modificar(Producto.builder().id(2L).nombre("MODIFICADO").precio(new BigDecimal("4321")).build());
		
		dao.borrar(1L);
		
		for(var p: dao.obtenerTodos()) {
			System.out.println(p);
		}
		
		System.out.println(dao.obtenerPorId(3L));
		
		for(var p: dao.buscarPorNombre("rue")) {
			System.out.println(p);
		}
		
		
	}
}
