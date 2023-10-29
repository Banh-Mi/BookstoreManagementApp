package entity;

import dao.ChiTietHoaDonDAO;
import java.sql.Date;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class HoaDon {

    private String maHoaDon;
    private String maKH;
    private String maNV;
    private String maKhuyenMai;
    private String phuongThucThanhToan;
    private Date ngayLapHoaDon;
    private String loaiHoaDon;
    private String soDienThoai;
    private String diaChiGiaoHang;
    private String trangThai;
    private String ghiChu;

    public HoaDon() {
    }

    public HoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public HoaDon(String maHoaDon, String maKH, String maNV, String maKhuyenMai, String phuongThucThanhToan, Date ngayLapHoaDon, String loaiHoaDon, String soDienThoai, String diaChiGiaoHang, String trangThai, String ghiChu) {
        this.maHoaDon = maHoaDon;
        this.maKH = maKH;
        this.maNV = maNV;
        this.maKhuyenMai = maKhuyenMai;
        this.phuongThucThanhToan = phuongThucThanhToan;
        this.ngayLapHoaDon = ngayLapHoaDon;
        this.loaiHoaDon = loaiHoaDon;
        this.soDienThoai = soDienThoai;
        this.diaChiGiaoHang = diaChiGiaoHang;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
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

    public String getPhuongThucThanhToan() {
        return phuongThucThanhToan;
    }

    public void setPhuongThucThanhToan(String phuongThucThanhToan) {
        this.phuongThucThanhToan = phuongThucThanhToan;
    }

    public Date getNgayLapHoaDon() {
        return ngayLapHoaDon;
    }

    public void setNgayLapHoaDon(Date ngayLapHoaDon) {
        this.ngayLapHoaDon = ngayLapHoaDon;
    }

    public String getLoaiHoaDon() {
        return loaiHoaDon;
    }

    public void setLoaiHoaDon(String loaiHoaDon) {
        this.loaiHoaDon = loaiHoaDon;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getDiaChiGiaoHang() {
        return diaChiGiaoHang;
    }

    public void setDiaChiGiaoHang(String diaChiGiaoHang) {
        this.diaChiGiaoHang = diaChiGiaoHang;
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
        ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonDAO.selectbyId(maHoaDon)) {
            tongTien = tongTien + chiTietHoaDon.getSoLuong() * chiTietHoaDon.getGia();
        }
        return (int) tongTien;
    }

    @Override
    public String toString() {
        return "HoaDon{" + "maHoaDon=" + maHoaDon + ", maKH=" + maKH + ", maNV=" + maNV + ", maKhuyenMai=" + maKhuyenMai + ", phuongThucThanhToan=" + phuongThucThanhToan + ", ngayLapHoaDon=" + ngayLapHoaDon + ", loaiHoaDon=" + loaiHoaDon + ", soDienThoai=" + soDienThoai + ", diaChiGiaoHang=" + diaChiGiaoHang + ", trangThai=" + trangThai + ", ghiChu=" + ghiChu + '}';
    }

}
