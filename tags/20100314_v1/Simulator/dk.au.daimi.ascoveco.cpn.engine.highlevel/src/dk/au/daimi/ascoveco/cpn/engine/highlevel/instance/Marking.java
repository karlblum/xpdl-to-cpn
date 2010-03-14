package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.PlaceNode;

/**
 * @model
 * @author mw
 */
public interface Marking extends EObject {
	/**
	 * @model containment="true"
	 * @return
	 */
	Instance<PlaceNode> getPlaceInstance();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getPlaceInstance <em>Place Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Place Instance</em>' containment reference.
	 * @see #getPlaceInstance()
	 * @generated
	 */
	void setPlaceInstance(Instance<PlaceNode> value);

	/**
	 * @model
	 * @return
	 */
	int getTokenCount();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getTokenCount <em>Token Count</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Token Count</em>' attribute.
	 * @see #getTokenCount()
	 * @generated
	 */
	void setTokenCount(int value);

	/**
	 * @model changeable="false" transient="true"
	 * @return
	 */
	String getMarking();

	/**
	 * @model containment="true"
	 * @return
	 */
	EList<MultisetEntry> getStructuredMarking();
}
