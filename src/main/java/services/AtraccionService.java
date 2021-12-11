package services;

import java.util.List;

import model.Atraccion;
import persistence.atraccion.AtraccionDao;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDao().findAll();
	}

	public Atraccion create(String nombre, Double costo,  String tipo, double tiempo, int cupo, int id) {

		Atraccion atraccion = new Atraccion(nombre, costo, tipo, tiempo, cupo, id);

		if (atraccion.isValid()) {
			AtraccionDao atraccionDao = DAOFactory.getAtraccionDao();
			atraccionDao.insert(atraccion);
			// XXX: si no devuelve "1", es que hubo más errores
		}

		return atraccion;
	}

//	public Atraccion update(Integer id, String name, Integer cost, Double duration, Integer capacity) {
//
//		AtraccionDao attractionDAO = DAOFactory.getAttractionDAO();
//		Atraccion attraction = attractionDAO.find(id);
//
//		attraction.setName(name);
//		attraction.setCost(cost);
//		attraction.setDuration(duration);
//		attraction.setCapacity(capacity);
//
//		if (attraction.isValid()) {
//			attractionDAO.update(attraction);
//			// XXX: si no devuelve "1", es que hubo más errores
//		}
//
//		return attraction;
//	}

//	public void delete(Integer id) {
//		Atraccion attraction = new Atraccion(id, null, null, null, null);
//
//		AtraccionDao attractionDAO = DAOFactory.getAttractionDAO();
//		attractionDAO.delete(attraction);
//	}

	public Atraccion find(Integer id) {
		AtraccionDao attractionDAO = DAOFactory.getAtraccionDao();
		return attractionDAO.find(id);
	}

}
