/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import entity.SanPham;
import java.text.NumberFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import javax.swing.table.DefaultTableModel;

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
        loadComboboxDanhMuc();
        loadData();

    }

    private void loadComboboxDanhMuc() {
        sanPhamDAO = new SanPhamDAO();
        Set<String> uniqueDanhMuc = new HashSet<>();
        jcbDanhMuc.removeAllItems();
        jcbDanhMuc.addItem("Mặc định");
        for (SanPham sanPham : sanPhamDAO.selectAll()) {
            if (!sanPham.getDanhMuc().equals("Sách")) {
                uniqueDanhMuc.add(sanPham.getDanhMuc());
            }

        }
        for (String danhMuc : uniqueDanhMuc) {
            jcbDanhMuc.addItem(danhMuc);
        }

    }

    private void loadTuyChon(boolean componentSach) {
//        lblNamXuatBan.setVisible(componentSach);
        jcbNamXuatBan.setEnabled(componentSach);
//        lblSoTrang.setVisible(componentSach);
        txtSoTrang.setEnabled(componentSach);
        jcbLocSoTrang.setEnabled(componentSach);
//        lblNhaXuatBan.setVisible(componentSach);
        txtNhaXuatBan.setEnabled(componentSach);
//        lblTacGia.setVisible(componentSach);
        txtTacGia.setEnabled(componentSach);
//        lblDanhMuc.setVisible(!componentSach);

        jcbDanhMuc.setEnabled(!componentSach);

        setTieuDeBang(componentSach);
    }

    private void setTieuDeBang(boolean timSach) {
        if (timSach) {
            modelTimKiem = new DefaultTableModel(new Object[][]{}, this.timSach);
            tableSanPham.setModel(modelTimKiem);
            lblTieuDe.setText("TÌM KIẾM SÁCH");
            lblMa.setText("Mã sách:");
            lblTen.setText("Tên sách:");
        } else {
            lblTieuDe.setText("TÌM KIẾM SẢN PHẨM");
            lblMa.setText("Mã SP:");
            lblTen.setText("Tên SP:");
            modelTimKiem = new DefaultTableModel(new Object[][]{}, timSanPham);
            tableSanPham.setModel(modelTimKiem);
        }

    }

    private void loadData() {
        sanPhamDAO = new SanPhamDAO();
        String item = jcbTuyChon.getSelectedItem().toString();
        if (item.equals("Sách")) {
            loadTuyChon(true);
            modelTimKiem = (DefaultTableModel) tableSanPham.getModel();
            for (SanPham sanPham : sanPhamDAO.layTheoDanhMuc(item)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getTacGia(), sanPham.getNhaXuatBan(), sanPham.getNamXuatBan() + "", sanPham.getSoTrang() + "", sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        } else {
            loadTuyChon(false);
            modelTimKiem = (DefaultTableModel) tableSanPham.getModel();
            for (SanPham sanPham : sanPhamDAO.layTheoDanhMuc(null)) {
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
        lblDanhMuc = new javax.swing.JLabel();
        txtNhaXuatBan = new javax.swing.JTextField();
        lblTacGia = new javax.swing.JLabel();
        jcbDanhMuc = new javax.swing.JComboBox<>();
        lblTim = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        lblNamXuatBan = new javax.swing.JLabel();
        jcbLocSoTrang = new javax.swing.JComboBox<>();
        jcbNamXuatBan = new javax.swing.JComboBox<>();
        lblNhaXuatBan = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jcbTuyChon = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        lblSoTrang = new javax.swing.JLabel();
        lblEmail2 = new javax.swing.JLabel();
        jcbLocGia1 = new javax.swing.JComboBox<>();
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
        jpChucNang.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, 70, 30));

        lblMa.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMa.setText("Mã sách:");
        jpChucNang.add(lblMa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 80, 30));

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 220, 30));

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

        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Còn hàng", "Hết hàng", " " }));
        jpChucNang.add(jcbTrangThai, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, 110, 30));

        lblDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDanhMuc.setText("Danh mục:");
        jpChucNang.add(lblDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 80, 30));

        txtNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtNhaXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 200, 30));

        lblTacGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTacGia.setText("Tác giả:");
        jpChucNang.add(lblTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 120, 60, 30));

        jcbDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbDanhMucActionPerformed(evt);
            }
        });
        jpChucNang.add(jcbDanhMuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 150, 30));

        lblTim.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTim.setText("Tìm theo:");
        jpChucNang.add(lblTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 70, 30));

        txtSoTrang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtSoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 140, 30));

        lblNamXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNamXuatBan.setText("Năm xuất bản:");
        jpChucNang.add(lblNamXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, 30));

        jcbLocSoTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớn hơn", "Nhỏ hơn" }));
        jpChucNang.add(jcbLocSoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 70, 110, 30));

        jcbNamXuatBan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jpChucNang.add(jcbNamXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 110, 30));

        lblNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNhaXuatBan.setText("Nhà xuất bản:");
        jpChucNang.add(lblNhaXuatBan, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 30));

        txtTacGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtTacGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 200, 30));

        jcbTuyChon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Sản phẩm khác" }));
        jcbTuyChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTuyChonActionPerformed(evt);
            }
        });
        jpChucNang.add(jcbTuyChon, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 140, 30));

        txtGia.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpChucNang.add(txtGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 170, 30));

        lblSoTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSoTrang.setText("Số trang:");
        jpChucNang.add(lblSoTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 70, 30));

        lblEmail2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail2.setText("Giá:");
        jpChucNang.add(lblEmail2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 30, 30));

        jcbLocGia1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lớn hơn", "Nhỏ hơn" }));
        jpChucNang.add(jcbLocGia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 110, 30));

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

    }//GEN-LAST:event_jpTimMouseClicked

    private void jpLamMoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpLamMoiMouseClicked

    }//GEN-LAST:event_jpLamMoiMouseClicked

    private void tableSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSanPhamMouseClicked

    }//GEN-LAST:event_tableSanPhamMouseClicked

    private void jcbDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbDanhMucActionPerformed
        sanPhamDAO = new SanPhamDAO();
        String item = jcbDanhMuc.getSelectedItem().toString();
        loadTuyChon(false);
        modelTimKiem = (DefaultTableModel) tableSanPham.getModel();
        if (item.equals("Mặc định")) {
            loadData();
        } else {
            for (SanPham sanPham : sanPhamDAO.layTheoDanhMuc(item)) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.timNhaCungCapTheoID(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getMoTa()};
                modelTimKiem.addRow(data);
            }
        }

    }//GEN-LAST:event_jcbDanhMucActionPerformed

    private void jcbTuyChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTuyChonActionPerformed
        loadData();        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTuyChonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JComboBox<String> jcbDanhMuc;
    private javax.swing.JComboBox<String> jcbLocGia1;
    private javax.swing.JComboBox<String> jcbLocSoTrang;
    private javax.swing.JComboBox<String> jcbNamXuatBan;
    private javax.swing.JComboBox<String> jcbTrangThai;
    private javax.swing.JComboBox<String> jcbTuyChon;
    private javax.swing.JPanel jpChucNang;
    private util.JPanelRounded jpLamMoi;
    private util.JPanelRounded jpTim;
    private javax.swing.JLabel lblDanhMuc;
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
