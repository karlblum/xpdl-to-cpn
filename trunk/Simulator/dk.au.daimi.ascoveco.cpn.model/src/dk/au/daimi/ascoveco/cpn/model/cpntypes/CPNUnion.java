package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author keblov
 */
public interface CPNUnion extends CPNType {
	/**
	 * @return all elements of unit
	 * @model required="true" type="NameTypePair" containment="true"
	 */
	public EList<NameTypePair> getValues();

	/**
	 * @param id constructor
	 * @param name name of type
	 */
	public void addValue(String id, String name);

}
