package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
	private static ArrayList<Efemeride> efemerides;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		efemerides = new ArrayList<Efemeride>();
		int op = 0;
		
		do {
			System.out.println("Ingrese opcion");
			System.out.println("1. Crear efemeride");
			System.out.println("2. Mostrar efemerides");
			System.out.println("3. Eliminar efemerides");
			System.out.println("4. Modificar efemerides");
			System.out.println("5. Salir");
			try {
				op = scanner.nextInt();
				switch(op) {
					case 1:
						crearEfemeride();
						break;
					case 2:
						mostrarEfemerides();
						break;
					case 3:
						eliminarEfemeride();
						break;
					case 4:
						 modificarEfemeride();
						break;
					case 5:
						break;
				}
			}catch(InputMismatchException ex) {
				System.out.println("Ingrese una opcion valida");
				scanner.next();
			}
		}while(op != 5);
	}

	public static void crearEfemeride(){
		int i = 0;
		Efemeride efemeride = new Efemeride();
		System.out.println("Ingese codigo de la efemeride");
		efemeride.setCodigo(scanner.nextInt());
		do {
			System.out.println("Ingrese dia");
			i = scanner.nextInt();
		}while(i<1 || i > 31);
		efemeride.setDia(i);
		do {
			System.out.println("Ingrese mes");
			i = scanner.nextInt();
		}while(i<1 || i > 12);
		efemeride.setMes(darMes(i));
		System.out.println("Ingrese detalles");
		efemeride.setDetalle(scanner.next());
		efemerides.add(efemeride);
	}
	
	public static Mes darMes(int i) {
		switch(i) {
		case 1:
			return Mes.Enero;
		case 2:
			return Mes.Febrero;
		case 3:
			return Mes.Marzo;
		case 4:
			return Mes.Abril;
		case 5:
			return Mes.Mayo;
		case 6:
			return Mes.Junio;
		case 7:
			return Mes.Julio;
		case 8:
			return Mes.Agosto;
		case 9:
			return Mes.Septiembre;
		case 10:
			return Mes.Octubre;
		case 11:
			return Mes.Noviembre;
		case 12:
			return Mes.Diciembre;
		}
		return null;
	}
	
	public static void mostrarEfemerides() {
		for(Efemeride l: efemerides) {
			System.out.println(l);
		}
	}
	
	public static void modificarEfemeride() {
		int codBuscado;
		int op = 0;
		System.out.println("Ingrese codigo de la eferide");
		codBuscado = scanner.nextInt();
		int j = -1;
		for(int i=0; i < efemerides.size(); i++) {
			if(efemerides.get(i).getCodigo() == codBuscado) {
				j = i;
			}
		}
		if(j==-1) {
			System.out.println("Efemeride no existente");
		}else {
			char option;
			
			System.out.println("Modificar dia? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				do {
					System.out.println("Ingrese dia");
					op = scanner.nextInt();
				}while(op<1 || op > 31);
				efemerides.get(j).setDia(op);
			}
			
			System.out.println("Modificar mes? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				do {
					System.out.println("Ingrese mes");
					op = scanner.nextInt();
				}while(op<1 || op > 12);
				efemerides.get(j).setMes(darMes(op));
			}
			
			System.out.println("Modificar detalle? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				System.out.println("Ingrese detalle");
				efemerides.get(j).setDetalle(scanner.next());
			}
			
		}
	}
	
	public static void eliminarEfemeride() {
		System.out.println("Ingrese codigo de la efemeride");
		int codBusqueda = scanner.nextInt();
		Iterator<Efemeride> iteratorEfemerides = efemerides.iterator();
		while(iteratorEfemerides.hasNext()) {
			Efemeride l = iteratorEfemerides.next();
			if(l.getCodigo() == codBusqueda) {
				iteratorEfemerides.remove();
				System.out.println("Efemeride eliminada.");
			}
		}
	}
}
