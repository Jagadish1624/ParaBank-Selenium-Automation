package utils;

import java.io.InputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    static Workbook workbook;
    static Sheet sheet;

    private static final String FILE_NAME = "testdata.xlsx";
    private static final String SHEET_NAME = "Registration";

    public static void loadExcel() {

        try {

            InputStream is = ExcelUtil.class
                    .getClassLoader()
                    .getResourceAsStream(FILE_NAME);

            if (is == null) {
                throw new RuntimeException("Excel file not found: " + FILE_NAME);
            }

            workbook = new XSSFWorkbook(is);
            sheet = workbook.getSheet(SHEET_NAME);

            if (sheet == null) {
                throw new RuntimeException("Sheet not found: " + SHEET_NAME);
            }

        } catch (Exception e) {
            throw new RuntimeException("Excel not loaded");
        }
    }

    public static String getCellData(int row, int col) {

        DataFormatter formatter = new DataFormatter();

        return formatter.formatCellValue(
                sheet.getRow(row).getCell(col));
    }

    public static int getRowCount() {
        return sheet.getLastRowNum();
    }
    public static void closeWorkbook() {

        try {

            if (workbook != null) {
                workbook.close();
                workbook = null;
                sheet = null;
            }

        } catch (Exception e) {

            throw new RuntimeException("Failed to close Excel");
        }
    }
}
