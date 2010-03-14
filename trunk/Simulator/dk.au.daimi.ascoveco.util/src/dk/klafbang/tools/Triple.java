package dk.klafbang.tools;

/**
 * @author Michael Westergaard
 * @param <S>
 *            type of first component
 * @param <T>
 *            type of second component
 * @param <U>
 *            type of third component
 */
public class Triple<S, T, U> extends Pair<S, T> {
	/**
	 * @param <S>
	 *            type of first
	 * @param <T>
	 *            type of second
	 * @param <U>
	 *            type of third
	 * @param first
	 *            first component
	 * @param second
	 *            second component
	 * @param third
	 *            third component
	 * @return a new Triple
	 */
	public static <S, T, U> Triple<S, T, Class<? extends U>> createTriple(final S first, final T second,
	        final Class<? extends U> third) {
		return new Triple<S, T, Class<? extends U>>(first, second, third);
	}

	/**
	 * @param <S>
	 *            type of first
	 * @param <T>
	 *            type of second
	 * @param <U>
	 *            type of third
	 * @param first
	 *            first component
	 * @param second
	 *            second component
	 * @param third
	 *            third component
	 * @return a new Triple
	 */
	public static <S, T, U> Triple<S, T, U> createTriple(final S first, final T second, final U third) {
		return new Triple<S, T, U>(first, second, third);
	}

	U third;

	/**
	 * @param first
	 *            first component
	 * @param second
	 *            second component
	 * @param third
	 *            third component
	 */
	protected Triple(final S first, final T second, final U third) {
		super(first, second);
		this.third = third;
	}

	/**
	 * @see dk.klafbang.tools.Pair#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object object) {
		try {
			final Triple<?, ?, ?> other = (Triple<?, ?, ?>) object;
			if (super.equals(object) && (third == null && other.third == null || third.equals(other.third))) { return true; }
			return false;
		} catch (final Exception e) {
			return false;
		}
	}

	/**
	 * @return third entry
	 */
	public U getThird() {
		return third;
	}

	/**
	 * @see dk.klafbang.tools.Pair#hashCode()
	 */
	@Override
	public int hashCode() {
		final int hash1 = super.hashCode();
		try {
			final int hash2 = third.hashCode();
			return hash1 + hash2;
		} catch (final Exception e) {
			return hash1;
		}
	}

	/**
	 * @param value
	 *            value to use for third component
	 */
	public void setThird(final U value) {
		third = value;
	}

	/**
	 * @see dk.klafbang.tools.Pair#toString()
	 */
	@Override
	public String toString() {
		return "(" + first + ", " + second + ", " + third + ')'; //$NON-NLS-1$//$NON-NLS-2$
	}
}
