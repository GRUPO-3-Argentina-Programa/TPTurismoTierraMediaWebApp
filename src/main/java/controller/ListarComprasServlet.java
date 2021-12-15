package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import services.UsuarioService;

@WebServlet("/compras.adm")
public class ListarComprasServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -6770102606537294547L;
	private UsuarioService usuarioService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Usuario> usuarios = usuarioService.list();
		req.setAttribute("usuarios", usuarios);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/compras.jsp");
		dispatcher.forward(req, resp);

	}

}
