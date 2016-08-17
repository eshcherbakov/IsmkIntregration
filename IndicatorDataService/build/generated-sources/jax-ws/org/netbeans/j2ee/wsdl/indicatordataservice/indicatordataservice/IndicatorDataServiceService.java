
package org.netbeans.j2ee.wsdl.indicatordataservice.indicatordataservice;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.3.3-hudson-757-SNAPSHOT
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "IndicatorDataServiceService", targetNamespace = "http://j2ee.netbeans.org/wsdl/IndicatorDataService/IndicatorDataService", wsdlLocation = "file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorDataService/src/conf/xml-resources/web-services/IndicatorDataService/wsdl/IndicatorDataService.wsdl")
public class IndicatorDataServiceService
    extends Service
{

    private final static URL INDICATORDATASERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.netbeans.j2ee.wsdl.indicatordataservice.indicatordataservice.IndicatorDataServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.netbeans.j2ee.wsdl.indicatordataservice.indicatordataservice.IndicatorDataServiceService.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorDataService/src/conf/xml-resources/web-services/IndicatorDataService/wsdl/IndicatorDataService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorDataService/src/conf/xml-resources/web-services/IndicatorDataService/wsdl/IndicatorDataService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        INDICATORDATASERVICESERVICE_WSDL_LOCATION = url;
    }

    public IndicatorDataServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IndicatorDataServiceService() {
        super(INDICATORDATASERVICESERVICE_WSDL_LOCATION, new QName("http://j2ee.netbeans.org/wsdl/IndicatorDataService/IndicatorDataService", "IndicatorDataServiceService"));
    }

    /**
     * 
     * @return
     *     returns IndicatorDataServicePortType
     */
    @WebEndpoint(name = "IndicatorDataServicePort")
    public IndicatorDataServicePortType getIndicatorDataServicePort() {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/IndicatorDataService/IndicatorDataService", "IndicatorDataServicePort"), IndicatorDataServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IndicatorDataServicePortType
     */
    @WebEndpoint(name = "IndicatorDataServicePort")
    public IndicatorDataServicePortType getIndicatorDataServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/IndicatorDataService/IndicatorDataService", "IndicatorDataServicePort"), IndicatorDataServicePortType.class, features);
    }

}
