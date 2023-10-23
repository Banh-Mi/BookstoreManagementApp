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
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
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
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbCustomerManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblCustomerID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        radnu = new javax.swing.JRadioButton();
        radnam = new javax.swing.JRadioButton();
        lblPhone = new javax.swing.JLabel();
        txtmaKH = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jpRefresh = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        cboboxthe = new javax.swing.JComboBox<>();
        lblGender2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        scrollCustomer = new javax.swing.JScrollPane();
        tableCustomer = new javax.swing.JTable();

        jbCustomerManagerment.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbCustomerManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbCustomerManagerment.setText(" TÌM KIẾM KHÁCH HÀNG");

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerID.setText("Mã khách hàng:");
        jpFunction.add(lblCustomerID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 30));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFullName.setText("Họ và tên:");
        jpFunction.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtSDT, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, 210, 30));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGender.setText("Thẻ TV:");
        jpFunction.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 70, 30));

        radnu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radnu.setText("Nữ");
        radnu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radnuActionPerformed(evt);
            }
        });
        jpFunction.add(radnu, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 70, 50, 30));

        radnam.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radnam.setSelected(true);
        radnam.setText("Nam");
        radnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radnamActionPerformed(evt);
            }
        });
        jpFunction.add(radnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 70, 70, 30));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setText("SĐT:");
        jpFunction.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 40, 30));

        txtmaKH.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtmaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaKHActionPerformed(evt);
            }
        });
        jpFunction.add(txtmaKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 240, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");
        jpFunction.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 50, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 240, 30));

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

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Tìm kiếm");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 60, 130, 60));

        cboboxthe.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đồng", "Bạc", "Vàng", "Kim cương", "Ruby", " " }));
        cboboxthe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboboxtheActionPerformed(evt);
            }
        });
        jpFunction.add(cboboxthe, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 120, 90, 30));

        lblGender2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGender2.setText("Giới tính:");
        jpFunction.add(lblGender2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 70, -1, 30));

        txtHoTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });
        jpFunction.add(txtHoTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 240, 30));

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollCustomer)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbCustomerManagerment, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpFunction, javax.swing.GroupLayout.DEFAULT_SIZE, 1034, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbCustomerManagerment)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpFunction, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(160, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void radnuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radnuActionPerformed

    }//GEN-LAST:event_radnuActionPerformed

    private void radnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radnamActionPerformed

    }//GEN-LAST:event_radnamActionPerformed

    private void txtmaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaKHActionPerformed

    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked

        //timMaKH(txtmaKH.getText());     
        timHT(txtHoTen.getText());

    }//GEN-LAST:event_jpRefreshMouseClicked

    private void cboboxtheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboboxtheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cboboxtheActionPerformed

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoTenActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
        System.out.println("oke");
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void scrollCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_scrollCustomerMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_scrollCustomerMouseClicked
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
    public void addDataTOTAble(ArrayList<KhachHang> dsKH){
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
    private javax.swing.JComboBox<String> cboboxthe;
    private javax.swing.JLabel jbCustomerManagerment;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JPanel jpFunction;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JRadioButton radnam;
    private javax.swing.JRadioButton radnu;
    private javax.swing.JScrollPane scrollCustomer;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtmaKH;
    // End of variables declaration//GEN-END:variables
}
