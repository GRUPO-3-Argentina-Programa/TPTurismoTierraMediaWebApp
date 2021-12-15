package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Atraccion;
import model.Usuario;
import persistence.AtraccionDao;
import persistence.UsuarioDao;
import persistence.commons.DAOFactory;
import persistence.impl.AtraccionDaoImpl;
import persistence.impl.UsuarioDaoImpl;

public class ComprarAtraccionService {
	
	AtraccionDao atraccionDao = DAOFactory.getAtraccionDao();
	UsuarioDao usuarioDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer attractionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.find(userId);
		Atraccion atraccion = atraccionDao.find(attractionId);

		if (!atraccion.hayCupo()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!usuario.leAlcanza(atraccion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!usuario.tieneTiempo(atraccion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.aceptarSugerencia(atraccion);
			atraccion.restarCupo();
			
			try {
				UsuarioDaoImpl.guardar(usuario, atraccion);
				UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
				usuarioDaoImpl.update(usuario);
				AtraccionDaoImpl.updateCupo(atraccion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return errors;

	}

}
