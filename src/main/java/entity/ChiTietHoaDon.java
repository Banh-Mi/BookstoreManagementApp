package entity;
/**
 * @author Nguyễn Thanh Nhứt
 */
public class ChiTietHoaDon {

    private String maHoaDon;
    private String maSanPham;
    private int soLuong;
    private double gia;

    public ChiTietHoaDon() {
    }

    public ChiTietHoaDon(String maHoaDon, String maSanPham, int soLuong, double gia) {
        this.maHoaDon = maHoaDon;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "ChiTietHoaDon{" + "maHoaDon=" + maHoaDon + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

}
