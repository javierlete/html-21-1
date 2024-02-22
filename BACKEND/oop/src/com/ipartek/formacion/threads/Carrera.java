package com.ipartek.formacion.threads;

public class Carrera {
	public static void main(String[] args) {
		Corredor c1 = new Corredor("UNO");
		Corredor c2 = new Corredor("DOS");

		Thread t1 = new Thread(c1);
		Thread t2 = new Thread(c2);

//		c1.run();
//		c2.run();

		t1.start();
		t2.start();

		boolean terminada = false;

		while (!terminada) {
			if (c1.getPosicion() == 10 || c2.getPosicion() == 10) {
				terminada = true;
				
				c1.parar();
				c2.parar();
			}
			
			System.out.printf("| %02d | %02d |\n", c1.getPosicion(), c2.getPosicion());

			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
			}
		}
	}
}
