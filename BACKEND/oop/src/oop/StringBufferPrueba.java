package oop;

public class StringBufferPrueba {
	public static void main(String[] args) {
		StringBuffer log = new StringBuffer();
		
		log.append("Un texto\n");
		log.append("Otro texto\n");
		log.append(new Punto(5, 6)).append(" que mola mucho\n");
		
		System.out.println(log);
	}
	
	public static void mainTraducido(String[] args) {
		String log = "";
		
		log = new StringBuffer(log).append("Un texto\n").toString();
		log = new StringBuffer(log).append("Otro texto\n").toString();
		log = new StringBuffer(log).append(new Punto(5, 6)).append(" que mola mucho\n").toString();
		
		System.out.println(log);
	}
	
	public static void mainConcatenaciones(String[] args) {
		String log = "";
		
		log += "Un texto\n";
		log += "Otro texto\n";
		log += new Punto(5, 6) + " que mola mucho\n";
		
		System.out.println(log);
	}
}
