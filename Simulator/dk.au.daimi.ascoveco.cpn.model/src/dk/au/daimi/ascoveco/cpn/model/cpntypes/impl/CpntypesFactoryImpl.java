/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

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
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesFactory;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class CpntypesFactoryImpl extends EFactoryImpl implements CpntypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static CpntypesFactory init() {
		try {
			CpntypesFactory theCpntypesFactory = (CpntypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///dk/au/daimi/ascoveco/cpn/model/cpntypes.ecore"); 
			if (theCpntypesFactory != null) {
				return theCpntypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CpntypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CpntypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case CpntypesPackage.CPN_UNIT: return createCPNUnit();
			case CpntypesPackage.CPN_ENUM: return createCPNEnum();
			case CpntypesPackage.CPN_PRODUCT: return createCPNProduct();
			case CpntypesPackage.CPN_REAL: return createCPNReal();
			case CpntypesPackage.CPN_INDEX: return createCPNIndex();
			case CpntypesPackage.CPN_STRING: return createCPNString();
			case CpntypesPackage.CPN_ALIAS: return createCPNAlias();
			case CpntypesPackage.CPN_INT: return createCPNInt();
			case CpntypesPackage.CPN_BOOL: return createCPNBool();
			case CpntypesPackage.CPN_LIST: return createCPNList();
			case CpntypesPackage.CPN_RECORD: return createCPNRecord();
			case CpntypesPackage.CPN_UNION: return createCPNUnion();
			case CpntypesPackage.CPN_SUBSET: return createCPNSubset();
			case CpntypesPackage.NAME_TYPE_PAIR: return createNameTypePair();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNUnit createCPNUnit() {
		CPNUnitImpl cpnUnit = new CPNUnitImpl();
		return cpnUnit;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNEnum createCPNEnum() {
		CPNEnumImpl cpnEnum = new CPNEnumImpl();
		return cpnEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNProduct createCPNProduct() {
		CPNProductImpl cpnProduct = new CPNProductImpl();
		return cpnProduct;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNReal createCPNReal() {
		CPNRealImpl cpnReal = new CPNRealImpl();
		return cpnReal;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNIndex createCPNIndex() {
		CPNIndexImpl cpnIndex = new CPNIndexImpl();
		return cpnIndex;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNString createCPNString() {
		CPNStringImpl cpnString = new CPNStringImpl();
		return cpnString;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNAlias createCPNAlias() {
		CPNAliasImpl cpnAlias = new CPNAliasImpl();
		return cpnAlias;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNInt createCPNInt() {
		CPNIntImpl cpnInt = new CPNIntImpl();
		return cpnInt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * @return a new CPNBool <!-- end-user-doc -->
	 * @generated
	 */
	public CPNBool createCPNBool() {
		CPNBoolImpl cpnBool = new CPNBoolImpl();
		return cpnBool;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNList createCPNList() {
		CPNListImpl cpnList = new CPNListImpl();
		return cpnList;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNRecord createCPNRecord() {
		CPNRecordImpl cpnRecord = new CPNRecordImpl();
		return cpnRecord;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNUnion createCPNUnion() {
		CPNUnionImpl cpnUnion = new CPNUnionImpl();
		return cpnUnion;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CPNSubset createCPNSubset() {
		CPNSubsetImpl cpnSubset = new CPNSubsetImpl();
		return cpnSubset;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NameTypePair createNameTypePair() {
		NameTypePairImpl nameTypePair = new NameTypePairImpl();
		return nameTypePair;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CpntypesPackage getCpntypesPackage() {
		return (CpntypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CpntypesPackage getPackage() {
		return CpntypesPackage.eINSTANCE;
	}

} // CpntypesFactoryImpl
