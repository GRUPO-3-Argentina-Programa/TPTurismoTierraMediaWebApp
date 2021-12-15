package controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import services.AtraccionService;


@WebServlet("/atraccion/borrar.adm")
public class BorrarAtraccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AtraccionService atraccionService;

	
	@Override
	public void init() throws ServletException {
		super.init();
		this.atraccionService = new AtraccionService();
	}

	
 	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = Integer.parseInt(req.getParameter("id"));

		atraccionService.delete(id);
		
		resp.sendRedirect("/webAppTurismoTierraMedia/listar.adm");

//		RequestDispatcher dispatcher = getServletContext()
//				.getRequestDispatcher("/webAppTurismoTierraMedia/listar.adm");
//		dispatcher.forward(req, resp);
	}

	}



