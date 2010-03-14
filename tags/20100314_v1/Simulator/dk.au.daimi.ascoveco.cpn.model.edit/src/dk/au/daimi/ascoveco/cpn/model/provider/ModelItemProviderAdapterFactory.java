/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package dk.au.daimi.ascoveco.cpn.model.provider;

import dk.au.daimi.ascoveco.cpn.model.util.ModelAdapterFactory;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ModelItemProviderAdapterFactory extends ModelAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Arc} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArcItemProvider arcItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Arc}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createArcAdapter() {
		if (arcItemProvider == null) {
			arcItemProvider = new ArcItemProvider(this);
		}

		return arcItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Name} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NameItemProvider nameItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Name}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNameAdapter() {
		if (nameItemProvider == null) {
			nameItemProvider = new NameItemProvider(this);
		}

		return nameItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Page} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PageItemProvider pageItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Page}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPageAdapter() {
		if (pageItemProvider == null) {
			pageItemProvider = new PageItemProvider(this);
		}

		return pageItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.PetriNet} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PetriNetItemProvider petriNetItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.PetriNet}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPetriNetAdapter() {
		if (petriNetItemProvider == null) {
			petriNetItemProvider = new PetriNetItemProvider(this);
		}

		return petriNetItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Place} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PlaceItemProvider placeItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Place}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createPlaceAdapter() {
		if (placeItemProvider == null) {
			placeItemProvider = new PlaceItemProvider(this);
		}

		return placeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.RefPlace} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefPlaceItemProvider refPlaceItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.RefPlace}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRefPlaceAdapter() {
		if (refPlaceItemProvider == null) {
			refPlaceItemProvider = new RefPlaceItemProvider(this);
		}

		return refPlaceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.RefTrans} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RefTransItemProvider refTransItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.RefTrans}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createRefTransAdapter() {
		if (refTransItemProvider == null) {
			refTransItemProvider = new RefTransItemProvider(this);
		}

		return refTransItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.ToolInfo} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ToolInfoItemProvider toolInfoItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.ToolInfo}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createToolInfoAdapter() {
		if (toolInfoItemProvider == null) {
			toolInfoItemProvider = new ToolInfoItemProvider(this);
		}

		return toolInfoItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Transition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TransitionItemProvider transitionItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Transition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTransitionAdapter() {
		if (transitionItemProvider == null) {
			transitionItemProvider = new TransitionItemProvider(this);
		}

		return transitionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.HLMarking} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HLMarkingItemProvider hlMarkingItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.HLMarking}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHLMarkingAdapter() {
		if (hlMarkingItemProvider == null) {
			hlMarkingItemProvider = new HLMarkingItemProvider(this);
		}

		return hlMarkingItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Type} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeItemProvider typeItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Type}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTypeAdapter() {
		if (typeItemProvider == null) {
			typeItemProvider = new TypeItemProvider(this);
		}

		return typeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.HLAnnotation} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HLAnnotationItemProvider hlAnnotationItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.HLAnnotation}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHLAnnotationAdapter() {
		if (hlAnnotationItemProvider == null) {
			hlAnnotationItemProvider = new HLAnnotationItemProvider(this);
		}

		return hlAnnotationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Condition} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConditionItemProvider conditionItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Condition}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createConditionAdapter() {
		if (conditionItemProvider == null) {
			conditionItemProvider = new ConditionItemProvider(this);
		}

		return conditionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Code} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CodeItemProvider codeItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Code}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCodeAdapter() {
		if (codeItemProvider == null) {
			codeItemProvider = new CodeItemProvider(this);
		}

		return codeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Time} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeItemProvider timeItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Time}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeAdapter() {
		if (timeItemProvider == null) {
			timeItemProvider = new TimeItemProvider(this);
		}

		return timeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HLDeclarationItemProvider hlDeclarationItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.HLDeclaration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createHLDeclarationAdapter() {
		if (hlDeclarationItemProvider == null) {
			hlDeclarationItemProvider = new HLDeclarationItemProvider(this);
		}

		return hlDeclarationItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.Instance} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InstanceItemProvider instanceItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.Instance}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createInstanceAdapter() {
		if (instanceItemProvider == null) {
			instanceItemProvider = new InstanceItemProvider(this);
		}

		return instanceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ParameterAssignmentItemProvider parameterAssignmentItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.ParameterAssignment}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createParameterAssignmentAdapter() {
		if (parameterAssignmentItemProvider == null) {
			parameterAssignmentItemProvider = new ParameterAssignmentItemProvider(this);
		}

		return parameterAssignmentItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link dk.au.daimi.ascoveco.cpn.model.FusionGroup} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FusionGroupItemProvider fusionGroupItemProvider;

	/**
	 * This creates an adapter for a {@link dk.au.daimi.ascoveco.cpn.model.FusionGroup}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createFusionGroupAdapter() {
		if (fusionGroupItemProvider == null) {
			fusionGroupItemProvider = new FusionGroupItemProvider(this);
		}

		return fusionGroupItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (arcItemProvider != null) arcItemProvider.dispose();
		if (nameItemProvider != null) nameItemProvider.dispose();
		if (pageItemProvider != null) pageItemProvider.dispose();
		if (petriNetItemProvider != null) petriNetItemProvider.dispose();
		if (placeItemProvider != null) placeItemProvider.dispose();
		if (refPlaceItemProvider != null) refPlaceItemProvider.dispose();
		if (refTransItemProvider != null) refTransItemProvider.dispose();
		if (toolInfoItemProvider != null) toolInfoItemProvider.dispose();
		if (transitionItemProvider != null) transitionItemProvider.dispose();
		if (hlMarkingItemProvider != null) hlMarkingItemProvider.dispose();
		if (typeItemProvider != null) typeItemProvider.dispose();
		if (hlAnnotationItemProvider != null) hlAnnotationItemProvider.dispose();
		if (conditionItemProvider != null) conditionItemProvider.dispose();
		if (codeItemProvider != null) codeItemProvider.dispose();
		if (timeItemProvider != null) timeItemProvider.dispose();
		if (hlDeclarationItemProvider != null) hlDeclarationItemProvider.dispose();
		if (instanceItemProvider != null) instanceItemProvider.dispose();
		if (parameterAssignmentItemProvider != null) parameterAssignmentItemProvider.dispose();
		if (fusionGroupItemProvider != null) fusionGroupItemProvider.dispose();
	}

}
