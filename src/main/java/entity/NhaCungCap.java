/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;
public class NhaCungCap {
    private String maNhaCC;
    private String tenNhaCC;
    private boolean trangThai;
    private String diaChi;
    private String email;
    private String soDienThoai;
    private String tenNguoiLienHe;

    public NhaCungCap(String maNhaCC, String tenNhaCC, boolean trangThai, String diaChi, String email, String soDienThoai, String tenNguoiLienHe) {
        this.maNhaCC = maNhaCC;
        this.tenNhaCC = tenNhaCC;
        this.trangThai = trangThai;
        this.diaChi = diaChi;
        this.email = email;
        this.soDienThoai = soDienThoai;
        this.tenNguoiLienHe = tenNguoiLienHe;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getTenNhaCC() {
        return tenNhaCC;
    }

    public void setTenNhaCC(String tenNhaCC) {
        this.tenNhaCC = tenNhaCC;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenNguoiLienHe() {
        return tenNguoiLienHe;
    }

    public void setTenNguoiLienHe(String tenNguoiLienHe) {
        this.tenNguoiLienHe = tenNguoiLienHe;
    }
}

