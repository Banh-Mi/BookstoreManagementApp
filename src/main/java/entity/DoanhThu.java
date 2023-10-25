
package entity;

import java.sql.Date;

public class DoanhThu {
    private String mahoadon;
    private String tennv;
    private String tenkh;
    private Date ngaylaphoadon;
    private double tongtien;

    public DoanhThu(String mahoadon, String tennv, String tenkh, Date ngaylaphoadon, double tongtien) {
        this.mahoadon = mahoadon;
        this.tennv = tennv;
        this.tenkh = tenkh;
        this.ngaylaphoadon = ngaylaphoadon;
        this.tongtien = tongtien;
    }

    public String getMahoadon() {
        return mahoadon;
    }

    public void setMahoadon(String mahoadon) {
        this.mahoadon = mahoadon;
    }

    public String getTennv() {
        return tennv;
    }

    public void setTennv(String tennv) {
        this.tennv = tennv;
    }

    public String getTenkh() {
        return tenkh;
    }

    public void setTenkh(String tenkh) {
        this.tenkh = tenkh;
    }

    public Date getNgaylaphoadon() {
        return ngaylaphoadon;
    }

    public void setNgaylaphoadon(Date ngaylaphoadon) {
        this.ngaylaphoadon = ngaylaphoadon;
    }

    public double getTongtien() {
        return tongtien;
    }

    public void setTongtien(double tongtien) {
        this.tongtien = tongtien;
    }
    
}
