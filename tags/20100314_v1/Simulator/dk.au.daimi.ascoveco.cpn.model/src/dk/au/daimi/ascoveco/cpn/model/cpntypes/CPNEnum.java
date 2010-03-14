package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface CPNEnum extends CPNType {
	/**
	 * @return all allowed values
	 * @model type="String"
	 */
	public EList<String> getValues();

	/**
	 * @param value add an allowed value
	 */
	public void addValue(String value);
}
