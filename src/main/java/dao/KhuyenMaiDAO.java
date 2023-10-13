package dao;

import connectDB.ConnectDB;
import entity.KhuyenMai;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

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

    public boolean insertKhuyenMai(KhuyenMai khuyenMai) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO KhuyenMai VALUES(?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, khuyenMai.getMaKhuyenMai());
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
