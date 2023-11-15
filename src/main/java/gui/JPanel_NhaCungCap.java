/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.NhaCungCapDAO;
import entity.NhaCungCap;
import static gui.GiaoDienDangNhap.ngonNgu;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static util.Validator.checkName;
import static util.Validator.*;

/**
 *
 * @author BanhMi88
 */
public class JPanel_NhaCungCap extends javax.swing.JPanel {

    private final DefaultTableModel modelNhaCungCap;
    private NhaCungCapDAO nhaCungCapDAO;

    public JPanel_NhaCungCap() {
        initComponents();
        if (ngonNgu == 2) {
            ChuyenDoiNN();
        }
        svgAdd.setSvgImage("add.svg", 40, 40);
        svgEdit.setSvgImage("edit.svg", 35, 35);
        svgDelete.setSvgImage("delete.svg", 40, 40);
        svgRefresh.setSvgImage("refresh.svg", 35, 35);
        modelNhaCungCap = (DefaultTableModel) tableSupplier.getModel();
        nhaCungCapDAO = new NhaCungCapDAO();
        setValue(nhaCungCapDAO.taoMaNCC(), "", "Đang làm", "", "", "", "");
        txtSupplierID.setEditable(false);

        loadData();

    }

    private void setValue(String maNCC, String tenNCC, String trangThai, String diaChi, String email, String soDienThoai, String nguoiLienHe) {

        txtSupplierID.setText(maNCC);
        txtSupplierName.setText(tenNCC);
        cbStatus.setSelectedItem(trangThai);
        txtAddress.setText(diaChi);
        txtEmail.setText(email);
        txtSoDienThoai.setText(soDienThoai);
        txtContactPerson.setText(nguoiLienHe);

    }

