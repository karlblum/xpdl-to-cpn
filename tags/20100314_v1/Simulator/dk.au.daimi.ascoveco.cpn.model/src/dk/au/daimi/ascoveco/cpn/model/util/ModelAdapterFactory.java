/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.Annotation;
import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.Attribute;
import dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin;
import dk.au.daimi.ascoveco.cpn.model.Code;
import dk.au.daimi.ascoveco.cpn.model.Condition;
import dk.au.daimi.ascoveco.cpn.model.FusionGroup;
import dk.au.daimi.ascoveco.cpn.model.HLAnnotation;
import dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin;
import dk.au.daimi.ascoveco.cpn.model.HLArcAddin;
import dk.au.daimi.ascoveco.cpn.model.HLArcType;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.HLMarking;
import dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin;
import dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin;
import dk.au.daimi.ascoveco.cpn.model.HasId;
import dk.au.daimi.ascoveco.cpn.model.HasLabel;
import dk.au.daimi.ascoveco.cpn.model.HasName;
import dk.au.daimi.ascoveco.cpn.model.HasToolInfo;
import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.Label;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Node;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.ParameterAssignment;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.RefTrans;
import dk.au.daimi.ascoveco.cpn.model.Time;
import dk.au.daimi.ascoveco.cpn.model.ToolInfo;
import dk.au.daimi.ascoveco.cpn.model.Transition;
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;
import dk.au.daimi.ascoveco.cpn.model.Type;
import dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.ModelPackage
 * @generated
 */
