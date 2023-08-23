package Dao;

import connectDB.ConnectDB;
import entity.giamgia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class giamgiaDAO {

    public ArrayList<giamgia> getAllgiamgia() {
        ArrayList<giamgia> dsgiamgia = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select * from giamgia";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                dsgiamgia.add(new giamgia(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsgiamgia;

    }

    public void them(giamgia gg) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into giamgia values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, gg.getMagiamgia());
            stmt.setString(2, gg.getTenchuongtrinh());
            stmt.setString(3, gg.getLoaichuongtrinh());
            stmt.setDate(4, gg.getNgaybatdau());
            stmt.setDate(5, gg.getNgayketthuc());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }

    }

    public void xoa(String magiamgia) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from giamgia where magiamgia = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, magiamgia);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public void sua(giamgia gg) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("update giamgia\r\n"
                    + "set tenchuongtrinh = ?,\r\n"
                    + "loaichuongtrinh = ?,\r\n"
                    + "ngaybatdau = ?,\r\n"
                    + "ngayketthuc = ?\r\n"
                    + "where magiamgia = ?");

            stmt.setString(1, gg.getTenchuongtrinh());
            stmt.setString(2, gg.getLoaichuongtrinh());
            stmt.setDate(3, gg.getNgaybatdau());
            stmt.setDate(4, gg.getNgayketthuc());
            stmt.setString(5, gg.getMagiamgia());

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
}
