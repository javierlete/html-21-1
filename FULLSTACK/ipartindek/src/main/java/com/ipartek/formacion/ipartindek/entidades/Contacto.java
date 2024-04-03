package com.ipartek.formacion.ipartindek.entidades;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "contactos")
public class Contacto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
	@NotNull
	@Size(max=50)
	private String email;
	
	@NotNull
	@Size(max=100)
	private String password;
	
	@ManyToOne
	private Genero genero;
	
	@NotNull
	@Size(min = 3, max = 50)
	private String nombre;
	
	@NotNull
	@Pattern(regexp = "^\\d{9}$")
	private String telefono;
	
	@NotNull
	@Past
	private LocalDate fechaNacimiento;
	
	@Lob
	@Size(max = 5000)
	private String descripción;
	
	@ManyToMany
	private Set<Contacto> leGusta;
	
	@ManyToMany
	private Set<Contacto> peticionesDeMatch;
	
	@ManyToMany
	private Set<Contacto> matches;
}
