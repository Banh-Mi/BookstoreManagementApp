/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author BanhMi88
 */
public class NhanVien {

    private String maNV;
    private String tenNV;
    private String soDienThoai;
    private String email;
    private Date ngaySinh;
    private String maTK;
    private String diaChi;
    private String gioiTinh;
    private String chucVu;
    private String trangThai;
    private Date ngayVaoLam;
    private int luong;

    public NhanVien() {
    }

    // Constructor
    public NhanVien(String maNV, String tenNV, String soDienThoai, String email, Date ngaySinh,
            String maTK, String diaChi, String gioiTinh,
            String chucVu, String trangThai,Date ngayVaoLam,int luong) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.maTK = maTK;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.ngayVaoLam=ngayVaoLam;
        this.luong=luong;
    }

    public NhanVien(String maNV, String tenNV, String soDienThoai, String email, String diaChi, String gioiTinh, String chucVu, String trangThai, Date ngaySinh) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
        this.ngaySinh = ngaySinh;
    }

    public NhanVien(String maNV, String tenNV, String soDienThoai, String email, Date ngaySinh,
            String diaChi, String gioiTinh,
            String chucVu, String trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;

        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
    }

    // Getters and Setters
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayVaoLam() {
        return ngayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        this.ngayVaoLam = ngayVaoLam;
    }

    public int getLuong() {
        return luong;
    }

    public void setLuong(int luong) {
        this.luong = luong;
    }
    
}
