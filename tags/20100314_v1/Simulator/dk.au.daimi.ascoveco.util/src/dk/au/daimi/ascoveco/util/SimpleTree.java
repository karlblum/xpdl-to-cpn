package dk.au.daimi.ascoveco.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.PlatformObject;

/**
 * @author michael
 * @param <T>
 */
public class SimpleTree<T> extends PlatformObject {
	List<SimpleTree<? extends T>> children;
	SimpleTree<? extends T>[] savedChildrenAsArray = null;
	T object;
	SimpleTree<T> parent = null;
	String text;

	/**
	 * @param parent
	 *            parent node
	 * @param text
	 *            text of this node (object is null)
	 */
	public SimpleTree(final SimpleTree<T> parent, final String text) {
		this(parent, text, null);
	}

	/**
	 * @param parent
	 *            parent node
	 * @param text
	 *            text of this node
	 * @param object
	 *            object associated with this node
	 */
	public SimpleTree(final SimpleTree<T> parent, final String text, final T object) {
		this.text = text;
		this.parent = parent;
		this.object = object;
		children = new ArrayList<SimpleTree<? extends T>>();
		if (parent != null) {
			synchronized (parent) {
				parent.children.add(this);
				parent.savedChildrenAsArray = null;
			}
		}
	}

	/**
	 * @param text
	 *            text of this node (parent and object are null)
	 */
	public SimpleTree(final String text) {
		this(null, text);
	}

	/**
	 * @return all children as an array
	 */
	@SuppressWarnings("unchecked")
	public synchronized SimpleTree<? extends T>[] getChildren() {
		if (savedChildrenAsArray == null) {
			savedChildrenAsArray = new SimpleTree[children.size()];
			children.toArray(savedChildrenAsArray);
		}
		return savedChildrenAsArray;
	}

	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}

	/**
	 * @return the parent
	 */
	public SimpleTree<T> getParent() {
		return parent;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @return whether this node has children
	 */
	public boolean hasChildren() {
		return !children.isEmpty();
	}
}
