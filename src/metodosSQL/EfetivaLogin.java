package metodosSQL;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EfetivaLogin")
public class EfetivaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public EfetivaLogin() {
		super();
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Usuario usuario = new Usuario();
		usuario.setChaveUsuario(new String(request.getParameter("chaveInformada")));
		usuario.setSenhaUsuario(new String(request.getParameter("senhaInformada")));
		try {
			if (!usuario.getChaveUsuario().isEmpty() && !usuario.getSenhaUsuario().isEmpty()) {
				Usuario registro = new Usuario();
				registro.setChaveUsuario("guest");
				registro.setSenhaUsuario("guest");
			
				if (usuario.equals(registro)) {
					HttpSession session = request.getSession();
					session.setAttribute("usuario", new String(usuario.getChaveUsuario()));
					session.setAttribute("ipusuario", new String(request.getRemoteAddr()));
					RequestDispatcher rd = request.getRequestDispatcher("pagina05.html");
					rd.forward(request, response);
				} else {
					throw (new Exception("Login inválidos!"));
				}
			} else {
				throw (new Exception("Dados vazios!"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("../pagina01.jsp");
		}
	}
}