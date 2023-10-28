/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connectDB.ConnectDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entity.PhanCaLamViec;
import entity.ThongTinPhanCaLamViec;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;

public class PhanCaLamViecDAO {

    public ArrayList<ThongTinPhanCaLamViec> getTatCaThongTin() {
        ArrayList<ThongTinPhanCaLamViec> listThongTinCaLamViec = new ArrayList<>();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "SELECT nv.maNV, nv.tenNV, nv.soDienThoai , clv.tenCa, clv.thoiGianVao, clv.thoiGianRa, llv.Ngay "
                    + "FROM NhanVien nv "
                    + "JOIN LichLamViec llv ON nv.maNV = llv.maNV "
                    + "JOIN CaLamViec clv ON llv.maCaLamViec = clv.maCaLamViec ORDER BY llv.Ngay DESC";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listThongTinCaLamViec.add(new ThongTinPhanCaLamViec(
                        rs.getString("maNV"),
                        rs.getString("tenNV"),
                        rs.getString("soDienThoai"),
                        rs.getString("tenCa"),
                        rs.getTime("thoiGianVao"),
                        rs.getTime("thoiGianRa"),
                        rs.getDate("Ngay")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối hoặc thực hiện các bước khác theo yêu cầu
        }
        return listThongTinCaLamViec;
    }

    public int phanCaLamViec(PhanCaLamViec phanCaLamViec) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call PhanCa(?,?,?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setString(1, phanCaLamViec.getMaNV());
            cstmt.setString(2, phanCaLamViec.getMaCaLamViec());
            cstmt.setDate(3, phanCaLamViec.getNgay());
            cstmt.registerOutParameter(4, java.sql.Types.INTEGER);
            cstmt.execute();
            return cstmt.getInt(4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }

    public boolean deleteCaLamViec(PhanCaLamViec phanCaLamViec) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement("DELETE FROM LichLamViec WHERE maNV = ? and maCaLamViec = ? and ngay = ? ");
            stmt.setString(1, phanCaLamViec.getMaNV());
            stmt.setString(2, phanCaLamViec.getMaCaLamViec());
            stmt.setDate(3, phanCaLamViec.getNgay());
            return stmt.executeUpdate()>0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
        }
        return false;
    }
}
