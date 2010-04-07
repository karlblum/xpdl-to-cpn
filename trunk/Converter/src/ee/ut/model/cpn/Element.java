package ee.ut.model.cpn;

public abstract class Element {

	protected CPNet cpnet;
	private String elementId;
	private String elementName;
	
	public Element(CPNet cpnet, String elementId,  String elementName){
		if(elementId == null) elementId = Util.createId();
		this.elementId = elementId;
		this.cpnet = cpnet;
		this.elementName = elementName;
	}
	
	public String getId() {
		return elementId;
	}
}
