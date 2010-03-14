/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import edu.umd.cs.findbugs.annotations.SuppressWarnings;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface GraphicsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "graphics";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dk/au/daimi/ascoveco/cpn/model/graphics.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.au.daimi.ascoveco.cpn.model.graphics";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GraphicsPackage eINSTANCE = dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsImpl <em>Graphics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getGraphics()
	 * @generated
	 */
	int GRAPHICS = 5;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS__PARENT = 0;

	/**
	 * The number of structural features of the '<em>Graphics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GRAPHICS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.AnnotationGraphicsImpl <em>Annotation Graphics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.AnnotationGraphicsImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getAnnotationGraphics()
	 * @generated
	 */
	int ANNOTATION_GRAPHICS = 0;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS__PARENT = GRAPHICS__PARENT;

	/**
	 * The feature id for the '<em><b>Fill</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS__FILL = GRAPHICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Offset</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS__OFFSET = GRAPHICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS__LINE = GRAPHICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Font</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS__FONT = GRAPHICS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Annotation Graphics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_GRAPHICS_FEATURE_COUNT = GRAPHICS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl <em>Arc Graphics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getArcGraphics()
	 * @generated
	 */
	int ARC_GRAPHICS = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_GRAPHICS__PARENT = GRAPHICS__PARENT;

	/**
	 * The feature id for the '<em><b>Line</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_GRAPHICS__LINE = GRAPHICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_GRAPHICS__POSITION = GRAPHICS_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Arc Graphics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_GRAPHICS_FEATURE_COUNT = GRAPHICS_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.CoordinateImpl <em>Coordinate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.CoordinateImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCoordinate()
	 * @generated
	 */
	int COORDINATE = 2;

	/**
	 * The feature id for the '<em><b>X</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COORDINATE__X = 0;

	/**
	 * The feature id for the '<em><b>Y</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COORDINATE__Y = 1;

	/**
	 * The number of structural features of the '<em>Coordinate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COORDINATE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl <em>Fill</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getFill()
	 * @generated
	 */
	int FILL = 3;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__COLOR = 0;

	/**
	 * The feature id for the '<em><b>Image</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__IMAGE = 1;

	/**
	 * The feature id for the '<em><b>Gradient Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__GRADIENT_COLOR = 2;

	/**
	 * The feature id for the '<em><b>Gradient Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL__GRADIENT_ROTATION = 3;

	/**
	 * The number of structural features of the '<em>Fill</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILL_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FontImpl <em>Font</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.FontImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getFont()
	 * @generated
	 */
	int FONT = 4;

	/**
	 * The feature id for the '<em><b>Family</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__FAMILY = 0;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__STYLE = 1;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__SIZE = 3;

	/**
	 * The feature id for the '<em><b>Decoration</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__DECORATION = 4;

	/**
	 * The feature id for the '<em><b>Align</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__ALIGN = 5;

	/**
	 * The feature id for the '<em><b>Rotation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT__ROTATION = 6;

	/**
	 * The number of structural features of the '<em>Font</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FONT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics <em>Has Graphics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getHasGraphics()
	 * @generated
	 */
	int HAS_GRAPHICS = 6;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_GRAPHICS__GRAPHICS = 0;

	/**
	 * The number of structural features of the '<em>Has Graphics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_GRAPHICS_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.LineImpl <em>Line</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.LineImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getLine()
	 * @generated
	 */
	int LINE = 7;

	/**
	 * The feature id for the '<em><b>Shape</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__SHAPE = 0;

	/**
	 * The feature id for the '<em><b>Color</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__COLOR = 1;

	/**
	 * The feature id for the '<em><b>Width</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__WIDTH = 2;

	/**
	 * The feature id for the '<em><b>Style</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE__STYLE = 3;

	/**
	 * The number of structural features of the '<em>Line</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LINE_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.NodeGraphicsImpl <em>Node Graphics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.NodeGraphicsImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getNodeGraphics()
	 * @generated
	 */
	int NODE_GRAPHICS = 8;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS__PARENT = GRAPHICS__PARENT;

	/**
	 * The feature id for the '<em><b>Position</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS__POSITION = GRAPHICS_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Dimension</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS__DIMENSION = GRAPHICS_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Line</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS__LINE = GRAPHICS_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Fill</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS__FILL = GRAPHICS_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Node Graphics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_GRAPHICS_FEATURE_COUNT = GRAPHICS_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Align <em>Align</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Align
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getAlign()
	 * @generated
	 */
	int ALIGN = 9;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Shape <em>Shape</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Shape
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getShape()
	 * @generated
	 */
	int SHAPE = 10;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Style <em>Style</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Style
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getStyle()
	 * @generated
	 */
	int STYLE = 11;

	/**
	 * The meta object id for the '<em>CSS2 Color</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2Color()
	 * @generated
	 */
	int CSS2_COLOR = 12;

	/**
	 * The meta object id for the '<em>CSS2 Font Family</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontFamily()
	 * @generated
	 */
	int CSS2_FONT_FAMILY = 13;

	/**
	 * The meta object id for the '<em>CSS2 Font Style</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontStyle()
	 * @generated
	 */
	int CSS2_FONT_STYLE = 14;

	/**
	 * The meta object id for the '<em>CSS2 Font Weight</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontWeight()
	 * @generated
	 */
	int CSS2_FONT_WEIGHT = 15;

	/**
	 * The meta object id for the '<em>CSS2 Font Size</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.lang.String
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontSize()
	 * @generated
	 */
	int CSS2_FONT_SIZE = 16;

	/**
	 * The meta object id for the '<em>Non Negative Decimal</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getNonNegativeDecimal()
	 * @generated
	 */
	int NON_NEGATIVE_DECIMAL = 17;

	/**
	 * The meta object id for the '<em>URL</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.net.URL
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getURL()
	 * @generated
	 */
	int URL = 18;

	/**
	 * The meta object id for the '<em>Rotation</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Rotation
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getRotation()
	 * @generated
	 */
	int ROTATION = 19;

	/**
	 * The meta object id for the '<em>Decoration</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Decoration
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getDecoration()
	 * @generated
	 */
	int DECORATION = 20;


	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics <em>Annotation Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics
	 * @generated
	 */
	EClass getAnnotationGraphics();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getFill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fill</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getFill()
	 * @see #getAnnotationGraphics()
	 * @generated
	 */
	EReference getAnnotationGraphics_Fill();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getOffset <em>Offset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Offset</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getOffset()
	 * @see #getAnnotationGraphics()
	 * @generated
	 */
	EReference getAnnotationGraphics_Offset();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Line</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getLine()
	 * @see #getAnnotationGraphics()
	 * @generated
	 */
	EReference getAnnotationGraphics_Line();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getFont <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Font</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics#getFont()
	 * @see #getAnnotationGraphics()
	 * @generated
	 */
	EReference getAnnotationGraphics_Font();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics <em>Arc Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics
	 * @generated
	 */
	EClass getArcGraphics();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Line</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics#getLine()
	 * @see #getArcGraphics()
	 * @generated
	 */
	EReference getArcGraphics_Line();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Position</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics#getPosition()
	 * @see #getArcGraphics()
	 * @generated
	 */
	EReference getArcGraphics_Position();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate <em>Coordinate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Coordinate</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate
	 * @generated
	 */
	EClass getCoordinate();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getX <em>X</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>X</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getX()
	 * @see #getCoordinate()
	 * @generated
	 */
	EAttribute getCoordinate_X();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getY <em>Y</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Y</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate#getY()
	 * @see #getCoordinate()
	 * @generated
	 */
	EAttribute getCoordinate_Y();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fill</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill
	 * @generated
	 */
	EClass getFill();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getColor()
	 * @see #getFill()
	 * @generated
	 */
	EAttribute getFill_Color();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getImage <em>Image</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Image</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getImage()
	 * @see #getFill()
	 * @generated
	 */
	EAttribute getFill_Image();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getGradientColor <em>Gradient Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gradient Color</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getGradientColor()
	 * @see #getFill()
	 * @generated
	 */
	EAttribute getFill_GradientColor();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getGradientRotation <em>Gradient Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Gradient Rotation</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill#getGradientRotation()
	 * @see #getFill()
	 * @generated
	 */
	EAttribute getFill_GradientRotation();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font <em>Font</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Font</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font
	 * @generated
	 */
	EClass getFont();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getFamily <em>Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Family</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getFamily()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Family();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getStyle()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Style();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getWeight()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Weight();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getSize <em>Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Size</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getSize()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Size();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getDecoration <em>Decoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Decoration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getDecoration()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Decoration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getAlign <em>Align</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Align</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getAlign()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Align();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font#getRotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rotation</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font#getRotation()
	 * @see #getFont()
	 * @generated
	 */
	EAttribute getFont_Rotation();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Graphics <em>Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Graphics
	 * @generated
	 */
	EClass getGraphics();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Graphics#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Graphics#getParent()
	 * @see #getGraphics()
	 * @generated
	 */
	EReference getGraphics_Parent();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics <em>Has Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics
	 * @generated
	 */
	EClass getHasGraphics();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics#getGraphics <em>Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics#getGraphics()
	 * @see #getHasGraphics()
	 * @generated
	 */
	EReference getHasGraphics_Graphics();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Line</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line
	 * @generated
	 */
	EClass getLine();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line#getShape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Shape</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line#getShape()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_Shape();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line#getColor <em>Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Color</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line#getColor()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_Color();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line#getWidth <em>Width</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Width</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line#getWidth()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_Width();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line#getStyle <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Style</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line#getStyle()
	 * @see #getLine()
	 * @generated
	 */
	EAttribute getLine_Style();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics <em>Node Graphics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node Graphics</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics
	 * @generated
	 */
	EClass getNodeGraphics();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getPosition <em>Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Position</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getPosition()
	 * @see #getNodeGraphics()
	 * @generated
	 */
	EReference getNodeGraphics_Position();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getDimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Dimension</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getDimension()
	 * @see #getNodeGraphics()
	 * @generated
	 */
	EReference getNodeGraphics_Dimension();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getLine <em>Line</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Line</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getLine()
	 * @see #getNodeGraphics()
	 * @generated
	 */
	EReference getNodeGraphics_Line();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getFill <em>Fill</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Fill</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics#getFill()
	 * @see #getNodeGraphics()
	 * @generated
	 */
	EReference getNodeGraphics_Fill();

	/**
	 * Returns the meta object for enum '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Align <em>Align</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Align</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Align
	 * @generated
	 */
	EEnum getAlign();

	/**
	 * Returns the meta object for enum '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Shape <em>Shape</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Shape</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Shape
	 * @generated
	 */
	EEnum getShape();

	/**
	 * Returns the meta object for enum '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Style <em>Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Style</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Style
	 * @generated
	 */
	EEnum getStyle();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>CSS2 Color</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSS2 Color</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getCSS2Color();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>CSS2 Font Family</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSS2 Font Family</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getCSS2FontFamily();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>CSS2 Font Style</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSS2 Font Style</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getCSS2FontStyle();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>CSS2 Font Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSS2 Font Weight</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getCSS2FontWeight();

	/**
	 * Returns the meta object for data type '{@link java.lang.String <em>CSS2 Font Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>CSS2 Font Size</em>'.
	 * @see java.lang.String
	 * @model instanceClass="java.lang.String"
	 * @generated
	 */
	EDataType getCSS2FontSize();

	/**
	 * Returns the meta object for data type '<em>Non Negative Decimal</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Non Negative Decimal</em>'.
	 * @model instanceClass="double"
	 * @generated
	 */
	EDataType getNonNegativeDecimal();

	/**
	 * Returns the meta object for data type '{@link java.net.URL <em>URL</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>URL</em>'.
	 * @see java.net.URL
	 * @model instanceClass="java.net.URL"
	 * @generated
	 */
	EDataType getURL();

	/**
	 * Returns the meta object for data type '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Rotation <em>Rotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Rotation</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Rotation
	 * @model instanceClass="dk.au.daimi.ascoveco.cpn.model.graphics.Rotation"
	 * @generated
	 */
	EDataType getRotation();

	/**
	 * Returns the meta object for data type '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Decoration <em>Decoration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Decoration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Decoration
	 * @model instanceClass="dk.au.daimi.ascoveco.cpn.model.graphics.Decoration"
	 * @generated
	 */
	EDataType getDecoration();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	GraphicsFactory getGraphicsFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.AnnotationGraphicsImpl <em>Annotation Graphics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.AnnotationGraphicsImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getAnnotationGraphics()
		 * @generated
		 */
		EClass ANNOTATION_GRAPHICS = eINSTANCE.getAnnotationGraphics();

		/**
		 * The meta object literal for the '<em><b>Fill</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_GRAPHICS__FILL = eINSTANCE.getAnnotationGraphics_Fill();

		/**
		 * The meta object literal for the '<em><b>Offset</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_GRAPHICS__OFFSET = eINSTANCE.getAnnotationGraphics_Offset();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_GRAPHICS__LINE = eINSTANCE.getAnnotationGraphics_Line();

		/**
		 * The meta object literal for the '<em><b>Font</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANNOTATION_GRAPHICS__FONT = eINSTANCE.getAnnotationGraphics_Font();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl <em>Arc Graphics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.ArcGraphicsImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getArcGraphics()
		 * @generated
		 */
		EClass ARC_GRAPHICS = eINSTANCE.getArcGraphics();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_GRAPHICS__LINE = eINSTANCE.getArcGraphics_Line();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC_GRAPHICS__POSITION = eINSTANCE.getArcGraphics_Position();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.CoordinateImpl <em>Coordinate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.CoordinateImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCoordinate()
		 * @generated
		 */
		EClass COORDINATE = eINSTANCE.getCoordinate();

		/**
		 * The meta object literal for the '<em><b>X</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COORDINATE__X = eINSTANCE.getCoordinate_X();

		/**
		 * The meta object literal for the '<em><b>Y</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COORDINATE__Y = eINSTANCE.getCoordinate_Y();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl <em>Fill</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.FillImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getFill()
		 * @generated
		 */
		EClass FILL = eINSTANCE.getFill();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL__COLOR = eINSTANCE.getFill_Color();

		/**
		 * The meta object literal for the '<em><b>Image</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL__IMAGE = eINSTANCE.getFill_Image();

		/**
		 * The meta object literal for the '<em><b>Gradient Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL__GRADIENT_COLOR = eINSTANCE.getFill_GradientColor();

		/**
		 * The meta object literal for the '<em><b>Gradient Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FILL__GRADIENT_ROTATION = eINSTANCE.getFill_GradientRotation();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.FontImpl <em>Font</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.FontImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getFont()
		 * @generated
		 */
		EClass FONT = eINSTANCE.getFont();

		/**
		 * The meta object literal for the '<em><b>Family</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__FAMILY = eINSTANCE.getFont_Family();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__STYLE = eINSTANCE.getFont_Style();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__WEIGHT = eINSTANCE.getFont_Weight();

		/**
		 * The meta object literal for the '<em><b>Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__SIZE = eINSTANCE.getFont_Size();

		/**
		 * The meta object literal for the '<em><b>Decoration</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__DECORATION = eINSTANCE.getFont_Decoration();

		/**
		 * The meta object literal for the '<em><b>Align</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__ALIGN = eINSTANCE.getFont_Align();

		/**
		 * The meta object literal for the '<em><b>Rotation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FONT__ROTATION = eINSTANCE.getFont_Rotation();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsImpl <em>Graphics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getGraphics()
		 * @generated
		 */
		EClass GRAPHICS = eINSTANCE.getGraphics();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GRAPHICS__PARENT = eINSTANCE.getGraphics_Parent();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics <em>Has Graphics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getHasGraphics()
		 * @generated
		 */
		EClass HAS_GRAPHICS = eINSTANCE.getHasGraphics();

		/**
		 * The meta object literal for the '<em><b>Graphics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_GRAPHICS__GRAPHICS = eINSTANCE.getHasGraphics_Graphics();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.LineImpl <em>Line</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.LineImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getLine()
		 * @generated
		 */
		EClass LINE = eINSTANCE.getLine();

		/**
		 * The meta object literal for the '<em><b>Shape</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__SHAPE = eINSTANCE.getLine_Shape();

		/**
		 * The meta object literal for the '<em><b>Color</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__COLOR = eINSTANCE.getLine_Color();

		/**
		 * The meta object literal for the '<em><b>Width</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__WIDTH = eINSTANCE.getLine_Width();

		/**
		 * The meta object literal for the '<em><b>Style</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LINE__STYLE = eINSTANCE.getLine_Style();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.impl.NodeGraphicsImpl <em>Node Graphics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.NodeGraphicsImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getNodeGraphics()
		 * @generated
		 */
		EClass NODE_GRAPHICS = eINSTANCE.getNodeGraphics();

		/**
		 * The meta object literal for the '<em><b>Position</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_GRAPHICS__POSITION = eINSTANCE.getNodeGraphics_Position();

		/**
		 * The meta object literal for the '<em><b>Dimension</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_GRAPHICS__DIMENSION = eINSTANCE.getNodeGraphics_Dimension();

		/**
		 * The meta object literal for the '<em><b>Line</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_GRAPHICS__LINE = eINSTANCE.getNodeGraphics_Line();

		/**
		 * The meta object literal for the '<em><b>Fill</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE_GRAPHICS__FILL = eINSTANCE.getNodeGraphics_Fill();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Align <em>Align</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Align
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getAlign()
		 * @generated
		 */
		EEnum ALIGN = eINSTANCE.getAlign();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Shape <em>Shape</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Shape
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getShape()
		 * @generated
		 */
		EEnum SHAPE = eINSTANCE.getShape();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Style <em>Style</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Style
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getStyle()
		 * @generated
		 */
		EEnum STYLE = eINSTANCE.getStyle();

		/**
		 * The meta object literal for the '<em>CSS2 Color</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2Color()
		 * @generated
		 */
		EDataType CSS2_COLOR = eINSTANCE.getCSS2Color();

		/**
		 * The meta object literal for the '<em>CSS2 Font Family</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontFamily()
		 * @generated
		 */
		EDataType CSS2_FONT_FAMILY = eINSTANCE.getCSS2FontFamily();

		/**
		 * The meta object literal for the '<em>CSS2 Font Style</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontStyle()
		 * @generated
		 */
		EDataType CSS2_FONT_STYLE = eINSTANCE.getCSS2FontStyle();

		/**
		 * The meta object literal for the '<em>CSS2 Font Weight</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontWeight()
		 * @generated
		 */
		EDataType CSS2_FONT_WEIGHT = eINSTANCE.getCSS2FontWeight();

		/**
		 * The meta object literal for the '<em>CSS2 Font Size</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.lang.String
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getCSS2FontSize()
		 * @generated
		 */
		EDataType CSS2_FONT_SIZE = eINSTANCE.getCSS2FontSize();

		/**
		 * The meta object literal for the '<em>Non Negative Decimal</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getNonNegativeDecimal()
		 * @generated
		 */
		EDataType NON_NEGATIVE_DECIMAL = eINSTANCE.getNonNegativeDecimal();

		/**
		 * The meta object literal for the '<em>URL</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.net.URL
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getURL()
		 * @generated
		 */
		EDataType URL = eINSTANCE.getURL();

		/**
		 * The meta object literal for the '<em>Rotation</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Rotation
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getRotation()
		 * @generated
		 */
		EDataType ROTATION = eINSTANCE.getRotation();

		/**
		 * The meta object literal for the '<em>Decoration</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Decoration
		 * @see dk.au.daimi.ascoveco.cpn.model.graphics.impl.GraphicsPackageImpl#getDecoration()
		 * @generated
		 */
		EDataType DECORATION = eINSTANCE.getDecoration();

	}

} //GraphicsPackage
