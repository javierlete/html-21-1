package com.ipartek.formacion.ejemplospring.entidades;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//LOMBOK
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data

@Component
@SessionScope
public class Carrito {
	private Long id;
	private Usuario usuario;
	
	@Builder.Default
	private Set<Producto> productos = new HashSet<>();
}
