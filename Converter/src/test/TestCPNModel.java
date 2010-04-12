package test;

import ee.ut.converter.CPNProcess;
import ee.ut.model.bpmn.BPMNProcess;

public class TestCPNModel {

	public static void main(String[] args) {

		CPNProcess p = new BPMNProcess();

		p.saveToCPN();
	}
}
