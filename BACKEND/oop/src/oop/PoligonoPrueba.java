package oop;

public class PoligonoPrueba {
	public static void main(String[] args) {
		Poligono poligono = new Poligono();
		
		poligono.addPunto(new Punto(1, 2));
		poligono.addPunto(new Punto(3, 4));
		poligono.addPunto(new PuntoNombre(5, 6, "Prueba"));
		
		for(Punto p: poligono.getPuntos()) {
			System.out.println(p);
		}
	}
}
