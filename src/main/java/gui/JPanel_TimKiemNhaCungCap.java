/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhaCungCapDAO;
import entity.NhaCungCap;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BanhMi88
 */
public class JPanel_TimKiemNhaCungCap extends javax.swing.JPanel {

    private final DefaultTableModel modelNhaCungCap;
    private NhaCungCapDAO nhaCungCapDAO;

    public JPanel_TimKiemNhaCungCap() {
        initComponents();
        if(ngonNgu==2)
        {
            ChuyenDoiNN();
        }
        svgDelete.setSvgImage("search.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelNhaCungCap = (DefaultTableModel) tableSupplier.getModel();
        loadData();
    }
     public void ChuyenDoiNN()
    {
        lbSupplierID.setText("Supplier ID:");
        lbSupplierName.setText("Supplier Name:");
        lblPhone.setText("Phone:");
        lblSearch1.setText("Status:");
        lbTitle.setText("SEARCH FOR SUPPLIERS");
        jbDelete.setText("Find");
        jbRefresh.setText("Refresh");       
    }

    private void refresh() {
        txtSupplierID.setText("");
        txtSupplierName.setText("");
        cbStatus.setSelectedIndex(0);
        txtSoDienThoai.setText("");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbSupplierName = new javax.swing.JLabel();
        lbSupplierID = new javax.swing.JLabel();
        txtSupplierName = new javax.swing.JTextField();
        txtSupplierID = new javax.swing.JTextField();
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
        jPanel3 = new javax.swing.JPanel();
        srcollSupplier = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("TÌM KIẾM NHÀ CUNG CẤP");
        lbTitle.setPreferredSize(new java.awt.Dimension(499, 70));
        jPanel1.add(lbTitle, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(1010, 150));
        jPanel2.setPreferredSize(new java.awt.Dimension(1040, 100));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSupplierName.setText("Tên nhà cung cấp:");
        jPanel2.add(lbSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 170, 40));

        lbSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSupplierID.setText("Mã nhà cung cấp:");
        jPanel2.add(lbSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 40));

        txtSupplierName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 210, 40));

        txtSupplierID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 200, 40));

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
        jbTim.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgDelete.setText(" ");
        jbTim.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jPanel2.add(jbTim, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 150, 50));

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
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hợp tác", "Ngưng hợp tác" }));
        jPanel2.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 210, 40));

        lblSearch1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch1.setText("Trạng thái:");
        jPanel2.add(lblSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 100, 240, 40));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 100, -1, 40));

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(452, 520));
        jPanel3.setLayout(new java.awt.BorderLayout());

        if(ngonNgu==2)
        {
            tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Supplier ID", "Supplier Name", "Status", "Address", "Email", "Phone", "Contact person"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã nhà cung cấp", "Tên nhà cung cấp", "Trạng thái", "Địa chỉ", "Email", "Số điện thoại", "Người liên hệ"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        srcollSupplier.setViewportView(tableSupplier);

        jPanel3.add(srcollSupplier, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents


    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        refresh();
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    private void jbTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTimMouseClicked
        nhaCungCapDAO = new NhaCungCapDAO();
        String maNhaCC = txtSupplierID.getText();
        String tenNhaCC = txtSupplierName.getText();
        String email = txtEmail.getText();
        String soDienThoai = txtSoDienThoai.getText();
        boolean trangThai = (cbStatus.getSelectedIndex() == 0);
        modelNhaCungCap.setRowCount(0);
        for (NhaCungCap ncc : nhaCungCapDAO.timNhaCungCap(maNhaCC.trim().equals("") ? "" : maNhaCC, tenNhaCC.trim().equals("") ? "" : tenNhaCC, email.trim().equals("") ? "" : email, soDienThoai.trim().equals("") ? "" : soDienThoai, trangThai)) {
            Object[] row = {ncc.getMaNhaCC(), ncc.getTenNhaCC(), ncc.isTrangThai() == true ? "Đang hợp tác" : "Ngưng hợp tác", ncc.getDiaChi(), ncc.getEmail(), ncc.getSoDienThoai(), ncc.getTenNguoiLienHe()};
            modelNhaCungCap.addRow(row);
        }
    }//GEN-LAST:event_jbTimMouseClicked

    private void loadData() {
        nhaCungCapDAO = new NhaCungCapDAO();
        modelNhaCungCap.setRowCount(0);
        for (NhaCungCap ncc : nhaCungCapDAO.getAllNhaCungCap()) {
            String trangThai = ncc.isTrangThai() ? "Đang hợp tác" : "Ngưng hợp tác";
            Object[] row = {ncc.getMaNhaCC(), ncc.getTenNhaCC(), trangThai, ncc.getDiaChi(), ncc.getEmail(), ncc.getSoDienThoai(), ncc.getTenNguoiLienHe()};
            modelNhaCungCap.addRow(row);
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
    private util.JPanelRounded jpRefresh;
    private javax.swing.JLabel lbSupplierID;
    private javax.swing.JLabel lbSupplierName;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JScrollPane srcollSupplier;
    private util.SVGImage svgDelete;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
