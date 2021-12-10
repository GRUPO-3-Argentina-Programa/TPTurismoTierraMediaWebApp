package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.PromocionAbs;
import model.PromocionAxB;
import model.PromocionPorcentual;
import persistence.PromocionDao;
import persistence.commons.ConnectionProvider;

public class PromocionDaoImpl implements PromocionDao {

	static List<Atraccion> atraccionesDePromo = null;

	public static List<Promocion> findAllPromo() throws SQLException {
		String query = "SELECT * FROM promociones";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(query);

		ResultSet result = statement.executeQuery();

		List<Promocion> promocion = new LinkedList<Promocion>();
		while (result.next()) {

			promocion.add(toTipoPromocion(result));

		}

		return promocion;
	}

	private static Promocion toTipoPromocion(ResultSet result) throws SQLException {
		atraccionesDePromo = new LinkedList<Atraccion>();
		atraccionesDePromo.addAll(getAtraccionesDePromo(getIdDeAtracciones(result.getInt(1))));

		if (result.getString(3).equals("porcentual")) {
			return new PromocionPorcentual(result.getString(2), atraccionesDePromo, result.getDouble(4),
					result.getInt(1));
		}

		if (result.getString(3).equals("AxB")) {
			AtraccionDaoImpl atrd = new AtraccionDaoImpl();
			return new PromocionAxB(result.getString(2), atraccionesDePromo, atrd.find(result.getInt(6)),
					result.getInt(1));
		} else {
			return new PromocionAbs(result.getString(2), atraccionesDePromo, result.getInt(5), result.getInt(1));
		}
	}

	private static List<Atraccion> getAtraccionesDePromo(List<Integer> id_atracciones) throws SQLException {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		AtraccionDaoImpl atrd = new AtraccionDaoImpl();
		try {
			List<Atraccion> atrs = new LinkedList<Atraccion>(atrd.findAll());
			for (Integer id : id_atracciones) {
				for (Atraccion a : atrs) {
					if (id == a.getId())
						atracciones.add(a);
				}
			}
		} catch (Exception e) {

		}
		return atracciones;
	}

	public static List<Integer> getIdDeAtracciones(int id_promocion) throws SQLException {
		String query = "   SELECT Id_atraccion FROM Promociones_con_atracciones  \r\n" + "WHERE id_promocion = ? ";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(query);

		statement.setInt(1, id_promocion);
		ResultSet result = statement.executeQuery();

		List<Integer> id_atracciones = new LinkedList<Integer>();
		while (result.next()) {
			id_atracciones.add(result.getInt(1));
		}

		return id_atracciones;
	}

	public void updateCupo(Promocion promo, Connection conn) throws SQLException {

		Iterator<Atraccion> itr = promo.getAtracciones().iterator();

		while (itr.hasNext()) {
			Atraccion atr = itr.next();

			String query = "UPDATE atracciones SET cupo = ? WHERE NOMBRE LIKE ?";

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, atr.getCupo());
			statement.setString(2, atr.getNombre());

			statement.executeUpdate();

		}
	}

	public Promocion findByIdPromo(int id) throws SQLException {
		String query = "SELECT * FROM promociones WHERE promo_id LIKE ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(query);

		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		Promocion promoId = null;
		if (result.next()) {
			promoId = toTipoPromocion(result);
		}

		return promoId;
	}

	
	@Override
	public Promocion find(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Promocion> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countAll() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insert(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(Promocion t) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
