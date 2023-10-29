/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import entity.SanPham;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

import static util.Validator.checkEmpty;

/**
 *
 * @author BanhMi88
 */
public class JPanel_TimKiemSanPham extends javax.swing.JPanel {

    private DefaultTableModel modelTimKiem;
    private final String[] timSach = {"Mã sách", "Tên sách", "Danh mục", "Nhà cung cấp", "Đơn vị tính", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Số lượng", "Giá", "Mô tả"};
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    private final String[] timSanPham = {"Mã sản phẩm", "Tên sản phẩm", "Danh mục", "Nhà cung cấp", "Đơn vị tính", "Số lượng", "Giá", "Mô tả"};
    private SanPhamDAO sanPhamDAO;
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public JPanel_TimKiemSanPham() {
        initComponents();
        svgDelete.setSvgImage("search.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        loadCombobox();
        loadData();
    }

    private void lamMoi() {
        jcbNamXuatBan.setSelectedIndex(0);
        jcbTrangThai.setSelectedIndex(0);
        txtMa.setText("");
        txtTen.setText("");
        txtGia.setText("");
        txtNhaXuatBan.setText("");
        txtSoTrang.setText("");
        txtTacGia.setText("");
    }

    private void loadCombobox() {
        sanPhamDAO = new SanPhamDAO();
        Set<String> uniqueDanhMuc = new HashSet<>();
        List<Integer> uniqueNam = new ArrayList<>();
        jcbTuyChon.removeAllItems();
        jcbNamXuatBan.removeAllItems();
        for (SanPham sanPham : sanPhamDAO.selectAll()) {
            uniqueDanhMuc.add(sanPham.getDanhMuc());
            if (sanPham.getDanhMuc().equals("Sách")) {
                uniqueNam.add(sanPham.getNamXuatBan());
            }
        }
        for (String danhMuc : uniqueDanhMuc) {
            jcbTuyChon.addItem(danhMuc);
        }

        Collections.sort(uniqueNam);
        jcbNamXuatBan.addItem("Mặc định");
        for (int nam : uniqueNam) {
            jcbNamXuatBan.addItem(nam + "");
        }
    }

    private void loadTuyChon(boolean componentSach, String item) {
//        lblNamXuatBan.setVisible(componentSach);
        jcbNamXuatBan.setEnabled(componentSach);
//        lblSoTrang.setVisible(componentSach);
        txtSoTrang.setEnabled(componentSach);
//        lblNhaXuatBan.setVisible(componentSach);
        txtNhaXuatBan.setEnabled(componentSach);
//        lblTacGia.setVisible(componentSach);
        txtTacGia.setEnabled(componentSach);
//        lblDanhMuc.setVisible(!componentSach);

        setTieuDeBang(componentSach, item);
    }

    private void setTieuDeBang(boolean timSach, String item) {
        lblTieuDe.setText("TÌM KIẾM " + item);
        if (timSach) {
            modelTimKiem = new DefaultTableModel(new Object[][]{}, this.timSach);
            tableSanPham.setModel(modelTimKiem);

            lblMa.setText("Mã sách:");
            lblTen.setText("Tên sách:");
        } else {
            lblMa.setText("Mã SP:");
            lblTen.setText("Tên SP:");
            modelTimKiem = new DefaultTableModel(new Object[][]{}, timSanPham);
            tableSanPham.setModel(modelTimKiem);
        }

    }

    private void loadData() {
        sanPhamDAO = new SanPhamDAO();
        String item = jcbTuyChon.getSelectedItem().toString();
        loadTuyChon(item.equals("Sách"), item.toUpperCase());
        modelTimKiem = (DefaultTableModel) tableSanPham.getModel();
        //{"Mã sách", "Tên sách", "Danh mục", "Nhà cung cấp", "Đơn vị tính", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Số lượng", "Giá", "Mô tả"};
        if (item.equals("Sách")) {
            for (SanPham sanPham : sanPhamDAO.layTheoDanhMuc(item)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getTacGia(), sanPham.getNhaXuatBan(), sanPham.getNamXuatBan() + "", sanPham.getSoTrang() + "", sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        } else {
            for (SanPham sanPham : sanPhamDAO.layTheoDanhMuc(item)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblTieuDe = new javax.swing.JLabel();
        jpChucNang = new javax.swing.JPanel();
        lblTen = new javax.swing.JLabel();
        lblMa = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        txtMa = new javax.swing.JTextField();
        lblTrangThai = new javax.swing.JLabel();
        jpTim = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jpLamMoi = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        jcbTrangThai = new javax.swing.JComboBox<>();
        txtNhaXuatBan = new javax.swing.JTextField();
        lblTacGia = new javax.swing.JLabel();
        lblTim = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        lblNamXuatBan = new javax.swing.JLabel();
        jcbNamXuatBan = new javax.swing.JComboBox<>();
        lblNhaXuatBan = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jcbTuyChon = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        lblSoTrang = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        scrollSanPham = new javax.swing.JScrollPane();
        tableSanPham = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        lblTieuDe.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTieuDe.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTieuDe.setText("TÌM KIẾM SÁCH");
        jPanel2.add(lblTieuDe, java.awt.BorderLayout.CENTER);

        add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jpChucNang.setMinimumSize(new java.awt.Dimension(1010, 150));
        jpChucNang.setPreferredSize(new java.awt.Dimension(1040, 150));
        jpChucNang.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTen.setText("Tên sách:");
        jpChucNang.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 70, 30));

        lblMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMa.setText("Mã sách:");
        jpChucNang.add(lblMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 80, 30));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 210, 30));

        txtMa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 150, 30));

        lblTrangThai.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTrangThai.setText("Trạng thái:");
        jpChucNang.add(lblTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 80, 30));

        jpTim.setBackground(new java.awt.Color(255, 255, 255));
        jpTim.setRoundedBottomLeft(10);
        jpTim.setRoundedBottomRight(10);
        jpTim.setRoundedTopLeft(10);
        jpTim.setRoundedTopRight(10);
        jpTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpTimMouseClicked(evt);
            }
        });
        jpTim.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Tìm");
        jpTim.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpTim.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNang.add(jpTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 100, 40));

        jpLamMoi.setBackground(new java.awt.Color(255, 255, 255));
        jpLamMoi.setRoundedBottomLeft(10);
        jpLamMoi.setRoundedBottomRight(10);
        jpLamMoi.setRoundedTopLeft(10);
        jpLamMoi.setRoundedTopRight(10);
        jpLamMoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpLamMoiMouseClicked(evt);
            }
        });
        jpLamMoi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpLamMoi.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpLamMoi.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpChucNang.add(jpLamMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 170, 110, 40));

        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang bán", "Ngưng bán" }));
        jpChucNang.add(jcbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 110, 30));

        txtNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtNhaXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, 190, 30));

        lblTacGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTacGia.setText("Tác giả:");
        jpChucNang.add(lblTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 60, 30));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTim.setText("Tìm theo:");
        jpChucNang.add(lblTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 30));

        txtSoTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtSoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, 90, 30));

        lblNamXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamXuatBan.setText("Năm xuất bản:");
        jpChucNang.add(lblNamXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 100, 30));

        jcbNamXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jcbNamXuatBan.setSelectedIndex(-1);
        jpChucNang.add(jcbNamXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 70, 140, 30));

        lblNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhaXuatBan.setText("Nhà xuất bản:");
        jpChucNang.add(lblNhaXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 100, 30));

        txtTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 200, 30));

        jcbTuyChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTuyChonActionPerformed(evt);
            }
        });
        jpChucNang.add(jcbTuyChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, 30));

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 200, 30));

        lblSoTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoTrang.setText("Số trang:");
        jpChucNang.add(lblSoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 70, 70, 30));

        lblEmail2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail2.setText("Giá:");
        jpChucNang.add(lblEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 30, 30));

        add(jpChucNang, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(452, 480));
        jPanel4.setLayout(new java.awt.BorderLayout());

        scrollSanPham.setPreferredSize(new java.awt.Dimension(452, 350));

        tableSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSanPhamMouseClicked(evt);
            }
        });
        scrollSanPham.setViewportView(tableSanPham);

        jPanel4.add(scrollSanPham, java.awt.BorderLayout.CENTER);

        add(jPanel4, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void jpTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpTimMouseClicked
        sanPhamDAO = new SanPhamDAO();
        SanPham sanPhamLoc;
        String item = jcbTuyChon.getSelectedItem().toString();
        String danhMuc = jcbTuyChon.getSelectedItem().toString();
        String ma = checkEmpty(txtMa.getText()) ? null : txtMa.getText();
        String ten = checkEmpty(txtTen.getText()) ? null : txtTen.getText();
        boolean trangThai = jcbTrangThai.getSelectedItem().equals("Đang bán");
        double gia = checkEmpty(txtGia.getText()) ? -1 : Double.parseDouble(txtGia.getText());
        modelTimKiem = (DefaultTableModel) tableSanPham.getModel();
        modelTimKiem.setRowCount(0);
        if (item.equals("Sách")) {
            String nhaXuatBan = checkEmpty(txtNhaXuatBan.getText().trim()) ? null : txtNhaXuatBan.getText();
            int soTrang = checkEmpty(txtSoTrang.getText()) ? -1 : Integer.parseInt(txtSoTrang.getText());
            int namXuatBan = jcbNamXuatBan.getSelectedItem().equals("Mặc định") ? -1 : Integer.parseInt(jcbNamXuatBan.getSelectedItem().toString());
            String tacGia = checkEmpty(txtTacGia.getText()) ? null : txtTacGia.getText();
            sanPhamLoc = new SanPham(ma, ten, danhMuc, tacGia, nhaXuatBan, namXuatBan, soTrang, gia, trangThai);
            for (SanPham sanPham : jcbTrangThai.getSelectedItem().toString().equals("Tất cả") ? sanPhamDAO.timSanPham(sanPhamLoc, 0) : sanPhamDAO.timSanPham(sanPhamLoc, 1)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getTacGia(), sanPham.getNhaXuatBan(), sanPham.getNamXuatBan() + "", sanPham.getSoTrang() + "", sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        } else {
            sanPhamLoc = new SanPham(ma, ten, danhMuc, null, null, -1, -1, gia, trangThai);
            for (SanPham sanPham : jcbTrangThai.getSelectedItem().toString().equals("Tất cả") ? sanPhamDAO.timSanPham(sanPhamLoc, 0) : sanPhamDAO.timSanPham(sanPhamLoc, 1)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        }


    }//GEN-LAST:event_jpTimMouseClicked

    private void jpLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLamMoiMouseClicked
        lamMoi();
        loadData();
    }//GEN-LAST:event_jpLamMoiMouseClicked

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked

    }//GEN-LAST:event_tableSanPhamMouseClicked

    private void jcbTuyChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTuyChonActionPerformed
        loadData();
    }//GEN-LAST:event_jcbTuyChonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JComboBox<String> jcbNamXuatBan;
    private javax.swing.JComboBox<String> jcbTrangThai;
    private javax.swing.JComboBox<String> jcbTuyChon;
    private javax.swing.JPanel jpChucNang;
    private util.JPanelRounded jpLamMoi;
    private util.JPanelRounded jpTim;
    private javax.swing.JLabel lblEmail2;
    private javax.swing.JLabel lblMa;
    private javax.swing.JLabel lblNamXuatBan;
    private javax.swing.JLabel lblNhaXuatBan;
    private javax.swing.JLabel lblSoTrang;
    private javax.swing.JLabel lblTacGia;
    private javax.swing.JLabel lblTen;
    private javax.swing.JLabel lblTieuDe;
    private javax.swing.JLabel lblTim;
    private javax.swing.JLabel lblTrangThai;
    private javax.swing.JScrollPane scrollSanPham;
    private util.SVGImage svgDelete;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableSanPham;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}