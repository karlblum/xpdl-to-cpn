package ee.ut.converter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CPNProcess {

	private CPNet cpnet = new CPNet();
	protected HashMap<String, Element> elements = new HashMap<String, Element>();
	protected Map<Element, List<Element>> adjList = new HashMap<Element, List<Element>>();
	protected Set<Element> sinks = new HashSet<Element>();
	
	public void addEdge(Element v1, Element v2) {
		if (!adjList.containsKey(v1))
			adjList.put(v1, new LinkedList<Element>());
		adjList.get(v1).add(v2);
	}

	public void sinks() {
		for (Element i : elements.values()) {
			if (adjList.get(i).isEmpty()) {
				sinks.add(i);
			}
		}
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

	public HashMap<String, Element> getElelments() {
		return elements;
	}

	public void printAdjList() {
		System.out.println("===== ADJACENY LIST =====");
		for(Element e: adjList.keySet()){
			System.out.print(e.getId() + " --> ");
			for (Element e2: adjList.get(e)){
				System.out.print(e2.getId() + ",");
			}
			System.out.println();
		}
		
	}

}