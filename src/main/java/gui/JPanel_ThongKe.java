package gui;

import dao.KhachHangDAO;
import dao.SanPhamDAO;
import dao.ThongKeDoanhThuDAO;
import dao.ThongKeKhachHangDAO;
import dao.ThongKeSanPhamDAO;
import entity.KhachHang;
import entity.SanPham;
import entity.ThongKeDoanhThu;
import entity.ThongKeKhachHang;
import entity.ThongKeSanPham;
import java.awt.Graphics2D;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import static util.ExcelExporter.exportToExcel;

public class JPanel_ThongKe extends javax.swing.JPanel {

    private final DefaultTableModel modelDoanhThu;
    private final DefaultTableModel modelSanPham;
    private final DefaultTableModel modelKhachHang;
    private ArrayList<ThongKeDoanhThu> doanhThuList = new ArrayList<>();
    private ArrayList<ThongKeSanPham> sanPhamList = new ArrayList<>();
    private ArrayList<ThongKeKhachHang> khachHangList = new ArrayList<>();
    private ThongKeDoanhThuDAO thongKeDoanhThuDAO;
    private ThongKeSanPhamDAO thongKeSanPhamDAO;
    private ThongKeKhachHangDAO thongKeKhachHangDAO;
    private SanPhamDAO sanPhamDAO;
    private final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    private KhachHangDAO khachHangDAO;

    public JPanel_ThongKe() {
        initComponents();
        modelDoanhThu = (DefaultTableModel) tableDoanhThu.getModel();
        modelSanPham = (DefaultTableModel) tableSanPham.getModel();
        modelKhachHang = (DefaultTableModel) tableKhachHang.getModel();
        svgThongKeKH.setSvgImage("statistical.svg", 35, 35);
        svgLamMoiKH.setSvgImage("refresh.svg", 35, 35);
        svgThongKeDoanhThu.setSvgImage("statistical.svg", 35, 35);
        svgLamMoiDoanhThu.setSvgImage("refresh.svg", 35, 35);
        svgThongKeSP.setSvgImage("statistical.svg", 35, 35);
        svgLamMoiSP.setSvgImage("refresh.svg", 35, 35);
        loadDuLieuDoanhThu();
        loadDuLieuSanPham();
        loadDuLieuKhachHang();
    }

