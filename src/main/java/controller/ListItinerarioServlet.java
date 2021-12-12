package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Sugerible;
import model.Usuario;
import services.ItinerarioService;

@WebServlet("/itinerario.do")
public class ListItinerarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = 226781629828058871L;
	private ItinerarioService itinerarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.itinerarioService = new ItinerarioService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario us = (Usuario) req.getSession().getAttribute("user");
		List<Sugerible> sugeribles;
		try {
			sugeribles = itinerarioService.list(us.getNombre());
			req.setAttribute("sugeribles", sugeribles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/itinerario.jsp");
		dispatcher.forward(req, resp);

	}

}
