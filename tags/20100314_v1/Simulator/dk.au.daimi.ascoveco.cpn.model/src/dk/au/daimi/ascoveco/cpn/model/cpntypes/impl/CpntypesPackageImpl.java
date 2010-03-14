/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.cpntypes.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
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
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesFactory;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.NameTypePair;
import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationPackage;
import dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl;
import dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class CpntypesPackageImpl extends EPackageImpl implements CpntypesPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnTypeEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnUnitEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnEnumEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnProductEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnRealEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnIndexEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnStringEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnAliasEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnIntEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnBoolEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnListEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnRecordEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnUnionEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpnSubsetEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nameTypePairEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with {@link org.eclipse.emf.ecore.EPackage.Registry
	 * EPackage.Registry} by the package package URI value.
	 * <p>
	 * Note: the correct way to create the package is via the static factory method {@link #init init()}, which also
	 * performs initialization of the package, or returns the registered package, if one already exists. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CpntypesPackageImpl() {
		super(eNS_URI, CpntypesFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link CpntypesPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CpntypesPackage init() {
		if (isInited) return (CpntypesPackage)EPackage.Registry.INSTANCE.getEPackage(CpntypesPackage.eNS_URI);

		// Obtain or create and register package
		CpntypesPackageImpl theCpntypesPackage = (CpntypesPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CpntypesPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CpntypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);
		GraphicsPackageImpl theGraphicsPackage = (GraphicsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GraphicsPackage.eNS_URI) instanceof GraphicsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GraphicsPackage.eNS_URI) : GraphicsPackage.eINSTANCE);

		// Create package meta-data objects
		theCpntypesPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theDeclarationPackage.createPackageContents();
		theGraphicsPackage.createPackageContents();

		// Initialize created meta-data
		theCpntypesPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theDeclarationPackage.initializePackageContents();
		theGraphicsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCpntypesPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CpntypesPackage.eNS_URI, theCpntypesPackage);
		return theCpntypesPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNType() {
		return cpnTypeEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNType_Declares() {
		return (EAttribute)cpnTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNType_Timed() {
		return (EAttribute)cpnTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNUnit() {
		return cpnUnitEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNUnit_Id() {
		return (EAttribute)cpnUnitEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNEnum() {
		return cpnEnumEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNEnum_Values() {
		return (EAttribute)cpnEnumEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNProduct() {
		return cpnProductEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNProduct_Types() {
		return (EAttribute)cpnProductEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNReal() {
		return cpnRealEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNReal_High() {
		return (EAttribute)cpnRealEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNReal_Low() {
		return (EAttribute)cpnRealEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNIndex() {
		return cpnIndexEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNIndex_Name() {
		return (EAttribute)cpnIndexEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNIndex_Low() {
		return (EAttribute)cpnIndexEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNIndex_High() {
		return (EAttribute)cpnIndexEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNString() {
		return cpnStringEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNString_RangeLow() {
		return (EAttribute)cpnStringEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNString_RangeHigh() {
		return (EAttribute)cpnStringEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNString_LengthLow() {
		return (EAttribute)cpnStringEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNString_LengthHigh() {
		return (EAttribute)cpnStringEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNAlias() {
		return cpnAliasEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNAlias_Type() {
		return (EAttribute)cpnAliasEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNInt() {
		return cpnIntEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNInt_Low() {
		return (EAttribute)cpnIntEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNInt_High() {
		return (EAttribute)cpnIntEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNBool() {
		return cpnBoolEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNBool_TrueValue() {
		return (EAttribute)cpnBoolEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNBool_FalseValue() {
		return (EAttribute)cpnBoolEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNList() {
		return cpnListEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNList_Type() {
		return (EAttribute)cpnListEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNList_Low() {
		return (EAttribute)cpnListEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNList_High() {
		return (EAttribute)cpnListEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNRecord() {
		return cpnRecordEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCPNRecord_Values() {
		return (EReference)cpnRecordEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNUnion() {
		return cpnUnionEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCPNUnion_Values() {
		return (EReference)cpnUnionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPNSubset() {
		return cpnSubsetEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNSubset_Type() {
		return (EAttribute)cpnSubsetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNSubset_By() {
		return (EAttribute)cpnSubsetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCPNSubset_With() {
		return (EAttribute)cpnSubsetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNameTypePair() {
		return nameTypePairEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameTypePair_Name() {
		return (EAttribute)nameTypePairEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNameTypePair_Type() {
		return (EAttribute)nameTypePairEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public CpntypesFactory getCpntypesFactory() {
		return (CpntypesFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		cpnTypeEClass = createEClass(CPN_TYPE);
		createEAttribute(cpnTypeEClass, CPN_TYPE__DECLARES);
		createEAttribute(cpnTypeEClass, CPN_TYPE__TIMED);

		cpnUnitEClass = createEClass(CPN_UNIT);
		createEAttribute(cpnUnitEClass, CPN_UNIT__ID);

		cpnEnumEClass = createEClass(CPN_ENUM);
		createEAttribute(cpnEnumEClass, CPN_ENUM__VALUES);

		cpnProductEClass = createEClass(CPN_PRODUCT);
		createEAttribute(cpnProductEClass, CPN_PRODUCT__TYPES);

		cpnRealEClass = createEClass(CPN_REAL);
		createEAttribute(cpnRealEClass, CPN_REAL__HIGH);
		createEAttribute(cpnRealEClass, CPN_REAL__LOW);

		cpnIndexEClass = createEClass(CPN_INDEX);
		createEAttribute(cpnIndexEClass, CPN_INDEX__NAME);
		createEAttribute(cpnIndexEClass, CPN_INDEX__LOW);
		createEAttribute(cpnIndexEClass, CPN_INDEX__HIGH);

		cpnStringEClass = createEClass(CPN_STRING);
		createEAttribute(cpnStringEClass, CPN_STRING__RANGE_LOW);
		createEAttribute(cpnStringEClass, CPN_STRING__RANGE_HIGH);
		createEAttribute(cpnStringEClass, CPN_STRING__LENGTH_LOW);
		createEAttribute(cpnStringEClass, CPN_STRING__LENGTH_HIGH);

		cpnAliasEClass = createEClass(CPN_ALIAS);
		createEAttribute(cpnAliasEClass, CPN_ALIAS__TYPE);

		cpnIntEClass = createEClass(CPN_INT);
		createEAttribute(cpnIntEClass, CPN_INT__LOW);
		createEAttribute(cpnIntEClass, CPN_INT__HIGH);

		cpnBoolEClass = createEClass(CPN_BOOL);
		createEAttribute(cpnBoolEClass, CPN_BOOL__TRUE_VALUE);
		createEAttribute(cpnBoolEClass, CPN_BOOL__FALSE_VALUE);

		cpnListEClass = createEClass(CPN_LIST);
		createEAttribute(cpnListEClass, CPN_LIST__TYPE);
		createEAttribute(cpnListEClass, CPN_LIST__LOW);
		createEAttribute(cpnListEClass, CPN_LIST__HIGH);

		cpnRecordEClass = createEClass(CPN_RECORD);
		createEReference(cpnRecordEClass, CPN_RECORD__VALUES);

		cpnUnionEClass = createEClass(CPN_UNION);
		createEReference(cpnUnionEClass, CPN_UNION__VALUES);

		cpnSubsetEClass = createEClass(CPN_SUBSET);
		createEAttribute(cpnSubsetEClass, CPN_SUBSET__TYPE);
		createEAttribute(cpnSubsetEClass, CPN_SUBSET__BY);
		createEAttribute(cpnSubsetEClass, CPN_SUBSET__WITH);

		nameTypePairEClass = createEClass(NAME_TYPE_PAIR);
		createEAttribute(nameTypePairEClass, NAME_TYPE_PAIR__NAME);
		createEAttribute(nameTypePairEClass, NAME_TYPE_PAIR__TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		cpnUnitEClass.getESuperTypes().add(this.getCPNType());
		cpnEnumEClass.getESuperTypes().add(this.getCPNType());
		cpnProductEClass.getESuperTypes().add(this.getCPNType());
		cpnRealEClass.getESuperTypes().add(this.getCPNType());
		cpnIndexEClass.getESuperTypes().add(this.getCPNType());
		cpnStringEClass.getESuperTypes().add(this.getCPNType());
		cpnAliasEClass.getESuperTypes().add(this.getCPNType());
		cpnIntEClass.getESuperTypes().add(this.getCPNType());
		cpnBoolEClass.getESuperTypes().add(this.getCPNType());
		cpnListEClass.getESuperTypes().add(this.getCPNType());
		cpnRecordEClass.getESuperTypes().add(this.getCPNType());
		cpnUnionEClass.getESuperTypes().add(this.getCPNType());
		cpnSubsetEClass.getESuperTypes().add(this.getCPNType());

		// Initialize classes and features; add operations and parameters
		initEClass(cpnTypeEClass, CPNType.class, "CPNType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNType_Declares(), ecorePackage.getEString(), "declares", null, 0, -1, CPNType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNType_Timed(), ecorePackage.getEBooleanObject(), "timed", null, 0, 1, CPNType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnUnitEClass, CPNUnit.class, "CPNUnit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNUnit_Id(), ecorePackage.getEString(), "id", null, 0, 1, CPNUnit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnEnumEClass, CPNEnum.class, "CPNEnum", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNEnum_Values(), ecorePackage.getEString(), "values", null, 0, -1, CPNEnum.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnProductEClass, CPNProduct.class, "CPNProduct", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNProduct_Types(), ecorePackage.getEString(), "types", null, 0, -1, CPNProduct.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnRealEClass, CPNReal.class, "CPNReal", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNReal_High(), ecorePackage.getEDouble(), "high", null, 0, 1, CPNReal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNReal_Low(), ecorePackage.getEDouble(), "low", null, 0, 1, CPNReal.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnIndexEClass, CPNIndex.class, "CPNIndex", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNIndex_Name(), ecorePackage.getEString(), "name", null, 1, 1, CPNIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNIndex_Low(), ecorePackage.getEString(), "low", null, 1, 1, CPNIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNIndex_High(), ecorePackage.getEString(), "high", null, 1, 1, CPNIndex.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnStringEClass, CPNString.class, "CPNString", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNString_RangeLow(), ecorePackage.getEString(), "rangeLow", null, 0, 1, CPNString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNString_RangeHigh(), ecorePackage.getEString(), "rangeHigh", null, 0, 1, CPNString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNString_LengthLow(), ecorePackage.getEString(), "lengthLow", null, 0, 1, CPNString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNString_LengthHigh(), ecorePackage.getEString(), "lengthHigh", null, 0, 1, CPNString.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnAliasEClass, CPNAlias.class, "CPNAlias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNAlias_Type(), ecorePackage.getEString(), "type", null, 1, 1, CPNAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnIntEClass, CPNInt.class, "CPNInt", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNInt_Low(), ecorePackage.getEString(), "low", null, 0, 1, CPNInt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNInt_High(), ecorePackage.getEString(), "high", null, 0, 1, CPNInt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnBoolEClass, CPNBool.class, "CPNBool", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNBool_TrueValue(), ecorePackage.getEString(), "trueValue", null, 0, 1, CPNBool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNBool_FalseValue(), ecorePackage.getEString(), "falseValue", null, 0, 1, CPNBool.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnListEClass, CPNList.class, "CPNList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNList_Type(), ecorePackage.getEString(), "type", null, 1, 1, CPNList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNList_Low(), ecorePackage.getEString(), "low", null, 0, 1, CPNList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNList_High(), ecorePackage.getEString(), "high", null, 0, 1, CPNList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnRecordEClass, CPNRecord.class, "CPNRecord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCPNRecord_Values(), this.getNameTypePair(), null, "values", null, 1, -1, CPNRecord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnUnionEClass, CPNUnion.class, "CPNUnion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCPNUnion_Values(), this.getNameTypePair(), null, "values", null, 1, -1, CPNUnion.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cpnSubsetEClass, CPNSubset.class, "CPNSubset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCPNSubset_Type(), ecorePackage.getEString(), "type", null, 0, 1, CPNSubset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNSubset_By(), ecorePackage.getEString(), "by", null, 0, 1, CPNSubset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCPNSubset_With(), ecorePackage.getEString(), "with", null, 0, 1, CPNSubset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nameTypePairEClass, NameTypePair.class, "NameTypePair", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNameTypePair_Name(), ecorePackage.getEString(), "name", null, 0, 1, NameTypePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNameTypePair_Type(), ecorePackage.getEString(), "type", null, 0, 1, NameTypePair.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} // CpntypesPackageImpl
