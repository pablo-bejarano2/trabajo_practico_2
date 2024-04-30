package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fnacimiento;
	private String nacionalidad;
	private Float estatura;
	private Float peso;
	private Posicion posicion;
	
	public int calcularEdad() {
		LocalDate fechaHoy = LocalDate.now();
		return fechaHoy.compareTo(fnacimiento);
	}
	
	public Jugador() {
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFnacimiento() {
		return fnacimiento;
	}

	public void setFnacimiento(LocalDate fnacimiento) {
		this.fnacimiento = fnacimiento;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Float getEstatura() {
		return estatura;
	}

	public void setEstatura(Float estatura) {
		this.estatura = estatura;
	}

	public Float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	@Override
	public String toString() {
		return "Nombre del jugador: " + nombre + ", apellido: " + apellido + ", fecha de nacimiento: " + fnacimiento
				+ ", nacionalidad: " + nacionalidad + ", estatura: " + estatura + ", peso: " + peso + ", posicion: "
				+ posicion + ", edad: " + calcularEdad();
	}
	
	
}
