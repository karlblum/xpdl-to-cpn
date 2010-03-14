package dk.au.daimi.ascoveco.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Observable;

/**
 * @author mw
 * @param <E> elements in collection
 */
public class ObservableCollection<E> extends Observable implements Collection<E> {

	private final Collection<E> collection;

	/**
	 * @param collection real collection
	 */
	public ObservableCollection(final Collection<E> collection) {
		this.collection = collection;
	}

	/**
	 * @see java.util.Collection#add(java.lang.Object)
	 */
	public synchronized boolean add(final E arg0) {
		final boolean result = collection.add(arg0);
		setChanged();
		notifyObservers(arg0);
		return result;
	}

	/**
	 * @see java.util.Collection#addAll(java.util.Collection)
	 */
	public synchronized boolean addAll(final Collection<? extends E> arg0) {
		final boolean result = collection.addAll(arg0);
		setChanged();
		notifyObservers(arg0);
		return result;
	}

	/**
	 * @see java.util.Collection#clear()
	 */
	public synchronized void clear() {
		collection.clear();
		setChanged();
		notifyObservers();
	}

	/**
	 * @see java.util.Collection#contains(java.lang.Object)
	 */
	public synchronized boolean contains(final Object arg0) {
		return collection.contains(arg0);
	}

	/**
	 * @see java.util.Collection#containsAll(java.util.Collection)
	 */
	public synchronized boolean containsAll(final Collection<?> arg0) {
		return collection.containsAll(arg0);
	}

	/**
	 * @see java.util.Collection#isEmpty()
	 */
	public synchronized boolean isEmpty() {
		return collection.isEmpty();
	}

	/**
	 * @see java.util.Collection#iterator()
	 */
	public synchronized Iterator<E> iterator() {
		return collection.iterator();
	}

	/**
	 * @see java.util.Collection#remove(java.lang.Object)
	 */
	public synchronized boolean remove(final Object arg0) {
		final boolean result = collection.remove(arg0);
		setChanged();
		notifyObservers(arg0);
		return result;
	}

	/**
	 * @see java.util.Collection#removeAll(java.util.Collection)
	 */
	public synchronized boolean removeAll(final Collection<?> arg0) {
		final boolean result = collection.removeAll(arg0);
		setChanged();
		notifyObservers(arg0);
		return result;
	}

	/**
	 * @see java.util.Collection#retainAll(java.util.Collection)
	 */
	public synchronized boolean retainAll(final Collection<?> arg0) {
		final boolean result = collection.retainAll(arg0);
		setChanged();
		notifyObservers(arg0);
		return result;
	}

	/**
	 * @see java.util.Collection#size()
	 */
	public synchronized int size() {
		return collection.size();
	}

	/**
	 * @see java.util.Collection#toArray()
	 */
	public synchronized Object[] toArray() {
		return collection.toArray();
	}

	/**
	 * @see java.util.Collection#toArray(T[])
	 */
	public synchronized <T> T[] toArray(final T[] arg0) {
		return collection.toArray(arg0);
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return collection.toString();
	}
}
