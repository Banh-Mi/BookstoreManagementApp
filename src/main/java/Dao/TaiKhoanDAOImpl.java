package Dao;

import connectDB.ConnectDB;
import model.taikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanDAOImpl implements TaiKhoanDAO {

    @Override
    public taikhoan login(String tenDangNhap, String matKhau) {
        ConnectDB.getInstance();
        Connection cons = ConnectDB.getConnection();
        String sql = "SELECT * FROM tai_khoan WHERE tendangnhap LIKE ? AND matkhau LIKE ?";
        taikhoan taiKhoan = null;
        try {
            PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql);
            ps.setString(1, tenDangNhap);
            ps.setString(2, matKhau);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                taiKhoan = new taikhoan();
                taiKhoan.setMataikhoan(rs.getInt("mataikhoan"));
                taiKhoan.setTendangnhap(rs.getString("tendangnhap"));
                taiKhoan.setMatkhau(rs.getString("matkhau"));
                taiKhoan.setTinhtrang(rs.getBoolean("tinhtrang"));
            }           
            ps.close();
            return taiKhoan;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}