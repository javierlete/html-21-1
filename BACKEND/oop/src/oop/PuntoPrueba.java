package oop;

public class PuntoPrueba {

	public static void main(String[] args) {
		Punto p = new Punto(5, 7);
		Punto p2 = new Punto(6, 8);
		
		System.out.println(p);
		System.out.println(p2);
		
		System.out.println(p.getX());
		System.out.println(p.getY());
		
		System.out.println(p2.distancia(p));
		
		System.out.println(Punto.distancia(p, p2));
	}
}
