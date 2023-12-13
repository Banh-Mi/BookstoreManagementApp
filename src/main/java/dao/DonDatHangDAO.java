package dao;

import connectDB.ConnectDB;
import entity.DonDatHang;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class DonDatHangDAO implements InterfaceDAO<DonDatHang> {

    @Override
    public ArrayList<DonDatHang> selectAll() {
        ArrayList<DonDatHang> danhSachDonDatHang = new ArrayList<>();
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM DonDatHang";
            PreparedStatement pst = c.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKH = rs.getString("maKH");
                String maNV = rs.getString("maNV");
                String maKhuyenMai = rs.getString("maKhuyenMai");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                String soDienThoai = rs.getString("soDienThoai");
                String trangThai = rs.getString("trangThai");
                String ghiChu = rs.getString("ghiChu");

                DonDatHang donDatHang = new DonDatHang(maDonHang, maKH, maNV, maKhuyenMai, ngayDatHang, soDienThoai, trangThai, ghiChu);
                danhSachDonDatHang.add(donDatHang);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachDonDatHang;
    }

    @Override
    public DonDatHang selectbyId(DonDatHang t) {
        DonDatHang donDatHang = null;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "SELECT * FROM DonDatHang WHERE maDonHang = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, t.getMaDonHang());

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                String maKH = rs.getString("maKH");
                String maNV = rs.getString("maNV");
                String maKhuyenMai = rs.getString("maKhuyenMai");
                Date ngayDatHang = rs.getDate("ngayDatHang");
                String soDienThoai = rs.getString("soDienThoai");
                String trangThai = rs.getString("trangThai");
                String ghiChu = rs.getString("ghiChu");

                donDatHang = new DonDatHang(maDonHang, maKH, maNV, maKhuyenMai, ngayDatHang, soDienThoai, trangThai, ghiChu);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return donDatHang;
    }

    @Override
    public int insert(DonDatHang t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "INSERT INTO DonDatHang VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());
            pst.setString(2, t.getMaKH());
            pst.setString(3, t.getMaNV());
            pst.setString(4, t.getMaKhuyenMai());
            pst.setDate(5, t.getNgayDatHang());
            pst.setString(6, t.getSoDienThoai());
            pst.setString(7, t.getTrangThai());
            pst.setString(8, t.getGhiChu());

            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    @Override
    public int update(DonDatHang t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "UPDATE DonDatHang SET trangThai = ? WHERE maDonHang = ?";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getTrangThai());
            pst.setString(2, t.getMaDonHang());

            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }

    @Override
    public int delete(DonDatHang t) {
        int result = 0;
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "DELETE FROM DonDatHang WHERE maDonHang = ?";

            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaDonHang());

            // Xóa các chi tiết đơn đặt hàng trước khi xóa đơn đặt hàng
            ChiTietDonDatHangDAO chiTietDonDatHangDAO = new ChiTietDonDatHangDAO();
            chiTietDonDatHangDAO.delete(t.getMaDonHang());

            result = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
        return result;
    }
    
    public String createOrderId() {
        try {
            String sql = "SELECT TOP 1 maDonHang FROM DonDatHang ORDER BY maDonHang DESC";
            PreparedStatement pst = ConnectDB.getInstance().getConnection().prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String maDonHang = rs.getString("maDonHang");
                int number = Integer.parseInt(maDonHang.substring(2));
                number = number + 1;
                String newMaDonHang = number + "";
                while (newMaDonHang.length() < 3) {
                    newMaDonHang = "0" + newMaDonHang;
                }
                return "DH" + newMaDonHang;
            } else {
                return "DH001";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
