package dk.klafbang.tools;

/**
 * @author Michael Westergaard
 * @param <S>
 *            type of first component
 * @param <T>
 *            type of second component
 */
public class Pair<S, T> {
	/**
	 * @param <S>
	 *            type of first
	 * @param <T>
	 *            type of second
	 * @param first
	 *            first componenet
	 * @param second
	 *            second component
	 * @return a new Pair instance
	 */
	public static <S, T> Pair<S, T> createPair(final S first, final T second) {
		return new Pair<S, T>(first, second);
	}

	S first;

	T second;

	/**
	 * @param first
	 *            first component
	 * @param second
	 *            second component
	 */
	public Pair(final S first, final T second) {
		this.first = first;
		this.second = second;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object object) {
		try {
			final Pair<?, ?> other = (Pair<?, ?>) object;
			if (first == null && other.first == null || first.equals(other.first)
			        && (second == null && other.second == null || second.equals(other.second))) { return true; }
			return false;
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 * @return first componont
	 */
	public S getFirst() {
		return first;
	}

	/**
	 * @return second component
	 */
	public T getSecond() {
		return second;
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		try {
			final int hash1 = first.hashCode();
			try {
				final int hash2 = second.hashCode();
				return hash1 + hash2;
			} catch (final Exception e2) {
				return hash1;
			}
		} catch (final Exception e) {
			return 0;
		}
	}

	/**
	 * @param value
	 *            value to set for first component
	 */
	public void setFirst(final S value) {
		first = value;
	}

	/**
	 * @param value
	 *            value to set for second component
	 */
	public void setSecond(final T value) {
		second = value;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "(" + first + ", " + second + ')'; //$NON-NLS-1$
	}
}
