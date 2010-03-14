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
import dk.au.daimi.ascoveco.cpn.model.TransitionNode;
import dk.au.daimi.ascoveco.cpn.model.Name;
import dk.au.daimi.ascoveco.cpn.model.Node;

/**
 * This is the item provider adapter for a {@link dk.au.daimi.ascoveco.cpn.model.TransitionNode} object. <!--
 * begin-user-doc --> <!-- end-user-doc -->
 * 
 * @generated
 */
public class TransitionNodeItemProvider extends NodeItemProvider implements IEditingDomainItemProvider,
        IStructuredItemContentProvider, ITreeItemContentProvider, IItemLabelProvider, IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public TransitionNodeItemProvider(AdapterFactory adapterFactory) {
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

			addConditionPropertyDescriptor(object);
			addCodePropertyDescriptor(object);
			addTimePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Condition feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addConditionPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_HLTransitionAddin_condition_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_HLTransitionAddin_condition_feature", "_UI_HLTransitionAddin_type"),
				 ModelPackage.Literals.HL_TRANSITION_ADDIN__CONDITION,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Code feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addCodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CPNToolsTransitionAddin_code_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CPNToolsTransitionAddin_code_feature", "_UI_CPNToolsTransitionAddin_type"),
				 ModelPackage.Literals.CPN_TOOLS_TRANSITION_ADDIN__CODE,
				 true,
				 false,
				 true,
				 null,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Time feature.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void addTimePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_CPNToolsTransitionAddin_time_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_CPNToolsTransitionAddin_time_feature", "_UI_CPNToolsTransitionAddin_type"),
				 ModelPackage.Literals.CPN_TOOLS_TRANSITION_ADDIN__TIME,
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
		return label == null || label.length() == 0 ? getString("_UI_TransitionNode_type")
		        : getString("_UI_TransitionNode_type") + " " + label;
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
