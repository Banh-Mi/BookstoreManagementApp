package dao;

import entity.SanPham;
import java.sql.Connection;
import java.util.ArrayList;
import connectDB.ConnectDB;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class SanPhamDAO implements InterfaceDAO<SanPham>{

    @Override
    public ArrayList<SanPham> selectAll() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        try {
            Connection c = ConnectDB.getInstance().getConnection();
            String sql = "SELECT * FROM SanPham";
            PreparedStatement pst = c.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();
            
            while(rs.next()){
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
                
                SanPham sanPham = new SanPham(maSanPham, tenSanPham, danhMuc, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa);
                danhSachSanPham.add(sanPham);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return danhSachSanPham;
    }

    @Override
    public SanPham selectbyId(String id) {
        return null;
    }

    @Override
    public int insert(SanPham t) {
        return 0;
    }

    @Override
    public int update(SanPham t) {
        return 0;
    }

    @Override
    public int delete(SanPham t) {
        return 0;
    }
    
}
