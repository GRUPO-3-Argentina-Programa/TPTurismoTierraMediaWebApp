package persistence;

import java.sql.SQLException;
import java.util.List;

import model.Tipo;

public interface TipoDao {
	
	Tipo find(String nombre) throws SQLException;
	
	List<Tipo> findAll();

	int delete(String tipo);

	int insert(String nombre);
	
}
