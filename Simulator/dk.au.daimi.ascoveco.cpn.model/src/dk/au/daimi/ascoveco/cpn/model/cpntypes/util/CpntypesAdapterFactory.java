/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.util;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage
 * @generated
 */
public class CpntypesAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected final static CpntypesPackage modelPackage = CpntypesPackage.eINSTANCE;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public CpntypesAdapterFactory() {
		// Raise visibility
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc --> This
	 * implementation returns <code>true</code> if the object is either the model's package or is an instance object of
	 * the model. <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected CpntypesSwitch<Adapter> modelSwitch = new CpntypesSwitch<Adapter>() {
			@Override
			public Adapter caseCPNType(CPNType object) {
				return createCPNTypeAdapter();
			}
			@Override
			public Adapter caseCPNUnit(CPNUnit object) {
				return createCPNUnitAdapter();
			}
			@Override
			public Adapter caseCPNEnum(CPNEnum object) {
				return createCPNEnumAdapter();
			}
			@Override
			public Adapter caseCPNProduct(CPNProduct object) {
				return createCPNProductAdapter();
			}
			@Override
			public Adapter caseCPNReal(CPNReal object) {
				return createCPNRealAdapter();
			}
			@Override
			public Adapter caseCPNIndex(CPNIndex object) {
				return createCPNIndexAdapter();
			}
			@Override
			public Adapter caseCPNString(CPNString object) {
				return createCPNStringAdapter();
			}
			@Override
			public Adapter caseCPNAlias(CPNAlias object) {
				return createCPNAliasAdapter();
			}
			@Override
			public Adapter caseCPNInt(CPNInt object) {
				return createCPNIntAdapter();
			}
			@Override
			public Adapter caseCPNBool(CPNBool object) {
				return createCPNBoolAdapter();
			}
			@Override
			public Adapter caseCPNList(CPNList object) {
				return createCPNListAdapter();
			}
			@Override
			public Adapter caseCPNRecord(CPNRecord object) {
				return createCPNRecordAdapter();
			}
			@Override
			public Adapter caseCPNUnion(CPNUnion object) {
				return createCPNUnionAdapter();
			}
			@Override
			public Adapter caseCPNSubset(CPNSubset object) {
				return createCPNSubsetAdapter();
			}
			@Override
			public Adapter caseNameTypePair(NameTypePair object) {
				return createNameTypePairAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType
	 * <em>CPN Type</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType
	 * @generated
	 */
	public Adapter createCPNTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit
	 * <em>CPN Unit</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit
	 * @generated
	 */
	public Adapter createCPNUnitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum
	 * <em>CPN Enum</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum
	 * @generated
	 */
	public Adapter createCPNEnumAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct
	 * <em>CPN Product</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct
	 * @generated
	 */
	public Adapter createCPNProductAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal
	 * <em>CPN Real</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal
	 * @generated
	 */
	public Adapter createCPNRealAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex
	 * <em>CPN Index</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex
	 * @generated
	 */
	public Adapter createCPNIndexAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString
	 * <em>CPN String</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString
	 * @generated
	 */
	public Adapter createCPNStringAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias
	 * <em>CPN Alias</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias
	 * @generated
	 */
	public Adapter createCPNAliasAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt <em>CPN Int</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore
	 * cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt
	 * @generated
	 */
	public Adapter createCPNIntAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool
	 * <em>CPN Bool</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool
	 * @generated
	 */
	public Adapter createCPNBoolAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList
	 * <em>CPN List</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList
	 * @generated
	 */
	public Adapter createCPNListAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord
	 * <em>CPN Record</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord
	 * @generated
	 */
	public Adapter createCPNRecordAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion
	 * <em>CPN Union</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion
	 * @generated
	 */
	public Adapter createCPNUnionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset
	 * <em>CPN Subset</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset
	 * @generated
	 */
	public Adapter createCPNSubsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair
	 * <em>Name Type Pair</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair
	 * @generated
	 */
	public Adapter createNameTypePairAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc --> This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} // CpntypesAdapterFactory
