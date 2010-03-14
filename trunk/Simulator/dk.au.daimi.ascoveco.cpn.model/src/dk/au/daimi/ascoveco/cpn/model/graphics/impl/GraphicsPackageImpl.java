/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics.impl;

import dk.au.daimi.ascoveco.cpn.model.ModelPackage;

import dk.au.daimi.ascoveco.cpn.model.cpntypes.CpntypesPackage;
import dk.au.daimi.ascoveco.cpn.model.cpntypes.impl.CpntypesPackageImpl;
import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationPackage;
import dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl;
import dk.au.daimi.ascoveco.cpn.model.graphics.Align;
import dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate;
import dk.au.daimi.ascoveco.cpn.model.graphics.Decoration;
import dk.au.daimi.ascoveco.cpn.model.graphics.Fill;
import dk.au.daimi.ascoveco.cpn.model.graphics.Font;
import dk.au.daimi.ascoveco.cpn.model.graphics.Graphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsFactory;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Line;
import dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Rotation;
import dk.au.daimi.ascoveco.cpn.model.graphics.Shape;
import dk.au.daimi.ascoveco.cpn.model.graphics.Style;

import dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphicsPackageImpl extends EPackageImpl implements GraphicsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationGraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass arcGraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass coordinateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fillEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fontEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass graphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hasGraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lineEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeGraphicsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum alignEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum shapeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum styleEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType css2ColorEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType css2FontFamilyEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType css2FontStyleEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType css2FontWeightEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType css2FontSizeEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nonNegativeDecimalEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType urlEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType rotationEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType decorationEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private GraphicsPackageImpl() {
		super(eNS_URI, GraphicsFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link GraphicsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static GraphicsPackage init() {
		if (isInited) return (GraphicsPackage)EPackage.Registry.INSTANCE.getEPackage(GraphicsPackage.eNS_URI);

		// Obtain or create and register package
		GraphicsPackageImpl theGraphicsPackage = (GraphicsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphicsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphicsPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ModelPackageImpl theModelPackage = (ModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) instanceof ModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ModelPackage.eNS_URI) : ModelPackage.eINSTANCE);
		CpntypesPackageImpl theCpntypesPackage = (CpntypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CpntypesPackage.eNS_URI) instanceof CpntypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CpntypesPackage.eNS_URI) : CpntypesPackage.eINSTANCE);
		DeclarationPackageImpl theDeclarationPackage = (DeclarationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) instanceof DeclarationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DeclarationPackage.eNS_URI) : DeclarationPackage.eINSTANCE);

		// Create package meta-data objects
		theGraphicsPackage.createPackageContents();
		theModelPackage.createPackageContents();
		theCpntypesPackage.createPackageContents();
		theDeclarationPackage.createPackageContents();

		// Initialize created meta-data
		theGraphicsPackage.initializePackageContents();
		theModelPackage.initializePackageContents();
		theCpntypesPackage.initializePackageContents();
		theDeclarationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theGraphicsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(GraphicsPackage.eNS_URI, theGraphicsPackage);
		return theGraphicsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotationGraphics() {
		return annotationGraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationGraphics_Fill() {
		return (EReference)annotationGraphicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationGraphics_Offset() {
		return (EReference)annotationGraphicsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationGraphics_Line() {
		return (EReference)annotationGraphicsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAnnotationGraphics_Font() {
		return (EReference)annotationGraphicsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getArcGraphics() {
		return arcGraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArcGraphics_Line() {
		return (EReference)arcGraphicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getArcGraphics_Position() {
		return (EReference)arcGraphicsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCoordinate() {
		return coordinateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoordinate_X() {
		return (EAttribute)coordinateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCoordinate_Y() {
		return (EAttribute)coordinateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFill() {
		return fillEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFill_Color() {
		return (EAttribute)fillEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFill_Image() {
		return (EAttribute)fillEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFill_GradientColor() {
		return (EAttribute)fillEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFill_GradientRotation() {
		return (EAttribute)fillEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFont() {
		return fontEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Family() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Style() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Weight() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Size() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Decoration() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Align() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFont_Rotation() {
		return (EAttribute)fontEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGraphics() {
		return graphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getGraphics_Parent() {
		return (EReference)graphicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHasGraphics() {
		return hasGraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getHasGraphics_Graphics() {
		return (EReference)hasGraphicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLine() {
		return lineEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLine_Shape() {
		return (EAttribute)lineEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLine_Color() {
		return (EAttribute)lineEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLine_Width() {
		return (EAttribute)lineEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLine_Style() {
		return (EAttribute)lineEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNodeGraphics() {
		return nodeGraphicsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeGraphics_Position() {
		return (EReference)nodeGraphicsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeGraphics_Dimension() {
		return (EReference)nodeGraphicsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeGraphics_Line() {
		return (EReference)nodeGraphicsEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNodeGraphics_Fill() {
		return (EReference)nodeGraphicsEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAlign() {
		return alignEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getShape() {
		return shapeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getStyle() {
		return styleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCSS2Color() {
		return css2ColorEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCSS2FontFamily() {
		return css2FontFamilyEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCSS2FontStyle() {
		return css2FontStyleEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCSS2FontWeight() {
		return css2FontWeightEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getCSS2FontSize() {
		return css2FontSizeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getNonNegativeDecimal() {
		return nonNegativeDecimalEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getURL() {
		return urlEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getRotation() {
		return rotationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getDecoration() {
		return decorationEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicsFactory getGraphicsFactory() {
		return (GraphicsFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationGraphicsEClass = createEClass(ANNOTATION_GRAPHICS);
		createEReference(annotationGraphicsEClass, ANNOTATION_GRAPHICS__FILL);
		createEReference(annotationGraphicsEClass, ANNOTATION_GRAPHICS__OFFSET);
		createEReference(annotationGraphicsEClass, ANNOTATION_GRAPHICS__LINE);
		createEReference(annotationGraphicsEClass, ANNOTATION_GRAPHICS__FONT);

		arcGraphicsEClass = createEClass(ARC_GRAPHICS);
		createEReference(arcGraphicsEClass, ARC_GRAPHICS__LINE);
		createEReference(arcGraphicsEClass, ARC_GRAPHICS__POSITION);

		coordinateEClass = createEClass(COORDINATE);
		createEAttribute(coordinateEClass, COORDINATE__X);
		createEAttribute(coordinateEClass, COORDINATE__Y);

		fillEClass = createEClass(FILL);
		createEAttribute(fillEClass, FILL__COLOR);
		createEAttribute(fillEClass, FILL__IMAGE);
		createEAttribute(fillEClass, FILL__GRADIENT_COLOR);
		createEAttribute(fillEClass, FILL__GRADIENT_ROTATION);

		fontEClass = createEClass(FONT);
		createEAttribute(fontEClass, FONT__FAMILY);
		createEAttribute(fontEClass, FONT__STYLE);
		createEAttribute(fontEClass, FONT__WEIGHT);
		createEAttribute(fontEClass, FONT__SIZE);
		createEAttribute(fontEClass, FONT__DECORATION);
		createEAttribute(fontEClass, FONT__ALIGN);
		createEAttribute(fontEClass, FONT__ROTATION);

		graphicsEClass = createEClass(GRAPHICS);
		createEReference(graphicsEClass, GRAPHICS__PARENT);

		hasGraphicsEClass = createEClass(HAS_GRAPHICS);
		createEReference(hasGraphicsEClass, HAS_GRAPHICS__GRAPHICS);

		lineEClass = createEClass(LINE);
		createEAttribute(lineEClass, LINE__SHAPE);
		createEAttribute(lineEClass, LINE__COLOR);
		createEAttribute(lineEClass, LINE__WIDTH);
		createEAttribute(lineEClass, LINE__STYLE);

		nodeGraphicsEClass = createEClass(NODE_GRAPHICS);
		createEReference(nodeGraphicsEClass, NODE_GRAPHICS__POSITION);
		createEReference(nodeGraphicsEClass, NODE_GRAPHICS__DIMENSION);
		createEReference(nodeGraphicsEClass, NODE_GRAPHICS__LINE);
		createEReference(nodeGraphicsEClass, NODE_GRAPHICS__FILL);

		// Create enums
		alignEEnum = createEEnum(ALIGN);
		shapeEEnum = createEEnum(SHAPE);
		styleEEnum = createEEnum(STYLE);

		// Create data types
		css2ColorEDataType = createEDataType(CSS2_COLOR);
		css2FontFamilyEDataType = createEDataType(CSS2_FONT_FAMILY);
		css2FontStyleEDataType = createEDataType(CSS2_FONT_STYLE);
		css2FontWeightEDataType = createEDataType(CSS2_FONT_WEIGHT);
		css2FontSizeEDataType = createEDataType(CSS2_FONT_SIZE);
		nonNegativeDecimalEDataType = createEDataType(NON_NEGATIVE_DECIMAL);
		urlEDataType = createEDataType(URL);
		rotationEDataType = createEDataType(ROTATION);
		decorationEDataType = createEDataType(DECORATION);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
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
		annotationGraphicsEClass.getESuperTypes().add(this.getGraphics());
		arcGraphicsEClass.getESuperTypes().add(this.getGraphics());
		nodeGraphicsEClass.getESuperTypes().add(this.getGraphics());

		// Initialize classes and features; add operations and parameters
		initEClass(annotationGraphicsEClass, AnnotationGraphics.class, "AnnotationGraphics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAnnotationGraphics_Fill(), this.getFill(), null, "fill", null, 0, 1, AnnotationGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationGraphics_Offset(), this.getCoordinate(), null, "offset", null, 0, 1, AnnotationGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationGraphics_Line(), this.getLine(), null, "line", null, 0, 1, AnnotationGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAnnotationGraphics_Font(), this.getFont(), null, "font", null, 0, 1, AnnotationGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(arcGraphicsEClass, ArcGraphics.class, "ArcGraphics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getArcGraphics_Line(), this.getLine(), null, "line", null, 0, 1, ArcGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getArcGraphics_Position(), this.getCoordinate(), null, "position", null, 0, -1, ArcGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(coordinateEClass, Coordinate.class, "Coordinate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCoordinate_X(), this.getNonNegativeDecimal(), "x", null, 1, 1, Coordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCoordinate_Y(), this.getNonNegativeDecimal(), "y", null, 1, 1, Coordinate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fillEClass, Fill.class, "Fill", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFill_Color(), this.getCSS2Color(), "color", null, 0, 1, Fill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFill_Image(), this.getURL(), "image", null, 0, 1, Fill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFill_GradientColor(), this.getCSS2Color(), "gradientColor", null, 0, 1, Fill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFill_GradientRotation(), this.getRotation(), "gradientRotation", null, 0, 1, Fill.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(fontEClass, Font.class, "Font", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFont_Family(), this.getCSS2FontFamily(), "family", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Style(), this.getCSS2FontStyle(), "style", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Weight(), this.getCSS2FontWeight(), "weight", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Size(), this.getCSS2FontSize(), "size", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Decoration(), this.getDecoration(), "decoration", null, 0, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Align(), this.getAlign(), "align", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getFont_Rotation(), this.getNonNegativeDecimal(), "rotation", null, 1, 1, Font.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(graphicsEClass, Graphics.class, "Graphics", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getGraphics_Parent(), this.getHasGraphics(), this.getHasGraphics_Graphics(), "parent", null, 1, 1, Graphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(hasGraphicsEClass, HasGraphics.class, "HasGraphics", IS_ABSTRACT, IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getHasGraphics_Graphics(), this.getGraphics(), this.getGraphics_Parent(), "graphics", null, 0, 1, HasGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(lineEClass, Line.class, "Line", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLine_Shape(), this.getShape(), "shape", null, 1, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLine_Color(), this.getCSS2Color(), "color", null, 1, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLine_Width(), this.getNonNegativeDecimal(), "width", null, 1, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getLine_Style(), this.getStyle(), "style", null, 1, 1, Line.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeGraphicsEClass, NodeGraphics.class, "NodeGraphics", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeGraphics_Position(), this.getCoordinate(), null, "position", null, 0, 1, NodeGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeGraphics_Dimension(), this.getCoordinate(), null, "dimension", null, 0, 1, NodeGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeGraphics_Line(), this.getLine(), null, "line", null, 0, 1, NodeGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeGraphics_Fill(), this.getFill(), null, "fill", null, 0, 1, NodeGraphics.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(alignEEnum, Align.class, "Align");
		addEEnumLiteral(alignEEnum, Align.LEFT);
		addEEnumLiteral(alignEEnum, Align.RIGHT);
		addEEnumLiteral(alignEEnum, Align.CENTER);

		initEEnum(shapeEEnum, Shape.class, "Shape");
		addEEnumLiteral(shapeEEnum, Shape.LINE);
		addEEnumLiteral(shapeEEnum, Shape.CURVE);

		initEEnum(styleEEnum, Style.class, "Style");
		addEEnumLiteral(styleEEnum, Style.SOLID);
		addEEnumLiteral(styleEEnum, Style.DASH);
		addEEnumLiteral(styleEEnum, Style.DOT);

		// Initialize data types
		initEDataType(css2ColorEDataType, String.class, "CSS2Color", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(css2FontFamilyEDataType, String.class, "CSS2FontFamily", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(css2FontStyleEDataType, String.class, "CSS2FontStyle", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(css2FontWeightEDataType, String.class, "CSS2FontWeight", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(css2FontSizeEDataType, String.class, "CSS2FontSize", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(nonNegativeDecimalEDataType, double.class, "NonNegativeDecimal", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(urlEDataType, java.net.URL.class, "URL", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(rotationEDataType, Rotation.class, "Rotation", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(decorationEDataType, Decoration.class, "Decoration", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //GraphicsPackageImpl
