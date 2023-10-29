
package dao;

import connectDB.ConnectDB;
import entity.ThongKeSanPham;
import entity.DoanhThuBieuDo;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class ThongKeSanPhamDAO {
     public ArrayList<ThongKeSanPham> getSanPham(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamTuyChinh(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

    

    public ArrayList<ThongKeSanPham> getDoanhThuSanPhamThangNam(int month, int year) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamThangNam(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
 //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 ban nhieu
    public ArrayList<ThongKeSanPham> getSanPhamBanNhieu(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamTuyChinhBanNhieu(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<ThongKeSanPham> getSanPhamThangNamBanNhieu(int month, int year) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamThangNamBanNhieu(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }

     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 ban nhieu
    public ArrayList<ThongKeSanPham> getSanPhamBanIt(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamTuyChinhBanIt(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<ThongKeSanPham> getSanPhamThangNamBanIt(int month, int year) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamThangNamBanIt(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 doanh thu ban nhieu
    public ArrayList<ThongKeSanPham> getSanPhamDoanhThuNhieu(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamTuyChinhDoanhThuNhieu(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<ThongKeSanPham> getSanPhamThangNamDoanhThuNhieu(int month, int year) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamThangNamDoanhThuNhieu(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 doanh thu ban it
    public ArrayList<ThongKeSanPham> getSanPhamDoanhThuIt(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamTuyChinhDoanhThuIt(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    public ArrayList<ThongKeSanPham> getSanPhamThangNamDoanhThuIt(int month, int year) {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call SanPhamThangNamDoanhThuIt(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
      //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 ton kho nhieu nhat
    public ArrayList<ThongKeSanPham> getSanPhamTonKhoNhieu() {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "SELECT TOP 5 maSanPham, tenSanPham, soLuong, soLuong * gia AS ThanhTien FROM SanPham ORDER BY soLuong DESC";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
    //top 5 ton kho it nhat
    public ArrayList<ThongKeSanPham> getSanPhamTonKhoIt() {
        ArrayList<ThongKeSanPham> ds = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        
        try {
            String sql = "SELECT TOP 5 maSanPham, tenSanPham, soLuong, soLuong * gia AS ThanhTien FROM SanPham ORDER BY soLuong ASC";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                ds.add(new ThongKeSanPham(rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;
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
