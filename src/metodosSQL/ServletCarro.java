package metodosSQL;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletCarro() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		log("Iniciando a servlet");
	}

	public void destroy() {
		super.destroy();
		log("Destruindo a servlet");
	}

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		try {
			CarrosDAO regDAO = new CarrosDAO();
			try {
				Carros registro = new Carros();
				
				registro.setIdCarros(new Integer(request.getParameter("idCarro")));
				registro.setNomeCarros(new String(request.getParameter("nomeCarro")));
				registro.setModeloCarros(new String(request.getParameter("modeloCarro")));
				registro.setUfCarros(new String(request.getParameter("uf")));
				
				regDAO.incluir(registro);
				
				RequestDispatcher rd = request.getRequestDispatcher("../RespostaConsultaCarro.jsp");
				request.setAttribute("carros", registro);
				rd.forward(request, response);
				
			} catch (Exception e) {
				out.println("Erro de Inclusão.");
				e.printStackTrace();
			} finally {
				regDAO.finalize();
			}
		} catch (Exception e) {
			out.println("Erro de abertura de conexão.");
			e.printStackTrace();
		}
	}
}
