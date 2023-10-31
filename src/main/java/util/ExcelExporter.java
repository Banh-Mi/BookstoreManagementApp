package util;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.io.FileOutputStream;

public class ExcelExporter {

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
}
