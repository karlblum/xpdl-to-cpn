//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.1-b02-fcs 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2010.03.24 at 06:49:45 PM EET 
//


package ee.ut.model.sim;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GateRef complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GateRef">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="IdRef" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Probability" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GateRef", propOrder = {
    "idRef",
    "probability"
})
public class GateRef {

    @XmlElement(name = "IdRef", required = true)
    protected String idRef;
    @XmlElement(name = "Probability")
    protected int probability;

    /**
     * Gets the value of the idRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdRef() {
        return idRef;
    }

    /**
     * Sets the value of the idRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdRef(String value) {
        this.idRef = value;
    }

    /**
     * Gets the value of the probability property.
     * 
     */
    public int getProbability() {
        return probability;
    }

    /**
     * Sets the value of the probability property.
     * 
     */
    public void setProbability(int value) {
        this.probability = value;
    }

}
