package org.openxava.web.servlets;

import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.swing.event.*;
import javax.swing.table.*;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.*;

import org.apache.commons.logging.*;
import org.openxava.hibernate.*;
import org.openxava.jpa.*;
import org.openxava.model.meta.*;
import org.openxava.tab.*;
import org.openxava.tab.impl.*;
import org.openxava.util.*;
import org.openxava.web.*;

/**
 * To generate automatically reports from list mode. <p>
 * 
 * Uses JasperReports.
 * 
 * @author Javier Paniza
 */

public class GenerateReportServlet extends HttpServlet {
	
	private static Log log = LogFactory.getLog(GenerateReportServlet.class);
	
	public static class TableModelDecorator implements TableModel {
							 
		private TableModel original;		
		private List metaProperties;
		private boolean withValidValues = false;
		private Locale locale;
		private boolean labelAsHeader = false;
		private HttpServletRequest request;
		private boolean format = false;	// format or no the values. If format = true, all values to the report are String
		private Integer columnCountLimit; 
		
		public TableModelDecorator(HttpServletRequest request, TableModel original, List metaProperties, Locale locale, boolean labelAsHeader, boolean format, Integer columnCountLimit) throws Exception { 
			this.request = request;
			this.original = original;
			this.metaProperties = metaProperties;
			this.locale = locale;
			this.withValidValues = calculateWithValidValues();
			this.labelAsHeader = labelAsHeader;			
			this.format = format;
			this.columnCountLimit = columnCountLimit;
		}

		private boolean calculateWithValidValues() {
			Iterator it = metaProperties.iterator();
			while (it.hasNext()) {
				MetaProperty m = (MetaProperty) it.next();
				if (m.hasValidValues()) return true;
			}
			return false;
		}
		
		private MetaProperty getMetaProperty(int i) {
			return (MetaProperty) metaProperties.get(i);
		}

		public int getRowCount() {			
			return original.getRowCount();
		}

		public int getColumnCount() {			
			return columnCountLimit == null?original.getColumnCount():columnCountLimit;
		}

		public String getColumnName(int c) {			
			return labelAsHeader?getMetaProperty(c).getLabel(locale):Strings.change(getMetaProperty(c).getQualifiedName(), ".", "_");
		}

		public Class getColumnClass(int c) {						
			return original.getColumnClass(c);
		}

		public boolean isCellEditable(int row, int column) {			
			return original.isCellEditable(row, column);
		}

		public Object getValueAt(int row, int column) {
			if (isFormat()) return getValueWithWebEditorsFormat(row, column);
			else return getValueWithoutWebEditorsFormat(row, column);
		}

		private Object getValueWithoutWebEditorsFormat(int row, int column){
			Object r = original.getValueAt(row, column);

			if (r instanceof Boolean) {
				if (((Boolean) r).booleanValue()) return XavaResources.getString(locale, "yes");
				return XavaResources.getString(locale, "no");
			}
			if (withValidValues) {
				MetaProperty p = getMetaProperty(column);
				if (p.hasValidValues()) {					
					return p.getValidValueLabel(locale, original.getValueAt(row, column));
				}
			}
			
			if (r instanceof java.util.Date) {				
				MetaProperty p = getMetaProperty(column); // In order to use the type declared by the developer 
					// and not the one returned by JDBC or the JPA engine				
				if (java.sql.Time.class.isAssignableFrom(p.getType())) {
					return DateFormat.getTimeInstance(DateFormat.SHORT, locale).format(r);
				}
				if (java.sql.Timestamp.class.isAssignableFrom(p.getType())) {
					DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
					return dateFormat.format( r );
				}
				return DateFormat.getDateInstance(DateFormat.SHORT, locale).format(r);
			}

			if (r instanceof BigDecimal) {
				return formatBigDecimal(r, locale); 
			}
			
			return r;
		}
		
		private Object getValueWithWebEditorsFormat(int row, int column){
			Object r = original.getValueAt(row, column);
			MetaProperty metaProperty = getMetaProperty(column);
			String result = WebEditors.format(this.request, metaProperty, r, null, "", true);
			if (isHtml(result)){	// this avoids that the report shows html content
				result = WebEditors.format(this.request, metaProperty, r, null, "", false);
			}
			return result;
		}
		
