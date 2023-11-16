package entity;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ChiTietDonDatHang {

    private String maDonDatHang;
    private String maSanPham;
    private int soLuong;
    private double gia;

    public ChiTietDonDatHang() {
    }

    public ChiTietDonDatHang(String maDonDatHang, String maSanPham, int soLuong, double gia) {
        this.maDonDatHang = maDonDatHang;
        this.maSanPham = maSanPham;
        this.soLuong = soLuong;
        this.gia = gia;
    }

    public String getMaDonDatHang() {
        return maDonDatHang;
    }

    public void setMaDonDatHang(String maDonDatHang) {
        this.maDonDatHang = maDonDatHang;
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
        return "ChiTietDonDatHang{" + "maDonDatHang=" + maDonDatHang + ", maSanPham=" + maSanPham + ", soLuong=" + soLuong + ", gia=" + gia + '}';
    }

}
