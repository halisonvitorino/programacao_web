<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@page import="metodosSQL.Carros"%>
<%@ page import="metodosSQL.UF"%>
<%@ page errorPage="aula5_jsp_erro/paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value="pt_BR" />
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<title>Alteração de Município/></title>
</head>

<body>
	
	
	<aside> <titulo>
	<h1>
		<marquee> <img src="resources/img/bandeira1.png"></img>ALTERAÇÃO... 
		<img src="resources/img/bandeira1.png"></img></marquee>
	</h1>
	</titulo> </aside>

	<fundo_menu_escolha1> 
	<c:if test="${carros == null}">
		<form action="../AlterarCarros" method="post">
			<fieldset>
			<legend><fmt:message key="carro.legenda"/></legend>
				
				<label for="idMunicipio"><fmt:message key="carro.codigo"/></label> 
				<input id="idCarro" type="text" name="idCarro" /> 
				
				<input type="hidden" name="logica" value="consultar" />
				
				<p><input id="Consultar" type="submit" value="<fmt:message key="geral.consultar"/>" /></p>
				
			</fieldset>
		</form>
		<p>
			<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
		</p>
	</c:if>
	 	
	 	
	 	
	 	<c:if test="${carros != null}">
		
		
		<form action="../AlterarCarros" method="post">
			<fieldset>
				<legend><fmt:message key="carro.legenda"/></legend>
				
				<label for="idCarro"><fmt:message key="carro.codigo"/></label> 
				<input id="idCarro" type="text" name="idCarro" value="${municipio.idMunicipio}" /> 
				
				<label for="nomeCarro"><fmt:message key="carro.nome"/></label>
				<input id="nomeCarro" type="text" name="nomeCarro" value="${municipio.nomeMunicipio}" />
				
				<label for="uf"><fmt:message key="carro.uf"/></label> 
				<select id="uf" name="uf">
					<%
						Carros mun = (Carros) request.getAttribute("municipio");
							for (UF x : UF.values())
								if (x.getCodigoUF().equals(mun.getUfCarros()))
									out.println("<option value=" + x.getCodigoUF()
											+ " selected>" + x.getCodigoUF() + "</option>");
								else
									out.println("<option value=" + x.getCodigoUF() + ">"
											+ x.getCodigoUF() + "</option>");
					%>
				</select> 
				
				<input type="hidden" name="logica" value="alterar" />
				
				<p><input id="Alterar" type="submit" value="<fmt:message key="geral.alterar"/>" /></p>
				
			</fieldset>
		</form>
		<p>
			<a href="../pagina01.html"><img src="../resources/img/voltar.gif" alt="<fmt:message key="geral.voltar"/>" width="42" height="42" border='0' /></a>
		</p>
	</c:if>
	
	<P>Alteração de Municipio</P>
	<%
	Carros carros = (Carros) request.getAttribute("carros");
	if (carros == null) {
	%>
		<form action="../AlterarMunicipio" method="post">
			IdCarros: <input type="text" name="idCarros"/> 
			<input type="hidden" name="logica" value="consultar"/>
			<input type="submit" value="Consultar"/>
		</form>
		<p>
			<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
		</p>
	<%
	}else{
	%>
		<form action="AlterarCarros" method="post" >
			IdMunicipio: <input	type="text" name="idCarros" value="<%=carros.getIdCarros()%>" /><br />
			<fmt:message key="carros.nome"/><input type="text" name="nomeCarros" value="<%=carros.getNomeCarros()%>" /><br />
			UF: <input type="text" name="ufCarros" value="<%=carros.getUfCarros() %>"/><br />
			<input type="hidden" name="logica" value="alterar"/>
	   		<input type="submit" value="Alterar"/>
		</form>
		<P><a href=pagina05.html><fmt:message key="geral.voltar"/></a></P>
	<%}%>
	 	
	 		
	</fundo_menu_escolha1>
	
		
	
</body>
</html>