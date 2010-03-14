package ee.ut.bpmnsim;

import noNamespace.Annot;
import noNamespace.Arc;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;
import noNamespace.Trans;

import org.apache.xmlbeans.XmlObject;
import org.apache.xmlbeans.XmlString;



public class StartEvent {
	private String name;
	private Page page;
	private XmlObject color;
	private XmlObject variable;
	private String counterVar;
	private Trans transition;
	protected Place outputPlace;
	private Place nextCasePlace;

	public StartEvent(Page page, String name, XmlObject color, XmlObject variable, XmlObject counterType, String counterVar) {
		this.page = page;
		this.name = name;
		this.color = color;
		this.variable = variable;
		this.counterVar = counterVar;
		
		transition = Util.createTrans(page, name);

		outputPlace = Util.createPlace(page, name + "_new_case");
		outputPlace.getTypeArray()[0].getText().set(color.copy());		
		outputPlace.addNewPort().setType("Out");

		Util.createArc(page, transition, outputPlace, XmlString.Factory.newValue("initCaseInfo("+counterVar+")"));
		
		// --- case generation
		nextCasePlace = Util.createPlace(page, "nextCase");
		nextCasePlace.getTypeArray()[0].getText().set(counterType.copy());
		nextCasePlace.getInitmarkArray(0).getText().set(XmlString.Factory.newValue("1"));
		Util.createArc(page, nextCasePlace, transition, XmlString.Factory.newValue(counterVar));
		Util.createArc(page, transition, nextCasePlace, XmlString.Factory.newValue(counterVar + " + 1"));
	}
	
	public Place getExitPlace() {
		return outputPlace;
	}
	
	public void setNumberOfCases(XmlString number) {
		transition.getCondArray(0).getText().set(number);
	}
	
	public void setTimeExpresion(XmlString expr) {
		transition.getTimeArray(0).getText().set(expr);
	}

}
