package utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {

    public static String getData(String path, int row, int col) {

        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheetAt(0);

            return sheet.getRow(row).getCell(col).toString();

        } catch (Exception e) {
            throw new RuntimeException("Excel Read Error: " + e.getMessage());
        }
    }

    public static int getRowCount(String path) {

        try (FileInputStream fis = new FileInputStream(path);
             Workbook wb = WorkbookFactory.create(fis)) {

            Sheet sheet = wb.getSheetAt(0);

            return sheet.getPhysicalNumberOfRows();

        } catch (Exception e) {
            throw new RuntimeException("Row Count Error: " + e.getMessage());
        }
    }
}