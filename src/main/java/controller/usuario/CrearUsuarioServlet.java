package controller.usuario;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Tipo;
import model.Usuario;
import services.TipoService;
import services.UsuarioService;


@WebServlet("/crearUsuario.adm")
public class CrearUsuarioServlet extends HttpServlet implements Servlet {

	private static final long serialVersionUID = -1047363622015119142L;

	private UsuarioService usuarioService;
	private TipoService tipoService;

	@Override
	public void init() throws ServletException {
		super.init();
		this.usuarioService = new UsuarioService();
		this.tipoService = new TipoService();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		List<Tipo> tipos = tipoService.list();
		req.setAttribute("tipos", tipos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createU.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nombre = req.getParameter("nombre");
		String password = req.getParameter("password");
		Boolean admin = Boolean.parseBoolean(req.getParameter("admin"));
		Integer presupuesto = Integer.parseInt(req.getParameter("presupuesto"));
		Double tiempo = Double.parseDouble(req.getParameter("tiempo"));
		String preferencia = req.getParameter("preferencia");

		Usuario usuario = usuarioService.create(nombre, password, admin, presupuesto, tiempo, preferencia);
		if (usuario.isValid()) {
			resp.sendRedirect("listar.adm");
		} else {
			req.setAttribute("usuario", usuario);

			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/createU.jsp");
			dispatcher.forward(req, resp);
		}

	}

}
