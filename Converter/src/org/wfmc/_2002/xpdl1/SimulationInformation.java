//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.3 in JDK 1.6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2009.09.15 at 06:18:08 PM EST 
//


package org.wfmc._2002.xpdl1;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}Cost"/>
 *         &lt;element ref="{http://www.wfmc.org/2002/XPDL1.0}TimeEstimation"/>
 *       &lt;/sequence>
 *       &lt;attribute name="Instantiation">
 *         &lt;simpleType>
 *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NMTOKEN">
 *             &lt;enumeration value="ONCE"/>
 *             &lt;enumeration value="MULTIPLE"/>
 *           &lt;/restriction>
 *         &lt;/simpleType>
 *       &lt;/attribute>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "cost",
    "timeEstimation"
})
@XmlRootElement(name = "SimulationInformation")
public class SimulationInformation {

    @XmlElement(name = "Cost", required = true)
    protected String cost;
    @XmlElement(name = "TimeEstimation", required = true)
    protected TimeEstimation timeEstimation;
    @XmlAttribute(name = "Instantiation")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String instantiation;

    /**
     * Gets the value of the cost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCost() {
        return cost;
    }

    /**
     * Sets the value of the cost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCost(String value) {
        this.cost = value;
    }

    /**
     * Gets the value of the timeEstimation property.
     * 
     * @return
     *     possible object is
     *     {@link TimeEstimation }
     *     
     */
    public TimeEstimation getTimeEstimation() {
        return timeEstimation;
    }

    /**
     * Sets the value of the timeEstimation property.
     * 
     * @param value
     *     allowed object is
     *     {@link TimeEstimation }
     *     
     */
    public void setTimeEstimation(TimeEstimation value) {
        this.timeEstimation = value;
    }

    /**
     * Gets the value of the instantiation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstantiation() {
        return instantiation;
    }

    /**
     * Sets the value of the instantiation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstantiation(String value) {
        this.instantiation = value;
    }

}
