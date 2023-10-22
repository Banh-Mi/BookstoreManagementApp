package dao;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ChiTietHoaDonDAO{

    public ArrayList<ChiTietHoaDon> selectbyId(String maHoaDon) {
        ArrayList<ChiTietHoaDon> danhSachChiTietHoaDon = new ArrayList<>();
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietHoaDon WHERE maHoaDon = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, maHoaDon);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maSanPham = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                
                ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, gia);
                danhSachChiTietHoaDon.add(chiTietHoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachChiTietHoaDon;
    }

    public int insert(ChiTietHoaDon t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "INSERT INTO ChiTietHoaDon VALUES(?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, t.getMaHoaDon());
            pst.setString(2, t.getMaSanPham());
            pst.setInt(3, t.getSoLuong());
            pst.setDouble(4, t.getGia());
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    public int delete(String maHoaDon) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "DELETE FROM ChiTietHoaDon WHERE maHoaDon = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, maHoaDon);
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }
    
}
