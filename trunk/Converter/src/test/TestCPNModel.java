package test;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import ee.ut.converter.factory.BPMNRelayFactory;
import ee.ut.converter.parser.KBSimDataParser;
import ee.ut.converter.parser.Parser;
import ee.ut.converter.parser.XPDL2ElementParser;

public class TestCPNModel {

	public static void main(String[] args) throws Exception {
		
		if(args.length < 3){
			System.out.println("cpnConverter.jar [xpdl file] [output cpn file] [simulation data]");
			return;
		}
		
		boolean doLayout = false;

		
		Properties configFile = new Properties();
		configFile.load(new FileInputStream("configuration.conf"));
		
		String template = configFile.getProperty("TEMPLATE_PATH");
		String layouter = configFile.getProperty("LAYOUTER");
		String useLayouter = configFile.getProperty("USE_LAYOUTER");
		if(useLayouter.equals("TRUE")) doLayout = true;
		
		File xpdlFile = new File(args[0]);
		File simDataFile = new File(args[2]);
		
		Parser p = new Parser(template);
		p.setElementFactory(new BPMNRelayFactory(p));
		p.setElementParser(new XPDL2ElementParser(xpdlFile));
		p.setSimDataParser(new KBSimDataParser(simDataFile));
		p.parse();
		
		p.save(args[1], doLayout,layouter);
	}
}
