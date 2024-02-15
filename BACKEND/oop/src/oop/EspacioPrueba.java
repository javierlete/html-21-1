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
		e.getPersonas().add(new Empleado("Javier", "Lete", LocalDate.of(2000, 2, 3), new BigDecimal("23456.78")));
		
		System.out.println(e);
	}
}
