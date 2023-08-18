
package entity;


public class taikhoan {
    private String mataikhoan;
    private String tendangnhap;
    private String matkhau;
    private String quyen;
    private boolean tinhtrang;

    public taikhoan(String mataikhoan, String tendangnhap, String matkhau,String quyen, boolean tinhtrang) {
        this.mataikhoan = mataikhoan;
        this.tendangnhap = tendangnhap;
        this.matkhau = matkhau;
        this.quyen=quyen;
        this.tinhtrang = tinhtrang;
    }

    public taikhoan() {
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

  

 

    
    public String getMataikhoan() {
        return mataikhoan;
    }

    public void setMataikhoan(String mataikhoan) {
        this.mataikhoan = mataikhoan;
    }

    public String getTendangnhap() {
        return tendangnhap;
    }

    public void setTendangnhap(String tendangnhap) {
        this.tendangnhap = tendangnhap;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public boolean isTinhtrang() {
        return tinhtrang;
    }

    public void setTinhtrang(boolean tinhtrang) {
        this.tinhtrang = tinhtrang;
    }
    
}
