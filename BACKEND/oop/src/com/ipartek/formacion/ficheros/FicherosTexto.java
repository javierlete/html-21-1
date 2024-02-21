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

	public static void main(String[] args) {
		File carpeta = new File("ficheros");
		carpeta.mkdir();
		
		File ficheroTexto = new File(carpeta, "fichero.txt");
		
		FileWriter fw = null;
		PrintWriter pw = null;
		
		try {
			fw = new FileWriter(ficheroTexto, AGREGAR_AL_FINAL);
			pw = new PrintWriter(fw, true);
			
			pw.printf("%s: ejecución del programa\n", LocalDateTime.now());
		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero");
		} finally {
			if(pw != null) {
				pw.close();
			}
			
			if(fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					System.out.println("Ha fallado el cierre de fichero");
				}
			}
		}
		
		try (FileReader fr = new FileReader(ficheroTexto);
				Scanner sc = new Scanner(fr)) {
			while(sc.hasNext()) {
				System.out.println(sc.nextLine());
			}
		} catch (IOException e) {
			System.out.println("Ha habido un error al leer el fichero");
		}
	}
}
