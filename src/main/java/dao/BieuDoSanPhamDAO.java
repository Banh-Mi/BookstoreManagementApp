package dao;

import com.toedter.calendar.JDateChooser;
import connectDB.ConnectDB;
import entity.SanPhamBieuDo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BieuDoSanPhamDAO {

    public ArrayList<SanPhamBieuDo> getAllSanPhamBieuDo(JDateChooser ngayBatDau, JDateChooser ngayKetThuc) {
    ArrayList<SanPhamBieuDo> listdtbd = new ArrayList<>();
    ConnectDB.getInstance();
    Connection con = ConnectDB.getConnection();
    PreparedStatement stmt = null;
    try {
        String sql = "SELECT "
                + "SP.danhMuc AS TenDanhMuc, "
                + "SUM(CTHD.soLuong) AS SoLuongSanPham "
                + "FROM ChiTietHoaDon CTHD "
                + "JOIN SanPham SP ON CTHD.maSanPham = SP.maSanPham "
                + "JOIN HoaDon HD ON CTHD.maHoaDon = HD.maHoaDon "
                + "WHERE HD.ngayLapHoaDon BETWEEN ? AND ? "
                + "GROUP BY SP.danhMuc";
        stmt = con.prepareStatement(sql);

        // Chuyển ngày từ JDateChooser thành java.sql.Date
        java.util.Date ngayBatDauUtil = ngayBatDau.getDate();
        java.sql.Date ngayBatDauSQL = new java.sql.Date(ngayBatDauUtil.getTime());

        java.util.Date ngayKetThucUtil = ngayKetThuc.getDate();
        java.sql.Date ngayKetThucSQL = new java.sql.Date(ngayKetThucUtil.getTime());

        stmt.setDate(1, ngayBatDauSQL);
        stmt.setDate(2, ngayKetThucSQL);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            listdtbd.add(new SanPhamBieuDo(rs.getString(1), rs.getInt(2)));
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return listdtbd;
}
}
