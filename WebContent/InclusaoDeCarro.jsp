<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page import="metodosSQL.UF"%>
<%@ page errorPage="aula5_jsp_erro/paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value="pt_BR" />
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<title><fmt:message key="carro.titulo.inclusao"/></title>
</head>

<body>

<aside> <titulo>
	<h1>
		<marquee> <img src="resources/img/bandeira1.png"></img>INCLUSÃO... 
		<img src="resources/img/bandeira1.png"></img></marquee>
	</h1>
	</titulo> </aside>

	<fundo_menu_escolha1> 
				<h1 class="nivel-um"><fmt:message key="carro.titulo.inclusao"/></h1>
			
				<form action="../IncluirCarro" method="post">
					<fieldset>
						<legend><fmt:message key="carro.legenda"/></legend>
						
						<label for="idCarro"><fmt:message key="carro.codigo"/></label> 
						<input type="text" id="idCarro"	name="idCarro" /> <br/>
						
						<label for="nomeCarro"><fmt:message key="carro.nome"/></label> 
						<input type="text" id="nomeCarro" name="nomeCarro" /> <br/>
						
						<label for="uf"><fmt:message key="carro.uf"/></label> 
						<select id="uf" name="uf">
							<%for (UF x : UF.values())
									out.println("<option value=" + x.getCodigoUF() + ">"
											+ x.getCodigoUF() + "</option>");%>
						</select><br/>
						
						<p><input id="enviar" type="submit" value="<fmt:message key="geral.incluir"/>" /></p>
					</fieldset>
				</form>
				<p>
						<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
					</p>
	</fundo_menu_escolha1> 
</body>
</html>