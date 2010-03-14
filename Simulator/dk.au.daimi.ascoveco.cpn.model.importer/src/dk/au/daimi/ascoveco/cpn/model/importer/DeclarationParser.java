package dk.au.daimi.ascoveco.cpn.model.importer;

import java.util.ArrayList;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import dk.au.daimi.ascoveco.cpn.model.Label;
import dk.au.daimi.ascoveco.cpn.model.declaration.DeclarationFactory;
import dk.au.daimi.ascoveco.cpn.model.declaration.GlobalReferenceDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.MLDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.TypeDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.UseDeclaration;
import dk.au.daimi.ascoveco.cpn.model.declaration.VariableDeclaration;
import dk.au.daimi.ascoveco.util.ParserUtil;

/**
 * @author mw
 */
public class DeclarationParser {

	/**
	 * 
	 */
	public static final String aliasNode = "alias";

	/**
	 * 
	 */
	public static final String andNode = "and";
	/**
	 * 
	 */
	public static final String blockNode = "block";
	/**
	 * 
	 */
	public static final String boolNode = "bool";
	/**
	 * 
	 */
	public static final String colorNode = "color";
	/**
	 * 
	 */
	public static final String declareNode = "declare";
	private static final DeclarationFactory declFactory = DeclarationFactory.eINSTANCE;
	/**
	 * 
	 */
	public static final String enumNode = "enum";
	/**
	 * 
	 */
	public static final String globrefNode = "globref";

	/**
	 * 
	 */
	public static final String idNode = "id";
	/**
	 * 
	 */
	public static final String indexNode = "index";
	/**
	 * 
	 */
	public static final String intNode = "int";
	/**
	 * 
	 */
	public static final String listNode = "list";
	/**
	 * 
	 */
	public static final String mlNode = "ml";
	/**
	 * 
	 */
	public static final String productNode = "product";
	/**
	 * 
	 */
	public static final String realNode = "real";
	/**
	 * 
	 */
	public static final String recordfieldNode = "recordfield";
	/**
	 * 
	 */
	public static final String recordNode = "record";
	/**
	 * 
	 */
	public static final String stringNode = "string";
	/**
	 * 
	 */
	public static final String subsetNode = "subset";
	/**
	 * 
	 */
	public static final String timedNode = "timed";
	/**
	 * 
	 */
	public static final String typeNode = "type";

	/**
	 * 
	 */
	public static final String unionNode = "union";
	/**
	 * 
	 */
	public static final String unitNode = "unit";
	/**
	 * 
	 */
	public static final String useNode = "use";
	/**
	 * 
	 */
	public static final String varNode = "var";

	/**
	 * 
	 */
	public static final String withNode = "with";

	/**
	 * @param n node
	 * @return color decl
	 * @throws NetDeclarationException if error occurred
	 */
	public static Label processColor(final Node n) throws NetDeclarationException {
		final TypeDeclaration color = DeclarationParser.declFactory.createTypeDeclaration();
		boolean timed = false;
		ArrayList<String> declares = new ArrayList<String>();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.idNode)) {
				color.setTypeName(ParserUtil.getTextFromElement(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.declareNode)) {
				declares = DeclarationParser.processDeclare(currentNode);
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.timedNode)) {
				timed = true;
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.unitNode)) {
				color.setType(CPNTypeParser.processUnit(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.boolNode)) {
				color.setType(CPNTypeParser.processBool(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.intNode)) {
				color.setType(CPNTypeParser.processInt(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.stringNode)) {
				color.setType(CPNTypeParser.processString(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.enumNode)) {
				color.setType(CPNTypeParser.processEnum(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.indexNode)) {
				color.setType(CPNTypeParser.processIndex(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.productNode)) {
				color.setType(CPNTypeParser.processProduct(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.recordNode)) {
				color.setType(CPNTypeParser.processRecord(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.listNode)) {
				color.setType(CPNTypeParser.processList(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.unionNode)) {
				color.setType(CPNTypeParser.processUnion(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.aliasNode)) {
				color.setType(CPNTypeParser.processAlias(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.subsetNode)) {
				color.setType(CPNTypeParser.processSubset(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.realNode)) { throw new NetDeclarationException(
			        "real is not supported", currentNode); }
		}

		for (final String declare : declares) {
			color.getType().addDeclare(declare);
		}
		if (color.getType() != null) {
			color.getType().setTimed(timed);
		}

		return DOMParser.getHLDeclaration(color, n);
	}

	/**
	 * @param n node
	 * @return declare part
	 */
	public static ArrayList<String> processDeclare(final Node n) {
		final ArrayList<String> declares = new ArrayList<String>();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.idNode)) {
				declares.add(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return declares;
	}

	/**
	 * @param n node
	 * @return list of decls
	 * @throws NetDeclarationException error occurred
	 */
	public static ArrayList<Label> processDecls(final Node n) throws NetDeclarationException {
		final ArrayList<Label> labels = new ArrayList<Label>();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.blockNode)) {
				labels.addAll(DeclarationParser.processDecls(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.colorNode)) {
				labels.add(DeclarationParser.processColor(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.varNode)) {
				labels.add(DeclarationParser.processVar(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.mlNode)) {
				labels.add(DeclarationParser.processML(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.globrefNode)) {
				labels.add(DeclarationParser.processGlobref(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.useNode)) {
				labels.add(DeclarationParser.processUse(currentNode));
			}
		}

		return labels;
	}

	/**
	 * @param n node
	 * @return globref decl
	 */
	public static Label processGlobref(final Node n) {
		final GlobalReferenceDeclaration globref = DeclarationParser.declFactory.createGlobalReferenceDeclaration();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.idNode)) {
				globref.setName(ParserUtil.getTextFromElement(currentNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.mlNode)) {
				globref.setValue(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return DOMParser.getHLDeclaration(globref, n);
	}

	/**
	 * @param n node
	 * @return ml decl
	 */
	public static Label processML(final Node n) {
		final MLDeclaration mld = DeclarationParser.declFactory.createMLDeclaration();
		mld.setCode(ParserUtil.getTextFromElement(n));
		return DOMParser.getHLDeclaration(mld, n);
	}

	/**
	 * @param n node
	 * @return use decl
	 */
	public static Label processUse(final Node n) {
		final UseDeclaration use = DeclarationParser.declFactory.createUseDeclaration();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.mlNode)) {
				use.setFileName(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return DOMParser.getHLDeclaration(use, n);
	}

	/**
	 * @param n node
	 * @return var decl
	 */
	public static Label processVar(final Node n) {
		final VariableDeclaration varDecl = DeclarationParser.declFactory.createVariableDeclaration();

		final NodeList nl = n.getChildNodes();
		for (int i = 0, cnt = nl.getLength(); i < cnt; i++) {
			final Node currentNode = nl.item(i);
			if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.typeNode)) {
				varDecl.setTypeName(ParserUtil.getTextFromChild(currentNode, DeclarationParser.idNode));
			} else if (ParserUtil.isElementNodeOfType(currentNode, DeclarationParser.idNode)) {
				varDecl.addVariable(ParserUtil.getTextFromElement(currentNode));
			}
		}

		return DOMParser.getHLDeclaration(varDecl, n);
	}
}
