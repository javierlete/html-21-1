package com.ipartek.formacion.pruebas;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.ipartek.formacion.tienda.dtos.ProductoDTO;

public class ProductoDTOPruebas {
	public static void main(String[] args) {
		ProductoDTO dto = new ProductoDTO(1L, "Producto1", new BigDecimal("111"), LocalDate.now());
		ProductoDTO dto2 = new ProductoDTO(1L, "Producto1", new BigDecimal("111"), LocalDate.now());
		
		System.out.println(dto.nombre());
		
		System.out.println(dto == dto2);
		
		System.out.println(dto.equals(dto2));
		
		System.out.println(dto);
	}
}
