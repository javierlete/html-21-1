package oop;

import java.math.BigDecimal;
import java.time.LocalDate;

public abstract class Empleado extends Persona {
	public Empleado(Long id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super(id, nombre, apellidos, fechaNacimiento);
	}
	
	public Empleado(Empleado empleado){
		this(empleado.getId(), empleado.getNombre(), empleado.getApellidos(), empleado.getFechaNacimiento());
	}
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(null, nombre, apellidos, fechaNacimiento);
	}
	
	public abstract BigDecimal getSueldoMensual();
}
