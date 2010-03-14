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
import org.eclipse.emf.ecore.util.InternalEList;

import dk.au.daimi.ascoveco.cpn.model.FusionGroup;
import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.HasId;
import dk.au.daimi.ascoveco.cpn.model.HasLabel;
import dk.au.daimi.ascoveco.cpn.model.HasName;
import dk.au.daimi.ascoveco.cpn.model.Label;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.cpn.model.ToolInfo;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Petri Net</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getToolinfo <em>Toolinfo</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getId <em>Id</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getName <em>Name</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getType <em>Type</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getPage <em>Page</em>}</li>
 *   <li>{@link dk.au.daimi.ascoveco.cpn.model.impl.PetriNetImpl#getFusionGroups <em>Fusion Groups</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PetriNetImpl extends EObjectImpl implements PetriNet {
	/**
	 * The cached value of the '{@link #getToolinfo() <em>Toolinfo</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getToolinfo()
	 * @generated
	 * @ordered
	 */
	protected EList<ToolInfo> toolinfo;

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
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<Label> label;

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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPage() <em>Page</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPage()
	 * @generated
	 * @ordered
	 */
	protected EList<Page> page;

	/**
	 * The cached value of the '{@link #getFusionGroups() <em>Fusion Groups</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getFusionGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<FusionGroup> fusionGroups;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected PetriNetImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelPackage.Literals.PETRI_NET;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ToolInfo> getToolinfo() {
		if (toolinfo == null) {
			toolinfo = new EObjectContainmentWithInverseEList<ToolInfo>(ToolInfo.class, this, ModelPackage.PETRI_NET__TOOLINFO, ModelPackage.TOOL_INFO__PARENT);
		}
		return toolinfo;
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PETRI_NET__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Label> getLabel() {
		if (label == null) {
			label = new EObjectContainmentWithInverseEList<Label>(Label.class, this, ModelPackage.PETRI_NET__LABEL, ModelPackage.LABEL__PARENT);
		}
		return label;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelPackage.PETRI_NET__NAME, oldName, name));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PETRI_NET__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelPackage.PETRI_NET__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Page> getPage() {
		if (page == null) {
			page = new EObjectContainmentWithInverseEList<Page>(Page.class, this, ModelPackage.PETRI_NET__PAGE, ModelPackage.PAGE__PETRI_NET);
		}
		return page;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FusionGroup> getFusionGroups() {
		if (fusionGroups == null) {
			fusionGroups = new EObjectContainmentWithInverseEList<FusionGroup>(FusionGroup.class, this, ModelPackage.PETRI_NET__FUSION_GROUPS, ModelPackage.FUSION_GROUP__PETRI_NET);
		}
		return fusionGroups;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PETRI_NET__TOOLINFO:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getToolinfo()).basicAdd(otherEnd, msgs);
			case ModelPackage.PETRI_NET__LABEL:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLabel()).basicAdd(otherEnd, msgs);
			case ModelPackage.PETRI_NET__PAGE:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getPage()).basicAdd(otherEnd, msgs);
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFusionGroups()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> Whenever the model is regenerated, this will yield an error because of the @override
	 * annotation. Just remove the annotation. <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelPackage.PETRI_NET__TOOLINFO:
				return ((InternalEList<?>)getToolinfo()).basicRemove(otherEnd, msgs);
			case ModelPackage.PETRI_NET__LABEL:
				return ((InternalEList<?>)getLabel()).basicRemove(otherEnd, msgs);
			case ModelPackage.PETRI_NET__PAGE:
				return ((InternalEList<?>)getPage()).basicRemove(otherEnd, msgs);
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				return ((InternalEList<?>)getFusionGroups()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelPackage.PETRI_NET__TOOLINFO:
				return getToolinfo();
			case ModelPackage.PETRI_NET__ID:
				return getId();
			case ModelPackage.PETRI_NET__LABEL:
				return getLabel();
			case ModelPackage.PETRI_NET__NAME:
				if (resolve) return getName();
				return basicGetName();
			case ModelPackage.PETRI_NET__TYPE:
				return getType();
			case ModelPackage.PETRI_NET__PAGE:
				return getPage();
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				return getFusionGroups();
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
			case ModelPackage.PETRI_NET__TOOLINFO:
				getToolinfo().clear();
				getToolinfo().addAll((Collection<? extends ToolInfo>)newValue);
				return;
			case ModelPackage.PETRI_NET__ID:
				setId((String)newValue);
				return;
			case ModelPackage.PETRI_NET__LABEL:
				getLabel().clear();
				getLabel().addAll((Collection<? extends Label>)newValue);
				return;
			case ModelPackage.PETRI_NET__NAME:
				setName((Name)newValue);
				return;
			case ModelPackage.PETRI_NET__TYPE:
				setType((String)newValue);
				return;
			case ModelPackage.PETRI_NET__PAGE:
				getPage().clear();
				getPage().addAll((Collection<? extends Page>)newValue);
				return;
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				getFusionGroups().clear();
				getFusionGroups().addAll((Collection<? extends FusionGroup>)newValue);
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
			case ModelPackage.PETRI_NET__TOOLINFO:
				getToolinfo().clear();
				return;
			case ModelPackage.PETRI_NET__ID:
				setId(ID_EDEFAULT);
				return;
			case ModelPackage.PETRI_NET__LABEL:
				getLabel().clear();
				return;
			case ModelPackage.PETRI_NET__NAME:
				setName((Name)null);
				return;
			case ModelPackage.PETRI_NET__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case ModelPackage.PETRI_NET__PAGE:
				getPage().clear();
				return;
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				getFusionGroups().clear();
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
			case ModelPackage.PETRI_NET__TOOLINFO:
				return toolinfo != null && !toolinfo.isEmpty();
			case ModelPackage.PETRI_NET__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case ModelPackage.PETRI_NET__LABEL:
				return label != null && !label.isEmpty();
			case ModelPackage.PETRI_NET__NAME:
				return name != null;
			case ModelPackage.PETRI_NET__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case ModelPackage.PETRI_NET__PAGE:
				return page != null && !page.isEmpty();
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				return fusionGroups != null && !fusionGroups.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == HasId.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PETRI_NET__ID: return ModelPackage.HAS_ID__ID;
				default: return -1;
			}
		}
		if (baseClass == HasLabel.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PETRI_NET__LABEL: return ModelPackage.HAS_LABEL__LABEL;
				default: return -1;
			}
		}
		if (baseClass == HasName.class) {
			switch (derivedFeatureID) {
				case ModelPackage.PETRI_NET__NAME: return ModelPackage.HAS_NAME__NAME;
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
		if (baseClass == HasId.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_ID__ID: return ModelPackage.PETRI_NET__ID;
				default: return -1;
			}
		}
		if (baseClass == HasLabel.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_LABEL__LABEL: return ModelPackage.PETRI_NET__LABEL;
				default: return -1;
			}
		}
		if (baseClass == HasName.class) {
			switch (baseFeatureID) {
				case ModelPackage.HAS_NAME__NAME: return ModelPackage.PETRI_NET__NAME;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String toString() {
		if (eIsProxy()) { return super.toString(); }

		final StringBuffer result = new StringBuffer(getClass().getSimpleName().replaceFirst("Impl$", ""));
		result.append(" (");
		result.append(getName());
		result.append(')');
		return result.toString();
	}

	/**
	 * @see dk.au.daimi.ascoveco.cpn.model.PetriNet#declaration()
	 */
	@SuppressWarnings("unchecked")
	public Iterable<HLDeclaration> declaration() {
		return new Iterable<HLDeclaration>() {
			public Iterator<HLDeclaration> iterator() {
				return (FilterIterator<HLDeclaration>) (FilterIterator<?>) new FilterIterator<Label>(getLabel()
				        .iterator()) {
					@Override
					public boolean accept(final Label label) {
						return label instanceof HLDeclaration;
					}
				};
			}
		};
	}

} // PetriNetImpl
