<%@ taglib prefix="mp" tagdir="/WEB-INF/tags/common" %>
<%
 request.setAttribute("ctx", request.getContextPath()); 
 %>
<div class='portlet' style='margin: 4px'>

<div id="menuheader">
  	<span id="menutitle">Buscacoro menu 
      <a href="<%=request.getContextPath()%>/xava/homeMenu.jsp" ><img src="<%=request.getContextPath()%>/xava/images/home.gif"></a>
    </span>
  	<span id="menuPowerByMP">
      <a href="http://minuteproject.wikispaces.com" >powered by minuteProject</a>
       version 0.8.7 - 2014-05-29 17:46:45<br/>
	</span>		
</div>


<table id="menuTable" border="0" width="100%" cellspacing="0" cellpadding="0" style="margin-top: 2px;">
<tr>

<td>

<div id="searchbar">
<div class="menustyle" id="menu">
  <ul class="menubar" id="dmenu">
    <li class="topitem">
      <a href="#" onclick="return false;">
      Buscacoro
      </a>
	  <ul class="submenu">
        <li><a href="home.jsp?application=buscacoro&module=Ciudad" >Ciudad</a></li>
        <!--<li><hr color="black"></li>-->
        <li><a href="home.jsp?application=buscacoro&module=Coro" >Coro</a></li>
        <!--<li><hr color="black"></li>-->
        <li><a href="home.jsp?application=buscacoro&module=Pais" >Pais</a></li>
        <!--<li><hr color="black"></li>-->
        <li><a href="home.jsp?application=buscacoro&module=Provincia" >Provincia</a></li>
        <!--<li><hr color="black"></li>-->
        <li><a href="home.jsp?application=buscacoro&module=Recurso" >Recurso</a></li>
        <!--<li><hr color="black"></li>-->
        <li><a href="home.jsp?application=buscacoro&module=Tipo" >Tipo</a></li>
	  </ul>
	</li>
<!-- views -->
<!-- transfer entities -->

	
  </div>

</div>
</td>

</tr>
</table>

</div>

</div>

