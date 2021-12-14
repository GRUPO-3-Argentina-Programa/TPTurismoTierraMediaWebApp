package services;

import java.sql.SQLException;
import java.util.List;

import model.Atraccion;
import persistence.AtraccionDao;
import persistence.commons.DAOFactory;

public class AtraccionService {

	public List<Atraccion> list() {
		return DAOFactory.getAtraccionDao().findAll();
	}

	public Atraccion create(String nombre, Double costo, String tipo, double tiempo, int cupo, String descripcion) {

		Atraccion atraccion = new Atraccion(nombre, costo, tipo, tiempo, cupo, descripcion);

		if (atraccion.isValid()) {
			AtraccionDao atraccionDao = DAOFactory.getAtraccionDao();
			atraccionDao.insert(atraccion);
		}

		return atraccion;
	}

	public Atraccion update(String nombre, Double costo, String tipo, Double tiempo, Integer cupo, String descripcion) throws SQLException {

		AtraccionDao attractionDAO = DAOFactory.getAtraccionDao();
		Atraccion attraction = attractionDAO.findByName(nombre);

		attraction.setNombre(nombre);
		attraction.setCosto(costo);
		attraction.setTipo(tipo);
		attraction.setTiempo(tiempo);
		attraction.setCupo(cupo);
		attraction.setDescripcion(descripcion);
		

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
