package dao;

import connectDB.ConnectDB;
import entity.DoanhThuBieuDo;
import entity.ThongKeDoanhThu;
import entity.ThongKeKhachHang;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

public class ThongKeKhachHangDAO {

    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public ArrayList<ThongKeKhachHang> getKHTuyChinh(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinh(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {

                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<DoanhThuBieuDo> getKHNamBieuDo(int nam) {
        ArrayList<DoanhThuBieuDo> listkh = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();
        PreparedStatement stmt = null;
        try {
            String sql = "SELECT "
                    + "KhachHang.maKH, "
                    + "KhachHang.tenKH, "
                    + "MONTH(HoaDon.ngayLapHoaDon) AS thang, "
                    + "SUM("
                    + "CASE "
                    + "WHEN HoaDon.maKhuyenMai IS NOT NULL THEN "
                    + "chiTietTongTien.TongTien * (1 - KhuyenMai.phanTramKhuyenMai / 100.0) "
                    + "ELSE "
                    + "chiTietTongTien.TongTien "
                    + "END "
                    + ") AS tongTien "
                    + "FROM KhachHang "
                    + "JOIN HoaDon ON KhachHang.maKH = HoaDon.maKH "
                    + "LEFT JOIN KhuyenMai ON HoaDon.maKhuyenMai = KhuyenMai.maKhuyenMai "
                    + "LEFT JOIN ("
                    + "SELECT ChiTietHoaDon.maHoaDon, SUM(soLuong * gia) AS TongTien "
                    + "FROM ChiTietHoaDon "
                    + "GROUP BY ChiTietHoaDon.maHoaDon "
                    + ") chiTietTongTien ON HoaDon.maHoaDon = chiTietTongTien.maHoaDon "
                    + "WHERE YEAR(HoaDon.ngayLapHoaDon) = ? "
                    + "GROUP BY KhachHang.maKH, KhachHang.tenKH, MONTH(HoaDon.ngayLapHoaDon) "
                    + "ORDER BY thang;";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, nam);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                listkh.add(new DoanhThuBieuDo(rs.getInt(3), rs.getDouble(4)));
            }
        } catch (Exception e) {
        }
        return listkh;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNam(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNam(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }
/////////////////////////////////////////////////////////////////////Top 5 khách hàng tổng chi cao nhất

    public ArrayList<ThongKeKhachHang> getKHTuyChinhTongChiCaoNhat(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhTongChiCaoNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamTongChiCaoNhat(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamTongChiCaoNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }
/////////////////////////////////////////////////////////////////////Top 5 khách hàng tổng chi thấp nhất

    public ArrayList<ThongKeKhachHang> getKHTuyChinhTongChiThapNhat(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhTongChiThapNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamTongChiThapNhat(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamTongChiThapNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }

    /////////////////////////////////////////////////////////////////////Top 5 khách hàng mua hàng nhiều nhất
    public ArrayList<ThongKeKhachHang> getKHTuyChinhMuaHangNhieuNhat(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhMuaHangNhieuNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamMuaHangNhieuNhat(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamMuaHangNhieuNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }
    /////////////////////////////////////////////////////////////////////Top 5 khách hàng mua hàng ít nhất

    public ArrayList<ThongKeKhachHang> getKHTuyChinhMuaHangItNhat(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhMuaHangItNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamMuaHangItNhat(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamMuaHangItNhat(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }

    /////////////////////////////////////////////////////////////////////Top 5 khách hàng thường xuyên mua hàng
    public ArrayList<ThongKeKhachHang> getKHTuyChinhThuongXuyenMuaHang(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhThuongXuyenMuaHang(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamThuongXuyenMuaHang(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamThuongXuyenMuaHang(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
    }

    /////////////////////////////////////////////////////////////////////Top 5 khách hàng không thường xuyên mua hàng
    public ArrayList<ThongKeKhachHang> getKHTuyChinhKhongThuongXuyenMuaHang(Date ngayBatDau, Date ngayKetThuc) {
        ArrayList<ThongKeKhachHang> danhSachKhachHang = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangTuyChinhKhongThuongXuyenMuaHang(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setDate(1, ngayBatDau);
            cstmt.setDate(2, ngayKetThuc);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKhachHang.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKhachHang;
    }

    public ArrayList<ThongKeKhachHang> getKHThangNamKhongThuongXuyenMuaHang(int month, int year) {
        ArrayList<ThongKeKhachHang> danhSachKH = new ArrayList<>();
        ConnectDB.getInstance();
        Connection con = ConnectDB.getConnection();

        CallableStatement cstmt = null;
        try {
            String sql = "{call KhachHangThangNamKhongThuongXuyenMuaHang(?,?)}";
            cstmt = con.prepareCall(sql);
            cstmt.setInt(1, month);
            cstmt.setInt(2, year);
            ResultSet rs = cstmt.executeQuery();
            while (rs.next()) {
                danhSachKH.add(new ThongKeKhachHang(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7), rs.getInt(8)));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return danhSachKH;
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
