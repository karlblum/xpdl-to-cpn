package ee.ut.old.model.bpmne;

public class BPMNeIdGen {
	private	static int current = 7000;
	
	public static String createId() { return "ID" + (current++);};
}
