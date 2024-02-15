package oop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Empleado extends Persona {
	private BigDecimal sueldo;

	public Empleado(Long id, String nombre, String apellidos, LocalDate fechaNacimiento, BigDecimal sueldo) {
		super(id, nombre, apellidos, fechaNacimiento);
		setSueldo(sueldo);
	}
	
	public Empleado(Empleado empleado){
		this(empleado.getId(), empleado.getNombre(), empleado.getApellidos(), empleado.getFechaNacimiento(), empleado.getSueldo());
	}
	
	public Empleado(String nombre, String apellidos, LocalDate fechaNacimiento, BigDecimal sueldo) {
		this(null, nombre, apellidos, fechaNacimiento, sueldo);
	}
	
	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(sueldo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empleado other = (Empleado) obj;
		return Objects.equals(sueldo, other.sueldo);
	}

	@Override
	public String toString() {
		return "Empleado [id=" + getId() + ", nombre=" + getNombre()
				+ ", apellidos=" + getApellidos() + ", fechaNacimiento=" + getFechaNacimiento() + ", sueldo=" + sueldo + "]";
	}
}
