package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Ofertador {
	
	public List<Sugerible> ofertar(Usuario us, List<Sugerible> sugerencias) throws IOException, SQLException {
	sugerencias.sort(new ComparadorDeSugerencias(us.getPreferencia()));
	List<Sugerible> recomendacion = new LinkedList<Sugerible>();

	Iterator<Sugerible> sg = sugerencias.iterator();
	while (sg.hasNext()) {
		Sugerible sug = sg.next();
		
		if (us.puedeComprar(sug) && sug.hayCupo()) {
			recomendacion.add(sug);
		}
	}
	return recomendacion;
	
	}

}
