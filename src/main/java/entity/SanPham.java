package entity;

/**
 *
 * @author Nguyễn Thanh Nhứt
 */
public class SanPham {
    private String maSanPham;
    private String tenSanPham;
    private String danhMuc;
    private String maNhaCC;
    private String donViTinh;
    private String tacGia;
    private String nhaXuatBan;
    private int namXuatBan;
    private int soTrang;
    private int soLuong;
    private double gia;
    private String hinhAnh;
    private String moTa;

    public SanPham() {
    }

    public SanPham(String maSanPham, String tenSanPham, String danhMuc, String maNhaCC, String donViTinh, String tacGia, String nhaXuatBan, int namXuatBan, int soTrang, int soLuong, double gia, String hinhAnh, String moTa) {
        this.maSanPham = maSanPham;
        this.tenSanPham = tenSanPham;
        this.danhMuc = danhMuc;
        this.maNhaCC = maNhaCC;
        this.donViTinh = donViTinh;
        this.tacGia = tacGia;
        this.nhaXuatBan = nhaXuatBan;
        this.namXuatBan = namXuatBan;
        this.soTrang = soTrang;
        this.soLuong = soLuong;
        this.gia = gia;
        this.hinhAnh = hinhAnh;
        this.moTa = moTa;
    }

    public String getMaSanPham() {
        return maSanPham;
    }

    public void setMaSanPham(String maSanPham) {
        this.maSanPham = maSanPham;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getDanhMuc() {
        return danhMuc;
    }

    public void setDanhMuc(String danhMuc) {
        this.danhMuc = danhMuc;
    }

    public String getMaNhaCC() {
        return maNhaCC;
    }

    public void setMaNhaCC(String maNhaCC) {
        this.maNhaCC = maNhaCC;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getTacGia() {
        return tacGia;
    }

    public void setTacGia(String tacGia) {
        this.tacGia = tacGia;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getNamXuatBan() {
        return namXuatBan;
    }

    public void setNamXuatBan(int namXuatBan) {
        this.namXuatBan = namXuatBan;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
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

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSanPham=" + maSanPham + ", tenSanPham=" + tenSanPham + ", danhMuc=" + danhMuc + ", maNhaCC=" + maNhaCC + ", donViTinh=" + donViTinh + ", tacGia=" + tacGia + ", nhaXuatBan=" + nhaXuatBan + ", namXuatBan=" + namXuatBan + ", soTrang=" + soTrang + ", soLuong=" + soLuong + ", gia=" + gia + ", hinhAnh=" + hinhAnh + ", moTa=" + moTa + '}';
    }

}
