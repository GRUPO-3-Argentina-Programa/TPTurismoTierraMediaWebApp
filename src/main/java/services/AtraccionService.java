package services;

import java.util.List;

import model.Atraccion;
import persistence.AtraccionDao;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDao().findAll();
	}

	public Atraccion create(String nombre, Double costo, String tipo, double tiempo, int cupo) {

		Atraccion atraccion = new Atraccion(nombre, costo, tipo, tiempo, cupo);

		if (atraccion.isValid()) {
			AtraccionDao atraccionDao = DAOFactory.getAtraccionDao();
			atraccionDao.insert(atraccion);
		}

		return atraccion;
	}

	public Atraccion update(String nombre, Double costo, String tipo, Double tiempo, Integer cupo, Integer id) {

		AtraccionDao attractionDAO = DAOFactory.getAtraccionDao();
		Atraccion attraction = attractionDAO.find(id);

		attraction.setNombre(nombre);
		attraction.setCosto(costo);
		attraction.setTiempo(tiempo);
		attraction.setCupo(cupo);

		if (attraction.isValid()) {
			attractionDAO.update(attraction);
		}

		return attraction;
	}

	public int delete(int id) {

		AtraccionDao atraccionDAO = DAOFactory.getAtraccionDao();

		return atraccionDAO.delete(id);
	}

	public Atraccion find(Integer id) {
		AtraccionDao attractionDAO = DAOFactory.getAtraccionDao();
		return attractionDAO.find(id);
	}

}
