package dao;

import connectDB.ConnectDB;
import entity.KhachHang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhachHangDAO {

    public ArrayList<KhachHang> getAllKhachHang() {
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM KhachHang";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listKhachHang.add(new KhachHang(
                        rs.getString("maKH"),
                        rs.getString("tenKH"),
                        rs.getString("soDienThoai"),
                        rs.getString("email"),
                        rs.getDate("ngaySinh"),
                        rs.getString("diaChi"),
                        rs.getString("gioiTinh")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listKhachHang;
    }

    public void insertKhachHang(KhachHang khachHang) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO KhachHang VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, khachHang.getMaKH());
            stmt.setString(2, khachHang.getTenKH());
            stmt.setString(3, khachHang.getSoDienThoai());
            stmt.setString(4, khachHang.getEmail());
            stmt.setDate(5, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            stmt.setString(6, khachHang.getDiaChi());
            stmt.setString(7, khachHang.getGioiTinh());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public void deleteKhachHang(String maKH) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM KhachHang WHERE maKH = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, maKH);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public void updateKhachHang(KhachHang khachHang) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE KhachHang "
                    + "SET tenKH=?, soDienThoai=?, email=?, ngaySinh=?, diaChi=?, gioiTinh=? "
                    + "WHERE maKH=?");

            stmt.setString(1, khachHang.getTenKH());
            stmt.setString(2, khachHang.getSoDienThoai());
            stmt.setString(3, khachHang.getEmail());
            stmt.setDate(4, new java.sql.Date(khachHang.getNgaySinh().getTime()));
            stmt.setString(5, khachHang.getDiaChi());
            stmt.setString(6, khachHang.getGioiTinh());
            stmt.setString(7, khachHang.getMaKH());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
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

    public String taoMaKhachHang() {
        try {
            String sql = "SELECT TOP 1 maKH FROM KhachHang ORDER BY maKH DESC";
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

                return "KH" + maKHMoi;
            } else {
                return "KH001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
