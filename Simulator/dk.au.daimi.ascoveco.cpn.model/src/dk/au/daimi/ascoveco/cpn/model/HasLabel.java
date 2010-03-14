package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael Addition compared to HLPN standard. Makes it possible to have reverse references for labels.
 */
public interface HasLabel extends EObject {
	/**
	 * @model containment="true" opposite="parent" type="Label"
	 * @return the labels of the object
	 */
	public EList<Label> getLabel();
}
