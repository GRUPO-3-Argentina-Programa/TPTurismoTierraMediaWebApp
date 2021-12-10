package persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Sugerible;
import model.Usuario;
import persistence.commons.ConnectionProvider;
import persistence.impl.AtraccionDaoImpl;
import persistence.impl.PromocionDaoImpl;

public class ItinerarioDao {
	
	
	public static int insert(Usuario usuario, Sugerible sugerencia, Connection conn) throws SQLException {
		String query = "INSERT INTO ITINERARIO (usuario, Atraccion, Promocion) VALUES (?, ?, ?)";
			
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, usuario.getNombre());
		if (!sugerencia.esPromo()) {
			statement.setInt(2, sugerencia.getId());
		} else {
			statement.setInt(3, sugerencia.getId());
		}
		
		return statement.executeUpdate();

	}
	
	public static List<Sugerible> getItinerario(String nombre) throws SQLException {
		String query = "SELECT * FROM ITINERARIO WHERE usuario LIKE ?";
		Connection conn= ConnectionProvider.getConnection();		
		PreparedStatement statement = conn.prepareStatement(query);
		
		statement.setString(1, nombre);
		
		ResultSet result= statement.executeQuery();
		
		List<Sugerible> itinerario = new LinkedList<Sugerible>();
		AtraccionDaoImpl atrd = new AtraccionDaoImpl();
		while(result.next()) {
			if(!result.getBoolean(2)) {
				PromocionDaoImpl prod = new PromocionDaoImpl();
				itinerario.add(prod.find(Integer.parseInt(result.getString(3))));
			} else {
				itinerario.add(atrd.find(Integer.parseInt(result.getString(2))));
			}
		}			
		return itinerario;
	}

}
