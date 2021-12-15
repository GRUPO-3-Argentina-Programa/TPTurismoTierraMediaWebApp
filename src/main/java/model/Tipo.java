package model;

public class Tipo {
	private String nombre;
	private Boolean activo;
	
	public Tipo(String nombre, Boolean activo) {
		this.nombre = nombre;
		this.activo = activo;
	}
	
	public Tipo(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public Boolean esActivo() {
		return activo;
	}

}
