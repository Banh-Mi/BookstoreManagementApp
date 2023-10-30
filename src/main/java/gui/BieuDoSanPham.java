
package gui;

import dao.BieuDoSanPhamDAO;
import entity.SanPhamBieuDo;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.Font;
import java.awt.Color;

/**
 *
 * @author VONG VINH LOI
 */
public class BieuDoSanPham extends javax.swing.JFrame {

    private BieuDoSanPhamDAO sanPhamDao;
    public BieuDoSanPham() {
        sanPhamDao = new BieuDoSanPhamDAO();
        initComponents();
        showPieChart();
    }


   public void showPieChart() {
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("Sách", 320);
    dataset.setValue("Dụng cụ học tập", 270);
    dataset.setValue("Đồ chơi", 250);
    dataset.setValue("Văn phòng phẩm", 100);
    dataset.setValue("Quà lưu niệm", 300);

    JFreeChart pieChart = ChartFactory.createPieChart("Phần trăm sản phẩm", dataset, true, true, false);

    PiePlot plot = (PiePlot) pieChart.getPlot();
    plot.setSectionPaint("Sách", new Color(102, 255, 0));
    plot.setSectionPaint("Dụng cụ học tập", new Color(153, 153, 255));
    plot.setSectionPaint("Đồ chơi", new Color(255, 153, 255));
    plot.setSectionPaint("Văn phòng phẩm", new Color(255, 153, 102));
    plot.setSectionPaint("Quà lưu niệm", new Color(0, 102, 102));

    StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} ({2})");
    plot.setLabelFont(new Font("TimenewRoman", Font.BOLD, 12));
    plot.setLabelPaint(Color.BLACK);
    plot.setLabelGenerator(labelGenerator);

    plot.setSimpleLabels(true);
    plot.setInteriorGap(0.0);

