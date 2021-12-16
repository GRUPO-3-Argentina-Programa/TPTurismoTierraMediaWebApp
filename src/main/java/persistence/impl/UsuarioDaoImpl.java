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
import persistence.UsuarioDao;
import persistence.commons.ConnectionProvider;
import persistence.commons.MissingDataException;

public class UsuarioDaoImpl implements UsuarioDao {

	public int insert(Usuario user) {
		try {
			String sql = "INSERT INTO Usuarios (nombre, passwordHash, admin, presupuesto, tiempoDisponible, preferencia) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			statement.setString(2, user.getPassword());
			if (user.getAdmin()) statement.setInt(3, 1);
			else statement.setInt(3, 0);
			statement.setDouble(4, user.getPresupuesto());
			statement.setDouble(5, user.getTiempo());
			statement.setString(6, user.getPreferencia());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	public int update(Usuario user) {
		try {
			String sql = "UPDATE Usuarios SET nombre = ?, passwordHash = ?,"
					+ "presupuesto = ?, tiempoDisponible = ?, "
					+ " preferencia = ?, activo = ? WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, user.getNombre());
			statement.setString(2, user.getPassword());
			statement.setDouble(3, user.getPresupuesto());
			statement.setDouble(4, user.getTiempo());
			statement.setString(5, user.getPreferencia());
			statement.setBoolean(6, user.esActivo());
			statement.setInt(7, user.getId());
			int rows = statement.executeUpdate();

			return rows;
		} catch (Exception e) {
			throw new MissingDataException(e);
		}
	}

	@Override
	public int delete (int id) {
		try {
			String sql = "UPDATE Usuarios SET activo = 0 WHERE id = ?";
			Connection conn = ConnectionProvider.getConnection();

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1, id);
			
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
		Connection conn = ConnectionProvider.getConnection();

		try {
			conn.setAutoCommit(false);
			ItinerarioDaoImpl.insert(usuario, sugerencia, conn);
			UsuarioDaoImpl usuarioDaoImpl = new UsuarioDaoImpl();
			usuarioDaoImpl.update(usuario);
			if (!sugerencia.esPromo()) {
				AtraccionDaoImpl.updateCupo((Atraccion) sugerencia);
			} else {
				PromocionDaoImpl.updateCupo((Promocion) sugerencia);
			}

		} catch (SQLException e) {
			System.out.println("No se pudo realizar la transaccion");
			conn.rollback();
		} finally {
			conn.commit();
		}
	}

	private Usuario toUsuario(ResultSet userRegister) throws SQLException {
		return new Usuario(userRegister.getInt(1), userRegister.getString(2), userRegister.getString(3),
				userRegister.getBoolean(4), userRegister.getInt(5), userRegister.getDouble(6),
				userRegister.getString(7), userRegister.getBoolean(8));
	}

	
}
