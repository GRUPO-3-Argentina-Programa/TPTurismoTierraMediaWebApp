package services;

import java.sql.SQLException;
import java.util.List;

import model.Sugerible;
import persistence.commons.DAOFactory;

public class ItinerarioService {
	
	public List<Sugerible> list(String nombre) throws SQLException {
		return DAOFactory.getItinerarioDao().getItinerario(nombre);
	}
}
