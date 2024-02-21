package com.ipartek.formacion.flujos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;

import oop.Coche;

public class SerializacionObjetos {
	public static void main(String[] args) {
		var coches = new ArrayList<Coche>();

		coches.add(new Coche(1L, "Citroen", "Xsara", 5, LocalDate.now()));
		coches.add(new Coche(2L, "Opel", "Zafira", 5, LocalDate.now()));
		coches.add(new Coche(3L, "Renault", "Megane", 5, LocalDate.now()));
		coches.add(new Coche(4L, "Ferrari", "Testarrosa", 5, LocalDate.now()));

		try (FileOutputStream fos = new FileOutputStream("ficheros/coches.dat");
				ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(coches);
		} catch (IOException e) {
			System.out.println("No se han podido escribir los coches");
			e.printStackTrace();
		}

		try (FileInputStream fis = new FileInputStream("ficheros/coches.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) {
			var leidos = (ArrayList<?>) ois.readObject();

			for (var c : leidos) {
				System.out.println(c);
			}
		} catch (ClassNotFoundException | IOException e) {
			System.out.println("Error al leer los coches");
		}
	}
}
