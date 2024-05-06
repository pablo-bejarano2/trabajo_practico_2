package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	
	private static ArrayList<Producto> productos;
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		productos = new ArrayList<Producto>();
		crearArrayProductos();
		int op = 0;
		do {
			mostrarMenu();
			try {
				System.out.println("Ingrese una opcion:");
				op = scanner.nextInt();
				switch(op) {
				case 1:
					mostrarDisponibles();
					break;
				case 2:
					mostrarFaltantes();
					break;
				case 3:
					incrementarPrecios();
					break;
				case 4:
					mostrarElectrohogar();
					break;
				case 5:
					 ordenarPorPrecio();
					 break;
				case 6:
					nombresMayusculas();
					break;
				}
			}catch(InputMismatchException ex){
				System.out.println("Ingrese un numero valido");
				scanner.next();
				}
		}while(op != 7);
	}
	
	public static void mostrarMenu() {
		System.out.println("1. Mostrar productos");
		System.out.println("2. Mostrar productos faltantes");
		System.out.println("3. Incrementar el precio de los productos en un 20%");
		System.out.println("4. Mostrar productos de la categoria electrohogar disponibles");
		System.out.println("5. Ordenar productos por precio");
		System.out.println("6. Mostrar productos en mayuscula");
		System.out.println("7. Salir");
		
	}
	public static void crearArrayProductos() {
		productos.add(new Producto(100, "Cafetera", 500.0, Producto.OrigenFabricacion.Brasil ,Producto.Categoria.Electrohogar, false));
		productos.add(new Producto(120, "Computadora", 2000.0, Producto.OrigenFabricacion.China ,Producto.Categoria.Informatica, true));
		productos.add(new Producto(110, "Telefono Motorola", 1500.0, Producto.OrigenFabricacion.China ,Producto.Categoria.Telefonia, false));
		productos.add(new Producto(101, "Microondas", 350.0, Producto.OrigenFabricacion.Argentina ,Producto.Categoria.Electrohogar, true));
		productos.add(new Producto(140, "Taladro", 200.0, Producto.OrigenFabricacion.Uruguay ,Producto.Categoria.Herramientas, true));
		productos.add(new Producto(111, "Telefono Samsung", 1700.0, Producto.OrigenFabricacion.Brasil ,Producto.Categoria.Telefonia, true));
		productos.add(new Producto(102, "Heladera", 1000.0, Producto.OrigenFabricacion.Brasil ,Producto.Categoria.Electrohogar, true));
		productos.add(new Producto(121, "Teclado de computadora", 200.0, Producto.OrigenFabricacion.Uruguay ,Producto.Categoria.Informatica, false));
		productos.add(new Producto(122, "Laptop", 1400.0, Producto.OrigenFabricacion.Argentina ,Producto.Categoria.Informatica, true));
		productos.add(new Producto(123, "Netbook", 2000.0, Producto.OrigenFabricacion.China ,Producto.Categoria.Informatica, false));
		productos.add(new Producto(103, "Batidora electrica", 250.0, Producto.OrigenFabricacion.Argentina ,Producto.Categoria.Electrohogar, true));
		productos.add(new Producto(112, "Telefono Apple", 2500.0, Producto.OrigenFabricacion.Argentina ,Producto.Categoria.Telefonia, true));
		productos.add(new Producto(113, "Telefono Xiaomi", 1200.0, Producto.OrigenFabricacion.China ,Producto.Categoria.Telefonia, false));
		productos.add(new Producto(104, "Lavadora", 500.0, Producto.OrigenFabricacion.Brasil ,Producto.Categoria.Electrohogar, true));
		productos.add(new Producto(141, "Motosierra", 400.0, Producto.OrigenFabricacion.Uruguay ,Producto.Categoria.Herramientas, true));
		
	}
	public static void mostrarDisponibles() {
		Consumer<Producto> printConsumer; 
		printConsumer = c -> System.out.println(c);
		ArrayList<Producto> disponibles = new ArrayList<>();
		for(Producto l: productos) {
			if(l.getDisponible()) {
				disponibles.add(l);
			}
		}
		disponibles.forEach(printConsumer);
	}
	
	public static void mostrarFaltantes() {
		ArrayList<Producto> noDisponibles = new ArrayList<>();
		Consumer<Producto> printProduct = c -> System.out.println(c);
		Predicate<Producto> filterProducts = n -> n.getDisponible() == false;
		noDisponibles = (ArrayList<Producto>) productos.stream().filter(filterProducts).collect(Collectors.toList());
		noDisponibles.forEach(printProduct);
		
	}
	
	public static void incrementarPrecios() {
		ArrayList<Producto> productosPrecioAjustado = new ArrayList<>();
		Consumer<Producto> printProduct = c -> System.out.println(c);
		Function<Producto, Producto> funcionAjuste = producto -> new Producto(producto.getCodigo(), producto.getDescripcion(), producto.getPrecioUnitario() *2, producto.getOrigen(), producto.getCategoria(), producto.getDisponible());
		productosPrecioAjustado = (ArrayList<Producto>) productos.stream().map(funcionAjuste).collect(Collectors.toList());
		productosPrecioAjustado.forEach(printProduct);
	}
	
	public static void mostrarElectrohogar() {
		ArrayList<Producto> electrohogarDisponibles = new ArrayList<>();
		Consumer<Producto> printProduct = c -> System.out.println(c);
		Predicate<Producto> filterProducts = n -> n.getDisponible() == true && n.getCategoria() == Producto.Categoria.Electrohogar;
		electrohogarDisponibles = (ArrayList<Producto>) productos.stream().filter(filterProducts).collect(Collectors.toList());
		electrohogarDisponibles.forEach(printProduct);
	}
	
	public static void ordenarPorPrecio() {
		Consumer<Producto> printProduct = c -> System.out.println(c);
		Comparator<Producto> comparatorPorPrecio = (Producto p1, Producto p2) -> p2.getPrecioUnitario().compareTo(p1.getPrecioUnitario()) ;
		Collections.sort(productos, comparatorPorPrecio);
		productos.forEach(printProduct);
	}
	
	public static void nombresMayusculas() {
		ArrayList<Producto> descripcionMayuscula = new ArrayList<>();
		Consumer<Producto> printProduct = c -> System.out.println(c);
		Function<Producto, Producto> funcionMayuscula = producto -> new Producto(producto.getCodigo(), producto.getDescripcion().toUpperCase(), producto.getPrecioUnitario(), producto.getOrigen(), producto.getCategoria(), producto.getDisponible());
		descripcionMayuscula = (ArrayList<Producto>) productos.stream().map(funcionMayuscula).collect(Collectors.toList());
		descripcionMayuscula.forEach(printProduct);
	}
}
