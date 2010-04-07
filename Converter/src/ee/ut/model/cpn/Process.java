package ee.ut.model.cpn;

import java.util.HashMap;

public class Process {
	
	private CPNet cpnet;
	private HashMap<String,Activity> activities = new HashMap<String, Activity>();
	private HashMap<String,Transition> transitions = new HashMap<String, Transition>();
	private HashMap<String,Gateway> gateways = new HashMap<String,Gateway>();
	private AbstractElementFactory elementFactory;
	
	
	public Process(AbstractElementFactory elementfactory){
		this.cpnet = new CPNet();
		this.elementFactory = elementfactory;
	}
	
	public void saveToCPN(){
		cpnet.saveToFile("C:/Karl/Thesis/Source/Converter/files/cpn/TestCPNModel.cpn");
	}

	public Activity addActivity(String id, String name) {
		Activity activity = elementFactory.makeActivity(cpnet,id,name);
		activities.put(activity.getId(), activity);
		return activity;
	}
	
	public Transition addTransition(String id, String sourceId,String targetId){
		Transition transition = elementFactory.makeTransition(cpnet,id,activities.get(sourceId).getFirstOutputPlace(),activities.get(targetId).getFirstInputPlace());
		transitions.put(transition.getId(), transition);
		return transition;
	}
	
	public Gateway addGateway(String id, String name){
		Gateway gateway = elementFactory.makeGateway(cpnet,id,name);
		gateways.put(id, gateway);
		return gateway;
	}
	
}
