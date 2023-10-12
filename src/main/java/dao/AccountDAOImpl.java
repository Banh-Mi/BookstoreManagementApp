package dao;

import connectDB.ConnectDB;
import entity.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public Account login(String  userName, String  password) {
        ConnectDB.getInstance();
        Connection cons = ConnectDB.getConnection();
        String sql = "SELECT * FROM Accounts WHERE username LIKE ? AND password LIKE ?";
        Account account = null;
        try {
            try (PreparedStatement ps = (PreparedStatement) cons.prepareStatement(sql)) {
                ps.setString(1,  userName);
                ps.setString(2,  password);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    account = new Account();
                    account.setAccountID(rs.getString("account_id"));
                    account.setUserName(rs.getString("username"));
                    account.setPassword(rs.getString("password"));
                    account.setStatus(rs.getBoolean("status"));
                }
            }
            return account;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public ArrayList<Account> getAllHocVien()
    {
        ArrayList<Account> listAccount = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
			String sql="select * from Accounts";
			Statement statement = con.createStatement();
			ResultSet rs =statement.executeQuery(sql);
			while(rs.next()) 
			{
                                listAccount.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3),rs.getString(4), rs.getBoolean(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listAccount;
        
    }
    public void insert(Account account) 
	{
            Connection con = ConnectDB.getInstance().getConnection();
            PreparedStatement stmt = null;
		String sql="insert into Accounts values(?,?,?,?,?)";
		try {
			stmt=con.prepareStatement(sql);
			stmt.setString(1, account.getAccountID());
			stmt.setString(2, account.getUserName());
			stmt.setString(3, account.getPassword());
                        stmt.setString(3, account.getRole());
                        stmt.setBoolean(4, account.isStatus());
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