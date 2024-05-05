package ar.edu.unju.fi.ejercicio5.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio5.interfaces.Pago;

public class PagoEfectivo implements Pago {
	private LocalDate fechaPago;
	private double montoPagado;
	
	@Override
	public void realizarPago(double monto) {
		montoPagado = monto - ((monto*15)/100);
	}
	@Override
	public void imprimirRecibo() {
		System.out.println("Fecha: " + fechaPago.getDayOfMonth() + "/" + fechaPago.getMonthValue() + "/" + fechaPago.getYear());
		System.out.println("Monto pagado: " + montoPagado);
	}
	public LocalDate getFechaPago() {
		return fechaPago;
	}
	public void setFechaPago(LocalDate fechaPago) {
		this.fechaPago = fechaPago;
	}
	public double getMontoPagado() {
		return montoPagado;
	}
	
}
