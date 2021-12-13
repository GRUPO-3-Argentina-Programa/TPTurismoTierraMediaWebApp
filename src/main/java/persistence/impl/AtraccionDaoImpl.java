package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import persistence.AtraccionDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class AtraccionDaoImpl implements AtraccionDao {

	protected Atraccion toAtraccion(ResultSet result) throws SQLException {
		return new Atraccion(result.getString(1), result.getInt(2), result.getString(3), result.getDouble(4),
				result.getInt(5), result.getInt(6), result.getString(8));
	}

	public List<Atraccion> findAll() {

		try {
			String query = "SELECT * FROM atracciones";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet result = statement.executeQuery();

			List<Atraccion> atraccion = new LinkedList<Atraccion>();
			while (result.next()) {

				atraccion.add(toAtraccion(result));
			}

			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public Atraccion findByName(String nombre) throws SQLException {
		String query = "SELECT * FROM atracciones WHERE NOMBRE LIKE ?";
		Connection conn = ConnectionProvider.getConnection();

		PreparedStatement statement = conn.prepareStatement(query);

		statement.setString(1, nombre);

		ResultSet result = statement.executeQuery();

		Atraccion atraccionR = null;
		if (result.next()) {
			atraccionR = toAtraccion(result);
		}

		return atraccionR;
	}

	public Atraccion find(Integer id) {
		try {
			String query = "SELECT * FROM atracciones WHERE atraccion_id LIKE ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, id);

			ResultSet result = statement.executeQuery();

			Atraccion atraccionId = null;
			if (result.next()) {
				atraccionId = toAtraccion(result);
			}

			return atraccionId;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	public static int updateCupo(Atraccion atraccion) throws SQLException {
		try {
			String query = "UPDATE atracciones SET Cupo = ? WHERE NOMBRE LIKE ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setInt(1, atraccion.getCupo());
			statement.setString(2, atraccion.getNombre());

			return statement.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}

	}

	@Override
	public int insert(Atraccion atraccion) {
		try {
			String sql = "INSERT INTO ATRACCIONES (Nombre, COSTO, TIPO, TIEMPO, CUPO) VALUES (?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, atraccion.getNombre());
			statement.setDouble(i++, atraccion.getCosto());
			statement.setString(i++, atraccion.getTipoAtraccion());
			statement.setDouble(i++, atraccion.getTiempoTotal());
			statement.setInt(i++, atraccion.getCupo());
			// statement.setInt(i++, atraccion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public void update(Atraccion attraction) {
		try {
			String sql = "UPDATE ATTRACTIONS SET nombre = ?, costo = ?, tipo = ?, tiempo = ?, cupo = ? WHERE atraccion_ID = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			int i = 1;
			statement.setString(i++, attraction.getNombre());
			statement.setDouble(i++, attraction.getCosto());
			statement.setString(i++, attraction.getTipoAtraccion());
			statement.setDouble(i++, attraction.getTiempoTotal());
			statement.setInt(i++, attraction.getCupo());
			statement.setInt(i++, attraction.getId());
			int rows = statement.executeUpdate();

			
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	@Override
	public int delete (int id) {
		try {
			String sql = "UPDATE atracciones SET activo = 0 WHERE atraccion_id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
			int rows = statement.executeUpdate();
			return rows;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		} 
	}

	public static void main(String[] args) {
		List<Atraccion> atracciones = new LinkedList<Atraccion>();
		AtraccionDaoImpl a = new AtraccionDaoImpl();
		atracciones.addAll(a.findAll());
		System.out.println(atracciones);
	}

}
