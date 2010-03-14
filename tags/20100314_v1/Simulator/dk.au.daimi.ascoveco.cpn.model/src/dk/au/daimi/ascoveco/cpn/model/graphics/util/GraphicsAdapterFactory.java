/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.graphics.util;

import dk.au.daimi.ascoveco.cpn.model.graphics.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;
import org.eclipse.emf.ecore.EObject;

import dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate;
import dk.au.daimi.ascoveco.cpn.model.graphics.Fill;
import dk.au.daimi.ascoveco.cpn.model.graphics.Font;
import dk.au.daimi.ascoveco.cpn.model.graphics.Graphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage;
import dk.au.daimi.ascoveco.cpn.model.graphics.HasGraphics;
import dk.au.daimi.ascoveco.cpn.model.graphics.Line;
import dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics;

/**
 * <!-- begin-user-doc --> The <b>Adapter Factory</b> for the model. It provides an adapter <code>createXXX</code>
 * method for each class of the model. <!-- end-user-doc -->
 * @see dk.au.daimi.ascoveco.cpn.model.graphics.GraphicsPackage
 * @generated
 */
public class GraphicsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected final static GraphicsPackage modelPackage = GraphicsPackage.eINSTANCE;

	/**
	 * Creates an instance of the adapter factory. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public GraphicsAdapterFactory() {
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
	protected GraphicsSwitch<Adapter> modelSwitch = new GraphicsSwitch<Adapter>() {
			@Override
			public Adapter caseAnnotationGraphics(AnnotationGraphics object) {
				return createAnnotationGraphicsAdapter();
			}
			@Override
			public Adapter caseArcGraphics(ArcGraphics object) {
				return createArcGraphicsAdapter();
			}
			@Override
			public Adapter caseCoordinate(Coordinate object) {
				return createCoordinateAdapter();
			}
			@Override
			public Adapter caseFill(Fill object) {
				return createFillAdapter();
			}
			@Override
			public Adapter caseFont(Font object) {
				return createFontAdapter();
			}
			@Override
			public Adapter caseGraphics(Graphics object) {
				return createGraphicsAdapter();
			}
			@Override
			public Adapter caseHasGraphics(HasGraphics object) {
				return createHasGraphicsAdapter();
			}
			@Override
			public Adapter caseLine(Line object) {
				return createLineAdapter();
			}
			@Override
			public Adapter caseNodeGraphics(NodeGraphics object) {
				return createNodeGraphicsAdapter();
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
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics <em>Annotation Graphics</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can
	 * easily ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!--
	 * end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.AnnotationGraphics
	 * @generated
	 */
	public Adapter createAnnotationGraphicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics
	 * <em>Arc Graphics</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.ArcGraphics
	 * @generated
	 */
	public Adapter createArcGraphicsAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate
	 * <em>Coordinate</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Coordinate
	 * @generated
	 */
	public Adapter createCoordinateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Fill <em>Fill</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Fill
	 * @generated
	 */
	public Adapter createFillAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Font <em>Font</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Font
	 * @generated
	 */
	public Adapter createFontAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Graphics
	 * <em>Graphics</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Graphics
	 * @generated
	 */
	public Adapter createGraphicsAdapter() {
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
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.Line <em>Line</em>}'.
	 * <!-- begin-user-doc --> This default implementation returns null so that we can easily ignore cases; it's
	 * useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.Line
	 * @generated
	 */
	public Adapter createLineAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics
	 * <em>Node Graphics</em>}'. <!-- begin-user-doc --> This default implementation returns null so that we can easily
	 * ignore cases; it's useful to ignore a case when inheritance will catch all the cases anyway. <!-- end-user-doc
	 * -->
	 * 
	 * @return the new adapter.
	 * @see dk.au.daimi.ascoveco.cpn.model.graphics.NodeGraphics
	 * @generated
	 */
	public Adapter createNodeGraphicsAdapter() {
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

} // GraphicsAdapterFactory
