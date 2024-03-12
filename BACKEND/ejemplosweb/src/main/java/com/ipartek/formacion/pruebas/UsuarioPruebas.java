package com.ipartek.formacion.pruebas;

import com.ipartek.formacion.tienda.modelos.Rol;
import com.ipartek.formacion.tienda.modelos.Usuario;

public class UsuarioPruebas {
	public static void main(String[] args) {
		Usuario u = new Usuario();
		Usuario u1 = new Usuario(1L, "javier@email.net", "contra", "Javier Lete", Rol.builder().id(1L).nombre("ADMIN").build());
		Usuario u2 = Usuario.builder().id(1L).nombre("Javier Lete").rol(Rol.builder().id(1L).nombre("ADMIN").build()).email("javier@email.net").password("contra")
				.build();
		
		System.out.println(u);
		System.out.println(u1);
		System.out.println(u2);
		
		System.out.println(u1.equals(u2));
		
		System.out.println(u1.getNombre());
	}
}
