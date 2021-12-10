package persistence;

import model.Usuario;

public  interface UsuarioDao {
	
	public abstract Usuario findByUsername(String username);
}

