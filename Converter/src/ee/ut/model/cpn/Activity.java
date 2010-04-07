package ee.ut.model.cpn;

import java.util.ArrayList;
import java.util.List;

public abstract class Activity extends Element{

	protected List<String> inputPlaceIds = new ArrayList<String>();
	protected List<String> outputPlaceIds = new ArrayList<String>();
	protected List<String> transitionIds = new ArrayList<String>();
	
	public Activity(CPNet cpnet,String id,String name){
		super(cpnet,id, name);
	}
	
	public String getFirstInputPlace(){
		return inputPlaceIds.get(0);
	}
	
	public String getFirstOutputPlace(){
		return outputPlaceIds.get(0);
	}

	
}
