/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;


/**
 *
 * @author pc
 */
public class JpanelEmployee extends javax.swing.JPanel {

    public JpanelEmployee() {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        svgExcel.setSvgImage("excel.svg", 30, 30);
        svgPdf.setSvgImage("pdf.svg", 25, 30);
        svgSearch.setSvgImage("search.svg", 35, 35);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpTitle = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblEmployeeID = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        radFemale = new javax.swing.JRadioButton();
        radMale = new javax.swing.JRadioButton();
        lblPhone = new javax.swing.JLabel();
        lblStatus = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        comboboxPosition = new javax.swing.JComboBox<>();
        lblPosition = new javax.swing.JLabel();
        txtEmployeeID = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        txtEmployeeID1 = new javax.swing.JTextField();
        jDateChooserDob = new com.toedter.calendar.JDateChooser();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jPanelSearch = new javax.swing.JPanel();
        jpSearch = new customLib.roundedPanel();
        jbSearch = new javax.swing.JLabel();
        svgSearch = new customLib.SVGImage();
        jLabelSearchByNameOrByCode = new javax.swing.JLabel();
        jTextFieldSearchByNameOrByCode = new javax.swing.JTextField();
        jLabelSearchSelection = new javax.swing.JLabel();
        jComboBoxSearchSelection = new javax.swing.JComboBox<>();
        jPanelSort = new javax.swing.JPanel();
        jComboBoxSortSelection = new javax.swing.JComboBox<>();
        jLabelSortBy = new javax.swing.JLabel();
        jComboBoxSortDropDown = new javax.swing.JComboBox<>();
        jpAdd = new customLib.roundedPanel();
        jbAdd = new javax.swing.JLabel();
        svgAdd = new customLib.SVGImage();
        jpEdit = new customLib.roundedPanel();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new customLib.SVGImage();
        jpDelete = new customLib.roundedPanel();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new customLib.SVGImage();
        jpRefresh = new customLib.roundedPanel();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new customLib.SVGImage();
        jpExcel = new customLib.roundedPanel();
        jbExcel = new javax.swing.JLabel();
        svgExcel = new customLib.SVGImage();
        jpPdf = new customLib.roundedPanel();
        jbPdf = new javax.swing.JLabel();
        svgPdf = new customLib.SVGImage();
        jPanelEmployeeDetail = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEmployee = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jpTitle.setLayout(new java.awt.BorderLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Employee Manager");
        jpTitle.add(title, java.awt.BorderLayout.CENTER);

        add(jpTitle, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEmployeeID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeID.setText("Employee ID:");
        jpFunction.add(lblEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 100, 30));

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblFullName.setText("Full Name:");
        jpFunction.add(lblFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 120, 220, 30));

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblGender.setText("Gender:");
        jpFunction.add(lblGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, -1, 30));

