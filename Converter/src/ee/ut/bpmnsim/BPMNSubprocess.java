package ee.ut.bpmnsim;

import org.apache.xmlbeans.XmlString;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;

public class BPMNSubprocess extends BPMNProcess {
	private Place entryPlace;
	private Place exitPlace;

	public BPMNSubprocess(Cpnet cpnet, Page page, Instance instance, XmlString color, XmlString variable) {
		super();
		this.cpnet = cpnet;
		this.page = page;
		this.rootInst = instance;
		this.caseType = color;
		this.variable = variable;
		
		entryPlace = page.addNewPlace(); entryPlace.setId(BPMNIdGen.createId());
		entryPlace.addNewType().addNewText().set(caseType.copy());
		Port inPort = entryPlace.addNewPort();
		inPort.setType("In");
		
		exitPlace = page.addNewPlace();  exitPlace.setId(BPMNIdGen.createId());
		exitPlace.addNewType().addNewText().set(caseType.copy());
		Port outPort = exitPlace.addNewPort();
		outPort.setType("Out");
	}
	
	public void setEntry(String entryId) {
		BPMNTask entry = (BPMNTask)map.get(entryId);
		
		// -- entry transition
		String psock = transitions.get(entryId).getSubst().getPortsock();
		psock = psock == null ? "" : psock;
		psock += String.format("(%s,%s)", entry.getEntryPlace().getId(), entryPlace.getId());
		transitions.get(entryId).getSubst().setPortsock(psock);
		
		Arc a1 = page.addNewArc();
		a1.setOrientation("PtoT");
		a1.addNewPlaceend().setIdref(entryPlace.getId());
		a1.addNewTransend().setIdref(transitions.get(entryId).getId());

	}

	public void setExit(String exitId) {
		BPMNTask exit = (BPMNTask)map.get(exitId);
		
		// -- entry transition
		String psock = transitions.get(exitId).getSubst().getPortsock();
		psock = psock == null ? "" : psock;
		psock += String.format("(%s,%s)", exit.getExitPlace().getId(), exitPlace.getId());
		transitions.get(exitId).getSubst().setPortsock(psock);

		Arc a1 = page.addNewArc();
		a1.setOrientation("TtoP");
		a1.addNewTransend().setIdref(transitions.get(exitId).getId());
		a1.addNewPlaceend().setIdref(exitPlace.getId());
	}
	
	public Place getEntryPlace() {
		return entryPlace;
	}
	
	public Place getExitPlace() {
		return exitPlace;
	}
}
