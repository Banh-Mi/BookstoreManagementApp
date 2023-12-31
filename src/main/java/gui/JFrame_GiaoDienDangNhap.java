package gui;

import util.LoginController;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import connectDB.ConnectDB;
import java.awt.event.ItemEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;


public class JFrame_GiaoDienDangNhap extends javax.swing.JFrame {

    private boolean setShow = false;
    public static int ngonNgu;
    public JFrame_GiaoDienDangNhap() throws SQLException {
        ConnectDB.getInstance().connect();
        initComponents();
        SetupSVGImage();
        LoginController controller = new LoginController(this, btnLogin, txtUserName, txtPassword, jbNotification);
        controller.setEvent();
    }

    //Hàm set imageSVG
    private void SetupSVGImage() {
        svgClose.setSvgImage("close.svg", 25, 25);
        svgUser.setSvgImage("user.svg", 22, 22);
        passWordShow(setShow);
    }

    //Hàm đổi icon và set lại kiểu hiển thị dữ liệu của txtpassword
    private void passWordShow(boolean check) {
        if (check) {
            svgHiden.setSvgImage("visible.svg", 25, 25);
            txtPassword.setEchoChar((char) 0);
        } else {
            svgHiden.setSvgImage("hiden.svg", 25, 25);
            txtPassword.setEchoChar((char) 8226);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpLogin = new javax.swing.JPanel();
        jpLeft = new javax.swing.JPanel();
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
        jpRight = new javax.swing.JPanel();
        jbLogin = new javax.swing.JLabel();
        jbSubtitle = new javax.swing.JLabel();
        jbUserName = new javax.swing.JLabel();
        txtUserName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jbPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        btnLogin = new javax.swing.JButton();
        svgClose = new util.SVGImage();
        svgUser = new util.SVGImage();
        svgHiden = new util.SVGImage();
        jbNotification = new javax.swing.JLabel();
        comboxngonngu = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(920, 550));
        setUndecorated(true);

        jpLogin.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpLeft.setBackground(new java.awt.Color(255, 255, 255));
        jpLeft.setPreferredSize(new java.awt.Dimension(500, 550));
        jpLeft.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(105, 194, 255));
        jLabel10.setText("BOOK");
        jpLeft.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 10, 240, 100));

        jLabel13.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 111, 255));
        jLabel13.setText("BOOK");
        jpLeft.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 240, 100));

        jLabel14.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(105, 194, 255));
        jLabel14.setText("BOOK");
        jpLeft.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 240, 100));

        jLabel15.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 111, 255));
        jLabel15.setText("BOOK");
        jpLeft.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 120, 240, 100));

        jLabel16.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 111, 255));
        jLabel16.setText("BOOK");
        jpLeft.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 240, 100));

        jLabel17.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(105, 194, 255));
        jLabel17.setText("BOOK");
        jpLeft.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 230, 240, 100));

        jLabel18.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 111, 255));
        jLabel18.setText("BOOK");
        jpLeft.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 240, 100));

        jLabel19.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(105, 194, 255));
        jLabel19.setText("BOOK");
        jpLeft.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 450, 240, 100));

        jLabel20.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(105, 194, 255));
        jLabel20.setText("BOOK");
        jpLeft.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 240, 100));

        jLabel21.setFont(new java.awt.Font("Nunito ExtraBold", 0, 70)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(0, 111, 255));
        jLabel21.setText("BOOK");
        jpLeft.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(265, 340, 240, 100));

        jpLogin.add(jpLeft, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 550));

        jpRight.setBackground(new java.awt.Color(0, 133, 255));
        jpRight.setMinimumSize(new java.awt.Dimension(420, 550));
        jpRight.setPreferredSize(new java.awt.Dimension(420, 550));
        jpRight.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbLogin.setFont(new java.awt.Font("Segoe UI", 0, 45)); // NOI18N
        jbLogin.setForeground(new java.awt.Color(255, 255, 255));
        jbLogin.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbLogin.setText("Đăng nhập");
        jpRight.add(jbLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 420, 60));

        jbSubtitle.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        jbSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jbSubtitle.setText("Xin chào! Đăng nhập để bắt đầu");
        jpRight.add(jbSubtitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 420, 30));

        jbUserName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbUserName.setForeground(new java.awt.Color(199, 226, 255));
        jbUserName.setText("Tên đăng nhập");
        jpRight.add(jbUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 110, -1));

        txtUserName.setBackground(new java.awt.Color(0, 133, 255));
        txtUserName.setFont(txtUserName.getFont().deriveFont(txtUserName.getFont().getSize()+2f));
        txtUserName.setForeground(new java.awt.Color(255, 255, 255));
        txtUserName.setText("NV001");
        txtUserName.setBorder(null);
        txtUserName.setCaretColor(new java.awt.Color(255, 255, 255));
        txtUserName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUserNameActionPerformed(evt);
            }
        });
        jpRight.add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 290, 30));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jpRight.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 290, -1));

        jbPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbPassword.setForeground(new java.awt.Color(199, 226, 255));
        jbPassword.setText("Mật khẩu");
        jpRight.add(jbPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 110, -1));

        txtPassword.setBackground(new java.awt.Color(0, 133, 255));
        txtPassword.setFont(txtPassword.getFont().deriveFont(txtPassword.getFont().getSize()+2f));
        txtPassword.setForeground(new java.awt.Color(255, 255, 255));
        txtPassword.setText("1111");
        txtPassword.setBorder(null);
        txtPassword.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        jpRight.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 290, 30));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jpRight.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 290, -1));

        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(new java.awt.Color(25, 118, 211));
        btnLogin.setText("ĐĂNG NHẬP");
        btnLogin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jpRight.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 410, 341, 40));

        svgClose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgCloseMouseClicked(evt);
            }
        });
        jpRight.add(svgClose, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 25, 25));
        jpRight.add(svgUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, 25, 25));

        svgHiden.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgHidenMouseClicked(evt);
            }
        });
        jpRight.add(svgHiden, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, 25, 25));

        jbNotification.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jbNotification.setForeground(new java.awt.Color(255, 255, 255));
        jpRight.add(jbNotification, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 365, 340, 30));

        comboxngonngu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiếng Việt", "English"}));
        comboxngonngu.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboxngonnguItemStateChanged(evt);
            }
        });
        comboxngonngu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboxngonnguMouseClicked(evt);
            }
        });
        jpRight.add(comboxngonngu, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 470, -1, -1));

        jpLogin.add(jpRight, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 420, 550));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(916, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void svgCloseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgCloseMouseClicked
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_svgCloseMouseClicked

    private void svgHidenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgHidenMouseClicked
        setShow = !setShow;
        passWordShow(setShow);
    }//GEN-LAST:event_svgHidenMouseClicked

    private void comboxngonnguMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboxngonnguMouseClicked
        
    }//GEN-LAST:event_comboxngonnguMouseClicked

    private void comboxngonnguItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboxngonnguItemStateChanged
       if (evt.getStateChange() == ItemEvent.SELECTED) {
           comboxngonngu.setSelectedItem(comboxngonngu.getSelectedItem());
    }
       if(comboxngonngu.getSelectedItem().equals("English"))
       {
           ngonNgu=2;
       }
       else
       {
           ngonNgu=1;
       }
    }//GEN-LAST:event_comboxngonnguItemStateChanged

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtUserNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUserNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUserNameActionPerformed
    public static int getngonngu()
    {
        return ngonNgu;
    }
    public static void main(String args[]) {
    
        FlatLaf.registerCustomDefaultsSource("resources.themes");

        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 5);
        java.awt.EventQueue.invokeLater(() -> {
            try {
                new JFrame_GiaoDienDangNhap().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(JFrame_GiaoDienDangNhap.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    public javax.swing.JComboBox<String> comboxngonngu;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel jbLogin;
    private javax.swing.JLabel jbNotification;
    private javax.swing.JLabel jbPassword;
    private javax.swing.JLabel jbSubtitle;
    private javax.swing.JLabel jbUserName;
    private javax.swing.JPanel jpLeft;
    private javax.swing.JPanel jpLogin;
    private javax.swing.JPanel jpRight;
    private util.SVGImage svgClose;
    private util.SVGImage svgHiden;
    private util.SVGImage svgUser;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUserName;
    // End of variables declaration//GEN-END:variables
}
