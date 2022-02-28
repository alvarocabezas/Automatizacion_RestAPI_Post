package co.com.practice.utils;

import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    public ReadExcelFile(){

    }

    public void readExcel() throws IOException {

        File file = new File("C:\\Users\\acabezasr\\Desktop\\EjercicioAutomatizacionRestPOST\\src\\test\\resources\\data\\DataAutomatizacionPost.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet("Hoja1");

        int rowCount = newSheet.getLastRowNum() + newSheet.getFirstRowNum();

        for (int i = 0; i < rowCount; i++){
            XSSFRow row = newSheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++){
                System.out.println(row.getCell(j).getStringCellValue() + "||");

            }
        }
    }

    public static String getCellValue(int rowNumber, int cellNumber) throws IOException {

        File file = new File("C:\\Users\\acabezasr\\Desktop\\EjercicioAutomatizacionRestPOST\\src\\test\\resources\\data\\DataAutomatizacionPost.xlsx");
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet("Hoja1");

        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }

    /*public String getCellValue(String filepath, String sheeName, int rowNumber, int cellNumber) throws IOException {

        File file = new File(filepath);
        FileInputStream inputStream = new FileInputStream(file);
        XSSFWorkbook newWorkbook = new XSSFWorkbook(inputStream);
        XSSFSheet newSheet = newWorkbook.getSheet(sheeName);

        XSSFRow row = newSheet.getRow(rowNumber);
        XSSFCell cell = row.getCell(cellNumber);

        return cell.getStringCellValue();
    }*/

}
