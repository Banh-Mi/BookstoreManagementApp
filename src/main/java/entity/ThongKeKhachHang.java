
package entity;
import java.sql.Date;
public class ThongKeKhachHang {
      private String maKhachHang;
      private String tenKhachHang;
      private String sDT;
      private String gioiTinh;

      private Date ngayDangKy;
      private int soLuongDonHang;
      private double tongTien;
      private int tongSoLuongSP;

    public ThongKeKhachHang(String maKhachHang, String tenKhachHang, String sDT, String gioiTinh, Date ngayDangKy, int soLuongDonHang, double tongTien, int tongSoLuongSP) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.sDT = sDT;
        this.gioiTinh = gioiTinh;
        this.ngayDangKy = ngayDangKy;
        this.soLuongDonHang = soLuongDonHang;
        this.tongTien = tongTien;
        this.tongSoLuongSP = tongSoLuongSP;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getsDT() {
        return sDT;
    }

    public void setsDT(String sDT) {
        this.sDT = sDT;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayDangKy() {
        return ngayDangKy;
    }

    public void setNgayDangKy(Date ngayDangKy) {
        this.ngayDangKy = ngayDangKy;
    }

    public int getSoLuongDonHang() {
        return soLuongDonHang;
    }

    public void setSoLuongDonHang(int soLuongDonHang) {
        this.soLuongDonHang = soLuongDonHang;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public int getTongSoLuongSP() {
        return tongSoLuongSP;
    }

    public void setTongSoLuongSP(int tongSoLuongSP) {
        this.tongSoLuongSP = tongSoLuongSP;
    }

   
      
}
