<%@ include file="../imports.jsp"%>
 
<jsp:useBean id="context" class="org.openxava.controller.ModuleContext" scope="session"/>
 
<%
String tabObject = request.getParameter("tabObject");
tabObject = (tabObject == null || tabObject.equals(""))?"xava_tab":tabObject;
org.openxava.tab.Tab tab = (org.openxava.tab.Tab) context.get(request, tabObject);
String condition = tab.getBaseCondition()==null?"":tab.getBaseCondition();
String valor= (String) context.get(request, "valorFiltroSimple");
String action="openxava.executeAction('"+request.getParameter("application")+"', '"+request.getParameter("module")+"'," +
    "'', false, 'List.filter')";
String actionSetValor="openxava.executeAction('"+request.getParameter("application")+"', '"+request.getParameter("module")+"'," +
	    "'', false, 'FiltroSimple.establecerValor', 'valor='+this.value)";
%>

<b>Buscar:</b>&nbsp;<input name="<xava:id name='inputFiltroSimple'/>" style='margin-bottom: 6px' onchange="<%=actionSetValor%>" value="<%=valor%>"/>

<a href="javascript:<%=action%>" title=" - Filtrar">
<img id="ox_<%=request.getParameter("application")%>_<%=request.getParameter("module")%>__List___simpleFilter" class="ox-image-link" align="absmiddle" border="0" alt=" - Filtrar" src="<%=request.getContextPath()%>/xava/images/filter.gif">
</a>
 
<jsp:include page="listEditor.jsp"/>