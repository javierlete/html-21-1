package com.ipartek.formacion.basico;

import java.math.BigInteger;

public class Recursividad {
	public static void main(String[] args) {
		System.out.println(sumar(5, 6));

		System.out.println(factorial(20));
		
		BigInteger f = factorial(new BigInteger("10000"));
		
		System.out.println(f);
		System.out.println(f.toString().length());
	}

	/*
	 * 4! = 4 * 3 * 2 * 1
	 * 
	 * 4! = 4 * 3! 3! = 3 * 2! 2! = 2 * 1! 1! = 1
	 */

	private static BigInteger factorial(BigInteger valor) {
		if (valor.compareTo(BigInteger.ONE) == 0) {
			return BigInteger.ONE;
		}
		
		return valor.multiply(factorial(valor.subtract(BigInteger.ONE)));
	}
	private static long factorial(long valor) {
		if (valor == 1) {
			return 1;
		}
		
		return valor * factorial(valor - 1);
	}

	private static int sumar(int a, int b) {
		return a + b;
	}
}
