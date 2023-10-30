package gui;

import dao.KhachHangDAO;
import entity.KhachHang;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class JPanel_KhachHangTK extends javax.swing.JPanel {

    private DefaultTableModel modelKhachHang;
    private KhachHangDAO khachHangDao;

    public JPanel_KhachHangTK() {

        initComponents();
        svgTimKiem.setSvgImage("search.svg", 35, 35);
        modelKhachHang = (DefaultTableModel) tableCustomer.getModel();
        loadData();
    }

    private void loadData() {
        khachHangDao = new KhachHangDAO();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : khachHangDao.getAllKhachHang()) {
            Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getTheVip()};
            modelKhachHang.addRow(row);
        }
        txtmaKH.setText("");
        txtEmail.setText("");
        txtSDT.setText("");
        txtHoTen.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGioiTinh = new javax.swing.ButtonGroup();
        jbCustomerManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        lblPhone = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jbTimKiem = new util.JPanelRounded();
        lblTimKiem = new javax.swing.JLabel();
        svgTimKiem = new util.SVGImage();
        jcbGioiTinh = new javax.swing.JComboBox<>();
        lblGender2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jcbTheThanhVien = new javax.swing.JComboBox<>();
        scrollCustomer = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jbCustomerManagerment.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        jbCustomerManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbCustomerManagerment.setText(" TÌM KIẾM KHÁCH HÀNG");
        jbCustomerManagerment.setPreferredSize(new java.awt.Dimension(476, 70));
        add(jbCustomerManagerment, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCustomerID.setText("Mã khách hàng:");
        jpFunction.add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, 40));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFullName.setText("Họ và tên:");
        jpFunction.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, 40));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, 310, 40));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender.setText("Thẻ TV:");
        jpFunction.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 90, -1, 40));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("SĐT:");
        jpFunction.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, 40));

        txtmaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtmaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaKHActionPerformed(evt);
            }
        });
        jpFunction.add(txtmaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 240, 40));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");
        jpFunction.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 320, 40));

        jbTimKiem.setBackground(new java.awt.Color(255, 255, 255));
        jbTimKiem.setRoundedBottomLeft(10);
        jbTimKiem.setRoundedBottomRight(10);
        jbTimKiem.setRoundedTopLeft(10);
        jbTimKiem.setRoundedTopRight(10);
        jbTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbTimKiemMouseClicked(evt);
            }
        });
        jbTimKiem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTimKiem.setText("Tìm kiếm");
        jbTimKiem.add(lblTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgTimKiem.setText(" ");
        jbTimKiem.add(svgTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jpFunction.add(jbTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 150, 50));

        jcbGioiTinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbGioiTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Nam", "Nữ" }));
        jcbGioiTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGioiTinhActionPerformed(evt);
            }
        });
        jpFunction.add(jcbGioiTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 20, 170, 40));

        lblGender2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender2.setText("Giới tính:");
        jpFunction.add(lblGender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 20, -1, 40));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        jpFunction.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 90, 280, 40));

        jcbTheThanhVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jcbTheThanhVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mặc định", "Đồng", "Bạc", "Vàng", "Kim cương", "Ruby" }));
        jcbTheThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTheThanhVienActionPerformed(evt);
            }
        });
        jpFunction.add(jcbTheThanhVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 90, 170, 40));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        scrollCustomer.setPreferredSize(new java.awt.Dimension(452, 540));
        scrollCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                scrollCustomerMouseClicked(evt);
            }
        });

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên", "Email", "SĐT", "Giới tính", "Thẻ thành viên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        scrollCustomer.setViewportView(tableCustomer);

        add(scrollCustomer, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaKHActionPerformed

    private void jbTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbTimKiemMouseClicked

        khachHangDao = new KhachHangDAO();
        String maKH = txtmaKH.getText();
        String SDT = txtSDT.getText();
        String email = txtEmail.getText();
        String hoten = txtHoTen.getText();
        String thevip = jcbTheThanhVien.getSelectedItem().toString().equals("Mặc định") ? null : jcbTheThanhVien.getSelectedItem().toString();

        String gioiTinh = jcbGioiTinh.getSelectedItem().toString().equals("Mặc định") ? null : jcbGioiTinh.getSelectedItem().toString();
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : khachHangDao.timKhachHang(maKH, hoten, email, SDT, gioiTinh, thevip)) {
            Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getTheVip()};
            modelKhachHang.addRow(row);
        }

    }//GEN-LAST:event_jbTimKiemMouseClicked

    private void jcbGioiTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGioiTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbGioiTinhActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        System.out.println("oke");
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void scrollCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollCustomerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollCustomerMouseClicked

    private void jcbTheThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTheThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbTheThanhVienActionPerformed
    //xu ly tim kiem o day
    private void timMaKH(String makh) {
        modelKhachHang.setRowCount(0);
        DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();
        for (KhachHang kh : khachHangDao.getAllKhachHang()) {
            if (kh.getMaKH().equals(makh)) {
                Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getTheVip()};
                model.addRow(row);
            }
        }
    }

    private void timHT(String hoten) {
//    clearTable();
        khachHangDao = new KhachHangDAO();
        ArrayList<KhachHang> listkh = new ArrayList<>();
//    DefaultTableModel model = (DefaultTableModel) tableCustomer.getModel();

        for (KhachHang kh : khachHangDao.getAllKhachHang()) {
            if (hoten.equals(kh.getTenKH())) {
//           String[] row = {kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getTheVip()};
//            modelKhachHang.addRow(row);
                listkh.add(kh);
            }
        }
        addDataTOTAble(listkh);
    }

    public void addDataTOTAble(ArrayList<KhachHang> dsKH) {
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : dsKH) {
            String[] row = {kh.getMaKH(), kh.getTenKH(), kh.getEmail(), kh.getSoDienThoai(), kh.getGioiTinh(), kh.getTheVip()};
            modelKhachHang.addRow(row);
        }
    }

    private void clearTable() {
        DefaultTableModel dtm = (DefaultTableModel) tableCustomer.getModel();
        dtm.setRowCount(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGioiTinh;
    private javax.swing.JLabel jbCustomerManagerment;
    private util.JPanelRounded jbTimKiem;
    private javax.swing.JComboBox<String> jcbGioiTinh;
    private javax.swing.JComboBox<String> jcbTheThanhVien;
    private javax.swing.JPanel jpFunction;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblTimKiem;
    private javax.swing.JScrollPane scrollCustomer;
    private util.SVGImage svgTimKiem;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtmaKH;
    // End of variables declaration//GEN-END:variables
}