    ChartPanel pieChartPanel = new ChartPanel(pieChart);
    panelBarChart.removeAll();
    panelBarChart.add(pieChartPanel, BorderLayout.CENTER);
    panelBarChart.validate();
}
   public void showPieChart1(int Sach, int dCHT, int doChoi, int vanPhongPham, int quaLuuNiem) {
    DefaultPieDataset dataset = new DefaultPieDataset();
    dataset.setValue("Sách", Sach);
    dataset.setValue("Dụng cụ học tập", dCHT);
    dataset.setValue("Đồ chơi", doChoi);
    dataset.setValue("Văn phòng phẩm", vanPhongPham);
    dataset.setValue("Quà lưu niệm", quaLuuNiem);

    JFreeChart pieChart = ChartFactory.createPieChart("Phần trăm sản phẩm", dataset, true, true, false);

    PiePlot plot = (PiePlot) pieChart.getPlot();
    plot.setSectionPaint("Sách", new Color(102, 255, 0));
    plot.setSectionPaint("Dụng cụ học tập", new Color(153, 153, 255));
    plot.setSectionPaint("Đồ chơi", new Color(255, 153, 255));
    plot.setSectionPaint("Văn phòng phẩm", new Color(255, 153, 102));
    plot.setSectionPaint("Quà lưu niệm", new Color(0, 102, 102));

    StandardPieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} ({2})");
    plot.setLabelFont(new Font("TimenewRoman", Font.BOLD, 12));
    plot.setLabelPaint(Color.BLACK);
    plot.setLabelGenerator(labelGenerator);

    plot.setSimpleLabels(true);
    plot.setInteriorGap(0.0);

    ChartPanel pieChartPanel = new ChartPanel(pieChart);
    panelBarChart.removeAll();
    panelBarChart.add(pieChartPanel, BorderLayout.CENTER);
    panelBarChart.validate();
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtQuaLuuNiem = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtSach = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtDCHT = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtDoChoi = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txtVanPhongPham = new javax.swing.JLabel();
        panelBarChart = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jbtThongKe = new javax.swing.JButton();
        jcbTieuChi = new javax.swing.JComboBox<>();
        JDCDenNgay = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jDCTuNgay = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("THỐNG KÊ SẢN PHẨM BIỂU ĐỒ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, 390, -1));

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setText("Quà lưu niệm");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 110, 30));

        txtQuaLuuNiem.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtQuaLuuNiem.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtQuaLuuNiem.setText("0");
        jPanel1.add(txtQuaLuuNiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 50, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 160, 180, 120));

        jPanel2.setBackground(new java.awt.Color(102, 255, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setText("Sách");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 70, 30));

        txtSach.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtSach.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtSach.setText("0");
        jPanel2.add(txtSach, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 40, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 180, 120));

        jPanel3.setBackground(new java.awt.Color(153, 153, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setText("Dụng cụ học tập");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 30));

        txtDCHT.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtDCHT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDCHT.setText("0");
        jPanel3.add(txtDCHT, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 60, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 160, 180, 120));

        jPanel4.setBackground(new java.awt.Color(255, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setText("Đồ chơi");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 70, 30));

        txtDoChoi.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtDoChoi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtDoChoi.setText("0");
        jPanel4.add(txtDoChoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 40, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 180, 120));

        jPanel5.setBackground(new java.awt.Color(255, 153, 102));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setText("Văn phòng phẩm");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 140, 30));

        txtVanPhongPham.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        txtVanPhongPham.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtVanPhongPham.setText("0");
        jPanel5.add(txtVanPhongPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 50, 30));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 160, 180, 120));
        getContentPane().add(panelBarChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 1040, 420));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("In thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 70, -1, 30));

        jbtThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtThongKe.setText("Xem thống kê");
        jbtThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThongKeMouseClicked(evt);
            }
        });
        jbtThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThongKeActionPerformed(evt);
            }
        });
        getContentPane().add(jbtThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 70, 130, 30));

        jcbTieuChi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jcbTieuChi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sản phẩm đã bán", "Top 5 sản phẩm được bán nhiều nhất", "Top 5 sản phẩm được bán ít nhất", "Top 5 sản phẩm có doanh thu cao nhất", "Top 5 sản phẩm có doanh thu thấp nhất", "Top 5 sản phẩm tồn kho nhiều nhất", "Top 5 sản phẩm tồn kho ít nhất" }));
        getContentPane().add(jcbTieuChi, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 70, 200, 30));
        getContentPane().add(JDCDenNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 70, 180, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Đến ngày:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 90, -1));
        getContentPane().add(jDCTuNgay, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 180, 30));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Từ ngày:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 90, -1));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jbtThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtThongKeActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThongKeMouseClicked
        sanPhamDao = new BieuDoSanPhamDAO();
        int doChoi=0,dungCuHocTap=0,quaLuuNiem=0,Sach=0,vanPhongPham=0;
        for(SanPhamBieuDo bdsp : sanPhamDao.getAllSanPhamBieuDo(jDCTuNgay, JDCDenNgay))
        {
            if(bdsp.getTenDanhMuc().equals("Đồ chơi"))
            {
                doChoi+=bdsp.getSoluong();
            }
            else if(bdsp.getTenDanhMuc().equals("Dụng cụ học tập"))
            {
                dungCuHocTap+=bdsp.getSoluong();
            }
            else if(bdsp.getTenDanhMuc().equals("Quà lưu niệm"))
            {
                quaLuuNiem+=bdsp.getSoluong();
            }
            else if(bdsp.getTenDanhMuc().equals("Sách"))
            {
                Sach+=bdsp.getSoluong();
            }
            else if(bdsp.getTenDanhMuc().equals("Văn phòng phẩm"))
            {
                vanPhongPham+=bdsp.getSoluong();
            }
        }
        txtSach.setText(Sach+"");
        txtDCHT.setText(dungCuHocTap+"");
        txtQuaLuuNiem.setText(quaLuuNiem+"");
        txtVanPhongPham.setText(vanPhongPham+"");
        txtDoChoi.setText(doChoi+"");
        showPieChart1(Sach, dungCuHocTap, doChoi, vanPhongPham, quaLuuNiem);
    }//GEN-LAST:event_jbtThongKeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BieuDoSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BieuDoSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BieuDoSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BieuDoSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BieuDoSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JDCDenNgay;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private com.toedter.calendar.JDateChooser jDCTuNgay;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton jbtThongKe;
    private javax.swing.JComboBox<String> jcbTieuChi;
    private javax.swing.JPanel panelBarChart;
    private javax.swing.JLabel txtDCHT;
    private javax.swing.JLabel txtDoChoi;
    private javax.swing.JLabel txtQuaLuuNiem;
    private javax.swing.JLabel txtSach;
    private javax.swing.JLabel txtVanPhongPham;
    // End of variables declaration//GEN-END:variables
}
