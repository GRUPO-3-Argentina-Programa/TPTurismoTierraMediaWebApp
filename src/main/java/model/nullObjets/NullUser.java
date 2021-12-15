package model.nullObjets;

import model.Usuario;

public class NullUser extends Usuario {
	
	public static Usuario build() {
		return new NullUser();
	}
	
	public NullUser() {
		super(0, "", "",false, 0, 0.0, "",false);
	}
	
	public boolean isNull() {
		return true;
	}

}
