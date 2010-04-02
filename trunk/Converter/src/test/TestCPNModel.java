package test;

import ee.ut.model.cpn.Activity;
import ee.ut.model.cpn.BPMNElementFactory;
import ee.ut.model.cpn.AbstractElementFactory;
import ee.ut.model.cpn.Process;

public class TestCPNModel {

	public static void main(String[] args) {
		AbstractElementFactory factory = new BPMNElementFactory();
		Process process = new Process(factory);
		
		Activity activity = process.addActivity("1", "activity1");
		Activity activity2 = process.addActivity("2", "activity2");
		Activity activity3 = process.addActivity("3", "activity3");
		
		process.addTransition(null, activity.getId(), activity2.getId());
		process.addTransition(null, activity2.getId(), activity3.getId());
		process.saveToCPN();
	}
}
