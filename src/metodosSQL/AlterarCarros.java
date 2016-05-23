package metodosSQL;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AlterarCarros")
public class AlterarCarros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AlterarCarros() {
		super();
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	@Override
	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String alterar = new String(request.getParameter("logica"));
		if (alterar.equals("consultar")) {
			Carros carros = new Carros();
			carros.setIdCarros(new Integer(request.getParameter("idCarro")));
			try {
				CarrosDAO regDAO = new CarrosDAO();
				try {
					regDAO.consultar(carros);
					RequestDispatcher rd = request.getRequestDispatcher("../AlteracaoDeCarro.jsp");
					request.setAttribute("titulo", "Altera��o de Carro");
					request.setAttribute("carros", carros);
					rd.forward(request, response);
				} catch (Exception e) {
					PrintWriter out = response.getWriter();
					out.println("Erro de Altera��o.");
					e.printStackTrace();
				} finally {
					regDAO.finalize();
				}
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de abertura de conex�o.");
				e.printStackTrace();
			}
		} else if (alterar.equals("alterar")) {
			Carros carros = new Carros();
			carros.setIdCarros(new Integer(request.getParameter("idCarro")));
			carros.setNomeCarros(new String(request.getParameter("nomeCarro")));
			String ufCarros = new String(request.getParameter("uf"));
			carros.setUfCarros(ufCarros);
			try {
				CarrosDAO regDAO = new CarrosDAO();
				try {
					regDAO.alterar(carros);
					RequestDispatcher rd = request.getRequestDispatcher("../RespostaConsultaCarro.jsp");
					request.setAttribute("titulo", "Altera��o de Carros");
					request.setAttribute("carros", carros);
					rd.forward(request, response);
				} catch (Exception e) {
					PrintWriter out = response.getWriter();
					out.println("Erro de Altera��o.");
					e.printStackTrace();
				} finally {
					regDAO.finalize();
				}
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de abertura de conex�o.");
				e.printStackTrace();
			}
		}
	}
}