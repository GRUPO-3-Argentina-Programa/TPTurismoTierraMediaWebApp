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
import model.Tipo;
import services.AtraccionService;
import services.TipoService;

@WebServlet("/crear.adm")
public class CrearAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtraccionService atraccionService;
	private TipoService tipoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		this.tipoService = new TipoService();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Tipo> tipos = tipoService.list();
		req.setAttribute("tipos", tipos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Create1.jsp");
		dispatcher.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		String tipo = req.getParameter("tipo");
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String descripcion = req.getParameter("descripcion");
//		Integer id = Integer.parseInt(req.getParameter("Id"));

		Atraccion atraccion = atraccionService.create(nombre, costo, tipo, tiempo, cupo, descripcion);
		if (atraccion.isValid()) {
			resp.sendRedirect("listar.adm");
		} else {
			req.setAttribute("atraccion", atraccion);
			
		

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Create1.jsp");
			dispatcher.forward(req, resp);
		}

	}

}