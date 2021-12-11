package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import persistence.atraccion.AtraccionDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;


public class AtraccionDaoImpl implements AtraccionDao {

	protected  Atraccion toAtraccion(ResultSet result) throws SQLException {
		return new Atraccion(result.getString(1), result.getInt(2), result.getString(3),
				result.getDouble(4), result.getInt(5), result.getInt(6));
	}

	public  List<Atraccion>findAll() {
		
		try {
			String query = "SELECT * FROM atracciones";
			Connection conn= ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			ResultSet result= statement.executeQuery();
			
			List<Atraccion> atraccion = new LinkedList<Atraccion>(); 
			while(result.next()) {
				
				atraccion.add(toAtraccion(result));
			}
					
			return atraccion;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	public Atraccion findByName(String nombre) throws SQLException {
		String query = "SELECT * FROM atracciones WHERE NOMBRE LIKE ?";
		Connection conn= ConnectionProvider.getConnection();
		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, nombre);
		
		ResultSet result= statement.executeQuery();
		
		Atraccion atraccionR = null;
		if(result.next()) {
			atraccionR = toAtraccion(result);
		}
		
		return atraccionR;
	}
	
	public Atraccion find(Integer id) {
		try {
			String query = "SELECT * FROM atracciones WHERE atraccion_id LIKE ?";
			Connection conn= ConnectionProvider.getConnection();
			
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setInt(1, id);
			
			ResultSet result= statement.executeQuery();
			
			Atraccion atraccionId = null;
			if(result.next()) {
				atraccionId = toAtraccion(result);
			}
			
			return atraccionId;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
		
	}
	
	public int updateCupo(Atraccion atraccion, Connection conn) throws SQLException {
		String query = "UPDATE atracciones SET Cupo = ? WHERE NOMBRE LIKE ?";
		
		PreparedStatement statement = conn.prepareStatement(query);

		statement.setInt(1, atraccion.getCupo());
		statement.setString(2, atraccion.getNombre());

		return statement.executeUpdate();

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
		//	statement.setInt(i++, atraccion.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public static void main(String[] args) {
		List<Atraccion> atracciones =  new LinkedList<Atraccion>();
		AtraccionDaoImpl a = new AtraccionDaoImpl();
		atracciones.addAll(a.findAll());
		System.out.println(atracciones);
	}
		
}
