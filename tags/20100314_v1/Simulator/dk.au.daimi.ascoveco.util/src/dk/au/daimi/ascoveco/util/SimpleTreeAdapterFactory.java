package dk.au.daimi.ascoveco.util;

import org.eclipse.core.runtime.IAdapterFactory;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.model.IWorkbenchAdapter;

/**
 * @author michael
 */
public class SimpleTreeAdapterFactory implements IAdapterFactory {
	IWorkbenchAdapter simpleTreeAdapter = new IWorkbenchAdapter() {
		@SuppressWarnings("unchecked")
		public Object[] getChildren(final Object o) {
			return ((SimpleTree<Object>) o).getChildren();
		}

		public ImageDescriptor getImageDescriptor(final Object object) {
			return null;
		}

		@SuppressWarnings("unchecked")
		public String getLabel(final Object o) {
			return ((SimpleTree<Object>) o).getText();
		}

		@SuppressWarnings("unchecked")
		public Object getParent(final Object o) {
			return ((SimpleTree<Object>) o).getParent();
		}

	};

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapter(java.lang.Object, java.lang.Class)
	 */
	@SuppressWarnings("unchecked")
	public Object getAdapter(final Object adaptableObject, final Class adapterType) {
		return simpleTreeAdapter;
	}

	/**
	 * @see org.eclipse.core.runtime.IAdapterFactory#getAdapterList()
	 */
	@SuppressWarnings("unchecked")
	public Class[] getAdapterList() {
		return new Class[] { IWorkbenchAdapter.class };
	}
}
