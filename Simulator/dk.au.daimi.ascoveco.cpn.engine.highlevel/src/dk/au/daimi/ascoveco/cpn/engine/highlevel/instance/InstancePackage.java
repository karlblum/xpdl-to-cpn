/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.engine.highlevel.instance;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.InstanceFactory
 * @model kind="package"
 * @generated
 */
public interface InstancePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "instance";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dk/au/daimi/ascoveco/cpn/engine/highlevel/instance.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.au.daimi.ascoveco.cpn.engine.highlevel.instance";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	InstancePackage eINSTANCE = dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl <em>Instance</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getInstance()
	 * @generated
	 */
	int INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>Node</b></em>' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__NODE = 0;

	/**
	 * The feature id for the '<em><b>Transition Path</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE__TRANSITION_PATH = 1;

	/**
	 * The number of structural features of the '<em>Instance</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANCE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl <em>Marking</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getMarking()
	 * @generated
	 */
	int MARKING = 1;

	/**
	 * The feature id for the '<em><b>Token Count</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__TOKEN_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Marking</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__MARKING = 1;

	/**
	 * The feature id for the '<em><b>Place Instance</b></em>' containment reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__PLACE_INSTANCE = 2;

	/**
	 * The feature id for the '<em><b>Structured Marking</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING__STRUCTURED_MARKING = 3;

	/**
	 * The number of structural features of the '<em>Marking</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MARKING_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.StateImpl <em>State</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.StateImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getState()
	 * @generated
	 */
	int STATE = 2;

	/**
	 * The feature id for the '<em><b>All Markings</b></em>' reference list. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int STATE__ALL_MARKINGS = 0;

	/**
	 * The number of structural features of the '<em>State</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MultisetEntryImpl <em>Multiset Entry</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MultisetEntryImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getMultisetEntry()
	 * @generated
	 */
	int MULTISET_ENTRY = 3;

	/**
	 * The feature id for the '<em><b>Coefficient</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTISET_ENTRY__COEFFICIENT = 0;

	/**
	 * The feature id for the '<em><b>Value As String</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTISET_ENTRY__VALUE_AS_STRING = 1;

	/**
	 * The number of structural features of the '<em>Multiset Entry</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTISET_ENTRY_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl <em>Binding</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getBinding()
	 * @generated
	 */
	int BINDING = 4;

	/**
	 * The feature id for the '<em><b>Transition Instance</b></em>' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 * @ordered
	 */
	int BINDING__TRANSITION_INSTANCE = 0;

	/**
	 * The feature id for the '<em><b>All Assignments</b></em>' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING__ALL_ASSIGNMENTS = 1;

	/**
	 * The number of structural features of the '<em>Binding</em>' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BINDING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.ValueAssignmentImpl
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getValueAssignment()
	 * @generated
	 */
	int VALUE_ASSIGNMENT = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ASSIGNMENT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ASSIGNMENT__VALUE = 1;

	/**
	 * The number of structural features of the '<em>Value Assignment</em>' class.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_ASSIGNMENT_FEATURE_COUNT = 2;

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance <em>Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instance</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance
	 * @generated
	 */
	EClass getInstance();

	/**
	 * Returns the meta object for the reference '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Node</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getNode()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_Node();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getTransitionPath <em>Transition Path</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transition Path</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Instance#getTransitionPath()
	 * @see #getInstance()
	 * @generated
	 */
	EReference getInstance_TransitionPath();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking <em>Marking</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Marking</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking
	 * @generated
	 */
	EClass getMarking();

	/**
	 * Returns the meta object for the attribute '
	 * {@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getTokenCount <em>Token Count</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Token Count</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getTokenCount()
	 * @see #getMarking()
	 * @generated
	 */
	EAttribute getMarking_TokenCount();

	/**
	 * Returns the meta object for the attribute '
	 * {@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getMarking <em>Marking</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Marking</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getMarking()
	 * @see #getMarking()
	 * @generated
	 */
	EAttribute getMarking_Marking();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getPlaceInstance <em>Place Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Place Instance</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getPlaceInstance()
	 * @see #getMarking()
	 * @generated
	 */
	EReference getMarking_PlaceInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getStructuredMarking <em>Structured Marking</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Structured Marking</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Marking#getStructuredMarking()
	 * @see #getMarking()
	 * @generated
	 */
	EReference getMarking_StructuredMarking();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State <em>State</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>State</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State
	 * @generated
	 */
	EClass getState();

	/**
	 * Returns the meta object for the reference list '
	 * {@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State#getAllMarkings <em>All Markings</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the reference list '<em>All Markings</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.State#getAllMarkings()
	 * @see #getState()
	 * @generated
	 */
	EReference getState_AllMarkings();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry <em>Multiset Entry</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiset Entry</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry
	 * @generated
	 */
	EClass getMultisetEntry();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry#getCoefficient <em>Coefficient</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Coefficient</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry#getCoefficient()
	 * @see #getMultisetEntry()
	 * @generated
	 */
	EAttribute getMultisetEntry_Coefficient();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry#getValueAsString <em>Value As String</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value As String</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.MultisetEntry#getValueAsString()
	 * @see #getMultisetEntry()
	 * @generated
	 */
	EAttribute getMultisetEntry_ValueAsString();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding <em>Binding</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Binding</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding
	 * @generated
	 */
	EClass getBinding();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getTransitionInstance <em>Transition Instance</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Transition Instance</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getTransitionInstance()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_TransitionInstance();

	/**
	 * Returns the meta object for the containment reference list '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getAllAssignments <em>All Assignments</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>All Assignments</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.Binding#getAllAssignments()
	 * @see #getBinding()
	 * @generated
	 */
	EReference getBinding_AllAssignments();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment <em>Value Assignment</em>}'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Assignment</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment
	 * @generated
	 */
	EClass getValueAssignment();

	/**
	 * Returns the meta object for the attribute '
	 * {@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment#getName <em>Name</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment#getName()
	 * @see #getValueAssignment()
	 * @generated
	 */
	EAttribute getValueAssignment_Name();

	/**
	 * Returns the meta object for the attribute '
	 * {@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment#getValue <em>Value</em>}'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.ValueAssignment#getValue()
	 * @see #getValueAssignment()
	 * @generated
	 */
	EAttribute getValueAssignment_Value();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	InstanceFactory getInstanceFactory();

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
	@SuppressWarnings("hiding")
	interface Literals {
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl <em>Instance</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstanceImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getInstance()
		 * @generated
		 */
		EClass INSTANCE = eINSTANCE.getInstance();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' reference feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__NODE = eINSTANCE.getInstance_Node();

		/**
		 * The meta object literal for the '<em><b>Transition Path</b></em>' containment reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference INSTANCE__TRANSITION_PATH = eINSTANCE.getInstance_TransitionPath();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl <em>Marking</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MarkingImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getMarking()
		 * @generated
		 */
		EClass MARKING = eINSTANCE.getMarking();

		/**
		 * The meta object literal for the '<em><b>Token Count</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MARKING__TOKEN_COUNT = eINSTANCE.getMarking_TokenCount();

		/**
		 * The meta object literal for the '<em><b>Marking</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MARKING__MARKING = eINSTANCE.getMarking_Marking();

		/**
		 * The meta object literal for the '<em><b>Place Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MARKING__PLACE_INSTANCE = eINSTANCE.getMarking_PlaceInstance();

		/**
		 * The meta object literal for the '<em><b>Structured Marking</b></em>' reference list feature. <!--
		 * begin-user-doc --> <!-- end-user-doc -->
		 * 
		 * @generated
		 */
		EReference MARKING__STRUCTURED_MARKING = eINSTANCE.getMarking_StructuredMarking();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.StateImpl <em>State</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.StateImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getState()
		 * @generated
		 */
		EClass STATE = eINSTANCE.getState();

		/**
		 * The meta object literal for the '<em><b>All Markings</b></em>' containment reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference STATE__ALL_MARKINGS = eINSTANCE.getState_AllMarkings();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MultisetEntryImpl <em>Multiset Entry</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.MultisetEntryImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getMultisetEntry()
		 * @generated
		 */
		EClass MULTISET_ENTRY = eINSTANCE.getMultisetEntry();

		/**
		 * The meta object literal for the '<em><b>Coefficient</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute MULTISET_ENTRY__COEFFICIENT = eINSTANCE.getMultisetEntry_Coefficient();

		/**
		 * The meta object literal for the '<em><b>Value As String</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTISET_ENTRY__VALUE_AS_STRING = eINSTANCE.getMultisetEntry_ValueAsString();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl <em>Binding</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.BindingImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getBinding()
		 * @generated
		 */
		EClass BINDING = eINSTANCE.getBinding();

		/**
		 * The meta object literal for the '<em><b>Transition Instance</b></em>' containment reference feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__TRANSITION_INSTANCE = eINSTANCE.getBinding_TransitionInstance();

		/**
		 * The meta object literal for the '<em><b>All Assignments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc
		 * --> <!-- end-user-doc -->
		 * @generated
		 */
		EReference BINDING__ALL_ASSIGNMENTS = eINSTANCE.getBinding_AllAssignments();

		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.ValueAssignmentImpl <em>Value Assignment</em>}' class.
		 * <!-- begin-user-doc --> <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.ValueAssignmentImpl
		 * @see dk.au.daimi.ascoveco.cpn.engine.highlevel.instance.impl.InstancePackageImpl#getValueAssignment()
		 * @generated
		 */
		EClass VALUE_ASSIGNMENT = eINSTANCE.getValueAssignment();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ASSIGNMENT__NAME = eINSTANCE.getValueAssignment_Name();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc --> <!--
		 * end-user-doc -->
		 * @generated
		 */
		EAttribute VALUE_ASSIGNMENT__VALUE = eINSTANCE.getValueAssignment_Value();

	}

} // InstancePackage
