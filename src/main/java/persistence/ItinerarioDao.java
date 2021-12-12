package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Sugerible;

public interface ItinerarioDao {

	List<Sugerible> getItinerario(String nombre) throws SQLException;
	
}

