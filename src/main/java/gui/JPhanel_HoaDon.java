package gui;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JPhanel_HoaDon extends javax.swing.JPanel {
    
    public JPhanel_HoaDon() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Order = new javax.swing.JPanel();
        txt_SearchOrder = new javax.swing.JTextField();
        btn_Search = new javax.swing.JButton();
        pnl_SearchByTime = new javax.swing.JPanel();
        jDateChooser_SreachByTimeFrom = new com.toedter.calendar.JDateChooser();
        jDateChooser_SearchByTimeTo = new com.toedter.calendar.JDateChooser();
        lbl_SearchSearchByTimeFrom = new javax.swing.JLabel();
        lbl_SearchByTimeTo = new javax.swing.JLabel();
        pnl_SearchPaymentStatus = new javax.swing.JPanel();
        cb_SearchPaymentStatus = new javax.swing.JComboBox<>();
        pnl_SearchTotalAmount = new javax.swing.JPanel();
        cb_SearchTotalAmount = new javax.swing.JComboBox<>();
        lbl_SearchOrder1 = new javax.swing.JLabel();
        scr_Order = new javax.swing.JScrollPane();
        tbl_Order = new javax.swing.JTable();
        jPanel_OrderDetail = new javax.swing.JPanel();
        scr_OrderDetail = new javax.swing.JScrollPane();
        tbl_OrderDetail = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Order.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel_Order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_SearchOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SearchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchOrderActionPerformed(evt);
            }
        });
        jPanel_Order.add(txt_SearchOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 30, 440, 30));

        btn_Search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Search.setText("Tìm");
        jPanel_Order.add(btn_Search, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 30, 84, 30));

        pnl_SearchByTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời gian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchByTime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_SearchByTime.add(jDateChooser_SreachByTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 100, 33));
        pnl_SearchByTime.add(jDateChooser_SearchByTimeTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 100, 33));

        lbl_SearchSearchByTimeFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SearchSearchByTimeFrom.setText("Từ");
        pnl_SearchByTime.add(lbl_SearchSearchByTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 30, 30));

        lbl_SearchByTimeTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SearchByTimeTo.setText("Đến");
        pnl_SearchByTime.add(lbl_SearchByTimeTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 30, 30));

        jPanel_Order.add(pnl_SearchByTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 320, 87));

        pnl_SearchPaymentStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng thái thanh toán", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchPaymentStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchPaymentStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_SearchPaymentStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchPaymentStatusActionPerformed(evt);
            }
        });
        pnl_SearchPaymentStatus.add(cb_SearchPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 33));

        jPanel_Order.add(pnl_SearchPaymentStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 211, 87));

        pnl_SearchTotalAmount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchTotalAmount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchTotalAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_SearchTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchTotalAmountActionPerformed(evt);
            }
        });
        pnl_SearchTotalAmount.add(cb_SearchTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 150, 33));

        jPanel_Order.add(pnl_SearchTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 211, 87));

        lbl_SearchOrder1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_SearchOrder1.setText("Tìm kiếm hóa đơn:");
        jPanel_Order.add(lbl_SearchOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 130, 30));

        tbl_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Mã nhân viên", "Tên nhân viên", "Mã khách hàng", "Tên khách hàng", "Giảm giá", "Tổng tiền", "Trạng thái"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_Order.setViewportView(tbl_Order);
        if (tbl_Order.getColumnModel().getColumnCount() > 0) {
            tbl_Order.getColumnModel().getColumn(4).setHeaderValue("Mã khách hàng");
            tbl_Order.getColumnModel().getColumn(5).setHeaderValue("Tên khách hàng");
            tbl_Order.getColumnModel().getColumn(6).setHeaderValue("Giảm giá");
            tbl_Order.getColumnModel().getColumn(7).setHeaderValue("Tổng tiền");
            tbl_Order.getColumnModel().getColumn(8).setHeaderValue("Trạng thái");
        }

        jPanel_Order.add(scr_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 960, 230));

        add(jPanel_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1000, 450));

        jPanel_OrderDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel_OrderDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_OrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_OrderDetail.setViewportView(tbl_OrderDetail);

        jPanel_OrderDetail.add(scr_OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 200));

        add(jPanel_OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 1000, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchOrderActionPerformed

    private void cb_SearchPaymentStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchPaymentStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchPaymentStatusActionPerformed

    private void cb_SearchTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchTotalAmountActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Search;
    private javax.swing.JComboBox<String> cb_SearchPaymentStatus;
    private javax.swing.JComboBox<String> cb_SearchTotalAmount;
    private com.toedter.calendar.JDateChooser jDateChooser_SearchByTimeTo;
    private com.toedter.calendar.JDateChooser jDateChooser_SreachByTimeFrom;
    private javax.swing.JPanel jPanel_Order;
    private javax.swing.JPanel jPanel_OrderDetail;
    private javax.swing.JLabel lbl_SearchByTimeTo;
    private javax.swing.JLabel lbl_SearchOrder1;
    private javax.swing.JLabel lbl_SearchSearchByTimeFrom;
    private javax.swing.JPanel pnl_SearchByTime;
    private javax.swing.JPanel pnl_SearchPaymentStatus;
    private javax.swing.JPanel pnl_SearchTotalAmount;
    private javax.swing.JScrollPane scr_Order;
    private javax.swing.JScrollPane scr_OrderDetail;
    private javax.swing.JTable tbl_Order;
    private javax.swing.JTable tbl_OrderDetail;
    private javax.swing.JTextField txt_SearchOrder;
    // End of variables declaration//GEN-END:variables
}
