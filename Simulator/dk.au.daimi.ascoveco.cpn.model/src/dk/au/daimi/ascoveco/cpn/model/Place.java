package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface Place extends PlaceNode {
	/**
	 * @model containment="false" type="RefPlace"
	 * @return all references to this place
	 */
	EList<RefPlace> getReferences();
}
