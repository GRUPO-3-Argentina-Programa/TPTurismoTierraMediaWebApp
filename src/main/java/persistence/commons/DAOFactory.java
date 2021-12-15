package persistence.commons;

import persistence.AtraccionDao;
import persistence.ItinerarioDao;
import persistence.UsuarioDao;
import persistence.PromocionDao;
import persistence.impl.AtraccionDaoImpl;
import persistence.impl.ItinerarioDaoImpl;
import persistence.impl.PromocionDaoImpl;
import persistence.impl.UsuarioDaoImpl;

public class DAOFactory {

	public static UsuarioDao getUserDAO() {
		return new UsuarioDaoImpl();
	}
	
	public static AtraccionDao getAtraccionDao() {
		return new AtraccionDaoImpl();
	}
	
	public static PromocionDao getPromocionDao() {
		return new PromocionDaoImpl();
	}
	
	public static ItinerarioDao getItinerarioDao() {
		return new ItinerarioDaoImpl();
	}
	
}