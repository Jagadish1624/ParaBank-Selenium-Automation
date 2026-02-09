package utils;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    static Workbook workbook;
    static Sheet sheet;

    public static void loadExcel(String path, String sheetName) {

        try {

            FileInputStream fis = new FileInputStream(path);

            workbook = new XSSFWorkbook(fis);

            sheet = workbook.getSheet(sheetName);

        } catch (Exception e) {

            throw new RuntimeException("Excel not loaded");
        }
    }

    public static String getCellData(int row, int col) {

        return sheet
                .getRow(row)
                .getCell(col)
                .getStringCellValue();
    }

    public static int getRowCount() {

        return sheet.getPhysicalNumberOfRows();
    }
}
