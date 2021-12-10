package persistence.commons;

import persistence.atraccion.AtraccionDao;
import persistence.atraccion.PromocionDao;
import persistence.impl.AtraccionDaoImpl;
import persistence.impl.PromocionDaoImpl;

public class DAOFactory {
/*
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	} */
	
	public static AtraccionDao getAtraccionDao() {
		return new AtraccionDaoImpl();
	}
	
	public static PromocionDao getPromocionDao() {
		return new PromocionDaoImpl();
	}
}
