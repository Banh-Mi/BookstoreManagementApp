package gui;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

/**
 *
 * @author ME1
 */
public class BookStoreManagementApp extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    //Tạo biến hiện ẩn password
    private boolean setShow = false;

    public BookStoreManagementApp() {
        initComponents();
        SetupSVGImage();
    }

    //Hàm set imageSVG
    private void SetupSVGImage() {
        svgClose.setSvgImage("logout.svg", 25, 25);
        svgUser.setSvgImage("user.svg", 22, 22);
        passWordShow(setShow);
    }

    //Hàm đổi icon và set lại kiểu hiển thị dữ liệu của txtpassword
    private void passWordShow(boolean check) {
        if (check) {
            svgHiden.setSvgImage("visible.svg", 25, 25);
            txtpassword.setEchoChar((char) 0);
        } else {
            svgHiden.setSvgImage("hiden.svg", 25, 25);
            txtpassword.setEchoChar((char) 8226);
        }
    }

    //Hàm set imageSVG
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        svgClose = new customLib.SVGImage();
        svgUser = new customLib.SVGImage();
        svgHiden = new customLib.SVGImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 550));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(500, 550));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(105, 194, 255));
        jLabel10.setText("BOOK");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 10, 240, 100));

        jLabel13.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 111, 255));
        jLabel13.setText("BOOK");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 100));

        jLabel14.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 194, 255));
        jLabel14.setText("BOOK");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 240, 100));

        jLabel15.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 111, 255));
        jLabel15.setText("BOOK");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 120, 240, 100));

        jLabel16.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 111, 255));
        jLabel16.setText("BOOK");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 100));

        jLabel17.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(105, 194, 255));
        jLabel17.setText("BOOK");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 230, 240, 100));

        jLabel18.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 111, 255));
        jLabel18.setText("BOOK");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 240, 100));

        jLabel19.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(105, 194, 255));
        jLabel19.setText("BOOK");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 450, 240, 100));

        jLabel20.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(105, 194, 255));
        jLabel20.setText("BOOK");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 240, 100));

        jLabel21.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 111, 255));
        jLabel21.setText("BOOK");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 340, 240, 100));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 550));

        jPanel2.setBackground(new java.awt.Color(0, 133, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(420, 550));
        jPanel2.setPreferredSize(new java.awt.Dimension(420, 550));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 40)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Login");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Hello! Let's get started");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 420, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(199, 226, 255));
        jLabel5.setText("Username");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 60, -1));

        txtusername.setBackground(new java.awt.Color(0, 133, 255));
        txtusername.setFont(txtusername.getFont().deriveFont(txtusername.getFont().getSize()+2f));
        txtusername.setForeground(new java.awt.Color(255, 255, 255));
        txtusername.setBorder(null);
        txtusername.setCaretColor(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 290, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 290, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(199, 226, 255));
        jLabel8.setText("Password");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 60, -1));

        txtpassword.setBackground(new java.awt.Color(0, 133, 255));
        txtpassword.setFont(txtpassword.getFont().deriveFont(txtpassword.getFont().getSize()+2f));
        txtpassword.setForeground(new java.awt.Color(255, 255, 255));
        txtpassword.setBorder(null);
        txtpassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 290, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 290, -1));

        jCheckBox1.setBackground(new java.awt.Color(0, 133, 255));
        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(199, 226, 255));
        jCheckBox1.setText("Remember Password");
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 150, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(199, 226, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Forget Password?");
        jLabel11.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 121, 27));

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(25, 118, 211));
        jButton1.setText("LOGIN");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 341, 40));

        svgClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgCloseMouseClicked(evt);
            }
        });
        jPanel2.add(svgClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 25, 25));
        jPanel2.add(svgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 25, 25));

        svgHiden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgHidenMouseClicked(evt);
            }
        });
        jPanel2.add(svgHiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 25, 25));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(916, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void svgCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgCloseMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_svgCloseMouseClicked

    private void svgHidenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgHidenMouseClicked
        setShow = !setShow;
        passWordShow(setShow);
    }//GEN-LAST:event_svgHidenMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatLaf.registerCustomDefaultsSource("resources.themes");

        FlatMacLightLaf.setup();

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new BookStoreManagementApp().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private customLib.SVGImage svgClose;
    private customLib.SVGImage svgHiden;
    private customLib.SVGImage svgUser;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    // End of variables declaration//GEN-END:variables
}
