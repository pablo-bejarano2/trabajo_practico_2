package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	Jujuy(811611, 53219), Salta(1440672, 155488), Tucuman(2003186, 22525), Catamarca(429562, 102602), La_Rioja(384607, 89680), Santiago_Del_Estero(1054028, 136351);
	
	private Integer poblacion;
	private Integer superficie;
	
	private Provincia(Integer poblacion, Integer superficie) {
		this.poblacion = poblacion;
		this.superficie = superficie;
	}

	public Integer getPoblacion() {
		return poblacion;
	}

	public Integer getSuperficie() {
		return superficie;
	}
	
	public float  calcularDensidad() {
		
		return (float)poblacion/(float)superficie;
		
	}
}
