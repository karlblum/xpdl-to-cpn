/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.declaration.impl;

import dk.au.daimi.ascoveco.cpn.model.declaration.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeclarationFactoryImpl extends EFactoryImpl implements DeclarationFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeclarationFactory init() {
		try {
			DeclarationFactory theDeclarationFactory = (DeclarationFactory)EPackage.Registry.INSTANCE.getEFactory("http:///dk/au/daimi/ascoveco/cpn/model/declaration.ecore"); 
			if (theDeclarationFactory != null) {
				return theDeclarationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeclarationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DeclarationPackage.VARIABLE_DECLARATION: return createVariableDeclaration();
			case DeclarationPackage.ML_DECLARATION: return createMLDeclaration();
			case DeclarationPackage.USE_DECLARATION: return createUseDeclaration();
			case DeclarationPackage.GLOBAL_REFERENCE_DECLARATION: return createGlobalReferenceDeclaration();
			case DeclarationPackage.TYPE_DECLARATION: return createTypeDeclaration();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableDeclaration createVariableDeclaration() {
		VariableDeclarationImpl variableDeclaration = new VariableDeclarationImpl();
		return variableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MLDeclaration createMLDeclaration() {
		MLDeclarationImpl mlDeclaration = new MLDeclarationImpl();
		return mlDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseDeclaration createUseDeclaration() {
		UseDeclarationImpl useDeclaration = new UseDeclarationImpl();
		return useDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public GlobalReferenceDeclaration createGlobalReferenceDeclaration() {
		GlobalReferenceDeclarationImpl globalReferenceDeclaration = new GlobalReferenceDeclarationImpl();
		return globalReferenceDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeDeclaration createTypeDeclaration() {
		TypeDeclarationImpl typeDeclaration = new TypeDeclarationImpl();
		return typeDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeclarationPackage getDeclarationPackage() {
		return (DeclarationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DeclarationPackage getPackage() {
		return DeclarationPackage.eINSTANCE;
	}

} //DeclarationFactoryImpl
