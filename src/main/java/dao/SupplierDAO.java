/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 *
 * @author BanhMi88
 */
import connectDB.ConnectDB;
import entity.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SupplierDAO {

    public ArrayList<Supplier> getAllSupplier() {
        ArrayList<Supplier> listSupplier = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        try {
            String sql = "select * from Suppliers";
            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                listSupplier.add(new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSupplier;

    }

    public boolean insert(Supplier supplier) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into Suppliers values(?,?,?,?,?,?,?)";
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, supplier.getSupplierID());
            stmt.setString(2, supplier.getSupplierName());
            stmt.setString(3, supplier.getAddress());
            stmt.setString(4, supplier.getContactPerson());
            stmt.setString(5, supplier.getPhone());
            stmt.setString(6, supplier.getEmail());
            stmt.setInt(7, supplier.getStatus());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            close(stmt);
        }
        return false;
    }

//    public boolean delete(String supplierID) {
//        Connection con = ConnectDB.getInstance().getConnection();
//        PreparedStatement stmt = null;
//        String sql = "Delete from Suppliers where supplier_id = ?";
//        try {
//            stmt = con.prepareStatement(sql);
//            stmt.setString(1, supplierID);
//            return stmt.executeUpdate()>0;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        } finally {
//            close(stmt);
//        }
//        return false;
//    }
    public boolean update(Supplier supplier) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        try {

            stmt = con.prepareStatement("Update Suppliers\r\n"
                    + "set supplier_name = ?,\r\n"
                    + "address = ?,\r\n"
                    + "contact_person = ?,\r\n"
                    + "phone = ?,\r\n"
                    + "email = ?\r\n,"
                    + "status = ?\r\n"
                    + "where supplier_id = ?");
            stmt.setString(1, supplier.getSupplierName());
            stmt.setString(2, supplier.getAddress());
            stmt.setString(3, supplier.getContactPerson());
            stmt.setString(4, supplier.getPhone());
            stmt.setString(5, supplier.getEmail());
            stmt.setInt(6, supplier.getStatus());
            stmt.setString(7, supplier.getSupplierID());
            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            close(stmt);
        }
        return false;
    }

    public Supplier searchSupplier(String supplierID) {
        Connection con = ConnectDB.getInstance().getConnection();
        PreparedStatement stmt = null;
        Supplier supplier = null;
        try {
            stmt = con.prepareStatement("SELECT * FROM Suppliers WHERE supplier_id = ?");
            stmt.setString(1, supplierID);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                supplier = new Supplier(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return supplier;

    }

    public String createSupplierID() {
        try {
            String sql = "SELECT TOP 1 supplier_id FROM Suppliers ORDER BY supplier_id DESC";
            Statement statement = ConnectDB.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                String supplier_id = resultSet.getString(1);
                int number = Integer.parseInt(supplier_id.substring(3));
                number++;
                String supplier_idNew = number + "";
                while (supplier_idNew.length() < 3) {
                    supplier_idNew = "0" + supplier_idNew;
                }

                return "SUP" + supplier_idNew;
            } else {
                return "SUP001";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
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
