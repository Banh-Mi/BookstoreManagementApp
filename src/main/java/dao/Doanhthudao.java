package dao;

import connectDB.ConnectDB;
import entity.Customer;
import entity.DoanhThu;
import entity.DoanhThuBieuDo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Doanhthudao {

    public ArrayList<DoanhThu> getAllDoanhThu(Date ngaybatdau, Date ngayketthuc) {
        ArrayList<DoanhThu> listdt = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon, "
                    + "SUM(CH.soLuong * SP.gia) AS TongTien "
                    + "FROM HoaDon HD "
                    + "JOIN NhanVien NV ON HD.maNV = NV.maNV "
                    + "JOIN KhachHang KH ON HD.maKH = KH.maKH "
                    + "JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon "
                    + "JOIN SanPham SP ON CH.maSanPham = SP.maSanPham "
                    + "WHERE HD.ngayLapHoaDon BETWEEN ? AND ? "
                    + "GROUP BY HD.maHoaDon, NV.tenNV, KH.tenKH, HD.ngayLapHoaDon";
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, ngaybatdau);
            stmt.setDate(2, ngayketthuc);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listdt.add(new DoanhThu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDouble(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdt;
    }

    public ArrayList<DoanhThuBieuDo> getAllDoanhThuBieuDo(int nam) {
        ArrayList<DoanhThuBieuDo> listdtbd = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT DATEPART(MONTH, HD.ngayLapHoaDon) AS Thang, "
                    + " SUM(CH.soLuong * SP.gia) AS TongTien "
                    + "	FROM HoaDon HD "
                    + "	JOIN ChiTietHoaDon CH ON HD.maHoaDon = CH.maHoaDon "
                    + "	JOIN SanPham SP ON CH.maSanPham = SP.maSanPham "
                    + "	WHERE YEAR(HD.ngayLapHoaDon) = ? "
                    + "	GROUP BY DATEPART(MONTH, HD.ngayLapHoaDon) "
                    + "	ORDER BY DATEPART(MONTH, HD.ngayLapHoaDon);";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listdtbd.add(new DoanhThuBieuDo(rs.getInt(1), rs.getDouble(2)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listdtbd;
    }

    public void close(PreparedStatement stmt) {
        if (stmt != null) {
            try {
                stmt.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
