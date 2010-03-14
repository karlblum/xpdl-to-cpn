package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.PlaceNode;

/**
 * @model
 * @author michael
 */
public interface State extends EObject {
	/**
	 * @param instance
	 * @return
	 */
	Marking getMarking(Instance<PlaceNode> instance);

	/**
	 * @model containment="true"
	 * @return
	 */
	EList<Marking> getAllMarkings();
}