    public void ChuyenDoiNN() {
        lbSupplierID.setText("Supplier ID:");
        lbSupplierName.setText("Supplier Name:");
        lblContactPerson.setText("Contact Person:");
        lblAddress.setText("Address:");
        lblPhone.setText("Phone:");
        lblSearch1.setText("Status:");
        lbTitle.setText("SUPPLIER MANAGERMENT");
        jbAdd.setText("Add");
        jbDelete.setText("Delete");
        jbRefresh.setText("Refresh");
        jbEdit.setText("Edit");
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
        jpAdd = new util.JPanelRounded();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new util.SVGImage();
        jpEdit = new util.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new util.SVGImage();
        jpDelete = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jpRefresh = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();
        cbStatus = new javax.swing.JComboBox<>();
        lblSearch1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        srcollSupplier = new javax.swing.JScrollPane();
        tableSupplier = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(490, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        lbTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbTitle.setText("QUẢN LÝ NHÀ CUNG CẤP");
        jPanel1.add(lbTitle, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setMinimumSize(new java.awt.Dimension(1010, 200));
        jPanel2.setPreferredSize(new java.awt.Dimension(1040, 200));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbSupplierName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSupplierName.setText("Tên nhà cung cấp:");
        jPanel2.add(lbSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 40));

        lbSupplierID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbSupplierID.setText("Mã nhà cung cấp:");
        jPanel2.add(lbSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, 40));

        txtSupplierName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSupplierName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierNameActionPerformed(evt);
            }
        });
        jPanel2.add(txtSupplierName, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 90, 240, 40));

        txtSupplierID.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSupplierID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSupplierIDActionPerformed(evt);
            }
        });
        jPanel2.add(txtSupplierID, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 210, 40));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtAddress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAddressActionPerformed(evt);
            }
        });
        jPanel2.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 90, 240, 40));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblAddress.setText("Địa chỉ:");
        jPanel2.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 90, -1, 40));

        lblContactPerson.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblContactPerson.setText("Người liên hệ:");
        jPanel2.add(lblContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, 40));

        txtContactPerson.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtContactPerson, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, 250, 40));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 20, 280, 40));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("Số điện thoại:");
        jPanel2.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 20, -1, 40));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");
        jPanel2.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, 40));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 20, 230, 40));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbAdd.setText("Thêm");
        jbAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbAddMouseClicked(evt);
            }
        });
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jPanel2.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 150, 50));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jPanel2.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 150, 50));

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jbDelete.setText("Xoá");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 100, 50));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 40, 40));

        jPanel2.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 150, 50));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        jPanel2.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, 150, 50));

        cbStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cbStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hợp tác", "Ngưng hợp tác", " " }));
        jPanel2.add(cbStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 90, 200, 40));

        lblSearch1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSearch1.setText("Trạng thái:");
        jPanel2.add(lblSearch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 90, -1, 40));

        add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(452, 470));
        jPanel3.setLayout(new java.awt.BorderLayout());

        if(ngonNgu==2)
        {
            tableSupplier.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Supplier Name", "Supplier Name", "Status", "Address", "Email", "Phone", "Contact Person"
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
        if (ngonNgu == 2) {
            nhaCungCapDAO = new NhaCungCapDAO();

            String maNCC = txtSupplierID.getText();
            if (maNCC.equals(nhaCungCapDAO.taoMaNCC())) {
                String tenNCC = txtSupplierName.getText();
                boolean trangThai = (cbStatus.getSelectedIndex() == 0);
                String diaChi = txtAddress.getText();
                String email = txtEmail.getText();
                String soDienThoai = txtSoDienThoai.getText();
                String nguoiLienHe = txtContactPerson.getText();
                if (!checkEmpty(tenNCC) && !checkEmpty(diaChi) && !checkEmpty(nguoiLienHe) && !checkEmpty(soDienThoai) && !checkEmpty(email)) {
                    NhaCungCap nhaCungCap = new NhaCungCap(maNCC, tenNCC, trangThai, diaChi, email, soDienThoai, nguoiLienHe);
                    if (checkText(tenNCC, "Invalid supplier name") && checkPhone(soDienThoai, "Invalid phone number") && checkName(nguoiLienHe, "Invalid contact person name") && checkName(diaChi, "Invalid address") && checkMail(email, "Invalid email")) {
                        if (nhaCungCapDAO.insert(nhaCungCap)) {
                            loadData();
                            JOptionPane.showMessageDialog(this, "Added successfully");
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to add");
                        }
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Cannot add an existing supplier");
            }
        } else {
            nhaCungCapDAO = new NhaCungCapDAO();

            String maNCC = txtSupplierID.getText();
            if (maNCC.equals(nhaCungCapDAO.taoMaNCC())) {
                String tenNCC = txtSupplierName.getText();
                boolean trangThai = (cbStatus.getSelectedIndex() == 0);
                String diaChi = txtAddress.getText();
                String email = txtEmail.getText();
                String soDienThoai = txtSoDienThoai.getText();
                String nguoiLienHe = txtContactPerson.getText();
                if (!checkEmpty(tenNCC) && !checkEmpty(diaChi) && !checkEmpty(nguoiLienHe) && !checkEmpty(soDienThoai) && !checkEmpty(email)) {
                    NhaCungCap nhaCungCap = new NhaCungCap(maNCC, tenNCC, trangThai, diaChi, email, soDienThoai, nguoiLienHe);
                    if (checkText(tenNCC, "Tên nhà cung cấp không hợp lệ") && checkPhone(soDienThoai, "Số điện thoại không hợp lệ") && checkName(nguoiLienHe, "Tên người liên hệ không hợp lệ") && checkName(diaChi, "Địa chỉ không hợp lệ") && checkMail(email, "Email không hợp lệ")) {
                        if (nhaCungCapDAO.insert(nhaCungCap)) {
                            loadData();
                            JOptionPane.showMessageDialog(this, "Thêm thành công");
                        } else {
                            JOptionPane.showMessageDialog(this, "Thêm không thành công");
                        }
                    }

                }
            } else {
                JOptionPane.showMessageDialog(this, "Không được thêm nhà cung cấp đã tồn tại");
            }
        }
    }//GEN-LAST:event_jpAddMouseClicked

    private void tableSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableSupplierMouseClicked
        int rowIndex = tableSupplier.getSelectedRow();
        if (rowIndex >= 0) {
            String maNCC = modelNhaCungCap.getValueAt(rowIndex, 0).toString();
            String tenNCC = modelNhaCungCap.getValueAt(rowIndex, 1).toString();
            String trangThai = modelNhaCungCap.getValueAt(rowIndex, 2).toString();
            String diaChi = modelNhaCungCap.getValueAt(rowIndex, 3).toString();
            String email = modelNhaCungCap.getValueAt(rowIndex, 4).toString();
            String soDienThoai = modelNhaCungCap.getValueAt(rowIndex, 5).toString();
            String nguoiLienHe = modelNhaCungCap.getValueAt(rowIndex, 6).toString();
            setValue(maNCC, tenNCC, trangThai, diaChi, email, soDienThoai, nguoiLienHe);
        }
    }//GEN-LAST:event_tableSupplierMouseClicked

    private void jpEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEditMouseClicked
        if (ngonNgu == 2) {
            int rowIndex = tableSupplier.getSelectedRow();
            if (rowIndex < 0) {
                JOptionPane.showMessageDialog(null, "Please select a row to edit");
                setValue(nhaCungCapDAO.taoMaNCC(), "", "Working on it", "", "", "", "");
            } else {
                if (JOptionPane.showConfirmDialog(null, "Are you sure you want to edit this row?", "Confirm", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                    String maNCC = txtSupplierID.getText();
                    String tenNCC = txtSupplierName.getText();
                    boolean trangThai = (cbStatus.getSelectedIndex() == 0);
                    String diaChi = txtAddress.getText();
                    String email = txtEmail.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String nguoiLienHe = txtContactPerson.getText();
                    if (!checkEmpty(tenNCC) && !checkEmpty(diaChi) && !checkEmpty(nguoiLienHe) && !checkEmpty(soDienThoai) && !checkEmpty(email)) {
                        if (checkText(tenNCC, "Invalid supplier name") && checkPhone(soDienThoai, "Invalid phone number") && checkName(nguoiLienHe, "Invalid contact person name") && checkName(diaChi, "Invalid address") && checkMail(email, "Invalid email")) {
                            NhaCungCap supplier = new NhaCungCap(maNCC, tenNCC, trangThai, diaChi, email, soDienThoai, nguoiLienHe);
                            if (nhaCungCapDAO.update(supplier)) {
                                loadData();
                                JOptionPane.showMessageDialog(null, "Edit successful");
                            } else {
                                JOptionPane.showMessageDialog(null, "Edit failed");
                            }
                        }
                    }

                }
            }
        } else {
            int rowIndex = tableSupplier.getSelectedRow();
            if (rowIndex < 0) {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
                setValue(nhaCungCapDAO.taoMaNCC(), "", "Đang làm", "", "", "", "");
            } else {
                if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                    String maNCC = txtSupplierID.getText();
                    String tenNCC = txtSupplierName.getText();
                    boolean trangThai = (cbStatus.getSelectedIndex() == 0);
                    String diaChi = txtAddress.getText();
                    String email = txtEmail.getText();
                    String soDienThoai = txtSoDienThoai.getText();
                    String nguoiLienHe = txtContactPerson.getText();
                    if (!checkEmpty(tenNCC) && !checkEmpty(diaChi) && !checkEmpty(nguoiLienHe) && !checkEmpty(soDienThoai) && !checkEmpty(email)) {
                        if (checkText(tenNCC, "Tên nhà cung cấp không hợp lệ") && checkPhone(soDienThoai, "Số điện thoại không hợp lệ") && checkName(nguoiLienHe, "Tên người liên hệ không hợp lệ") && checkName(diaChi, "Địa chỉ không hợp lệ") && checkMail(email, "Email không hợp lệ")) {
                            NhaCungCap supplier = new NhaCungCap(maNCC, tenNCC, trangThai, diaChi, email, soDienThoai, nguoiLienHe);
                            if (nhaCungCapDAO.update(supplier)) {
                                loadData();
                                JOptionPane.showMessageDialog(null, "Sửa thành công");
                            } else {
                                JOptionPane.showMessageDialog(null, "Sửa thất bại");
                            }
                        }
                    }

                }
            }
        }
    }//GEN-LAST:event_jpEditMouseClicked


    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        setValue(nhaCungCapDAO.taoMaNCC(), "", "Đang làm", "", "", "", "");
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked
//                int rowIndex = tableSupplier.getSelectedRow();
//                if (rowIndex < 0) {
//                    JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa");
//                    setValue(nhaCungCapDAO.createSupplierID(), "", "", "", "", "", 0);
//                } else {
//                    if (JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
//                        if (nhaCungCapDAO.delete(txtSupplierID.getText())) {
//                            modelNhaCungCap.removeRow(rowIndex);
//                            setValue(nhaCungCapDAO.createSupplierID(), "", "", "", "", "", 0);
//                            JOptionPane.showMessageDialog(this, "Xoá thành công");
//                        } else {
//                            JOptionPane.showMessageDialog(this, "Xoá thất bại");
//                        }
//                    }
//                }
    }//GEN-LAST:event_jpDeleteMouseClicked

    private void jbAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbAddMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jbAddMouseClicked

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
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpDelete;
    private util.JPanelRounded jpEdit;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JLabel lbSupplierID;
    private javax.swing.JLabel lbSupplierName;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblContactPerson;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSearch1;
    private javax.swing.JScrollPane srcollSupplier;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableSupplier;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtContactPerson;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtSupplierID;
    private javax.swing.JTextField txtSupplierName;
    // End of variables declaration//GEN-END:variables
}
