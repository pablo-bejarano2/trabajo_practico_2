package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	private static ArrayList<Producto> productos;
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		productos = new ArrayList<Producto>();
		int op = 0;
		
		do {
			System.out.println("Ingrese opcion");
			System.out.println("1. Crear opcion");
			System.out.println("2. Mostrar productos");
			System.out.println("3. Modificar productos");
			System.out.println("4. Salir");
			try {
			op = scanner.nextInt();
			switch(op) {
			case 1: 
				crearProducto();
				break;
			case 2:
				mostrarProductos();
				break;
			case 3:
				modificarProducto();
				break;
			case 4:
				break;
			}
			}catch(InputMismatchException ex) {
			System.out.println("Ingrese una opcion valida");
			scanner.next();
		}
		}while(op != 4);
		
	}
	
	public static void crearProducto() {
		int op = 0;
		Producto producto = new Producto();
		System.out.println("Ingrese codigo del producto");
		producto.setCodigo(scanner.nextInt());
		System.out.println("Ingrese descripcion del producto");
		producto.setDescripcion(scanner.next());
		System.out.println("Ingrese precio del producto");
		producto.setPrecioUnitario(scanner.nextDouble());
		do {
			System.out.println("Ingrese origen del producto");
			System.out.println(producto.mostrarOrigenes());
			op = scanner.nextInt();
		}while(op<1 || op > 4);
		producto.setOrigen(op);
		do {
			System.out.println("Ingrese categoria del producto");
			System.out.println(producto.mostrarCategorias());
			op = scanner.nextInt();
		}while(op<1 || op > 4);
		producto.setCategoria(op);
		productos.add(producto);
	}
	
	public static void mostrarProductos(){
		for(Producto l: productos) {
			System.out.println(l);
		}
	}
	
	public static void modificarProducto() {
		int codBuscado;
		int op = 0;
		System.out.println("Ingrese codigo del producto");
		codBuscado = scanner.nextInt();
		int j = -1;
		for(int i=0; i < productos.size(); i++) {
			if(productos.get(i).getCodigo() == codBuscado) {
				j = i;
			}
		}
		if(j==-1) {
			System.out.println("Destino no existente");
		}else {
			char option;
			System.out.println("Modificar descripcion? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				System.out.println("Ingrese nueva descripcion");
				productos.get(j).setDescripcion(scanner.next());
			}
			System.out.println("Modificar precio? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				System.out.println("Ingrese nuevo precio");
				productos.get(j).setPrecioUnitario(scanner.nextDouble());
			}
			System.out.println("Modificar origen? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				do {
					System.out.println("Ingrese nuevo origen");
					System.out.println(productos.get(j).mostrarOrigenes());
					op = scanner.nextInt();
				}while(op<1 || op > 4);
				productos.get(j).setOrigen(op);;
			}
			System.out.println("Modificar categoria? S/N");
			option = scanner.next().charAt(0);
			if(option == 's' || option == 'S') {
				do {
					System.out.println("Ingrese nueva categoria");
					System.out.println(productos.get(j).mostrarCategorias());
					op = scanner.nextInt();
				}while(op<1 || op > 4);
				productos.get(j).setCategoria(op);;
			}
			
		}
		
		
	}
}
