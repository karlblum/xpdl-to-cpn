package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface Page extends HasName, HasLabel, HasId {
	/**
	 * @model required="true"
	 * @return the petri net this page belongs to
	 */
	public PetriNet getPetriNet();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.Page#getPetriNet <em>Petri Net</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Petri Net</em>' container reference.
	 * @see #getPetriNet()
	 * @generated
	 */
	void setPetriNet(PetriNet value);

	/**
	 * @model type="Object" opposite="page" containment="true"
	 * @return all objects on this page
	 */
	public EList<dk.au.daimi.ascoveco.cpn.model.Object> getObject();

	/**
	 * @model containment="true" opposite="page" type="Arc"
	 * @return all arcs on this page
	 */
	public EList<Arc> getArc();

	/**
	 * @return an iterator over all places of this page
	 */
	public Iterable<Place> place();

	/**
	 * @return an iterator over all ready places of this page
	 */
	public Iterable<Place> readyPlaces();

	/**
	 * @return an iterator over all transitions of this page
	 */
	public Iterable<Transition> transition();

	/**
	 * @return an iterator over all ready transitions of this page
	 */
	public Iterable<Transition> readyTransitions();

	/**
	 * @return an iterator over all instances/subst. transitions of this page
	 */
	public Iterable<Instance> instance();

	/**
	 * @return an iterator over all fucsion groups on this page
	 */
	public Iterable<RefPlace> fusionGroup();

	/**
	 * @return an iterator over all ports on thsi page
	 */
	public Iterable<RefPlace> portPlace();

	/**
	 * @return an iterator over all ready instances/subst. transitions of this page
	 */
	public Iterable<Instance> readyInstances();

	/**
	 * @return an iterator over all ready fucsion groups on this page
	 */
	public Iterable<RefPlace> readyFusionGroups();

	/**
	 * @return an iterator over all ready ports on thsi page
	 */
	public Iterable<RefPlace> readyPortPlaces();
}
