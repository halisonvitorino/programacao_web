package metodosSQL;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName = "/ValidaLogin", 
servletNames = {"IncluirCarro", 
		"AlterarCarro", 
		"ExcluirCarro", 
		"ConsultarCarro"},
urlPatterns = {"../InclusaoDeCarro.jsp",
		"../AlteracaoDeCarro.jsp",
		"../ExclusaoDeCarro.jsp",
		"../ConsultaDeCarro.jsp",
		"../RespostaConsultaCarro.jsp",
		"../RespostaListaCarro.jsp"})
public final class ValidaLogin implements Filter {

	public ValidaLogin() {
	}

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request2 = (HttpServletRequest) request;

		HttpSession session = request2.getSession();

		if (session.getAttribute("nome") != null
				&& request.getRemoteAddr().equals(session.getAttribute("ipusuario"))) {
			chain.doFilter(request, response);
		} else {
			HttpServletResponse response2 = (HttpServletResponse) response;
			response2.sendRedirect("../pagina01.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}