    private void setComponentState(boolean set, JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(set);
        }
    }

    private void loadDuLieuDoanhThu() {
        //Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        Set<Integer> uniqueYears = new HashSet<>();
        thongKeDoanhThuDAO = new ThongKeDoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tongTien = 0;
        double giamGia = 0;
        double thanhTien = 0;
        doanhThuList = thongKeDoanhThuDAO.getHoaDon(null, null);
        for (ThongKeDoanhThu doanhThu : doanhThuList) {
            Object row[] = {doanhThu.getMaHoaDon(), doanhThu.getTenNV(), doanhThu.getTenKH(), doanhThu.getNgayLapHoaDon(), nf.format(doanhThu.getTongTien()), nf.format(doanhThu.getGiamGia()), nf.format(doanhThu.getThanhTien())};
            modelDoanhThu.addRow(row);
            tongTien += doanhThu.getTongTien();
            thanhTien += doanhThu.getThanhTien();
            giamGia += doanhThu.getGiamGia();
            soHoaDon++;
            uniqueYears.add(doanhThu.getNgayLapHoaDon().toLocalDate().getYear());
        }
        jcbNamDoanhThu.removeAllItems();
        for (Integer year : uniqueYears) {
            jcbNamDoanhThu.addItem(year.toString());
        }
        txtSoLuongHoaDon.setText(soHoaDon + "");
        txtGiamGia.setText(nf.format(giamGia));
        txtTongTien.setText(nf.format(tongTien));
        txtDoanhThu.setText(nf.format(thanhTien));

    }

    private void loadDuLieuKhachHang() {
//Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        thongKeKhachHangDAO = new ThongKeKhachHangDAO();
        modelKhachHang.setRowCount(0);
        int soLuongSanPham = 0;
        int soHoaDon = 0;
        double tongTien = 0;
        int soLuongNDK = 0;
        khachHangList = thongKeKhachHangDAO.getKHTuyChinh(null, null);
        int i = 0;
        for (ThongKeKhachHang kh : khachHangList) {
            try {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            } catch (Exception e) {
                System.out.println("Error at index " + i + ": " + e.getMessage());
            }
            i++;
        }

        txtSoLuongDHKH.setText(soHoaDon + "");
        txtTongTienKH.setText(nf.format(tongTien));
        txtSoLuongSPKH.setText(soLuongSanPham + "");
        txtsoLuongNDK.setText(soLuongNDK + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTab = new javax.swing.JTabbedPane();
        tabDoanhThu = new javax.swing.JPanel();
        scrollDoanhThu = new javax.swing.JScrollPane();
        tableDoanhThu = new javax.swing.JTable();
        jpChucNangDoanhThu = new javax.swing.JPanel();
        jdDenNgayDoanhThu = new com.toedter.calendar.JDateChooser();
        jdTuNgayDoanhThu = new com.toedter.calendar.JDateChooser();
        lblDenNgay = new javax.swing.JLabel();
        lblDoanhThu = new javax.swing.JLabel();
        lblTongDoanhThu = new javax.swing.JLabel();
        lblSoLuongHoaDon = new javax.swing.JLabel();
        txtDoanhThu = new javax.swing.JLabel();
        txtSoLuongHoaDon = new javax.swing.JLabel();
        lblTuNgay = new javax.swing.JLabel();
        jcbLuaChonDoanhThu = new javax.swing.JComboBox<>();
        lblLuaChonDoanhThu = new javax.swing.JLabel();
        jpThongKeDT = new util.JPanelRounded();
        lblThongKeDoanhThu = new javax.swing.JLabel();
        svgThongKeDoanhThu = new util.SVGImage();
        jbLamMoiDoanhThu = new util.JPanelRounded();
        lblLamMoiDoanhThu = new javax.swing.JLabel();
        svgLamMoiDoanhThu = new util.SVGImage();
        jSeparator1 = new javax.swing.JSeparator();
        lblNamDoanhThu = new javax.swing.JLabel();
        lblThangDoanhThu = new javax.swing.JLabel();
        jcbThangDoanhThu = new javax.swing.JComboBox<>();
        jcbNamDoanhThu = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        lblTongTien = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        lblGiamGia = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JLabel();
        jbLXuatExcelDoanhThu = new util.JPanelRounded();
        lblLamMoiSP3 = new javax.swing.JLabel();
        XuatExcelDoanhThu = new util.SVGImage();
        jpLXuatPDFDoanhThu = new util.JPanelRounded();
        lblInBaoCaoSP2 = new javax.swing.JLabel();
        svgXuatPDFDoanhThu = new util.SVGImage();
        tabSanPham = new javax.swing.JPanel();
        scrollSanPham = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jpChucNangSanPham = new javax.swing.JPanel();
        jdTuNgayDoanhThu1 = new com.toedter.calendar.JDateChooser();
        jdDenNgayDoanhThu1 = new com.toedter.calendar.JDateChooser();
        lblDenNgaySanPham = new javax.swing.JLabel();
        lblDoanhThuSanPham = new javax.swing.JLabel();
        lblTongDoanhThuSanPham = new javax.swing.JLabel();
        lblSoLuongHoaDonSP = new javax.swing.JLabel();
        txtDoanhThuSP = new javax.swing.JLabel();
        txtSoLuongHoaDon1 = new javax.swing.JLabel();
        lblTuNgaySP = new javax.swing.JLabel();
        btnBieuDoSP = new javax.swing.JButton();
        jcbLuaChonDoanhThu1 = new javax.swing.JComboBox<>();
        jpLXuatPDFSanPham = new util.JPanelRounded();
        lblInBaoCaoSP = new javax.swing.JLabel();
        svgXuatPDFSanPham = new util.SVGImage();
        lblLuaChonSP = new javax.swing.JLabel();
        jpThongKeSP = new util.JPanelRounded();
        lblThongKeSP = new javax.swing.JLabel();
        svgThongKeSP = new util.SVGImage();
        jbLamMoiSP = new util.JPanelRounded();
        lblLamMoiSP = new javax.swing.JLabel();
        svgLamMoiSP = new util.SVGImage();
        jSeparator3 = new javax.swing.JSeparator();
        lblNamSP = new javax.swing.JLabel();
        lblThangSP = new javax.swing.JLabel();
        jcbThangDoanhThu1 = new javax.swing.JComboBox<>();
        jcbNamDoanhThu1 = new javax.swing.JComboBox<>();
        jcbchonsanpham = new javax.swing.JComboBox<>();
        jbLXuatExcelSanPham = new util.JPanelRounded();
        lblLamMoiSP1 = new javax.swing.JLabel();
        svgXuatExcelSanPham = new util.SVGImage();
        tabKhachHang = new javax.swing.JPanel();
        scrollKhachHang = new javax.swing.JScrollPane();
        tableKhachHang = new javax.swing.JTable();
        jpChucNangKH = new javax.swing.JPanel();
        jdDenNgayKH = new com.toedter.calendar.JDateChooser();
        jdTuNgayKH = new com.toedter.calendar.JDateChooser();
        lblDenNgayKH = new javax.swing.JLabel();
        lblDoanhThuKH = new javax.swing.JLabel();
        lblTongDoanhThuKH = new javax.swing.JLabel();
        lblSoLuongHoaDonKH = new javax.swing.JLabel();
        txtTongTienKH = new javax.swing.JLabel();
        txtSoLuongSPKH = new javax.swing.JLabel();
        lblTuNgayKH = new javax.swing.JLabel();
        btnBieuDoKH = new javax.swing.JButton();
        jcbLuaChonKH = new javax.swing.JComboBox<>();
        lblLuaChonKH = new javax.swing.JLabel();
        jpThongKeKH = new util.JPanelRounded();
        lblThongKeKH = new javax.swing.JLabel();
        svgThongKeKH = new util.SVGImage();
        jbLamMoiKH = new util.JPanelRounded();
        lblLamMoiKH = new javax.swing.JLabel();
        svgLamMoiKH = new util.SVGImage();
        jSeparator4 = new javax.swing.JSeparator();
        lblNamKH = new javax.swing.JLabel();
        lblThangKH = new javax.swing.JLabel();
        jcbThangKH = new javax.swing.JComboBox<>();
        jcbNamKH = new javax.swing.JComboBox<>();
        jCBTieuChi = new javax.swing.JComboBox<>();
        lblSoLuongHoaDonKH1 = new javax.swing.JLabel();
        txtSoLuongDHKH = new javax.swing.JLabel();
        lblDoanhThuKH1 = new javax.swing.JLabel();
        txtsoLuongNDK = new javax.swing.JLabel();
        jbLXuatExcelKhachHang = new util.JPanelRounded();
        lblLamMoiSP2 = new javax.swing.JLabel();
        svgXuatExcelKhachHang = new util.SVGImage();
        jpLXuatPDFKhachHang = new util.JPanelRounded();
        lblInBaoCaoSP1 = new javax.swing.JLabel();
        svgXuatPDFKhachHang = new util.SVGImage();

        setPreferredSize(new java.awt.Dimension(1040, 950));
        setLayout(new java.awt.BorderLayout());

        jTab.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTab.setPreferredSize(new java.awt.Dimension(1200, 950));

        tabDoanhThu.setPreferredSize(new java.awt.Dimension(1061, 950));
        tabDoanhThu.setLayout(new java.awt.BorderLayout());

        scrollDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        scrollDoanhThu.setPreferredSize(new java.awt.Dimension(420, 395));

        tableDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên nhân viên", "Tên khách hàng", "Ngày tạo", "Tổng tiền", "Giảm giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollDoanhThu.setViewportView(tableDoanhThu);

        tabDoanhThu.add(scrollDoanhThu, java.awt.BorderLayout.CENTER);

        jpChucNangDoanhThu.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangDoanhThu.setPreferredSize(new java.awt.Dimension(400, 710));
        jpChucNangDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdDenNgayDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(jdDenNgayDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 240, 40));

        jdTuNgayDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(jdTuNgayDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 240, 40));

        lblDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDenNgay.setText("Đến ngày:");
        jpChucNangDoanhThu.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, 40));

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThu.setText("Doanh thu:");
        jpChucNangDoanhThu.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 750, -1, 40));

        lblTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThu.setText("THỐNG KÊ");
        jpChucNangDoanhThu.add(lblTongDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 220, -1));

        lblSoLuongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDon.setText("Số lượng hóa đơn bán được:");
        jpChucNangDoanhThu.add(lblSoLuongHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 570, -1, 40));

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 750, 190, 40));

        txtSoLuongHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtSoLuongHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 570, 80, 40));

        lblTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTuNgay.setText("Từ ngày:");
        jpChucNangDoanhThu.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 40));

        jcbLuaChonDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jcbLuaChonDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonDoanhThuActionPerformed(evt);
            }
        });
        jpChucNangDoanhThu.add(jcbLuaChonDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 40));

        lblLuaChonDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLuaChonDoanhThu.setText("Thống kê theo:");
        jpChucNangDoanhThu.add(lblLuaChonDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        jpThongKeDT.setBackground(new java.awt.Color(255, 255, 255));
        jpThongKeDT.setRoundedBottomLeft(10);
        jpThongKeDT.setRoundedBottomRight(10);
        jpThongKeDT.setRoundedTopLeft(10);
        jpThongKeDT.setRoundedTopRight(10);
        jpThongKeDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpThongKeDTMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jpThongKeDTMouseEntered(evt);
            }
        });
        jpThongKeDT.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThongKeDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKeDoanhThu.setText("Thống kê");
        jpThongKeDT.add(lblThongKeDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgThongKeDoanhThu.setText(" ");
        jpThongKeDT.add(svgThongKeDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangDoanhThu.add(jpThongKeDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 150, 50));

        jbLamMoiDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        jbLamMoiDoanhThu.setRoundedBottomLeft(10);
        jbLamMoiDoanhThu.setRoundedBottomRight(10);
        jbLamMoiDoanhThu.setRoundedTopLeft(10);
        jbLamMoiDoanhThu.setRoundedTopRight(10);
        jbLamMoiDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLamMoiDoanhThuMouseClicked(evt);
            }
        });
        jbLamMoiDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiDoanhThu.setText("Làm mới");
        jbLamMoiDoanhThu.add(lblLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgLamMoiDoanhThu.setText(" ");
        jbLamMoiDoanhThu.add(svgLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangDoanhThu.add(jbLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 150, 50));
        jpChucNangDoanhThu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 340, 10));

        lblNamDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamDoanhThu.setText("Năm :");
        jpChucNangDoanhThu.add(lblNamDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, -1, 40));

        lblThangDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThangDoanhThu.setText("Tháng :");
        jpChucNangDoanhThu.add(lblThangDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, 40));

        jcbThangDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbThangDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangDoanhThu.setEnabled(false);
        jpChucNangDoanhThu.add(jcbThangDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 80, 40));

        jcbNamDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbNamDoanhThu.setEnabled(false);
        jpChucNangDoanhThu.add(jcbNamDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 240, 110, 40));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setText("XEM BIỂU ĐỒ");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jpChucNangDoanhThu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 820, 150, 50));

        lblTongTien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTongTien.setText("Tổng tiền:");
        jpChucNangDoanhThu.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, -1, 40));

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 630, 150, 40));

        lblGiamGia.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGiamGia.setText("Giảm giá:");
        jpChucNangDoanhThu.add(lblGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 690, -1, 40));

        txtGiamGia.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtGiamGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 690, 190, 40));

        jbLXuatExcelDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        jbLXuatExcelDoanhThu.setRoundedBottomLeft(10);
        jbLXuatExcelDoanhThu.setRoundedBottomRight(10);
        jbLXuatExcelDoanhThu.setRoundedTopLeft(10);
        jbLXuatExcelDoanhThu.setRoundedTopRight(10);
        jbLXuatExcelDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLXuatExcelDoanhThuMouseClicked(evt);
            }
        });
        jbLXuatExcelDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiSP3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiSP3.setText("Xuất excel");
        jbLXuatExcelDoanhThu.add(lblLamMoiSP3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        XuatExcelDoanhThu.setText(" ");
        jbLXuatExcelDoanhThu.add(XuatExcelDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangDoanhThu.add(jbLXuatExcelDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 150, 50));

        jpLXuatPDFDoanhThu.setBackground(new java.awt.Color(255, 255, 255));
        jpLXuatPDFDoanhThu.setRoundedBottomLeft(10);
        jpLXuatPDFDoanhThu.setRoundedBottomRight(10);
        jpLXuatPDFDoanhThu.setRoundedTopLeft(10);
        jpLXuatPDFDoanhThu.setRoundedTopRight(10);
        jpLXuatPDFDoanhThu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpLXuatPDFDoanhThuMouseClicked(evt);
            }
        });
        jpLXuatPDFDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCaoSP2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInBaoCaoSP2.setText("Xuất PDF");
        jpLXuatPDFDoanhThu.add(lblInBaoCaoSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgXuatPDFDoanhThu.setText(" ");
        jpLXuatPDFDoanhThu.add(svgXuatPDFDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangDoanhThu.add(jpLXuatPDFDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 390, 150, 50));

        tabDoanhThu.add(jpChucNangDoanhThu, java.awt.BorderLayout.WEST);

        jTab.addTab("Doanh Thu", tabDoanhThu);

        tabSanPham.setLayout(new java.awt.BorderLayout());

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        scrollSanPham.setViewportView(tableSanPham);

        tabSanPham.add(scrollSanPham, java.awt.BorderLayout.CENTER);

        jpChucNangSanPham.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangSanPham.setPreferredSize(new java.awt.Dimension(400, 710));
        jpChucNangSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdTuNgayDoanhThu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(jdTuNgayDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 250, 40));

        jdDenNgayDoanhThu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(jdDenNgayDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 250, 40));

        lblDenNgaySanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDenNgaySanPham.setText("Đến ngày:");
        jpChucNangSanPham.add(lblDenNgaySanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 40));

        lblDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThuSanPham.setText("Tổng tiền:");
        jpChucNangSanPham.add(lblDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, 40));

        lblTongDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTongDoanhThuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuSanPham.setText("THỐNG KÊ");
        jpChucNangSanPham.add(lblTongDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 200, -1));

        lblSoLuongHoaDonSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDonSP.setText("Số lượng sản phẩm đã bán được:");
        jpChucNangSanPham.add(lblSoLuongHoaDonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 570, -1, 40));

        txtDoanhThuSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtDoanhThuSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 620, 190, 40));

        txtSoLuongHoaDon1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtSoLuongHoaDon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 570, 60, 40));

        lblTuNgaySP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTuNgaySP.setText("Từ ngày:");
        jpChucNangSanPham.add(lblTuNgaySP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 40));

        btnBieuDoSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBieuDoSP.setText("XEM BIỂU ĐỒ");
        btnBieuDoSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBieuDoSPMouseClicked(evt);
            }
        });
        btnBieuDoSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoSPActionPerformed(evt);
            }
        });
        jpChucNangSanPham.add(btnBieuDoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 800, 170, 50));

        jcbLuaChonDoanhThu1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jcbLuaChonDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonDoanhThu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jcbLuaChonDoanhThu1MouseClicked(evt);
            }
        });
        jcbLuaChonDoanhThu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonDoanhThu1ActionPerformed(evt);
            }
        });
        jpChucNangSanPham.add(jcbLuaChonDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 200, 40));

        jpLXuatPDFSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jpLXuatPDFSanPham.setRoundedBottomLeft(10);
        jpLXuatPDFSanPham.setRoundedBottomRight(10);
        jpLXuatPDFSanPham.setRoundedTopLeft(10);
        jpLXuatPDFSanPham.setRoundedTopRight(10);
        jpLXuatPDFSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpLXuatPDFSanPhamMouseClicked(evt);
            }
        });
        jpLXuatPDFSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCaoSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInBaoCaoSP.setText("Xuất PDF");
        jpLXuatPDFSanPham.add(lblInBaoCaoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgXuatPDFSanPham.setText(" ");
        svgXuatPDFSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                svgXuatPDFSanPhamMouseEntered(evt);
            }
        });
        jpLXuatPDFSanPham.add(svgXuatPDFSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangSanPham.add(jpLXuatPDFSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 150, 50));

        lblLuaChonSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLuaChonSP.setText("Thống kê theo:");
        jpChucNangSanPham.add(lblLuaChonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        jpThongKeSP.setBackground(new java.awt.Color(255, 255, 255));
        jpThongKeSP.setRoundedBottomLeft(10);
        jpThongKeSP.setRoundedBottomRight(10);
        jpThongKeSP.setRoundedTopLeft(10);
        jpThongKeSP.setRoundedTopRight(10);
        jpThongKeSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpThongKeSPMouseClicked(evt);
            }
        });
        jpThongKeSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThongKeSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKeSP.setText("Thống kê");
        jpThongKeSP.add(lblThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgThongKeSP.setText(" ");
        jpThongKeSP.add(svgThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangSanPham.add(jpThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 150, 50));

        jbLamMoiSP.setBackground(new java.awt.Color(255, 255, 255));
        jbLamMoiSP.setRoundedBottomLeft(10);
        jbLamMoiSP.setRoundedBottomRight(10);
        jbLamMoiSP.setRoundedTopLeft(10);
        jbLamMoiSP.setRoundedTopRight(10);
        jbLamMoiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLamMoiSPMouseClicked(evt);
            }
        });
        jbLamMoiSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiSP.setText("Làm mới");
        jbLamMoiSP.add(lblLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgLamMoiSP.setText(" ");
        jbLamMoiSP.add(svgLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangSanPham.add(jbLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 340, 150, 50));
        jpChucNangSanPham.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 350, 10));

        lblNamSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamSP.setText("Năm :");
        jpChucNangSanPham.add(lblNamSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, -1, 40));

        lblThangSP.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThangSP.setText("Tháng :");
        jpChucNangSanPham.add(lblThangSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, -1, 40));

        jcbThangDoanhThu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbThangDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangDoanhThu1.setEnabled(false);
        jpChucNangSanPham.add(jcbThangDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, 80, 40));

        jcbNamDoanhThu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbNamDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", " " }));
        jcbNamDoanhThu1.setEnabled(false);
        jpChucNangSanPham.add(jcbNamDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 120, 40));

        jcbchonsanpham.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jcbchonsanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm đã bán", "Top 5 sản phẩm được bán nhiều nhất", "Top 5 sản phẩm được bán ít nhất", "Top 5 sản phẩm có doanh thu cao nhất", "Top 5 sản phẩm có doanh thu thấp nhất", "Top 5 sản phẩm tồn kho nhiều nhất", "Top 5 sản phẩm tồn kho ít nhất" }));
        jcbchonsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbchonsanphamActionPerformed(evt);
            }
        });
        jpChucNangSanPham.add(jcbchonsanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 350, 40));

        jbLXuatExcelSanPham.setBackground(new java.awt.Color(255, 255, 255));
        jbLXuatExcelSanPham.setRoundedBottomLeft(10);
        jbLXuatExcelSanPham.setRoundedBottomRight(10);
        jbLXuatExcelSanPham.setRoundedTopLeft(10);
        jbLXuatExcelSanPham.setRoundedTopRight(10);
        jbLXuatExcelSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLXuatExcelSanPhamMouseClicked(evt);
            }
        });
        jbLXuatExcelSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiSP1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiSP1.setText("Xuất excel");
        jbLXuatExcelSanPham.add(lblLamMoiSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgXuatExcelSanPham.setText(" ");
        jbLXuatExcelSanPham.add(svgXuatExcelSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangSanPham.add(jbLXuatExcelSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 50));

        tabSanPham.add(jpChucNangSanPham, java.awt.BorderLayout.WEST);

        jTab.addTab("Sản Phẩm", tabSanPham);

        tabKhachHang.setLayout(new java.awt.BorderLayout());

        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Giới tính", "Ngày đăng ký", "Số lượng HĐ", "Tổng tiền", "Tổng SP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableKhachHangMouseClicked(evt);
            }
        });
        scrollKhachHang.setViewportView(tableKhachHang);

        tabKhachHang.add(scrollKhachHang, java.awt.BorderLayout.CENTER);

        jpChucNangKH.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangKH.setPreferredSize(new java.awt.Dimension(400, 710));
        jpChucNangKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jdDenNgayKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(jdDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 210, 260, 40));

        jdTuNgayKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(jdTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 260, 40));

        lblDenNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDenNgayKH.setText("Đến ngày:");
        jpChucNangKH.add(lblDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 40));

        lblDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThuKH.setText("Tổng tiền:");
        jpChucNangKH.add(lblDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 690, -1, 40));

        lblTongDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        lblTongDoanhThuKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuKH.setText("THỐNG KÊ");
        jpChucNangKH.add(lblTongDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 510, 200, -1));

        lblSoLuongHoaDonKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDonKH.setText("Số lượng sản phẩm:");
        jpChucNangKH.add(lblSoLuongHoaDonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 590, -1, 40));

        txtTongTienKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtTongTienKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 690, 170, 40));

        txtSoLuongSPKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtSoLuongSPKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 590, 100, 40));

        lblTuNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTuNgayKH.setText("Từ ngày:");
        jpChucNangKH.add(lblTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 40));

        btnBieuDoKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnBieuDoKH.setText("XEM BIỂU ĐỒ");
        btnBieuDoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBieuDoKHMouseClicked(evt);
            }
        });
        btnBieuDoKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBieuDoKHActionPerformed(evt);
            }
        });
        jpChucNangKH.add(btnBieuDoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 800, 170, 50));

        jcbLuaChonKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jcbLuaChonKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonKHActionPerformed(evt);
            }
        });
        jpChucNangKH.add(jcbLuaChonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 210, 40));

        lblLuaChonKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLuaChonKH.setText("Thống kê theo:");
        jpChucNangKH.add(lblLuaChonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 40));

        jpThongKeKH.setBackground(new java.awt.Color(255, 255, 255));
        jpThongKeKH.setRoundedBottomLeft(10);
        jpThongKeKH.setRoundedBottomRight(10);
        jpThongKeKH.setRoundedTopLeft(10);
        jpThongKeKH.setRoundedTopRight(10);
        jpThongKeKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpThongKeKHMouseClicked(evt);
            }
        });
        jpThongKeKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblThongKeKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThongKeKH.setText("Thống kê");
        jpThongKeKH.add(lblThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgThongKeKH.setText(" ");
        jpThongKeKH.add(svgThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangKH.add(jpThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 150, 50));

        jbLamMoiKH.setBackground(new java.awt.Color(255, 255, 255));
        jbLamMoiKH.setRoundedBottomLeft(10);
        jbLamMoiKH.setRoundedBottomRight(10);
        jbLamMoiKH.setRoundedTopLeft(10);
        jbLamMoiKH.setRoundedTopRight(10);
        jbLamMoiKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLamMoiKHMouseClicked(evt);
            }
        });
        jbLamMoiKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiKH.setText("Làm mới");
        jbLamMoiKH.add(lblLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgLamMoiKH.setText(" ");
        jbLamMoiKH.add(svgLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangKH.add(jbLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 350, 150, 50));
        jpChucNangKH.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 560, 360, 10));

        lblNamKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNamKH.setText("Năm :");
        jpChucNangKH.add(lblNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, -1, 40));

        lblThangKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblThangKH.setText("Tháng :");
        jpChucNangKH.add(lblThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, 40));

        jcbThangKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbThangKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangKH.setEnabled(false);
        jpChucNangKH.add(jcbThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 90, 40));

        jcbNamKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbNamKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", " " }));
        jcbNamKH.setEnabled(false);
        jpChucNangKH.add(jcbNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 120, 40));

        jCBTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jCBTieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng đã mua hàng", "Top 5 khách hàng tổng chi cao nhất", "Top 5 khách hàng tổng chi thấp nhất", "Top 5 khách hàng mua hàng nhiều nhất", "Top 5 khách hàng mua hàng ít nhất", "Top 5 khách hàng thường xuyên mua hàng nhất", "Top 5 khách hàng không thường xuyên mua hàng nhất" }));
        jCBTieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTieuChiActionPerformed(evt);
            }
        });
        jpChucNangKH.add(jCBTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 360, 40));

        lblSoLuongHoaDonKH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDonKH1.setText("Số lượng đơn hàng:");
        jpChucNangKH.add(lblSoLuongHoaDonKH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, -1, 40));

        txtSoLuongDHKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtSoLuongDHKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 80, 40));

        lblDoanhThuKH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThuKH1.setText("Số lượng người đăng ký:");
        jpChucNangKH.add(lblDoanhThuKH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 740, -1, 40));

        txtsoLuongNDK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtsoLuongNDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 740, 80, 40));

        jbLXuatExcelKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        jbLXuatExcelKhachHang.setRoundedBottomLeft(10);
        jbLXuatExcelKhachHang.setRoundedBottomRight(10);
        jbLXuatExcelKhachHang.setRoundedTopLeft(10);
        jbLXuatExcelKhachHang.setRoundedTopRight(10);
        jbLXuatExcelKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbLXuatExcelKhachHangMouseClicked(evt);
            }
        });
        jbLXuatExcelKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLamMoiSP2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblLamMoiSP2.setText("Xuất excel");
        jbLXuatExcelKhachHang.add(lblLamMoiSP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgXuatExcelKhachHang.setText(" ");
        jbLXuatExcelKhachHang.add(svgXuatExcelKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangKH.add(jbLXuatExcelKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, 150, 50));

        jpLXuatPDFKhachHang.setBackground(new java.awt.Color(255, 255, 255));
        jpLXuatPDFKhachHang.setRoundedBottomLeft(10);
        jpLXuatPDFKhachHang.setRoundedBottomRight(10);
        jpLXuatPDFKhachHang.setRoundedTopLeft(10);
        jpLXuatPDFKhachHang.setRoundedTopRight(10);
        jpLXuatPDFKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpLXuatPDFKhachHangMouseClicked(evt);
            }
        });
        jpLXuatPDFKhachHang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCaoSP1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblInBaoCaoSP1.setText("Xuất PDF");
        jpLXuatPDFKhachHang.add(lblInBaoCaoSP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgXuatPDFKhachHang.setText(" ");
        jpLXuatPDFKhachHang.add(svgXuatPDFKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpChucNangKH.add(jpLXuatPDFKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 410, 150, 50));

        tabKhachHang.add(jpChucNangKH, java.awt.BorderLayout.WEST);

        jTab.addTab("Khách hàng", tabKhachHang);

        add(jTab, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void jpThongKeDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeDTMouseClicked
        String selectedItem = (String) jcbLuaChonDoanhThu.getSelectedItem();
        thongKeDoanhThuDAO = new ThongKeDoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tongTien = 0;
        double giamGia = 0;
        double thanhTien = 0;
        java.util.Date currDate = new java.util.Date();
        switch (selectedItem) {
            case "Theo ngày":
                doanhThuList = thongKeDoanhThuDAO.getHoaDon(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                break;
            case "Theo tuần":
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currDate);
                calendar.add(Calendar.DAY_OF_MONTH, -7);
                java.util.Date weekAgo = calendar.getTime();
                doanhThuList = thongKeDoanhThuDAO.getHoaDon(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                break;
            case "Theo tháng":
                doanhThuList = thongKeDoanhThuDAO.getDoanhThuThangNam(Integer.parseInt(jcbThangDoanhThu.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()));
                break;
            case "Tuỳ chỉnh":
                java.sql.Date tuNgay = jdTuNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu.getDate().getTime());
                java.sql.Date denNgay = jdDenNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu.getDate().getTime());
                doanhThuList = thongKeDoanhThuDAO.getHoaDon(tuNgay, denNgay);
                break;

            case "Theo năm":
                doanhThuList = thongKeDoanhThuDAO.getDoanhThuThangNam(0, Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()));
                break;
            default:
                break;
        }
        //Load table

        for (ThongKeDoanhThu doanhThu : doanhThuList) {
            Object row[] = {doanhThu.getMaHoaDon(), doanhThu.getTenNV(), doanhThu.getTenKH(), doanhThu.getNgayLapHoaDon(), nf.format(doanhThu.getTongTien()), nf.format(doanhThu.getGiamGia()), nf.format(doanhThu.getThanhTien())};
            modelDoanhThu.addRow(row);
            tongTien += doanhThu.getTongTien();
            thanhTien += doanhThu.getThanhTien();
            giamGia += doanhThu.getGiamGia();
            soHoaDon++;

        }
        txtSoLuongHoaDon.setText(soHoaDon + "");
        txtGiamGia.setText(nf.format(giamGia));
        txtTongTien.setText(nf.format(tongTien));
        txtDoanhThu.setText(nf.format(thanhTien));
    }//GEN-LAST:event_jpThongKeDTMouseClicked

    private void jbLamMoiDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiDoanhThuMouseClicked
        loadDuLieuDoanhThu();
        jdTuNgayDoanhThu.setDate(null);
        jdDenNgayDoanhThu.setDate(null);
        jcbThangDoanhThu.setSelectedIndex(0);
        jcbNamDoanhThu.setSelectedIndex(0);
    }//GEN-LAST:event_jbLamMoiDoanhThuMouseClicked

    private void jcbLuaChonDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLuaChonDoanhThuActionPerformed
        String selectedItem = (String) jcbLuaChonDoanhThu.getSelectedItem();
        switch (selectedItem) {
            case "Theo tháng":
                setComponentState(true, jcbThangDoanhThu, jcbNamDoanhThu);
                setComponentState(false, jdDenNgayDoanhThu, jdTuNgayDoanhThu);
                break;
            case "Tuỳ chỉnh":
                setComponentState(false, jcbThangDoanhThu, jcbNamDoanhThu);
                setComponentState(true, jdDenNgayDoanhThu, jdTuNgayDoanhThu);
                break;
            case "Theo năm":
                setComponentState(false, jcbThangDoanhThu, jdDenNgayDoanhThu, jdTuNgayDoanhThu);
                setComponentState(true, jcbNamDoanhThu);
                break;
            default:
                setComponentState(false, jcbThangDoanhThu, jcbNamDoanhThu, jdDenNgayDoanhThu, jdTuNgayDoanhThu);
                break;
        }
    }//GEN-LAST:event_jcbLuaChonDoanhThuActionPerformed

    private void btnBieuDoSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBieuDoSPMouseClicked
        BieuDoSanPham jf = new BieuDoSanPham();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }//GEN-LAST:event_btnBieuDoSPMouseClicked

