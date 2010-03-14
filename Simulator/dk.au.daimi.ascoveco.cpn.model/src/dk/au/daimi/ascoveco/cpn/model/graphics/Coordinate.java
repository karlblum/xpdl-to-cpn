package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.ecore.EObject;

/**
 * @model
 * @author michael
 */
public interface Coordinate extends EObject {
	/**
	 * @model required="true"
	 * @return the x value
	 */
	public double getX();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getX <em>X</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>X</em>' attribute.
	 * @see #getX()
	 * @generated
	 */
	void setX(double value);

	/**
	 * @model required="true"
	 * @return the y value
	 */
	public double getY();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getY <em>Y</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Y</em>' attribute.
	 * @see #getY()
	 * @generated
	 */
	void setY(double value);
}
