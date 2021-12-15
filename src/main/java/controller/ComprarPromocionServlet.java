package controller;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import persistence.commons.DAOFactory;
import services.ComprarPromocionService;

@WebServlet("/comprarPromo.do")
public class ComprarPromocionServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = 4377625632327861982L;
	
private ComprarPromocionService comprarService;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.comprarService = new ComprarPromocionService();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Integer promocionId = Integer.parseInt(req.getParameter("id"));
		Usuario user = (Usuario) req.getSession().getAttribute("user");
		Map<String, String> errors = comprarService.buy(user.getId(), promocionId);
		
		Usuario user2 = DAOFactory.getUserDAO().find(user.getId());
		req.getSession().setAttribute("user", user2);
		
		if (errors.isEmpty()) {
			req.setAttribute("flash", "¡Gracias por comprar!");
		} else {
			req.setAttribute("errors", errors);
			req.setAttribute("flash", "No ha podido realizarse la compra");
		}
		
//		resp.sendRedirect("/webAppTurismoTierraMedia/listar.do");

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/listar.do");
		dispatcher.forward(req, resp);
	}

}
