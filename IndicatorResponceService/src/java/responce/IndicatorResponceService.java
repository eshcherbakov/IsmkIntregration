/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package responce;

import java.util.List;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ru.shcherbakov.responce.IndicatorType;
import ru.shcherbakov.simpleresponce.SimpleResponceType;

/**
 *
 * @author Shcherbakov
 */
@WebService(serviceName = "IndicatorResponceServiceService", portName = "IndicatorResponceServicePortTypeBindingPort", endpointInterface = "org.netbeans.j2ee.wsdl.indicatorresponceservice.indicatorresponceservice.IndicatorResponceServicePortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/IndicatorResponceService/IndicatorResponceService", wsdlLocation = "META-INF/wsdl/IndicatorResponceService/IndicatorResponceService.wsdl")
@Stateless
public class IndicatorResponceService {

    public ru.shcherbakov.simpleresponce.SimpleResponceType indicatorResponceServiceOperation(ru.shcherbakov.responce.ResponceType inputPart) {
        SimpleResponceType srt = new SimpleResponceType();
        String result = null;

        List<IndicatorType> itList = inputPart.getIndicatorType();
        if (itList != null) {

            for (IndicatorType it : itList) {
                if (it != null) {

                    Integer processId = it.getId();
                    Double value = it.getValue();

                    if ((processId != null) | (value != null)) {
                        // Идентификатор процесса и значение доложны быть положительным
                        if ((processId > 0) & (value > 0)) {
                            result = "successIndicatorResponce";
                        } else {
                            result = "faultIndicatorResponce";
                        }
                    } else {
                        result = "faultIndicatorResponce";
                    }
                } else {
                    result = "faultIndicatorResponce";
                }
            }
        } else {
            result = "faultIndicatorResponce";
        }

        srt.setResponce(result);
        return srt;
    }
}
