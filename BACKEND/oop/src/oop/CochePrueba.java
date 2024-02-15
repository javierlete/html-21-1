package oop;

import java.time.LocalDate;

public class CochePrueba {
	public static void main(String[] args) {
		Coche coche = new Coche(1L, "Citroen", "Xsara", 5, LocalDate.of(2000, 1, 2));
		
		System.out.println(coche);
		
		Coche coche2 = new Coche(coche);
		
		// coche2.setId(2L);
		
		System.out.println(coche);
		System.out.println(coche2);
		
		System.out.println(coche == coche2);
		System.out.println(coche.equals(coche2));
	}
}
