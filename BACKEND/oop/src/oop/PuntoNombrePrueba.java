package oop;

public class PuntoNombrePrueba {
	public static void main(String[] args) {
		PuntoNombre ptn = new PuntoNombre(1, 2, "Prueba");
		
		System.out.println(ptn);
		
		Punto p = ptn;
		
		System.out.println(p.getClass());
		
		Object o = new Object();
		
		System.out.println(o);
	}
}
