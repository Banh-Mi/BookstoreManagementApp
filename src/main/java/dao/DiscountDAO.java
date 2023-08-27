package dao;

import connectDB.ConnectDB;
import entity.Discount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DiscountDAO {

    public ArrayList<Discount> getAllDiscount() {
        ArrayList<Discount> listDiscount = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select * from Discounts";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listDiscount.add(new Discount(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getDate(5)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDiscount;

    }

    public void insert(Discount discount) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into Discounts values(?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, discount.getDiscountID());
            stmt.setString(2, discount.getDiscountName());
            stmt.setString(3, discount.getDiscountType());
            stmt.setDate(4, discount.getStartDate());
            stmt.setDate(5, discount.getEndDate());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }

    }

    public void delete(String discountID) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "delete from Discounts where discount_id = ?";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, discountID);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
    }

    public void update(Discount discount) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("update Discounts\r\n"
                    + "set discount_name = ?,\r\n"
                    + "discount_type = ?,\r\n"
                    + "start-date = ?,\r\n"
                    + "end_date = ?\r\n"
                    + "where discount_id = ?");

            stmt.setString(1, discount.getDiscountID());
            stmt.setString(2, discount.getDiscountName());
            stmt.setDate(3, discount.getStartDate());
            stmt.setDate(4, discount.getEndDate());
            stmt.setString(5, discount.getDiscountID());

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
