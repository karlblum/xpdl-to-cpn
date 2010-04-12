package ee.ut.old.model.bpmne;

import org.apache.xmlbeans.XmlString;

import noNamespace.Arc;
import noNamespace.Cpnet;
import noNamespace.Instance;
import noNamespace.Page;
import noNamespace.Place;
import noNamespace.Port;

public class BPMNeSubprocess extends BPMNeProcess {
	private Place entryPlace;
	private Place exitPlace;

	public BPMNeSubprocess(Cpnet cpnet, Page page, Instance instance) {
		super();
		this.cpnet = cpnet;
		this.page = page;
		this.rootInst = instance;
		
		entryPlace = page.addNewPlace(); entryPlace.setId(BPMNeIdGen.createId());
		entryPlace.addNewType().addNewText().set(CASE_TYPE.copy());
		Port inPort = entryPlace.addNewPort();
		inPort.setType("In");
		
		exitPlace = page.addNewPlace();  exitPlace.setId(BPMNeIdGen.createId());
		exitPlace.addNewType().addNewText().set(CASE_TYPE.copy());
		Port outPort = exitPlace.addNewPort();
		outPort.setType("Out");
	}
	
	public void setEntry(String entryId) {
		BPMNeTask entry = (BPMNeTask)map.get(entryId);
		
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
		BPMNeTask exit = (BPMNeTask)map.get(exitId);
		
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
