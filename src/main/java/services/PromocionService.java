package services;

import java.util.List;

import model.Promocion;
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

}
