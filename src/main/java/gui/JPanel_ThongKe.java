/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.DoanhThuDAO;
import entity.DoanhThu;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JComponent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BanhMi88
 */
public class JPanel_ThongKe extends javax.swing.JPanel {

    private final DefaultTableModel modelDoanhThu;

    private DoanhThuDAO doanhThuDAO;

    public JPanel_ThongKe() {
        initComponents();
        modelDoanhThu = (DefaultTableModel) tableDoanhThu.getModel();
        svgThongKeDoanhThu.setSvgImage("statistical.svg", 25, 25);
        svgInBaoCao.setSvgImage("print.svg", 25, 25);
        svgLamMoiDoanhThu.setSvgImage("refresh.svg", 25, 25);
        loadDuLieuDoanhThu();
    }

    private void setComponentState(boolean set, JComponent... components) {
        for (JComponent component : components) {
            component.setEnabled(set);
        }
    }

    private void loadDuLieuDoanhThu() {
        //Tạo mảng không trùng bằng set và sử dụng HashSet để lọc
        Set<Integer> uniqueYears = new HashSet<>();
        doanhThuDAO = new DoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tong = 0;
        for (DoanhThu doanhThu : doanhThuDAO.getHoaDon(null, null)) {
            Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
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
        btnBieuDoDT = new javax.swing.JButton();
        jcbLuaChonDoanhThu = new javax.swing.JComboBox<>();
        jpInBaoCao = new util.JPanelRounded();
        lblInBaoCao = new javax.swing.JLabel();
        svgInBaoCao = new util.SVGImage();
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
        tabSanPham = new javax.swing.JPanel();
        scrollSanPham = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();
        jpChucNangSanPham = new javax.swing.JPanel();
        jdDenNgaySanPham = new com.toedter.calendar.JDateChooser();
        jdTuNgaySanPham = new com.toedter.calendar.JDateChooser();
        lblDenNgaySanPham = new javax.swing.JLabel();
        lblDoanhThuSanPham = new javax.swing.JLabel();
        lblTongDoanhThuSanPham = new javax.swing.JLabel();
        lblSoLuongHoaDonSP = new javax.swing.JLabel();
        txtDoanhThuSP = new javax.swing.JLabel();
        txtSoLuongSP = new javax.swing.JLabel();
        lblTuNgaySP = new javax.swing.JLabel();
        btnBieuDoSP = new javax.swing.JButton();
        jcbLuaChonSP = new javax.swing.JComboBox<>();
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
        jcbThangSP = new javax.swing.JComboBox<>();
        jcbNamSP = new javax.swing.JComboBox<>();
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
        txtDoanhThuKH = new javax.swing.JLabel();
        txtSoLuongKH = new javax.swing.JLabel();
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

        btnBieuDoDT.setText("BIỂU ĐỒ DOANH THU");
        btnBieuDoDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBieuDoDTMouseClicked(evt);
            }
        });
        jpChucNangDoanhThu.add(btnBieuDoDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 170, 50));

        jcbLuaChonDoanhThu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbLuaChonDoanhThu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonDoanhThuActionPerformed(evt);
            }
        });
        jpChucNangDoanhThu.add(jcbLuaChonDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, 30));

        jpInBaoCao.setBackground(new java.awt.Color(255, 255, 255));
        jpInBaoCao.setRoundedBottomLeft(10);
        jpInBaoCao.setRoundedBottomRight(10);
        jpInBaoCao.setRoundedTopLeft(10);
        jpInBaoCao.setRoundedTopRight(10);
        jpInBaoCao.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpInBaoCaoMouseClicked(evt);
            }
        });
        jpInBaoCao.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInBaoCao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblInBaoCao.setText("In báo cáo");
        jpInBaoCao.add(lblInBaoCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgInBaoCao.setText(" ");
        jpInBaoCao.add(svgInBaoCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNangDoanhThu.add(jpInBaoCao, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 120, 40));

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

        jpChucNangDoanhThu.add(jbLamMoiDoanhThu, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 110, 40));
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

        tabDoanhThu.add(jpChucNangDoanhThu, java.awt.BorderLayout.WEST);

        jTab.addTab("Doanh Thu", tabDoanhThu);

        tabSanPham.setLayout(new java.awt.BorderLayout());

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
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
        jpChucNangSanPham.add(jdDenNgaySanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 30));
        jpChucNangSanPham.add(jdTuNgaySanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 30));

        lblDenNgaySanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDenNgaySanPham.setText("Đến ngày:");
        jpChucNangSanPham.add(lblDenNgaySanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 30));

        lblDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThuSanPham.setText("Doanh thu:");
        jpChucNangSanPham.add(lblDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        lblTongDoanhThuSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongDoanhThuSanPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuSanPham.setText("TỔNG DOANH THU");
        jpChucNangSanPham.add(lblTongDoanhThuSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        lblSoLuongHoaDonSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDonSP.setText("Số lượng hóa đơn bán được:");
        jpChucNangSanPham.add(lblSoLuongHoaDonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 30));

        txtDoanhThuSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtDoanhThuSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 110, 30));

        txtSoLuongSP.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangSanPham.add(txtSoLuongSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, 30));

        lblTuNgaySP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTuNgaySP.setText("Từ ngày:");
        jpChucNangSanPham.add(lblTuNgaySP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

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

        jcbLuaChonSP.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbLuaChonSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tuỳ chỉnh", "Theo ngày", "Theo tuần", "Theo tháng", "Theo năm" }));
        jcbLuaChonSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbLuaChonSPActionPerformed(evt);
            }
        });
        jpChucNangSanPham.add(jcbLuaChonSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 150, 30));

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

        jpChucNangSanPham.add(jpInBaoCaoSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 250, 120, 40));

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

        jpChucNangSanPham.add(jpThongKeSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 110, 40));

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

        jpChucNangSanPham.add(jbLamMoiSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 310, 110, 40));
        jpChucNangSanPham.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 280, 10));

        lblNamSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamSP.setText("Năm :");
        jpChucNangSanPham.add(lblNamSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 30));

        lblThangSP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThangSP.setText("Tháng :");
        jpChucNangSanPham.add(lblThangSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 30));

        jcbThangSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangSP.setEnabled(false);
        jpChucNangSanPham.add(jcbThangSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 60, 30));

        jcbNamSP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2014", " " }));
        jcbNamSP.setEnabled(false);
        jpChucNangSanPham.add(jcbNamSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 90, 30));

        tabSanPham.add(jpChucNangSanPham, java.awt.BorderLayout.WEST);

        jTab.addTab("Sản Phẩm", tabSanPham);

        tabKhachHang.setLayout(new java.awt.BorderLayout());

        tableKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "Số điện thoại", "Địa chỉ", "Giới tính", "Số lượng", "Tổng tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class
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
        jpChucNangKH.add(jdDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 180, 30));
        jpChucNangKH.add(jdTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 180, 30));

        lblDenNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDenNgayKH.setText("Đến ngày:");
        jpChucNangKH.add(lblDenNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 70, 30));

        lblDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDoanhThuKH.setText("Doanh thu:");
        jpChucNangKH.add(lblDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 80, 30));

        lblTongDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblTongDoanhThuKH.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTongDoanhThuKH.setText("TỔNG DOANH THU");
        jpChucNangKH.add(lblTongDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 390, 200, -1));

        lblSoLuongHoaDonKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoLuongHoaDonKH.setText("Số lượng hóa đơn bán được:");
        jpChucNangKH.add(lblSoLuongHoaDonKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 200, 30));

        txtDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtDoanhThuKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 490, 110, 30));

        txtSoLuongKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jpChucNangKH.add(txtSoLuongKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 80, 30));

        lblTuNgayKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTuNgayKH.setText("Từ ngày:");
        jpChucNangKH.add(lblTuNgayKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 80, 30));

        btnBieuDoKH.setText("BIỂU ĐỒ KHÁCH HÀNG");
        btnBieuDoKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnBieuDoKHMouseClicked(evt);
            }
        });
        jpChucNangKH.add(btnBieuDoKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 550, 170, 50));

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
        jpChucNangKH.add(lblNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, -1, 30));

        lblThangKH.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblThangKH.setText("Tháng :");
        jpChucNangKH.add(lblThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 60, 30));

        jcbThangKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", " " }));
        jcbThangKH.setEnabled(false);
        jpChucNangKH.add(jcbThangKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 60, 30));

        jcbNamKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2014", " " }));
        jcbNamKH.setEnabled(false);
        jpChucNangKH.add(jcbNamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 90, 30));

        tabKhachHang.add(jpChucNangKH, java.awt.BorderLayout.WEST);

        jTab.addTab("Khách hàng", tabKhachHang);

        add(jTab, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnBieuDoDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBieuDoDTMouseClicked

    }//GEN-LAST:event_btnBieuDoDTMouseClicked

    private void jpThongKeDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeDTMouseClicked
        String selectedItem = (String) jcbLuaChonDoanhThu.getSelectedItem();
        doanhThuDAO = new DoanhThuDAO();
        modelDoanhThu.setRowCount(0);
        int soHoaDon = 0;
        double tong = 0;
        java.util.Date currDate = new java.util.Date();
        switch (selectedItem) {
            case "Theo ngày":
                for (DoanhThu doanhThu : doanhThuDAO.getHoaDon(new java.sql.Date(currDate.getTime()), new java.sql.Date(currDate.getTime()))) {
                    Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
                    modelDoanhThu.addRow(row);
                    tong += doanhThu.getTongtien();
                    soHoaDon++;
                }
                break;
            case "Theo tuần":
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(currDate);
                calendar.add(Calendar.DAY_OF_MONTH, -7);
                java.util.Date weekAgo = calendar.getTime();
                for (DoanhThu doanhThu : doanhThuDAO.getHoaDon(new java.sql.Date(weekAgo.getTime()), new java.sql.Date(currDate.getTime()))) {
                    Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
                    modelDoanhThu.addRow(row);
                    tong += doanhThu.getTongtien();
                    soHoaDon++;
                }
                break;
            case "Theo tháng":
                for (DoanhThu doanhThu : doanhThuDAO.getDoanhThuThangNam(Integer.parseInt(jcbThangDoanhThu.getSelectedItem().toString()), Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()))) {
                    Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
                    modelDoanhThu.addRow(row);
                    tong += doanhThu.getTongtien();
                    soHoaDon++;
                }
                break;
            case "Tuỳ chỉnh":
                java.sql.Date tuNgay = jdTuNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdTuNgayDoanhThu.getDate().getTime());
                java.sql.Date denNgay = jdDenNgayDoanhThu.getDate() == null ? null : new java.sql.Date(jdDenNgayDoanhThu.getDate().getTime());
                for (DoanhThu doanhThu : doanhThuDAO.getHoaDon(tuNgay, denNgay)) {
                    Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
                    modelDoanhThu.addRow(row);
                    tong += doanhThu.getTongtien();
                    soHoaDon++;
                }
                break;

            case "Theo năm":
                for (DoanhThu doanhThu : doanhThuDAO.getDoanhThuThangNam(0, Integer.parseInt(jcbNamDoanhThu.getSelectedItem().toString()))) {
                    Object row[] = {doanhThu.getMahoadon(), doanhThu.getTennv(), doanhThu.getTenkh(), doanhThu.getNgaylaphoadon(), doanhThu.getTongtien()};
                    modelDoanhThu.addRow(row);
                    tong += doanhThu.getTongtien();
                    soHoaDon++;
                }
                break;
            default:
                break;
        }
        BigDecimal tongTien = new BigDecimal(tong);
        txtSoLuongHoaDon.setText(soHoaDon + "");
        txtDoanhThu.setText(tongTien + "");
    }//GEN-LAST:event_jpThongKeDTMouseClicked

    private void jpInBaoCaoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInBaoCaoMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpInBaoCaoMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBieuDoSPMouseClicked

    private void jcbLuaChonSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLuaChonSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLuaChonSPActionPerformed

    private void jpInBaoCaoSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInBaoCaoSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpInBaoCaoSPMouseClicked

    private void jpThongKeSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpThongKeSPMouseClicked

    private void jbLamMoiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiSPMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLamMoiSPMouseClicked

    private void btnBieuDoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBieuDoKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBieuDoKHMouseClicked

    private void jcbLuaChonKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbLuaChonKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbLuaChonKHActionPerformed

    private void jpInBaoCaoKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpInBaoCaoKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpInBaoCaoKHMouseClicked

    private void jpThongKeKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpThongKeKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpThongKeKHMouseClicked

    private void jbLamMoiKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbLamMoiKHMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbLamMoiKHMouseClicked

    private void btnBieuDoSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBieuDoSPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBieuDoSPActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBieuDoDT;
    private javax.swing.JButton btnBieuDoKH;
    private javax.swing.JButton btnBieuDoSP;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTab;
    private util.JPanelRounded jbLamMoiDoanhThu;
    private util.JPanelRounded jbLamMoiKH;
    private util.JPanelRounded jbLamMoiSP;
    private javax.swing.JComboBox<String> jcbLuaChonDoanhThu;
    private javax.swing.JComboBox<String> jcbLuaChonKH;
    private javax.swing.JComboBox<String> jcbLuaChonSP;
    private javax.swing.JComboBox<String> jcbNamDoanhThu;
    private javax.swing.JComboBox<String> jcbNamKH;
    private javax.swing.JComboBox<String> jcbNamSP;
    private javax.swing.JComboBox<String> jcbThangDoanhThu;
    private javax.swing.JComboBox<String> jcbThangKH;
    private javax.swing.JComboBox<String> jcbThangSP;
    private com.toedter.calendar.JDateChooser jdDenNgayDoanhThu;
    private com.toedter.calendar.JDateChooser jdDenNgayKH;
    private com.toedter.calendar.JDateChooser jdDenNgaySanPham;
    private com.toedter.calendar.JDateChooser jdTuNgayDoanhThu;
    private com.toedter.calendar.JDateChooser jdTuNgayKH;
    private com.toedter.calendar.JDateChooser jdTuNgaySanPham;
    private javax.swing.JPanel jpChucNangDoanhThu;
    private javax.swing.JPanel jpChucNangKH;
    private javax.swing.JPanel jpChucNangSanPham;
    private util.JPanelRounded jpInBaoCao;
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
    private javax.swing.JLabel lblDoanhThuSanPham;
    private javax.swing.JLabel lblInBaoCao;
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
    private util.SVGImage svgInBaoCao;
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
    private javax.swing.JLabel txtDoanhThuKH;
    private javax.swing.JLabel txtDoanhThuSP;
    private javax.swing.JLabel txtSoLuongHoaDon;
    private javax.swing.JLabel txtSoLuongKH;
    private javax.swing.JLabel txtSoLuongSP;
    // End of variables declaration//GEN-END:variables
}
