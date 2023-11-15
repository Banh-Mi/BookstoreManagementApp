package util;

import gui.BangNhapExcel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//ọadaskdk
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Excel {

    public static boolean exportToExcel(JTable table, String totalAmount) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
        int result = fileChooser.showSaveDialog(null);

        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            // Ensure the file has the ".xlsx" extension
            if (!file.getName().toLowerCase().endsWith(".xlsx")) {
                file = new File(file.getAbsolutePath() + ".xlsx");
            }

            try (FileOutputStream outputStream = new FileOutputStream(file); Workbook workbook = new XSSFWorkbook()) {
                Sheet sheet = workbook.createSheet("DanhSachHoaDon");
                Font boldFont = workbook.createFont();
                boldFont.setBold(true);

                CellStyle boldCellStyle = workbook.createCellStyle();
                boldCellStyle.setFont(boldFont);

                // Tạo dòng tiêu đề
                Row titleRow = sheet.createRow(0);
                for (int col = 0; col < table.getColumnCount(); col++) {
                    Cell cell = titleRow.createCell(col);
                    cell.setCellValue(table.getColumnName(col));
                    cell.setCellStyle(boldCellStyle);
                }

                // Xuất dữ liệu từ JTable vào Excel
                for (int row = 0; row < table.getRowCount(); row++) {
                    Row excelRow = sheet.createRow(row + 1);
                    for (int col = 0; col < table.getColumnCount(); col++) {
                        Object value = table.getValueAt(row, col);
                        Cell cell = excelRow.createCell(col);
                        if (value != null) {
                            cell.setCellValue(value.toString());
                        }
                    }
                }

                // Tạo dòng chứa tổng doanh thu
                Row totalRow = sheet.createRow(table.getRowCount() + 1);

                Cell totalLabelCell = totalRow.createCell(table.getColumnCount() - 2);
                totalLabelCell.setCellValue("Doanh Thu");
                totalLabelCell.setCellStyle(boldCellStyle);

                Cell totalAmountCell = totalRow.createCell(table.getColumnCount() - 1);
                totalAmountCell.setCellValue(totalAmount);
                totalAmountCell.setCellStyle(boldCellStyle);

                workbook.write(outputStream);

                return true;
            } catch (Exception ex) {
                ex.printStackTrace();
                return false;
            }
        }

        return false;
    }

    private static Object[] readRow(Row row) {
        int numberOfColumns = row.getLastCellNum();
        Object[] rowData = new Object[numberOfColumns];

        for (int i = 0; i < numberOfColumns; i++) {
            Cell cell = row.getCell(i, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);

            switch (cell.getCellType()) {
                case STRING:
                    rowData[i] = cell.getStringCellValue();
                    break;
                case NUMERIC:
                    rowData[i] = cell.getNumericCellValue();
                    break;
                // Add more cases for other cell types as needed
                default:
                    rowData[i] = null;
            }
        }

        return rowData;
    }

    public static List<Object[]> readExcel() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Excel Files", "xlsx"));
        int result = fileChooser.showSaveDialog(null);

        List<Object[]> rows = new ArrayList<>();
        if (result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try (FileInputStream inputStream = new FileInputStream(file); Workbook workbook = WorkbookFactory.create(inputStream)) {
                Sheet sheet = workbook.getSheetAt(0);
                Row headerRow = sheet.getRow(0);
                Object[] columnHeaders = readRow(headerRow);
                for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
                    Row currentRow = sheet.getRow(rowIndex);

                    Object[] rowData = readRow(currentRow);
                    if (rowData[0] != null&&rowData[1]!=null&&rowData[2]!=null&&rowData[3]!=null&&rowData[4]!=null&&rowData[9]!=null&&rowData[10]!=null&&rowData[11]!=null&&rowData[12]!=null) {
                        rows.add(rowData);
                    }

                }
                JFrame jf = null;
                jf = new BangNhapExcel(rows, columnHeaders);
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return rows;
    }
}
