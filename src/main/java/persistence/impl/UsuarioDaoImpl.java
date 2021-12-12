package persistence.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Promocion;
import model.Sugerible;
import model.Usuario;
import model.nullObjets.NullUser;
import persistence.ItinerarioDao;
import persistence.UsuarioDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;


public class UsuarioDaoImpl implements UsuarioDao {

	public int insert(Usuario user) {
		try {
			String sql = "INSERT INTO Usuarios (nombre, passwordHash) VALUES (?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			statement.setString(2, user.getPassword());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public static int update(Usuario user) {
		try {
			String sql = "UPDATE Usuarios SET presupuesto = ?, tiempoDisponible = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setDouble(1, user.getPresupuesto());
			statement.setDouble(2, user.getTiempo());
			statement.setDouble(3, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int delete(Usuario user) {
		try {
			String sql = "DELETE FROM Usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario findByUsername(String username) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE nombre = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, username);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public Usuario find(Integer id) {
		try {
			String sql = "SELECT * FROM Usuarios WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultados = statement.executeQuery();

			Usuario user = NullUser.build();

			if (resultados.next()) {
				user = toUsuario(resultados);
			}

			return user;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int countAll() {
		try {
			String sql = "SELECT COUNT(1) AS TOTAL FROM Usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			resultados.next();
			int total = resultados.getInt("TOTAL");

			return total;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public List<Usuario> findAll() {
		try {
			String sql = "SELECT * FROM Usuarios";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultados = statement.executeQuery();

			List<Usuario> usuarios = new LinkedList<Usuario>();
			while (resultados.next()) {
				usuarios.add(toUsuario(resultados));
			}

			return usuarios;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}
	
	public static void guardar(Usuario usuario, Sugerible sugerencia) throws SQLException {
		Connection conn= ConnectionProvider.getConnection();
		
		try {
			conn.setAutoCommit(false);
			ItinerarioDao.insert(usuario, sugerencia, conn);
			UsuarioDaoImpl.update(usuario);
			if(!sugerencia.esPromo()) {
				AtraccionDaoImpl.updateCupo((Atraccion) sugerencia);
			} else {
				PromocionDaoImpl prod = new PromocionDaoImpl();
				prod.updateCupo((Promocion) sugerencia, conn);
			}
			
		} catch (SQLException e) {
			System.out.println("No se pudo realizar la transaccion");
			conn.rollback();
		} finally {
			conn.commit();
		}
	}

	private Usuario toUsuario(ResultSet userRegister) throws SQLException {
		return new Usuario(userRegister.getInt(1), userRegister.getString(2), 
							userRegister.getString(3), userRegister.getBoolean(4),
							userRegister.getInt(5), userRegister.getDouble(6),
							userRegister.getString(7));
	}

}
