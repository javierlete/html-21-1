package oop;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class EmpleadoPorHoras extends Empleado {
	private BigDecimal sueldoPorHora;
	private int numeroHorasMensuales;

	public EmpleadoPorHoras(Long id, String nombre, String apellidos, LocalDate fechaNacimiento,
			BigDecimal sueldoPorHora, int numeroHorasMensuales) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.sueldoPorHora = sueldoPorHora;
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	public BigDecimal getSueldoPorHora() {
		return sueldoPorHora;
	}

	public void setSueldoPorHora(BigDecimal sueldoPorHora) {
		this.sueldoPorHora = sueldoPorHora;
	}

	public int getNumeroHorasMensuales() {
		return numeroHorasMensuales;
	}

	public void setNumeroHorasMensuales(int numeroHorasMensuales) {
		this.numeroHorasMensuales = numeroHorasMensuales;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroHorasMensuales, sueldoPorHora);
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
		EmpleadoPorHoras other = (EmpleadoPorHoras) obj;
		return numeroHorasMensuales == other.numeroHorasMensuales && Objects.equals(sueldoPorHora, other.sueldoPorHora);
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras [sueldoPorHora=" + sueldoPorHora + ", numeroHorasMensuales=" + numeroHorasMensuales
				+ "]";
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoPorHora.multiply(new BigDecimal(numeroHorasMensuales));
	}
}
