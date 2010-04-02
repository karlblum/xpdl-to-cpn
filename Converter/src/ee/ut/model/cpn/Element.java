package ee.ut.model.cpn;

public abstract class Element {

	protected CPNet cpnet;
	protected String elementId;
	
	public Element(CPNet cpnet, String elementId){
		if(elementId == null) elementId = Util.createId();
		this.elementId = elementId;
		this.cpnet = cpnet;
	}
	
	public String getId() {
		return elementId;
	}
}
