/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.ecore.EFactory;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface GraphicsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicsFactory eINSTANCE = dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Annotation Graphics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Annotation Graphics</em>'.
	 * @generated
	 */
	AnnotationGraphics createAnnotationGraphics();

	/**
	 * Returns a new object of class '<em>Arc Graphics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Arc Graphics</em>'.
	 * @generated
	 */
	ArcGraphics createArcGraphics();

	/**
	 * Returns a new object of class '<em>Coordinate</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Coordinate</em>'.
	 * @generated
	 */
	Coordinate createCoordinate();

	/**
	 * Returns a new object of class '<em>Fill</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fill</em>'.
	 * @generated
	 */
	Fill createFill();

	/**
	 * Returns a new object of class '<em>Font</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Font</em>'.
	 * @generated
	 */
	Font createFont();

	/**
	 * Returns a new object of class '<em>Line</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Line</em>'.
	 * @generated
	 */
	Line createLine();

	/**
	 * Returns a new object of class '<em>Node Graphics</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Node Graphics</em>'.
	 * @generated
	 */
	NodeGraphics createNodeGraphics();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GraphicsPackage getGraphicsPackage();

} //GraphicsFactory
