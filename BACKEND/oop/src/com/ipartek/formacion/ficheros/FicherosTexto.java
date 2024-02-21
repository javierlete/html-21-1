package com.ipartek.formacion.ficheros;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class FicherosTexto {

	private static final boolean AGREGAR_AL_FINAL = true;

	public static void main(String[] args) throws IOException {
		File carpeta = new File("ficheros");
		carpeta.mkdir();
		
		File ficheroTexto = new File(carpeta, "fichero.txt");
		
		FileWriter fw = new FileWriter(ficheroTexto, AGREGAR_AL_FINAL);
		PrintWriter pw = new PrintWriter(fw, true);
		
		pw.printf("%s: ejecución del programa\n", LocalDateTime.now());
		
		pw.close();
		fw.close();
		
		FileReader fr = new FileReader(ficheroTexto);
		Scanner sc = new Scanner(fr);
		
		while(sc.hasNext()) {
			System.out.println(sc.nextLine());
		}
		
		sc.close();
		fr.close();
	}
}
