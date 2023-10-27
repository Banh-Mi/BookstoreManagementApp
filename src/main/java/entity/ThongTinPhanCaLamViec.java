/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author BanhMi88
 */
import java.sql.Time;
import java.sql.Date;

public class ThongTinPhanCaLamViec {

    private String maNV;
    private String tenNV;
    private String soDienThoai;
    private String tenCa;
    private Time thoiGianVao;
    private Time thoiGianRa;
    private Date ngay;

    public ThongTinPhanCaLamViec(String maNV, String tenNV, String soDienThoai, String tenCa, Time thoiGianVao, Time thoiGianRa, Date ngay) {
        this.maNV = maNV;
        this.tenNV = tenNV;
        this.soDienThoai = soDienThoai;
        this.tenCa = tenCa;
        this.thoiGianVao = thoiGianVao;
        this.thoiGianRa = thoiGianRa;
        this.ngay = ngay;
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

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTenCa() {
        return tenCa;
    }

    public void setTenCa(String tenCa) {
        this.tenCa = tenCa;
    }

    public Time getThoiGianVao() {
        return thoiGianVao;
    }

    public void setThoiGianVao(Time thoiGianVao) {
        this.thoiGianVao = thoiGianVao;
    }

    public Time getThoiGianRa() {
        return thoiGianRa;
    }

    public void setThoiGianRa(Time thoiGianRa) {
        this.thoiGianRa = thoiGianRa;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

}
