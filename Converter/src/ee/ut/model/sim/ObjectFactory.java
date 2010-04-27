//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.04.22 at 03:03:07 PM EEST 
//

package ee.ut.model.sim;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java
 * element interface generated in the ee.ut.model.sim package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the
 * Java representation for XML content. The Java representation of XML content
 * can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory
 * methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName _Gateways_QNAME = new QName("", "Gateways");
	private final static QName _GateRefs_QNAME = new QName("", "GateRefs");
	private final static QName _Task_QNAME = new QName("", "Task");
	private final static QName _Gateway_QNAME = new QName("", "Gateway");
	private final static QName _Tasks_QNAME = new QName("", "Tasks");
	private final static QName _SimulationData_QNAME = new QName("",
			"SimulationData");
	private final static QName _GateRef_QNAME = new QName("", "GateRef");
	private final static QName _SimulationProfile_QNAME = new QName("",
			"SimulationProfile");
	private final static QName _Resources_QNAME = new QName("", "Resources");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of
	 * schema derived classes for package: ee.ut.model.sim
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link GateRefs }
	 * 
	 */
	public GateRefs createGateRefs() {
		return new GateRefs();
	}

	/**
	 * Create an instance of {@link Gateways }
	 * 
	 */
	public Gateways createGateways() {
		return new Gateways();
	}

	/**
	 * Create an instance of {@link Task }
	 * 
	 */
	public Task createTask() {
		return new Task();
	}

	/**
	 * Create an instance of {@link SimulationProfile }
	 * 
	 */
	public SimulationProfile createSimulationProfile() {
		return new SimulationProfile();
	}

	/**
	 * Create an instance of {@link GateRef }
	 * 
	 */
	public GateRef createGateRef() {
		return new GateRef();
	}

	/**
	 * Create an instance of {@link SimulationData }
	 * 
	 */
	public SimulationData createSimulationData() {
		return new SimulationData();
	}

	/**
	 * Create an instance of {@link Resources }
	 * 
	 */
	public Resources createResources() {
		return new Resources();
	}

	/**
	 * Create an instance of {@link Resource }
	 * 
	 */
	public Resource createResource() {
		return new Resource();
	}

	/**
	 * Create an instance of {@link Gateway }
	 * 
	 */
	public Gateway createGateway() {
		return new Gateway();
	}

	/**
	 * Create an instance of {@link Tasks }
	 * 
	 */
	public Tasks createTasks() {
		return new Tasks();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Gateways }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "Gateways")
	public JAXBElement<Gateways> createGateways(Gateways value) {
		return new JAXBElement<Gateways>(_Gateways_QNAME, Gateways.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GateRefs }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "GateRefs")
	public JAXBElement<GateRefs> createGateRefs(GateRefs value) {
		return new JAXBElement<GateRefs>(_GateRefs_QNAME, GateRefs.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Task }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "Task")
	public JAXBElement<Task> createTask(Task value) {
		return new JAXBElement<Task>(_Task_QNAME, Task.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Gateway }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "Gateway")
	public JAXBElement<Gateway> createGateway(Gateway value) {
		return new JAXBElement<Gateway>(_Gateway_QNAME, Gateway.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Tasks }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "Tasks")
	public JAXBElement<Tasks> createTasks(Tasks value) {
		return new JAXBElement<Tasks>(_Tasks_QNAME, Tasks.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link SimulationData }
	 * {@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "SimulationData")
	public JAXBElement<SimulationData> createSimulationData(SimulationData value) {
		return new JAXBElement<SimulationData>(_SimulationData_QNAME,
				SimulationData.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link GateRef }{@code
	 * >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "GateRef")
	public JAXBElement<GateRef> createGateRef(GateRef value) {
		return new JAXBElement<GateRef>(_GateRef_QNAME, GateRef.class, null,
				value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "SimulationProfile")
	public JAXBElement<Object> createSimulationProfile(Object value) {
		return new JAXBElement<Object>(_SimulationProfile_QNAME, Object.class,
				null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "", name = "Resources")
	public JAXBElement<Object> createResources(Object value) {
		return new JAXBElement<Object>(_Resources_QNAME, Object.class, null,
				value);
	}

}
