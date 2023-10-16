/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.KhuyenMaiDAO;
import entity.KhuyenMai;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author pc
 */
public class JPanel_KhuyenMai extends javax.swing.JPanel {
    private final DefaultTableModel modelKhuyenMai;
    private KhuyenMaiDAO khuyenMaiDAO;

    public JPanel_KhuyenMai() {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        modelKhuyenMai = (DefaultTableModel) tableDiscount.getModel();
        loadData();
    }

    private void loadData() {
        khuyenMaiDAO = new KhuyenMaiDAO();
        modelKhuyenMai.setRowCount(0);
        for (KhuyenMai km: khuyenMaiDAO.getAllKhuyenMai()) {
            Object[] row = {km.getMaKhuyenMai(), km.getTenChuongTrinh(), km.getPhanTramKhuyenMai(), km.getNgayBatDau(), km.getNgayKetThuc(), km.getMoTa()};
            modelKhuyenMai.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gioiTinh = new javax.swing.ButtonGroup();
        jpTitle = new javax.swing.JPanel();
        jbDiscountManagerment = new javax.swing.JLabel();
        jpFunction = new javax.swing.JPanel();
        lblDiscountID = new javax.swing.JLabel();
        lblNameProgram = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        txtDescribe = new javax.swing.JTextField();
        lblDescribe = new javax.swing.JLabel();
        txtProgram = new javax.swing.JTextField();
        txtDiscountID = new javax.swing.JTextField();
        jDateChooserDob = new com.toedter.calendar.JDateChooser();
        lblPercent = new javax.swing.JLabel();
        txtPercent = new javax.swing.JTextField();
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
        lblDob1 = new javax.swing.JLabel();
        jDateChooserDob1 = new com.toedter.calendar.JDateChooser();
        jPanelDiscountDetail = new javax.swing.JPanel();
        scrollDiscount = new javax.swing.JScrollPane();
        tableDiscount = new javax.swing.JTable();

        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1040, 760));
        setLayout(new java.awt.BorderLayout());

        jpTitle.setLayout(new java.awt.BorderLayout());

        jbDiscountManagerment.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jbDiscountManagerment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbDiscountManagerment.setText("QUẢN LÝ KHUYẾN MÃI");
        jpTitle.add(jbDiscountManagerment, java.awt.BorderLayout.CENTER);

        add(jpTitle, java.awt.BorderLayout.PAGE_START);

        jpFunction.setPreferredSize(new java.awt.Dimension(1010, 350));
        jpFunction.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDiscountID.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiscountID.setText("Mã khuyến mãi:");
        jpFunction.add(lblDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 130, 30));

        lblNameProgram.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNameProgram.setText("Tên chương trình:");
        jpFunction.add(lblNameProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDob.setText("Ngày bắt đầu:");
        jpFunction.add(lblDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, 30));

        txtDescribe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDescribe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescribeActionPerformed(evt);
            }
        });
        jpFunction.add(txtDescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, 430, 30));

        lblDescribe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDescribe.setText("Mô tả:");
        jpFunction.add(lblDescribe, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, -1, 30));

        txtProgram.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtProgram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProgramActionPerformed(evt);
            }
        });
        jpFunction.add(txtProgram, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 220, 30));

        txtDiscountID.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtDiscountID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiscountIDActionPerformed(evt);
            }
        });
        jpFunction.add(txtDiscountID, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 120, 30));
        jpFunction.add(jDateChooserDob, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 70, 190, 30));

        lblPercent.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPercent.setText("Phần trăm:");
        jpFunction.add(lblPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 80, 30));

        txtPercent.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPercent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPercentActionPerformed(evt);
            }
        });
        jpFunction.add(txtPercent, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 110, 30));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setRoundedBottomLeft(10);
        jpAdd.setRoundedBottomRight(10);
        jpAdd.setRoundedTopLeft(10);
        jpAdd.setRoundedTopRight(10);
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbAdd.setText("Thêm");
        jpAdd.add(jbAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 40));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 100, 40));

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setRoundedBottomLeft(10);
        jpDelete.setRoundedBottomRight(10);
        jpDelete.setRoundedTopLeft(10);
        jpDelete.setRoundedTopRight(10);
        jpDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Xoá");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, 100, 40));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jpFunction.add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 110, 40));

        lblDob1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDob1.setText("Ngày kết thúc:");
        jpFunction.add(lblDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 70, -1, 30));
        jpFunction.add(jDateChooserDob1, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 70, 190, 30));

        add(jpFunction, java.awt.BorderLayout.CENTER);

        jPanelDiscountDetail.setPreferredSize(new java.awt.Dimension(458, 500));
        jPanelDiscountDetail.setLayout(new java.awt.BorderLayout());

        tableDiscount.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã khuyến mãi", "Tên chương trình", "Phần trăm giảm", "Ngày bắt đầu", "Ngày kết thúc", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollDiscount.setViewportView(tableDiscount);

        jPanelDiscountDetail.add(scrollDiscount, java.awt.BorderLayout.CENTER);

        add(jPanelDiscountDetail, java.awt.BorderLayout.PAGE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void txtProgramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProgramActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProgramActionPerformed

    private void txtDiscountIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiscountIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiscountIDActionPerformed

    private void txtPercentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPercentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPercentActionPerformed

    private void txtDescribeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescribeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescribeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup gioiTinh;
    private com.toedter.calendar.JDateChooser jDateChooserDob;
    private com.toedter.calendar.JDateChooser jDateChooserDob1;
    private javax.swing.JPanel jPanelDiscountDetail;
    private javax.swing.JLabel jbAdd;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbDiscountManagerment;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpDelete;
    private util.JPanelRounded jpEdit;
    private javax.swing.JPanel jpFunction;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JPanel jpTitle;
    private javax.swing.JLabel lblDescribe;
    private javax.swing.JLabel lblDiscountID;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblDob1;
    private javax.swing.JLabel lblNameProgram;
    private javax.swing.JLabel lblPercent;
    private javax.swing.JScrollPane scrollDiscount;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tableDiscount;
    private javax.swing.JTextField txtDescribe;
    private javax.swing.JTextField txtDiscountID;
    private javax.swing.JTextField txtPercent;
    private javax.swing.JTextField txtProgram;
    // End of variables declaration//GEN-END:variables
}
