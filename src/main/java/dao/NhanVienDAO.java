/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import entity.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import connectDB.ConnectDB;

public class NhanVienDAO {

    public ArrayList<NhanVien> getAllNhanVien() {
        ArrayList<NhanVien> listNhanVien = new ArrayList<>();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT * FROM NhanVien";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listNhanVien.add(new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return listNhanVien;
    }

    public boolean themNhanVien(NhanVien nhanVien) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO NhanVien VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, nhanVien.getMaNV());
            stmt.setString(2, nhanVien.getTenNV());
            stmt.setString(3, nhanVien.getSoDienThoai());
            stmt.setString(4, nhanVien.getEmail());
            stmt.setDate(5, nhanVien.getNgaySinh());
            stmt.setString(6, nhanVien.getMaLichLamViec());
            stmt.setString(7, nhanVien.getMaTK());
            stmt.setString(8, nhanVien.getDiaChi());
            stmt.setString(9, nhanVien.getGioiTinh());
            stmt.setString(10, nhanVien.getChucVu());
            stmt.setString(11, nhanVien.getTrangThai());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return false;
    }

    public boolean capNhatNhanVien(NhanVien nhanVien) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("UPDATE NhanVien SET "
                    + "tenNV=?, soDienThoai=?, email=?, ngaySinh=?, diaChi=?, gioiTinh=?, chucVu=?, trangThai=? "
                    + "WHERE maNV=?");

            stmt.setString(1, nhanVien.getTenNV());
            stmt.setString(2, nhanVien.getSoDienThoai());
            stmt.setString(3, nhanVien.getEmail());
            stmt.setDate(4, new java.sql.Date(nhanVien.getNgaySinh().getTime()));

            stmt.setString(5, nhanVien.getDiaChi());
            stmt.setString(6, nhanVien.getGioiTinh());
            stmt.setString(7, nhanVien.getChucVu());
            stmt.setString(8, nhanVien.getTrangThai());
            stmt.setString(9, nhanVien.getMaNV());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return false;
    }

    public NhanVien searchEmployee(String maNV) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        NhanVien nhanVien = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM NhanVien WHERE maNV = ?");
            stmt.setString(1, maNV);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                nhanVien = new NhanVien(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getDate(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        }
        return nhanVien;
    }

    public String taoMaNhanVien() {
        try {
            String sql = "SELECT TOP 1 maNV FROM NhanVien ORDER BY maNV DESC";
            Statement statement = ConnectDB.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String maNV = resultSet.getString(1);
                int number = Integer.parseInt(maNV.substring(3));
                number++;
                String maNVMoi = number + "";
                while (maNVMoi.length() < 3) {
                    maNVMoi = "0" + maNVMoi;
                }

                return "NV" + maNVMoi;
            } else {
                return "NV001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
