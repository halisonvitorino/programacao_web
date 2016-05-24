<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.Map.Entry"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="metodosSQL.Carros"%>
<%@ page errorPage="aula5_jsp_erro/paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value="pt_BR" />
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<title><c:out value='${titulo}' /></title>
</head>
<body>

	<aside> <titulo>
	<h1>
		<marquee> <img src="resources/img/bandeira1.png"></img>RESPOSTA... 
		<img src="resources/img/bandeira1.png"></img></marquee>
	</h1>
	</titulo> </aside>

	<fundo_menu_escolha1> 
					<c:if test="${carros != null}">
						<h1 class="nivel-um">
							<c:out value='${titulo}' />
						</h1>
						<fieldset>
							<legend>
								<fmt:message key="carro.legendaparcial"/> <c:out value='${titulo}' />
							</legend>
							<table>
								<tr>
									<td><fmt:message key="carro.codigo"/></td>
									<td><fmt:message key="carro.nome"/></td>
									<td><fmt:message key="carro.mod"/></td>
									<td><fmt:message key="carro.uf"/></td>
								</tr>
								<c:forEach var='item' items='${carros}'>
									<tr>
										<td><c:out value='${item.getValue().idCarro}' /></td>
										<td><c:out value='${item.getValue().nomeCarro}' /></td>
										<td><c:out value='${item.getValue().nomeModelo}' /></td>
										<td><c:out value='${item.getValue().ufCarro}' /></td>
									</tr>
								</c:forEach>
							</table>
						</fieldset>
					</c:if>
					<c:if test="${carros == null}">
						<c:out value="<fmt:message key="geral.alertaDados"/>" />
					</c:if>
					<p>
						<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
						</p>
					
					
				<P>Listagem de Carros</P>
				<table>
					<%List<Carros> registros = (List<Carros>) request.getAttribute("carros");%>
				    <tr>
				    	<td>Id</td><td>Nome</td><td>Modelo</td><td>UF</td>
				 	</tr>
				 	<%for (Carros carro : registros ) {	%>
					     <tr>
					     	<td><%out.println(carro.getIdCarros());%></td>
						  	<td><%out.println(carro.getNomeCarros());%></td>
						  	<td><%out.println(carro.getModeloCarros());%></td>
						 	<td><%out.println(carro.getUfCarros());%></td>
						 </tr>
					<%}%>
				</table>
					<p>
						<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
						</p>
		</fundo_menu_escolha1> 
</body>
</html>