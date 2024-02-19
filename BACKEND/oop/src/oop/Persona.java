package oop;

import java.time.LocalDate;
import java.util.Objects;

public class Persona {
	private static final String NOMBRE_POR_DEFECTO = "Anónimo";
	
	// Variables de instancia
	private Long id;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;

	// Constructores
	public Persona(Long id, String nombre, String apellidos, LocalDate fechaNacimiento) {
		setId(id);
		setNombre(nombre);
		setApellidos(apellidos);
		setFechaNacimiento(fechaNacimiento);
	}
	
	public Persona(Persona persona) {
		// Constructor de copia
		this(persona.getId(), persona.getNombre(), persona.getApellidos(), persona.getFechaNacimiento());
	}

	public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
		this(null, nombre, apellidos, fechaNacimiento);
	}
	
	public Persona(String nombre, String apellidos) {
		this(null, nombre, apellidos, null);
	}
	
	public Persona(String nombre, LocalDate fechaNacimiento) {
		this(null, nombre, null, fechaNacimiento);
	}
	
	public Persona(String nombre) {
		this(null, nombre, null, null);
	}
	
	public Persona() {
		this(null, NOMBRE_POR_DEFECTO, null, null);
	}

	// Getters y setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		if(id != null && id < 0) {
			throw new RuntimeException("No se admiten ids negativos");
		}
		
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre == null) {
			throw new RuntimeException("No se admiten nombres con valor null");
		}

		if (nombre.trim().equals("")) {
			throw new RuntimeException("No se admite un nombre sin rellenar");
		}

		this.nombre = nombre.trim();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		if (apellidos != null && apellidos.trim().length() == 0) {
			throw new RuntimeException("No se admiten apellidos vacíos");
		}

		this.apellidos = apellidos == null ? null : apellidos.trim();
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		if (fechaNacimiento != null && fechaNacimiento.isAfter(LocalDate.now())) {
			throw new RuntimeException("No se admiten nacimientos en el futuro");
		}

		this.fechaNacimiento = fechaNacimiento;
	}

	// hashCode y equals
	@Override
	public int hashCode() {
		return Objects.hash(apellidos, fechaNacimiento, id, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(apellidos, other.apellidos) && Objects.equals(fechaNacimiento, other.fechaNacimiento)
				&& Objects.equals(id, other.id) && Objects.equals(nombre, other.nombre);
	}

	// toString
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNacimiento="
				+ fechaNacimiento + "]";
	}
	
	// Métodos de instancia
	public String getNombreCompleto() {
		return nombre + " " + apellidos;
	}
}
