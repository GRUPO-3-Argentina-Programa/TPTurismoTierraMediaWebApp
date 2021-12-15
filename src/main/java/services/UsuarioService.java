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
	
	public int delete(int id) {
		UsuarioDao usuarioDao = DAOFactory.getUserDAO();
		return usuarioDao.delete(id);
	}

	public Usuario update(String nombre, String password,Boolean admin, Integer presupuesto, Double tiempo, String preferencia, int id, Boolean activo)  {

		UsuarioDao usuarioDao = DAOFactory.getUserDAO();
		Usuario usuario = usuarioDao.find(id);

		usuario.setNombre(nombre);
		usuario.setPassword(password);
		usuario.setAdmin(admin);
		usuario.setPresupuesto(presupuesto);
		usuario.setTiempo(tiempo);
		usuario.setPreferencia(preferencia);
		usuario.setActivo(activo);

		if (usuario.isValid()) {
			usuarioDao.update(usuario);
		}

		return usuario;
	}

	public Usuario find(Integer id) {
		UsuarioDao usuarioDao = DAOFactory.getUserDAO();
		return usuarioDao.find(id);
	}
}


