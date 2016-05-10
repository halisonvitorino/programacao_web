package src;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import src.Usuario;
import src.LoginDAO;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		Usuario usuario = new Usuario();
		LoginDAO dao;
		String pagina = null;

		// Recebe parametros do usuario
		if (request.getParameter("usuario") != null && request.getParameter("senha") != null) {
			try {
				dao = new LoginDAO();
				usuario = dao.validaLogin(request.getParameter("nome"));

				if (usuario.getSenha().equals(request.getParameter("senha"))) {
					System.out.println("Usuário \"" + usuario.getUsuario() + "\" logado com sucesso!");
					
					session.setAttribute("usuarioLogado", usuario);
					request.setAttribute("nome", usuario);
					pagina = "pagina02.html";
					System.out.println(pagina);
				} else {
					System.out.println("Dados informados invalidos!");
					pagina = "pagina01.html";
				}

			} catch (SQLException e) {

				System.out.println("catch: " + pagina);
			}

		} else {
			pagina = "pagina01.html";
			System.out.println("else: " + pagina);
		}
		System.out.println("forward: " + pagina);
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);

	}

}
