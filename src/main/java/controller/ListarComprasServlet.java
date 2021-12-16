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
import services.UsuarioService;

@WebServlet("/compras.adm")
public class ListarComprasServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -6770102606537294547L;
	private UsuarioService usuarioService;
	private ItinerarioService itinerarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.itinerarioService = new ItinerarioService();
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario us = (Usuario) req.getSession().getAttribute("user");
		List<Usuario> usuarios = usuarioService.list();
		req.setAttribute("usuarios", usuarios);
		
		List<Sugerible> sugeribles;
		try {
			sugeribles = itinerarioService.list(us.getNombre());
			req.setAttribute("sugeribles", sugeribles);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/compras.jsp");
		dispatcher.forward(req, resp);

	}

}
