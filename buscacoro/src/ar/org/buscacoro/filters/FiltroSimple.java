package ar.org.buscacoro.filters;
 
import java.util.*;

import org.apache.commons.logging.*;
import org.openxava.filters.*;
 
/**
 * @author Gabriel Alvarez
 */
 
public class FiltroSimple extends BaseContextFilter {   
	private static Log log = LogFactory.getLog(FiltroSimple.class);
    public Object filter(Object o) throws FilterException {
        if (o == null) {
            return new Object [] { getValorFiltroSimple() };       
        }
        if (o instanceof Object []) {
            List c = new ArrayList(Arrays.asList((Object []) o));
            c.add(0, getValorFiltroSimple());                       
            return c.toArray();
        }
        else {
            return new Object [] { getValorFiltroSimple(), o };     
        }
    }
 
    private String getValorFiltroSimple() throws FilterException {
        try {
        	log.info("valor= %"+getString("valorFiltroSimple").toUpperCase()+"%");
        	
            return "%"+getString("valorFiltroSimple")+"%";       
        }
        catch (Exception ex) {
            ex.printStackTrace();
            throw new FilterException(
            "Imposible obtener valor de filtro simple asociado a esta sesión");
        }
    }
 
}