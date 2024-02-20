package oop;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

public class EmpleadoIndefinido extends Empleado {
	private BigDecimal sueldoAnual;
	private int numeroPagas;
	
	public EmpleadoIndefinido(Long id, String nombre, String apellidos, LocalDate fechaNacimiento,
			BigDecimal sueldoAnual, int numeroPagas) {
		super(id, nombre, apellidos, fechaNacimiento);
		this.sueldoAnual = sueldoAnual;
		this.numeroPagas = numeroPagas;
	}
	
	public BigDecimal getSueldoAnual() {
		return sueldoAnual;
	}
	public void setSueldoAnual(BigDecimal sueldoAnual) {
		this.sueldoAnual = sueldoAnual;
	}
	public int getNumeroPagas() {
		return numeroPagas;
	}
	public void setNumeroPagas(int numeroPagas) {
		this.numeroPagas = numeroPagas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(numeroPagas, sueldoAnual);
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
		EmpleadoIndefinido other = (EmpleadoIndefinido) obj;
		return numeroPagas == other.numeroPagas && Objects.equals(sueldoAnual, other.sueldoAnual);
	}

	@Override
	public String toString() {
		return "EmpleadoIndefinido [sueldoAnual=" + sueldoAnual + ", numeroPagas=" + numeroPagas + "]";
	}

	@Override
	public BigDecimal getSueldoMensual() {
		return sueldoAnual.divide(new BigDecimal(numeroPagas), RoundingMode.HALF_UP);
	}
}
