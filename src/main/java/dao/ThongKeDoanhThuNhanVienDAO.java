
package dao;

import connectDB.ConnectDB;
import entity.ThongKeDoanhThu;
import entity.ThongKeDoanhThuNhanVien;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author BanhMi88
 */
public class ThongKeDoanhThuNhanVienDAO {
    public ArrayList<ThongKeDoanhThuNhanVien> getDoanhThuNhanVien(Date ngayBatDau, Date ngayKetThuc, int option, String maNV) {
        ArrayList<ThongKeDoanhThuNhanVien> danhSachThongKe = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call DoanhThuNhanVienTuyChinh(?,?,?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            cstmt.setInt(3, option);
            cstmt.setString(4, maNV);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {

                danhSachThongKe.add(new ThongKeDoanhThuNhanVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachThongKe;
    }

    public ArrayList<ThongKeDoanhThuNhanVien> getDoanhThuNhanVienThangNam(int month, int year, int option, String maNV) {
        ArrayList<ThongKeDoanhThuNhanVien> danhSachThongKe = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call DoanhThuNhanVienThangNam(?,?,?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, option);
            cstmt.setString(2, maNV);
            cstmt.setInt(3, month);
            cstmt.setInt(4, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachThongKe.add(new ThongKeDoanhThuNhanVien(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getDouble(4), rs.getDouble(5), rs.getDouble(6)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachThongKe;
    }

}
