/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;
import com.toedter.calendar.JDateChooser;
import Dao.giamgiaDAO;
import connectDB.ConnectDB;
import entity.giamgia;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author VONG VINH LOI
 */
public class jpannelgiamgia extends javax.swing.JPanel{

   private DefaultTableModel modelgiamgia;
    public JDateChooser dateChooser = new JDateChooser();
    private ConnectDB connectDB;
    private ArrayList<giamgia> listgiamgia;
    private giamgiaDAO giamgiadao;
    
    public jpannelgiamgia() throws SQLException {
        initComponents();
        ConnectDB.getInstance().connect();
        Connection con = ConnectDB.getConnection();
        loaddulieu();
    }
    private void loaddulieu()
    {
        giamgiadao = new giamgiaDAO();
        for(giamgia gg : giamgiadao.getAllgiamgia())
        {
            Object[] row={gg.getMagiamgia(),gg.getTenchuongtrinh(),gg.getLoaichuongtrinh(),gg.getNgaybatdau(),gg.getNgayketthuc()};
            modelgiamgia.addRow(row);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panneltoanbo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfloaichuongtrinh = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jtftenchuongtrinh = new javax.swing.JTextField();
        jtfketthuctk = new com.toedter.calendar.JDateChooser();
        jtfbatdautk = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jtfngaybatdau = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        jtfngayketthuc = new com.toedter.calendar.JDateChooser();
        jbttimkim = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        modelgiamgia = new DefaultTableModel();
        table1 = new JTable(modelgiamgia);
        jLabel10 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtfmagiamgia = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jbtsua = new javax.swing.JButton();
        jbtthem = new javax.swing.JButton();
        jbtxoa = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1040, 690));

