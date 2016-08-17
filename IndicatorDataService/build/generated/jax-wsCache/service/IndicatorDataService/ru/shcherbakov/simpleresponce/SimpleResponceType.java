
package ru.shcherbakov.simpleresponce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for simpleResponceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="simpleResponceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="responce" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "simpleResponceType", propOrder = {
    "responce"
})
public class SimpleResponceType {

    @XmlElement(required = true)
    protected String responce;

    /**
     * Gets the value of the responce property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getResponce() {
        return responce;
    }

    /**
     * Sets the value of the responce property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setResponce(String value) {
        this.responce = value;
    }

}
