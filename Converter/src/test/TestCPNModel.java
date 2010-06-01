package test;

import java.io.File;

import ee.ut.converter.factory.BPMNRelayFactory;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.XPDL2ElementParser;

public class TestCPNModel {

	private static final String MODEL_PATH = "files/models/";
	private static final String CPN_PATH = "files/cpn/";

	public static void main(String[] args) throws Exception {

		 test("case_study");
		 //testAll();
	}

	private static void testAll() throws Exception {
		test("EBXOR");
		test("Bound Timer");
		test("Gateway Join");
		test("Gateway INC");
		test("Gateway EX");
		test("Task split");
		test("Task");
		test("Subprocess exception");
	}

	private static void test(String f) throws Exception {
		File xpdlFile = new File(MODEL_PATH + f + ".xpdl");
		File simDataFile = new File(MODEL_PATH + f + ".xml");
		if (!simDataFile.exists()) {
			simDataFile = new File(MODEL_PATH + "Empty simulation data.xml");
		}

		Parser p = new Parser();
		p.setElementFactory(new BPMNRelayFactory(p));
		p.setElementParser(new XPDL2ElementParser(xpdlFile));
		p.setSimDataParser(new KBSimDataParser(simDataFile));
		p.parse();
		p.save(CPN_PATH + f + ".cpn", true);
	}

}
