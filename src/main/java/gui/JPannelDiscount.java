/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import com.toedter.calendar.JDateChooser;
import dao.DiscountDAO;
import connectDB.ConnectDB;
import entity.Discount;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VONG VINH LOI
 */
public class JPannelDiscount extends javax.swing.JPanel {

    private final DefaultTableModel modelDiscount;
    public JDateChooser dateChooser = new JDateChooser();
    private DiscountDAO discountDAO;

    public JPannelDiscount() throws SQLException {
        initComponents();
        ConnectDB.getInstance().connect();
        modelDiscount = (DefaultTableModel) tableDiscount.getModel();
        loadData();
    }

    private void loadData() {
        discountDAO = new DiscountDAO();
        for (Discount discount : discountDAO.getAllDiscount()) {
            Object[] row = {discount.getDiscountID(), discount.getDiscountName(), discount.getDiscountType(), discount.getStartDate(), discount.getEndDate()};
            modelDiscount.addRow(row);
        }
    }

    @SuppressWarnings("uncheck")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneltoanbo = new javax.swing.JPanel();
        jbDiscountDetails = new javax.swing.JLabel();
        jbEndDateSearch = new javax.swing.JLabel();
        jbPercentDiscount = new javax.swing.JLabel();
        jbDiscountName = new javax.swing.JLabel();
        jbDiscountType = new javax.swing.JLabel();
        jbStartDateSearch = new javax.swing.JLabel();
        txtDiscountType = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        txtDiscountName = new javax.swing.JTextField();
        txtEndDateSearch = new com.toedter.calendar.JDateChooser();
        txtStartDateSearch = new com.toedter.calendar.JDateChooser();
        scrollDiscountDetails = new javax.swing.JScrollPane();
        tableDiscountDetails = new javax.swing.JTable();
        jbStartDate = new javax.swing.JLabel();
        txtStartDate = new com.toedter.calendar.JDateChooser();
        jbEndDate = new javax.swing.JLabel();
        txtEndDate = new com.toedter.calendar.JDateChooser();
        btnSearch = new javax.swing.JButton();
        jbDiscount = new javax.swing.JLabel();
        scrollDiscount = new javax.swing.JScrollPane();
        tableDiscount = new javax.swing.JTable();
        jbDiscountID = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtDiscountID = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 690));

        panneltoanbo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDiscountDetails.setBackground(new java.awt.Color(0, 0, 255));
        jbDiscountDetails.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbDiscountDetails.setText("Chi tiết chương trình giảm giá");
        panneltoanbo.add(jbDiscountDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jbEndDateSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbEndDateSearch.setText("Ngày kết thúc");
        panneltoanbo.add(jbEndDateSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 90, 30));

        jbPercentDiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbPercentDiscount.setText("% giảm:");
        panneltoanbo.add(jbPercentDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 90, 30));

        jbDiscountName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbDiscountName.setText("Tên chương trình:");
        panneltoanbo.add(jbDiscountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        jbDiscountType.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbDiscountType.setText("Loại chương trình:");
        panneltoanbo.add(jbDiscountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jbStartDateSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbStartDateSearch.setText("Ngày bắt đầu:");
        panneltoanbo.add(jbStartDateSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, 30));

        txtDiscountType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountTypeActionPerformed(evt);
            }
        });
        panneltoanbo.add(txtDiscountType, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        panneltoanbo.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 180, 30));

        txtDiscountName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountNameActionPerformed(evt);
            }
        });
        panneltoanbo.add(txtDiscountName, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, 30));
        panneltoanbo.add(txtEndDateSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 180, 30));
        panneltoanbo.add(txtStartDateSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 180, 30));

        tableDiscountDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảm giá", "Phần trăm giảm", "Mã sách"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableDiscountDetails.setShowHorizontalLines(true);
        tableDiscountDetails.setShowVerticalLines(true);
        scrollDiscountDetails.setViewportView(tableDiscountDetails);

        panneltoanbo.add(scrollDiscountDetails, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 650, 230));

        jbStartDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbStartDate.setText("Ngày bắt đầu:");
        panneltoanbo.add(jbStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));
        panneltoanbo.add(txtStartDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));

        jbEndDate.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbEndDate.setText("Ngày kết thúc");
        panneltoanbo.add(jbEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));
        panneltoanbo.add(txtEndDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 180, 30));

        btnSearch.setText("Tìm kiếm");
        btnSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSearchMouseClicked(evt);
            }
        });
        panneltoanbo.add(btnSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, -1, 30));

        jbDiscount.setBackground(new java.awt.Color(0, 0, 255));
        jbDiscount.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbDiscount.setText("Chương trình giảm giá");
        panneltoanbo.add(jbDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        tableDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giảm giá", "Tên chương trình", "Loại chương trình", "Ngày bắt đầu", "Ngày kết thúc"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableDiscount.setShowHorizontalLines(true);
        tableDiscount.setShowVerticalLines(true);
        tableDiscount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDiscountMouseClicked(evt);
            }
        });
        scrollDiscount.setViewportView(tableDiscount);
        if (tableDiscount.getColumnModel().getColumnCount() > 0) {
            tableDiscount.getColumnModel().getColumn(3).setHeaderValue("Ngày bắt đầu");
            tableDiscount.getColumnModel().getColumn(4).setHeaderValue("Ngày kết thúc");
        }

        panneltoanbo.add(scrollDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 650, 230));

        jbDiscountID.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jbDiscountID.setText("Mã giảm giá:");
        panneltoanbo.add(jbDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        jButton2.setText("...");
        panneltoanbo.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 460, 30, 30));

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        panneltoanbo.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 580, 120, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Danh sách sách:");
        panneltoanbo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 460, 90, 30));

        txtDiscountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountIDActionPerformed(evt);
            }
        });
        panneltoanbo.add(txtDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 180, 30));

        jButton3.setText("Thêm");
        panneltoanbo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, -1, -1));

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panneltoanbo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, -1, -1));

        btnEdit.setText("Sửa");
        btnEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEditMouseClicked(evt);
            }
        });
        panneltoanbo.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        btnAdd.setText("Thêm");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });
        panneltoanbo.add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        btnDelete.setText("Xóa");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        panneltoanbo.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panneltoanbo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panneltoanbo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtDiscountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountIDActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void tableDiscountMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDiscountMouseClicked
        int rowindex = tableDiscount.getSelectedRow();
        if (rowindex >= 0) {
            String discountID = modelDiscount.getValueAt(rowindex, 0).toString();
            String discountName = modelDiscount.getValueAt(rowindex, 1).toString();
            String discountType = modelDiscount.getValueAt(rowindex, 2).toString();
            Date starDate = (Date) modelDiscount.getValueAt(rowindex, 3);
            Date endDate = (Date) modelDiscount.getValueAt(rowindex, 4);
            show(discountID, discountName, discountType, starDate, endDate);
        }
    }//GEN-LAST:event_tableDiscountMouseClicked

    private void btnSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSearchMouseClicked
        java.sql.Date startDate = new java.sql.Date(txtStartDateSearch.getDate().getTime());
        java.sql.Date endDate = new java.sql.Date(txtEndDateSearch.getDate().getTime());

        if (startDate == null || endDate == null) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu");
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableDiscount.getModel();
        model.setRowCount(0); // Xóa hết dữ liệu trong bảng

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        discountDAO = new DiscountDAO();

        for (Discount discount : discountDAO.getAllDiscount()) {
            java.sql.Date rowStartDate = discount.getStartDate();
            java.sql.Date rowEndDate = discount.getEndDate();

            boolean start1 = startDate.before(rowStartDate) || dateFormat.format(startDate).equals(dateFormat.format(rowStartDate));
            boolean end1 = endDate.after(rowEndDate) || endDate.equals(rowEndDate);

            System.out.println("---" + startDate);
            System.out.println(rowStartDate + "---" + start1 + "******");

            if (start1 && end1) {
                Object[] row = {discount.getDiscountID(), discount.getDiscountName(), discount.getDiscountType(), rowStartDate, rowEndDate};
                model.addRow(row);
            }
        }
    }//GEN-LAST:event_btnSearchMouseClicked

    private void txtDiscountNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountNameActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void txtDiscountTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountTypeActionPerformed

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        discountDAO = new DiscountDAO();
        java.sql.Date sqldate = new java.sql.Date(txtStartDate.getDate().getTime());
        java.sql.Date sqldate1 = new java.sql.Date(txtStartDate.getDate().getTime());
        String ma = txtDiscountID.getText();
        String ten = txtDiscountName.getText();
        String loai = txtDiscountType.getText();
        Discount discount = new Discount(loai, ten, loai, sqldate, sqldate1);
        discountDAO.insert(discount);
        Object[] row = {ma, ten, loai, sqldate, sqldate1};
        modelDiscount.addRow(row);
        show("", "", "", null, null);
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        int rowindex = tableDiscount.getSelectedRow();
        if (rowindex == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa");
            show("", "", "", null, null);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                discountDAO.delete(txtDiscountID.getText());
                modelDiscount.removeRow(rowindex);
                show("", "", "", null, null);
            }

        }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditMouseClicked
        int rowindex = tableDiscount.getSelectedRow();
        if (rowindex == -1) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
            show("", "", "", null, null);
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                java.sql.Date sqldate = new java.sql.Date(txtStartDate.getDate().getTime());
                java.sql.Date sqldate1 = new java.sql.Date(txtEndDate.getDate().getTime());
                String ma = txtDiscountID.getText();
                String ten = txtDiscountName.getText();
                String loai = txtDiscountType.getText();
                Discount discount = new Discount(ma, ten, loai, sqldate, sqldate1);
                discountDAO.update(discount);
                modelDiscount.removeRow(rowindex);
                Object[] row = {ma, ten, loai, sqldate, sqldate1};
                modelDiscount.insertRow(rowindex, row);
                show("", "", "", null, null);
            }
        }
    }//GEN-LAST:event_btnEditMouseClicked

    private void show(String discountID, String discountName, String discountType, Date startDate, Date endDate) {
        txtDiscountID.setText(discountID);
        txtDiscountName.setText(discountName);
        txtDiscountType.setText(discountType);
        txtStartDate.setDate(startDate);
        txtEndDate.setDate(endDate);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JLabel jbDiscount;
    private javax.swing.JLabel jbDiscountDetails;
    private javax.swing.JLabel jbDiscountID;
    private javax.swing.JLabel jbDiscountName;
    private javax.swing.JLabel jbDiscountType;
    private javax.swing.JLabel jbEndDate;
    private javax.swing.JLabel jbEndDateSearch;
    private javax.swing.JLabel jbPercentDiscount;
    private javax.swing.JLabel jbStartDate;
    private javax.swing.JLabel jbStartDateSearch;
    private javax.swing.JPanel panneltoanbo;
    private javax.swing.JScrollPane scrollDiscount;
    private javax.swing.JScrollPane scrollDiscountDetails;
    private javax.swing.JTable tableDiscount;
    private javax.swing.JTable tableDiscountDetails;
    private javax.swing.JTextField txtDiscountID;
    private javax.swing.JTextField txtDiscountName;
    private javax.swing.JTextField txtDiscountType;
    private com.toedter.calendar.JDateChooser txtEndDate;
    private com.toedter.calendar.JDateChooser txtEndDateSearch;
    private com.toedter.calendar.JDateChooser txtStartDate;
    private com.toedter.calendar.JDateChooser txtStartDateSearch;
    // End of variables declaration//GEN-END:variables

}
