package oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmpleadoPrueba {
	public static void main(String[] args) {
		Empleado e = new EmpleadoIndefinido(1L, "Pepe", "Pérez", LocalDate.of(2000, 1, 2), new BigDecimal("12345.67"), 12);

		System.out.println(e);

		Empleado e2 = new EmpleadoPorHoras(2L, "Javier", "Lete", LocalDate.of(2000, 1, 2), new BigDecimal("12.67"), 60);

		System.out.println(e2);

		System.out.println(e == e2);
		System.out.println(e.equals(e2));

		Persona p = e;

		// System.out.println(p.getSueldo());

		// Java >=16
		if (p instanceof Empleado e3) {
			//Empleado e3 = (Empleado) p;

			System.out.println(e.getSueldoMensual());
		} else {
			System.out.println("NO ES UN EMPLEADO");
		}
		
		Persona p2 = new Persona();

		// Java <16
		if (p2 instanceof Empleado) {
			Empleado e4 = (Empleado) p2;

			System.out.println(e4.getSueldoMensual());
		} else {
			System.out.println("NO ES UN EMPLEADO");
		}
	}
}
