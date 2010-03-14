package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.ecore.EObject;

/**
 * @model abstract="true"
 * @author michael
 */
public interface Graphics extends EObject {
	/**
	 * @model required="true"
	 * @return the parent having this graphics
	 */
	public HasGraphics getParent();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Graphics#getParent <em>Parent</em>}' container reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent</em>' container reference.
	 * @see #getParent()
	 * @generated
	 */
	void setParent(HasGraphics value);
}
