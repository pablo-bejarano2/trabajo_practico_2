package ar.edu.unju.fi.ejercicio6.main;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;
import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;

public class Main {

	public static void main(String[] args) {
		FelinoSalvaje gatoSalvaje = new FelinoSalvaje("Tanner", (byte)20, 186f);
		
		if(Converter.isNotNull(gatoSalvaje)) {
			Converter<FelinoSalvaje, FelinoDomestico> converter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());
			FelinoDomestico gatoDomestico = converter.convert(gatoSalvaje);
			
			converter.mostrarObjeto(gatoDomestico);
		}else {
			System.out.println("No existen valores");
		}
		
		
	}

}
