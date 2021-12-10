package services;

import model.Usuario;
import model.nullObjets.NullUser;
import persistence.UsuarioDao;
import persistence.commons.DAOFactory;

public class LoginService {
	
	private UsuarioDao userDao;
	
	public Usuario login(String username, String password) {
		userDao = DAOFactory.getUserDAO();
    	Usuario user = userDao.findByUsername(username);
    	
    	if (user.isNull() || !user.checkPassword(password)) {
    		user = NullUser.build();
    	}
    	return user;
	}
	
}
