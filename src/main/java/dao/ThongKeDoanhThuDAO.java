package dao;

import connectDB.ConnectDB;
import entity.ThongKeDoanhThu;
import entity.DoanhThuBieuDo;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ThongKeDoanhThuDAO {

    public ArrayList<ThongKeDoanhThu> getHoaDon(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeDoanhThu> danhSachHoaDon = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call DoanhThuTuyChinh(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachHoaDon.add(new ThongKeDoanhThu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDouble(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
    }

    

    public ArrayList<ThongKeDoanhThu> getDoanhThuThangNam(int month, int year) {
        ArrayList<ThongKeDoanhThu> danhSachHoaDon = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call DoanhThuThangNam(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachHoaDon.add(new ThongKeDoanhThu(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDouble(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachHoaDon;
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
