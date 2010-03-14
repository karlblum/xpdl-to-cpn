package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface CPNProduct extends CPNType {
	/**
	 * @return types we are product of
	 * @model type="String" unique="false"
	 */
	public EList<String> getTypes();

	/**
	 * @param type new type to add to product
	 */
	public void addType(String type);
}
