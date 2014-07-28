<%
 request.setAttribute("ctx", request.getContextPath()); 
 %>

<div id="menuheader">
  	<span id="menutitle">Buscacoro menu 
      <a href="/<%=request.getContextPath()%>/xava/homeMenu.jsp" ><img src="/<%=request.getContextPath()%>/xava/images/home.gif"></a>
    </span>
  	<span id="menuPowerByMP">
      <a href="http://minuteproject.wikispaces.com" >powered by minuteProject</a>
       version 0.8.7 - 2014-05-29 17:46:45<br/>
	</span>		
</div>
