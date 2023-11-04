/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author BanhMi88
 */
public class ThongKeDoanhThuNhanVien {

    private String maNV;
    private String tenNV;
    private int soLuongDonHang;
    private double tongTien;
    private double giamGia;
    private double thanhTien;

    public ThongKeDoanhThuNhanVien(String maNV, String tenNV, int soLuongDonHang, double tongTien, double giamGia, double thanhTien) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soLuongDonHang = soLuongDonHang;
        this.tongTien = tongTien;
        this.giamGia = giamGia;
        this.thanhTien = thanhTien;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getTenNV() {
        return tenNV;
    }

    public void setTenNV(String tenNV) {
        this.tenNV = tenNV;
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
