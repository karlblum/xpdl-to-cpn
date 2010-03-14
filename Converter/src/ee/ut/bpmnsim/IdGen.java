package ee.ut.bpmnsim;

public class IdGen {
	private	static int current = 7000;
	
	public static String createId() { return "ID" + (current++);};
}
