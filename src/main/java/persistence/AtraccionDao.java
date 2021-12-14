package persistence;

import java.sql.SQLException;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDao extends GenericDAO<Atraccion> {

	int insert(Atraccion atraccion);
	int delete(int id);
	int update(Atraccion attraction);
	Atraccion findByName(String nombre) throws SQLException;
}
