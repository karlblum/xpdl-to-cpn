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

		Parser p = new Parser();
		p.setElementFactory(new BPMNRelayFactory(p));
		p.setElementParser(new XPDL2ElementParser(xpdlFile));
		p.setSimDataParser(new KBSimDataParser(simDataFile));
		p.parse();
		p.save("files/cpn/newArchitecture.cpn");
	}

}
