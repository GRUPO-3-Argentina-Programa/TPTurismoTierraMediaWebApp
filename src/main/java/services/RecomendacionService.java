package services;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Atraccion;
import model.Ofertador;
import model.Promocion;
import model.Sugerible;
import model.Usuario;

public class RecomendacionService {
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	Ofertador ofertador = new Ofertador();
	
	public List<Sugerible> list(Usuario us) throws IOException, SQLException {
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
		
		List<Promocion> promociones = promocionService.list();
		List<Atraccion> atracciones = atraccionService.list();
		
		List<Sugerible> sugerencias = new LinkedList<Sugerible>(atracciones);
		sugerencias.addAll(promociones);
		ofertador.ofertar(us, sugerencias);
		
		return sugerencias;
	}
	
}
