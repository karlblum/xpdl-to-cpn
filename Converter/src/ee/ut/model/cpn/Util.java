package ee.ut.model.cpn;

public class Util {
	private static int currentId = 1;

	public static  String createId() {
		return "ELEMENT_" + (currentId++);
	};
}
