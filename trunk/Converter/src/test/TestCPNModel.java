package test;

import java.io.File;

import ee.ut.converter.factory.BPMNRelayFactory;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.XPDL2ElementParser;

public class TestCPNModel {

	public static void main(String[] args) throws Exception {

		// XPDL process model file
		File xpdlFile = new File("./files/models/dfs.xpdl");

		// Simulation data to the corresponding XPDL simulation model
		File simDataFile = new File("./files/models/Empty simulation data.xml");

		// CPNProcess p = new BPMNProcess(xpdlFile, simDataFile);

		// OUTPUT FILE
		// p.saveToCPN("./files/cpn/test4.cpn");

		Parser p = new Parser();
		p.setElementFactory(new BPMNRelayFactory());
		p.setElementParser(new XPDL2ElementParser(xpdlFile));
		p.setSimDataParser(new KBSimDataParser(simDataFile));
		p.parse();
		p.printAdjList();
		p.save();
	}

}
