/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;


public class giamgia {
    private String magiamgia,tenchuongtrinh,loaichuongtrinh;
    private Date ngaybatdau;
    private Date ngayketthuc;

    public giamgia(String magiamgia, String tenchuongtrinh, String loaichuongtrinh, Date ngaybatdau, Date ng) {
        this.magiamgia = magiamgia;
        this.tenchuongtrinh = tenchuongtrinh;
        this.loaichuongtrinh = loaichuongtrinh;
        this.ngaybatdau = ngaybatdau;
        this.ngayketthuc = ng;
    }

    public String getMagiamgia() {
        return magiamgia;
    }

    public void setMagiamgia(String magiamgia) {
        this.magiamgia = magiamgia;
    }

    public String getTenchuongtrinh() {
        return tenchuongtrinh;
    }

    public void setTenchuongtrinh(String tenchuongtrinh) {
        this.tenchuongtrinh = tenchuongtrinh;
    }

    public String getLoaichuongtrinh() {
        return loaichuongtrinh;
    }

    public void setLoaichuongtrinh(String loaichuongtrinh) {
        this.loaichuongtrinh = loaichuongtrinh;
    }

    public Date getNgaybatdau() {
        return ngaybatdau;
    }

    public void setNgaybatdau(Date ngaybatdau) {
        this.ngaybatdau = ngaybatdau;
    }

    public Date getNgayketthuc() {
        return ngayketthuc;
    }

    public void setNgayketthuc(Date ngayketthuc) {
        this.ngayketthuc = ngayketthuc;
    }
    
   

   
}