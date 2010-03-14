package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface PetriNet extends HasToolInfo, HasId, HasLabel, HasName {
	/**
	 * @model required="true"
	 * @return the type of petri net
	 */
	public String getType();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet#getType <em>Type</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

	/**
	 * @model containment="true" lower="1" opposite="petriNet" type="Page"
	 * @return all pages of this petri net
	 */
	public EList<Page> getPage();

	// This definition differs from the standard to avoid double representation
	/**
	 * @return all declarations of this petri net
	 */
	public Iterable<HLDeclaration> declaration();

	// This is added to better support fusion groups
	/**
	 * @return all fusion groups in this petri net
	 * @model containment="true" opposite="petriNet" type="FusionGroup"
	 */
	EList<FusionGroup> getFusionGroups();
}
