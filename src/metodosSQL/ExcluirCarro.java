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

@WebServlet("/ExcluirCarro")
public class ExcluirCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExcluirCarro() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carros carros = new Carros();
		carros.setIdCarros(new Integer(request.getParameter("idMunicipio")));
		try {
			CarrosDAO regDAO = new CarrosDAO();
			try {
				regDAO.excluir(carros);
				RequestDispatcher rd = request.getRequestDispatcher("/aula9_municipio/RespostaConsultaMunicipio.jsp");
				request.setAttribute("titulo", "Exclusão de Carro");
				request.setAttribute("municipio", carros);
				rd.forward(request, response);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de Alteração.");
				e.printStackTrace();
			} finally {
				regDAO.finalize();
			}
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("Erro de abertura de conexão.");
			e.printStackTrace();
		}
	}
}
