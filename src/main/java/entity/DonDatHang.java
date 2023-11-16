package entity;

import dao.ChiTietDonDatHangDAO;
import dao.ChiTietHoaDonDAO;
import java.sql.Date;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class DonDatHang {

    private String maDonHang;
    private String maKH;
    private String maNV;
    private String maKhuyenMai;
    private Date ngayDatHang;
    private String soDienThoai;
    private String trangThai;
    private String ghiChu;

    public DonDatHang() {
    }

    public DonDatHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public DonDatHang(String maDonHang, String maKH, String maNV, String maKhuyenMai, Date ngayDatHang, String soDienThoai, String trangThai, String ghiChu) {
        this.maDonHang = maDonHang;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maKhuyenMai = maKhuyenMai;
        this.ngayDatHang = ngayDatHang;
        this.soDienThoai = soDienThoai;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(String maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getMaNV() {
        return maNV;
    }

    public void setMaNV(String maNV) {
        this.maNV = maNV;
    }

    public String getMaKhuyenMai() {
        return maKhuyenMai;
    }

    public void setMaKhuyenMai(String maKhuyenMai) {
        this.maKhuyenMai = maKhuyenMai;
    }

    public Date getNgayDatHang() {
        return ngayDatHang;
    }

    public void setNgayDatHang(Date ngayDatHang) {
        this.ngayDatHang = ngayDatHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
    
    public int getTongTien() {
        double tongTien = 0;
        ChiTietDonDatHangDAO chiTietDonDatHangDAO = new ChiTietDonDatHangDAO();
        for (ChiTietDonDatHang chiTietDonDatHang : chiTietDonDatHangDAO.selectbyId(maDonHang)) {
            tongTien = tongTien + chiTietDonDatHang.getSoLuong() * chiTietDonDatHang.getGia();
        }
        return (int) tongTien;
    }

    @Override
    public String toString() {
        return "DonDatHang{" + "maDonHang=" + maDonHang + ", maKH=" + maKH + ", maNV=" + maNV + ", maKhuyenMai=" + maKhuyenMai + ", ngayDatHang=" + ngayDatHang + ", soDienThoai=" + soDienThoai + ", trangThai=" + trangThai + ", ghiChu=" + ghiChu + '}';
    }

}
