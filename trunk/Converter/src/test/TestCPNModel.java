package test;

import ee.ut.model.cpn2.BPMNProcess;
import ee.ut.model.cpn2.Process;



public class TestCPNModel {

	public static void main(String[] args) {
		
		Process p = new BPMNProcess();
		
		p.saveToCPN();
	}
}
