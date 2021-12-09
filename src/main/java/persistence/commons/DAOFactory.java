package persistence.commons;

import persistence.atraccion.*;
import persistence.impl.AtraccionDaoImpl;

public class DAOFactory {
/*
	public static UserDAO getUserDAO() {
		return new UserDAOImpl();
	} */
	
	public static AtraccionDao getAtraccionDao() {
		return new AtraccionDaoImpl();
	}
}
