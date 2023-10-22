package dao;

import connectDB.ConnectDB;
import entity.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class TaiKhoanDAO {

    public TaiKhoan login(String userName, String password) {
        ConnectDB.getInstance();
        Connection cons = ConnectDB.getConnection();
        String sql = "SELECT * FROM TaiKhoan WHERE tenDangNhap LIKE ? AND matKhau LIKE ?";
        TaiKhoan account = null;
        try {
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ps.setString(1, userName);
                ps.setString(2, password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    account = new TaiKhoan();
                    account.setMaTK(rs.getString("maTK"));
                    account.setTenDangNhap(rs.getString("tenDangNhap"));
                    account.setMaTK(rs.getString("matKhau"));
                    account.setQuyen(rs.getString("quyen"));
                    account.setTrangThaiTaiKhoan(rs.getString("trangThaiTaiKhoan"));
                }
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<TaiKhoan> getAllTaiKhoan() {
        ArrayList<TaiKhoan> listAccount = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select * from TaiKhoan";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listAccount.add(new TaiKhoan(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAccount;

    }

    public boolean insert(TaiKhoan account) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into TaiKhoan values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, account.getMaTK());
            stmt.setString(2, account.getTenDangNhap());
            stmt.setString(3, account.getMatKhau());
            stmt.setString(4, account.getQuyen());
            stmt.setString(5, account.getTrangThaiTaiKhoan());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        } finally {
            close(stmt);
        }
    }

    public String taMaTK() {
        try {
            String sql = "SELECT TOP 1 maTK FROM TaiKhoan ORDER BY maTK DESC";
            Statement statement = ConnectDB.getInstance().getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String maTK = resultSet.getString(1);
                int number = Integer.parseInt(maTK.substring(3));
                number++;
                String maTKMoi = number + "";
                while (maTKMoi.length() < 3) {
                    maTKMoi = "0" + maTKMoi;
                }

                return "TK" + maTKMoi;
            } else {
                return "TK001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
//    public void xoa(String mahocvien) 
//	{
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt =null;
//		String sql="delete from QLHV1 where mahocvien = ?";
//		try {
//			stmt=con.prepareStatement(sql);
//			stmt.setString(1, mahocvien);
//			stmt.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			close(stmt);
//		}
//	}

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
