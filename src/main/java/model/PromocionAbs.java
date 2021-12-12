package model;

import java.util.List;



public class PromocionAbs extends Promocion {

	public PromocionAbs(String nombre,  String tipo, List<Atraccion> atraccionesDePromo, double precio, int id) {
		super(nombre, tipo, atraccionesDePromo,id);
		this.sumaCostos = precio;
		this.tiempoTotal = super.getTiempoTotal();
	}

	@Override
	public double getCosto() {
		return this.sumaCostos;
	}

}
