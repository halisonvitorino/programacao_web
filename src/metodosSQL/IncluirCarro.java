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

@WebServlet("/IncluirCarro")
public class IncluirCarro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public IncluirCarro() {
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
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Carros registro = new Carros();
		registro.setIdCarros(new Integer(request.getParameter("idCarro")));
		registro.setNomeCarros(new String(request.getParameter("nomeCarro")));
		// registro.setUfMunicipio(new String(request.getParameter("ufMunicipio")));
		String ufSel = new String(request.getParameter("uf"));
		registro.setUfCarros(ufSel);
		// for (UF uf : UF.values())
		// if (ufSel.equals(uf.getCodigoUF()))
		// municipio.setUfMunicipio(uf.getCodigoUF());
		try {
			CarrosDAO regDAO = new CarrosDAO();
			try {
				regDAO.incluir(registro);
				RequestDispatcher rd = request.getRequestDispatcher("../RespostaConsultaCarro.jsp");
				request.setAttribute("titulo", "Inclusão de Carro");
				request.setAttribute("carros", registro);
				rd.forward(request, response);
			} catch (Exception e) {
				PrintWriter out = response.getWriter();
				out.println("Erro de Inclusão.");
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