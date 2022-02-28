package co.com.practice.utils;

import java.io.IOException;

public class DataExcel {

    public static String DataExcelCell(int row, int cell) throws IOException {

        ReadExcelFile readExcelFile = new ReadExcelFile();
        String dato = readExcelFile.getCellValue(row, cell);

        return dato;
    }

}
