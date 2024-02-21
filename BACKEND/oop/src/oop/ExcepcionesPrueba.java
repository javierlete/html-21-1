package oop;

public class ExcepcionesPrueba {

	public static void main(String[] args) {
		int div, a = 6, b = 2;

		try {
			var arr = new int[2];
			
			arr[2] = 5;
			
			@SuppressWarnings("unused")
			String s = null;

			// System.out.println(s.toUpperCase());

			div = a / b;

			System.out.println(div);
		} catch (ArithmeticException e) {
			System.out.println("Error en la división");
		} catch(NullPointerException e) {
			System.out.println("Error de null");
		} finally {
			System.out.println("Por mis narices");
		}

		System.out.println("FIN");
	}

}
