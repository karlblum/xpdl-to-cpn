package ee.ut.bpmnsim;

public class BPMNIdGen {
	private	static int current = 7000;
	
	public static String createId() { return "ID" + (current++);};
}
