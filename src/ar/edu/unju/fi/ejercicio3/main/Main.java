package ar.edu.unju.fi.ejercicio3.main;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		Provincia[] provincias = Provincia.values();
		for (Provincia l : provincias) {
			System.out.println(l);
			System.out.println("Poblacion: " + l.getPoblacion());
			System.out.println("Superficie: " + l.getSuperficie());
			System.out.println("Densidad: " + l.calcularDensidad());
			System.out.println("--------------------");
		}
	}

}
