package ar.edu.unju.fi.ejercicio5.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

public class Main {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Producto> productos;
	public static void main(String[] args) {
		productos = new ArrayList<Producto>();
		crearArrayProductos();
		
		int op = 0;
		do {
			try {
				System.out.println("1. Mostrar productos");
				System.out.println("2. Realizar compra");
				System.out.println("3. Salir");
				System.out.println("Seleccione una opcion");
				op = scanner.nextInt();
				switch(op) {
				case 1:
					mostrarProductos();
					break;
				case 2:
					realizarCompra();
					break;
				case 3:
					break;
				}
			}catch(InputMismatchException ex){
				System.out.println("Ingrese un numero valido");
				scanner.next();
				}
		}while(op!=3);
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
	public static void mostrarProductos() {
		for(Producto l: productos) {
			System.out.println(l);
		}
	}
	public static void realizarCompra() {
		ArrayList<Producto> carrito = new ArrayList<Producto>();
		int op = -1;
		do {
			int i = 1;
			for(Producto l: productos) {
				System.out.println(i + ". " + l.getDescripcion());
				i++;
			}
			System.out.println("16. Terminar compra");
			System.out.println("Elige una opcion");
			op = scanner.nextInt();
			if(op>0 && op <15) {
				if(productos.get(op-1).getDisponible() == true) {
					System.out.println("Producto agregado");
					carrito.add(productos.get(op-1));
				}else {
					System.out.println("No hay disponible");
				}
				
			}
			if(op == 16) {
				for(Producto l: carrito) {
					System.out.println("Carrito: " + l.getDescripcion());
				}
			}
		}while(op!=16);
		if(carrito.isEmpty() == true) {
			System.out.println("El carrito esta vacio");
		}else {
			double monto = 0;
			for(Producto l: carrito) {
				monto += l.getPrecioUnitario();
			}
			do {
				System.out.println("El monto total es: " + monto);
				System.out.println("Seleccione metodo de pago");
				System.out.println("1. Pago efectivo");
				System.out.println("2. Pago en tarjeta");
				op = scanner.nextInt();
			}while(op != 1 && op != 2);
			if(op == 1) {
				PagoEfectivo pago = new PagoEfectivo();
				pago.setFechaPago(LocalDate.now());
				pago.realizarPago(monto);
				pago.imprimirRecibo();
			}else if(op == 2) {
				PagoTarjeta pago = new PagoTarjeta();
				System.out.println("Ingrese tarjeta");
				pago.setNumTarjeta(scanner.next());
				pago.setFechaPago(LocalDate.now());
				pago.realizarPago(monto);
				pago.imprimirRecibo();
			}
		}
		
	}
}
