/**
 * <copyright> </copyright> $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.provider;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import dk.au.daimi.ascoveco.cpn.model.ModelFactory;
import dk.au.daimi.ascoveco.cpn.model.ModelPackage;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;

/**
 * This is the item provider adapter for a {@link dk.au.daimi.ascoveco.cpn.model.PetriNet} object.
 * <!-- begin-user-doc
 * --> <!-- end-user-doc -->
 * @generated
 */
public class PetriNetItemProvider extends ItemProviderAdapter implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public PetriNetItemProvider(AdapterFactory adapterFactory) {
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

			addIdPropertyDescriptor(object);
			addNamePropertyDescriptor(object);
			addTypePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Id feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addIdPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HasId_id_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HasId_id_feature", "_UI_HasId_type"),
				 ModelPackage.Literals.HAS_ID__ID,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Name feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HasName_name_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HasName_name_feature", "_UI_HasName_type"),
				 ModelPackage.Literals.HAS_NAME__NAME,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
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
				 getString("_UI_PetriNet_type_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_PetriNet_type_feature", "_UI_PetriNet_type"),
				 ModelPackage.Literals.PETRI_NET__TYPE,
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(ModelPackage.Literals.HAS_TOOL_INFO__TOOLINFO);
			childrenFeatures.add(ModelPackage.Literals.HAS_LABEL__LABEL);
			childrenFeatures.add(ModelPackage.Literals.PETRI_NET__PAGE);
			childrenFeatures.add(ModelPackage.Literals.PETRI_NET__FUSION_GROUPS);
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns PetriNet.gif.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/PetriNet"));
	}

	/**
	 * This returns the label text for the adapted class. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	@Override
	public String getText(final Object object) {
		final Name name = ((PetriNet) object).getName();
		final String label = name != null ? name.getText() : "<unnamed>";
		return label == null || label.length() == 0 ? getString("_UI_PetriNet_type") : getString("_UI_PetriNet_type")
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

		switch (notification.getFeatureID(PetriNet.class)) {
			case ModelPackage.PETRI_NET__ID:
			case ModelPackage.PETRI_NET__TYPE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case ModelPackage.PETRI_NET__TOOLINFO:
			case ModelPackage.PETRI_NET__LABEL:
			case ModelPackage.PETRI_NET__PAGE:
			case ModelPackage.PETRI_NET__FUSION_GROUPS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
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

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_TOOL_INFO__TOOLINFO,
				 ModelFactory.eINSTANCE.createToolInfo()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createHLAnnotation()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createName()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createHLMarking()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createType()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createCondition()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createCode()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createTime()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.HAS_LABEL__LABEL,
				 ModelFactory.eINSTANCE.createHLDeclaration()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PETRI_NET__PAGE,
				 ModelFactory.eINSTANCE.createPage()));

		newChildDescriptors.add
			(createChildParameter
				(ModelPackage.Literals.PETRI_NET__FUSION_GROUPS,
				 ModelFactory.eINSTANCE.createFusionGroup()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return ModelEditPlugin.INSTANCE;
	}

}
