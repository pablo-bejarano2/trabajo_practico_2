package ar.edu.unju.fi.ejercicio6.model;

public class FelinoDomestico {
	private String nombre;
	private Byte edad;
	private Float peso;
	
	public FelinoDomestico(String nombre, Byte edad, Float peso) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public String getNombre() {
		return nombre;
	}

	public Byte getEdad() {
		return edad;
	}

	public Float getPeso() {
		return peso;
	}

	@Override
	public String toString() {
		return "Nombre del felino domestico: " + nombre + ", edad: " + edad + ", peso: " + peso + "kg";
	}
	
	
}
