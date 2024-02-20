package oop.interfaces;

public class Naranja extends Fruto implements Esferico, Comestible {

	private boolean porElSuelo = false;
	
	@Override
	public void comer() {
		if(porElSuelo) {
			System.out.println("Puag, que asco...");
		} else {
			System.out.println("Ñam que rica");
		}
	}

	@Override
	public void rodar() {
		porElSuelo = true;
		
		System.out.println("Naranja rodando");
	}

}
