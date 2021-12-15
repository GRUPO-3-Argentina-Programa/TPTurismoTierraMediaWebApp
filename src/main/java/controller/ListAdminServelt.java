package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import model.Promocion;
import model.Tipo;
import model.Usuario;
import services.AtraccionService;
import services.PromocionService;
import services.TipoService;
import services.UsuarioService;


  @WebServlet("/listar.adm")
public class ListAdminServelt extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AtraccionService atraccionService;
	private PromocionService promocionService;
	private UsuarioService usuarioService;
	private TipoService tipoService;


	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
		this.atraccionService = new AtraccionService();
		this.usuarioService = new UsuarioService();
		this.tipoService = new TipoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Promocion> promociones = promocionService.list();
		req.setAttribute("promociones", promociones);
		
		List<Atraccion> atracciones = atraccionService.list();
		req.setAttribute("atracciones", atracciones);

		List<Usuario> usuarios = usuarioService.list();
		req.setAttribute("usuarios", usuarios);

		List<Tipo> tipos = tipoService.list();
		req.setAttribute("tipos", tipos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
		dispatcher.forward(req, resp);

	}
	
	


}