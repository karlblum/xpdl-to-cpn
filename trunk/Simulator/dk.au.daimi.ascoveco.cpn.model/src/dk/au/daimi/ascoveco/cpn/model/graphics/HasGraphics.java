package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.ecore.EObject;

/**
 * @model interface="true" abstract="true"
 * @author michael
 */
public interface HasGraphics extends EObject {
	/**
	 * @model containment="true" required="false" opposite="parent"
	 * @return the graphics of this objectr
	 */
	public Graphics getGraphics();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics#getGraphics <em>Graphics</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Graphics</em>' containment reference.
	 * @see #getGraphics()
	 * @generated
	 */
	void setGraphics(Graphics value);
}
