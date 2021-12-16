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

@WebServlet("/editarUsuario.adm")
public class EditarUsuarioServlet extends HttpServlet implements Servlet {
	private static final long serialVersionUID = -7447534953866974348L;
	
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
		Integer id = Integer.parseInt(req.getParameter("id"));

		Usuario usuario = usuarioService.find(id);
		req.setAttribute("usuario", usuario);
		
		List<Tipo> tipos = tipoService.list();
		req.setAttribute("tipos", tipos);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/editarUsuario.jsp");
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
		Integer id = Integer.parseInt(req.getParameter("id"));
		Boolean activo = Boolean.parseBoolean(req.getParameter("activo"));

		Usuario usuario = usuarioService.update(nombre, password, admin, presupuesto, tiempo, preferencia, id, activo);
		if (usuario.isValid()) {
			resp.sendRedirect("/webAppTurismoTierraMedia/listar.adm");
		} else {
			req.setAttribute("usuario", usuario);
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/admin.jsp");
			dispatcher.forward(req, resp);
		}
	}

}
