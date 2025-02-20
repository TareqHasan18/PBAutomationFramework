package utility;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestUtil {

    public static long PAGE_LOAD_TIMEOUT = 30;
    public static long IMPLICIT_WAIT = 20;

    public static String TEST_DATA_SHEET_NAME = "/Users/tareqhasan/IdeaProjects/PBAutomationFramework/src/main/java/dataProvider/ParaBankTestData.xlsx";

    public static Object[][] getTestData(String sheetName) throws IOException {
        //create the object of FileInputStream and pass the path of the excel in the constructor
        FileInputStream myFile = new FileInputStream(TEST_DATA_SHEET_NAME);

        //create the object of XSSFWorkbook
        XSSFWorkbook workbook = new XSSFWorkbook(myFile);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rows = sheet.getLastRowNum();
        int columns = sheet.getRow(0).getLastCellNum();

        Object[][] data = new Object[rows][columns];

        for(int i = 0; i < rows; i++){
            XSSFRow row = sheet.getRow(i+1);

            for(int j = 0; j < columns; j++){
                XSSFCell cell = row.getCell(j);

                CellType cellType = cell.getCellType();

                switch (cellType){
                    case STRING:
                        data[i][j] = cell.getStringCellValue();
                        break;

                    case NUMERIC:
                        data[i][j] = Integer.toString((int)cell.getNumericCellValue());
                        break;

                    case BOOLEAN:
                        data[i][j] = cell.getBooleanCellValue();
                }
            }
        }

        return data;

    }

}
