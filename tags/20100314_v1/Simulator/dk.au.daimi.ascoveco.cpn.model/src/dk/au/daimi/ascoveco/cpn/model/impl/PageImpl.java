/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.impl;

import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.model.Arc;
import dk.au.daimi.ascoveco.cpn.model.HasId;
import dk.au.daimi.ascoveco.cpn.model.HasLabel;
import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.Label;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.Place;
import dk.au.daimi.ascoveco.cpn.model.RefPlace;
import dk.au.daimi.ascoveco.cpn.model.Transition;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Page</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getName <em>Name</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getId <em>Id</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getPetriNet <em>Petri Net</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getObject <em>Object</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PageImpl#getArc <em>Arc</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PageImpl extends EObjectImpl implements Page {
	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected Name name;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> label;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getObject() <em>Object</em>}' containment reference list.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getObject()
	 * @generated
	 * @ordered
	 */
	protected EList<dk.au.daimi.ascoveco.cpn.model.Object> object;

	/**
	 * The cached value of the '{@link #getArc() <em>Arc</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getArc()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> arc;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PAGE;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Name getName() {
		if (name != null && name.eIsProxy()) {
			InternalEObject oldName = (InternalEObject)name;
			name = (Name)eResolveProxy(oldName);
			if (name != oldName) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PAGE__NAME, oldName, name));
			}
		}
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Name basicGetName() {
		return name;
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.HasName#setName(dk.au.daimi.ascoveco.cpn.model.Name)
	 */
	public void setName(final Name newName) {
		if (name != null) {
			name.setParent(null);
		}
		setNameGen(newName);
		if (newName != null) {
			newName.setParent(this);
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setNameGen(Name newName) {
		Name oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabel() {
		if (label == null) {
			label = new EObjectContainmentWithInverseEList<Label>(Label.class, this, ModelPackage.PAGE__LABEL, ModelPackage.LABEL__PARENT);
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PetriNet getPetriNet() {
		if (eContainerFeatureID() != ModelPackage.PAGE__PETRI_NET) return null;
		return (PetriNet)eContainer();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPetriNet(PetriNet newPetriNet, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newPetriNet, ModelPackage.PAGE__PETRI_NET, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPetriNet(PetriNet newPetriNet) {
		if (newPetriNet != eInternalContainer() || (eContainerFeatureID() != ModelPackage.PAGE__PETRI_NET && newPetriNet != null)) {
			if (EcoreUtil.isAncestor(this, newPetriNet))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newPetriNet != null)
				msgs = ((InternalEObject)newPetriNet).eInverseAdd(this, ModelPackage.PETRI_NET__PAGE, PetriNet.class, msgs);
			msgs = basicSetPetriNet(newPetriNet, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PAGE__PETRI_NET, newPetriNet, newPetriNet));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<dk.au.daimi.ascoveco.cpn.model.Object> getObject() {
		if (object == null) {
			object = new EObjectContainmentWithInverseEList<dk.au.daimi.ascoveco.cpn.model.Object>(dk.au.daimi.ascoveco.cpn.model.Object.class, this, ModelPackage.PAGE__OBJECT, ModelPackage.OBJECT__PAGE);
		}
		return object;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getArc() {
		if (arc == null) {
			arc = new EObjectContainmentWithInverseEList<Arc>(Arc.class, this, ModelPackage.PAGE__ARC, ModelPackage.ARC__PAGE);
		}
		return arc;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PAGE__LABEL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabel()).basicAdd(otherEnd, msgs);
			case ModelPackage.PAGE__PETRI_NET:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetPetriNet((PetriNet)otherEnd, msgs);
			case ModelPackage.PAGE__OBJECT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getObject()).basicAdd(otherEnd, msgs);
			case ModelPackage.PAGE__ARC:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getArc()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PAGE__LABEL:
				return ((InternalEList<?>)getLabel()).basicRemove(otherEnd, msgs);
			case ModelPackage.PAGE__PETRI_NET:
				return basicSetPetriNet(null, msgs);
			case ModelPackage.PAGE__OBJECT:
				return ((InternalEList<?>)getObject()).basicRemove(otherEnd, msgs);
			case ModelPackage.PAGE__ARC:
				return ((InternalEList<?>)getArc()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case ModelPackage.PAGE__PETRI_NET:
				return eInternalContainer().eInverseRemove(this, ModelPackage.PETRI_NET__PAGE, PetriNet.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PAGE__NAME:
				if (resolve) return getName();
				return basicGetName();
			case ModelPackage.PAGE__LABEL:
				return getLabel();
			case ModelPackage.PAGE__ID:
				return getId();
			case ModelPackage.PAGE__PETRI_NET:
				return getPetriNet();
			case ModelPackage.PAGE__OBJECT:
				return getObject();
			case ModelPackage.PAGE__ARC:
				return getArc();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelPackage.PAGE__NAME:
				setName((Name)newValue);
				return;
			case ModelPackage.PAGE__LABEL:
				getLabel().clear();
				getLabel().addAll((Collection<? extends Label>)newValue);
				return;
			case ModelPackage.PAGE__ID:
				setId((String)newValue);
				return;
			case ModelPackage.PAGE__PETRI_NET:
				setPetriNet((PetriNet)newValue);
				return;
			case ModelPackage.PAGE__OBJECT:
				getObject().clear();
				getObject().addAll((Collection<? extends dk.au.daimi.ascoveco.cpn.model.Object>)newValue);
				return;
			case ModelPackage.PAGE__ARC:
				getArc().clear();
				getArc().addAll((Collection<? extends Arc>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModelPackage.PAGE__NAME:
				setName((Name)null);
				return;
			case ModelPackage.PAGE__LABEL:
				getLabel().clear();
				return;
			case ModelPackage.PAGE__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.PAGE__PETRI_NET:
				setPetriNet((PetriNet)null);
				return;
			case ModelPackage.PAGE__OBJECT:
				getObject().clear();
				return;
			case ModelPackage.PAGE__ARC:
				getArc().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModelPackage.PAGE__NAME:
				return name != null;
			case ModelPackage.PAGE__LABEL:
				return label != null && !label.isEmpty();
			case ModelPackage.PAGE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.PAGE__PETRI_NET:
				return getPetriNet() != null;
			case ModelPackage.PAGE__OBJECT:
				return object != null && !object.isEmpty();
			case ModelPackage.PAGE__ARC:
				return arc != null && !arc.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasLabel.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PAGE__LABEL: return ModelPackage.HAS_LABEL__LABEL;
				default: return -1;
			}
		}
		if (baseClass == HasId.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PAGE__ID: return ModelPackage.HAS_ID__ID;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == HasLabel.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_LABEL__LABEL: return ModelPackage.PAGE__LABEL;
				default: return -1;
			}
		}
		if (baseClass == HasId.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_ID__ID: return ModelPackage.PAGE__ID;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#place()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Place> place() {
		return new Iterable<Place>() {
			public Iterator<Place> iterator() {
				return (FilterIterator<Place>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Place;
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#transition()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Transition> transition() {
		return new Iterable<Transition>() {
			public Iterator<Transition> iterator() {
				return (FilterIterator<Transition>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Transition;
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#instance()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Instance> instance() {
		return new Iterable<Instance>() {
			public Iterator<Instance> iterator() {
				return (FilterIterator<Instance>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Instance;
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#fusionGroup()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<RefPlace> fusionGroup() {
		return new Iterable<RefPlace>() {
			public Iterator<RefPlace> iterator() {
				return (FilterIterator<RefPlace>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof RefPlace && ((RefPlace) object).isFusionGroup();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#portPlace()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<RefPlace> portPlace() {
		return new Iterable<RefPlace>() {
			public Iterator<RefPlace> iterator() {
				return (FilterIterator<RefPlace>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof RefPlace && ((RefPlace) object).isPort();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#place()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Place> readyPlaces() {
		return new Iterable<Place>() {
			public Iterator<Place> iterator() {
				return (FilterIterator<Place>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Place && ((Place) object).isReady();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#transition()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Transition> readyTransitions() {
		return new Iterable<Transition>() {
			public Iterator<Transition> iterator() {
				return (FilterIterator<Transition>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Transition && ((Transition) object).isReady();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#instance()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<Instance> readyInstances() {
		return new Iterable<Instance>() {
			public Iterator<Instance> iterator() {
				return (FilterIterator<Instance>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof Instance && ((Instance) object).isReady();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#fusionGroup()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<RefPlace> readyFusionGroups() {
		return new Iterable<RefPlace>() {
			public Iterator<RefPlace> iterator() {
				return (FilterIterator<RefPlace>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof RefPlace && ((RefPlace) object).isFusionGroup()
						        && ((RefPlace) object).isReady();
					}
				};
			}
		};
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.Page#portPlace()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<RefPlace> readyPortPlaces() {
		return new Iterable<RefPlace>() {
			public Iterator<RefPlace> iterator() {
				return (FilterIterator<RefPlace>) (FilterIterator<?>) new FilterIterator<dk.au.daimi.ascoveco.cpn.model.Object>(
				        getObject().iterator()) {
					@Override
					public boolean accept(final dk.au.daimi.ascoveco.cpn.model.Object object) {
						return object instanceof RefPlace && ((RefPlace) object).isPort()
						        && ((RefPlace) object).isReady();
					}
				};
			}
		};
	}

} // PageImpl
