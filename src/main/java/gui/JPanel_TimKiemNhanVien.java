/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhanVienDAO;
import entity.NhanVien;
import static gui.GiaoDienDangNhap.ngonNgu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BanhMi88
 */
public class JPanel_TimKiemNhanVien extends javax.swing.JPanel {

    private final DefaultTableModel modelNhanVien;
    private NhanVienDAO nhanVienDAO;

    public JPanel_TimKiemNhanVien() {
        initComponents();
        if(ngonNgu==2)
        {
            ChuyenDoiNN();
        }
        svgDelete.setSvgImage("search.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelNhanVien = (DefaultTableModel) tableNhanVien.getModel();
        loadData();
    }
    public void ChuyenDoiNN()
    {
        lblMaNhanVien.setText("Employee ID:");
        lblSearch1.setText("Status:");
        lbSupplierName.setText("Employee Name:");
        lblPhone.setText("Phone:");
        lblGioiTinh.setText("Gender:");
        lblGioiTinh1.setText("Position:");
        jbDelete.setText("Find");
        jbRefresh.setText("Refresh");
        lbTitle.setText("FINDING EMPLOYEES");
    }

    private void refresh() {
        txtMaNhanVien.setText("");
        txtTenNhanVien.setText("");
        cbStatus.setSelectedIndex(0);
        jcbChucVu.setSelectedIndex(0);
        jcbGioiTinh.setSelectedIndex(0);
        txtSoDienThoai.setText("");
        txtEmail.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbSupplierName = new javax.swing.JLabel();
        lblMaNhanVien = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtMaNhanVien = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        jbTim = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jpRefresh = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        cbStatus = new javax.swing.JComboBox<>();
        lblSearch1 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        jcbGioiTinh = new javax.swing.JComboBox<>();
        lblGioiTinh1 = new javax.swing.JLabel();
        jcbChucVu = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        scrollNhanVien = new javax.swing.JScrollPane();
        tableNhanVien = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("TÌM KIẾM NHÂN VIÊN");
        lbTitle.setPreferredSize(new java.awt.Dimension(499, 70));
        jPanel1.add(lbTitle, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(1010, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(1040, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSupplierName.setText("Tên nhân viên:");
        jPanel2.add(lbSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 140, 40));

        lblMaNhanVien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblMaNhanVien.setText("Mã nhân viên:");
        jPanel2.add(lblMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        txtTenNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtTenNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 30, 230, 40));

        txtMaNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtMaNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 220, 40));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, 220, 40));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("Số điện thoại:");
        jPanel2.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 30, -1, 40));

        jbTim.setBackground(new java.awt.Color(255, 255, 255));
        jbTim.setRoundedBottomLeft(10);
        jbTim.setRoundedBottomRight(10);
        jbTim.setRoundedTopLeft(10);
        jbTim.setRoundedTopRight(10);
        jbTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbTimMouseClicked(evt);
            }
        });
        jbTim.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbDelete.setText("Tìm");
        jbTim.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 0, 60, 50));

        svgDelete.setText(" ");
        jbTim.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 5, 40, 40));

        jPanel2.add(jbTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, 50));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRefreshMouseClicked(evt);
            }
        });
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jPanel2.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 150, 50));

        cbStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang làm", "Nghĩ Làm" }));
        jPanel2.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 210, 40));

        lblSearch1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch1.setText("Trạng thái:");
        jPanel2.add(lblSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 100, 230, 40));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, -1, 40));

        lblGioiTinh.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGioiTinh.setText("Giới tính:");
        jPanel2.add(lblGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 100, -1, 40));

        jcbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nam", "Nữ" }));
        jPanel2.add(jcbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 100, 120, 40));

        lblGioiTinh1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGioiTinh1.setText("Chức vụ:");
        jPanel2.add(lblGioiTinh1, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 100, -1, 40));

        jcbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Nhân viên", "Quản lý" }));
        jPanel2.add(jcbChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 100, 150, 40));

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(452, 520));
        jPanel3.setLayout(new java.awt.BorderLayout());

        if(ngonNgu==2)
        {
            tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Employee ID", "Employee Name", "Phone", "Email", "Date Of Birth", "Address", "Gender", "Position", "Status"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, true, false, false, true, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        }
        else
        {
            tableNhanVien.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã nhân viên", "Tên nhân viên", "Số điện thoại", "Email", "Ngày sinh", "Địa chỉ", "Giới tính", "Chức vụ", "Trạng thái"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };
                boolean[] canEdit = new boolean [] {
                    false, false, false, false, true, false, false, true, false
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        }
        scrollNhanVien.setViewportView(tableNhanVien);

        jPanel3.add(scrollNhanVien, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        refresh();
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    private String checkRong(String text) {
        return text.trim().equals("") ? "" : text;
    }
    private void jbTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTimMouseClicked
        nhanVienDAO = new NhanVienDAO();
        String maNV = checkRong(txtMaNhanVien.getText());
        String tenNV = checkRong(txtTenNhanVien.getText());
        String email = checkRong(txtEmail.getText());
        String soDienThoai = checkRong(txtSoDienThoai.getText());
        String trangThai = cbStatus.getSelectedItem().toString().equals("Tất cả") ? "" : cbStatus.getSelectedItem().toString();

        String gioiTinh = jcbGioiTinh.getSelectedItem().toString().equals("Tất cả") ? "" : jcbGioiTinh.getSelectedItem().toString();

        String chucVu = jcbChucVu.getSelectedItem().toString().equals("Tất cả") ? "" : jcbChucVu.getSelectedItem().toString();
        modelNhanVien.setRowCount(0);
        for (NhanVien nv : nhanVienDAO.timNhanVien(maNV, tenNV, soDienThoai, email, gioiTinh, chucVu, trangThai)) {
            Object[] row = {nv.getMaNV(), nv.getTenNV(), nv.getSoDienThoai(), nv.getEmail(), nv.getNgaySinh(), nv.getDiaChi(), nv.getGioiTinh(), nv.getChucVu(), nv.getTrangThai()};
            modelNhanVien.addRow(row);
        }
    }//GEN-LAST:event_jbTimMouseClicked

    private void loadData() {
        nhanVienDAO = new NhanVienDAO();
        modelNhanVien.setRowCount(0);
        for (NhanVien nv : nhanVienDAO.getAllNhanVien()) {
            Object[] row = {nv.getMaNV(), nv.getTenNV(), nv.getSoDienThoai(), nv.getEmail(), nv.getNgaySinh(), nv.getDiaChi(), nv.getGioiTinh(), nv.getChucVu(), nv.getTrangThai()};
            modelNhanVien.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbStatus;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jbTim;
    private javax.swing.JComboBox<String> jcbChucVu;
    private javax.swing.JComboBox<String> jcbGioiTinh;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JLabel lbSupplierName;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblGioiTinh1;
    private javax.swing.JLabel lblMaNhanVien;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JScrollPane scrollNhanVien;
    private util.SVGImage svgDelete;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableNhanVien;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNhanVien;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTenNhanVien;
    // End of variables declaration//GEN-END:variables
}
