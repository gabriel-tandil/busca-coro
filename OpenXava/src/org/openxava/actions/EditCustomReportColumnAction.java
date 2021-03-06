package org.openxava.actions;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.inject.*;
import org.openxava.session.*;


/**
 * 
 * @author Javier Paniza 
 */

public class EditCustomReportColumnAction extends CollectionElementViewBaseAction  {
	
	@Inject
	private CustomReport customReport; 
	
	private int row;
		
	@SuppressWarnings("unchecked")
	public void execute() throws Exception {
		getCollectionElementView().clear(); 
		getCollectionElementView().setCollectionDetailVisible(true);
		Collection elements;
		Map keys = null;
		Map	values = null;
		getCollectionElementView().setCollectionEditingRow(getRow());
		CustomReportColumn column = customReport.getColumns().get(row); 
		getCollectionElementView().setModel(column); 
		getCollectionElementView().setValueNotifying("name", column.getName()); // To throw the change event  
		showDialog(getCollectionElementView());		
		if (getCollectionElementView().isCollectionEditable() || 
			getCollectionElementView().isCollectionMembersEditables()) 
		{ 
			addActions(getCollectionElementView().getSaveCollectionElementAction());
		}
		if (getCollectionElementView().isCollectionEditable()) { 
			addActions(getCollectionElementView().getRemoveCollectionElementAction());
		} 	
		Iterator itDetailActions = getCollectionElementView().getActionsNamesDetail().iterator();
		while (itDetailActions.hasNext()) {		
			addActions(itDetailActions.next().toString());			
		}
		addActions(getCollectionElementView().getHideCollectionElementAction());					
	}
	
	public int getRow() {
		return row;
	}

	public void setRow(int i) {
		row = i;
	}

}
