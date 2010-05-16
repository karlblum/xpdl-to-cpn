package ee.ut.converter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import ee.ut.model.bpmn.BPMNEndEvent;
import ee.ut.model.bpmn.BPMNSubprocessStart;

public class BProcess {

	private CPNet cpnet;
	protected HashMap<String, Element> elements = new HashMap<String, Element>();
	protected Map<Element, List<Element>> adjList = new HashMap<Element, List<Element>>();
	protected ArrayList<Element> sinks = new ArrayList<Element>();
	protected Element source;
	private String id;

	protected HashMap<String, BProcess> subprocesses = new HashMap<String, BProcess>();

	public BProcess(CPNet c, String s) {
		if (c == null)
			c = new CPNet();
		cpnet = c;
		id = s;
	}

	public void addEdge(Element v1, Element v2) {
		if (!adjList.containsKey(v1))
			adjList.put(v1, new LinkedList<Element>());
		if (!adjList.containsKey(v2))
			adjList.put(v2, new LinkedList<Element>());
		adjList.get(v1).add(v2);
	}

	public void findSinks() {
		for (Element i : adjList.keySet()) {
			if (adjList.get(i).isEmpty()) {
				sinks.add(i);
			}
		}
	}

	public void findSource() {
		List<Element> potentialSources = new ArrayList<Element>();
		List<Element> targets = new ArrayList<Element>();

		potentialSources.addAll(elements.values());

		for (Element i : elements.values()) {
			if (!adjList.get(i).isEmpty()) {
				targets.addAll(adjList.get(i));
			}
		}
		potentialSources.removeAll(targets);
		source = potentialSources.get(0);
	}
	
	public ArrayList<Element> getLastBeforeSink(){
		ArrayList<Element> elements = new ArrayList<Element>();
		for(Element e: adjList.keySet()){
			for(Element s: sinks){
				if(adjList.get(e).contains(s)){
					elements.add(e);
				}
			}
		}
		return elements;
	}

	public BProcess createSubprocess(String id) {
		BProcess p = new BProcess(cpnet, id);
		subprocesses.put(id, p);
		return p;
	}

	public BProcess getSubprocess(String id) {
		return subprocesses.get(id);
	}

	public void saveToCPN(String location) {
		cpnet.saveToFile(location);
	}

	public CPNet getCpnet() {
		return cpnet;
	}

	public Element getElement(String key) {
		return elements.get(key);
	}

	public void addElement(String key, Element value) {
		this.elements.put(key, value);
	}

	public HashMap<String, Element> getElements() {
		return elements;
	}

	public void printAdjList() {
		System.out.println("\n===== CONVERTED ELEMENTS ADJACENY LIST =====");
		System.out.println("===== SIZE: " + adjList.size() + " =====");
		for (Element e : adjList.keySet()) {
			System.out.print(e.getId() + " (" + e.getName() + ") " + "--> ");
			for (Element e2 : adjList.get(e)) {
				System.out.print(e2.getId() + " (" + e2.getName() + ")" + ",");
			}
			System.out.println();
		}

	}

	public String getId() {
		return id;
	}

	public HashMap<String, BProcess> getSubprocesses() {
		return subprocesses;
	}

	public void setSubprocesses(HashMap<String, BProcess> subprocesses) {
		this.subprocesses = subprocesses;
	}

	public Element getDefaultSink() {
		for(Element e: sinks){
			if(e instanceof BPMNEndEvent)
				return e;
		}
		return null;
	}
	
	public ArrayList<Element> getSinks(){
		return sinks;
	}

	public Element getSource() {
		return source;
	}

}