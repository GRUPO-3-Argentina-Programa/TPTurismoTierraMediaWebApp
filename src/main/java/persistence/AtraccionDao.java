package persistence;

import model.Atraccion;
import persistence.commons.GenericDAO;

public interface AtraccionDao extends GenericDAO<Atraccion> {

	int insert(Atraccion atraccion);

}
