/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics.impl;

import dk.au.daimi.ascoveco.cpn.model.graphics.*;
import java.net.URL;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import dk.au.daimi.ascoveco.cpn.model.graphics.Align;
import dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate;
import dk.au.daimi.ascoveco.cpn.model.graphics.Decoration;
import dk.au.daimi.ascoveco.cpn.model.graphics.Fill;
import dk.au.daimi.ascoveco.cpn.model.graphics.Font;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsFactory;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.Line;
import dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Rotation;
import dk.au.daimi.ascoveco.cpn.model.graphics.Shape;
import dk.au.daimi.ascoveco.cpn.model.graphics.Style;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Factory</b>. <!-- end-user-doc -->
 * @generated
 */
public class GraphicsFactoryImpl extends EFactoryImpl implements GraphicsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static GraphicsFactory init() {
		try {
			GraphicsFactory theGraphicsFactory = (GraphicsFactory)EPackage.Registry.INSTANCE.getEFactory("http:///dk/au/daimi/ascoveco/cpn/model/graphics.ecore"); 
			if (theGraphicsFactory != null) {
				return theGraphicsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new GraphicsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicsFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case GraphicsPackage.ANNOTATION_GRAPHICS: return createAnnotationGraphics();
			case GraphicsPackage.ARC_GRAPHICS: return createArcGraphics();
			case GraphicsPackage.COORDINATE: return createCoordinate();
			case GraphicsPackage.FILL: return createFill();
			case GraphicsPackage.FONT: return createFont();
			case GraphicsPackage.LINE: return createLine();
			case GraphicsPackage.NODE_GRAPHICS: return createNodeGraphics();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case GraphicsPackage.ALIGN:
				return createAlignFromString(eDataType, initialValue);
			case GraphicsPackage.SHAPE:
				return createShapeFromString(eDataType, initialValue);
			case GraphicsPackage.STYLE:
				return createStyleFromString(eDataType, initialValue);
			case GraphicsPackage.CSS2_COLOR:
				return createCSS2ColorFromString(eDataType, initialValue);
			case GraphicsPackage.CSS2_FONT_FAMILY:
				return createCSS2FontFamilyFromString(eDataType, initialValue);
			case GraphicsPackage.CSS2_FONT_STYLE:
				return createCSS2FontStyleFromString(eDataType, initialValue);
			case GraphicsPackage.CSS2_FONT_WEIGHT:
				return createCSS2FontWeightFromString(eDataType, initialValue);
			case GraphicsPackage.CSS2_FONT_SIZE:
				return createCSS2FontSizeFromString(eDataType, initialValue);
			case GraphicsPackage.NON_NEGATIVE_DECIMAL:
				return createNonNegativeDecimalFromString(eDataType, initialValue);
			case GraphicsPackage.URL:
				return createURLFromString(eDataType, initialValue);
			case GraphicsPackage.ROTATION:
				return createRotationFromString(eDataType, initialValue);
			case GraphicsPackage.DECORATION:
				return createDecorationFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case GraphicsPackage.ALIGN:
				return convertAlignToString(eDataType, instanceValue);
			case GraphicsPackage.SHAPE:
				return convertShapeToString(eDataType, instanceValue);
			case GraphicsPackage.STYLE:
				return convertStyleToString(eDataType, instanceValue);
			case GraphicsPackage.CSS2_COLOR:
				return convertCSS2ColorToString(eDataType, instanceValue);
			case GraphicsPackage.CSS2_FONT_FAMILY:
				return convertCSS2FontFamilyToString(eDataType, instanceValue);
			case GraphicsPackage.CSS2_FONT_STYLE:
				return convertCSS2FontStyleToString(eDataType, instanceValue);
			case GraphicsPackage.CSS2_FONT_WEIGHT:
				return convertCSS2FontWeightToString(eDataType, instanceValue);
			case GraphicsPackage.CSS2_FONT_SIZE:
				return convertCSS2FontSizeToString(eDataType, instanceValue);
			case GraphicsPackage.NON_NEGATIVE_DECIMAL:
				return convertNonNegativeDecimalToString(eDataType, instanceValue);
			case GraphicsPackage.URL:
				return convertURLToString(eDataType, instanceValue);
			case GraphicsPackage.ROTATION:
				return convertRotationToString(eDataType, instanceValue);
			case GraphicsPackage.DECORATION:
				return convertDecorationToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationGraphics createAnnotationGraphics() {
		AnnotationGraphicsImpl annotationGraphics = new AnnotationGraphicsImpl();
		return annotationGraphics;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ArcGraphics createArcGraphics() {
		ArcGraphicsImpl arcGraphics = new ArcGraphicsImpl();
		return arcGraphics;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Coordinate createCoordinate() {
		CoordinateImpl coordinate = new CoordinateImpl();
		return coordinate;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Fill createFill() {
		FillImpl fill = new FillImpl();
		return fill;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Font createFont() {
		FontImpl font = new FontImpl();
		return font;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Line createLine() {
		LineImpl line = new LineImpl();
		return line;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NodeGraphics createNodeGraphics() {
		NodeGraphicsImpl nodeGraphics = new NodeGraphicsImpl();
		return nodeGraphics;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Align createAlignFromString(EDataType eDataType, String initialValue) {
		Align result = Align.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAlignToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Shape createShapeFromString(EDataType eDataType, String initialValue) {
		Shape result = Shape.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShapeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Style createStyleFromString(EDataType eDataType, String initialValue) {
		Style result = Style.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createCSS2ColorFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCSS2ColorToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createCSS2FontFamilyFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCSS2FontFamilyToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createCSS2FontStyleFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCSS2FontStyleToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createCSS2FontWeightFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCSS2FontWeightToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String createCSS2FontSizeFromString(EDataType eDataType, String initialValue) {
		return (String)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCSS2FontSizeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Double createNonNegativeDecimalFromString(EDataType eDataType, String initialValue) {
		return (Double)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNonNegativeDecimalToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public URL createURLFromString(EDataType eDataType, String initialValue) {
		return (URL)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertURLToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Rotation createRotationFromString(EDataType eDataType, String initialValue) {
		return (Rotation)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRotationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Decoration createDecorationFromString(EDataType eDataType, String initialValue) {
		return (Decoration)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDecorationToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public GraphicsPackage getGraphicsPackage() {
		return (GraphicsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static GraphicsPackage getPackage() {
		return GraphicsPackage.eINSTANCE;
	}

} // GraphicsFactoryImpl
