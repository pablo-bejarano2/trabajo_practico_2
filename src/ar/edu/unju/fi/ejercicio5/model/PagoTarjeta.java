package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoTarjeta implements Pago {
	private String numTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	
	@Override
	public void realizarPago(double monto) {
		montoPagado = monto + ((monto*15)/100);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Numero de tarjeta: " + numTarjeta);
		System.out.println("Fecha: " + fechaPago.getDayOfMonth() + "/" + fechaPago.getMonthValue() + "/" + fechaPago.getYear());
		System.out.println("Monto pagado: " + montoPagado);
	}
	public String getNumTarjeta() {
		return numTarjeta;
	}
	public void setNumTarjeta(String numTarjeta) {
		this.numTarjeta = numTarjeta;
	}
	public LocalDate getFechapPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechapPago) {
		this.fechaPago = fechapPago;
	}
	public double getMontoPagado() {
		return montoPagado;
	}
	
	
}
