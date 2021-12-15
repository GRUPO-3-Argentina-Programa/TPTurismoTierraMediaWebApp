package controller;

import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import services.TipoService;

@WebServlet("/crearTipo.adm")
public class CrearTipoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -7185735534501086281L;
    private TipoService tipoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/crearTipo.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");

		Tipo tipo = tipoService.create(nombre);
		resp.sendRedirect("listar.adm");

	}

}
