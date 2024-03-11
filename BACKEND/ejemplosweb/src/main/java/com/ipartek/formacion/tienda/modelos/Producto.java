package com.ipartek.formacion.tienda.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 4833961369800111940L;
	
	private Long id;
	private String nombre;
	private BigDecimal precio;
	private LocalDate fechaCaducidad;
}
