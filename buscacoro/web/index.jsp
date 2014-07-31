
<%@ include file="xava/imports.jsp"%>

<%
if (request.getAttribute("style") == null) {	
	request.setAttribute("style", org.openxava.web.style.Style.getInstance());
}
%>

<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
<jsp:useBean id="style" class="org.openxava.web.style.Style" scope="request"/>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" >
<head>
	<title>BuscaCoro</title>
	<link href="<%=request.getContextPath()%>/xava/style/<%=style.getCssFile()%>" rel="stylesheet" type="text/css"> 
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/xava/style/mp.css" />	
</head>
<body bgcolor="#ffffff">
	<%-- layer for menu--%>
	<div id="menu">
		<%@ include file="mp/menu.jsp"%>
	</div>
	<div id="informacion">
	<h1>!Feliz Cumplea&ntilde;os Pap&aacute;!</h1>
	<p>&nbsp;&nbsp;El Gran Buscador de Coros y Recursos Corales.</p>
	<p>&nbsp;&nbsp;Use el men&uacute; superior para acceder a buscar Coros o Recursos Corales.</p>
	<p>&nbsp;&nbsp;Para agregar su coro o recurso contactese con <a href="mailto:gabriel.tandil@gmail.com">el administrador</a>.</p>
	</div>
	<div id="content">
		<%@ include file="mp/footer.jsp"%>
	</div>
</body>
</html>	