		public void setValueAt(Object value, int row, int column) {
			original.setValueAt(value, row, column);			
		}

		public void addTableModelListener(TableModelListener l) {
			original.addTableModelListener(l);			
		}

		public void removeTableModelListener(TableModelListener l) {
			original.removeTableModelListener(l);			
		}

		private boolean isHtml(String value){
			return value.matches("<.*>");
		}

		public boolean isFormat() {
			return format;
		}

		public void setFormat(boolean format) {
			this.format = format;
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try {				
			Locales.setCurrent(request); 
			if (Users.getCurrent() == null) { // for a bug in websphere portal 5.1 with Domino LDAP
				Users.setCurrent((String)request.getSession().getAttribute("xava.user"));
			}						
			request.getParameter("application"); // for a bug in websphere 5.1 
			request.getParameter("module"); // for a bug in websphere 5.1
			Tab tab = (Tab) request.getSession().getAttribute("xava_reportTab");			
			int [] selectedRowsNumber = (int []) request.getSession().getAttribute("xava_selectedRowsReportTab");
			Map [] selectedKeys = (Map []) request.getSession().getAttribute("xava_selectedKeysReportTab");
			int [] selectedRows = getSelectedRows(selectedRowsNumber, selectedKeys, tab);			
			request.getSession().removeAttribute("xava_selectedRowsReportTab");
			Integer columnCountLimit = (Integer) request.getSession().getAttribute("xava_columnCountLimitReportTab");
			request.getSession().removeAttribute("xava_columnCountLimitReportTab");
			
			setDefaultSchema(request);
			String user = (String) request.getSession().getAttribute("xava_user");
			request.getSession().removeAttribute("xava_user");
			Users.setCurrent(user);
			String uri = request.getRequestURI();				
			if (uri.endsWith(".pdf")) {
				InputStream is;
				JRDataSource ds;
				Map parameters = new HashMap();
				synchronized (tab) {
					tab.setRequest(request);
					parameters.put("Title", tab.getTitle());				
					parameters.put("Organization", getOrganization());
					parameters.put("Date", getCurrentDate());
					for (String totalProperty: tab.getTotalPropertiesNames()) { 								
						parameters.put(totalProperty + "__TOTAL__", getTotal(request, tab, totalProperty));
					}
					is  = getReport(request, response, tab, columnCountLimit); 
					ds = getDataSource(request, tab, selectedRows);
				}	
				JasperPrint jprint = JasperFillManager.fillReport(is, parameters, ds);					
				response.setContentType("application/pdf");	
				response.setHeader("Content-Disposition", "inline; filename=\"" + getFileName(tab) + ".pdf\""); 
				JasperExportManager.exportReportToPdfStream(jprint, response.getOutputStream());
				
			}
			else if (uri.endsWith(".csv")) {	
				String csvEncoding = XavaPreferences.getInstance().getCSVEncoding(); 
				if (!Is.emptyString(csvEncoding)) {
					response.setCharacterEncoding(csvEncoding);
				}
				response.setContentType("text/x-csv");
				response.setHeader("Content-Disposition", "inline; filename=\"" + getFileName(tab) + ".csv\""); 
				synchronized (tab) {
					tab.setRequest(request);
					response.getWriter().print(TableModels.toCSV(getTableModel(request, tab, selectedRows, true, false, columnCountLimit)));
				}
			}
			else {
				throw new ServletException(XavaResources.getString("report_type_not_supported", "", ".pdf .csv"));
			}			
		}
		catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new ServletException(XavaResources.getString("report_error"));
		}		
		finally {
			request.getSession().removeAttribute("xava_reportTab");
		}
	}

	private String getCurrentDate() {
		return java.text.DateFormat.getDateInstance(DateFormat.MEDIUM, Locales.getCurrent()).format(new java.util.Date());
	}

	private String getFileName(Tab tab) { 
		String now = new SimpleDateFormat("yyyyMMdd_HHmm").format(new Date());
		return tab.getTitle() + " " + now;
	}

