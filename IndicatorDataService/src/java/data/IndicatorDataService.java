/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.sql.DataSource;
import ru.shcherbakov.simpleresponce.SimpleResponceType;

/**
 *
 * @author Shcherbakov
 */
@WebService(serviceName = "IndicatorDataServiceService", portName = "IndicatorDataServicePort", endpointInterface = "org.netbeans.j2ee.wsdl.indicatordataservice.indicatordataservice.IndicatorDataServicePortType", targetNamespace = "http://j2ee.netbeans.org/wsdl/IndicatorDataService/IndicatorDataService", wsdlLocation = "META-INF/wsdl/IndicatorDataService/IndicatorDataService.wsdl")
@Stateless
public class IndicatorDataService {

    protected DataSource ds;
    private static String fileNameIn = "D:/dataIn.txt";
    private static String fileNameOut = "D:/dataOut.txt";	

    public ru.shcherbakov.simpleresponce.SimpleResponceType indicatorDataServiceOperation(ru.shcherbakov.simpleresponce.SimpleResponceType inputPart) {
        SimpleResponceType srt = new SimpleResponceType();
        try {
            FactData fd = new FactData();
            RequestData rd = new RequestData();
            // Прочитать данные из файла
            rd = readFromFile();
            // Выборка данных из БД
            fd = getFactData(rd);
            // Запись данных в файл
            writeToFile(fd);

            srt.setResponce("successIndicatorDataService");
        } catch (Exception ex) {
            srt.setResponce("failtIndicatorDataService");
        }
        return srt;
    }

    private void connect() {
        com.mysql.jdbc.jdbc2.optional.MysqlDataSource jdbc =
                new com.mysql.jdbc.jdbc2.optional.MysqlDataSource();
        jdbc.setDatabaseName("eldec");
        jdbc.setServerName("localhost");
        jdbc.setUser("root");
        jdbc.setPassword("root");
        this.ds = (DataSource) jdbc;
    }

    private void disconnect(PreparedStatement stmt, Connection conn) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
        }
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException exp) {
        }
    }

    private FactData getFactData(RequestData rd) {
        Connection conn = null;
        PreparedStatement stmt = null;
        connect();
        try {
            FactData fd = new FactData();
            conn = ds.getConnection();
            stmt = conn.prepareStatement("SELECT id, fdate, value, " +
                    "units FROM factdata " +
                    "WHERE (id = ?) and (fdate >= ?) and (fdate < ?)");
            stmt.setInt(1, rd.getId());
            stmt.setDate(2, rd.getFirstDate());
            stmt.setDate(3, rd.getLastDate());
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                fd.setId(rs.getInt("id"));
                fd.setFdate(rs.getDate("fdate"));
                fd.setValue(rs.getDouble("value"));
                fd.setUnits(rs.getString("units"));
            }
            return fd;
        } catch (SQLException exp) {
            return null;
        } finally {
            disconnect(stmt, conn);
        }
    }

    private RequestData readFromFile() {
        String fileString = "";
        RequestData rd = new RequestData();
        try {
            BufferedReader in = new BufferedReader(new FileReader(fileNameIn));
            fileString = in.readLine();

            int counter = 0;
            String strPart = "";
            for (int i = 0; i < fileString.length(); i++) {
                if (fileString.charAt(i) == ';') {
                    switch (counter) {
                        case 0:
                            rd.setId(Integer.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                        case 1:
                            rd.setFirstDate(Date.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                        case 2:
                            rd.setLastDate(Date.valueOf(strPart));
                            strPart = "";
                            counter++;
                            break;
                    }
                } else {
                    strPart += fileString.charAt(i);
                }
            }
            return rd;
        } catch (Exception ex) {
            return null;
        }
    }

    private void writeToFile(FactData fd) {
        try {
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(fileNameOut), false)));
            String str = fd.getId() + ";" + fd.getFdate() + ";" +
                    fd.getValue() + ";" + fd.getUnits() + ";";
            out.write(str);
            out.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}

