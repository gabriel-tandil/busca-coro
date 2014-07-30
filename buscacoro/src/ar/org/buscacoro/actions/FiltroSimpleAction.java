package ar.org.buscacoro.actions;

import org.apache.commons.logging.*;
import org.openxava.actions.*;

/**
 * @author Gabriel Alvarez
 */

public class FiltroSimpleAction extends BaseAction  {
	private static Log log = LogFactory.getLog(FiltroSimpleAction.class);
	private String valor;
	
	public void execute() throws Exception {	
		getContext().put(getRequest(), "valorFiltroSimple", getValor());
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String string) {
    	log.info("estableciendo valor= "+string);		
		valor = string;
	}

}
