
package gui;

import dao.ThongKeDoanhThuDAO;
import entity.DoanhThuBieuDo;
import java.awt.BorderLayout;
import java.awt.Color;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import connectDB.ConnectDB;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
/**
 *
 * @author VONG VINH LOI
 */
public class JFrame_BieuDoDoanhThu extends javax.swing.JFrame {

    private ThongKeDoanhThuDAO dtbddao;

    public JFrame_BieuDoDoanhThu() throws SQLException {
        initComponents();
        ConnectDB.getInstance().connect();
        showBarChart();
        if(ngonNgu==2)
        {
            ChuyenDoiNN();
        }
    }
     public void ChuyenDoiNN() {
         jLabel1.setText("Year");
         jButton1.setText("view statistics");
         jButton3.setText("Exit");
         jLabel2.setText("Revenue Statistics Chart");
     }

    public void showBarChart() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(0, "Amount", "Tháng 1");
        dataset.setValue(0, "Amount", "Tháng 2");
        dataset.setValue(0, "Amount", "Tháng 3");
        dataset.setValue(0, "Amount", "Tháng 4");
        dataset.setValue(0, "Amount", "Tháng 4");
        dataset.setValue(0, "Amount", "Tháng 5");
        dataset.setValue(0, "Amount", "Tháng 6");
        dataset.setValue(0, "Amount", "Tháng 7");
        dataset.setValue(0, "Amount", "Tháng 8");
        dataset.setValue(0, "Amount", "Tháng 9");
        dataset.setValue(0, "Amount", "Tháng 10");
        dataset.setValue(0, "Amount", "Tháng 11");
        dataset.setValue(0, "Amount", "Tháng 12");
        JFreeChart chart = ChartFactory.createBarChart("Tỷ Lệ", "Tháng", "Số Lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPane7.removeAll();
        jPane7.add(barpChartPanel, BorderLayout.CENTER);
        jPane7.validate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPane7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBoxnam = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("THỐNG KÊ DOANH THU BIỂU ĐỒ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, -1));

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Xem thống kê");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, 30));

        jPane7.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 1030, 510));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Năm :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 70, 30));

        jComboBoxnam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021", "2020"}));
        jComboBoxnam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxnamActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxnam, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 70, 30));

        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton3.setText("Thoát");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 80, -1, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dtbddao = new ThongKeDoanhThuDAO();
        int a = Integer.parseInt(jComboBoxnam.getSelectedItem().toString());
        for (DoanhThuBieuDo dtbd : dtbddao.getAllDoanhThuBieuDo(a)) {
            if (dtbd.getThang() == 1) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 1");
            }
            if (dtbd.getThang() == 2) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 2");
            }
            if (dtbd.getThang() == 3) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 3");
            }
            if (dtbd.getThang() == 4) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 4");
            }
            if (dtbd.getThang() == 5) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 5");
            }
            if (dtbd.getThang() == 6) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 6");
            }
            if (dtbd.getThang() == 7) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 7");
            }
            if (dtbd.getThang() == 8) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 8");
            }
            if (dtbd.getThang() == 9) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 9");
            }
            if (dtbd.getThang() == 10) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 10");
            }
            if (dtbd.getThang() == 11) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 11");
            }
            if (dtbd.getThang() == 12) {
                dataset.setValue(dtbd.getTongtien(), "Amount", "Tháng 12");
            }

        }
        JFreeChart chart = ChartFactory.createBarChart("Tỷ Lệ", "Tháng", "Số Lượng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        CategoryPlot categoryPlot = chart.getCategoryPlot();
        //categoryPlot.setRangeGridlinePaint(Color.BLUE);
        categoryPlot.setBackgroundPaint(Color.WHITE);
        BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
        Color clr3 = new Color(204, 0, 51);
        renderer.setSeriesPaint(0, clr3);

        ChartPanel barpChartPanel = new ChartPanel(chart);
        jPane7.removeAll();
        jPane7.add(barpChartPanel, BorderLayout.CENTER);
        jPane7.validate();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBoxnamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxnamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxnamActionPerformed

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBoxnam;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPane7;
    // End of variables declaration//GEN-END:variables
}
