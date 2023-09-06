/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.SupplierDAO;
import entity.Supplier;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author BanhMi88
 */
public class JPanelSupplier extends javax.swing.JPanel {

    private final DefaultTableModel modelSupplier;
    private SupplierDAO supplierDAO;

    public JPanelSupplier() {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        svgSearch.setSvgImage("search.svg", 35, 35);
        modelSupplier = (DefaultTableModel) tableSupplier.getModel();
        setJText("", "", "", "", "", "");
        loadData();

    }

    private void setJText(String supplierID, String supplierName, String address, String contactPerson, String phone, String email) {
        txtSupplierID.setText(supplierID);
        txtSupplierName.setText(supplierName);
        txtAddress.setText(address);
        txtContactPerson.setText(contactPerson);
        txtSoDienThoai.setText(phone);
        txtEmail.setText(email);
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
        txtAddress = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        lblContactPerson = new javax.swing.JLabel();
        txtContactPerson = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jpAdd = new customLib.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new customLib.SVGImage();
        jpEdit = new customLib.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new customLib.SVGImage();
        jpDelete = new customLib.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new customLib.SVGImage();
        jpRefresh = new customLib.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new customLib.SVGImage();
        jpSearch = new customLib.JPanelRounded();
        jbSearch = new javax.swing.JLabel();
        svgSearch = new customLib.SVGImage();
        jPanel3 = new javax.swing.JPanel();
        srcollSupplier = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("QUẢN LÝ NHÀ CUNG CẤP");
        jPanel1.add(lbTitle, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(1010, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(1040, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSupplierName.setText("Tên nhà cung cấp:");
        jPanel2.add(lbSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 30));

        lbSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbSupplierID.setText("Mã nhà cung cấp:");
        jPanel2.add(lbSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 30));

        txtSupplierName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 180, 30));

