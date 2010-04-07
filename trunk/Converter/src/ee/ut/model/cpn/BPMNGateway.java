package ee.ut.model.cpn;


import noNamespace.Trans;

public class BPMNGateway extends Gateway{
	
	BPMNGatewayType inputType;
	BPMNGatewayType outputType;

	public BPMNGateway(CPNet cpnet, String id, String name,BPMNGatewayType inputType, BPMNGatewayType outputType, int inputs, int outputs) {
		super(cpnet, id, name);
		this.inputType = inputType;
		this.outputType = outputType;
		
		
		//create input places
		for (int i=0;i<inputs;i++) {
			inputPlaceIds.add(cpnet.addPlace().getId());
		}
		
		
		//create output places
		for (int i=0;i<outputs;i++) {
			outputPlaceIds.add(cpnet.addPlace().getId());
		}
		initGateway();
	}
	
	private void initGateway(){
		//TODO: teha gateway sisend ja väljundtüübist sõltuvaks. Hetkel xor join ja and split
		Trans t = cpnet.addTrans();
		transitionIds.add(t.getId()); 
		
		for (String input : inputPlaceIds) {
			cpnet.addArc(input, t.getId());
		}
		
		for (String output : outputPlaceIds) {
			cpnet.addArc(t.getId(), output);
		}
	}

}
