package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelManager {
    public int getRowCount(String filePath,String sheetName) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheet(sheetName);
            return sheet.getPhysicalNumberOfRows() - 1;
        }

    }

    public String getCellData(String filepath, String sheetName, int row, int col) throws IOException {
        try (FileInputStream fis = new FileInputStream(new File(filepath));
             Workbook wb = new XSSFWorkbook(fis)) {
            Sheet sheet = wb.getSheet(sheetName);
            Row row1 = sheet.getRow(row);
            if (row1 == null) return "";
            Cell cell = row1.getCell(col);
            if (cell == null) return "";
            DataFormatter formatter = new DataFormatter();
            return formatter.formatCellValue(cell).trim();


        }


    }


}

