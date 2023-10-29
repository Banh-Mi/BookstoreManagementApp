
package entity;

import java.sql.Date;

public class ThongKeDoanhThu {
       private String maHoaDon;
    private String tenNV;
    private String tenKH;
    private Date ngayLapHoaDon;
    private double tongTien;
    private double giamGia;
    private double thanhTien;

    public ThongKeDoanhThu(String maHoaDon, String tenNV, String tenKH, Date ngayLapHoaDon, double tongTien, double giamGia, double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.tenNV = tenNV;
        this.tenKH = tenKH;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }

    public double getGiamGia() {
        return giamGia;
    }

    public void setGiamGia(double giamGia) {
        this.giamGia = giamGia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
}
