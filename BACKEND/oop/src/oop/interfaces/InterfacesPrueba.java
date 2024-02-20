package oop.interfaces;

import java.util.ArrayList;

public class InterfacesPrueba {
	public static void main(String[] args) {
		var esfericos = new ArrayList<Esferico>();
		
		esfericos.add(new Naranja());
		esfericos.add(new Balon());
		
		for(Esferico e: esfericos) {
			if(e instanceof Comestible c) {
				c.comer();
			}
			
			e.rodar();
			
			if(e instanceof Comestible c) {
				c.comer();
			}
		}
	}
}
