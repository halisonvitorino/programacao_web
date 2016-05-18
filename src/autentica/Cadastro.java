package autentica;

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
import javax.swing.JOptionPane;

import autentica.LoginDAO;
import autentica.Usuario;

@WebServlet("/Cadastro")
public class Cadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher;
		HttpSession session = request.getSession(true);
		Usuario usuario = new Usuario();
		LoginDAO dao;
		String pagina = null;
		System.out.println(request.getParameter("nome"));
		System.out.println(request.getParameter("senha"));
		System.out.println(request.getParameter("email"));
		System.out.println(request.getParameter("datanasci"));
		System.out.println(request.getParameter("telefone"));
		
		// Recebe parametros do usuario
		if (request.getParameter("nome") != null && request.getParameter("senha") != null && request.getParameter("email") != null
				&& request.getParameter("datanasci") != null && request.getParameter("datanasci") != null) {
			try {
				dao = new LoginDAO();
				usuario = dao.cadastraUser(request.getParameter("nome"),request.getParameter("senha"),request.getParameter("email"),request.getParameter("datanasci"), request.getParameter("telefone"));		
					 
					pagina = "pagina01.html";
					
				

			} catch (SQLException e) {

				System.out.println("catch: " + pagina);
			}

		} else {
			pagina = "paginaErro.html";
			System.out.println("else: " + pagina);
			System.out.println("Usuario não cadastrado: ");
		}
		System.out.println("forward: " + pagina);
		dispatcher = request.getRequestDispatcher(pagina);
		dispatcher.forward(request, response);

	}

}