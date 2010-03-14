/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.PlaceNode;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Node;

/**
 * This is the item provider adapter for a {@link dk.au.daimi.ascoveco.cpn.model.PlaceNode} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class PlaceNodeItemProvider extends NodeItemProvider implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PlaceNodeItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addTypePropertyDescriptor(object);
			addInitialMarkingPropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Type feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTypePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HLPlaceAddin_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HLPlaceAddin_type_feature", "_UI_HLPlaceAddin_type"),
				 ModelPackage.Literals.HL_PLACE_ADDIN__TYPE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Initial Marking feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addInitialMarkingPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HLPlaceAddin_initialMarking_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HLPlaceAddin_initialMarking_feature", "_UI_HLPlaceAddin_type"),
				 ModelPackage.Literals.HL_PLACE_ADDIN__INITIAL_MARKING,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(final Object object) {
		final Name name = ((Node) object).getName();
		final String label = name != null ? name.getText() : "<unnamed>";
		return label == null || label.length() == 0 ? getString("_UI_PlaceNode_type") : getString("_UI_PlaceNode_type")
		        + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached children and by creating
	 * a viewer notification, which it passes to {@link #fireNotifyChanged}. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);
	}

}
