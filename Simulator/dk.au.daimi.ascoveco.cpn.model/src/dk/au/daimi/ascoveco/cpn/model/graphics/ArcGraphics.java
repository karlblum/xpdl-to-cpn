package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.common.util.EList;

/**
 * @model
 * @author michael
 */
public interface ArcGraphics extends Graphics {
	/**
	 * @model containment="true"
	 * @return the line
	 */
	public Line getLine();

	/**
	 * Sets the value of the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics#getLine <em>Line</em>}' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Line</em>' containment reference.
	 * @see #getLine()
	 * @generated
	 */
	void setLine(Line value);

	/**
	 * @model type="Coordinate" containment="true"
	 * @return the bendpoints
	 */
	public EList<Coordinate> getPosition();
}
