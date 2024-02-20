package oop;

import java.util.Objects;

public class Fraccion extends Number {

	private static final long serialVersionUID = 1L;

	private double numerador;
	private double denominador;
	
	public Fraccion(double numerador, double denominador) {
		super();
		this.numerador = numerador;
		this.denominador = denominador;
	}
	
	public double getNumerador() {
		return numerador;
	}
	public void setNumerador(double numerador) {
		this.numerador = numerador;
	}
	public double getDenominador() {
		return denominador;
	}
	public void setDenominador(double denominador) {
		this.denominador = denominador;
	}

	@Override
	public int hashCode() {
		return Objects.hash(denominador, numerador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fraccion other = (Fraccion) obj;
		return Double.doubleToLongBits(denominador) == Double.doubleToLongBits(other.denominador)
				&& Double.doubleToLongBits(numerador) == Double.doubleToLongBits(other.numerador);
	}

	@Override
	public String toString() {
		return "Fraccion [numerador=" + numerador + ", denominador=" + denominador + "]";
	}

	@Override
	public int intValue() {
		return (int)(numerador / denominador);
	}

	@Override
	public long longValue() {
		return (long)(numerador / denominador);
	}

	@Override
	public float floatValue() {
		return (float)(numerador / denominador);
	}

	@Override
	public double doubleValue() {
		return numerador / denominador;
	}
}
