package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import utils.Crypt;

public class Usuario {
	
	private Integer id;
	private String nombre, passwordHash;
	private double presupuesto;
	private double tiempo;
	private String preferencia;
	public List<Sugerible> itinerario;
	protected double totalPagar;
	protected double totalTiempo;
	private Boolean admin;
	private HashMap<String, String> errors;
	private Boolean activo;

	public Usuario(Integer id, String nombre,
					String passwordHash, Boolean admin,
					int presupuesto, double tiempo, 
					String preferencia, Boolean activo) {
		this.id = id;
		this.nombre = nombre;
		this.passwordHash = passwordHash;
		this.admin = admin;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Sugerible>();
		this.activo = activo;
	}


	public Usuario(String nombre, String password,Boolean admin, Integer presupuesto, Double tiempo, String preferencia) {
		this.nombre = nombre;
		this.passwordHash = Crypt.hash(password);
		this.admin = admin;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		
	}

	public String getNombre() {
		return this.nombre;
	}

	public double getTiempo() {
		return this.tiempo;
	}

	public double getPresupuesto() {
		return this.presupuesto;
	}

	public String getPreferencia() {
		return this.preferencia;
	}

	public List<Sugerible> getItinerario() {
		return this.itinerario;
	}

	public void aceptarSugerencia(Sugerible sugerencia) {
		this.itinerario.add(sugerencia);
		this.setTiempo(sugerencia.getTiempoTotal());
		this.setPresupuesto(sugerencia.getCosto());
		this.totalPagar += sugerencia.getCosto();
		this.totalTiempo += sugerencia.getTiempoTotal();
	}
	
	public double getTotalPagar(List<Sugerible> itinerario) {
		double suma = 0;
		for (Sugerible s : itinerario) {
			suma += s.getCosto();
		}
		return suma;
	}
	
	public double getTotalTiempo(List<Sugerible> itinerario) {
		double tiempo = 0;
		for (Sugerible s : itinerario) {
			tiempo += s.getTiempoTotal();
		}
		return tiempo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre, presupuesto, tiempo, preferencia);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre) && presupuesto == other.presupuesto
				&& Double.doubleToLongBits(tiempo) == Double.doubleToLongBits(other.tiempo)
				&& preferencia == other.preferencia;
	}

	public boolean puedeComprar(Sugerible sugerencia) {
		return (this.leAlcanza(sugerencia) 
				&& this.tieneTiempo(sugerencia)
				&& (!estaIncluido(sugerencia)));
	}
	
	public boolean leAlcanza(Sugerible sugerencia) {
		return (sugerencia.getCosto() <= this.presupuesto);
	}
	
	public boolean tieneTiempo(Sugerible sugerencia) {
		return (sugerencia.getCosto() <= this.presupuesto);
	}
	
	

	private boolean estaIncluido(Sugerible buscado) {

	List<Atraccion> atracciones = new LinkedList<Atraccion>();
		for (Sugerible a : itinerario)
			if (a.esPromo())
				atracciones.addAll(a.getAtracciones());
			else
				atracciones.add((Atraccion) a);
			
		boolean encontrado = false;
		int i = 0;

		while (!encontrado && i < atracciones.size()) {
			if(buscado.esPromo()) {
				for(Atraccion a : buscado.getAtracciones())
					if (atracciones.get(i).getNombre().equals(a.getNombre()))
						encontrado = true; }
			else if (atracciones.get(i).getNombre().equals(buscado.getNombre()))
				encontrado = true;
			
			i++;
		}
		return encontrado;

	}

	public void setPresupuesto(double costo) {
		this.presupuesto -= costo;
	}

	public void setTiempo(double tiempo) {
		this.tiempo -= tiempo;

	}

	public Integer getId() {
		return id;
	}

	public String getPassword() {
		return passwordHash;
	}
	
	public boolean checkPassword(String password) {
		// this.password en realidad es el hash del password
		return Crypt.match(password, this.passwordHash);
	}
	
	public Boolean getAdmin() {
		return admin;
	}
	
	public Boolean isAdmin() {
		return admin;
	}
	
	public boolean isNull() {
		return false;
	}
	
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	
	public void setPresupuesto(Integer monedas) {
		this.presupuesto = monedas;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.passwordHash = Crypt.hash(password);
	}

	public void setTiempo(Double time) {
		this.tiempo = time;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo=" + tiempo + ", preferencia="
				+ preferencia +"]";
	}

	public boolean isValid() {
		validate();
		return errors.isEmpty();
	}
	
	public void validate() {
		errors = new HashMap<String, String>();

		if (presupuesto <= 0) {
			errors.put("presupuesto", "Debe ser positivo");
		}
		if (tiempo <= 0) {
			errors.put("tiempo", "Debe ser positivo");
		}
	}

	public Boolean esActivo() {
		return activo;
	}
}
