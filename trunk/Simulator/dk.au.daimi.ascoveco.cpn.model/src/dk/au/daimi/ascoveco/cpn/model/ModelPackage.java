/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see dk.au.daimi.ascoveco.cpn.model.ModelFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface ModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "model";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dk/au/daimi/ascoveco/cpn/model.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.au.daimi.ascoveco.cpn.model";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ModelPackage eINSTANCE = dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HasToolInfo <em>Has Tool Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HasToolInfo
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasToolInfo()
	 * @generated
	 */
	int HAS_TOOL_INFO = 6;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TOOL_INFO__TOOLINFO = 0;

	/**
	 * The number of structural features of the '<em>Has Tool Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_TOOL_INFO_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.LabelImpl <em>Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.LabelImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getLabel()
	 * @generated
	 */
	int LABEL = 7;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__TOOLINFO = HAS_TOOL_INFO__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL__PARENT = HAS_TOOL_INFO_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LABEL_FEATURE_COUNT = HAS_TOOL_INFO_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TOOLINFO = LABEL__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__PARENT = LABEL__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__GRAPHICS = LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__TEXT = LABEL_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = LABEL_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.AttributeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HasId <em>Has Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HasId
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasId()
	 * @generated
	 */
	int HAS_ID = 3;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HasLabel <em>Has Label</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HasLabel
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasLabel()
	 * @generated
	 */
	int HAS_LABEL = 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HasName <em>Has Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HasName
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasName()
	 * @generated
	 */
	int HAS_NAME = 5;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.NameImpl <em>Name</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.NameImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getName_()
	 * @generated
	 */
	int NAME = 8;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ObjectImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getObject()
	 * @generated
	 */
	int OBJECT = 10;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 9;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl <em>Page</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.PageImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPage()
	 * @generated
	 */
	int PAGE = 11;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl <em>Petri Net</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPetriNet()
	 * @generated
	 */
	int PETRI_NET = 12;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl <em>Place Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPlaceNode()
	 * @generated
	 */
	int PLACE_NODE = 14;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceImpl <em>Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.PlaceImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPlace()
	 * @generated
	 */
	int PLACE = 13;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.RefPlaceImpl <em>Ref Place</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.RefPlaceImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getRefPlace()
	 * @generated
	 */
	int REF_PLACE = 15;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl <em>Transition Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTransitionNode()
	 * @generated
	 */
	int TRANSITION_NODE = 19;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.RefTransImpl <em>Ref Trans</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.RefTransImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getRefTrans()
	 * @generated
	 */
	int REF_TRANS = 16;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ToolInfoImpl <em>Tool Info</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ToolInfoImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getToolInfo()
	 * @generated
	 */
	int TOOL_INFO = 17;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionImpl <em>Transition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.TransitionImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTransition()
	 * @generated
	 */
	int TRANSITION = 18;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLMarkingImpl <em>HL Marking</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLMarkingImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLMarking()
	 * @generated
	 */
	int HL_MARKING = 20;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.TypeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getType()
	 * @generated
	 */
	int TYPE = 21;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin <em>HL Place Addin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLPlaceAddin()
	 * @generated
	 */
	int HL_PLACE_ADDIN = 22;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin <em>HL Annotation Addin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLAnnotationAddin()
	 * @generated
	 */
	int HL_ANNOTATION_ADDIN = 23;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin <em>HL Arc Addin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcAddin()
	 * @generated
	 */
	int HL_ARC_ADDIN = 24;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ARC_ADDIN__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Hlinscription</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ARC_ADDIN__HLINSCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>HL Arc Addin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ARC_ADDIN_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__TYPE = HL_ARC_ADDIN__TYPE;

	/**
	 * The feature id for the '<em><b>Hlinscription</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__HLINSCRIPTION = HL_ARC_ADDIN__HLINSCRIPTION;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ID = HL_ARC_ADDIN_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__SOURCE = HL_ARC_ADDIN_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__TARGET = HL_ARC_ADDIN_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__PAGE = HL_ARC_ADDIN_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = HL_ARC_ADDIN_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__TOOLINFO = LABEL__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__PARENT = LABEL__PARENT;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = LABEL_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ID__ID = 0;

	/**
	 * The number of structural features of the '<em>Has Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_ID_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_LABEL__LABEL = 0;

	/**
	 * The number of structural features of the '<em>Has Label</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_LABEL_FEATURE_COUNT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME__NAME = 0;

	/**
	 * The number of structural features of the '<em>Has Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HAS_NAME_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLAnnotationImpl <em>HL Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLAnnotationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLAnnotation()
	 * @generated
	 */
	int HL_ANNOTATION = 25;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>HL Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__TOOLINFO = HL_ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__PARENT = HL_ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__GRAPHICS = HL_ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME__TEXT = HL_ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>Name</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAME_FEATURE_COUNT = HL_ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__TOOLINFO = HAS_TOOL_INFO__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__GRAPHICS = HAS_TOOL_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__ID = HAS_TOOL_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__LABEL = HAS_TOOL_INFO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__NAME = HAS_TOOL_INFO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT__PAGE = HAS_TOOL_INFO_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OBJECT_FEATURE_COUNT = HAS_TOOL_INFO_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TOOLINFO = OBJECT__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__GRAPHICS = OBJECT__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = OBJECT__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__LABEL = OBJECT__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__NAME = OBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__PAGE = OBJECT__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__SOURCE_ARC = OBJECT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__TARGET_ARC = OBJECT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = OBJECT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__NAME = HAS_NAME__NAME;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__LABEL = HAS_NAME_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ID = HAS_NAME_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Petri Net</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__PETRI_NET = HAS_NAME_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Object</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__OBJECT = HAS_NAME_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Arc</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE__ARC = HAS_NAME_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Page</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAGE_FEATURE_COUNT = HAS_NAME_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__TOOLINFO = HAS_TOOL_INFO__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__ID = HAS_TOOL_INFO_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__LABEL = HAS_TOOL_INFO_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__NAME = HAS_TOOL_INFO_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__TYPE = HAS_TOOL_INFO_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Page</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__PAGE = HAS_TOOL_INFO_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Fusion Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET__FUSION_GROUPS = HAS_TOOL_INFO_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Petri Net</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PETRI_NET_FEATURE_COUNT = HAS_TOOL_INFO_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__TOOLINFO = NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__GRAPHICS = NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__LABEL = NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__PAGE = NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__SOURCE_ARC = NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__TARGET_ARC = NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__TYPE = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE__INITIAL_MARKING = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Place Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TOOLINFO = PLACE_NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__GRAPHICS = PLACE_NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__ID = PLACE_NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__LABEL = PLACE_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__NAME = PLACE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__PAGE = PLACE_NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__SOURCE_ARC = PLACE_NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TARGET_ARC = PLACE_NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__TYPE = PLACE_NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__INITIAL_MARKING = PLACE_NODE__INITIAL_MARKING;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE__REFERENCES = PLACE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLACE_FEATURE_COUNT = PLACE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__TOOLINFO = PLACE_NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__GRAPHICS = PLACE_NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__ID = PLACE_NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__LABEL = PLACE_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__NAME = PLACE_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__PAGE = PLACE_NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__SOURCE_ARC = PLACE_NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__TARGET_ARC = PLACE_NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__TYPE = PLACE_NODE__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__INITIAL_MARKING = PLACE_NODE__INITIAL_MARKING;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE__REF = PLACE_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ref Place</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_PLACE_FEATURE_COUNT = PLACE_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__TOOLINFO = NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__GRAPHICS = NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__LABEL = NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__PAGE = NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__SOURCE_ARC = NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__TARGET_ARC = NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__CONDITION = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__CODE = NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE__TIME = NODE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Transition Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_NODE_FEATURE_COUNT = NODE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__TOOLINFO = TRANSITION_NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__GRAPHICS = TRANSITION_NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__ID = TRANSITION_NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__LABEL = TRANSITION_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__NAME = TRANSITION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__PAGE = TRANSITION_NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__SOURCE_ARC = TRANSITION_NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__TARGET_ARC = TRANSITION_NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__CONDITION = TRANSITION_NODE__CONDITION;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__CODE = TRANSITION_NODE__CODE;

	/**
	 * The feature id for the '<em><b>Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__TIME = TRANSITION_NODE__TIME;

	/**
	 * The feature id for the '<em><b>Ref</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS__REF = TRANSITION_NODE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Ref Trans</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REF_TRANS_FEATURE_COUNT = TRANSITION_NODE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Tool</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO__TOOL = 0;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO__VERSION = 1;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO__PARENT = 2;

	/**
	 * The number of structural features of the '<em>Tool Info</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TOOL_INFO_FEATURE_COUNT = 3;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TOOLINFO = TRANSITION_NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__GRAPHICS = TRANSITION_NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__ID = TRANSITION_NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__LABEL = TRANSITION_NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__NAME = TRANSITION_NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__PAGE = TRANSITION_NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__SOURCE_ARC = TRANSITION_NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TARGET_ARC = TRANSITION_NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__CONDITION = TRANSITION_NODE__CONDITION;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__CODE = TRANSITION_NODE__CODE;

	/**
	 * The feature id for the '<em><b>Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION__TIME = TRANSITION_NODE__TIME;

	/**
	 * The number of structural features of the '<em>Transition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRANSITION_FEATURE_COUNT = TRANSITION_NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_MARKING__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_MARKING__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_MARKING__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_MARKING__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>HL Marking</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_MARKING_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_PLACE_ADDIN__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_PLACE_ADDIN__INITIAL_MARKING = 1;

	/**
	 * The number of structural features of the '<em>HL Place Addin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_PLACE_ADDIN_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION_ADDIN__TEXT = 0;

	/**
	 * The number of structural features of the '<em>HL Annotation Addin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ANNOTATION_ADDIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ConditionImpl <em>Condition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ConditionImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCondition()
	 * @generated
	 */
	int CONDITION = 26;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>Condition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin <em>HL Transition Addin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLTransitionAddin()
	 * @generated
	 */
	int HL_TRANSITION_ADDIN = 27;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_TRANSITION_ADDIN__CONDITION = 0;

	/**
	 * The number of structural features of the '<em>HL Transition Addin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_TRANSITION_ADDIN_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin <em>CPN Tools Transition Addin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCPNToolsTransitionAddin()
	 * @generated
	 */
	int CPN_TOOLS_TRANSITION_ADDIN = 28;

	/**
	 * The feature id for the '<em><b>Code</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TOOLS_TRANSITION_ADDIN__CODE = 0;

	/**
	 * The feature id for the '<em><b>Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TOOLS_TRANSITION_ADDIN__TIME = 1;

	/**
	 * The number of structural features of the '<em>CPN Tools Transition Addin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CPN_TOOLS_TRANSITION_ADDIN_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.CodeImpl <em>Code</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.CodeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCode()
	 * @generated
	 */
	int CODE = 29;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>Code</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CODE_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TimeImpl <em>Time</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.TimeImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTime()
	 * @generated
	 */
	int TIME = 30;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME__TEXT = ANNOTATION__TEXT;

	/**
	 * The number of structural features of the '<em>Time</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TIME_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLDeclarationImpl <em>HL Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLDeclaration()
	 * @generated
	 */
	int HL_DECLARATION = 31;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__TOOLINFO = ANNOTATION__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Parent</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__PARENT = ANNOTATION__PARENT;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__GRAPHICS = ANNOTATION__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Text</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__TEXT = ANNOTATION__TEXT;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__ID = ANNOTATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Structure</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION__STRUCTURE = ANNOTATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>HL Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_DECLARATION_FEATURE_COUNT = ANNOTATION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 32;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__TOOLINFO = NODE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__GRAPHICS = NODE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__ID = NODE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__LABEL = NODE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__NAME = NODE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__PAGE = NODE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__SOURCE_ARC = NODE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__TARGET_ARC = NODE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Parameter Assignment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__PARAMETER_ASSIGNMENT = NODE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Sub Page ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__SUB_PAGE_ID = NODE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = NODE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ParameterAssignmentImpl <em>Parameter Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ParameterAssignmentImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getParameterAssignment()
	 * @generated
	 */
	int PARAMETER_ASSIGNMENT = 33;

	/**
	 * The feature id for the '<em><b>Parameter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ASSIGNMENT__PARAMETER = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ASSIGNMENT__VALUE = 1;

	/**
	 * The feature id for the '<em><b>Instance</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ASSIGNMENT__INSTANCE = 2;

	/**
	 * The number of structural features of the '<em>Parameter Assignment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_ASSIGNMENT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.FusionGroupImpl <em>Fusion Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.FusionGroupImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getFusionGroup()
	 * @generated
	 */
	int FUSION_GROUP = 34;

	/**
	 * The feature id for the '<em><b>Toolinfo</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__TOOLINFO = PLACE__TOOLINFO;

	/**
	 * The feature id for the '<em><b>Graphics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__GRAPHICS = PLACE__GRAPHICS;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__ID = PLACE__ID;

	/**
	 * The feature id for the '<em><b>Label</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__LABEL = PLACE__LABEL;

	/**
	 * The feature id for the '<em><b>Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__NAME = PLACE__NAME;

	/**
	 * The feature id for the '<em><b>Page</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__PAGE = PLACE__PAGE;

	/**
	 * The feature id for the '<em><b>Source Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__SOURCE_ARC = PLACE__SOURCE_ARC;

	/**
	 * The feature id for the '<em><b>Target Arc</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__TARGET_ARC = PLACE__TARGET_ARC;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__TYPE = PLACE__TYPE;

	/**
	 * The feature id for the '<em><b>Initial Marking</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__INITIAL_MARKING = PLACE__INITIAL_MARKING;

	/**
	 * The feature id for the '<em><b>References</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__REFERENCES = PLACE__REFERENCES;

	/**
	 * The feature id for the '<em><b>Petri Net</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP__PETRI_NET = PLACE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Fusion Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUSION_GROUP_FEATURE_COUNT = PLACE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type 1</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcType_1()
	 * @generated
	 */
	int HL_ARC_TYPE_1 = 35;

	/**
	 * The number of structural features of the '<em>HL Arc Type 1</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HL_ARC_TYPE_1_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcType()
	 * @generated
	 */
	int HL_ARC_TYPE = 36;


	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.Arc#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getSource()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Source();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.Arc#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getTarget()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Target();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.Arc#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Page</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc#getPage()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Page();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HasId <em>Has Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Id</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasId
	 * @generated
	 */
	EClass getHasId();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.HasId#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasId#getId()
	 * @see #getHasId()
	 * @generated
	 */
	EAttribute getHasId_Id();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HasLabel <em>Has Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Label</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasLabel
	 * @generated
	 */
	EClass getHasLabel();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.HasLabel#getLabel <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Label</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasLabel#getLabel()
	 * @see #getHasLabel()
	 * @generated
	 */
	EReference getHasLabel_Label();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HasName <em>Has Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasName
	 * @generated
	 */
	EClass getHasName();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.HasName#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasName#getName()
	 * @see #getHasName()
	 * @generated
	 */
	EReference getHasName_Name();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HasToolInfo <em>Has Tool Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Has Tool Info</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasToolInfo
	 * @generated
	 */
	EClass getHasToolInfo();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.HasToolInfo#getToolinfo <em>Toolinfo</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Toolinfo</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasToolInfo#getToolinfo()
	 * @see #getHasToolInfo()
	 * @generated
	 */
	EReference getHasToolInfo_Toolinfo();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Label <em>Label</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Label</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Label
	 * @generated
	 */
	EClass getLabel();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.Label#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Label#getParent()
	 * @see #getLabel()
	 * @generated
	 */
	EReference getLabel_Parent();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Name <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Name
	 * @generated
	 */
	EClass getName_();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the reference list '{@link dk.au.daimi.ascoveco.cpn.model.Node#getSourceArc <em>Source Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Source Arc</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Node#getSourceArc()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_SourceArc();

	/**
	 * Returns the meta object for the reference list '{@link dk.au.daimi.ascoveco.cpn.model.Node#getTargetArc <em>Target Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target Arc</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Node#getTargetArc()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_TargetArc();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Object <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Object
	 * @generated
	 */
	EClass getObject();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.Object#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Page</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Object#getPage()
	 * @see #getObject()
	 * @generated
	 */
	EReference getObject_Page();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Page <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Page</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Page
	 * @generated
	 */
	EClass getPage();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.Page#getPetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Petri Net</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#getPetriNet()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_PetriNet();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.Page#getObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Object</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#getObject()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Object();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.Page#getArc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arc</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#getArc()
	 * @see #getPage()
	 * @generated
	 */
	EReference getPage_Arc();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Petri Net</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet
	 * @generated
	 */
	EClass getPetriNet();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet#getType()
	 * @see #getPetriNet()
	 * @generated
	 */
	EAttribute getPetriNet_Type();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet#getPage <em>Page</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Page</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet#getPage()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_Page();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet#getFusionGroups <em>Fusion Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Fusion Groups</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet#getFusionGroups()
	 * @see #getPetriNet()
	 * @generated
	 */
	EReference getPetriNet_FusionGroups();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Place <em>Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Place
	 * @generated
	 */
	EClass getPlace();

	/**
	 * Returns the meta object for the reference list '{@link dk.au.daimi.ascoveco.cpn.model.Place#getReferences <em>References</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>References</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Place#getReferences()
	 * @see #getPlace()
	 * @generated
	 */
	EReference getPlace_References();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.PlaceNode <em>Place Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Place Node</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.PlaceNode
	 * @generated
	 */
	EClass getPlaceNode();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.RefPlace <em>Ref Place</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref Place</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefPlace
	 * @generated
	 */
	EClass getRefPlace();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.RefPlace#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefPlace#getRef()
	 * @see #getRefPlace()
	 * @generated
	 */
	EReference getRefPlace_Ref();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.RefTrans <em>Ref Trans</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ref Trans</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefTrans
	 * @generated
	 */
	EClass getRefTrans();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.RefTrans#getRef <em>Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Ref</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefTrans#getRef()
	 * @see #getRefTrans()
	 * @generated
	 */
	EReference getRefTrans_Ref();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.ToolInfo <em>Tool Info</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tool Info</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ToolInfo
	 * @generated
	 */
	EClass getToolInfo();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.ToolInfo#getTool <em>Tool</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Tool</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ToolInfo#getTool()
	 * @see #getToolInfo()
	 * @generated
	 */
	EAttribute getToolInfo_Tool();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.ToolInfo#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ToolInfo#getVersion()
	 * @see #getToolInfo()
	 * @generated
	 */
	EAttribute getToolInfo_Version();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.ToolInfo#getParent <em>Parent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Parent</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ToolInfo#getParent()
	 * @see #getToolInfo()
	 * @generated
	 */
	EReference getToolInfo_Parent();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Transition <em>Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Transition
	 * @generated
	 */
	EClass getTransition();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.TransitionNode <em>Transition Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Transition Node</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.TransitionNode
	 * @generated
	 */
	EClass getTransitionNode();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLMarking <em>HL Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Marking</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLMarking
	 * @generated
	 */
	EClass getHLMarking();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Type
	 * @generated
	 */
	EClass getType();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin <em>HL Place Addin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Place Addin</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin
	 * @generated
	 */
	EClass getHLPlaceAddin();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getType()
	 * @see #getHLPlaceAddin()
	 * @generated
	 */
	EReference getHLPlaceAddin_Type();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getInitialMarking <em>Initial Marking</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Initial Marking</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin#getInitialMarking()
	 * @see #getHLPlaceAddin()
	 * @generated
	 */
	EReference getHLPlaceAddin_InitialMarking();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin <em>HL Annotation Addin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Annotation Addin</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin
	 * @generated
	 */
	EClass getHLAnnotationAddin();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#getText <em>Text</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Text</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin#getText()
	 * @see #getHLAnnotationAddin()
	 * @generated
	 */
	EAttribute getHLAnnotationAddin_Text();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin <em>HL Arc Addin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Arc Addin</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin
	 * @generated
	 */
	EClass getHLArcAddin();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getType()
	 * @see #getHLArcAddin()
	 * @generated
	 */
	EAttribute getHLArcAddin_Type();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getHlinscription <em>Hlinscription</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Hlinscription</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin#getHlinscription()
	 * @see #getHLArcAddin()
	 * @generated
	 */
	EReference getHLArcAddin_Hlinscription();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotation <em>HL Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Annotation</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotation
	 * @generated
	 */
	EClass getHLAnnotation();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Condition</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Condition
	 * @generated
	 */
	EClass getCondition();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin <em>HL Transition Addin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Transition Addin</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin
	 * @generated
	 */
	EClass getHLTransitionAddin();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Condition</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin#getCondition()
	 * @see #getHLTransitionAddin()
	 * @generated
	 */
	EReference getHLTransitionAddin_Condition();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin <em>CPN Tools Transition Addin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CPN Tools Transition Addin</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin
	 * @generated
	 */
	EClass getCPNToolsTransitionAddin();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Code</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getCode()
	 * @see #getCPNToolsTransitionAddin()
	 * @generated
	 */
	EReference getCPNToolsTransitionAddin_Code();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Time</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin#getTime()
	 * @see #getCPNToolsTransitionAddin()
	 * @generated
	 */
	EReference getCPNToolsTransitionAddin_Time();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Code <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Code</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Code
	 * @generated
	 */
	EClass getCode();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Time <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Time</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Time
	 * @generated
	 */
	EClass getTime();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration <em>HL Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLDeclaration
	 * @generated
	 */
	EClass getHLDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration#getStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Structure</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLDeclaration#getStructure()
	 * @see #getHLDeclaration()
	 * @generated
	 */
	EReference getHLDeclaration_Structure();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.model.Instance#getParameterAssignment <em>Parameter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Assignment</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Instance#getParameterAssignment()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_ParameterAssignment();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.Instance#getSubPageID <em>Sub Page ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Sub Page ID</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.Instance#getSubPageID()
	 * @see #getInstance()
	 * @generated
	 */
	EAttribute getInstance_SubPageID();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment <em>Parameter Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Assignment</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ParameterAssignment
	 * @generated
	 */
	EClass getParameterAssignment();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getParameter <em>Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parameter</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getParameter()
	 * @see #getParameterAssignment()
	 * @generated
	 */
	EAttribute getParameterAssignment_Parameter();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getValue()
	 * @see #getParameterAssignment()
	 * @generated
	 */
	EAttribute getParameterAssignment_Value();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getInstance <em>Instance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Instance</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.ParameterAssignment#getInstance()
	 * @see #getParameterAssignment()
	 * @generated
	 */
	EReference getParameterAssignment_Instance();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.FusionGroup <em>Fusion Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Fusion Group</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.FusionGroup
	 * @generated
	 */
	EClass getFusionGroup();

	/**
	 * Returns the meta object for the container reference '{@link dk.au.daimi.ascoveco.cpn.model.FusionGroup#getPetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Petri Net</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.FusionGroup#getPetriNet()
	 * @see #getFusionGroup()
	 * @generated
	 */
	EReference getFusionGroup_PetriNet();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type 1</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>HL Arc Type 1</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @model instanceClass="dk.au.daimi.ascoveco.cpn.model.HLArcType"
	 * @generated
	 */
	EClass getHLArcType_1();

	/**
	 * Returns the meta object for enum '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>HL Arc Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @generated
	 */
	EEnum getHLArcType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ModelFactory getModelFactory();

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
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.AnnotationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ArcImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__SOURCE = eINSTANCE.getArc_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__TARGET = eINSTANCE.getArc_Target();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__PAGE = eINSTANCE.getArc_Page();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.AttributeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HasId <em>Has Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HasId
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasId()
		 * @generated
		 */
		EClass HAS_ID = eINSTANCE.getHasId();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HAS_ID__ID = eINSTANCE.getHasId_Id();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HasLabel <em>Has Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HasLabel
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasLabel()
		 * @generated
		 */
		EClass HAS_LABEL = eINSTANCE.getHasLabel();

		/**
		 * The meta object literal for the '<em><b>Label</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_LABEL__LABEL = eINSTANCE.getHasLabel_Label();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HasName <em>Has Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HasName
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasName()
		 * @generated
		 */
		EClass HAS_NAME = eINSTANCE.getHasName();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_NAME__NAME = eINSTANCE.getHasName_Name();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HasToolInfo <em>Has Tool Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HasToolInfo
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHasToolInfo()
		 * @generated
		 */
		EClass HAS_TOOL_INFO = eINSTANCE.getHasToolInfo();

		/**
		 * The meta object literal for the '<em><b>Toolinfo</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HAS_TOOL_INFO__TOOLINFO = eINSTANCE.getHasToolInfo_Toolinfo();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.LabelImpl <em>Label</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.LabelImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getLabel()
		 * @generated
		 */
		EClass LABEL = eINSTANCE.getLabel();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LABEL__PARENT = eINSTANCE.getLabel_Parent();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.NameImpl <em>Name</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.NameImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getName_()
		 * @generated
		 */
		EClass NAME = eINSTANCE.getName_();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.NodeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Source Arc</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__SOURCE_ARC = eINSTANCE.getNode_SourceArc();

		/**
		 * The meta object literal for the '<em><b>Target Arc</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__TARGET_ARC = eINSTANCE.getNode_TargetArc();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ObjectImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getObject()
		 * @generated
		 */
		EClass OBJECT = eINSTANCE.getObject();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference OBJECT__PAGE = eINSTANCE.getObject_Page();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl <em>Page</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.PageImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPage()
		 * @generated
		 */
		EClass PAGE = eINSTANCE.getPage();

		/**
		 * The meta object literal for the '<em><b>Petri Net</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__PETRI_NET = eINSTANCE.getPage_PetriNet();

		/**
		 * The meta object literal for the '<em><b>Object</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__OBJECT = eINSTANCE.getPage_Object();

		/**
		 * The meta object literal for the '<em><b>Arc</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PAGE__ARC = eINSTANCE.getPage_Arc();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl <em>Petri Net</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPetriNet()
		 * @generated
		 */
		EClass PETRI_NET = eINSTANCE.getPetriNet();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PETRI_NET__TYPE = eINSTANCE.getPetriNet_Type();

		/**
		 * The meta object literal for the '<em><b>Page</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__PAGE = eINSTANCE.getPetriNet_Page();

		/**
		 * The meta object literal for the '<em><b>Fusion Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PETRI_NET__FUSION_GROUPS = eINSTANCE.getPetriNet_FusionGroups();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceImpl <em>Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.PlaceImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPlace()
		 * @generated
		 */
		EClass PLACE = eINSTANCE.getPlace();

		/**
		 * The meta object literal for the '<em><b>References</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PLACE__REFERENCES = eINSTANCE.getPlace_References();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl <em>Place Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.PlaceNodeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getPlaceNode()
		 * @generated
		 */
		EClass PLACE_NODE = eINSTANCE.getPlaceNode();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.RefPlaceImpl <em>Ref Place</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.RefPlaceImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getRefPlace()
		 * @generated
		 */
		EClass REF_PLACE = eINSTANCE.getRefPlace();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF_PLACE__REF = eINSTANCE.getRefPlace_Ref();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.RefTransImpl <em>Ref Trans</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.RefTransImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getRefTrans()
		 * @generated
		 */
		EClass REF_TRANS = eINSTANCE.getRefTrans();

		/**
		 * The meta object literal for the '<em><b>Ref</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REF_TRANS__REF = eINSTANCE.getRefTrans_Ref();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ToolInfoImpl <em>Tool Info</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ToolInfoImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getToolInfo()
		 * @generated
		 */
		EClass TOOL_INFO = eINSTANCE.getToolInfo();

		/**
		 * The meta object literal for the '<em><b>Tool</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_INFO__TOOL = eINSTANCE.getToolInfo_Tool();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TOOL_INFO__VERSION = eINSTANCE.getToolInfo_Version();

		/**
		 * The meta object literal for the '<em><b>Parent</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TOOL_INFO__PARENT = eINSTANCE.getToolInfo_Parent();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionImpl <em>Transition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.TransitionImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTransition()
		 * @generated
		 */
		EClass TRANSITION = eINSTANCE.getTransition();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl <em>Transition Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.TransitionNodeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTransitionNode()
		 * @generated
		 */
		EClass TRANSITION_NODE = eINSTANCE.getTransitionNode();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLMarkingImpl <em>HL Marking</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLMarkingImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLMarking()
		 * @generated
		 */
		EClass HL_MARKING = eINSTANCE.getHLMarking();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.TypeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getType()
		 * @generated
		 */
		EClass TYPE = eINSTANCE.getType();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin <em>HL Place Addin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLPlaceAddin()
		 * @generated
		 */
		EClass HL_PLACE_ADDIN = eINSTANCE.getHLPlaceAddin();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HL_PLACE_ADDIN__TYPE = eINSTANCE.getHLPlaceAddin_Type();

		/**
		 * The meta object literal for the '<em><b>Initial Marking</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HL_PLACE_ADDIN__INITIAL_MARKING = eINSTANCE.getHLPlaceAddin_InitialMarking();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin <em>HL Annotation Addin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLAnnotationAddin()
		 * @generated
		 */
		EClass HL_ANNOTATION_ADDIN = eINSTANCE.getHLAnnotationAddin();

		/**
		 * The meta object literal for the '<em><b>Text</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HL_ANNOTATION_ADDIN__TEXT = eINSTANCE.getHLAnnotationAddin_Text();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin <em>HL Arc Addin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcAddin()
		 * @generated
		 */
		EClass HL_ARC_ADDIN = eINSTANCE.getHLArcAddin();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HL_ARC_ADDIN__TYPE = eINSTANCE.getHLArcAddin_Type();

		/**
		 * The meta object literal for the '<em><b>Hlinscription</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HL_ARC_ADDIN__HLINSCRIPTION = eINSTANCE.getHLArcAddin_Hlinscription();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLAnnotationImpl <em>HL Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLAnnotationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLAnnotation()
		 * @generated
		 */
		EClass HL_ANNOTATION = eINSTANCE.getHLAnnotation();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ConditionImpl <em>Condition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ConditionImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCondition()
		 * @generated
		 */
		EClass CONDITION = eINSTANCE.getCondition();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin <em>HL Transition Addin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLTransitionAddin()
		 * @generated
		 */
		EClass HL_TRANSITION_ADDIN = eINSTANCE.getHLTransitionAddin();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HL_TRANSITION_ADDIN__CONDITION = eINSTANCE.getHLTransitionAddin_Condition();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin <em>CPN Tools Transition Addin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCPNToolsTransitionAddin()
		 * @generated
		 */
		EClass CPN_TOOLS_TRANSITION_ADDIN = eINSTANCE.getCPNToolsTransitionAddin();

		/**
		 * The meta object literal for the '<em><b>Code</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPN_TOOLS_TRANSITION_ADDIN__CODE = eINSTANCE.getCPNToolsTransitionAddin_Code();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CPN_TOOLS_TRANSITION_ADDIN__TIME = eINSTANCE.getCPNToolsTransitionAddin_Time();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.CodeImpl <em>Code</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.CodeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getCode()
		 * @generated
		 */
		EClass CODE = eINSTANCE.getCode();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.TimeImpl <em>Time</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.TimeImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getTime()
		 * @generated
		 */
		EClass TIME = eINSTANCE.getTime();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.HLDeclarationImpl <em>HL Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.HLDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLDeclaration()
		 * @generated
		 */
		EClass HL_DECLARATION = eINSTANCE.getHLDeclaration();

		/**
		 * The meta object literal for the '<em><b>Structure</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference HL_DECLARATION__STRUCTURE = eINSTANCE.getHLDeclaration_Structure();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.InstanceImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Parameter Assignment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__PARAMETER_ASSIGNMENT = eINSTANCE.getInstance_ParameterAssignment();

		/**
		 * The meta object literal for the '<em><b>Sub Page ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INSTANCE__SUB_PAGE_ID = eINSTANCE.getInstance_SubPageID();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.ParameterAssignmentImpl <em>Parameter Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ParameterAssignmentImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getParameterAssignment()
		 * @generated
		 */
		EClass PARAMETER_ASSIGNMENT = eINSTANCE.getParameterAssignment();

		/**
		 * The meta object literal for the '<em><b>Parameter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_ASSIGNMENT__PARAMETER = eINSTANCE.getParameterAssignment_Parameter();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_ASSIGNMENT__VALUE = eINSTANCE.getParameterAssignment_Value();

		/**
		 * The meta object literal for the '<em><b>Instance</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_ASSIGNMENT__INSTANCE = eINSTANCE.getParameterAssignment_Instance();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.impl.FusionGroupImpl <em>Fusion Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.FusionGroupImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getFusionGroup()
		 * @generated
		 */
		EClass FUSION_GROUP = eINSTANCE.getFusionGroup();

		/**
		 * The meta object literal for the '<em><b>Petri Net</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUSION_GROUP__PETRI_NET = eINSTANCE.getFusionGroup_PetriNet();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type 1</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcType_1()
		 * @generated
		 */
		EClass HL_ARC_TYPE_1 = eINSTANCE.getHLArcType_1();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType <em>HL Arc Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
		 * @see dk.au.daimi.ascoveco.cpn.model.impl.ModelPackageImpl#getHLArcType()
		 * @generated
		 */
		EEnum HL_ARC_TYPE = eINSTANCE.getHLArcType();

	}

} //ModelPackage
