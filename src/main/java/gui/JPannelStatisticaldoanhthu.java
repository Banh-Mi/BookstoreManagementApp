package gui;

import javax.swing.JFrame;
import connectDB.ConnectDB;
import dao.Doanhthudao;
import entity.DoanhThu;
import java.sql.Date;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

public class JPannelStatisticaldoanhthu extends javax.swing.JPanel {

    private DefaultTableModel modaldoanhthu;
    private Doanhthudao doanhThuDao;

    public JPannelStatisticaldoanhthu() throws SQLException {
        initComponents();
        ConnectDB.getInstance().connect();
        modaldoanhthu = (DefaultTableModel) tabledoanhthu.getModel();
    }

    public void loaddata(Date ngaybatdau, Date ngayketthuc) {
        refesh();
        int soluongdon=0;
        double doanhthu=0;
        doanhThuDao = new Doanhthudao();
        for (DoanhThu dt : doanhThuDao.getAllDoanhThu(ngaybatdau, ngayketthuc)) {
            Object[] row = {dt.getMahoadon(), dt.getTennv(), dt.getTenkh(), dt.getNgaylaphoadon(), dt.getTongtien()};
            soluongdon++;
            doanhthu+=dt.getTongtien();
            modaldoanhthu.addRow(row);
        }
        txtdoanhthu.setText(String.valueOf(doanhthu));
        txtsoluonghoadon.setText(String.valueOf(soluongdon));       
    }
    public void refesh() {
        DefaultTableModel model = (DefaultTableModel) tabledoanhthu.getModel();
        model.setRowCount(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ngayketthuc = new com.toedter.calendar.JDateChooser();
        ngaybatdau = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtdoanhthu = new javax.swing.JLabel();
        txtsoluonghoadon = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabledoanhthu = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(ngayketthuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 180, 30));
        add(ngaybatdau, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 180, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("---------------------------------");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 250, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("THỐNG KÊ DOANH THU");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 290, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("In thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton2.setText("Xem thống kê");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Đến ngày:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 90, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Đến ngày:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 90, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Doanh thu:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 100, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Tổng doanh thu");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Số lượng hóa đơn bán được:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 240, -1));

        txtdoanhthu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(txtdoanhthu, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 110, -1));

        txtsoluonghoadon.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        add(txtsoluonghoadon, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 30, -1));

        tabledoanhthu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Tên khách hàng", "Tên nhân viên", "Ngày tạo", "Tổng thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tabledoanhthu);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 690, 630));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Từ ngày:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, -1));

        jButton3.setText("Biểu đồ tổng quát");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 50));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         java.sql.Date sqldate1 = new java.sql.Date(ngaybatdau.getDate().getTime());
        java.sql.Date sqldate2 = new java.sql.Date(ngayketthuc.getDate().getTime());
        loaddata(sqldate1,sqldate2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        JFrame jf = new JFrameBieudodoanhthu();
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       


    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser ngaybatdau;
    private com.toedter.calendar.JDateChooser ngayketthuc;
    private javax.swing.JTable tabledoanhthu;
    private javax.swing.JLabel txtdoanhthu;
    private javax.swing.JLabel txtsoluonghoadon;
    // End of variables declaration//GEN-END:variables
}
