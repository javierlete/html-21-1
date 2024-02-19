package oop;

import java.util.ArrayList;

public class Poligono {
	private ArrayList<Punto> puntos = new ArrayList<>();

	public ArrayList<Punto> getPuntos() {
		return puntos;
	}
	
	public void addPunto(Punto punto) {
		puntos.add(punto);
	}
}
