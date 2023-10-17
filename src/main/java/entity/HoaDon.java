/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

/**
 *
 * @author pc
 */
public class HoaDon {

    private String maHoaDon;
    private String maKH;
    private String maNV;
    private String maKhuyenMai;
    private Date ngayLapHoaDon;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon, String maKH, String maNV, String maKhuyenMai, Date ngayLapHoaDon, String trangThai) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.trangThai = trangThai;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", maNV=" + maNV + ", maKhuyenMai=" + maKhuyenMai + ", ngayLapHoaDon=" + ngayLapHoaDon + ", trangThai=" + trangThai + '}';
    }

}