public class ModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected final static ModelPackage modelPackage = ModelPackage.eINSTANCE;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ModelAdapterFactory() {
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
	protected ModelSwitch<Adapter> modelSwitch = new ModelSwitch<Adapter>() {
			@Override
			public Adapter caseAnnotation(Annotation object) {
				return createAnnotationAdapter();
			}
			@Override
			public Adapter caseArc(Arc object) {
				return createArcAdapter();
			}
			@Override
			public Adapter caseAttribute(Attribute object) {
				return createAttributeAdapter();
			}
			@Override
			public Adapter caseHasId(HasId object) {
				return createHasIdAdapter();
			}
			@Override
			public Adapter caseHasLabel(HasLabel object) {
				return createHasLabelAdapter();
			}
			@Override
			public Adapter caseHasName(HasName object) {
				return createHasNameAdapter();
			}
			@Override
			public Adapter caseHasToolInfo(HasToolInfo object) {
				return createHasToolInfoAdapter();
			}
			@Override
			public Adapter caseLabel(Label object) {
				return createLabelAdapter();
			}
			@Override
			public Adapter caseName(Name object) {
				return createNameAdapter();
			}
			@Override
			public Adapter caseNode(Node object) {
				return createNodeAdapter();
			}
			@Override
			public Adapter caseObject(dk.au.daimi.ascoveco.cpn.model.Object object) {
				return createObjectAdapter();
			}
			@Override
			public Adapter casePage(Page object) {
				return createPageAdapter();
			}
			@Override
			public Adapter casePetriNet(PetriNet object) {
				return createPetriNetAdapter();
			}
			@Override
			public Adapter casePlace(Place object) {
				return createPlaceAdapter();
			}
			@Override
			public Adapter casePlaceNode(PlaceNode object) {
				return createPlaceNodeAdapter();
			}
			@Override
			public Adapter caseRefPlace(RefPlace object) {
				return createRefPlaceAdapter();
			}
			@Override
			public Adapter caseRefTrans(RefTrans object) {
				return createRefTransAdapter();
			}
			@Override
			public Adapter caseToolInfo(ToolInfo object) {
				return createToolInfoAdapter();
			}
			@Override
			public Adapter caseTransition(Transition object) {
				return createTransitionAdapter();
			}
			@Override
			public Adapter caseTransitionNode(TransitionNode object) {
				return createTransitionNodeAdapter();
			}
			@Override
			public Adapter caseHLMarking(HLMarking object) {
				return createHLMarkingAdapter();
			}
			@Override
			public Adapter caseType(Type object) {
				return createTypeAdapter();
			}
			@Override
			public Adapter caseHLPlaceAddin(HLPlaceAddin object) {
				return createHLPlaceAddinAdapter();
			}
			@Override
			public Adapter caseHLAnnotationAddin(HLAnnotationAddin object) {
				return createHLAnnotationAddinAdapter();
			}
			@Override
			public Adapter caseHLArcAddin(HLArcAddin object) {
				return createHLArcAddinAdapter();
			}
			@Override
			public Adapter caseHLAnnotation(HLAnnotation object) {
				return createHLAnnotationAdapter();
			}
			@Override
			public Adapter caseCondition(Condition object) {
				return createConditionAdapter();
			}
			@Override
			public Adapter caseHLTransitionAddin(HLTransitionAddin object) {
				return createHLTransitionAddinAdapter();
			}
			@Override
			public Adapter caseCPNToolsTransitionAddin(CPNToolsTransitionAddin object) {
				return createCPNToolsTransitionAddinAdapter();
			}
			@Override
			public Adapter caseCode(Code object) {
				return createCodeAdapter();
			}
			@Override
			public Adapter caseTime(Time object) {
				return createTimeAdapter();
			}
			@Override
			public Adapter caseHLDeclaration(HLDeclaration object) {
				return createHLDeclarationAdapter();
			}
			@Override
			public Adapter caseInstance(Instance object) {
				return createInstanceAdapter();
			}
			@Override
			public Adapter caseParameterAssignment(ParameterAssignment object) {
				return createParameterAssignmentAdapter();
			}
			@Override
			public Adapter caseFusionGroup(FusionGroup object) {
				return createFusionGroupAdapter();
			}
			@Override
			public Adapter caseHLArcType_1(HLArcType object) {
				return createHLArcType_1Adapter();
			}
			@Override
			public Adapter caseHasGraphics(HasGraphics object) {
				return createHasGraphicsAdapter();
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
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Annotation
	 * <em>Annotation</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Annotation
	 * @generated
	 */
	public Adapter createAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Arc <em>Arc</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Arc
	 * @generated
	 */
	public Adapter createArcAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Attribute
	 * @generated
	 */
	public Adapter createAttributeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HasId <em>Has Id</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasId
	 * @generated
	 */
	public Adapter createHasIdAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HasLabel <em>Has Label</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasLabel
	 * @generated
	 */
	public Adapter createHasLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HasName <em>Has Name</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasName
	 * @generated
	 */
	public Adapter createHasNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HasToolInfo
	 * <em>Has Tool Info</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HasToolInfo
	 * @generated
	 */
	public Adapter createHasToolInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Label <em>Label</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Label
	 * @generated
	 */
	public Adapter createLabelAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Name <em>Name</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Name
	 * @generated
	 */
	public Adapter createNameAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Node <em>Node</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Node
	 * @generated
	 */
	public Adapter createNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Object <em>Object</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Object
	 * @generated
	 */
	public Adapter createObjectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Page <em>Page</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Page
	 * @generated
	 */
	public Adapter createPageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.PetriNet <em>Petri Net</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet
	 * @generated
	 */
	public Adapter createPetriNetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Place <em>Place</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Place
	 * @generated
	 */
	public Adapter createPlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.PlaceNode
	 * <em>Place Node</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.PlaceNode
	 * @generated
	 */
	public Adapter createPlaceNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.RefPlace <em>Ref Place</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefPlace
	 * @generated
	 */
	public Adapter createRefPlaceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.RefTrans <em>Ref Trans</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.RefTrans
	 * @generated
	 */
	public Adapter createRefTransAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.ToolInfo <em>Tool Info</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.ToolInfo
	 * @generated
	 */
	public Adapter createToolInfoAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Transition
	 * <em>Transition</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Transition
	 * @generated
	 */
	public Adapter createTransitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.TransitionNode <em>Transition Node</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.TransitionNode
	 * @generated
	 */
	public Adapter createTransitionNodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLMarking
	 * <em>HL Marking</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLMarking
	 * @generated
	 */
	public Adapter createHLMarkingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Type <em>Type</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin
	 * <em>HL Place Addin</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLPlaceAddin
	 * @generated
	 */
	public Adapter createHLPlaceAddinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin <em>HL Annotation Addin</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotationAddin
	 * @generated
	 */
	public Adapter createHLAnnotationAddinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLArcAddin
	 * <em>HL Arc Addin</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcAddin
	 * @generated
	 */
	public Adapter createHLArcAddinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLAnnotation
	 * <em>HL Annotation</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLAnnotation
	 * @generated
	 */
	public Adapter createHLAnnotationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Condition <em>Condition</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Condition
	 * @generated
	 */
	public Adapter createConditionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin <em>HL Transition Addin</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLTransitionAddin
	 * @generated
	 */
	public Adapter createHLTransitionAddinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin <em>CPN Tools Transition Addin</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that
	 * we can easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.CPNToolsTransitionAddin
	 * @generated
	 */
	public Adapter createCPNToolsTransitionAddinAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Code <em>Code</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Code
	 * @generated
	 */
	public Adapter createCodeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Time <em>Time</em>}'. <!--
	 * begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful to
	 * ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Time
	 * @generated
	 */
	public Adapter createTimeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration
	 * <em>HL Declaration</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLDeclaration
	 * @generated
	 */
	public Adapter createHLDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's useful
	 * to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.Instance
	 * @generated
	 */
	public Adapter createInstanceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment <em>Parameter Assignment</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.ParameterAssignment
	 * @generated
	 */
	public Adapter createParameterAssignmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.FusionGroup
	 * <em>Fusion Group</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.FusionGroup
	 * @generated
	 */
	public Adapter createFusionGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * <em>HL Arc Type 1</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.HLArcType
	 * @generated
	 */
	public Adapter createHLArcType_1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics
	 * <em>Has Graphics</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics
	 * @generated
	 */
	public Adapter createHasGraphicsAdapter() {
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

} // ModelAdapterFactory
