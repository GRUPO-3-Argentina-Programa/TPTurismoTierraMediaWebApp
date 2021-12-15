package controller;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.TipoService;

@WebServlet("/borrarTipo.adm")
public class BorrarTipoServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -4264887825382408653L;
	private TipoService tipoService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.tipoService = new TipoService();
	}

	
 	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String tipo = req.getParameter("tipo");

		tipoService.delete(tipo);

		resp.sendRedirect("listar.adm");
	}

}
