package services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import model.Promocion;
import model.Usuario;
import persistence.PromocionDao;
import persistence.UsuarioDao;
import persistence.commons.DAOFactory;
import persistence.impl.PromocionDaoImpl;
import persistence.impl.UsuarioDaoImpl;

public class ComprarPromocionService {
	
	PromocionDao promocionDao = DAOFactory.getPromocionDao();
	UsuarioDao usuarioDAO = DAOFactory.getUserDAO();

	public Map<String, String> buy(Integer userId, Integer promocionId) {
		Map<String, String> errors = new HashMap<String, String>();

		Usuario usuario = usuarioDAO.find(userId);
		Promocion promocion = promocionDao.find(promocionId);

		if (!promocion.hayCupo()) {
			errors.put("attraction", "No hay cupo disponible");
		}
		if (!usuario.leAlcanza(promocion)) {
			errors.put("user", "No tienes dinero suficiente");
		}
		if (!usuario.tieneTiempo(promocion)) {
			errors.put("user", "No tienes tiempo suficiente");
		}

		if (errors.isEmpty()) {
			usuario.aceptarSugerencia(promocion);
			promocion.restarCupo();
			
			try {
				UsuarioDaoImpl.guardar(usuario, promocion);
				UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
				usuarioDaoImpl.update(usuario);
				PromocionDaoImpl.updateCupo(promocion);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

		return errors;

	}


}
