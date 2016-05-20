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
<link rel="stylesheet" type="text/css" href="../resources/css/styles.css" />
<title><fmt:message key="municipio.titulo.alteracao"/></title>
</head>

<body>
	<h1> Alteração </h1>
	
	<c:if test="${carros == null}">
		<form action="../AlterarCarros" method="post">
			<fieldset>
				<legend><fmt:message key="carros.legenda"/></legend>
				
				<label for="idCarros"><fmt:message key="carros.codigo"/></label> 
				<input id="idCarros" type="text" name="idCarros" /> 
				
				<input type="hidden" name="logica" value="consultar" />
				
				<p><input id="Consultar" type="submit" value="<fmt:message key="geral.consultar"/>" /></p>
				
			</fieldset>
		</form>
		<p>
			<a href="../pagina01.html"><img src="../resources/img/voltar.gif"	alt="Voltar" width="42" height="42" border='0' /></a>
		</p>
	</c:if>
	
	<c:if test="${carros != null}">
		<link rel="stylesheet" type="text/css" href="resources/css/styles.css" />
		
		<form action="AlterarCarros" method="post">
			<fieldset>
				<legend><fmt:message key="carros.legenda"/></legend>
				
				<label for="idCarros"><fmt:message key="carros.codigo"/></label> 
				<input id="idCarros" type="text" name="idCarros" value="${carros.idCarros}" /> 
				
				<label for="nomeCarros"><fmt:message key="carros.nome"/></label>
				<input id="nomeCarros" type="text" name="nomeCarros" value="${carros.nomeCarros}" />
				
				<label for="uf"><fmt:message key="carros.uf"/></label> 
				<select id="uf" name="uf">
					<%
						Carros mun = (Carros) request.getAttribute("carros");
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
		<P><a href=../pagina05.html><fmt:message key="geral.voltar"/></a></P>
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
</body>
</html>