package oop;

public class EspacioPrueba {
	public static void main(String[] args) {
		Espacio e = new Espacio("Bilbao");
		
		e.setEncargada(new Persona("El Jefe"));
		
		e.getPersonas().add(new Persona("Javier"));
		e.getPersonas().add(new Persona("Pepe"));
		e.getPersonas().add(new Persona("Juan"));
		
		System.out.println(e);
	}
}
