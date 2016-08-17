
package org.netbeans.j2ee.wsdl.indicatorresponceservice.indicatorresponceservice;

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
@WebServiceClient(name = "IndicatorResponceServiceService", targetNamespace = "http://j2ee.netbeans.org/wsdl/IndicatorResponceService/IndicatorResponceService", wsdlLocation = "file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorResponceService/src/conf/xml-resources/web-services/IndicatorResponceService/wsdl/IndicatorResponceService.wsdl")
public class IndicatorResponceServiceService
    extends Service
{

    private final static URL INDICATORRESPONCESERVICESERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(org.netbeans.j2ee.wsdl.indicatorresponceservice.indicatorresponceservice.IndicatorResponceServiceService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = org.netbeans.j2ee.wsdl.indicatorresponceservice.indicatorresponceservice.IndicatorResponceServiceService.class.getResource(".");
            url = new URL(baseUrl, "file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorResponceService/src/conf/xml-resources/web-services/IndicatorResponceService/wsdl/IndicatorResponceService.wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'file:/D:/University/Web-technology/Semestr2/KP/Step4-BPEL/IndicatorResponceService/src/conf/xml-resources/web-services/IndicatorResponceService/wsdl/IndicatorResponceService.wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        INDICATORRESPONCESERVICESERVICE_WSDL_LOCATION = url;
    }

    public IndicatorResponceServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public IndicatorResponceServiceService() {
        super(INDICATORRESPONCESERVICESERVICE_WSDL_LOCATION, new QName("http://j2ee.netbeans.org/wsdl/IndicatorResponceService/IndicatorResponceService", "IndicatorResponceServiceService"));
    }

    /**
     * 
     * @return
     *     returns IndicatorResponceServicePortType
     */
    @WebEndpoint(name = "IndicatorResponceServicePortTypeBindingPort")
    public IndicatorResponceServicePortType getIndicatorResponceServicePortTypeBindingPort() {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/IndicatorResponceService/IndicatorResponceService", "IndicatorResponceServicePortTypeBindingPort"), IndicatorResponceServicePortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns IndicatorResponceServicePortType
     */
    @WebEndpoint(name = "IndicatorResponceServicePortTypeBindingPort")
    public IndicatorResponceServicePortType getIndicatorResponceServicePortTypeBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/IndicatorResponceService/IndicatorResponceService", "IndicatorResponceServicePortTypeBindingPort"), IndicatorResponceServicePortType.class, features);
    }

}