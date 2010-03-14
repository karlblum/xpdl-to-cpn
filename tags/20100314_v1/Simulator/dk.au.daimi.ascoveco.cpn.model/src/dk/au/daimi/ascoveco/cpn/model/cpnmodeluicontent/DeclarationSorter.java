package dk.au.daimi.ascoveco.cpn.model.cpnmodeluicontent;

import org.eclipse.jface.viewers.TreePath;
import org.eclipse.jface.viewers.TreePathViewerSorter;
import org.eclipse.jface.viewers.Viewer;

import dk.au.daimi.ascoveco.util.SimpleTree;

/**
 * @author mw
 */
public class DeclarationSorter extends TreePathViewerSorter {

	/**
	 * 
	 */
	public static final String DECLARATION_HEADER = "Declarations"; //$NON-NLS-1$

	/**
	 * Compairs <code>e1</code> and <code>e2</code> just like <code>CommonViewerSorter</code> does it except that if
	 * both <code>e1</code> and <code>e2</code> are <code>SimpleTree</code>s and one of them is the declaration header
	 * it is return that it is the smalles of the two.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int compare(final Viewer viewer, final TreePath parentPath, final Object e1, final Object e2) {
		if (e1 instanceof SimpleTree && e2 instanceof SimpleTree) {
			final SimpleTree<Object> t1 = (SimpleTree<Object>) e1;
			final SimpleTree<Object> t2 = (SimpleTree<Object>) e2;
			if (t1.getText().equals(DeclarationSorter.DECLARATION_HEADER)) {
				return -1;
			} else if (t2.getText().equals(DeclarationSorter.DECLARATION_HEADER)) { return 1; }
		}

		return compare(viewer, parentPath, e1, e2);
	}

}