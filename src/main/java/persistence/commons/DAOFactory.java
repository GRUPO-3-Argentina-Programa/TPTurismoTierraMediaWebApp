package persistence.commons;

import persistence.UsuarioDao;
import persistence.atraccion.AtraccionDao;
import persistence.atraccion.PromocionDao;
import persistence.impl.AtraccionDaoImpl;
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
}
