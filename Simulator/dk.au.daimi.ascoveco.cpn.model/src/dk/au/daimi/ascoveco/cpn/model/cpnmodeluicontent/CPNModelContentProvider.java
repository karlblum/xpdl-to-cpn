package dk.au.daimi.ascoveco.cpn.model.cpnmodeluicontent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dk.au.daimi.ascoveco.cpn.model.HLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.Instance;
import dk.au.daimi.ascoveco.cpn.model.Page;
import dk.au.daimi.ascoveco.cpn.model.PetriNet;
import dk.au.daimi.ascoveco.util.SimpleTree;

/**
 * @author mw
 */
public class CPNModelContentProvider implements ITreeContentProvider {

	/**
	 * 
	 */
	public static final String DECLARATION_HEADER = "Declarations";
	private static final Object[] NO_CHILDREN = new Object[0];
	private Map<IFile, SimpleTree<Object>> fileToTreeMap;

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#dispose()
	 */
	public void dispose() {
		fileToTreeMap.clear();
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Object[] getChildren(final Object parentElement) {
		if (parentElement instanceof IFile) {
			final IFile file = (IFile) parentElement;
			if (fileToTreeMap == null || fileToTreeMap.get(file) == null) {
				updateModel(file);
			}
			return fileToTreeMap.get(file).getChildren();
		} else if (parentElement instanceof SimpleTree) {
			final SimpleTree<Object> simpleTree = (SimpleTree<Object>) parentElement;
			return simpleTree.getChildren();
		} else {
			return CPNModelContentProvider.NO_CHILDREN;
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IStructuredContentProvider#getElements(java.lang.Object)
	 */
	public Object[] getElements(final Object inputElement) {
		return getChildren(inputElement);
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#getParent(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public Object getParent(final Object element) {
		if (element instanceof IFile) {
			return null;
		} else if (element instanceof SimpleTree) {
			final SimpleTree<Object> treeData = (SimpleTree<Object>) element;
			return treeData.getParent();
		} else {
			return null;
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.ITreeContentProvider#hasChildren(java.lang.Object)
	 */
	@SuppressWarnings("unchecked")
	public boolean hasChildren(final Object element) {
		if (element instanceof IFile) {
			final IFile file = (IFile) element;
			if (fileToTreeMap == null || fileToTreeMap.get(file) == null) {
				updateModel(file);
			}
			return fileToTreeMap.get(file).hasChildren();
		} else if (element instanceof SimpleTree) {
			final SimpleTree<Object> treeData = (SimpleTree<Object>) element;
			return treeData.hasChildren();
		} else {
			return false;
		}
	}

	/**
	 * @see org.eclipse.jface.viewers.IContentProvider#inputChanged(org.eclipse.jface.viewers.Viewer, java.lang.Object,
	 *      java.lang.Object)
	 */
	public void inputChanged(final Viewer viewer, final Object oldInput, final Object newInput) {
		// Do nothing since the model do not change
	}

	private void buildTree(final SimpleTree<Object> parent, final Map<String, Page> idToPageMap, final String pageId) {
		final Page page = idToPageMap.get(pageId);
		final SimpleTree<Object> node = new SimpleTree<Object>(parent, page.getName().getText(), page);
		for (final Instance instance : page.instance()) {
			buildTree(node, idToPageMap, instance.getSubPageID());
		}
	}

	private void updateModel(final IFile file) {
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Factory.INSTANCE.createEditingDomain();
		final ResourceSet resourceSet = domain.getResourceSet();
		EObject diagramRoot = null;
		try {
			final URI domainModelURI = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
			final Resource resource = resourceSet.getResource(domainModelURI, true);
			diagramRoot = resource.getContents().get(0);
		} catch (final Exception ex) {
			ex.printStackTrace();
		}

		PetriNet petriNet = null;
		if (diagramRoot == null || !(diagramRoot instanceof PetriNet)) {
			throw new NotAPetriNetException("The diagram root is not a Petri net", diagramRoot);
		} else {
			petriNet = (PetriNet) diagramRoot;
		}

		if (fileToTreeMap == null) {
			fileToTreeMap = new HashMap<IFile, SimpleTree<Object>>();
		}
		final HashSet<String> primePages = new HashSet<String>();
		final HashSet<String> notPrimePages = new HashSet<String>();
		final Map<String, Page> idToPageMap = new HashMap<String, Page>();

		for (final Page page : petriNet.getPage()) {
			idToPageMap.put(page.getId(), page);
			for (final Instance instance : page.instance()) {
				notPrimePages.add(instance.getSubPageID());
			}
			primePages.add(page.getId());
		}
		primePages.removeAll(notPrimePages);

		final SimpleTree<Object> root = new SimpleTree<Object>("Root");
		final SimpleTree<Object> declarations = new SimpleTree<Object>(root, CPNModelContentProvider.DECLARATION_HEADER);
		for (final HLDeclaration decl : petriNet.declaration()) {
			String declText = decl.getStructure().asShortString().replace('\n', ' ');
			declText = declText.replace('\r', ' ');
			final int maxLength = 30;
			if (declText.length() > maxLength) {
				declText = declText.substring(0, maxLength) + "...";
			}

			new SimpleTree<Object>(declarations, declText, decl);
		}

		for (final String pageId : primePages) {
			buildTree(root, idToPageMap, pageId);
		}

		fileToTreeMap.put(file, root);
	}

}
