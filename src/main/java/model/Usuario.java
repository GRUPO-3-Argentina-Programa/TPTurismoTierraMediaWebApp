package model;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import persistence.impl.UsuarioDaoImpl;
import utils.Crypt;

public class Usuario {
	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", presupuesto=" + presupuesto + ", tiempo=" + tiempo + ", preferencia="
				+ preferencia + ", TIEMPO=" + TIEMPO + ", PRESUPUESTO=" + PRESUPUESTO + "]";
	}

	private Integer id;
	private String nombre, passwordHash;
	private double presupuesto;
	private double tiempo;
	private String preferencia;
	public List<Sugerible> itinerario;
	private final double TIEMPO;
	private final double PRESUPUESTO;
	protected double totalPagar;
	protected double totalTiempo;
	private Boolean admin;

	public Usuario(Integer id, String nombre,
					String passwordHash, Boolean admin,
					int presupuesto, double tiempo, 
					String preferencia) {
		this.id = id;
		this.nombre = nombre;
		this.passwordHash = passwordHash;
		this.admin = admin;
		this.presupuesto = presupuesto;
		this.tiempo = tiempo;
		this.preferencia = preferencia;
		this.itinerario = new LinkedList<Sugerible>();
		this.TIEMPO = tiempo;
		this.PRESUPUESTO = presupuesto;
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

	public void aceptarSugerencia(Sugerible sugerencia) throws SQLException {
		this.itinerario.add(sugerencia);
		this.setTiempo(sugerencia.getTiempoTotal());
		this.setPresupuesto(sugerencia.getCosto());
		this.totalPagar += sugerencia.getCosto();
		this.totalTiempo += sugerencia.getTiempoTotal();
		UsuarioDaoImpl.guardar(this, sugerencia);
		UsuarioDaoImpl.update(this);
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
		return (sugerencia.getCosto() <= this.presupuesto && sugerencia.getTiempoTotal() <= this.tiempo
				&& (!estaIncluido(sugerencia)));
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

	public double getTIEMPO() {
		return TIEMPO;
	}

	public double getPRESUPUESTO() {
		return PRESUPUESTO;
	}

	public double getId() {
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

}
