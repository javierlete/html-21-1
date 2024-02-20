package oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EspacioPrueba {
	public static void main(String[] args) {
		Espacio e = new Espacio("Bilbao");
		
		e.setEncargada(new Persona("El Jefe"));
		
		e.getPersonas().add(new Persona("Javier"));
		e.getPersonas().add(new Persona("Pepe"));
		e.getPersonas().add(new Persona("Juan"));
		e.getPersonas().add(new EmpleadoIndefinido(1L, "Pepe", "Pérez", LocalDate.of(2000, 1, 2), new BigDecimal("12345.67"), 12));
		e.getPersonas().add(new EmpleadoPorHoras(2L, "Javier", "Lete", LocalDate.of(2000, 1, 2), new BigDecimal("12.67"), 60));
		
		System.out.println(e);
		
		for(Persona p: e.getPersonas()) {
			System.out.println(p);
			
			if(p instanceof Empleado empleado) {
				System.out.println(empleado.getSueldoMensual());
			}
		}
	}
}
