package Dao;

import connectDB.ConnectDB;
import entity.taikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
                taiKhoan.setMataikhoan(rs.getString("mataikhoan"));
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
    public ArrayList<taikhoan> getAllHocVien()
    {
        ArrayList<taikhoan> dstaikhoan = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
			String sql="select * from tai_khoan";
			Statement statement = con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) 
			{
                                dstaikhoan.add(new taikhoan(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getBoolean(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dstaikhoan;
        
    }
    public void them(taikhoan tk) 
	{
            Connection con = ConnectDB.getInstance().getConnection();
            PreparedStatement stmt = null;
		String sql="insert into tai_khoan values(?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, tk.getMataikhoan());
			stmt.setString(2, tk.getTendangnhap());
			stmt.setString(3, tk.getMatkhau());
                        stmt.setString(3, tk.getQuyen());
                        stmt.setBoolean(4, tk.isTinhtrang());
			stmt.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
                finally
                {
                    close(stmt);
                }
		
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
    public void close(PreparedStatement stmt) 
	{
		if(stmt!=null) 
		{
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
//    public void updateNV(hocvien hv) {
//		Connection con = ConnectDB.getInstance().getConnection();
//		PreparedStatement stmt = null;
//		try {
//			
//			stmt = con.prepareStatement("update QLHV1\r\n"
//					+ "set tenhocvien = ?,\r\n"
//					+ "diachi = ? ,\r\n"
//					+ "sodienthoai = ?\r\n"
//					+ "where mahocvien = ?");
//			
//			stmt.setString(1, hv.getTenhocvien());
//                        stmt.setString(2, hv.getDiachi());
//                        stmt.setString(3, hv.getSodienthoai());
//			stmt.setString(4, hv.getMahocvien());
//			stmt.executeUpdate();
//		} catch (SQLException ex) {
//			ex.printStackTrace();
//		}
//		finally {
//			close(stmt);
//		}
//	}

}