package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.PromocionService;

@WebServlet("/borrarPromocion.adm")
public class BorrarPromocionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PromocionService promocionService;

	
	@Override
	public void init() throws ServletException {
		super.init();
		this.promocionService = new PromocionService();
	}

	
 	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		promocionService.delete(id);

		RequestDispatcher dispatcher = getServletContext()
				.getRequestDispatcher("/listar.adm");
		dispatcher.forward(req, resp);
	}

	}
