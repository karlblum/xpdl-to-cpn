package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true" interface="true"
 * @author michael
 */
public interface HLArcAddin extends EObject {
	/**
	 * @return the inscription of this arc
	 * @model required="false" containment="true"
	 */
	public HLAnnotation getHlinscription();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getHlinscription <em>Hlinscription</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Hlinscription</em>' containment reference.
	 * @see #getHlinscription()
	 * @generated
	 */
	void setHlinscription(HLAnnotation value);

	// This has been added -- seems like the standard has forgotten ablut this?
	/**
	 * @model required="true"
	 * @return the type of the arc
	 */
	public HLArcType getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getType <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @see #getType()
	 * @generated
	 */
	void setType(HLArcType value);
}
