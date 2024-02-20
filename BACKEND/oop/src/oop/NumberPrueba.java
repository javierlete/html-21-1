package oop;

import java.math.BigDecimal;

public class NumberPrueba {
	@SuppressWarnings("removal")
	public static void main(String[] args) {
		Number[] arr = new Number[4];
		
		arr[0] = Integer.valueOf(5);
		arr[1] = new Double(6.7);
		arr[2] = new BigDecimal(1234);
		arr[3] = new Fraccion(5, 3);
		
		for(Number n: arr) {
			System.out.println(n.doubleValue());
		}
	}
}
