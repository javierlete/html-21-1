package oop;

import java.util.ArrayList;
import java.util.Objects;

public class Espacio {
	private Long id;
	private String nombre;
	private Persona encargada;
	
	private ArrayList<Persona> personas = new ArrayList<>();

	public Espacio(Long id, String nombre) {
		setId(id);
		setNombre(nombre);
	}

	public Espacio(String nombre) {
		this(null, nombre);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Persona getEncargada() {
		return encargada;
	}

	public void setEncargada(Persona encargada) {
		this.encargada = encargada;
	}

	public ArrayList<Persona> getPersonas() {
		return personas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(encargada, id, nombre, personas);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Espacio other = (Espacio) obj;
		return Objects.equals(encargada, other.encargada) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(personas, other.personas);
	}

	@Override
	public String toString() {
		return "Espacio [id=" + id + ", nombre=" + nombre + ", encargada=" + encargada + ", personas=" + personas + "]";
	}
}
