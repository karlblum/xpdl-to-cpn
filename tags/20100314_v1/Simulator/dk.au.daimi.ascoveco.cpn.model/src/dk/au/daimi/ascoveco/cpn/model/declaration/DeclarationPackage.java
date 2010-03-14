/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.declaration;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationFactory
 * @model kind="package"
 * @generated
 */
@SuppressWarnings("IC_SUPERCLASS_USES_SUBCLASS_DURING_INITIALIZATION")
public interface DeclarationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "declaration";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///dk/au/daimi/ascoveco/cpn/model/declaration.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "dk.au.daimi.ascoveco.cpn.model.declaration";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeclarationPackage eINSTANCE = dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl.init();

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationStructureImpl <em>Structure</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationStructureImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getDeclarationStructure()
	 * @generated
	 */
	int DECLARATION_STRUCTURE = 1;

	/**
	 * The number of structural features of the '<em>Structure</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DECLARATION_STRUCTURE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.VariableDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 0;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__TYPE_NAME = DECLARATION_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__VARIABLES = DECLARATION_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = DECLARATION_STRUCTURE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.MLDeclarationImpl <em>ML Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.MLDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getMLDeclaration()
	 * @generated
	 */
	int ML_DECLARATION = 2;

	/**
	 * The feature id for the '<em><b>Code</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ML_DECLARATION__CODE = DECLARATION_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>ML Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ML_DECLARATION_FEATURE_COUNT = DECLARATION_STRUCTURE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.UseDeclarationImpl <em>Use Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.UseDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getUseDeclaration()
	 * @generated
	 */
	int USE_DECLARATION = 3;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_DECLARATION__FILE_NAME = DECLARATION_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Use Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_DECLARATION_FEATURE_COUNT = DECLARATION_STRUCTURE_FEATURE_COUNT + 1;


	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.GlobalReferenceDeclarationImpl <em>Global Reference Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.GlobalReferenceDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getGlobalReferenceDeclaration()
	 * @generated
	 */
	int GLOBAL_REFERENCE_DECLARATION = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_REFERENCE_DECLARATION__NAME = DECLARATION_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_REFERENCE_DECLARATION__VALUE = DECLARATION_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Global Reference Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_REFERENCE_DECLARATION_FEATURE_COUNT = DECLARATION_STRUCTURE_FEATURE_COUNT + 2;


	/**
	 * The meta object id for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.TypeDeclarationImpl
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getTypeDeclaration()
	 * @generated
	 */
	int TYPE_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Type Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__TYPE_NAME = DECLARATION_STRUCTURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION__TYPE = DECLARATION_STRUCTURE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_DECLARATION_FEATURE_COUNT = DECLARATION_STRUCTURE_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration#getTypeName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_TypeName();

	/**
	 * Returns the meta object for the attribute list '{@link dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Variables</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration#getVariables()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Variables();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationStructure <em>Structure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structure</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationStructure
	 * @generated
	 */
	EClass getDeclarationStructure();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration <em>ML Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>ML Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration
	 * @generated
	 */
	EClass getMLDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration#getCode <em>Code</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Code</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration#getCode()
	 * @see #getMLDeclaration()
	 * @generated
	 */
	EAttribute getMLDeclaration_Code();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration <em>Use Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration
	 * @generated
	 */
	EClass getUseDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration#getFileName()
	 * @see #getUseDeclaration()
	 * @generated
	 */
	EAttribute getUseDeclaration_FileName();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration <em>Global Reference Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Reference Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration
	 * @generated
	 */
	EClass getGlobalReferenceDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration#getName()
	 * @see #getGlobalReferenceDeclaration()
	 * @generated
	 */
	EAttribute getGlobalReferenceDeclaration_Name();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration#getValue()
	 * @see #getGlobalReferenceDeclaration()
	 * @generated
	 */
	EAttribute getGlobalReferenceDeclaration_Value();

	/**
	 * Returns the meta object for class '{@link dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration <em>Type Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Declaration</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration
	 * @generated
	 */
	EClass getTypeDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getTypeName <em>Type Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type Name</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getTypeName()
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	EAttribute getTypeDeclaration_TypeName();

	/**
	 * Returns the meta object for the containment reference '{@link dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration#getType()
	 * @see #getTypeDeclaration()
	 * @generated
	 */
	EReference getTypeDeclaration_Type();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DeclarationFactory getDeclarationFactory();

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
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.VariableDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();
		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__TYPE_NAME = eINSTANCE.getVariableDeclaration_TypeName();
		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__VARIABLES = eINSTANCE.getVariableDeclaration_Variables();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationStructureImpl <em>Structure</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationStructureImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getDeclarationStructure()
		 * @generated
		 */
		EClass DECLARATION_STRUCTURE = eINSTANCE.getDeclarationStructure();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.MLDeclarationImpl <em>ML Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.MLDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getMLDeclaration()
		 * @generated
		 */
		EClass ML_DECLARATION = eINSTANCE.getMLDeclaration();
		/**
		 * The meta object literal for the '<em><b>Code</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ML_DECLARATION__CODE = eINSTANCE.getMLDeclaration_Code();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.UseDeclarationImpl <em>Use Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.UseDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getUseDeclaration()
		 * @generated
		 */
		EClass USE_DECLARATION = eINSTANCE.getUseDeclaration();
		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_DECLARATION__FILE_NAME = eINSTANCE.getUseDeclaration_FileName();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.GlobalReferenceDeclarationImpl <em>Global Reference Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.GlobalReferenceDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getGlobalReferenceDeclaration()
		 * @generated
		 */
		EClass GLOBAL_REFERENCE_DECLARATION = eINSTANCE.getGlobalReferenceDeclaration();
		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_REFERENCE_DECLARATION__NAME = eINSTANCE.getGlobalReferenceDeclaration_Name();
		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_REFERENCE_DECLARATION__VALUE = eINSTANCE.getGlobalReferenceDeclaration_Value();
		/**
		 * The meta object literal for the '{@link dk.au.daimi.ascoveco.cpn.model.declaration.impl.TypeDeclarationImpl <em>Type Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.TypeDeclarationImpl
		 * @see dk.au.daimi.ascoveco.cpn.model.declaration.impl.DeclarationPackageImpl#getTypeDeclaration()
		 * @generated
		 */
		EClass TYPE_DECLARATION = eINSTANCE.getTypeDeclaration();
		/**
		 * The meta object literal for the '<em><b>Type Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TYPE_DECLARATION__TYPE_NAME = eINSTANCE.getTypeDeclaration_TypeName();
		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_DECLARATION__TYPE = eINSTANCE.getTypeDeclaration_Type();

	}

} //DeclarationPackage
