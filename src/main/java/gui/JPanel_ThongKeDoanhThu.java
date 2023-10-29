package gui;

import dao.ThongKeDoanhThuDAO;
import dao.ThongKeKhachHangDAO;
import dao.ThongKeSanPhamDAO;
import entity.ThongKeDoanhThu;
import entity.ThongKeKhachHang;
import entity.ThongKeSanPham;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static util.ExcelExporter.exportToExcel;


public class JPanel_ThongKeDoanhThu extends javax.swing.JPanel {

    private final DefaultTableModel modelDoanhThu;
    private final DefaultTableModel modelSanPham;
    private final DefaultTableModel modelKhachHang;
     private ArrayList<ThongKeDoanhThu> doanhThuList = new ArrayList<>();
    private ArrayList<ThongKeSanPham> sanPhamList = new ArrayList<>();
    private ArrayList<ThongKeKhachHang> khachHangList = new ArrayList<>();
      private ThongKeDoanhThuDAO doanhThuDAO;
    private ThongKeSanPhamDAO sanPhamDAO;
    private ThongKeKhachHangDAO khachHangDAO;

    public JPanel_ThongKeDoanhThu() {
        initComponents();
        modelDoanhThu = (DefaultTableModel) tableDoanhThu.getModel();
        modelSanPham = (DefaultTableModel) tableSanPham.getModel();
        modelKhachHang = (DefaultTableModel) tableKhachHang.getModel();
        svgThongKeKH.setSvgImage("statistical.svg", 25, 25);
        svgLamMoiKH.setSvgImage("refresh.svg", 25, 25);
        svgThongKeDoanhThu.setSvgImage("statistical.svg", 25, 25);
        svgLamMoiDoanhThu.setSvgImage("refresh.svg", 25, 25);
        svgThongKeSP.setSvgImage("statistical.svg", 25, 25);
        svgLamMoiSP.setSvgImage("refresh.svg", 25, 25);
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
          doanhThuDAO = new ThongKeDoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tong = 0;
        doanhThuList = doanhThuDAO.getHoaDon(null, null);
        for (ThongKeDoanhThu doanhThu : doanhThuList) {
            Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), new BigDecimal(doanhThu.getTongtien())};
            modelDoanhThu.addRow(row);
            tong += doanhThu.getTongtien();
            soHoaDon++;
            uniqueYears.add(doanhThu.getNgaylaphoadon().toLocalDate().getYear());
        }
        jcbNamDoanhThu.removeAllItems();
        for (Integer year : uniqueYears) {
            jcbNamDoanhThu.addItem(year.toString());
        }
        BigDecimal tongTien = new BigDecimal(tong);
        txtSoLuongHoaDon.setText(soHoaDon + "");
        txtDoanhThu.setText(tongTien + "");

    }

    private void loadDuLieuKhachHang() {
        //Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        Set<Integer> uniqueYears = new HashSet<>();
        khachHangDAO = new ThongKeKhachHangDAO();
        modelKhachHang.setRowCount(0);
        int soLuongSanPham = 0;
        int soHoaDon = 0;
        double tong = 0;
        int soLuongNDK = 0;
        khachHangList = khachHangDAO.getKHTuyChinh(null, null);
        for (ThongKeKhachHang kh : khachHangList) {
            Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
            modelKhachHang.addRow(row);
            soLuongSanPham += kh.getTongSoLuongSP();
            tong += kh.getTongTien();
            soHoaDon += kh.getSoLuongDonHang();
            soLuongNDK++;
        }
        BigDecimal tongTien = new BigDecimal(tong);
        txtSoLuongDHKH.setText(soHoaDon + "");
        txtTongTienKH.setText(tongTien + "");
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
        btnXuatExcel = new javax.swing.JButton();
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
        txtDoanhThu1 = new javax.swing.JLabel();
        txtSoLuongHoaDon1 = new javax.swing.JLabel();
        lblTuNgaySP = new javax.swing.JLabel();
        btnBieuDoSP = new javax.swing.JButton();
        jcbLuaChonDoanhThu1 = new javax.swing.JComboBox<>();
        jpInBaoCaoSP = new util.JPanelRounded();
        lblInBaoCaoSP = new javax.swing.JLabel();
        svgInBaoCaoSP = new util.SVGImage();
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
        jpInBaoCaoKH = new util.JPanelRounded();
        lblInBaoCaoKH = new javax.swing.JLabel();
        svgInBaoCaoKH = new util.SVGImage();
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

        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jTab.setPreferredSize(new java.awt.Dimension(100, 760));

        tabDoanhThu.setPreferredSize(new java.awt.Dimension(1061, 760));
        tabDoanhThu.setLayout(new java.awt.BorderLayout());

        scrollDoanhThu.setPreferredSize(new java.awt.Dimension(452, 395));

        tableDoanhThu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Ngày tạo", "Tổng thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollDoanhThu.setViewportView(tableDoanhThu);

        tabDoanhThu.add(scrollDoanhThu, java.awt.BorderLayout.CENTER);

        jpChucNangDoanhThu.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangDoanhThu.setPreferredSize(new java.awt.Dimension(310, 710));
        jpChucNangDoanhThu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpChucNangDoanhThu.add(jdDenNgayDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 30));
        jpChucNangDoanhThu.add(jdTuNgayDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 30));

        lblDenNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDenNgay.setText("Đến ngày:");
        jpChucNangDoanhThu.add(lblDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 30));

        lblDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThu.setText("Doanh thu:");
        jpChucNangDoanhThu.add(lblDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        lblTongDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongDoanhThu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThu.setText("TỔNG DOANH THU");
        jpChucNangDoanhThu.add(lblTongDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        lblSoLuongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDon.setText("Số lượng hóa đơn bán được:");
        jpChucNangDoanhThu.add(lblSoLuongHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 30));

        txtDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 110, 30));

        txtSoLuongHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangDoanhThu.add(txtSoLuongHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, 30));

        lblTuNgay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTuNgay.setText("Từ ngày:");
        jpChucNangDoanhThu.add(lblTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        btnXuatExcel.setText("XUẤT RA FILE EXCEL");
        btnXuatExcel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXuatExcelMouseClicked(evt);
            }
        });
        btnXuatExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatExcelActionPerformed(evt);
            }
        });
        jpChucNangDoanhThu.add(btnXuatExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 170, 50));

        jcbLuaChonDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbLuaChonDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonDoanhThuActionPerformed(evt);
            }
        });
        jpChucNangDoanhThu.add(jcbLuaChonDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, 30));

        lblLuaChonDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLuaChonDoanhThu.setText("Thống kê theo:");
        jpChucNangDoanhThu.add(lblLuaChonDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

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

        lblThongKeDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongKeDoanhThu.setText("Thống kê");
        jpThongKeDT.add(lblThongKeDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        svgThongKeDoanhThu.setText(" ");
        jpThongKeDT.add(svgThongKeDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangDoanhThu.add(jpThongKeDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 40));

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

        lblLamMoiDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLamMoiDoanhThu.setText("Làm mới");
        jbLamMoiDoanhThu.add(lblLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgLamMoiDoanhThu.setText(" ");
        jbLamMoiDoanhThu.add(svgLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangDoanhThu.add(jbLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 250, 110, 40));
        jpChucNangDoanhThu.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 280, 10));

        lblNamDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamDoanhThu.setText("Năm :");
        jpChucNangDoanhThu.add(lblNamDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 30));

        lblThangDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThangDoanhThu.setText("Tháng :");
        jpChucNangDoanhThu.add(lblThangDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 30));

        jcbThangDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangDoanhThu.setEnabled(false);
        jpChucNangDoanhThu.add(jcbThangDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 60, 30));

        jcbNamDoanhThu.setEnabled(false);
        jpChucNangDoanhThu.add(jcbNamDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 90, 30));

        jButton3.setText("Biểu đồ tổng quát");
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
        jpChucNangDoanhThu.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 170, 50));

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
                java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollSanPham.setViewportView(tableSanPham);

        tabSanPham.add(scrollSanPham, java.awt.BorderLayout.CENTER);

        jpChucNangSanPham.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangSanPham.setPreferredSize(new java.awt.Dimension(310, 710));
        jpChucNangSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpChucNangSanPham.add(jdTuNgayDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, 30));
        jpChucNangSanPham.add(jdDenNgayDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 150, 180, 30));

        lblDenNgaySanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDenNgaySanPham.setText("Đến ngày:");
        jpChucNangSanPham.add(lblDenNgaySanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 70, 30));

        lblDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThuSanPham.setText("Tổng tiền:");
        jpChucNangSanPham.add(lblDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        lblTongDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongDoanhThuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuSanPham.setText("TỔNG SẢN PHẨM");
        jpChucNangSanPham.add(lblTongDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        lblSoLuongHoaDonSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDonSP.setText("Số lượng sản phẩm đã bán được:");
        jpChucNangSanPham.add(lblSoLuongHoaDonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 240, 30));

        txtDoanhThu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 110, 30));

        txtSoLuongHoaDon1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtSoLuongHoaDon1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 450, 80, 30));

        lblTuNgaySP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTuNgaySP.setText("Từ ngày:");
        jpChucNangSanPham.add(lblTuNgaySP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 80, 30));

        btnBieuDoSP.setText("BIỂU ĐỒ SẢN PHẨM");
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
        jpChucNangSanPham.add(btnBieuDoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 170, 50));

        jcbLuaChonDoanhThu1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
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
        jpChucNangSanPham.add(jcbLuaChonDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 160, 30));

        jpInBaoCaoSP.setBackground(new java.awt.Color(255, 255, 255));
        jpInBaoCaoSP.setRoundedBottomLeft(10);
        jpInBaoCaoSP.setRoundedBottomRight(10);
        jpInBaoCaoSP.setRoundedTopLeft(10);
        jpInBaoCaoSP.setRoundedTopRight(10);
        jpInBaoCaoSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpInBaoCaoSPMouseClicked(evt);
            }
        });
        jpInBaoCaoSP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCaoSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInBaoCaoSP.setText("In báo cáo");
        jpInBaoCaoSP.add(lblInBaoCaoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgInBaoCaoSP.setText(" ");
        jpInBaoCaoSP.add(svgInBaoCaoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangSanPham.add(jpInBaoCaoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 120, 40));

        lblLuaChonSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLuaChonSP.setText("Thống kê theo:");
        jpChucNangSanPham.add(lblLuaChonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

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

        lblThongKeSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongKeSP.setText("Thống kê");
        jpThongKeSP.add(lblThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        svgThongKeSP.setText(" ");
        jpThongKeSP.add(svgThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangSanPham.add(jpThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 110, 40));

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

        lblLamMoiSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLamMoiSP.setText("Làm mới");
        jbLamMoiSP.add(lblLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgLamMoiSP.setText(" ");
        jbLamMoiSP.add(svgLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangSanPham.add(jbLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 320, 110, 40));
        jpChucNangSanPham.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 280, 10));

        lblNamSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamSP.setText("Năm :");
        jpChucNangSanPham.add(lblNamSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, 30));

        lblThangSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThangSP.setText("Tháng :");
        jpChucNangSanPham.add(lblThangSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 60, 30));

        jcbThangDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangDoanhThu1.setEnabled(false);
        jpChucNangSanPham.add(jcbThangDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, 60, 30));

        jcbNamDoanhThu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", " " }));
        jcbNamDoanhThu1.setEnabled(false);
        jpChucNangSanPham.add(jcbNamDoanhThu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 90, 30));

        jcbchonsanpham.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbchonsanpham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm đã bán", "Top 5 sản phẩm được bán nhiều nhất", "Top 5 sản phẩm được bán ít nhất", "Top 5 sản phẩm có doanh thu cao nhất", "Top 5 sản phẩm có doanh thu thấp nhất", "Top 5 sản phẩm tồn kho nhiều nhất", "Top 5 sản phẩm tồn kho ít nhất" }));
        jcbchonsanpham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbchonsanphamActionPerformed(evt);
            }
        });
        jpChucNangSanPham.add(jcbchonsanpham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 280, 30));

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
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollKhachHang.setViewportView(tableKhachHang);

        tabKhachHang.add(scrollKhachHang, java.awt.BorderLayout.CENTER);

        jpChucNangKH.setMinimumSize(new java.awt.Dimension(310, 715));
        jpChucNangKH.setPreferredSize(new java.awt.Dimension(310, 710));
        jpChucNangKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpChucNangKH.add(jdDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 180, 30));
        jpChucNangKH.add(jdTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 180, 30));

        lblDenNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDenNgayKH.setText("Đến ngày:");
        jpChucNangKH.add(lblDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, 70, 30));

        lblDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThuKH.setText("Tổng tiền:");
        jpChucNangKH.add(lblDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 80, 30));

        lblTongDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongDoanhThuKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuKH.setText("TỔNG DOANH THU");
        jpChucNangKH.add(lblTongDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        lblSoLuongHoaDonKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDonKH.setText("Số lượng sản phẩm:");
        jpChucNangKH.add(lblSoLuongHoaDonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 30));

        txtTongTienKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtTongTienKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 530, 110, 30));

        txtSoLuongSPKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtSoLuongSPKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, 30));

        lblTuNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTuNgayKH.setText("Từ ngày:");
        jpChucNangKH.add(lblTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 80, 30));

        btnBieuDoKH.setText("BIỂU ĐỒ KHÁCH HÀNG");
        btnBieuDoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBieuDoKHMouseClicked(evt);
            }
        });
        jpChucNangKH.add(btnBieuDoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 630, 170, 50));

        jcbLuaChonKH.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbLuaChonKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonKHActionPerformed(evt);
            }
        });
        jpChucNangKH.add(jcbLuaChonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, 30));

        jpInBaoCaoKH.setBackground(new java.awt.Color(255, 255, 255));
        jpInBaoCaoKH.setRoundedBottomLeft(10);
        jpInBaoCaoKH.setRoundedBottomRight(10);
        jpInBaoCaoKH.setRoundedTopLeft(10);
        jpInBaoCaoKH.setRoundedTopRight(10);
        jpInBaoCaoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpInBaoCaoKHMouseClicked(evt);
            }
        });
        jpInBaoCaoKH.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCaoKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInBaoCaoKH.setText("In báo cáo");
        jpInBaoCaoKH.add(lblInBaoCaoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgInBaoCaoKH.setText(" ");
        jpInBaoCaoKH.add(svgInBaoCaoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangKH.add(jpInBaoCaoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 120, 40));

        lblLuaChonKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLuaChonKH.setText("Thống kê theo:");
        jpChucNangKH.add(lblLuaChonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, 30));

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

        lblThongKeKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThongKeKH.setText("Thống kê");
        jpThongKeKH.add(lblThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 70, 40));

        svgThongKeKH.setText(" ");
        jpThongKeKH.add(svgThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangKH.add(jpThongKeKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 40));

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

        lblLamMoiKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblLamMoiKH.setText("Làm mới");
        jbLamMoiKH.add(lblLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgLamMoiKH.setText(" ");
        jbLamMoiKH.add(svgLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangKH.add(jbLamMoiKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 110, 40));
        jpChucNangKH.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 280, 10));

        lblNamKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamKH.setText("Năm :");
        jpChucNangKH.add(lblNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, 30));

        lblThangKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThangKH.setText("Tháng :");
        jpChucNangKH.add(lblThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 60, 30));

        jcbThangKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangKH.setEnabled(false);
        jpChucNangKH.add(jcbThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, 60, 30));

        jcbNamKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019", "2020", "2021", "2022", "2023", " " }));
        jcbNamKH.setEnabled(false);
        jpChucNangKH.add(jcbNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 210, 90, 30));

        jCBTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jCBTieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Khách hàng đã mua hàng", "Top 5 khách hàng tổng chi cao nhất", "Top 5 khách hàng tổng chi thấp nhất", "Top 5 khách hàng mua hàng nhiều nhất", "Top 5 khách hàng mua hàng ít nhất", "Top 5 khách hàng thường xuyên mua hàng nhất", "Top 5 khách hàng không thường xuyên mua hàng nhất" }));
        jCBTieuChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBTieuChiActionPerformed(evt);
            }
        });
        jpChucNangKH.add(jCBTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 270, 30));

        lblSoLuongHoaDonKH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDonKH1.setText("Số lượng đơn hàng:");
        jpChucNangKH.add(lblSoLuongHoaDonKH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 200, 30));

        txtSoLuongDHKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtSoLuongDHKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 490, 80, 30));

        lblDoanhThuKH1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThuKH1.setText("Số lượng người đăng ký:");
        jpChucNangKH.add(lblDoanhThuKH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 170, 30));

        txtsoLuongNDK.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtsoLuongNDK, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, 50, 30));

        tabKhachHang.add(jpChucNangKH, java.awt.BorderLayout.WEST);

        jTab.addTab("Khách hàng", tabKhachHang);

        add(jTab, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnXuatExcelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXuatExcelMouseClicked
        String selectedItem = (String) jcbLuaChonDoanhThu.getSelectedItem();
        if (modelDoanhThu.getRowCount() > 0) {
            java.util.Date currDate = new java.util.Date();
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
            String formattedDate = dateFormat.format(currDate);
            if (JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất excel không", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                String filePath = "D:\\DoanhThu_" + selectedItem + "_" + formattedDate + ".xlsx";
                if (exportToExcel(doanhThuList, filePath)) {
                    JOptionPane.showMessageDialog(this, "Xuất file thành công: " + filePath);
                } else {
                    JOptionPane.showMessageDialog(this, "Xuất file không thành công: " + filePath);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Không có dữ liệu nên không thể xuất file!");
        }
    }//GEN-LAST:event_btnXuatExcelMouseClicked

    private void jpThongKeDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeDTMouseClicked
        String selectedItem = (String) jcbLuaChonDoanhThu.getSelectedItem();
         doanhThuDAO = new ThongKeDoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tong = 0;
        java.util.Date currDate = new java.util.Date();
        switch (selectedItem) {
            case "Theo ngày":
                doanhThuList = doanhThuDAO.getHoaDon(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                break;
            case "Theo tuần":
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currDate);
                calendar.add(Calendar.DAY_OF_MONTH, -7);
                java.util.Date weekAgo = calendar.getTime();
                doanhThuList = doanhThuDAO.getHoaDon(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                break;
            case "Theo tháng":
                doanhThuList = doanhThuDAO.getDoanhThuThangNam(Integer.parseInt(jcbThangDoanhThu.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()));
                break;
            case "Tuỳ chỉnh":
                java.sql.Date tuNgay = jdTuNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu.getDate().getTime());
                java.sql.Date denNgay = jdDenNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu.getDate().getTime());
                doanhThuList = doanhThuDAO.getHoaDon(tuNgay, denNgay);
                break;

            case "Theo năm":
                doanhThuList = doanhThuDAO.getDoanhThuThangNam(0, Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()));
                break;
            default:
                break;
        }
        //Load table
        for (ThongKeDoanhThu doanhThu : doanhThuList) {
            Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), new BigDecimal(doanhThu.getTongtien())};
            modelDoanhThu.addRow(row);
            tong += doanhThu.getTongtien();
            soHoaDon++;
        }
        BigDecimal tongTien = new BigDecimal(tong);
        txtSoLuongHoaDon.setText(soHoaDon + "");
        txtDoanhThu.setText(tongTien + "");
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

    private void jpInBaoCaoSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInBaoCaoSPMouseClicked

    }//GEN-LAST:event_jpInBaoCaoSPMouseClicked

    private void loadDuLieuSanPham() {
        //Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        Set<Integer> uniqueYears = new HashSet<>();
        sanPhamDAO = new ThongKeSanPhamDAO();
        modelSanPham.setRowCount(0);
        int soHoaDon = 0;
        double tong = 0;
        sanPhamList = sanPhamDAO.getSanPham(null, null);
        for (ThongKeSanPham dtsp : sanPhamList) {
            Object row[] = {dtsp.getMa(), dtsp.getTen(), dtsp.getSoLuong(), new BigDecimal(dtsp.getThanhtien())};
            modelSanPham.addRow(row);
            tong += dtsp.getThanhtien();
            soHoaDon += dtsp.getSoLuong();
        }

        BigDecimal tongTien = new BigDecimal(tong);
        txtSoLuongHoaDon1.setText(soHoaDon + "");
        txtDoanhThu1.setText(tongTien + "");
    }

    //xu li su kien cua sanpham khi an thong ke
    private void jpThongKeSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeSPMouseClicked
        //code o day
        String luaChon = jcbchonsanpham.getSelectedItem().toString();
        if (luaChon.equals("Sản phẩm đã bán")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = sanPhamDAO.getSanPham(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = sanPhamDAO.getSanPham(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = sanPhamDAO.getDoanhThuSanPhamThangNam(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = sanPhamDAO.getSanPham(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = sanPhamDAO.getDoanhThuSanPhamThangNam(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
        } else if (luaChon.equals("Top 5 sản phẩm được bán nhiều nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = sanPhamDAO.getSanPhamBanNhieu(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = sanPhamDAO.getSanPhamBanNhieu(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamBanNhieu(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = sanPhamDAO.getSanPhamBanNhieu(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamBanNhieu(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
        } else if (luaChon.equals("Top 5 sản phẩm được bán ít nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = sanPhamDAO.getSanPhamBanIt(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = sanPhamDAO.getSanPhamBanIt(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamBanIt(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = sanPhamDAO.getSanPhamBanIt(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamBanIt(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");

        } else if (luaChon.equals("Top 5 sản phẩm có doanh thu cao nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuNhieu(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuNhieu(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamDoanhThuNhieu(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuNhieu(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamDoanhThuNhieu(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
        } else if (luaChon.equals("Top 5 sản phẩm có doanh thu thấp nhất")) {
            String selectedItem = (String) jcbLuaChonDoanhThu1.getSelectedItem();
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuIt(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuIt(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamDoanhThuIt(Integer.parseInt(jcbThangDoanhThu1.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu1.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayDoanhThu1.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu1.getDate().getTime());
                    sanPhamList = sanPhamDAO.getSanPhamDoanhThuIt(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    sanPhamList = sanPhamDAO.getSanPhamThangNamDoanhThuIt(0, Integer.parseInt(jcbNamDoanhThu1.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
        } else if (luaChon.equals("Top 5 sản phẩm tồn kho nhiều nhất")) {
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            sanPhamList = sanPhamDAO.getSanPhamTonKhoNhieu();
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
        } else if (luaChon.equals("Top 5 sản phẩm tồn kho ít nhất")) {
            sanPhamDAO = new ThongKeSanPhamDAO();
            modelSanPham.setRowCount(0);
            int sosanpham = 0;
            double tongtien = 0;
            sanPhamList = sanPhamDAO.getSanPhamTonKhoIt();
            for (ThongKeSanPham dtSanPham : sanPhamList) {
                Object row[] = {dtSanPham.getMa(), dtSanPham.getTen(), dtSanPham.getSoLuong(), new BigDecimal(dtSanPham.getThanhtien())};
                modelSanPham.addRow(row);
                tongtien += dtSanPham.getThanhtien();
                sosanpham += dtSanPham.getSoLuong();
            }
            BigDecimal tongTien1 = new BigDecimal(tongtien);
            txtSoLuongHoaDon1.setText(sosanpham + "");
            txtDoanhThu1.setText(tongTien1 + "");
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
        BieuDoKhachHang jf = new BieuDoKhachHang();
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

    private void jpInBaoCaoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInBaoCaoKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpInBaoCaoKHMouseClicked

    private void jpThongKeKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeKHMouseClicked
        //code Khach Hang o day
        String luaChon = jCBTieuChi.getSelectedItem().toString();
        if (luaChon.equals("Khách hàng đã mua hàng")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinh(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinh(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNam(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinh(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNam(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng tổng chi cao nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiCaoNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiCaoNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamTongChiCaoNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiCaoNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamTongChiCaoNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");

        } else if (luaChon.equals("Top 5 khách hàng tổng chi thấp nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiThapNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiThapNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamTongChiThapNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhTongChiThapNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamTongChiThapNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng mua hàng nhiều nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangNhieuNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangNhieuNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamMuaHangNhieuNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangNhieuNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamMuaHangNhieuNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng mua hàng ít nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangItNhat(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangItNhat(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamMuaHangItNhat(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhMuaHangItNhat(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamMuaHangItNhat(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng thường xuyên mua hàng nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhThuongXuyenMuaHang(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhThuongXuyenMuaHang(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamThuongXuyenMuaHang(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhThuongXuyenMuaHang(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamThuongXuyenMuaHang(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
            txtSoLuongSPKH.setText(soLuongSanPham + "");
            txtsoLuongNDK.setText(soLuongNDK + "");
        } else if (luaChon.equals("Top 5 khách hàng không thường xuyên mua hàng nhất")) {
            String selectedItem = (String) jcbLuaChonKH.getSelectedItem();
            khachHangDAO = new ThongKeKhachHangDAO();
            modelKhachHang.setRowCount(0);
            int soLuongSanPham = 0;
            int soHoaDon = 0;
            double tong = 0;
            int soLuongNDK = 0;
            java.util.Date currDate = new java.util.Date();
            switch (selectedItem) {
                case "Theo ngày":
                    khachHangList = khachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tuần":
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(currDate);
                    calendar.add(Calendar.DAY_OF_MONTH, -7);
                    java.util.Date weekAgo = calendar.getTime();
                    khachHangList = khachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()));
                    break;
                case "Theo tháng":
                    khachHangList = khachHangDAO.getKHThangNamKhongThuongXuyenMuaHang(Integer.parseInt(jcbThangKH.getSelectedItem().toString()), Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                case "Tuỳ chỉnh":
                    java.sql.Date tuNgay = jdTuNgayKH.getDate() == null ? null : new java.sql.Date(jdTuNgayKH.getDate().getTime());
                    java.sql.Date denNgay = jdDenNgayKH.getDate() == null ? null : new java.sql.Date(jdDenNgayKH.getDate().getTime());
                    khachHangList = khachHangDAO.getKHTuyChinhKhongThuongXuyenMuaHang(tuNgay, denNgay);
                    break;

                case "Theo năm":
                    khachHangList = khachHangDAO.getKHThangNamKhongThuongXuyenMuaHang(0, Integer.parseInt(jcbNamKH.getSelectedItem().toString()));
                    break;
                default:
                    break;
            }
            //Load table
            for (ThongKeKhachHang kh : khachHangList) {
                Object row[] = {kh.getMaKhachHang(), kh.getTenKhachHang(), kh.getsDT(), kh.getGioiTinh(), kh.getNgayDangKy(), kh.getSoLuongDonHang(), new BigDecimal(kh.getTongTien()), kh.getTongSoLuongSP()};
                modelKhachHang.addRow(row);
                soLuongSanPham += kh.getTongSoLuongSP();
                tong += kh.getTongTien();
                soHoaDon += kh.getSoLuongDonHang();
                soLuongNDK++;
            }
            BigDecimal tong1= new BigDecimal(tong);
            txtSoLuongDHKH.setText(soHoaDon + "");
            txtTongTienKH.setText(tong1 + "");
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
            Logger.getLogger(JPanel_ThongKeDoanhThu.class.getName()).log(Level.SEVERE, null, ex);
        }
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }//GEN-LAST:event_jButton3MouseClicked
    //code khach hang o day

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnXuatExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatExcelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXuatExcelActionPerformed

    private void jpThongKeDTMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeDTMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jpThongKeDTMouseEntered

    private void jcbLuaChonDoanhThu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jcbLuaChonDoanhThu1MouseClicked

    }//GEN-LAST:event_jcbLuaChonDoanhThu1MouseClicked

    private void jCBTieuChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBTieuChiActionPerformed

    }//GEN-LAST:event_jCBTieuChiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDoKH;
    private javax.swing.JButton btnBieuDoSP;
    private javax.swing.JButton btnXuatExcel;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jCBTieuChi;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTab;
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
    private util.JPanelRounded jpInBaoCaoKH;
    private util.JPanelRounded jpInBaoCaoSP;
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
    private javax.swing.JLabel lblInBaoCaoKH;
    private javax.swing.JLabel lblInBaoCaoSP;
    private javax.swing.JLabel lblLamMoiDoanhThu;
    private javax.swing.JLabel lblLamMoiKH;
    private javax.swing.JLabel lblLamMoiSP;
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
    private javax.swing.JLabel lblTuNgay;
    private javax.swing.JLabel lblTuNgayKH;
    private javax.swing.JLabel lblTuNgaySP;
    private javax.swing.JScrollPane scrollDoanhThu;
    private javax.swing.JScrollPane scrollKhachHang;
    private javax.swing.JScrollPane scrollSanPham;
    private util.SVGImage svgInBaoCaoKH;
    private util.SVGImage svgInBaoCaoSP;
    private util.SVGImage svgLamMoiDoanhThu;
    private util.SVGImage svgLamMoiKH;
    private util.SVGImage svgLamMoiSP;
    private util.SVGImage svgThongKeDoanhThu;
    private util.SVGImage svgThongKeKH;
    private util.SVGImage svgThongKeSP;
    private javax.swing.JPanel tabDoanhThu;
    private javax.swing.JPanel tabKhachHang;
    private javax.swing.JPanel tabSanPham;
    private javax.swing.JTable tableDoanhThu;
    private javax.swing.JTable tableKhachHang;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JLabel txtDoanhThu;
    private javax.swing.JLabel txtDoanhThu1;
    private javax.swing.JLabel txtSoLuongDHKH;
    private javax.swing.JLabel txtSoLuongHoaDon;
    private javax.swing.JLabel txtSoLuongHoaDon1;
    private javax.swing.JLabel txtSoLuongSPKH;
    private javax.swing.JLabel txtTongTienKH;
    private javax.swing.JLabel txtsoLuongNDK;
    // End of variables declaration//GEN-END:variables

}
