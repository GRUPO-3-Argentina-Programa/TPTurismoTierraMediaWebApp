package services;

import java.util.List;
import model.Tipo;
import persistence.commons.DAOFactory;

public class TipoService {
	
	public List<Tipo> list() {
		return DAOFactory.getTipoDao().findAll();
	}
	
	public int delete(String tipo) {
		return DAOFactory.getTipoDao().delete(tipo);
	}
	
	public Tipo create(String nombre) {

		Tipo tipo = new Tipo(nombre);

		DAOFactory.getTipoDao().insert(tipo.getNombre());

		return tipo;
	}

}