	private Object getTotal(HttpServletRequest request, Tab tab, String totalProperty) {
		Object total = tab.getTotal(totalProperty);
		return WebEditors.format(request, tab.getMetaProperty(totalProperty), total, new Messages(), null, true);
	}

	private void setDefaultSchema(HttpServletRequest request) {
		String hibernateDefaultSchemaTab = (String) request.getSession().getAttribute("xava_hibernateDefaultSchemaTab");
		if (hibernateDefaultSchemaTab != null) {
			request.getSession().removeAttribute("xava_hibernateDefaultSchemaTab");
			XHibernate.setDefaultSchema(hibernateDefaultSchemaTab);
			
		}
		String jpaDefaultSchemaTab = (String) request.getSession().getAttribute("xava_jpaDefaultSchemaTab");
		if (jpaDefaultSchemaTab != null) {
			request.getSession().removeAttribute("xava_jpaDefaultSchemaTab");
			XPersistence.setDefaultSchema(jpaDefaultSchemaTab);			
		}
	}

	protected String getOrganization() throws MissingResourceException, XavaException {
		return ReportParametersProviderFactory.getInstance().getOrganization();
	}
	
	private InputStream getReport(HttpServletRequest request, HttpServletResponse response, Tab tab, Integer columnCountLimit) throws ServletException, IOException {		
		StringBuffer suri = new StringBuffer();
		suri.append("/xava/jasperReport");
		suri.append("?language="); 
		suri.append(Locales.getCurrent().getLanguage());		
		if (columnCountLimit != null) {
			suri.append("&columnCountLimit="); 
			suri.append(columnCountLimit);			
		}
		response.setCharacterEncoding(XSystem.getEncoding());
		return Servlets.getURIAsStream(request, response, suri.toString());
	}
	
	private JRDataSource getDataSource(HttpServletRequest request, Tab tab, int [] selectedRows) throws Exception { 
		return new JRTableModelDataSource(getTableModel(request, tab, selectedRows, false, true, null)); 
	}		  	
	
	private TableModel getTableModel(HttpServletRequest request, Tab tab, int [] selectedRows, boolean labelAsHeader, boolean format, Integer columnCountLimit) throws Exception { 
		TableModel data = null;
		if (selectedRows != null && selectedRows.length > 0) {
			data = new SelectedRowsXTableModel(tab.getTableModel(), selectedRows);
		}
		else {
			data = tab.getAllDataTableModel();
		}
		return new TableModelDecorator(request, data, tab.getMetaProperties(), Locales.getCurrent(), labelAsHeader, format, columnCountLimit);
	}
	
	private static Object formatBigDecimal(Object number, Locale locale) { 
		NumberFormat nf = NumberFormat.getNumberInstance(locale);
		nf.setMinimumFractionDigits(2);
		return nf.format(number);
	}

	private int[] getSelectedRows(int[] selectedRowsNumber, Map[] selectedRowsKeys, Tab tab){
		if (selectedRowsKeys == null || selectedRowsKeys.length == 0) return new int[0];
		// selectedRowsNumber is the most performant so we use it when possible
		else if (selectedRowsNumber.length == selectedRowsKeys.length) return selectedRowsNumber;
		else{			
			// find the rows from the selectedKeys
			
			// This has a poor performance, but it covers the case when the selected
			// rows are not loaded for the tab, something that can occurs if the user
			// select rows and afterwards reorder the list.
			try{
				int[] s = new int[selectedRowsKeys.length];
				List selectedKeys = Arrays.asList(selectedRowsKeys);
				int end = tab.getTableModel().getTotalSize();
				int x = 0;
				for (int i = 0; i < end; i++){
					Map key = (Map)tab.getTableModel().getObjectAt(i);
					if (selectedKeys.contains(key)){
						s[x] = i; 
						x++;
					}
				}	
				return s;
			}
			catch(Exception ex){
				log.warn(XavaResources.getString("fails_selected"), ex); 
				throw new XavaException("fails_selected");
			}
		}
	}
}