        txtSupplierID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 180, 30));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 80, 540, 30));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setText("Địa chỉ:");
        jPanel2.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, -1, 30));

        lblContactPerson.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblContactPerson.setText("Người liên hệ:");
        jPanel2.add(lblContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 145, -1, 30));

        txtContactPerson.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 145, 280, 30));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 180, 30));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setText("Số điện thoại:");
        jPanel2.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, 100, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 50, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 220, 30));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setRoundedBottomLeft(10);
        jpAdd.setRoundedBottomRight(10);
        jpAdd.setRoundedTopLeft(10);
        jpAdd.setRoundedTopRight(10);
        jpAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAddMouseClicked(evt);
            }
        });
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdd.setText("Thêm");
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel2.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 100, 40));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEditMouseClicked(evt);
            }
        });
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel2.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 100, 40));

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setRoundedBottomLeft(10);
        jpDelete.setRoundedBottomRight(10);
        jpDelete.setRoundedTopLeft(10);
        jpDelete.setRoundedTopRight(10);
        jpDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpDeleteMouseClicked(evt);
            }
        });
        jpDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Xoá");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel2.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 200, 100, 40));

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
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel2.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 110, 40));

        jpSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpSearch.setRoundedBottomLeft(10);
        jpSearch.setRoundedBottomRight(10);
        jpSearch.setRoundedTopLeft(10);
        jpSearch.setRoundedTopRight(10);
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSearch.setText("Tìm");
        jpSearch.add(jbSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgSearch.setText(" ");
        jpSearch.add(svgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel2.add(jpSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 200, -1, -1));

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhà cung cấp", "Tên nhà cung cấp", "Địa chỉ", "Người liên hệ", "Số điện thoại", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableSupplierMouseClicked(evt);
            }
        });
        srcollSupplier.setViewportView(tableSupplier);

        jPanel3.add(srcollSupplier, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void txtSupplierNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierNameActionPerformed

    private void txtSupplierIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSupplierIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSupplierIDActionPerformed

    private void txtAddressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAddressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAddressActionPerformed

    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked
        supplierDAO = new SupplierDAO();

        String supplierID = txtSupplierID.getText();
        String supplierName = txtSupplierName.getText();
        String address = txtAddress.getText();
        String contactPerson = txtContactPerson.getText();
        String phone = txtSoDienThoai.getText();
        String email = txtEmail.getText();

        if (!"".equals(supplierID.trim()) && !"".equals(supplierName.trim()) && !"".equals(address.trim()) && !"".equals(contactPerson.trim()) && !"".equals(phone.trim()) && !"".equals(email.trim())) {
            Supplier supplier = new Supplier(supplierID, supplierName, address, phone, email, contactPerson);
            if (supplierDAO.insert(supplier)) {
                Object[] row = {supplierID, supplierName, address, phone, email, contactPerson};
                modelSupplier.addRow(row);
                setJText("", "", "", "", "", "");
                JOptionPane.showMessageDialog(this, "Thêm thành công");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm không thành công");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Không được để dữ liệu bị trống");
        }


    }//GEN-LAST:event_jpAddMouseClicked

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        int rowIndex = tableSupplier.getSelectedRow();
        if (rowIndex >= 0) {
            String supplierID = modelSupplier.getValueAt(rowIndex, 0).toString();
            String supplierName = modelSupplier.getValueAt(rowIndex, 1).toString();
            String address = modelSupplier.getValueAt(rowIndex, 2).toString();
            String contactPerson = modelSupplier.getValueAt(rowIndex, 3).toString();
            String phone = modelSupplier.getValueAt(rowIndex, 4).toString();
            String email = modelSupplier.getValueAt(rowIndex, 5).toString();
            setJText(supplierID, supplierName, address, contactPerson, phone, email);
        }
    }//GEN-LAST:event_tableSupplierMouseClicked

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked
        int rowIndex = tableSupplier.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa");
            setJText("", "", "", "", "", "");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                if (supplierDAO.delete(txtSupplierID.getText())) {
                    modelSupplier.removeRow(rowIndex);
                    setJText("", "", "", "", "", "");
                    JOptionPane.showMessageDialog(this, "Xoá thành công");
                } else {
                    JOptionPane.showMessageDialog(this, "Xoá thất bại");
                }
            }
        }
    }//GEN-LAST:event_jpDeleteMouseClicked

    private void jpEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEditMouseClicked
        int rowIndex = tableSupplier.getSelectedRow();
        if (rowIndex < 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
            setJText("", "", "", "", "", "");
        } else {
            if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                String supplierID = txtSupplierID.getText();
                String supplierName = txtSupplierName.getText();
                String address = txtAddress.getText();
                String contactPerson = txtContactPerson.getText();
                String phone = txtSoDienThoai.getText();
                String email = txtEmail.getText();
                Supplier supplier = new Supplier(supplierID, supplierName, address, phone, email, contactPerson);
                if (!"".equals(supplierID.trim()) && !"".equals(supplierName.trim()) && !"".equals(address.trim()) && !"".equals(contactPerson.trim()) && !"".equals(phone.trim()) && !"".equals(email.trim())) {
                    if (supplierDAO.update(supplier)) {
                        modelSupplier.removeRow(rowIndex);
                        Object[] row = {supplierID, supplierName, address, phone, email, contactPerson};
                        modelSupplier.insertRow(rowIndex, row);
                        setJText("", "", "", "", "", "");
                        JOptionPane.showMessageDialog(null, "Sửa thành công");
                    } else {
                        JOptionPane.showMessageDialog(null, "Sửa thất bại");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Không được để dữ liệu bị trống");
                }

            }
        }
    }//GEN-LAST:event_jpEditMouseClicked

    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        setJText("", "", "", "", "", "");
    }//GEN-LAST:event_jpRefreshMouseClicked

    private void loadData() {
        supplierDAO = new SupplierDAO();
        for (Supplier sup : supplierDAO.getAllSupplier()) {
            Object[] row = {sup.getSupplierID(), sup.getSupplierName(), sup.getAddress(), sup.getContactPerson(), sup.getPhone(), sup.getEmail()};
            modelSupplier.addRow(row);
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JLabel jbSearch;
    private customLib.JPanelRounded jpAdd;
    private customLib.JPanelRounded jpDelete;
    private customLib.JPanelRounded jpEdit;
    private customLib.JPanelRounded jpRefresh;
    private customLib.JPanelRounded jpSearch;
    private javax.swing.JLabel lbSupplierID;
    private javax.swing.JLabel lbSupplierName;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactPerson;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JScrollPane srcollSupplier;
    private customLib.SVGImage svgAdd;
    private customLib.SVGImage svgDelete;
    private customLib.SVGImage svgEdit;
    private customLib.SVGImage svgRefresh;
    private customLib.SVGImage svgSearch;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactPerson;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