        panneltoanbo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 0, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 255));
        jLabel1.setText("Chi tiết chương trình giảm giá");
        panneltoanbo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 380, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Ngày kết thúc");
        panneltoanbo.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 90, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("% giảm:");
        panneltoanbo.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 580, 90, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Tên chương trình:");
        panneltoanbo.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Loại chương trình:");
        panneltoanbo.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Ngày bắt đầu:");
        panneltoanbo.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 90, 30));

        jtfloaichuongtrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfloaichuongtrinhActionPerformed(evt);
            }
        });
        panneltoanbo.add(jtfloaichuongtrinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 180, 30));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        panneltoanbo.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 520, 180, 30));

        jtftenchuongtrinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtftenchuongtrinhActionPerformed(evt);
            }
        });
        panneltoanbo.add(jtftenchuongtrinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 180, 30));
        panneltoanbo.add(jtfketthuctk, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, 180, 30));
        panneltoanbo.add(jtfbatdautk, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 340, 180, 30));

        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
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
        table2.setShowHorizontalLines(true);
        table2.setShowVerticalLines(true);
        jScrollPane1.setViewportView(table2);

        panneltoanbo.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 650, 230));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Ngày bắt đầu:");
        panneltoanbo.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));
        panneltoanbo.add(jtfngaybatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 180, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Ngày kết thúc");
        panneltoanbo.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));
        panneltoanbo.add(jtfngayketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 180, 30));

        jbttimkim.setText("Tìm kiếm");
        jbttimkim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbttimkimMouseClicked(evt);
            }
        });
        panneltoanbo.add(jbttimkim, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 340, -1, 30));

        jLabel2.setBackground(new java.awt.Color(0, 0, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 51, 255));
        jLabel2.setText("Chương trình giảm giá");
        panneltoanbo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, -1, -1));

        modelgiamgia.addColumn("Ma giảm giá");
        modelgiamgia.addColumn("Tên chương trình");
        modelgiamgia.addColumn("Loại chương trình");
        modelgiamgia.addColumn("Ngày bắt đầu");
        modelgiamgia.addColumn("Ngày kết thúc");
        table1.setModel(modelgiamgia);
        table1.setShowHorizontalLines(true);
        table1.setShowVerticalLines(true);
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table1);
        if (table1.getColumnModel().getColumnCount() > 0) {
            table1.getColumnModel().getColumn(3).setHeaderValue("Ngày bắt đầu");
            table1.getColumnModel().getColumn(4).setHeaderValue("Ngày kết thúc");
        }

        panneltoanbo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 60, 650, 230));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Mã giảm giá:");
        panneltoanbo.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

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

        jtfmagiamgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfmagiamgiaActionPerformed(evt);
            }
        });
        panneltoanbo.add(jtfmagiamgia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 180, 30));

        jButton3.setText("Thêm");
        panneltoanbo.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 640, -1, -1));

        jButton4.setText("Xóa");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        panneltoanbo.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 640, -1, -1));

        jbtsua.setText("Sửa");
        jbtsua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtsuaMouseClicked(evt);
            }
        });
        panneltoanbo.add(jbtsua, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, -1, -1));

        jbtthem.setText("Thêm");
        jbtthem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtthemMouseClicked(evt);
            }
        });
        panneltoanbo.add(jbtthem, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jbtxoa.setText("Xóa");
        jbtxoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtxoaMouseClicked(evt);
            }
        });
        panneltoanbo.add(jbtxoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, -1, -1));

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

    private void jtfloaichuongtrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfloaichuongtrinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfloaichuongtrinhActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jtftenchuongtrinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtftenchuongtrinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtftenchuongtrinhActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jtfmagiamgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfmagiamgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfmagiamgiaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jbtthemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtthemMouseClicked
      giamgiadao = new giamgiaDAO();
     Date utilDate = jtfngaybatdau.getDate();
     java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
     Date utilDate1 = jtfngayketthuc.getDate();
     java.sql.Date sqldate1 = new java.sql.Date(utilDate1.getTime());
    String ma = jtfmagiamgia.getText();
    String ten = jtftenchuongtrinh.getText();
    String loai = jtfloaichuongtrinh.getText();
    giamgia gg = new giamgia(loai, ten, loai, sqldate, sqldate1);
    giamgiadao.them(gg);
    Object[] row = {ma, ten, loai, sqldate, sqldate1};
    modelgiamgia.addRow(row);
        hienthi("", "", "", null, null);
    }//GEN-LAST:event_jbtthemMouseClicked

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
       int rowindex =table1.getSelectedRow();
       if(rowindex>=0)
       {
           String ma=modelgiamgia.getValueAt(rowindex, 0).toString();
           String ten = modelgiamgia.getValueAt(rowindex, 1).toString();
           String loai= modelgiamgia.getValueAt(rowindex, 2).toString();
           Date ngaybatdau= (Date)modelgiamgia.getValueAt(rowindex, 3);
           Date ngayketthuc= (Date)modelgiamgia.getValueAt(rowindex, 4);
           hienthi(ma, ten, loai, ngaybatdau, ngayketthuc);
       }
    }//GEN-LAST:event_table1MouseClicked

    private void jbtxoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtxoaMouseClicked
        int rowindex=table1.getSelectedRow();
        if(rowindex==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn xóa");
            hienthi("", "", "", null,null   );
        }
        else 
        {
            if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xác nhận", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION)
            {
                giamgiadao.xoa(jtfmagiamgia.getText());
                modelgiamgia.removeRow(rowindex);
                hienthi("", "", "", null,null   );
            }
            
        }
    }//GEN-LAST:event_jbtxoaMouseClicked

    private void jbtsuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtsuaMouseClicked
        int rowindex=table1.getSelectedRow();
        if(rowindex==0)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn dòng muốn sửa");
            hienthi("", "", "", null,null   );
        }
        else 
        {
            if(JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn sửa dòng này không?", "Xác nhận", JOptionPane.YES_OPTION)==JOptionPane.YES_OPTION)
            {
                Date utilDate = jtfngaybatdau.getDate();
                java.sql.Date sqldate = new java.sql.Date(utilDate.getTime());
                Date utilDate1 = jtfngayketthuc.getDate();
                java.sql.Date sqldate1 = new java.sql.Date(utilDate1.getTime());
                String ma = jtfmagiamgia.getText();
                String ten = jtftenchuongtrinh.getText();
                String loai = jtfloaichuongtrinh.getText();
                giamgia gg = new giamgia(loai, ten, loai, sqldate, sqldate1); 
                giamgiadao.sua(gg);
                modelgiamgia.removeRow(rowindex);
                Object[] row = {ma, ten, loai, sqldate, sqldate1};
                modelgiamgia.insertRow(rowindex, row);
                hienthi("", "", "", null, null);
            }
        }
    }//GEN-LAST:event_jbtsuaMouseClicked

    private void jbttimkimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbttimkimMouseClicked
         int[] selectedRows = table1.getSelectedRows();

    if (jtfbatdautk != null && jtfketthuctk != null) {
        Date batdautk = jtfbatdautk.getDate();
        Date ketthuctk = jtfketthuctk.getDate();

        for (int rowIndex : selectedRows) {
            Date batdau = (Date) modelgiamgia.getValueAt(rowIndex, 3);
            Date ketthuc = (Date) modelgiamgia.getValueAt(rowIndex, 4);

            int result = batdau.compareTo(batdautk);
            int result1 = ketthuc.compareTo(ketthuctk);

            if (result >= 0 && result1 <= 0) {
                System.out.println(modelgiamgia.getValueAt(rowIndex, 0));
            }
            else 
            {
                System.out.println("saidieukien");
            }
        }
    } else {
        JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu để tìm");
    }
        
    }//GEN-LAST:event_jbttimkimMouseClicked
    private void hienthi(String ma, String ten, String loai, Date batdau,Date ketthuc)
    {
        jtfmagiamgia.setText(ma);
        jtftenchuongtrinh.setText(ten);
        jtfloaichuongtrinh.setText(loai);
        jtfngaybatdau.setDate(batdau);
        jtfngayketthuc.setDate(ketthuc);     
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JButton jbtsua;
    private javax.swing.JButton jbtthem;
    private javax.swing.JButton jbttimkim;
    private javax.swing.JButton jbtxoa;
    private com.toedter.calendar.JDateChooser jtfbatdautk;
    private com.toedter.calendar.JDateChooser jtfketthuctk;
    private javax.swing.JTextField jtfloaichuongtrinh;
    private javax.swing.JTextField jtfmagiamgia;
    private com.toedter.calendar.JDateChooser jtfngaybatdau;
    private com.toedter.calendar.JDateChooser jtfngayketthuc;
    private javax.swing.JTextField jtftenchuongtrinh;
    private javax.swing.JPanel panneltoanbo;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    // End of variables declaration//GEN-END:variables

}
