package ee.ut.model.bpmne;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import noNamespace.Arc;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;

public class BPMNeXORGateway implements BPMNeGateway {
	private String name;
	private Page page;
	private GWType type;
	private XmlObject color;
	private XmlObject variable;
	private Map<String, Trans> exitTrans = new HashMap<String, Trans>();
	private List<Arc> splitArcs = new LinkedList<Arc>();
	private Arc entryArc;
	private Trans transition;
	protected Place splittingPlace;
	private Place joiningPlace;
	
	public BPMNeXORGateway(Page page, String name, GWType type, XmlObject color, XmlObject variable) {
		this.page = page;
		this.name = name;
		this.type = type;
		this.color = color;
		this.variable = variable;
		
		transition = BPMNeUtil.createTrans(page, name);
		
		if (type == GWType.SPLIT || type == GWType.MIXED) {
			splittingPlace = BPMNeUtil.createPlace(page, name + "_split");
			splittingPlace.getTypeArray(0).getText().set(color.copy());		

			Arc a1 = BPMNeUtil.createArc(page, transition, splittingPlace, (XmlString)variable.copy());
			splitArcs.add(a1);
		}
		
		if (type == GWType.JOIN || type == GWType.MIXED) {
			joiningPlace = BPMNeUtil.createPlace(page, name + "_join");
			joiningPlace.getTypeArray(0).getText().set(color.copy());
			
			Arc a1 = BPMNeUtil.createArc(page, joiningPlace, transition, (XmlString)variable.copy());
			entryArc = a1;
		}
	}

	public Place addEntryPlace(String from) {
		Trans trans;
		
		if (type == GWType.SPLIT) {
			trans = transition;
		} else {
			trans = BPMNeUtil.createTrans(page, name + "\npath_from_" + from);
			BPMNeUtil.createArc(page, trans, joiningPlace, (XmlString)variable.copy());
		}
		
		Place entryPlace = BPMNeUtil.createPlace(page, name + "_" + from);
		entryPlace.getTypeArray(0).getText().set(color.copy());		
		Port inPort = entryPlace.addNewPort();
		inPort.setType("In");

		Arc arc = BPMNeUtil.createArc(page, entryPlace, trans, (XmlString)variable.copy());
		entryArc = arc;   // TODO: Verify this point
		
		return entryPlace;
	}

	public Place addExitPlace(String to) {
		Trans trans;
		
		if (type == GWType.JOIN) {
			trans = transition;
		} else {
			trans = BPMNeUtil.createTrans(page, name + "\npath_to_" + to);
			Arc a1 = BPMNeUtil.createArc(page, splittingPlace, trans, (XmlString)variable.copy());
			splitArcs.add(a1);
		}
		
		Place exitPlace = BPMNeUtil.createPlace(page, name + "_" + to);
		exitPlace.getTypeArray(0).getText().set(color.copy());
		Port outPort = exitPlace.addNewPort();
		outPort.setType("Out");
		
		BPMNeUtil.createArc(page, trans, exitPlace, (XmlString)variable.copy());
		
		exitTrans.put(to, trans);
		return exitPlace;
	}
	
	public void setTransitionProbabilities(Object[] probs) {
		int current = 0;
		int path = 0, num = probs.length/2;
		String expression = "";
		
		for (int i = 0; i < probs.length; i += 2) {
			String to = (String)probs[i];
			int prob = (Integer)probs[i+1];
			
			if (path > 0)
				expression += "else ";
			
			if (path < (num - 1))
				expression += String.format("if prob < %d then (caseInfop, %d)\n", current + prob, path);
			else
				expression += String.format("(caseInfop, %d)\nend", path);
			
			Trans trans = exitTrans.get(to);
			trans.getCondArray(0).getText().set(XmlString.Factory.newValue(String.format("[path=%d]", path)));
			
			path++; current += prob;
		}
		
		expression = "input(caseInfop)\noutput(caseInfo,path)\naction\nlet val prob = discrete(1,100) in\n" + expression;
		
		for (Arc a : splitArcs)
			a.getAnnot().getText().set(XmlString.Factory.newValue("(caseInfo, path)"));
		
		transition.getCodeArray(0).getText().set(XmlString.Factory.newValue(expression));
		splittingPlace.getTypeArray(0).getText().set(XmlString.Factory.newValue("CASExPATH"));
		entryArc.getAnnot().getText().set(XmlString.Factory.newValue("caseInfop"));
	}
}
