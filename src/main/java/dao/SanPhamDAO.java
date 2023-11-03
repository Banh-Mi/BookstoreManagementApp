package dao;

import entity.SanPham;
import java.sql.Connection;
import java.util.ArrayList;
import connectDB.ConnectDB;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class SanPhamDAO implements InterfaceDAO<SanPham> {

    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try {
            Connection c = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String danhMuc = rs.getString("danhMuc");
                String maNhaCC = rs.getString("maNhaCC");
                double gia = rs.getDouble("gia");
                String donViTinh = rs.getString("donViTinh");
                int soLuong = rs.getInt("soLuong");
                String tacGia = rs.getString("tacGia");
                int soTrang = rs.getInt("soTrang");
                int namXuatBan = rs.getInt("namXuatBan");
                String nhaXuatBan = rs.getString("nhaXuatBan");
                String hinhAnh = rs.getString("hinhAnh");
                String moTa = rs.getString("moTa");
                boolean trangThai = rs.getBoolean("trangThai");

                SanPham sanPham = new SanPham(maSanPham, tenSanPham, danhMuc, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa, trangThai);
                danhSachSanPham.add(sanPham);

            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachSanPham;
    }

    @Override
    public SanPham selectbyId(SanPham t) {
        SanPham sanPham = null;
        try {
            Connection c = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham WHERE maSanPham = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, t.getMaSanPham());
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String danhMuc = rs.getString("danhMuc");
                String maNhaCC = rs.getString("maNhaCC");
                double gia = rs.getDouble("gia");
                String donViTinh = rs.getString("donViTinh");
                int soLuong = rs.getInt("soLuong");
                String tacGia = rs.getString("tacGia");
                int soTrang = rs.getInt("soTrang");
                int namXuatBan = rs.getInt("namXuatBan");
                String nhaXuatBan = rs.getString("nhaXuatBan");
                String hinhAnh = rs.getString("hinhAnh");
                String moTa = rs.getString("moTa");
                boolean trangThai = rs.getBoolean("trangThai");

                sanPham = new SanPham(maSanPham, tenSanPham, danhMuc, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa, trangThai);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return sanPham;
    }

    @Override
    public int insert(SanPham t) {
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "INSERT INTO SanPham (maSanPham, tenSanPham, danhMuc, maNhaCC, donViTinh, soLuong, tacGia, nhaXuatBan, namXuatBan, soTrang, gia, hinhAnh, moTa, trangThai)"
                    + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = c.prepareStatement(sql);
            pst.setString(1, t.getMaSanPham());
            pst.setString(2, t.getTenSanPham());
            pst.setString(3, t.getDanhMuc());
            pst.setString(4, t.getMaNhaCC());
            pst.setString(5, t.getDonViTinh());
            pst.setInt(6, t.getSoLuong());
            pst.setDouble(11, t.getGia());
            pst.setString(12, t.getHinhAnh());
            pst.setString(13, t.getMoTa());
            pst.setBoolean(14, true);
            if (t.getDanhMuc().equals("Sách")) {
                pst.setString(7, t.getTacGia());
                pst.setString(8, t.getNhaXuatBan());
                pst.setInt(9, t.getNamXuatBan());
                pst.setInt(10, t.getSoTrang());
            } else {
                pst.setNull(7, Types.NVARCHAR);
                pst.setNull(8, Types.NVARCHAR);
                pst.setNull(9, Types.INTEGER);
                pst.setNull(10, Types.INTEGER);
            }
            int result = pst.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override
    public int update(SanPham t) {
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "UPDATE SanPham SET tenSanPham = ?, danhMuc = ?, maNhaCC = ?, donViTinh = ?, soLuong = ?, tacGia = ?, nhaXuatBan = ?, namXuatBan = ?, soTrang = ?, gia = ?, hinhAnh = ?, moTa = ?, trangThai = ? WHERE maSanPham = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setString(1, t.getTenSanPham());
            pst.setString(2, t.getDanhMuc());
            pst.setString(3, t.getMaNhaCC());
            pst.setString(4, t.getDonViTinh());
            pst.setInt(5, t.getSoLuong());
            pst.setDouble(10, t.getGia());
            pst.setString(11, t.getHinhAnh());
            pst.setString(12, t.getMoTa());
            pst.setBoolean(13, t.isTrangThai());
            pst.setString(14, t.getMaSanPham());
            if (t.getDanhMuc().equals("Sách")) {
                pst.setString(6, t.getTacGia());
                pst.setString(7, t.getNhaXuatBan());
                pst.setInt(8, t.getNamXuatBan());
                pst.setInt(9, t.getSoTrang());
            } else {
                pst.setNull(6, Types.NVARCHAR);
                pst.setNull(7, Types.NVARCHAR);
                pst.setNull(8, Types.INTEGER);
                pst.setNull(9, Types.INTEGER);
            }
            int result = pst.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    public ArrayList<SanPham> layTheoDanhMuc(String danhMuc) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call TimSanPham(@danhMuc = ?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setString(1, danhMuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String danhMucSP = rs.getString("danhMuc");
                String maNhaCC = rs.getString("maNhaCC");
                double gia = rs.getDouble("gia");
                String donViTinh = rs.getString("donViTinh");
                int soLuong = rs.getInt("soLuong");
                String tacGia = rs.getString("tacGia");
                int soTrang = rs.getInt("soTrang");
                int namXuatBan = rs.getInt("namXuatBan");
                String nhaXuatBan = rs.getString("nhaXuatBan");
                String hinhAnh = rs.getString("hinhAnh");
                String moTa = rs.getString("moTa");
                boolean trangThai = rs.getBoolean("trangThai");
                SanPham sanPham = new SanPham(maSanPham, tenSanPham, danhMucSP, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa, trangThai);
                danhSachSanPham.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }

    public ArrayList<SanPham> timSanPham(SanPham sanPhamLoc, String trangThaiLoc) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call TimSanPham(?,?,?,?,?,?,?,?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setString(1, sanPhamLoc.getMaSanPham());
            cstmt.setString(2, sanPhamLoc.getTenSanPham());
            cstmt.setString(3, sanPhamLoc.getDanhMuc());
            cstmt.setString(4, trangThaiLoc);
            cstmt.setString(5, sanPhamLoc.getGia() == -1 ? null : sanPhamLoc.getGia() + "");
            cstmt.setString(6, sanPhamLoc.getNhaXuatBan());
            cstmt.setString(7, sanPhamLoc.getSoTrang() == -1 ? null : sanPhamLoc.getSoTrang() + "");
            cstmt.setString(8, sanPhamLoc.getNamXuatBan() == -1 ? null : sanPhamLoc.getNamXuatBan() + "");
            cstmt.setString(9, sanPhamLoc.getTacGia());
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                String maSanPham = rs.getString("maSanPham");
                String tenSanPham = rs.getString("tenSanPham");
                String danhMucSP = rs.getString("danhMuc");
                String maNhaCC = rs.getString("maNhaCC");
                double gia = rs.getDouble("gia");
                String donViTinh = rs.getString("donViTinh");
                int soLuong = rs.getInt("soLuong");
                String tacGia = rs.getString("tacGia");
                int soTrang = rs.getInt("soTrang");
                int namXuatBan = rs.getInt("namXuatBan");
                String nhaXuatBan = rs.getString("nhaXuatBan");
                String hinhAnh = rs.getString("hinhAnh");
                String moTa = rs.getString("moTa");
                boolean trangThai = rs.getBoolean("trangThai");
                SanPham sanPham = new SanPham(maSanPham, tenSanPham, danhMucSP, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa, trangThai);
                danhSachSanPham.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachSanPham;
    }

    @Override
    public int delete(SanPham t) {
        try {
            Connection c = ConnectDB.getConnection();
            String sql = "UPDATE SanPham SET trangThai = ? WHERE maSanPham = ?";
            PreparedStatement pst = c.prepareStatement(sql);

            pst.setBoolean(1, false);
            pst.setString(2, t.getMaSanPham());
            int result = pst.executeUpdate();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    public int themTuExcell(SanPham sanPham) {
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        CallableStatement cstmt = null;
        try {
            String sql = "{call InsertProduct(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setString(1, sanPham.getMaSanPham());
            cstmt.setString(2, sanPham.getTenSanPham());
            cstmt.setString(3, sanPham.getDanhMuc());
            cstmt.setString(4, sanPham.getMaNhaCC());
            cstmt.setDouble(5, sanPham.getGia());
            cstmt.setString(6, sanPham.getDonViTinh());
            cstmt.setInt(7, sanPham.getSoLuong());
            cstmt.setString(8, sanPham.getHinhAnh());
            cstmt.setBoolean(9, sanPham.isTrangThai());
            cstmt.setString(10, sanPham.getMoTa());
            if (sanPham.getDanhMuc().equals("Sách")) {
                cstmt.setInt(11, sanPham.getSoTrang());
                cstmt.setInt(12, sanPham.getNamXuatBan());
                cstmt.setString(13, sanPham.getNhaXuatBan());
                cstmt.setString(14, sanPham.getTacGia());
            } else {
                cstmt.setNull(11, Types.NVARCHAR);
                cstmt.setNull(12, Types.NVARCHAR);
                cstmt.setNull(13, Types.INTEGER);
                cstmt.setNull(14, Types.INTEGER);
            }
            cstmt.registerOutParameter(15, java.sql.Types.INTEGER);
            cstmt.execute();
            return cstmt.getInt(15);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return 0;
    }
}
