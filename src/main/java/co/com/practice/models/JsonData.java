package co.com.practice.models;

import co.com.practice.utils.DataExcel;
import co.com.practice.utils.ReadExcelFile;

import java.io.IOException;

public class JsonData {


    public static String Json() throws IOException {
        String Data = "{\n" +
                "    \"name\": \""+DataExcel.DataExcelCell(1,1)+"\",\n" +
                "    \"job\": \""+ReadExcelFile.getCellValue(1,2) +"\"\n" +
                "}";
        return Data;
    }


}
