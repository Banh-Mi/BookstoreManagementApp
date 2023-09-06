
package dao;
import connectDB.ConnectDB;
import entity.Discount;
import entity.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
public class KhachHangDAO {
   public ArrayList<Customer> getAllKh()
   {
      ArrayList<Customer> listkh = new ArrayList<>();
      ConnectDB.getInstance();
      Connection con = ConnectDB.getConnection();
      try {
            String sql = "select * from Customers";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listkh.add(new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getDate(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listkh;
   }
   public void insert(Customer kh) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into Customers values(?,?,?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, kh.getCustomer_id());
            stmt.setString(2, kh.getFullName());
            stmt.setString(3, kh.getPhone());
            stmt.setString(4, kh.getEmail());
            stmt.setString(5, kh.getGender());
            stmt.setInt(6, kh.getTotal_spending());
            stmt.setDate(7, kh.getDayOfBirth());
            stmt.setString(8, kh.getAddress());
            stmt.setString(9, kh.getCountry());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }

    }
   public void delete(String customer_id) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from Customers where customer_id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, customer_id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }
   public void update(Customer kh) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("UPDATE Customers " +
                                         "SET fullName = ?, " +
                                          "phone = ?, " +
                                        "email = ?, " +
                                        "gender = ?, " +
                                        "total_spending = ?, " +
                                        "dayOfBirth = ?, " +
                                         "address = ?, " +
                                         "country = ? " +
                                        "WHERE customer_id = ?");

            
            stmt.setString(1, kh.getFullName());
            stmt.setString(2, kh.getPhone());
            stmt.setString(3, kh.getEmail());
            stmt.setString(4, kh.getGender());
            stmt.setInt(5, kh.getTotal_spending());
            stmt.setDate(6, kh.getDayOfBirth());
            stmt.setString(7, kh.getAddress());
            stmt.setString(8, kh.getCountry());
            stmt.setString(9, kh.getCustomer_id());
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
