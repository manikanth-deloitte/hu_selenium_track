package pages;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadingExcel {
    public  String Uname;
    public  String Pword;

    public void readCells() throws IOException {
            String excelFilePath = ".\\loginDetails.xlsx";
            FileInputStream inputStream = new FileInputStream(excelFilePath);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(1).getLastCellNum();


            for (int i = 1; i <= rows; i++) {
                XSSFRow row = sheet.getRow(i);
                for (int j = 0; j < cols; j++) {
                    XSSFCell cell = row.getCell(j);
                    if (j == 0) {
                        Uname = cell.getStringCellValue();
                    }
                    if (j == 1) {
                        Pword = cell.getStringCellValue();
                    }

                }

            }
        }
    public String getName(){
        return Uname;

    }
    public String getPass(){
        return Pword;
    }
}
