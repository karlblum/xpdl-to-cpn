package test;

import ee.ut.model.cpn.Activity;
import ee.ut.model.cpn.BPMNElementFactory;
import ee.ut.model.cpn.AbstractElementFactory;
import ee.ut.model.cpn.Gateway;
import ee.ut.model.cpn.Process;

public class TestCPNModel {

	public static void main(String[] args) {
		AbstractElementFactory factory = new BPMNElementFactory();
		Process process = new Process(factory);
		
		Activity activity = process.addActivity("a1", "activity1");
		Activity activity2 = process.addActivity("a2", "activity2");
		
		process.addTransition(null, activity.getId(), activity2.getId());
		
		Gateway gateway1 = process.addGateway("gw1", "gateway1");
		
		process.addTransition(null, activity2.getId(), gateway1.getId());
		
		Activity activity3 = process.addActivity("a3", "activity1");
		Activity activity4 = process.addActivity("a4", "activity2");
		
		process.addTransition(null, gateway1.getId(), activity3.getId());
		process.addTransition(null, gateway1.getId(), activity4.getId());
		
		process.saveToCPN();
	}
}
