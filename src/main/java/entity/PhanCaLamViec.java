/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

public class PhanCaLamViec {

    private String maNV;
    private String maCaLamViec;
    private Date ngay;

    public PhanCaLamViec(String maNV, String maCaLamViec, Date ngay) {
        this.maNV = maNV;
        this.maCaLamViec = maCaLamViec;
        this.ngay = ngay;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaCaLamViec() {
        return maCaLamViec;
    }

    public void setMaCaLamViec(String maCaLamViec) {
        this.maCaLamViec = maCaLamViec;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

  

    
}
