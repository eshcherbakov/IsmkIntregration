/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ru.shcherbakov.request.IndicatorsDataType;
import ru.shcherbakov.simpleresponce.SimpleResponceType;

/**
 *
 * @author Shcherbakov
 */
@WebService(serviceName = "IndicatorRequestServiceService", portName = "IndicatorRequestServicePort", endpointInterface = "org.netbeans.j2ee.wsdl.indicatorrequestservice.indicatorrequestservice.RequestPortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/IndicatorRequestService/IndicatorRequestService", wsdlLocation = "META-INF/wsdl/IndicatorRequestService/IndicatorRequestService.wsdl")
@Stateless
public class IndicatorRequestService {

    public ru.shcherbakov.simpleresponce.SimpleResponceType validateRequestOperation(ru.shcherbakov.request.RequestType inputPart) {
        String result = "";
        SimpleResponceType srt = new SimpleResponceType();
        try {

            List<IndicatorsDataType> idtList = inputPart.getIndicatorsDataType();
            for (IndicatorsDataType idt : idtList) {
                Integer processId = idt.getId();
                String firstDateStr = idt.getFirstDate();
                String lastDateStr = idt.getLastDate();

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date firstDate = sdf.parse(firstDateStr);
                Date lastDate = sdf.parse(lastDateStr);

                if ((processId != null) & (firstDate != null) & (lastDate != null)) {
                    if (processId.intValue() > 0) {
                        if (firstDate.before(lastDate) || firstDate.equals(lastDate)) {
                            result = "successValid";
                        } else {
                            result = "faultValid";
                        }
                    } else {
                        result = "faultValid";
                    }
                } else {
                    result = "faultValid";
                }
            }
            result = "successValid";
            srt.setResponce(result);
            return srt;
        } catch (Exception ex) {
            result = "faultValid";
            srt.setResponce(result);
            return srt;
        }
    }
}
