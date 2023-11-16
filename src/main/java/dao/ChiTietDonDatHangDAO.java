package dao;

import connectDB.ConnectDB;
import entity.ChiTietDonDatHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ChiTietDonDatHangDAO {
    public ArrayList<ChiTietDonDatHang> selectbyId(String maDonHang) {
        ArrayList<ChiTietDonDatHang> danhSachChiTietDonDatHang = new ArrayList<>();
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM ChiTietDonDatHang WHERE maDonHang = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, maDonHang);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maSanPham = rs.getString("maSanPham");
                int soLuong = rs.getInt("soLuong");
                double gia = rs.getDouble("gia");
                
                ChiTietDonDatHang chiTietDonDatHang = new ChiTietDonDatHang(maDonHang, maSanPham, soLuong, gia);
                danhSachChiTietDonDatHang.add(chiTietDonDatHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachChiTietDonDatHang;
    }

    public int insert(ChiTietDonDatHang t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "INSERT INTO ChiTietDonDatHang VALUES(?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, t.getMaDonDatHang());
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

    public int delete(String maDonHang) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "DELETE FROM ChiTietDonDatHang WHERE maDonHang = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, maDonHang);
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }
}
