package controller;

import java.io.IOException;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Atraccion;
import services.AtraccionService;


@WebServlet("/atraccion/editar.adm")
public class EditarAtraccionServlet extends HttpServlet {
	
	
	
	private static final long serialVersionUID = -6382169226339328447L;
	private AtraccionService atraccionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
		
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		Atraccion atraccion = atraccionService.find(id);
		req.setAttribute("atraccion", atraccion);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editar.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Integer id = Integer.parseInt(req.getParameter("id"));
		String nombre = req.getParameter("nombre");
		Double costo = Double.parseDouble(req.getParameter("costo"));
		// Integer cost = req.getParameter("cost").trim() == "" ? null : Integer.parseInt(req.getParameter("cost"));
		String tipo = req.getParameter("tipo");
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		Integer cupo = Integer.parseInt(req.getParameter("cupo"));
		String descripcion = req.getParameter("descripcion");

		Atraccion atraccion = new Atraccion(nombre, costo, tipo, tiempo, cupo, descripcion);
		try {
			atraccion = atraccionService.update(nombre, costo, tipo, tiempo, cupo, descripcion);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		if (atraccion.isValid()) {
			resp.sendRedirect("/listar.adm");
		} else {
			req.setAttribute("atraccion", atraccion);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(req, resp);
		}
	}
}


  
