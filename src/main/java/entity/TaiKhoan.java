package entity;

public class TaiKhoan {

    private String maTK;
    private String tenDangNhap;
    private String matKhau;
    private String quyen;
    private String trangThaiTaiKhoan;

    private NhanVien nhanVien;

    public TaiKhoan(String maTK, String tenDangNhap, String matKhau, String quyen, String trangThaiTaiKhoan) {
        this.maTK = maTK;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.quyen = quyen;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public TaiKhoan(String maNV, String tenDangNhap, String tenNV, String trangThaiTaiKhoan) {
        this.nhanVien = new NhanVien();
        nhanVien.setMaNV(maNV);
        nhanVien.setTenNV(tenNV);
        this.tenDangNhap = tenDangNhap;
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

    public NhanVien getNhanVien() {
        return nhanVien;
    }

    public void setNhanVien(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
    }

    public TaiKhoan() {
    }

    public String getQuyen() {
        return quyen;
    }

    public void setQuyen(String quyen) {
        this.quyen = quyen;
    }

    public String getMaTK() {
        return maTK;
    }

    public void setMaTK(String maTK) {
        this.maTK = maTK;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getTrangThaiTaiKhoan() {
        return trangThaiTaiKhoan;
    }

    public void setTrangThaiTaiKhoan(String trangThaiTaiKhoan) {
        this.trangThaiTaiKhoan = trangThaiTaiKhoan;
    }

}
