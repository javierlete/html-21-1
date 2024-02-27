package com.ipartek.formacion.bibliotecas;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Consola {
	private static final Scanner SC = new Scanner(System.in);
	
	public static void p(Object o) {
		System.out.print(o);
	}
	
	public static void pl() {
		System.out.println();
	}
	
	public static void pl(Object o) {
		System.out.println(o);
	}
	
	public static String leerString(String mensaje) {
		p(mensaje + ": ");
		
		return SC.nextLine();
	}
	
	public static int leerInt(String mensaje) {
		String texto;
		int dato = 0;
		
		boolean hayError = true;
		
		do {
			try {
				texto = leerString(mensaje);
				dato = Integer.parseInt(texto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("El formato de número es incorrecto");
			} 
		} while (hayError);
		
		return dato;
	}
	
	public static long leerLong(String mensaje) {
		String texto;
		long dato = 0;
		
		boolean hayError = true;
		
		do {
			try {
				texto = leerString(mensaje);
				dato = Long.parseLong(texto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("El formato de número es incorrecto");
			} 
		} while (hayError);
		
		return dato;
	}
	
	public static BigDecimal leerDecimal(String mensaje) {
		String texto;
		BigDecimal dato = null;
		
		boolean hayError = true;
		
		do {
			try {
				texto = leerString(mensaje);
				dato = new BigDecimal(texto);
				hayError = false;
			} catch (NumberFormatException e) {
				pl("El formato de número es incorrecto");
			} 
		} while (hayError);
		
		return dato;
	}
	
	public static LocalDate leerFecha(String mensaje) {
		String texto;
		LocalDate dato = null;
		
		boolean hayError = true;
		
		do {
			try {
				texto = leerString(mensaje + " [AAAA-MM-DD]");
				dato = LocalDate.parse(texto);
				hayError = false;
			} catch (DateTimeParseException e) {
				pl("El formato de fecha es incorrecto");
			} 
		} while (hayError);
		
		return dato;
	}
}
