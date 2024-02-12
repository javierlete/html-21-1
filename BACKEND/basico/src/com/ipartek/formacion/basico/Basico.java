package com.ipartek.formacion.basico;

import java.math.BigDecimal;

/**
 * Clase de demostración de características básicas de Java
 * 
 * @author Javier Lete
 */
public class Basico {
	/*
	 * Método que se utiliza como punto de entrada para la JVM
	 * DEBE llamarse main y DEBE tener como argumento String[]
	 * args se puede cambiar por otro nombre
	 */
	public static void main(String[] args) {
		System.out.println("Hola a todos"); // Muestra texto por consola
		System.out.println("Qué tal");
		
		float f1 = 0.4F, f2 = 0.3F, tf;
		tf = f1 + f2;
		
		System.out.println(tf * 1000000);
		
		double d1 = 0.43, d2 = 0.32, td;
		td = d1 + d2;
		
		System.out.println(td);
		
		var precio = new BigDecimal("2.75");
		
		System.out.println(precio);
		
		var arr = new int[5];
		
		arr[0] = 5;
//		arr[3] = "alkdsjflkas";
//		arr[5] = 9;
		
	}
}
