package dk.klafbang.tools;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author mw
 * @param <S> first component
 * @param <T> second component
 */
public class SecondComponentComparator<S, T extends Comparable<T>> implements Comparator<Pair<S, T>>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param left left
	 * @param right right
	 * @return the result of comparing the second components
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(final Pair<S, T> left, final Pair<S, T> right) {
		return left.getSecond().compareTo(right.getSecond());
	}

}
