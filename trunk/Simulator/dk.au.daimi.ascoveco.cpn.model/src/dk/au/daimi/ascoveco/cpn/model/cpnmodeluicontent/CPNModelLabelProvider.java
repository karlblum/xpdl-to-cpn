package dk.au.daimi.ascoveco.cpn.model.cpnmodeluicontent;

import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.navigator.IDescriptionProvider;

import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.util.SimpleTree;

/**
 * @author mw
 */
public class CPNModelLabelProvider extends LabelProvider implements IDescriptionProvider {

	/**
	 * @see org.eclipse.ui.navigator.IDescriptionProvider#getDescription(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public String getDescription(final Object anElement) {
		if (anElement instanceof SimpleTree) {
			final SimpleTree<Object> treeData = (SimpleTree<Object>) anElement;
			if (treeData.getObject() instanceof Page) {
				return "Page: " + treeData.getText();
			} else if (treeData.getObject() instanceof HLDeclaration) {
				return "Declaration: " + treeData.getText();
			} else if (treeData.getText().equals(CPNModelContentProvider.DECLARATION_HEADER)) {
				return CPNModelContentProvider.DECLARATION_HEADER;
			} else {
				return null;
			}
		}

		return null;
	}

	/**
	 * @see org.eclipse.jface.viewers.LabelProvider#getImage(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Image getImage(final Object element) {
		if (element instanceof SimpleTree) {
			final SimpleTree<Object> treeData = (SimpleTree<Object>) element;
			if (treeData.getObject() instanceof Page) {
				// TODO: return a page icon
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_FILE);
			} else if (treeData.getObject() instanceof HLDeclaration) {
				// TODO: return a decl icon
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
			} else if (treeData.getText().equals(CPNModelContentProvider.DECLARATION_HEADER)) {
				return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.LabelProvider#getText(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public String getText(final Object element) {
		if (element instanceof SimpleTree) {
			final SimpleTree<Object> treeData = (SimpleTree<Object>) element;
			return treeData.getText();
		} else {
			return null;
		}
	}

}
