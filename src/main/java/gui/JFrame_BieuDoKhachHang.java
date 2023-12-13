
package gui;
import connectDB.ConnectDB;
import dao.ThongKeKhachHangDAO;
import entity.DoanhThuBieuDo;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import java.awt.BorderLayout;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class JFrame_BieuDoKhachHang extends javax.swing.JFrame {
    private ThongKeKhachHangDAO khachHangDAO;
    public JFrame_BieuDoKhachHang() throws SQLException {
        initComponents();
        ConnectDB.getInstance().connect();
        showLineChart();
        if(ngonNgu==2)
        {
            ChuyenDoiNN();
        }
    }
    public void ChuyenDoiNN() {
         jLabel1.setText("Year");
         jButtonXemThongKe.setText("view statistics");
         jButtonThoat.setText("Exit");
         jLabel2.setText("Customer Statistics Chart");
     }
     public void showLineChart() {
        //create dataset for the graph
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(0, "Amount", "1");
        dataset.setValue(0, "Amount", "2");
        dataset.setValue(0, "Amount", "3");
        dataset.setValue(0, "Amount", "4");
        dataset.setValue(0, "Amount", "5");
        dataset.setValue(0, "Amount", "6");
        dataset.setValue(0, "Amount", "7");
        dataset.setValue(0, "Amount", "8");
        dataset.setValue(0, "Amount", "9");
        dataset.setValue(0, "Amount", "10");
        dataset.setValue(0, "Amount", "11");
        dataset.setValue(0, "Amount", "12");
        //create chart
        JFreeChart linechart = ChartFactory.createLineChart("Tỷ Lệ", "Tháng", "Số lượng khách mua hàng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jButtonThoat = new javax.swing.JButton();
        panelLineChart = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPane7 = new javax.swing.JPanel();
        jButtonXemThongKe = new javax.swing.JButton();
        jComboBoxnamKH = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("THỐNG KÊ KHÁCH HÀNG BIỂU ĐỒ");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jButtonThoat.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonThoat.setText("Thoát");
        jButtonThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonThoatMouseClicked(evt);
            }
        });
        jButtonThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonThoatActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonThoat, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 80, -1, 30));
        getContentPane().add(panelLineChart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 1040, 530));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Năm :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jPane7.setLayout(new java.awt.BorderLayout());
        getContentPane().add(jPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, -1, -1));

        jButtonXemThongKe.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonXemThongKe.setText("Xem thống kê");
        jButtonXemThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButtonXemThongKeMouseClicked(evt);
            }
        });
        jButtonXemThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonXemThongKeActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonXemThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, -1, -1));

        jComboBoxnamKH.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2023", "2022", "2021", "2020" }));
        jComboBoxnamKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxnamKHActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBoxnamKH, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 80, 70, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonThoatActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButtonThoatActionPerformed

    private void jButtonXemThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonXemThongKeActionPerformed
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        khachHangDAO = new ThongKeKhachHangDAO();
        int a = Integer.parseInt(jComboBoxnamKH.getSelectedItem().toString());
        System.out.println("thanh cong!!!");
        int t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0,t8=0,t9=0,t10=0,t11=0,t12=0;
        for (DoanhThuBieuDo dtbd : khachHangDAO.getKHNamBieuDo(a)) {
            System.out.println("thanh cong!!!");          
            Double ttongtien=dtbd.getTongtien();
            if (dtbd.getThang() == 1) {
                t1+=ttongtien;
                dataset.setValue(t1, "Amount", "1");
            }
            if (dtbd.getThang() == 2) {
                t2+=ttongtien;
                dataset.setValue(t2, "Amount", "2");
            }
            if (dtbd.getThang() == 3) {
                t3+=ttongtien;
                dataset.setValue( t3, "Amount", "3");
            }
            if (dtbd.getThang() == 4) {
                t4+=ttongtien;
                dataset.setValue(t4, "Amount", "4");
            }
            if (dtbd.getThang() == 5) {
                t5+=ttongtien;
                dataset.setValue(t5, "Amount", "5");
            }
            if (dtbd.getThang() == 6) {
                t6+=ttongtien;
                dataset.setValue(t6, "Amount", "6");
            }
            if (dtbd.getThang() == 7) {
                t7+=ttongtien;
                dataset.setValue(t7, "Amount", "7");
            }
            if (dtbd.getThang() == 8) {
                t8+=ttongtien;
                dataset.setValue(t8, "Amount", "8");
            }
            if (dtbd.getThang() == 9) {
                t9+=ttongtien;
                dataset.setValue(t9, "Amount", "9");
            }
            if (dtbd.getThang() == 10) {
                t10+=ttongtien;
                dataset.setValue(t10, "Amount", "10");
            }
            if (dtbd.getThang() == 11) {
                t11+=ttongtien;
                dataset.setValue(t11, "Amount", "11");
            }
            if (dtbd.getThang() == 12) {
                t12+=ttongtien;
                dataset.setValue(t12, "Amount", "12");
            }
        //create plot object
         JFreeChart linechart = ChartFactory.createLineChart("Tỷ Lệ", "Tháng", "Số lượng khách mua hàng",
                dataset, PlotOrientation.VERTICAL, false, true, false);

        //create plot object
        CategoryPlot lineCategoryPlot = linechart.getCategoryPlot();
        // lineCategoryPlot.setRangeGridlinePaint(Color.BLUE);
        lineCategoryPlot.setBackgroundPaint(Color.white);

        //create render object to change the moficy the line properties like color
        LineAndShapeRenderer lineRenderer = (LineAndShapeRenderer) lineCategoryPlot.getRenderer();
        Color lineChartColor = new Color(204, 0, 51);
        lineRenderer.setSeriesPaint(0, lineChartColor);

        //create chartPanel to display chart(graph)
        ChartPanel lineChartPanel = new ChartPanel(linechart);
        panelLineChart.removeAll();
        panelLineChart.add(lineChartPanel, BorderLayout.CENTER);
        panelLineChart.validate();
        }
        
    }//GEN-LAST:event_jButtonXemThongKeActionPerformed

    private void jComboBoxnamKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxnamKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxnamKHActionPerformed

    private void jButtonXemThongKeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonXemThongKeMouseClicked
        
    }//GEN-LAST:event_jButtonXemThongKeMouseClicked

    private void jButtonThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButtonThoatMouseClicked
        
    }//GEN-LAST:event_jButtonThoatMouseClicked



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonThoat;
    private javax.swing.JButton jButtonXemThongKe;
    private javax.swing.JComboBox<String> jComboBoxnamKH;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPane7;
    private javax.swing.JPanel panelLineChart;
    // End of variables declaration//GEN-END:variables
}
