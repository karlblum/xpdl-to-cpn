package ee.ut.model.cpn;

import java.util.ArrayList;
import java.util.List;

public abstract class Gateway extends Element{

	protected List<String> inputPlaceIds = new ArrayList<String>();
	protected List<String> outputPlaceIds = new ArrayList<String>();
	protected List<String> transitionIds = new ArrayList<String>();
	
	public Gateway(CPNet cpnet,String id,String name){
		super(cpnet,id, name);
	}
	
	public String getFirstInputPlace(){
		return inputPlaceIds.get(0);
	}
	
	public String getFirstOutputPlace(){
		return outputPlaceIds.get(0);
	}

	
}
