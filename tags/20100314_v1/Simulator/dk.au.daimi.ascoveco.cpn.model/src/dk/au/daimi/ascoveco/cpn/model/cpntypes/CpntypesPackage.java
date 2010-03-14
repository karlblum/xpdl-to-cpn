/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface CpntypesPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "cpntypes";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dk/au/daimi/ascoveco/cpn/model/cpntypes.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.au.daimi.ascoveco.cpn.model.cpntypes";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	CpntypesPackage eINSTANCE = dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl <em>CPN Type</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNType()
	 * @generated
	 */
	int CPN_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TYPE__DECLARES = 0;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TYPE__TIMED = 1;

	/**
	 * The number of structural features of the '<em>CPN Type</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TYPE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnitImpl <em>CPN Unit</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnitImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNUnit()
	 * @generated
	 */
	int CPN_UNIT = 1;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNIT__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNIT__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNIT__ID = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Unit</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNIT_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNEnumImpl <em>CPN Enum</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNEnumImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNEnum()
	 * @generated
	 */
	int CPN_ENUM = 2;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ENUM__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ENUM__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ENUM__VALUES = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Enum</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ENUM_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNProductImpl <em>CPN Product</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNProductImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNProduct()
	 * @generated
	 */
	int CPN_PRODUCT = 3;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_PRODUCT__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_PRODUCT__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Types</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_PRODUCT__TYPES = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Product</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_PRODUCT_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl <em>CPN Real</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNReal()
	 * @generated
	 */
	int CPN_REAL = 4;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_REAL__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_REAL__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_REAL__HIGH = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_REAL__LOW = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CPN Real</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_REAL_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIndexImpl <em>CPN Index</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIndexImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNIndex()
	 * @generated
	 */
	int CPN_INDEX = 5;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX__NAME = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX__LOW = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX__HIGH = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CPN Index</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_INDEX_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl <em>CPN String</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNString()
	 * @generated
	 */
	int CPN_STRING = 6;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Range Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__RANGE_LOW = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Range High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__RANGE_HIGH = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Length Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__LENGTH_LOW = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Length High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_STRING__LENGTH_HIGH = CPN_TYPE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>CPN String</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_STRING_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNAliasImpl <em>CPN Alias</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNAliasImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNAlias()
	 * @generated
	 */
	int CPN_ALIAS = 7;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ALIAS__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ALIAS__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_ALIAS__TYPE = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Alias</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_ALIAS_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIntImpl <em>CPN Int</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIntImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNInt()
	 * @generated
	 */
	int CPN_INT = 8;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INT__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INT__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INT__LOW = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INT__HIGH = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CPN Int</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_INT_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl <em>CPN Bool</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNBool()
	 * @generated
	 */
	int CPN_BOOL = 9;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_BOOL__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_BOOL__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>True Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_BOOL__TRUE_VALUE = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>False Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_BOOL__FALSE_VALUE = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>CPN Bool</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_BOOL_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl <em>CPN List</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNList()
	 * @generated
	 */
	int CPN_LIST = 10;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST__TYPE = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Low</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST__LOW = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>High</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST__HIGH = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CPN List</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_LIST_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRecordImpl <em>CPN Record</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRecordImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNRecord()
	 * @generated
	 */
	int CPN_RECORD = 11;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_RECORD__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_RECORD__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_RECORD__VALUES = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Record</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_RECORD_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnionImpl <em>CPN Union</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnionImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNUnion()
	 * @generated
	 */
	int CPN_UNION = 12;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNION__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNION__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Values</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_UNION__VALUES = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CPN Union</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_UNION_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNSubsetImpl <em>CPN Subset</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNSubsetImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNSubset()
	 * @generated
	 */
	int CPN_SUBSET = 13;

	/**
	 * The feature id for the '<em><b>Declares</b></em>' attribute list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET__DECLARES = CPN_TYPE__DECLARES;

	/**
	 * The feature id for the '<em><b>Timed</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET__TIMED = CPN_TYPE__TIMED;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET__TYPE = CPN_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>By</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET__BY = CPN_TYPE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>With</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET__WITH = CPN_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>CPN Subset</em>' class. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int CPN_SUBSET_FEATURE_COUNT = CPN_TYPE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.NameTypePairImpl <em>Name Type Pair</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.NameTypePairImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getNameTypePair()
	 * @generated
	 */
	int NAME_TYPE_PAIR = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_TYPE_PAIR__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_TYPE_PAIR__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Name Type Pair</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_TYPE_PAIR_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType <em>CPN Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType
	 * @generated
	 */
	EClass getCPNType();

	/**
	 * Returns the meta object for the attribute list '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#getDeclares <em>Declares</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Declares</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#getDeclares()
	 * @see #getCPNType()
	 * @generated
	 */
	EAttribute getCPNType_Declares();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#getTimed <em>Timed</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Timed</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNType#getTimed()
	 * @see #getCPNType()
	 * @generated
	 */
	EAttribute getCPNType_Timed();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit <em>CPN Unit</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Unit</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit
	 * @generated
	 */
	EClass getCPNUnit();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit#getId <em>Id</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnit#getId()
	 * @see #getCPNUnit()
	 * @generated
	 */
	EAttribute getCPNUnit_Id();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum <em>CPN Enum</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Enum</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum
	 * @generated
	 */
	EClass getCPNEnum();

	/**
	 * Returns the meta object for the attribute list '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNEnum#getValues()
	 * @see #getCPNEnum()
	 * @generated
	 */
	EAttribute getCPNEnum_Values();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct <em>CPN Product</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Product</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct
	 * @generated
	 */
	EClass getCPNProduct();

	/**
	 * Returns the meta object for the attribute list '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct#getTypes <em>Types</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the attribute list '<em>Types</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNProduct#getTypes()
	 * @see #getCPNProduct()
	 * @generated
	 */
	EAttribute getCPNProduct_Types();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal <em>CPN Real</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Real</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal
	 * @generated
	 */
	EClass getCPNReal();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal#getHigh()
	 * @see #getCPNReal()
	 * @generated
	 */
	EAttribute getCPNReal_High();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNReal#getLow()
	 * @see #getCPNReal()
	 * @generated
	 */
	EAttribute getCPNReal_Low();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex <em>CPN Index</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Index</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex
	 * @generated
	 */
	EClass getCPNIndex();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getName()
	 * @see #getCPNIndex()
	 * @generated
	 */
	EAttribute getCPNIndex_Name();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getLow()
	 * @see #getCPNIndex()
	 * @generated
	 */
	EAttribute getCPNIndex_Low();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNIndex#getHigh()
	 * @see #getCPNIndex()
	 * @generated
	 */
	EAttribute getCPNIndex_High();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString <em>CPN String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN String</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString
	 * @generated
	 */
	EClass getCPNString();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getRangeLow <em>Range Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getRangeLow()
	 * @see #getCPNString()
	 * @generated
	 */
	EAttribute getCPNString_RangeLow();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getRangeHigh <em>Range High</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Range High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getRangeHigh()
	 * @see #getCPNString()
	 * @generated
	 */
	EAttribute getCPNString_RangeHigh();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getLengthLow <em>Length Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Length Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getLengthLow()
	 * @see #getCPNString()
	 * @generated
	 */
	EAttribute getCPNString_LengthLow();

	/**
	 * Returns the meta object for the attribute '
	 * {@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getLengthHigh <em>Length High</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Length High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNString#getLengthHigh()
	 * @see #getCPNString()
	 * @generated
	 */
	EAttribute getCPNString_LengthHigh();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias <em>CPN Alias</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Alias</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias
	 * @generated
	 */
	EClass getCPNAlias();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNAlias#getType()
	 * @see #getCPNAlias()
	 * @generated
	 */
	EAttribute getCPNAlias_Type();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt <em>CPN Int</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for class '<em>CPN Int</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt
	 * @generated
	 */
	EClass getCPNInt();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt#getLow()
	 * @see #getCPNInt()
	 * @generated
	 */
	EAttribute getCPNInt_Low();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNInt#getHigh()
	 * @see #getCPNInt()
	 * @generated
	 */
	EAttribute getCPNInt_High();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool <em>CPN Bool</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Bool</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool
	 * @generated
	 */
	EClass getCPNBool();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool#getTrueValue <em>True Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>True Value</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool#getTrueValue()
	 * @see #getCPNBool()
	 * @generated
	 */
	EAttribute getCPNBool_TrueValue();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool#getFalseValue <em>False Value</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>False Value</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNBool#getFalseValue()
	 * @see #getCPNBool()
	 * @generated
	 */
	EAttribute getCPNBool_FalseValue();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList <em>CPN List</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN List</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList
	 * @generated
	 */
	EClass getCPNList();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getType()
	 * @see #getCPNList()
	 * @generated
	 */
	EAttribute getCPNList_Type();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getLow <em>Low</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Low</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getLow()
	 * @see #getCPNList()
	 * @generated
	 */
	EAttribute getCPNList_Low();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getHigh <em>High</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>High</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNList#getHigh()
	 * @see #getCPNList()
	 * @generated
	 */
	EAttribute getCPNList_High();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord <em>CPN Record</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Record</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord
	 * @generated
	 */
	EClass getCPNRecord();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNRecord#getValues()
	 * @see #getCPNRecord()
	 * @generated
	 */
	EReference getCPNRecord_Values();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion <em>CPN Union</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Union</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion
	 * @generated
	 */
	EClass getCPNUnion();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Values</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNUnion#getValues()
	 * @see #getCPNUnion()
	 * @generated
	 */
	EReference getCPNUnion_Values();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset <em>CPN Subset</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Subset</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset
	 * @generated
	 */
	EClass getCPNSubset();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getType()
	 * @see #getCPNSubset()
	 * @generated
	 */
	EAttribute getCPNSubset_Type();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getBy <em>By</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>By</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getBy()
	 * @see #getCPNSubset()
	 * @generated
	 */
	EAttribute getCPNSubset_By();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getWith <em>With</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>With</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CPNSubset#getWith()
	 * @see #getCPNSubset()
	 * @generated
	 */
	EAttribute getCPNSubset_With();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair <em>Name Type Pair</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name Type Pair</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair
	 * @generated
	 */
	EClass getNameTypePair();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getName <em>Name</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getName()
	 * @see #getNameTypePair()
	 * @generated
	 */
	EAttribute getNameTypePair_Name();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getType <em>Type</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair#getType()
	 * @see #getNameTypePair()
	 * @generated
	 */
	EAttribute getNameTypePair_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CpntypesFactory getCpntypesFactory();

	/**
	 * <!-- begin-user-doc --> Defines literals for the meta objects that represent
	 * <ul>
	 * <li>each class,</li>
	 * <li>each feature of each class,</li>
	 * <li>each enum,</li>
	 * <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl <em>CPN Type</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNTypeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNType()
		 * @generated
		 */
		EClass CPN_TYPE = eINSTANCE.getCPNType();
		/**
		 * The meta object literal for the '<em><b>Declares</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_TYPE__DECLARES = eINSTANCE.getCPNType_Declares();
		/**
		 * The meta object literal for the '<em><b>Timed</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_TYPE__TIMED = eINSTANCE.getCPNType_Timed();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnitImpl <em>CPN Unit</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnitImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNUnit()
		 * @generated
		 */
		EClass CPN_UNIT = eINSTANCE.getCPNUnit();
		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_UNIT__ID = eINSTANCE.getCPNUnit_Id();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNEnumImpl <em>CPN Enum</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNEnumImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNEnum()
		 * @generated
		 */
		EClass CPN_ENUM = eINSTANCE.getCPNEnum();
		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_ENUM__VALUES = eINSTANCE.getCPNEnum_Values();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNProductImpl <em>CPN Product</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNProductImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNProduct()
		 * @generated
		 */
		EClass CPN_PRODUCT = eINSTANCE.getCPNProduct();
		/**
		 * The meta object literal for the '<em><b>Types</b></em>' attribute list feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_PRODUCT__TYPES = eINSTANCE.getCPNProduct_Types();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl <em>CPN Real</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRealImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNReal()
		 * @generated
		 */
		EClass CPN_REAL = eINSTANCE.getCPNReal();
		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_REAL__HIGH = eINSTANCE.getCPNReal_High();
		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_REAL__LOW = eINSTANCE.getCPNReal_Low();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIndexImpl <em>CPN Index</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIndexImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNIndex()
		 * @generated
		 */
		EClass CPN_INDEX = eINSTANCE.getCPNIndex();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_INDEX__NAME = eINSTANCE.getCPNIndex_Name();
		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_INDEX__LOW = eINSTANCE.getCPNIndex_Low();
		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_INDEX__HIGH = eINSTANCE.getCPNIndex_High();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl <em>CPN String</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNStringImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNString()
		 * @generated
		 */
		EClass CPN_STRING = eINSTANCE.getCPNString();
		/**
		 * The meta object literal for the '<em><b>Range Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_STRING__RANGE_LOW = eINSTANCE.getCPNString_RangeLow();
		/**
		 * The meta object literal for the '<em><b>Range High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_STRING__RANGE_HIGH = eINSTANCE.getCPNString_RangeHigh();
		/**
		 * The meta object literal for the '<em><b>Length Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_STRING__LENGTH_LOW = eINSTANCE.getCPNString_LengthLow();
		/**
		 * The meta object literal for the '<em><b>Length High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_STRING__LENGTH_HIGH = eINSTANCE.getCPNString_LengthHigh();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNAliasImpl <em>CPN Alias</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNAliasImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNAlias()
		 * @generated
		 */
		EClass CPN_ALIAS = eINSTANCE.getCPNAlias();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_ALIAS__TYPE = eINSTANCE.getCPNAlias_Type();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIntImpl <em>CPN Int</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNIntImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNInt()
		 * @generated
		 */
		EClass CPN_INT = eINSTANCE.getCPNInt();
		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_INT__LOW = eINSTANCE.getCPNInt_Low();
		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_INT__HIGH = eINSTANCE.getCPNInt_High();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl <em>CPN Bool</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNBoolImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNBool()
		 * @generated
		 */
		EClass CPN_BOOL = eINSTANCE.getCPNBool();
		/**
		 * The meta object literal for the '<em><b>True Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_BOOL__TRUE_VALUE = eINSTANCE.getCPNBool_TrueValue();
		/**
		 * The meta object literal for the '<em><b>False Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_BOOL__FALSE_VALUE = eINSTANCE.getCPNBool_FalseValue();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl <em>CPN List</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNListImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNList()
		 * @generated
		 */
		EClass CPN_LIST = eINSTANCE.getCPNList();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_LIST__TYPE = eINSTANCE.getCPNList_Type();
		/**
		 * The meta object literal for the '<em><b>Low</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_LIST__LOW = eINSTANCE.getCPNList_Low();
		/**
		 * The meta object literal for the '<em><b>High</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_LIST__HIGH = eINSTANCE.getCPNList_High();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRecordImpl <em>CPN Record</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNRecordImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNRecord()
		 * @generated
		 */
		EClass CPN_RECORD = eINSTANCE.getCPNRecord();
		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CPN_RECORD__VALUES = eINSTANCE.getCPNRecord_Values();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnionImpl <em>CPN Union</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNUnionImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNUnion()
		 * @generated
		 */
		EClass CPN_UNION = eINSTANCE.getCPNUnion();
		/**
		 * The meta object literal for the '<em><b>Values</b></em>' containment reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference CPN_UNION__VALUES = eINSTANCE.getCPNUnion_Values();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNSubsetImpl <em>CPN Subset</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CPNSubsetImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getCPNSubset()
		 * @generated
		 */
		EClass CPN_SUBSET = eINSTANCE.getCPNSubset();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_SUBSET__TYPE = eINSTANCE.getCPNSubset_Type();
		/**
		 * The meta object literal for the '<em><b>By</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_SUBSET__BY = eINSTANCE.getCPNSubset_By();
		/**
		 * The meta object literal for the '<em><b>With</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute CPN_SUBSET__WITH = eINSTANCE.getCPNSubset_With();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.NameTypePairImpl <em>Name Type Pair</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.NameTypePairImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl#getNameTypePair()
		 * @generated
		 */
		EClass NAME_TYPE_PAIR = eINSTANCE.getNameTypePair();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_TYPE_PAIR__NAME = eINSTANCE.getNameTypePair_Name();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute NAME_TYPE_PAIR__TYPE = eINSTANCE.getNameTypePair_Type();

	}

} // CpntypesPackage
