package oop;

import java.time.LocalDate;

public class PersonaPrueba {
	public static void main(String[] args) {
		Persona p;
		p = new Persona();
		
		p.setId(5L);
		p.setNombre("   	dfghcwertwv wgwdrg ewr 		  ");
		p.setApellidos("    jlaksjdfdklasd	");
		p.setFechaNacimiento(LocalDate.of(2024, 2, 14));
		
		System.out.println(p);
		
//		System.out.println(p.getId());
//		System.out.println(p.getNombre());
//		System.out.println(p.getApellidos());
//		System.out.println(p.getFechaNacimiento());
		
		p = new Persona(1L, "Javier", "Lete", LocalDate.of(2000, 2, 3));
		
		System.out.println(p);
		
		p = new Persona(1L, "   Pepe  ", "		Pérez	", LocalDate.of(2000, 1, 1));

		System.out.println(p);
		
		System.out.println(p.getNombreCompleto());
		
		Persona p2 = new Persona(p); //p;
		
		// p2.setId(2L);
		
		System.out.println(p2);
		System.out.println(p);
		
		System.out.println(p == p2);
		System.out.println(p.equals(p2));
	}
}
