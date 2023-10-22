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
    private String maLichLamViec;
    private String maTK;
    private String diaChi;
    private String gioiTinh;
    private String chucVu;
    private String trangThai;

    // Constructor
    public NhanVien(String maNV, String tenNV, String soDienThoai, String email, Date ngaySinh,
            String maLichLamViec, String maTK, String diaChi, String gioiTinh,
            String chucVu, String trangThai) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.ngaySinh = ngaySinh;
        this.maLichLamViec = maLichLamViec;
        this.maTK = maTK;
        this.diaChi = diaChi;
        this.gioiTinh = gioiTinh;
        this.chucVu = chucVu;
        this.trangThai = trangThai;
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

    public String getMaLichLamViec() {
        return maLichLamViec;
    }

    public void setMaLichLamViec(String maLichLamViec) {
        this.maLichLamViec = maLichLamViec;
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
}
