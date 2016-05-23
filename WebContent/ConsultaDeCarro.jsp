<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page errorPage="aula5_jsp_erro/paginaErro.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<fmt:setLocale value="pt_BR" />
<link rel="stylesheet" type="text/css" href="estilo1.css"/>
<title><fmt:message key="carro.titulo.consulta"/></title>
</head>

<body>

	<aside> <titulo>
				<h1>
					<marquee> <img src="resources/img/bandeira1.png"></img>ALTERAÇÃO... 
					<img src="resources/img/bandeira1.png"></img></marquee>
				</h1>
			</titulo> 
	</aside>

	<fundo_menu_escolha1> 
	
			<h1 class="nivel-um"><fmt:message key="carro.titulo.alteracao"/></h1>
				<form action="../ConsultarCarro" method="post">
					<fieldset>
						<legend><fmt:message key="carro.legenda"/></legend>
						
						<label for="idCarro"><fmt:message key="carro.codigo"/></label>
						<input id="idCarro" type="text" name="idCarro" />
						
						<p><input id="Consultar" type="submit" value="<fmt:message key="geral.consultar"/>" /></p>
						
					</fieldset>
				</form>
				<p>
					<a href="pagina05.html"><img src="resources/img/icon-voltar.png"	alt="Voltar" width="72" height="72" border='0' /></a>
				</p>
		</fundo_menu_escolha1> 
</body>

</html>