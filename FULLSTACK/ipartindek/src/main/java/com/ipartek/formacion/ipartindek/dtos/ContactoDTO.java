package com.ipartek.formacion.ipartindek.dtos;

import java.time.LocalDate;

public record ContactoDTO(Long id, String email, String password, String genero, String nombre, String telefono,
		LocalDate fechaNacimiento, String descripcion) {
}
