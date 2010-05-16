package test;

import java.io.File;

import ee.ut.converter.factory.BPMNRelayFactory;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.XPDL2ElementParser;

public class TestCPNModel {

	public static void main(String[] args) throws Exception {

		test("Subprocess exception");
		// testAll();
	}

	private static void testAll() throws Exception {
		test("EBXOR");
		test("Bound Timer");
		test("Gateway Join");
		test("Gateway INC");
		test("Gateway EX");
		test("Task split");
		test("Task");
	}

	private static void test(String f) throws Exception {
		File xpdlFile = new File("./files/models/Tests/" + f + ".xpdl");
		File simDataFile = new File("./files/models/Empty simulation data.xml");

		Parser p = new Parser();
		p.setElementFactory(new BPMNRelayFactory(p));
		p.setElementParser(new XPDL2ElementParser(xpdlFile));
		p.setSimDataParser(new KBSimDataParser(simDataFile));
		p.parse();
		p.save("files/cpn/Tests/" + f + ".cpn");
	}

}
