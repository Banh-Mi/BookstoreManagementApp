
package entity;


public class SanPhamBieuDo {
    private String tenDanhMuc;
    private int Soluong;

    public SanPhamBieuDo(String tenDanhMuc, int Soluong) {
        this.tenDanhMuc = tenDanhMuc;
        this.Soluong = Soluong;
    }

    public String getTenDanhMuc() {
        return tenDanhMuc;
    }

    public void setTenDanhMuc(String tenDanhMuc) {
        this.tenDanhMuc = tenDanhMuc;
    }

    public int getSoluong() {
        return Soluong;
    }

    public void setSoluong(int Soluong) {
        this.Soluong = Soluong;
    }
    
}
