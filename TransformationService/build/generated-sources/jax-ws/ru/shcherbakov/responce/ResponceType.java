
package ru.shcherbakov.responce;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for responceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="responceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.shcherbakov.ru/responce}indicatorType" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responceType", propOrder = {
    "indicatorType"
})
public class ResponceType {

    @XmlElement(required = true)
    protected List<IndicatorType> indicatorType;

    /**
     * Gets the value of the indicatorType property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the indicatorType property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIndicatorType().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IndicatorType }
     * 
     * 
     */
    public List<IndicatorType> getIndicatorType() {
        if (indicatorType == null) {
            indicatorType = new ArrayList<IndicatorType>();
        }
        return this.indicatorType;
    }

}
