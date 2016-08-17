
package ru.shcherbakov.simpleresponce;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the ru.shcherbakov.simpleresponce package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SimpleResponce_QNAME = new QName("http://www.shcherbakov.ru/simpleResponce", "simpleResponce");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: ru.shcherbakov.simpleresponce
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SimpleResponceType }
     * 
     */
    public SimpleResponceType createSimpleResponceType() {
        return new SimpleResponceType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SimpleResponceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.shcherbakov.ru/simpleResponce", name = "simpleResponce")
    public JAXBElement<SimpleResponceType> createSimpleResponce(SimpleResponceType value) {
        return new JAXBElement<SimpleResponceType>(_SimpleResponce_QNAME, SimpleResponceType.class, null, value);
    }

}
