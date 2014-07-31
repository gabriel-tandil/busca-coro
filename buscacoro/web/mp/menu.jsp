<%@ taglib prefix="mp" tagdir="/WEB-INF/tags/common" %>
<%
 request.setAttribute("ctx", request.getContextPath()); 
 %>
<div class='portlet' style='margin: 4px'>

<div id="menuheader">
  	<span id="menutitle">BuscaCoro 
      <a href="<%=request.getContextPath()%>" ><img src="<%=request.getContextPath()%>/xava/images/home.gif"></a>
    </span>
  	<span id="menuPowerByMP">
Buscador de Coros y Recursos Corales
	</span>		
</div>


<table id="menuTable" border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top: 2px;">
<tr>

<td>

<div id="searchbar">
<div class="menustyle" id="menu">
  <ul class="menubar" id="dmenu">
<!--     <li class="topitem"> -->
<!--       <a href="#" onclick="return false;"> -->
<!--       BuscaCoro -->
<!--       </a> -->
<!-- 	  <ul class="submenu"> -->
        <li class="topitem"><a href="<%=request.getContextPath()%>/xava/home.jsp?application=buscacoro&module=ConsultaCoro" >Coro</a></li>
        <li class="topitem"><a href="<%=request.getContextPath()%>/xava/home.jsp?application=buscacoro&module=ConsultaRecurso" >Recurso Coral</a></li>
<!-- 	  </ul> -->
<!-- 	</li> -->
<!-- views -->
<!-- transfer entities -->

	
  </div>

</div>
</td>

</tr>
</table>

</div>

</div>

