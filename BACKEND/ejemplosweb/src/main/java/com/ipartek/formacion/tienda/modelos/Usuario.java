package com.ipartek.formacion.tienda.modelos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Usuario {
	private Long id;
	private String email;
	private String password;
	private String nombre;
	private String rol;
}
