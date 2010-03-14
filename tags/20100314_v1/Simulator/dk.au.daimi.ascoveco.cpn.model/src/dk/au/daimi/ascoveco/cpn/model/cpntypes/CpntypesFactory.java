/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.ecore.EFactory;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface CpntypesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CpntypesFactory eINSTANCE = dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>CPN Unit</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Unit</em>'.
	 * @generated
	 */
	CPNUnit createCPNUnit();

	/**
	 * Returns a new object of class '<em>CPN Enum</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Enum</em>'.
	 * @generated
	 */
	CPNEnum createCPNEnum();

	/**
	 * Returns a new object of class '<em>CPN Product</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Product</em>'.
	 * @generated
	 */
	CPNProduct createCPNProduct();

	/**
	 * Returns a new object of class '<em>CPN Real</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Real</em>'.
	 * @generated
	 */
	CPNReal createCPNReal();

	/**
	 * Returns a new object of class '<em>CPN Index</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Index</em>'.
	 * @generated
	 */
	CPNIndex createCPNIndex();

	/**
	 * Returns a new object of class '<em>CPN String</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN String</em>'.
	 * @generated
	 */
	CPNString createCPNString();

	/**
	 * Returns a new object of class '<em>CPN Alias</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Alias</em>'.
	 * @generated
	 */
	CPNAlias createCPNAlias();

	/**
	 * Returns a new object of class '<em>CPN Int</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Int</em>'.
	 * @generated
	 */
	CPNInt createCPNInt();

	/**
	 * Returns a new object of class '<em>CPN Bool</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Bool</em>'.
	 * @generated
	 */
	CPNBool createCPNBool();

	/**
	 * Returns a new object of class '<em>CPN List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN List</em>'.
	 * @generated
	 */
	CPNList createCPNList();

	/**
	 * Returns a new object of class '<em>CPN Record</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Record</em>'.
	 * @generated
	 */
	CPNRecord createCPNRecord();

	/**
	 * Returns a new object of class '<em>CPN Union</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Union</em>'.
	 * @generated
	 */
	CPNUnion createCPNUnion();

	/**
	 * Returns a new object of class '<em>CPN Subset</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CPN Subset</em>'.
	 * @generated
	 */
	CPNSubset createCPNSubset();

	/**
	 * Returns a new object of class '<em>Name Type Pair</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Name Type Pair</em>'.
	 * @generated
	 */
	NameTypePair createNameTypePair();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CpntypesPackage getCpntypesPackage();

} //CpntypesFactory
