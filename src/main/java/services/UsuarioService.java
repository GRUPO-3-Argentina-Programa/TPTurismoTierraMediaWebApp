package services;

import java.util.List;

import model.Usuario;
import persistence.commons.DAOFactory;

public class UsuarioService {
	
	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}

}


