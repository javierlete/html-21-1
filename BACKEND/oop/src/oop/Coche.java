package oop;

import java.time.LocalDate;
import java.util.Objects;

public class Coche {
	private Long id;
	private String marca;
	private String modelo;
	private Integer puertas;
	private LocalDate fechaFabricacion;

	// Source/Generate Constructor using Fields...
	public Coche(Long id, String marca, String modelo, Integer puertas, LocalDate fechaFabricacion) {
		setId(id);
		setMarca(marca);
		setModelo(modelo);
		setPuertas(puertas);
		setFechaFabricacion(fechaFabricacion);
	}
	
	// Constructor de copia
	public Coche(Coche coche) {
		this(coche.getId(), coche.getMarca(), coche.getModelo(), coche.getPuertas(), coche.getFechaFabricacion());
	}

	// Source/Generate Getters & Setters...
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getPuertas() {
		return puertas;
	}

	public void setPuertas(Integer puertas) {
		this.puertas = puertas;
	}

	public LocalDate getFechaFabricacion() {
		return fechaFabricacion;
	}

	public void setFechaFabricacion(LocalDate fechaFabricacion) {
		this.fechaFabricacion = fechaFabricacion;
	}

	// Generate hashCode & equals...
	@Override
	public int hashCode() {
		return Objects.hash(fechaFabricacion, id, marca, modelo, puertas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		return Objects.equals(fechaFabricacion, other.fechaFabricacion) && Objects.equals(id, other.id)
				&& Objects.equals(marca, other.marca) && Objects.equals(modelo, other.modelo)
				&& Objects.equals(puertas, other.puertas);
	}

	// Generate toString...
	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", puertas=" + puertas
				+ ", fechaFabricacion=" + fechaFabricacion + "]";
	}
}
