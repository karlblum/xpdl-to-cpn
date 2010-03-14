package dk.klafbang.tools;

import java.io.Serializable;
import java.util.Comparator;

/**
 * @author mw
 * @param <S> first component
 * @param <T> second componenet
 */
public class FirstComponentComparator<S extends Comparable<S>, T> implements Comparator<Pair<S, T>>, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param o1 first
	 * @param o2 second
	 * @return result of comparing first components
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(final Pair<S, T> o1, final Pair<S, T> o2) {
		return o1.getFirst().compareTo(o2.getFirst());
	}

}