        radFemale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radFemale.setText("Female");
        radFemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radFemaleActionPerformed(evt);
            }
        });
        jpFunction.add(radFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, 30));

        radMale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        radMale.setSelected(true);
        radMale.setText("Male");
        radMale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radMaleActionPerformed(evt);
            }
        });
        jpFunction.add(radMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 70, -1, 30));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPhone.setText("Phone:");
        jpFunction.add(lblPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 50, 30));

        lblStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStatus.setText("Status:");
        jpFunction.add(lblStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, 30));

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDob.setText("Date Of Birth:");
        jpFunction.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 20, -1, 30));

        txtAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 70, 300, 30));

        comboboxPosition.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboboxPosition.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jpFunction.add(comboboxPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 180, 30));

        lblPosition.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPosition.setText("Position:");
        jpFunction.add(lblPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 30));

        txtEmployeeID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmployeeID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeIDActionPerformed(evt);
            }
        });
        jpFunction.add(txtEmployeeID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 180, 30));

        lblAddress.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAddress.setText("Address:");
        jpFunction.add(lblAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, 30));

        txtFullName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFullName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFullNameActionPerformed(evt);
            }
        });
        jpFunction.add(txtFullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 180, 30));

        txtEmployeeID1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtEmployeeID1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmployeeID1ActionPerformed(evt);
            }
        });
        jpFunction.add(txtEmployeeID1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 180, 30));
        jpFunction.add(jDateChooserDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, 180, 30));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmail.setText("Email:");
        jpFunction.add(lblEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 120, 50, 30));

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jpFunction.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 120, 220, 30));

        jPanelSearch.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Advanced Search", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanelSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpSearch.setRoundedBottomLeft(10);
        jpSearch.setRoundedBottomRight(10);
        jpSearch.setRoundedTopLeft(10);
        jpSearch.setRoundedTopRight(10);
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbSearch.setText("Search");
        jpSearch.add(jbSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgSearch.setText(" ");
        jpSearch.add(svgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanelSearch.add(jpSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, 100, 40));

        jLabelSearchByNameOrByCode.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchByNameOrByCode.setText("Search by Name or ID:");
        jPanelSearch.add(jLabelSearchByNameOrByCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 29, -1, 30));

        jTextFieldSearchByNameOrByCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldSearchByNameOrByCodeActionPerformed(evt);
            }
        });
        jPanelSearch.add(jTextFieldSearchByNameOrByCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 29, 160, 30));

        jLabelSearchSelection.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSearchSelection.setText("Search Selection:");
        jPanelSearch.add(jLabelSearchSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 30));

        jComboBoxSearchSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxSearchSelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxSearchSelectionActionPerformed(evt);
            }
        });
        jPanelSearch.add(jComboBoxSearchSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, 85, 30));

        jpFunction.add(jPanelSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 570, 110));

        jPanelSort.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sort", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanelSort.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBoxSortSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelSort.add(jComboBoxSortSelection, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 120, 30));

        jLabelSortBy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelSortBy.setText("Sort by:");
        jPanelSort.add(jLabelSortBy, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        jComboBoxSortDropDown.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanelSort.add(jComboBoxSortDropDown, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 120, 30));

        jpFunction.add(jPanelSort, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 300, 110));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setRoundedBottomLeft(10);
        jpAdd.setRoundedBottomRight(10);
        jpAdd.setRoundedTopLeft(10);
        jpAdd.setRoundedTopRight(10);
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdd.setText("Add");
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 100, 40));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Edit");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 170, 100, 40));

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setRoundedBottomLeft(10);
        jpDelete.setRoundedBottomRight(10);
        jpDelete.setRoundedTopLeft(10);
        jpDelete.setRoundedTopRight(10);
        jpDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Delete");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 100, 40));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Refresh");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 170, 100, 40));

        jpExcel.setBackground(new java.awt.Color(255, 255, 255));
        jpExcel.setRoundedBottomLeft(10);
        jpExcel.setRoundedBottomRight(10);
        jpExcel.setRoundedTopLeft(10);
        jpExcel.setRoundedTopRight(10);
        jpExcel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbExcel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbExcel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbExcel.setText("Export Excel");
        jpExcel.add(jbExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 0, 90, 40));

        svgExcel.setText(" ");
        jpExcel.add(svgExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 170, 140, 40));

        jpPdf.setBackground(new java.awt.Color(255, 255, 255));
        jpPdf.setRoundedBottomLeft(10);
        jpPdf.setRoundedBottomRight(10);
        jpPdf.setRoundedTopLeft(10);
        jpPdf.setRoundedTopRight(10);
        jpPdf.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbPdf.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbPdf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbPdf.setText("Export PDF");
        jpPdf.add(jbPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 40));

        svgPdf.setText(" ");
        jpPdf.add(svgPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpPdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 170, 130, 40));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        jPanelEmployeeDetail.setPreferredSize(new java.awt.Dimension(458, 370));
        jPanelEmployeeDetail.setLayout(new java.awt.BorderLayout());

        jTableEmployee.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EmployeeID", "FullName", "Gender", "Date Of Birth", "Address", "Phone", "Email", "Position", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTableEmployee);

        jPanelEmployeeDetail.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        add(jPanelEmployeeDetail, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void radFemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radFemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radFemaleActionPerformed

    private void radMaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radMaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_radMaleActionPerformed

    private void txtEmployeeIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeIDActionPerformed

    private void txtFullNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFullNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFullNameActionPerformed

    private void txtEmployeeID1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmployeeID1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmployeeID1ActionPerformed

    private void jTextFieldSearchByNameOrByCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldSearchByNameOrByCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldSearchByNameOrByCodeActionPerformed

    private void jComboBoxSearchSelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxSearchSelectionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxSearchSelectionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboboxPosition;
    private javax.swing.JComboBox<String> jComboBoxSearchSelection;
    private javax.swing.JComboBox<String> jComboBoxSortDropDown;
    private javax.swing.JComboBox<String> jComboBoxSortSelection;
    private com.toedter.calendar.JDateChooser jDateChooserDob;
    private javax.swing.JLabel jLabelSearchByNameOrByCode;
    private javax.swing.JLabel jLabelSearchSelection;
    private javax.swing.JLabel jLabelSortBy;
    private javax.swing.JPanel jPanelEmployeeDetail;
    private javax.swing.JPanel jPanelSearch;
    private javax.swing.JPanel jPanelSort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableEmployee;
    private javax.swing.JTextField jTextFieldSearchByNameOrByCode;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbExcel;
    private javax.swing.JLabel jbPdf;
    private javax.swing.JLabel jbRefresh;
    private javax.swing.JLabel jbSearch;
    private customLib.roundedPanel jpAdd;
    private customLib.roundedPanel jpDelete;
    private customLib.roundedPanel jpEdit;
    private customLib.roundedPanel jpExcel;
    private javax.swing.JPanel jpFunction;
    private customLib.roundedPanel jpPdf;
    private customLib.roundedPanel jpRefresh;
    private customLib.roundedPanel jpSearch;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblEmployeeID;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblPosition;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JRadioButton radFemale;
    private javax.swing.JRadioButton radMale;
    private customLib.SVGImage svgAdd;
    private customLib.SVGImage svgDelete;
    private customLib.SVGImage svgEdit;
    private customLib.SVGImage svgExcel;
    private customLib.SVGImage svgPdf;
    private customLib.SVGImage svgRefresh;
    private customLib.SVGImage svgSearch;
    private javax.swing.JLabel title;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEmployeeID;
    private javax.swing.JTextField txtEmployeeID1;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
