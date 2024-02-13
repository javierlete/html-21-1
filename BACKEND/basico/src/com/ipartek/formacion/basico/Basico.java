package com.ipartek.formacion.basico;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Clase de demostración de características básicas de Java
 * 
 * @author Javier Lete
 */
public class Basico {
	/*
	 * Método que se utiliza como punto de entrada para la JVM DEBE llamarse main y
	 * DEBE tener como argumento String[] args se puede cambiar por otro nombre
	 */
	public static void main(String[] args) {
		var enteros = new int[] { 1, 2, 3, 4, 5 };

		for (int i = 0; i < enteros.length; i++) {
			int dato = enteros[i];
			System.out.println(dato);
		}

		int i = 0;
		while (i < enteros.length) {
			int dato = enteros[i];
			System.out.println(dato);
			i++;
		}

		for (int dato : enteros) {
			System.out.println(dato);
		}

		var textos = new ArrayList<String>();

		textos.add("Un texto");
		textos.add("Otro texto");

		for (String texto : textos) {
			System.out.println(texto);
		}

		var iterator = textos.iterator();

		while (iterator.hasNext()) {
			String dato = iterator.next();
			System.out.println(dato);
		}
	}

	public static void mainOperadores(String[] args) {
		int x = -5;

		System.out.println(1 + x + 10);

		var inicio = LocalDateTime.now();
		System.out.println(1 <= x && x <= 10);
		var fin = LocalDateTime.now();

		var duracion = Duration.between(inicio, fin);

		System.out.println(duracion);
	}

	public static void mainLecturaConsola(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Dime un texto: ");

		String linea = sc.nextLine();

		System.out.println("Linea introducida: " + linea);

		sc.close();
	}

	@SuppressWarnings("unused")
	public static void mainConversiones(String[] args) {
		String s = "5";

		int i = Integer.parseInt(s);

		String convertido = String.valueOf(i);

		double d = Double.parseDouble("5.6");

		LocalDate ld = LocalDate.parse("2024-02-13");

		System.out.println(ld);
	}

	public static void mainTipos(String[] args) {
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

		var ld = LocalDate.of(2024, 2, 13);

		System.out.println(ld);

		var lt = LocalTime.of(15, 23);

		System.out.println(lt);

		var ldt = LocalDateTime.of(2024, 2, 13, 15, 24);

		System.out.println(ldt);

		var arr = new int[5];

		arr[0] = 5;
//		arr[3] = "alkdsjflkas";
//		arr[5] = 9;

		System.out.println(arr[0]);
		System.out.println(arr);
		System.out.println(Arrays.toString(arr));

		var textos = new String[3];

		textos[0] = "Uno";
		textos[1] = "Dos";
		textos[2] = "Tres";

		System.out.println(Arrays.toString(textos));

		var al = new ArrayList<String>();

		al.add("Un texto");
		al.add("Otro texto");
		al.add("Uno más");

		al.set(2, "Otro más");

		al.remove("Otro texto");

		System.out.println(al);
		System.out.println(al.get(1));

		var dic = new HashMap<String, Integer>();

		dic.put("Uno", 1);
		dic.put("Dos", 2);
		dic.put("Tres", 3);

		System.out.println(dic);
		System.out.println(dic.get("Dos"));
	}
}
