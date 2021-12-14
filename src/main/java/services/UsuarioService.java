package services;

import java.util.List;

import model.Usuario;
import persistence.UsuarioDao;
import persistence.commons.DAOFactory;

public class UsuarioService {
	
	public List<Usuario> list() {
		return DAOFactory.getUserDAO().findAll();
	}
	
	public Usuario create(String nombre, String password,Boolean admin, Integer presupuesto, Double tiempo, String preferencia) {

		Usuario usuario = new Usuario(nombre, password, admin, presupuesto, tiempo, preferencia);

		if (usuario.isValid()) {
			UsuarioDao usuarioDao = DAOFactory.getUserDAO();
			usuarioDao.insert(usuario);
		}
		return usuario;
	}

}


