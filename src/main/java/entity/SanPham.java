/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author pc
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String danhMuc;
    private String maNCC;
    private double gia;
    private String donViTinh;
    private int soLuong;
    private String tacGia;
    private int soTrang;
    private int namXuatBan;
    private String nhaXuatBan;
    private String moTa;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String danhMuc, String maNCC, double gia, String donViTinh, int soLuong, String tacGia, int soTrang, int namXuatBan, String nhaXuatBan, String moTa) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.danhMuc = danhMuc;
        this.maNCC = maNCC;
        this.gia = gia;
        this.donViTinh = donViTinh;
        this.soLuong = soLuong;
        this.tacGia = tacGia;
        this.soTrang = soTrang;
        this.namXuatBan = namXuatBan;
        this.nhaXuatBan = nhaXuatBan;
        this.moTa = moTa;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getMaNCC() {
        return maNCC;
    }

    public void setMaNCC(String maNCC) {
        this.maNCC = maNCC;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", danhMuc=" + danhMuc + ", maNCC=" + maNCC + ", gia=" + gia + ", donViTinh=" + donViTinh + ", soLuong=" + soLuong + ", tacGia=" + tacGia + ", soTrang=" + soTrang + ", namXuatBan=" + namXuatBan + ", nhaXuatBan=" + nhaXuatBan + ", moTa=" + moTa + '}';
    }
    
    
}
