package com.ipartek.formacion.tienda.modelos;

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
@Table(name = "usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 50, nullable = false)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String password;
	
	@Column(length = 50, nullable = false)
	private String nombre;
	
	@Builder.Default
	@Column(length = 10, nullable = false)
	private String rol = "USER";
}
