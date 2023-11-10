package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class KhuyenMaiDAO {

    public ArrayList<KhuyenMai> getAllKhuyenMai() {
        ArrayList<KhuyenMai> listKhuyenMai = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM KhuyenMai";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listKhuyenMai.add(new KhuyenMai(
                        rs.getString("maKhuyenMai"),
                        rs.getString("tenChuongTrinh"),
                        rs.getFloat("phanTramKhuyenMai"),
                        rs.getDate("ngayBatDau"),
                        rs.getDate("ngayKetThuc"),
                        rs.getString("moTa")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listKhuyenMai;
    }

    public KhuyenMai getKhuyenMaiById(String id) {
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM KhuyenMai WHERE maKhuyenMai = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, id);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                String maKhuyenMai = rs.getString("maKhuyenMai");
                String tenChuongTrinh = rs.getString("tenChuongTrinh");
                float phanTramKhuyenMai = rs.getFloat("phanTramKhuyenMai");
                java.sql.Date ngayBatDau = rs.getDate("ngayBatDau");
                java.sql.Date ngayKetThuc = rs.getDate("ngayKetThuc");
                String moTa = rs.getString("moTa");

                KhuyenMai khuyenMai = new KhuyenMai(maKhuyenMai, tenChuongTrinh, phanTramKhuyenMai, ngayBatDau, ngayKetThuc, moTa);
                return khuyenMai;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public boolean insertKhuyenMai(KhuyenMai khuyenMai) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO KhuyenMai VALUES(?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, taoMaKhuyenMai());
            stmt.setString(2, khuyenMai.getTenChuongTrinh());
            stmt.setFloat(3, khuyenMai.getPhanTramKhuyenMai());
            stmt.setDate(4, new java.sql.Date(khuyenMai.getNgayBatDau().getTime()));
            stmt.setDate(5, new java.sql.Date(khuyenMai.getNgayKetThuc().getTime()));
            stmt.setString(6, khuyenMai.getMoTa());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
        return false;
    }

    public void deletekhuyenmai(String maKM) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM KhuyenMai WHERE maKhuyenMai = ?";
        try {
            // Tắt tất cả ràng buộc trên tất cả bảng
            String disableConstraintsSQL = "EXEC sp_MSforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL'";
            stmt = con.prepareStatement(disableConstraintsSQL);
            stmt.executeUpdate();

            // Tiến hành xóa dữ liệu
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maKM);
            stmt.executeUpdate();

            // Bật lại tất cả ràng buộc trên tất cả bảng
            String enableConstraintsSQL = "EXEC sp_MSforeachtable 'ALTER TABLE ? CHECK CONSTRAINT ALL'";
            stmt = con.prepareStatement(enableConstraintsSQL);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public void updatekhuyenmai(KhuyenMai khuyenMai) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE KhuyenMai "
                    + "SET tenChuongTrinh=?, phanTramKhuyenMai=?, ngayBatDau=?, ngayKetThuc=?, moTa=? "
                    + " WHERE maKhuyenMai=?");

            stmt.setString(1, khuyenMai.getTenChuongTrinh());
            stmt.setFloat(2, khuyenMai.getPhanTramKhuyenMai());
            stmt.setDate(3, new java.sql.Date(khuyenMai.getNgayBatDau().getTime()));
            stmt.setDate(4, new java.sql.Date(khuyenMai.getNgayKetThuc().getTime()));
            stmt.setString(5, khuyenMai.getMoTa());
            stmt.setString(6, khuyenMai.getMaKhuyenMai());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public String taoMaKhuyenMai() {
        try {
            String sql = "SELECT TOP 1 maKhuyenMai FROM KhuyenMai ORDER BY maKhuyenMai DESC";
            Statement statement = ConnectDB.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String maKH = resultSet.getString(1);
                int number = Integer.parseInt(maKH.substring(3));
                number++;
                String maKHMoi = number + "";
                while (maKHMoi.length() < 3) {
                    maKHMoi = "0" + maKHMoi;
                }

                return "KM" + maKHMoi;
            } else {
                return "KM001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public KhuyenMai getPromotionEnable() {
        ArrayList<KhuyenMai> danhSachKhuyenMai = new ArrayList<>();
        try {
            String sql = "SELECT * FROM KhuyenMai WHERE ngayBatDau <= CAST(GETDATE() AS DATE) AND ngayKetThuc >= CAST(GETDATE() AS DATE)";
            Statement statement = ConnectDB.getInstance().getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                String maKhuyenMai = rs.getString("maKhuyenMai");
                String tenChuongTrinh = rs.getString("tenChuongTrinh");
                float phanTramKhuyenMai = rs.getFloat("phanTramKhuyenMai");
                java.sql.Date ngayBatDau = rs.getDate("ngayBatDau");
                java.sql.Date ngayKetThuc = rs.getDate("ngayKetThuc");
                String moTa = rs.getString("moTa");

                KhuyenMai khuyenMai = new KhuyenMai(maKhuyenMai, tenChuongTrinh, phanTramKhuyenMai, ngayBatDau, ngayKetThuc, moTa);
                danhSachKhuyenMai.add(khuyenMai);
            }

            if (danhSachKhuyenMai.size() > 1) {
                KhuyenMai khuyenMaiMax = danhSachKhuyenMai.get(0);
                for (KhuyenMai khuyenMai : danhSachKhuyenMai) {
                    if (khuyenMai.getPhanTramKhuyenMai() > khuyenMaiMax.getPhanTramKhuyenMai()) {
                        khuyenMaiMax = khuyenMai;
                    }
                }
                return khuyenMaiMax;
            }
            if (danhSachKhuyenMai.size() == 1) {
                return danhSachKhuyenMai.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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
