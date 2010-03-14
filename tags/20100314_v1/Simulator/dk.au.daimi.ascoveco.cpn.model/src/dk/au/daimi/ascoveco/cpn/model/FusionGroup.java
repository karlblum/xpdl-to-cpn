package dk.au.daimi.ascoveco.cpn.model;

/**
 * @model
 * @author michael
 */
public interface FusionGroup extends Place {
	/**
	 * @model
	 * @return the net containing the fusion group
	 */
	PetriNet getPetriNet();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.FusionGroup#getPetriNet <em>Petri Net</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Petri Net</em>' container reference.
	 * @see #getPetriNet()
	 * @generated
	 */
	void setPetriNet(PetriNet value);
}
