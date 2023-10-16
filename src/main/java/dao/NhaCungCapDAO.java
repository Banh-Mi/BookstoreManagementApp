/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author BanhMi88
 */
import connectDB.ConnectDB;
import entity.NhaCungCap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhaCungCapDAO {

    public ArrayList<NhaCungCap> getAllNhaCungCap() {
        ArrayList<NhaCungCap> listNhaCungCap = new ArrayList<>();
        Connection con = ConnectDB.getInstance().getConnection();
        try {
            String sql = "SELECT * FROM NhaCungCap";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listNhaCungCap.add(new NhaCungCap(rs.getString("maNhaCC"), rs.getString("tenNhaCC"),
                        rs.getBoolean("trangThai"), rs.getString("diaChi"), rs.getString("email"),
                        rs.getString("soDienThoai"), rs.getString("tenNguoiLienHe")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNhaCungCap;
    }

    public boolean insert(NhaCungCap nhaCungCap) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO NhaCungCap VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nhaCungCap.getMaNhaCC());
            stmt.setString(2, nhaCungCap.getTenNhaCC());
            stmt.setBoolean(3, nhaCungCap.isTrangThai());
            stmt.setString(4, nhaCungCap.getDiaChi());
            stmt.setString(5, nhaCungCap.getEmail());
            stmt.setString(6, nhaCungCap.getSoDienThoai());
            stmt.setString(7, nhaCungCap.getTenNguoiLienHe());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
        return false;
    }

    public boolean update(NhaCungCap nhaCungCap) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE NhaCungCap SET tenNhaCC = ?, trangThai = ?, diaChi = ?, email = ?, soDienThoai = ?, tenNguoiLienHe = ? WHERE maNhaCC = ?");
            stmt.setString(1, nhaCungCap.getTenNhaCC());
            stmt.setBoolean(2, nhaCungCap.isTrangThai());
            stmt.setString(3, nhaCungCap.getDiaChi());
            stmt.setString(4, nhaCungCap.getEmail());
            stmt.setString(5, nhaCungCap.getSoDienThoai());
            stmt.setString(6, nhaCungCap.getTenNguoiLienHe());
            stmt.setString(7, nhaCungCap.getMaNhaCC());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
        return false;
    }

    public NhaCungCap searchNhaCungCap(String nhaCungCapID) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        NhaCungCap nhaCungCap = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM NhaCungCap WHERE maNhaCC = ?");
            stmt.setString(1, nhaCungCapID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nhaCungCap = new NhaCungCap(rs.getString("maNhaCC"), rs.getString("tenNhaCC"),
                        rs.getBoolean("trangThai"), rs.getString("diaChi"), rs.getString("email"),
                        rs.getString("soDienThoai"), rs.getString("tenNguoiLienHe"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nhaCungCap;
    }

    public String taoMaNCC() {
        try {
            String sql = "SELECT TOP 1 maNhaCC FROM NhaCungCap ORDER BY maNhaCC DESC";
            Statement statement = ConnectDB.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String maNhaCC = resultSet.getString(1);
                int number = Integer.parseInt(maNhaCC.substring(3));
                number++;
                String maNCCMoi = number + "";
                while (maNCCMoi.length() < 3) {
                    maNCCMoi = "0" + maNCCMoi;
                }
                return "SUP" + maNCCMoi;
            } else {
                return "SUP001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
