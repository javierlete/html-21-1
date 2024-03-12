package com.ipartek.formacion.tienda.modelos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// LOMBOK
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

// JPA
@Entity
@Table(name = "productos")
public class Producto implements Serializable {
	
	private static final long serialVersionUID = 4833961369800111940L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Column(nullable = false)
	private BigDecimal precio;
	
	@Column(name = "fecha_caducidad")
	private LocalDate fechaCaducidad;
}
