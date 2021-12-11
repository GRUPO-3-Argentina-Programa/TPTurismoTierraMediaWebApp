package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedList;
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
import services.RecomendacionService;

@WebServlet("/listar.do")
public class ListRecomendacionServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1180805945768674448L;
	private RecomendacionService recomendacionService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.recomendacionService = new RecomendacionService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Usuario us = (Usuario) req.getSession().getAttribute("user");
		List<Sugerible> recomendaciones = new LinkedList<Sugerible>();
		try {
			recomendaciones = recomendacionService.list(us);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		req.setAttribute("recomendaciones", recomendaciones);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/recomendacion.jsp");
		dispatcher.forward(req, resp);

	}

	
}
