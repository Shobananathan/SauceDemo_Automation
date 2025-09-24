package saucedemo.data_provider;

import org.testng.annotations.DataProvider;
import utility.ExcelManager;

import java.io.IOException;

public class SauceDemo_DP {
    //1.name
    //2. excel mention path,sheet
    //3.excel -> count
    //4.2d array ->forloop

    @DataProvider(name = "DP_SauceDemo")
    public static Object[][] getSauceDemoData() throws IOException {
        String filePath = "src/test/resources/testdata/Testcase_SauceDemo.xlsx";
        String sheetName = "Sheet1";


        ExcelManager excel = new ExcelManager();
        int rowCount = excel.getRowCount(filePath, sheetName);

        Object[][] data = new Object[rowCount][7];
        for (int i = 1; i <= rowCount; i++) {
            data[i - 1][0] = excel.getCellData(filePath, sheetName, i, 0);
            data[i - 1][1] = excel.getCellData(filePath, sheetName, i, 1);
            data[i - 1][2] = excel.getCellData(filePath, sheetName, i, 2);
            data[i - 1][3] = excel.getCellData(filePath, sheetName, i, 3);
            data[i - 1][4] = excel.getCellData(filePath, sheetName, i, 4);
            data[i - 1][5] = excel.getCellData(filePath, sheetName, i, 5);
            data[i - 1][6] = excel.getCellData(filePath, sheetName, i, 6);
        }
        return data;
    }

}
