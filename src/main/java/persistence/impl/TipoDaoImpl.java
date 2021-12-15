package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import model.Tipo;
import persistence.TipoDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class TipoDaoImpl implements TipoDao {
	
	protected Tipo toTipo(ResultSet result) throws SQLException {
		return new Tipo(result.getString(1), result.getBoolean(2));
	}
	
	public List<Tipo> findAll() {
		try {
		String query = "SELECT * FROM TIPOS";
		Connection conn= ConnectionProvider.getConnection();		
		PreparedStatement statement = conn.prepareStatement(query);
		
		ResultSet result= statement.executeQuery();
		
		List<Tipo> tipos = new LinkedList<Tipo>();
		
		while(result.next()) {
				tipos.add(toTipo(result));
		}
		return tipos;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public Tipo find(String nombre) throws SQLException {
		String query = "SELECT * FROM TIPOS WHERE nombre LIKE ?";
		Connection conn= ConnectionProvider.getConnection();		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, nombre);
		
		ResultSet result = statement.executeQuery();
		
		return toTipo(result);
	}
	
	public int insert(String tipo) {
		try {
		String query = "INSERT INTO TIPOS (nombre) VALUES (?)";
		Connection conn = ConnectionProvider.getConnection();
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, tipo);
		
		return statement.executeUpdate();
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	
	
	@Override
	public int delete (String tipo) {
		try {
			String sql = "UPDATE Tipos SET activo = 0 WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, tipo);
			
			int rows = statement.executeUpdate();
			return rows;
			
		} catch (Exception e) {
			throw new MissingDataException(e);
		} 
	}

}