//code san pham o day 
    private void jcbLuaChonDoanhThu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLuaChonDoanhThu1ActionPerformed
        String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
        switch (selectedItem) {
            case "Theo tháng":
                setComponentState(true, jcbThangDoanhThu1, jcbNamDoanhThu1);
                setComponentState(false, jdDenNgayDoanhThu1, jdTuNgayDoanhThu1);
                break;
            case "Tuỳ chỉnh":
                setComponentState(false, jcbThangDoanhThu1, jcbNamDoanhThu1);
                setComponentState(true, jdDenNgayDoanhThu1, jdTuNgayDoanhThu1);
                break;
            case "Theo năm":
                setComponentState(false, jcbThangDoanhThu1, jdDenNgayDoanhThu1, jdTuNgayDoanhThu1);
                setComponentState(true, jcbNamDoanhThu1);
                break;
            default:
                setComponentState(false, jcbThangDoanhThu1, jcbNamDoanhThu1, jdDenNgayDoanhThu1, jdTuNgayDoanhThu1);
                break;
        }
    }//GEN-LAST:event_jcbLuaChonDoanhThu1ActionPerformed

    private void jpLXuatPDFSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLXuatPDFSanPhamMouseClicked
        JFramePDFSanPham sanPham = new JFramePDFSanPham(tableSanPham,jcbchonsanpham.getSelectedItem().toString(),txtSoLuongHoaDon1.getText(),txtDoanhThuSP.getText(), txtTongTienKH.getText(), txtsoLuongNDK.getText());
        sanPham.setLocationRelativeTo(null);
        sanPham.setVisible(true); // Do not display the JFrame
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(sanPham.getWidth(), sanPham.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        sanPham.paint(graphics);

        // Đường dẫn mặc định cho tệp PDF
        String defaultPdfFilePath = "D:/ThongKeSanPham.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Convert the image to a PDF file
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImageXObject, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
            contentStream.close();

            document.save(new File(defaultPdfFilePath));
            document.close();

            sanPham.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bạn đã xuất file pdf thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jpLXuatPDFSanPhamMouseClicked

    private void loadDuLieuSanPham() {
        //Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        Set<Integer> uniqueYears = new HashSet<>();
        thongKeSanPhamDAO = new ThongKeSanPhamDAO();
        modelSanPham.setRowCount(0);
        int soHoaDon = 0;
        double tongTien = 0;
        sanPhamList = thongKeSanPhamDAO.getSanPham(null, null);
        for (ThongKeSanPham dtsp : sanPhamList) {
            Object row[] = {dtsp.getMa(), dtsp.getTen(), dtsp.getSoLuong(), nf.format(dtsp.getThanhtien())};
            modelSanPham.addRow(row);
            tongTien += dtsp.getThanhtien();
            soHoaDon += dtsp.getSoLuong();
        }

        txtSoLuongHoaDon1.setText(soHoaDon + "");
        txtDoanhThuSP.setText(nf.format(tongTien));
    }

    //xu li su kien cua sanpham khi an thong ke
    private void jpThongKeSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeSPMouseClicked
        //code o day
        String luaChon = jcbchonsanpham.getSelectedItem().toString();
        if (luaChon.equals("Sản phẩm đã bán")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = thongKeSanPhamDAO.getSanPham(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = thongKeSanPhamDAO.getSanPham(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = thongKeSanPhamDAO.getDoanhThuSanPhamThangNam(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = thongKeSanPhamDAO.getSanPham(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = thongKeSanPhamDAO.getDoanhThuSanPhamThangNam(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        } else if (luaChon.equals("Top 5 sản phẩm được bán nhiều nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanNhieu(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanNhieu(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamBanNhieu(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanNhieu(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamBanNhieu(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        } else if (luaChon.equals("Top 5 sản phẩm được bán ít nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanIt(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanIt(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamBanIt(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = thongKeSanPhamDAO.getSanPhamBanIt(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamBanIt(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));

        } else if (luaChon.equals("Top 5 sản phẩm có doanh thu cao nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuNhieu(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuNhieu(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamDoanhThuNhieu(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuNhieu(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamDoanhThuNhieu(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        } else if (luaChon.equals("Top 5 sản phẩm có doanh thu thấp nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuIt(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuIt(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamDoanhThuIt(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = thongKeSanPhamDAO.getSanPhamDoanhThuIt(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = thongKeSanPhamDAO.getSanPhamThangNamDoanhThuIt(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        } else if (luaChon.equals("Top 5 sản phẩm tồn kho nhiều nhất")) {
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            sanPhamList = thongKeSanPhamDAO.getSanPhamTonKhoNhieu();
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        } else if (luaChon.equals("Top 5 sản phẩm tồn kho ít nhất")) {
            thongKeSanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongTien = 0;
            sanPhamList = thongKeSanPhamDAO.getSanPhamTonKhoIt();
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), nf.format(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongTien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }

            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThuSP.setText(nf.format(tongTien));
        }

    }//GEN-LAST:event_jpThongKeSPMouseClicked
//lam moi san pham
    private void jbLamMoiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiSPMouseClicked
        loadDuLieuSanPham();
        jdTuNgayDoanhThu1.setDate(null);
        jdDenNgayDoanhThu1.setDate(null);
        jcbThangDoanhThu1.setSelectedIndex(0);
        jcbNamDoanhThu1.setSelectedIndex(0);
        jcbchonsanpham.setSelectedIndex(0);
    }//GEN-LAST:event_jbLamMoiSPMouseClicked
//ket thuc san pham o day
    private void btnBieuDoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBieuDoKHMouseClicked
        BieuDoKhachHang jf = null;
        try {
            jf = new BieuDoKhachHang();
        } catch (SQLException ex) {
            Logger.getLogger(JPanel_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }//GEN-LAST:event_btnBieuDoKHMouseClicked
    //code lua chon cua khach hang
    private void jcbLuaChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLuaChonKHActionPerformed

        String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
        switch (selectedItem) {
            case "Theo tháng":
                setComponentState(true, jcbThangKH, jcbNamKH);
                setComponentState(false, jdTuNgayKH, jdDenNgayKH);
                break;
            case "Tuỳ chỉnh":
                setComponentState(false, jcbThangKH, jcbNamKH);
                setComponentState(true, jdTuNgayKH, jdDenNgayKH);
                break;
            case "Theo năm":
                setComponentState(false, jcbThangKH, jdTuNgayKH, jdDenNgayKH);
                setComponentState(true, jcbNamKH);
                break;
            default:
                setComponentState(false, jcbThangKH, jcbNamKH, jdDenNgayKH, jdTuNgayKH);
                break;

        }
    }//GEN-LAST:event_jcbLuaChonKHActionPerformed

    private void jpThongKeKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeKHMouseClicked
        //code Khach Hang o day
        String luaChon = jCBTieuChi.getSelectedItem().toString();
        if (luaChon.equals("Khách hàng đã mua hàng")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinh(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinh(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNam(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinh(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNam(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng tổng chi cao nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiCaoNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiCaoNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamTongChiCaoNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiCaoNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamTongChiCaoNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");

        } else if (luaChon.equals("Top 5 khách hàng tổng chi thấp nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiThapNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiThapNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamTongChiThapNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhTongChiThapNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamTongChiThapNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng mua hàng nhiều nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangNhieuNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangNhieuNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamMuaHangNhieuNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangNhieuNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamMuaHangNhieuNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng mua hàng ít nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangItNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangItNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamMuaHangItNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhMuaHangItNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamMuaHangItNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng thường xuyên mua hàng nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhThuongXuyenMuaHang(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhThuongXuyenMuaHang(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamThuongXuyenMuaHang(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhThuongXuyenMuaHang(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamThuongXuyenMuaHang(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng không thường xuyên mua hàng nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            thongKeKhachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tongTien = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamKhongThuongXuyenMuaHang(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = thongKeKhachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = thongKeKhachHangDAO.getKHThangNamKhongThuongXuyenMuaHang(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), nf.format(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tongTien += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }

            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(nf.format(tongTien));
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        }
    }//GEN-LAST:event_jpThongKeKHMouseClicked

    private void jbLamMoiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiKHMouseClicked
        loadDuLieuKhachHang();
        jdTuNgayKH.setDate(null);
        jdDenNgayKH.setDate(null);
        jcbThangKH.setSelectedIndex(0);
        jcbNamKH.setSelectedIndex(0);
        jCBTieuChi.setSelectedIndex(0);
    }//GEN-LAST:event_jbLamMoiKHMouseClicked

    private void btnBieuDoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBieuDoSPActionPerformed
    //su kien lua chon cua san pham
    private void jcbchonsanphamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbchonsanphamActionPerformed
        if (jcbchonsanpham.getSelectedItem().toString().equals("Top 5 sản phẩm tồn kho nhiều nhất") || jcbchonsanpham.getSelectedItem().toString().equals("Top 5 sản phẩm tồn kho ít nhất")) {
            jdTuNgayDoanhThu1.setDate(null);
            jdDenNgayDoanhThu1.setDate(null);
            jcbThangDoanhThu1.setSelectedIndex(0);
            jcbNamDoanhThu1.setSelectedIndex(0);
            jcbLuaChonDoanhThu1.setEnabled(false);
            jdTuNgayDoanhThu1.setEnabled(false);
            jdDenNgayDoanhThu1.setEnabled(false);
            jcbThangDoanhThu1.setEnabled(false);
            jcbNamDoanhThu1.setEnabled(false);
        } else {
            jcbLuaChonDoanhThu1.setEnabled(true);
            jdTuNgayDoanhThu1.setEnabled(true);
            jdDenNgayDoanhThu1.setEnabled(true);
            jcbThangDoanhThu1.setEnabled(true);
            jcbNamDoanhThu1.setEnabled(true);
        }
    }//GEN-LAST:event_jcbchonsanphamActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        JFrame jf = null;
        try {
            jf = new BieuDoDoanhThu();
        } catch (SQLException ex) {
            Logger.getLogger(JPanel_ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked
    //code khach hang o day

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jpThongKeDTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeDTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jpThongKeDTMouseEntered

    private void jcbLuaChonDoanhThu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbLuaChonDoanhThu1MouseClicked

    }//GEN-LAST:event_jcbLuaChonDoanhThu1MouseClicked

    private void jCBTieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTieuChiActionPerformed

    }//GEN-LAST:event_jCBTieuChiActionPerformed

    private void btnBieuDoKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBieuDoKHActionPerformed

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked
        JFrame_ChiTietSanPham jf = new JFrame_ChiTietSanPham();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        sanPhamDAO = new SanPhamDAO();
        String maSP = tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 0).toString();
        String soLuong = tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 2).toString();
        String tongTien = tableSanPham.getValueAt(tableSanPham.getSelectedRow(), 3).toString();
        for (SanPham sp : sanPhamDAO.selectAll()) {
            if (maSP.equals(sp.getMaSanPham())) {
                jf.chuyenDoiChu(sp.getMaSanPham(), sp.getTenSanPham(), sp.getMaNhaCC(), sp.getTacGia(), sp.getNhaXuatBan(), sp.getDonViTinh(), sp.getDanhMuc(), soLuong, sp.getGia() + "", tongTien, sp.getSoTrang() + "", sp.getNamXuatBan() + "");
                break;
            }
        }
    }//GEN-LAST:event_tableSanPhamMouseClicked

    private void tableKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableKhachHangMouseClicked
        JFrame_ChiTietKhachHang jf = new JFrame_ChiTietKhachHang();
        jf.setLocationRelativeTo(null);

        jf.setVisible(true);
        khachHangDAO = new KhachHangDAO();
        String maKH = tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 0).toString();
        String soLuongSP = tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 7).toString();
        String soLuongDonHang = tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 5).toString();
        String tongTien = tableKhachHang.getValueAt(tableKhachHang.getSelectedRow(), 6).toString();
        for (KhachHang kh : khachHangDAO.getAllKhachHang()) {
            if (maKH.equals(kh.getMaKH())) {
                jf.chuyenDoiChu1(kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getNgaySinh().toString(), kh.getTheVip(), kh.getNgayDangKy().toString(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getDiaChi(), soLuongDonHang, soLuongSP, tongTien);
                break;
            }
        }
    }//GEN-LAST:event_tableKhachHangMouseClicked

    private void jbLXuatExcelSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLXuatExcelSanPhamMouseClicked
        if (modelSanPham.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất excel không", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (exportToExcel(tableSanPham, txtDoanhThuSP.getText())) {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu nên không thể xuất file!");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jbLXuatExcelSanPhamMouseClicked

    private void jbLXuatExcelKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLXuatExcelKhachHangMouseClicked
        if (modelKhachHang.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất excel không", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (exportToExcel(tableKhachHang, txtTongTienKH.getText())) {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu nên không thể xuất file!");
        }
    }//GEN-LAST:event_jbLXuatExcelKhachHangMouseClicked

    private void jpLXuatPDFKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLXuatPDFKhachHangMouseClicked
        JFramePDFKhachHang sanPham = new JFramePDFKhachHang(tableKhachHang,jCBTieuChi.getSelectedItem().toString(),txtSoLuongSPKH.getText(),txtSoLuongDHKH.getText(),txtTongTienKH.getText(),txtsoLuongNDK.getText());
        sanPham.setLocationRelativeTo(null);
        sanPham.setVisible(true); // Do not display the JFrame
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(sanPham.getWidth(), sanPham.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        sanPham.paint(graphics);

        // Đường dẫn mặc định cho tệp PDF
        String defaultPdfFilePath = "D:/ThongKeKhachHang.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Convert the image to a PDF file
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImageXObject, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
            contentStream.close();

            document.save(new File(defaultPdfFilePath));
            document.close();

            sanPham.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bạn đã xuất file pdf thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jpLXuatPDFKhachHangMouseClicked

    private void jbLXuatExcelDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLXuatExcelDoanhThuMouseClicked
        if (modelDoanhThu.getRowCount() > 0) {
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất excel không", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (exportToExcel(tableDoanhThu, txtDoanhThu.getText())) {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công!");
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file không thành công!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu nên không thể xuất file!");
        }
    }//GEN-LAST:event_jbLXuatExcelDoanhThuMouseClicked

    private void jpLXuatPDFDoanhThuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLXuatPDFDoanhThuMouseClicked
        JFramePDFDoanhThu sanPham = new JFramePDFDoanhThu(tableKhachHang,txtSoLuongHoaDon.getText(),txtTongTien.getText(),txtGiamGia.getText(),txtDoanhThu.getText());
        sanPham.setLocationRelativeTo(null);
        sanPham.setVisible(true); // Do not display the JFrame
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        BufferedImage image = new BufferedImage(sanPham.getWidth(), sanPham.getHeight(), BufferedImage.TYPE_INT_ARGB);
        Graphics2D graphics = image.createGraphics();
        sanPham.paint(graphics);

        // Đường dẫn mặc định cho tệp PDF
        String defaultPdfFilePath = "D:/ThongKeDoanhThu.pdf";

        try {
            PDDocument document = new PDDocument();
            PDPage page = new PDPage();
            document.addPage(page);

            // Convert the image to a PDF file
            PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);

            PDPageContentStream contentStream = new PDPageContentStream(document, page);
            contentStream.drawImage(pdImageXObject, 0, 0, page.getMediaBox().getWidth(), page.getMediaBox().getHeight());
            contentStream.close();

            document.save(new File(defaultPdfFilePath));
            document.close();

            sanPham.setVisible(false);
            JOptionPane.showMessageDialog(null, "Bạn đã xuất file pdf thành công");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jpLXuatPDFDoanhThuMouseClicked

    private void svgXuatPDFSanPhamMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgXuatPDFSanPhamMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_svgXuatPDFSanPhamMouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.SVGImage XuatExcelDoanhThu;
    private javax.swing.JButton btnBieuDoKH;
    private javax.swing.JButton btnBieuDoSP;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBTieuChi;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTab;
    private util.JPanelRounded jbLXuatExcelDoanhThu;
    private util.JPanelRounded jbLXuatExcelKhachHang;
    private util.JPanelRounded jbLXuatExcelSanPham;
    private util.JPanelRounded jbLamMoiDoanhThu;
    private util.JPanelRounded jbLamMoiKH;
    private util.JPanelRounded jbLamMoiSP;
    private javax.swing.JComboBox<String> jcbLuaChonDoanhThu;
    private javax.swing.JComboBox<String> jcbLuaChonDoanhThu1;
    private javax.swing.JComboBox<String> jcbLuaChonKH;
    private javax.swing.JComboBox<String> jcbNamDoanhThu;
    private javax.swing.JComboBox<String> jcbNamDoanhThu1;
    private javax.swing.JComboBox<String> jcbNamKH;
    private javax.swing.JComboBox<String> jcbThangDoanhThu;
    private javax.swing.JComboBox<String> jcbThangDoanhThu1;
    private javax.swing.JComboBox<String> jcbThangKH;
    private javax.swing.JComboBox<String> jcbchonsanpham;
    private com.toedter.calendar.JDateChooser jdDenNgayDoanhThu;
    private com.toedter.calendar.JDateChooser jdDenNgayDoanhThu1;
    private com.toedter.calendar.JDateChooser jdDenNgayKH;
    private com.toedter.calendar.JDateChooser jdTuNgayDoanhThu;
    private com.toedter.calendar.JDateChooser jdTuNgayDoanhThu1;
    private com.toedter.calendar.JDateChooser jdTuNgayKH;
    private javax.swing.JPanel jpChucNangDoanhThu;
    private javax.swing.JPanel jpChucNangKH;
    private javax.swing.JPanel jpChucNangSanPham;
    private util.JPanelRounded jpLXuatPDFDoanhThu;
    private util.JPanelRounded jpLXuatPDFKhachHang;
    private util.JPanelRounded jpLXuatPDFSanPham;
    private util.JPanelRounded jpThongKeDT;
    private util.JPanelRounded jpThongKeKH;
    private util.JPanelRounded jpThongKeSP;
    private javax.swing.JLabel lblDenNgay;
    private javax.swing.JLabel lblDenNgayKH;
    private javax.swing.JLabel lblDenNgaySanPham;
    private javax.swing.JLabel lblDoanhThu;
    private javax.swing.JLabel lblDoanhThuKH;
    private javax.swing.JLabel lblDoanhThuKH1;
    private javax.swing.JLabel lblDoanhThuSanPham;
    private javax.swing.JLabel lblGiamGia;
    private javax.swing.JLabel lblInBaoCaoSP;
    private javax.swing.JLabel lblInBaoCaoSP1;
    private javax.swing.JLabel lblInBaoCaoSP2;
    private javax.swing.JLabel lblLamMoiDoanhThu;
    private javax.swing.JLabel lblLamMoiKH;
    private javax.swing.JLabel lblLamMoiSP;
    private javax.swing.JLabel lblLamMoiSP1;
    private javax.swing.JLabel lblLamMoiSP2;
    private javax.swing.JLabel lblLamMoiSP3;
    private javax.swing.JLabel lblLuaChonDoanhThu;
    private javax.swing.JLabel lblLuaChonKH;
    private javax.swing.JLabel lblLuaChonSP;
    private javax.swing.JLabel lblNamDoanhThu;
    private javax.swing.JLabel lblNamKH;
    private javax.swing.JLabel lblNamSP;
    private javax.swing.JLabel lblSoLuongHoaDon;
    private javax.swing.JLabel lblSoLuongHoaDonKH;
    private javax.swing.JLabel lblSoLuongHoaDonKH1;
    private javax.swing.JLabel lblSoLuongHoaDonSP;
    private javax.swing.JLabel lblThangDoanhThu;
    private javax.swing.JLabel lblThangKH;
    private javax.swing.JLabel lblThangSP;
    private javax.swing.JLabel lblThongKeDoanhThu;
    private javax.swing.JLabel lblThongKeKH;
    private javax.swing.JLabel lblThongKeSP;
    private javax.swing.JLabel lblTongDoanhThu;
    private javax.swing.JLabel lblTongDoanhThuKH;
    private javax.swing.JLabel lblTongDoanhThuSanPham;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JLabel lblTuNgayKH;
    private javax.swing.JLabel lblTuNgaySP;
    private javax.swing.JScrollPane scrollDoanhThu;
    private javax.swing.JScrollPane scrollKhachHang;
    private javax.swing.JScrollPane scrollSanPham;
    private util.SVGImage svgLamMoiDoanhThu;
    private util.SVGImage svgLamMoiKH;
    private util.SVGImage svgLamMoiSP;
    private util.SVGImage svgThongKeDoanhThu;
    private util.SVGImage svgThongKeKH;
    private util.SVGImage svgThongKeSP;
    private util.SVGImage svgXuatExcelKhachHang;
    private util.SVGImage svgXuatExcelSanPham;
    private util.SVGImage svgXuatPDFDoanhThu;
    private util.SVGImage svgXuatPDFKhachHang;
    private util.SVGImage svgXuatPDFSanPham;
    private javax.swing.JPanel tabDoanhThu;
    private javax.swing.JPanel tabKhachHang;
    private javax.swing.JPanel tabSanPham;
    private javax.swing.JTable tableDoanhThu;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtDoanhThuSP;
    private javax.swing.JLabel txtGiamGia;
    private javax.swing.JLabel txtSoLuongDHKH;
    private javax.swing.JLabel txtSoLuongHoaDon;
    private javax.swing.JLabel txtSoLuongHoaDon1;
    private javax.swing.JLabel txtSoLuongSPKH;
    private javax.swing.JLabel txtTongTien;
    private javax.swing.JLabel txtTongTienKH;
    private javax.swing.JLabel txtsoLuongNDK;
    // End of variables declaration//GEN-END:variables

}
