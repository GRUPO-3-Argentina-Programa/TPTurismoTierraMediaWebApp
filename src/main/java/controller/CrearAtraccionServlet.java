package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;

@WebServlet("/crear.do")
public class CrearAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin/Create1.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		String tipo = req.getParameter("tipo");
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
//		Integer id = Integer.parseInt(req.getParameter("Id"));

		Atraccion atraccion = atraccionService.create(nombre, costo, tipo, tiempo, cupo);
		if (atraccion.isValid()) {
			resp.sendRedirect("listar.adm");
		} else {
			req.setAttribute("atraccion", atraccion);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Create1.jsp");
			dispatcher.forward(req, resp);
		}

	}

}