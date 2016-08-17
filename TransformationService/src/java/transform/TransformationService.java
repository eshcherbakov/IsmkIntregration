/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transform;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.sql.Date;
import javax.ejb.Stateless;
import javax.jws.WebService;
import ru.shcherbakov.request.IndicatorsDataType;
import ru.shcherbakov.responce.IndicatorType;
import ru.shcherbakov.responce.ResponceType;
import ru.shcherbakov.simpleresponce.SimpleResponceType;

/**
 *
 * @author Shcherbakov
 */
@WebService(serviceName = "TransformationServiceService", portName = "TransformationPortTypeBindingPort", endpointInterface = "ru.shcherbakov.transformation.TransformationPortType", targetNamespace = "http://www.shcherbakov.ru/transformation", wsdlLocation = "META-INF/wsdl/TransformationService/TransformationService.wsdl")
@Stateless
public class TransformationService {

    private String fileNameIn = "D:/dataIn.txt";
    private String fileNameOut = "D:/dataOut.txt";

    public ru.shcherbakov.simpleresponce.SimpleResponceType directTransformOperation(ru.shcherbakov.request.RequestType inputPart) {
        SimpleResponceType srt = new SimpleResponceType();
        try {
            RequestData rd = new RequestData();
            IndicatorsDataType idt = inputPart.getIndicatorsDataType().get(0);
            rd.setId(idt.getId());
            rd.setFirstDate(Date.valueOf(idt.getFirstDate()));
            rd.setLastDate(Date.valueOf(idt.getLastDate()));

            // Записать данные в файл
            writeToFile(rd);

            srt.setResponce("successDirectTransform");
        } catch (Exception e) {
            srt.setResponce("faultDirectTransform");
        }
        return srt;
    }

    public ru.shcherbakov.responce.ResponceType backTransformOperation(ru.shcherbakov.simpleresponce.SimpleResponceType inputPart) {
        ResponceType rt = new ResponceType();
        IndicatorType it = new IndicatorType();
        FactData fd = new FactData();
        try {
            // Прочитать данные из файла
            fd = readFromFile();
            it.setId(fd.getId());
            it.setDate(fd.getFdate().toString());
            it.setValue(fd.getValue());
            it.setUnits(fd.getUnits());
            rt.getIndicatorType().add(it);
            return rt;
        } catch (Exception e) {
            return null;
        }
    }

    private FactData readFromFile() {
        String fileString = "";
        FactData fd = new FactData();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileNameOut));
            fileString = in.readLine();

            int counter = 0;
            String strPart = "";
            for (int i = 0; i < fileString.length(); i++) {
                if (fileString.charAt(i) == ';') {
                    switch (counter) {
                        case 0:
                            fd.setId(Integer.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                        case 1:
                            fd.setFdate(Date.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                        case 2:
                            fd.setValue(Double.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                        case 3:
                            fd.setUnits(String.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                    }
                } else {
                    strPart += fileString.charAt(i);
                }
            }
            return fd;
        } catch (Exception ex) {
            return null;
        }
    }

    private void writeToFile(RequestData rd) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileNameIn), false)));
            String str = rd.getId() + ";" + rd.getFirstDate() + ";" +
                    rd.getLastDate() + ";";
            out.write(str);
            out.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}
