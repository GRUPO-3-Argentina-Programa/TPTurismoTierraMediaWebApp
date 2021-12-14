package model;

import java.util.List;



public class PromocionAbs extends Promocion {

	public PromocionAbs(String nombre,  String tipo, List<Atraccion> atraccionesDePromo, double precio, int id, Boolean activo) {
		super(nombre, tipo, atraccionesDePromo,id, activo);
		this.sumaCostos = precio;
		this.tiempoTotal = super.getTiempoTotal();
	}

	@Override
	public double getCosto() {
		return this.sumaCostos;
	}

}
