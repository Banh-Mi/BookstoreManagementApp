package dao;

import connectDB.ConnectDB;
import entity.HoaDon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class HoaDonDAO implements InterfaceDAO<HoaDon>{

    @Override
    public ArrayList<HoaDon> selectAll() {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement pst = c.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maHoaDon = rs.getString("maHoaDon");
                String maKH = rs.getString("maKH");
                String maNV = rs.getString("maNV");
                String maKhuyenMai = rs.getString("maKhuyenMai");
                String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
                Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                String loaiHoaDon = rs.getString("loaiHoaDon");
                String trangThai = rs.getString("trangThai");
                String ghiChu = rs.getString("ghiChu");
                
                HoaDon hoaDon = new HoaDon(maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, loaiHoaDon, trangThai, ghiChu);
                danhSachHoaDon.add(hoaDon);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachHoaDon;
    }

    @Override
    public HoaDon selectbyId(HoaDon t) {
        HoaDon hoaDon = null;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM HoaDon WHERE maHoaDon = ?";
            PreparedStatement pst = c.prepareStatement(sql);
            
            pst.setString(1, t.getMaHoaDon());
            
            ResultSet rs = pst.executeQuery();
            while(rs.next()){
                String maHoaDon = rs.getString("maHoaDon");
                String maKH = rs.getString("maKH");
                String maNV = rs.getString("maNV");
                String maKhuyenMai = rs.getString("maKhuyenMai");
                String phuongThucThanhToan = rs.getString("phuongThucThanhToan");
                Date ngayLapHoaDon = rs.getDate("ngayLapHoaDon");
                String loaiHoaDon = rs.getString("loaiHoaDon");
                String trangThai = rs.getString("trangThai");
                String ghiChu = rs.getString("ghiChu");
                
                hoaDon = new HoaDon(maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, loaiHoaDon, trangThai, ghiChu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return hoaDon;
    }

    @Override
    public int insert(HoaDon t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "INSERT INTO HoaDon VALUES(?, ?, ?, ?, ?, ?,?, ?, ?)";
            
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaHoaDon());
            pst.setString(2, t.getMaKH());
            pst.setString(3, t.getMaNV());
            pst.setString(4, t.getMaKhuyenMai());
            pst.setString(5, t.getPhuongThucThanhToan());
            pst.setDate(6, t.getNgayLapHoaDon());
            pst.setString(7, t.getLoaiHoaDon());
            pst.setString(8, t.getTrangThai());
            pst.setString(9, t.getGhiChu());
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    @Override
    public int update(HoaDon t) {
        return 0;
    }

    @Override
    public int delete(HoaDon t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "DELETE FROM HoaDon WHERE maHoaDon = ?";
            
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaHoaDon());
            
            // Xóa các chi tiết hóa đơn trước khi xóa hóa đơn
            ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
            chiTietHoaDonDAO.delete(t.getMaHoaDon());
            
            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }
    
}
