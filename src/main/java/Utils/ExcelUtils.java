package Utils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class ExcelUtils {

    private static final String FILE_PATH = "src/main/resources/TestData.xlsx";
    private static Workbook workbook;
    private static Sheet sheet;

    // Load the Excel file and initialize the sheet
    public static void loadExcelFile(String sheetName) {
        try (FileInputStream fis = new FileInputStream(FILE_PATH)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // Method to get username for a given row
    public static String getdata(int rowIndex, int i) {
        return sheet.getRow(rowIndex).getCell(i).getStringCellValue();
    }

    // Method to get password for a given row
//        public static String getPassword(int rowIndex, int i) {
//            return sheet.getRow(rowIndex).getCell(i).getStringCellValue();
//        }


    // Method to get all test data as a list of arrays
    public List<String[]> getAllTestData() {
        List<String[]> data = new ArrayList<>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from 1 to skip header
            Row row = sheet.getRow(i);
            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            data.add(new String[]{username, password});
        }
        return data;
    }


}

