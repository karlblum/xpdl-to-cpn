package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface CPNRecord extends CPNType {
	/**
	 * @return all elements of record
	 * @model required="true" type="NameTypePair" containment="true"
	 */
	public EList<NameTypePair> getValues();

	/**
	 * @param id record id
	 * @param name name of type
	 */
	public void addValue(String id, String name);
}
