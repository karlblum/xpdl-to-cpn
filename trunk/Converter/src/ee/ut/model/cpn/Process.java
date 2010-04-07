package ee.ut.model.cpn;

import java.util.HashMap;

public class Process {
	
	private CPNet cpnet;
	private HashMap<String,Activity> activities = new HashMap<String, Activity>();
	private HashMap<String,Transition> transitions = new HashMap<String, Transition>();
	private HashMap<String,Gateway> gateways = new HashMap<String,Gateway>();
	private BPMNFactory elementFactory;
	
	
	public Process(){
		this.cpnet = new CPNet();
		this.elementFactory = new BPMNFactory();
		elementFactory.registerActivityFactory(new BPMNActivityFactory());
		elementFactory.registerTransitionFactory(new BPMNTransitionFactory());
		
		BPMNActivity a = (BPMNActivity) elementFactory.create(new ee.ut.model.xpdl2.Activity(), cpnet, "Activity1");
		
		
	}
	
	public void saveToCPN(){
		cpnet.saveToFile("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNModel.cpn");
	}
	
}
