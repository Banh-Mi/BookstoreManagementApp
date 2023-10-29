/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import entity.ThongKeDoanhThu;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static boolean exportToExcel(List<ThongKeDoanhThu> doanhThuList, String filePath) {
        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("DanhSachHoaDon");
            Font boldFont = workbook.createFont();
            boldFont.setBold(true);

            // Tạo kiểu font đậm
            CellStyle boldCellStyle = workbook.createCellStyle();
            boldCellStyle.setFont(boldFont);

            // Tạo title
            Row titleRow = sheet.createRow(0);
            String[] columns = {"Mã Hóa Đơn", "Tên Nhân Viên", "Tên Khách Hàng", "Ngày Lập Hóa Đơn", "Tổng Tiền"};
            for (int i = 0; i < columns.length; i++) {
                Cell cell = titleRow.createCell(i);
                cell.setCellValue(columns[i]);
                cell.setCellStyle(boldCellStyle); // Đặt kiểu font đậm cho tiêu đề
            }

            // Đổ dữ liệu từ danh sách vào Excel
            int rowNum = 1;
            double totalAmount = 0; 
            for (ThongKeDoanhThu doanhThu : doanhThuList) {
                Row row = sheet.createRow(rowNum++);

                row.createCell(0).setCellValue(doanhThu.getMahoadon());
                row.createCell(1).setCellValue(doanhThu.getTennv());
                row.createCell(2).setCellValue(doanhThu.getTenkh());
                row.createCell(3).setCellValue(doanhThu.getNgaylaphoadon().toString());
                row.createCell(4).setCellValue(doanhThu.getTongtien());

                totalAmount += doanhThu.getTongtien();
            }

            // Tạo dòng cuối cùng để in tổng tiền
            Row totalRow = sheet.createRow(rowNum);
            Cell totalLabelCell = totalRow.createCell(columns.length-2);
            totalLabelCell.setCellValue("Doanh Thu");
            totalLabelCell.setCellStyle(boldCellStyle);

            Cell totalAmountCell = totalRow.createCell(columns.length-1);
            totalAmountCell.setCellValue(totalAmount);
            totalAmountCell.setCellStyle(boldCellStyle);

            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
                return true; 
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
}
