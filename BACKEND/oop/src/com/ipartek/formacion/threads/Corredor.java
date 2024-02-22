package com.ipartek.formacion.threads;

import java.util.Random;

public class Corredor implements Runnable {
	private static final Random RANDOM = new Random();

	private String dorsal;
	private int posicion;
	
	private boolean correr;

	public Corredor(String dorsal) {
		this.dorsal = dorsal;
	}

	public String getDorsal() {
		return dorsal;
	}

	public void setDorsal(String dorsal) {
		this.dorsal = dorsal;
	}

	public int getPosicion() {
		return posicion;
	}

	public void setPosicion(int posicion) {
		this.posicion = posicion;
	}

	
	public void parar() {
		correr = false;
	}
	
	@Override
	public void run() {
		correr = true;
		
		for (posicion = 1; posicion < 10 & correr; posicion++) {
			try {
				Thread.sleep(RANDOM.nextLong(0, 1000));
			} catch (InterruptedException e) {
			}
		}
	}

	@Override
	public String toString() {
		return "Corredor [dorsal=" + dorsal + ", posicion=" + posicion + "]";
	}
}
