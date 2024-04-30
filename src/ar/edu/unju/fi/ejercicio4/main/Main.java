package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Jugador> jugadores;
	public static void main(String[] args) {
		jugadores = new ArrayList<Jugador>();
		int op = 0;
		do {
			try {
				mostrarMenu();
				System.out.println("Ingrese una opcion");
				op = scanner.nextInt();
				switch(op) {
					case 1:
						agregarJugador();
						break;
					case 2:
						mostrarJugadores();
						break;
					case 3:
						modificarPosicionJugador();
						break;
					case 4:
						eliminarJugador();
						break;
					case 5:
						break;
				}
			}catch(InputMismatchException ex){
				System.out.println("Ingrese un numero valido");
				scanner.next();
				}
		}while(op!=5);
	}
	public static void mostrarMenu() {
		System.out.println("1- Alta de jugador");
		System.out.println("2- Mostrar todos los jugadores");
		System.out.println("3- Modificar posicion de un jugador");
		System.out.println("4- Eliminar un jugador");
		System.out.println("5- Salir");
	}
	public static void agregarJugador() {
		int dia, mes, anio, op;
		Jugador jugador = new Jugador();
		System.out.println("Ingrese nombre");
		jugador.setNombre(scanner.next());
		System.out.println("Ingrese apellido");
		jugador.setApellido(scanner.next());
		do {
			System.out.println("Ingrese dia de nacimiento de la persona");
			dia = scanner.nextInt();
		}while(dia<1 || dia > 31);
		do {
			System.out.println("Ingrese mes de nacimiento de la persona");
			mes = scanner.nextInt();
		}while(mes<1 || mes > 12);
		do {
			System.out.println("Ingrese año de nacimiento de la persona");
			anio = scanner.nextInt();
		}while(anio<1900);
		LocalDate fecha = LocalDate.of(anio, mes, dia);
		jugador.setFnacimiento(fecha);
		System.out.println("Ingrese nacionalidad");
		jugador.setNacionalidad(scanner.next());
		System.out.println("Ingrese estatura");
		jugador.setEstatura(scanner.nextFloat());
		System.out.println("Ingrese peso");
		jugador.setPeso(scanner.nextFloat());
		do {
			System.out.println("Seleccione una posicion");
			System.out.println("1."+Posicion.Delantero);
			System.out.println("2."+Posicion.Medio);
			System.out.println("3."+Posicion.Defensa);
			System.out.println("4."+Posicion.Arquero);
			op = scanner.nextInt();
		}while(op<1 || op>4);
		switch(op) {
		case 1:
			jugador.setPosicion(Posicion.Delantero);
			break;
		case 2:
			jugador.setPosicion(Posicion.Medio);
			break;
		case 3:
			jugador.setPosicion(Posicion.Defensa);
			break;
		case 4:
			jugador.setPosicion(Posicion.Arquero);
			break;
		}
		jugadores.add(jugador);
	}
	public static void mostrarJugadores() {
		for(Jugador l: jugadores) {
			System.out.println(l);
		}
	}
	public static void modificarPosicionJugador() {
		int found = -1;
		int op;
		System.out.println("Ingrese apellido para buscar");
		String apellidoBusqueda = scanner.next();
		System.out.println("Ingrese nombre para buscar");
		String nombreBusqueda = scanner.next();
		for(int i = 0; i< jugadores.size(); i++) {
			if(jugadores.get(i).getApellido().equals(apellidoBusqueda) && jugadores.get(i).getNombre().equals(nombreBusqueda)) {
				found = i;
			}
		}
		if(found == -1) {
			System.out.println("Apellido no encontrado");
		}else {
			do {
				System.out.println("Seleccione una posicion");
				System.out.println("1."+Posicion.Delantero);
				System.out.println("2."+Posicion.Medio);
				System.out.println("3."+Posicion.Defensa);
				System.out.println("4."+Posicion.Arquero);
				op = scanner.nextInt();
			}while(op<1 || op>4);
			switch(op) {
			case 1:
				jugadores.get(found).setPosicion(Posicion.Delantero);
				break;
			case 2:
				jugadores.get(found).setPosicion(Posicion.Medio);
				break;
			case 3:
				jugadores.get(found).setPosicion(Posicion.Defensa);
				break;
			case 4:
				jugadores.get(found).setPosicion(Posicion.Arquero);
				break;
			
			}
		}
	}
	public static void eliminarJugador() {
		System.out.println("Ingrese apellido para buscar");
		String apellidoBusqueda = scanner.next();
		System.out.println("Ingrese nombre para buscar");
		String nombreBusqueda = scanner.next();
		
		Iterator<Jugador> iteratorJugadores = jugadores.iterator();
		while(iteratorJugadores.hasNext()) {
			Jugador l = iteratorJugadores.next();
			if(l.getApellido().equals(apellidoBusqueda) && l.getNombre().equals(nombreBusqueda)) {
				iteratorJugadores.remove();
				System.out.println("Jugador eliminado");
			};
			
		}
	}
}
