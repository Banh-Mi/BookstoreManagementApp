
package entity;

public class DoanhThuBieuDo {
    private int thang;
    private Double tongtien;

    public DoanhThuBieuDo(int thang, Double tongtien) {
        this.thang = thang;
        this.tongtien = tongtien;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public Double getTongtien() {
        return tongtien;
    }

    public void setTongtien(Double tongtien) {
        this.tongtien = tongtien;
    }

   
    
}
