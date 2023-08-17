
package Dao;

import connectDB.ConnectDB;
import model.taikhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TaiKhoanDAOImpl implements TaiKhoanDAO{
    @Override
    public taikhoan login(String tdn, String mk) {
        ConnectDB.getInstance();
        Connection cons = ConnectDB.getConnection();
       // Connection cons = ConnectDB.getInstance().getConnection();
     String sql = "SELECT * FROM tai_khoan where tendangnhap like ? AND matkhau like ?";
     taikhoan taikhoan1 = null;
        try {
            PreparedStatement ps = cons.prepareStatement(sql);
            ps.setString(1, tdn);
            ps.setString(2, mk);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                taikhoan1 = new taikhoan();
                taikhoan1.setMataikhoan(rs.getInt("mataikhoan"));
                taikhoan1.setTendangnhap(rs.getString("tendangnhap"));
                taikhoan1.setMatkhau(rs.getString("matkhau"));
                taikhoan1.setTinhtrang(rs.getBoolean("tinhtrang"));
            
            } 
            ps.close();
            cons.close();
            return taikhoan1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
