package model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class Atraccion implements Sugerible {
 	private Double costeDeVisita;
	private Double promedioDeTiempo;
	private Integer cupoDePersonas;
	private String nombre;
	private String tipo;
	private Integer idAtraccion;
	private HashMap<String, String> errors;
	private String descripcion;
	private Boolean activo;

	public Atraccion(String nombre, double costo,  String tipo, double tiempo, int cupo, int id, boolean activo, String descripcion) {
		this.nombre = nombre;
		this.costeDeVisita = costo;
		this.promedioDeTiempo = tiempo;
		this.cupoDePersonas = cupo;
	    this.tipo = tipo;
	    this.idAtraccion = id;
	    this.activo = activo;
	    this.descripcion = descripcion;
	}
	public Atraccion(String nombre, double costo,  String tipo, double tiempo, int cupo, String descripcion) {
		this.nombre = nombre;
		this.costeDeVisita = costo;
		this.promedioDeTiempo = tiempo;
		this.cupoDePersonas = cupo;
	    this.tipo = tipo;
	    this.descripcion = descripcion;
	}
	
	
	public Atraccion (String nombre, Double costo, String tipo, Double tiempo, Integer cupo, Integer id, String descripcion) {
	this.nombre = nombre;
	this.costeDeVisita = costo;
	this.promedioDeTiempo = tiempo;
	this.cupoDePersonas = cupo;
    this.tipo = tipo;
    this.idAtraccion = id;
    this.descripcion = descripcion;
	}
	
	public int getId() {
		return idAtraccion;
	}

	public String getTipoAtraccion() {
		return tipo;
	}

	public double getCosto() {
		return costeDeVisita;
	}

	@Override
	public String toString() {
		return "\n Atraccion: " + nombre + ", Costo: " + costeDeVisita + ", Tiempo: " + promedioDeTiempo + ", Tipo: "
				+ tipo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(costeDeVisita, cupoDePersonas, nombre, promedioDeTiempo, tipo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atraccion other = (Atraccion) obj;
		return costeDeVisita == other.costeDeVisita && cupoDePersonas == other.cupoDePersonas
				&& Objects.equals(nombre, other.nombre)
				&& Double.doubleToLongBits(promedioDeTiempo) == Double.doubleToLongBits(other.promedioDeTiempo)
				&& tipo == other.tipo;
	}

	
	public double getTiempoTotal() {
		return promedioDeTiempo;
	}

	public int getCupo() {
		return this.cupoDePersonas;
	}

	public void restarCupo() {
		this.cupoDePersonas--;
	}

	public String getNombre() {
		return this.nombre;
	}


	public boolean hayCupo() {
		return (this.getCupo() >= 1);
	}


	public boolean esPromo() {
		return false;
	}

	
	public List<Atraccion> getAtracciones() {
		return null;
	}

	public String[] getNombresDeAtracciones() {
		return null;
	}

	
	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (costeDeVisita <= 0) {
			errors.put("costo", "Debe ser positivo");
		}
		if (promedioDeTiempo <= 0) {
			errors.put("duration", "Debe ser positivo");
		}
		if (cupoDePersonas <= 0) {
			errors.put("capacity", "Debe ser positivo");
		}
	}
	
	public Map<String, String> getErrors() {
		return errors;
	}

	public void setNombre(String nombre2) {
		this.nombre = nombre2;
		
	}

	public void setCosto(Double costo) {
	this.costeDeVisita= costo;
		
	}

	public void setTiempo(Double tiempo) {
		this.promedioDeTiempo= tiempo;
	}

	public void setCupo(Integer cupo) {
		this.cupoDePersonas= cupo;
		
	}
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public void borrar(int id) {
		this.activo = false;
	}
	
	public boolean esActivo() {
		return activo;
	}
	
	public void setActivo() {
		this.activo = true;
	}
	
	
	public void setTipo(String tipo2) {
		this.tipo = tipo2;
	}
	
}


