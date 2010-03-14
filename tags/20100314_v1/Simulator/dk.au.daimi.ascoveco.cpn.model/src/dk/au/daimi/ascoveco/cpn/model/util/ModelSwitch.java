/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.util;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
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
 * <!-- begin-user-doc --> The <b>Switch</b> for the model's inheritance hierarchy. It supports the call
 * {@link #doSwitch(EObject) doSwitch(object)} to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object and proceeding up the inheritance hierarchy until a non-null result is
 * returned, which is the result of the switch. <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.ModelPackage
 * @generated
 */
public class ModelSwitch<T> {
	/**
	 * The cached model package <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected final static ModelPackage modelPackage = ModelPackage.eINSTANCE;

	/**
	 * Creates an instance of the switch. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ModelSwitch() {
		// Raise visibility
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ModelPackage.ANNOTATION: {
				Annotation annotation = (Annotation)theEObject;
				T result = caseAnnotation(annotation);
				if (result == null) result = caseLabel(annotation);
				if (result == null) result = caseHasGraphics(annotation);
				if (result == null) result = caseHLAnnotationAddin(annotation);
				if (result == null) result = caseHasToolInfo(annotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ARC: {
				Arc arc = (Arc)theEObject;
				T result = caseArc(arc);
				if (result == null) result = caseHLArcAddin(arc);
				if (result == null) result = caseHasId(arc);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.ATTRIBUTE: {
				Attribute attribute = (Attribute)theEObject;
				T result = caseAttribute(attribute);
				if (result == null) result = caseLabel(attribute);
				if (result == null) result = caseHasToolInfo(attribute);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HAS_ID: {
				HasId hasId = (HasId)theEObject;
				T result = caseHasId(hasId);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HAS_LABEL: {
				HasLabel hasLabel = (HasLabel)theEObject;
				T result = caseHasLabel(hasLabel);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HAS_NAME: {
				HasName hasName = (HasName)theEObject;
				T result = caseHasName(hasName);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HAS_TOOL_INFO: {
				HasToolInfo hasToolInfo = (HasToolInfo)theEObject;
				T result = caseHasToolInfo(hasToolInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.LABEL: {
				Label label = (Label)theEObject;
				T result = caseLabel(label);
				if (result == null) result = caseHasToolInfo(label);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NAME: {
				Name name = (Name)theEObject;
				T result = caseName(name);
				if (result == null) result = caseHLAnnotation(name);
				if (result == null) result = caseAnnotation(name);
				if (result == null) result = caseLabel(name);
				if (result == null) result = caseHasGraphics(name);
				if (result == null) result = caseHLAnnotationAddin(name);
				if (result == null) result = caseHasToolInfo(name);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.NODE: {
				Node node = (Node)theEObject;
				T result = caseNode(node);
				if (result == null) result = caseObject(node);
				if (result == null) result = caseHasToolInfo(node);
				if (result == null) result = caseHasGraphics(node);
				if (result == null) result = caseHasId(node);
				if (result == null) result = caseHasLabel(node);
				if (result == null) result = caseHasName(node);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.OBJECT: {
				dk.au.daimi.ascoveco.cpn.model.Object object = (dk.au.daimi.ascoveco.cpn.model.Object)theEObject;
				T result = caseObject(object);
				if (result == null) result = caseHasToolInfo(object);
				if (result == null) result = caseHasGraphics(object);
				if (result == null) result = caseHasId(object);
				if (result == null) result = caseHasLabel(object);
				if (result == null) result = caseHasName(object);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PAGE: {
				Page page = (Page)theEObject;
				T result = casePage(page);
				if (result == null) result = caseHasName(page);
				if (result == null) result = caseHasLabel(page);
				if (result == null) result = caseHasId(page);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PETRI_NET: {
				PetriNet petriNet = (PetriNet)theEObject;
				T result = casePetriNet(petriNet);
				if (result == null) result = caseHasToolInfo(petriNet);
				if (result == null) result = caseHasId(petriNet);
				if (result == null) result = caseHasLabel(petriNet);
				if (result == null) result = caseHasName(petriNet);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PLACE: {
				Place place = (Place)theEObject;
				T result = casePlace(place);
				if (result == null) result = casePlaceNode(place);
				if (result == null) result = caseNode(place);
				if (result == null) result = caseHLPlaceAddin(place);
				if (result == null) result = caseObject(place);
				if (result == null) result = caseHasToolInfo(place);
				if (result == null) result = caseHasGraphics(place);
				if (result == null) result = caseHasId(place);
				if (result == null) result = caseHasLabel(place);
				if (result == null) result = caseHasName(place);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PLACE_NODE: {
				PlaceNode placeNode = (PlaceNode)theEObject;
				T result = casePlaceNode(placeNode);
				if (result == null) result = caseNode(placeNode);
				if (result == null) result = caseHLPlaceAddin(placeNode);
				if (result == null) result = caseObject(placeNode);
				if (result == null) result = caseHasToolInfo(placeNode);
				if (result == null) result = caseHasGraphics(placeNode);
				if (result == null) result = caseHasId(placeNode);
				if (result == null) result = caseHasLabel(placeNode);
				if (result == null) result = caseHasName(placeNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REF_PLACE: {
				RefPlace refPlace = (RefPlace)theEObject;
				T result = caseRefPlace(refPlace);
				if (result == null) result = casePlaceNode(refPlace);
				if (result == null) result = caseNode(refPlace);
				if (result == null) result = caseHLPlaceAddin(refPlace);
				if (result == null) result = caseObject(refPlace);
				if (result == null) result = caseHasToolInfo(refPlace);
				if (result == null) result = caseHasGraphics(refPlace);
				if (result == null) result = caseHasId(refPlace);
				if (result == null) result = caseHasLabel(refPlace);
				if (result == null) result = caseHasName(refPlace);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.REF_TRANS: {
				RefTrans refTrans = (RefTrans)theEObject;
				T result = caseRefTrans(refTrans);
				if (result == null) result = caseTransitionNode(refTrans);
				if (result == null) result = caseNode(refTrans);
				if (result == null) result = caseHLTransitionAddin(refTrans);
				if (result == null) result = caseCPNToolsTransitionAddin(refTrans);
				if (result == null) result = caseObject(refTrans);
				if (result == null) result = caseHasToolInfo(refTrans);
				if (result == null) result = caseHasGraphics(refTrans);
				if (result == null) result = caseHasId(refTrans);
				if (result == null) result = caseHasLabel(refTrans);
				if (result == null) result = caseHasName(refTrans);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TOOL_INFO: {
				ToolInfo toolInfo = (ToolInfo)theEObject;
				T result = caseToolInfo(toolInfo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TRANSITION: {
				Transition transition = (Transition)theEObject;
				T result = caseTransition(transition);
				if (result == null) result = caseTransitionNode(transition);
				if (result == null) result = caseNode(transition);
				if (result == null) result = caseHLTransitionAddin(transition);
				if (result == null) result = caseCPNToolsTransitionAddin(transition);
				if (result == null) result = caseObject(transition);
				if (result == null) result = caseHasToolInfo(transition);
				if (result == null) result = caseHasGraphics(transition);
				if (result == null) result = caseHasId(transition);
				if (result == null) result = caseHasLabel(transition);
				if (result == null) result = caseHasName(transition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TRANSITION_NODE: {
				TransitionNode transitionNode = (TransitionNode)theEObject;
				T result = caseTransitionNode(transitionNode);
				if (result == null) result = caseNode(transitionNode);
				if (result == null) result = caseHLTransitionAddin(transitionNode);
				if (result == null) result = caseCPNToolsTransitionAddin(transitionNode);
				if (result == null) result = caseObject(transitionNode);
				if (result == null) result = caseHasToolInfo(transitionNode);
				if (result == null) result = caseHasGraphics(transitionNode);
				if (result == null) result = caseHasId(transitionNode);
				if (result == null) result = caseHasLabel(transitionNode);
				if (result == null) result = caseHasName(transitionNode);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_MARKING: {
				HLMarking hlMarking = (HLMarking)theEObject;
				T result = caseHLMarking(hlMarking);
				if (result == null) result = caseAnnotation(hlMarking);
				if (result == null) result = caseLabel(hlMarking);
				if (result == null) result = caseHasGraphics(hlMarking);
				if (result == null) result = caseHLAnnotationAddin(hlMarking);
				if (result == null) result = caseHasToolInfo(hlMarking);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TYPE: {
				Type type = (Type)theEObject;
				T result = caseType(type);
				if (result == null) result = caseAnnotation(type);
				if (result == null) result = caseLabel(type);
				if (result == null) result = caseHasGraphics(type);
				if (result == null) result = caseHLAnnotationAddin(type);
				if (result == null) result = caseHasToolInfo(type);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_PLACE_ADDIN: {
				HLPlaceAddin hlPlaceAddin = (HLPlaceAddin)theEObject;
				T result = caseHLPlaceAddin(hlPlaceAddin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_ANNOTATION_ADDIN: {
				HLAnnotationAddin hlAnnotationAddin = (HLAnnotationAddin)theEObject;
				T result = caseHLAnnotationAddin(hlAnnotationAddin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_ARC_ADDIN: {
				HLArcAddin hlArcAddin = (HLArcAddin)theEObject;
				T result = caseHLArcAddin(hlArcAddin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_ANNOTATION: {
				HLAnnotation hlAnnotation = (HLAnnotation)theEObject;
				T result = caseHLAnnotation(hlAnnotation);
				if (result == null) result = caseAnnotation(hlAnnotation);
				if (result == null) result = caseLabel(hlAnnotation);
				if (result == null) result = caseHasGraphics(hlAnnotation);
				if (result == null) result = caseHLAnnotationAddin(hlAnnotation);
				if (result == null) result = caseHasToolInfo(hlAnnotation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = caseAnnotation(condition);
				if (result == null) result = caseLabel(condition);
				if (result == null) result = caseHasGraphics(condition);
				if (result == null) result = caseHLAnnotationAddin(condition);
				if (result == null) result = caseHasToolInfo(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_TRANSITION_ADDIN: {
				HLTransitionAddin hlTransitionAddin = (HLTransitionAddin)theEObject;
				T result = caseHLTransitionAddin(hlTransitionAddin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CPN_TOOLS_TRANSITION_ADDIN: {
				CPNToolsTransitionAddin cpnToolsTransitionAddin = (CPNToolsTransitionAddin)theEObject;
				T result = caseCPNToolsTransitionAddin(cpnToolsTransitionAddin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.CODE: {
				Code code = (Code)theEObject;
				T result = caseCode(code);
				if (result == null) result = caseAnnotation(code);
				if (result == null) result = caseLabel(code);
				if (result == null) result = caseHasGraphics(code);
				if (result == null) result = caseHLAnnotationAddin(code);
				if (result == null) result = caseHasToolInfo(code);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.TIME: {
				Time time = (Time)theEObject;
				T result = caseTime(time);
				if (result == null) result = caseAnnotation(time);
				if (result == null) result = caseLabel(time);
				if (result == null) result = caseHasGraphics(time);
				if (result == null) result = caseHLAnnotationAddin(time);
				if (result == null) result = caseHasToolInfo(time);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.HL_DECLARATION: {
				HLDeclaration hlDeclaration = (HLDeclaration)theEObject;
				T result = caseHLDeclaration(hlDeclaration);
				if (result == null) result = caseAnnotation(hlDeclaration);
				if (result == null) result = caseHasId(hlDeclaration);
				if (result == null) result = caseLabel(hlDeclaration);
				if (result == null) result = caseHasGraphics(hlDeclaration);
				if (result == null) result = caseHLAnnotationAddin(hlDeclaration);
				if (result == null) result = caseHasToolInfo(hlDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.INSTANCE: {
				Instance instance = (Instance)theEObject;
				T result = caseInstance(instance);
				if (result == null) result = caseNode(instance);
				if (result == null) result = caseObject(instance);
				if (result == null) result = caseHasToolInfo(instance);
				if (result == null) result = caseHasGraphics(instance);
				if (result == null) result = caseHasId(instance);
				if (result == null) result = caseHasLabel(instance);
				if (result == null) result = caseHasName(instance);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.PARAMETER_ASSIGNMENT: {
				ParameterAssignment parameterAssignment = (ParameterAssignment)theEObject;
				T result = caseParameterAssignment(parameterAssignment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ModelPackage.FUSION_GROUP: {
				FusionGroup fusionGroup = (FusionGroup)theEObject;
				T result = caseFusionGroup(fusionGroup);
				if (result == null) result = casePlace(fusionGroup);
				if (result == null) result = casePlaceNode(fusionGroup);
				if (result == null) result = caseNode(fusionGroup);
				if (result == null) result = caseHLPlaceAddin(fusionGroup);
				if (result == null) result = caseObject(fusionGroup);
				if (result == null) result = caseHasToolInfo(fusionGroup);
				if (result == null) result = caseHasGraphics(fusionGroup);
				if (result == null) result = caseHasId(fusionGroup);
				if (result == null) result = caseHasLabel(fusionGroup);
				if (result == null) result = caseHasName(fusionGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAnnotation(Annotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Arc</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Arc</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseArc(Arc object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttribute(Attribute object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Id</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Id</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasId(HasId object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Label</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasLabel(HasLabel object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasName(HasName object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Tool Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Tool Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasToolInfo(HasToolInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Label</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Label</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLabel(Label object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Name</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Name</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseName(Name object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Node</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNode(Node object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObject(dk.au.daimi.ascoveco.cpn.model.Object object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Page</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Page</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePage(Page object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Petri Net</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Petri Net</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePetriNet(PetriNet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Place</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Place</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlace(Place object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Place Node</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Place Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePlaceNode(PlaceNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ref Place</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ref Place</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefPlace(RefPlace object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ref Trans</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ref Trans</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRefTrans(RefTrans object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tool Info</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tool Info</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseToolInfo(ToolInfo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransition(Transition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Node</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Node</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionNode(TransitionNode object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Marking</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Marking</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLMarking(HLMarking object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Type</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseType(Type object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Place Addin</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Place Addin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLPlaceAddin(HLPlaceAddin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Annotation Addin</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Annotation Addin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLAnnotationAddin(HLAnnotationAddin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Arc Addin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Arc Addin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLArcAddin(HLArcAddin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Annotation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Annotation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLAnnotation(HLAnnotation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Transition Addin</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Transition Addin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLTransitionAddin(HLTransitionAddin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CPN Tools Transition Addin</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CPN Tools Transition Addin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCPNToolsTransitionAddin(CPNToolsTransitionAddin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Code</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Code</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCode(Code object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTime(Time object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Declaration</em>'. <!-- begin-user-doc
	 * --> This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc
	 * -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLDeclaration(HLDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Instance</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInstance(Instance object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Parameter Assignment</em>'. <!--
	 * begin-user-doc --> This implementation returns null; returning a non-null result will terminate the switch. <!--
	 * end-user-doc -->
	 * 
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Parameter Assignment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseParameterAssignment(ParameterAssignment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fusion Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fusion Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFusionGroup(FusionGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>HL Arc Type 1</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>HL Arc Type 1</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHLArcType_1(HLArcType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Has Graphics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null; returning a non-null result will terminate the switch. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Has Graphics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHasGraphics(HasGraphics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc --> This
	 * implementation returns null; returning a non-null result will terminate the switch, but this is the last case
	 * anyway. <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} // ModelSwitch
