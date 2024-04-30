package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private Integer codigo;
	private String descripcion;
	private Double precioUnitario;
	private OrigenFabricacion origen;
	private Categoria categoria;
	
	
	public enum OrigenFabricacion{
		Argentina, China, Brasil, Uruguay;
	}
	public enum Categoria{
		Telefonia, Informatica, Electrohogar, Herramientas;
	}
	
	public String mostrarOrigenes() {
		return "1. " + OrigenFabricacion.Argentina + " \n" +
		"2. " + OrigenFabricacion.China + " \n" +
		"3. " + OrigenFabricacion.Brasil + " \n" +
		"4. " + OrigenFabricacion.Uruguay;
	}
	
	public String mostrarCategorias() {
		return "1. " + Categoria.Telefonia + " \n" +
		"2. " + Categoria.Informatica + " \n" +
		"3. " + Categoria.Electrohogar + " \n" +
		"4. " + Categoria.Herramientas;
	}
	
	public Producto() {
		
	}

	public Producto(Integer codigo, String descripcion, Double precioUnitario, OrigenFabricacion origen,
			Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origen = origen;
		this.categoria = categoria;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(Double precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public OrigenFabricacion getOrigen() {
		return origen;
	}

	public void setOrigen(int i) {
		switch(i){
			case 1:
				this.origen = OrigenFabricacion.Argentina;
				break;
			case 2:
				this.origen = OrigenFabricacion.China;
				break;
			case 3:
				this.origen = OrigenFabricacion.Brasil;
				break;
			case 4:
				this.origen = OrigenFabricacion.Uruguay;
				break;
		}
		
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(int i) {
		switch(i){
		case 1:
			this.categoria = Categoria.Telefonia;
			break;
		case 2:
			this.categoria = Categoria.Informatica;
			break;
		case 3:
			this.categoria = Categoria.Electrohogar;
			break;
		case 4:
			this.categoria = Categoria.Herramientas;
			break;
	}
	}

	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origen=" + origen + ", categoria=" + categoria + "]";
	}
	
	
	
}
