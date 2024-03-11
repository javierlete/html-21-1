package com.ipartek.formacion.tienda.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProductoDTO(Long id, String nombre, BigDecimal precio, LocalDate fechaCaducidad) {
}
