package gui;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ThanhToanMoMo extends javax.swing.JFrame {

    private boolean confirm = false;
    
    public ThanhToanMoMo() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbl_payMoney = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_confirm = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setForeground(new java.awt.Color(204, 255, 204));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/light/amount@2x1.png"))); // NOI18N
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 40, 40));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setText("Số tiền chuyển:");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, -1, 30));

        lbl_payMoney.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_payMoney.setText("10.0000");
        jPanel2.add(lbl_payMoney, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 410, 150, 40));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("QUÉT MÃ QR");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, 130, 36));

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/light/momo.png"))); // NOI18N
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 320, 330));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 420, 470));

        btn_cancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_cancel.setText("Hủy");
        btn_cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cancelMouseClicked(evt);
            }
        });
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        getContentPane().add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 520, 80, 30));

        btn_confirm.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_confirm.setText("Xác nhận");
        btn_confirm.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_confirmMouseClicked(evt);
            }
        });
        btn_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_confirmActionPerformed(evt);
            }
        });
        getContentPane().add(btn_confirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 520, 100, 30));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 30, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cancelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_cancelMouseClicked

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        this.confirm = false;
        setVisible(false);
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_confirmMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_confirmMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_confirmMouseClicked

    private void btn_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_confirmActionPerformed
        this.confirm = true;
        setVisible(false);
    }//GEN-LAST:event_btn_confirmActionPerformed

    public boolean isConfirm() {
        return confirm;
    }

    public JButton getBtn_confirm() {
        return btn_confirm;
    }

    public JLabel getLbl_payMoney() {
        return lbl_payMoney;
    }
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_confirm;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_payMoney;
    // End of variables declaration//GEN-END:variables
}
