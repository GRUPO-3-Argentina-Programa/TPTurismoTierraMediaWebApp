package services;

import java.util.List;

import model.Atraccion;
import model.Promocion;
import persistence.AtraccionDao;
import persistence.PromocionDao;
import persistence.commons.DAOFactory;

public class PromocionService {

	public List<Promocion> list() {
		return DAOFactory.getPromocionDao().findAll();
	}
	
	public Promocion find(Integer id) {
		PromocionDao promocionDAO = DAOFactory.getPromocionDao();
		return promocionDAO.find(id);
	}

	
	public int delete(int id) {

		PromocionDao promocionDao = DAOFactory.getPromocionDao();

		return promocionDao.delete(id);
	}


}
