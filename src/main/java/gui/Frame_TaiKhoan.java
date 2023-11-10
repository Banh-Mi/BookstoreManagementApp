/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.NhanVien;
import entity.TaiKhoan;
import static gui.GiaoDienDangNhap.ngonNgu;
import java.awt.Window;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author BanhMi88
 */
public class Frame_TaiKhoan extends javax.swing.JFrame {

    private boolean setShow = false;

    private TaiKhoanDAO taiKhoanDAO;

    public Frame_TaiKhoan(String maNhanVien, String chucVu) {
        initComponents();
        passWordShow(setShow);
        lblTenDangNhap.setText(maNhanVien);
        lblChucVu.setText(chucVu);
        if(ngonNgu==2)
        {
            ChuyenDoiNN();
        }
    }
    public void ChuyenDoiNN()
    {
        jLabel1.setText("CHANGE PASSWORD");
        jLabel5.setText("Username:");
        jLabel6.setText("Position:");
        jLabel4.setText("Old password:");
        jLabel3.setText("New password");
        jButton2.setText("Exit");
        jButton3.setText("Change Password");
        jCheckBox1.setText("Show Password");
  }

    private void passWordShow(boolean check) {
        if (check) {
            passCu.setEchoChar((char) 0);
            passMoi.setEchoChar((char) 0);
        } else {
            passCu.setEchoChar((char) 8226);
            passMoi.setEchoChar((char) 8226);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblTenDangNhap = new javax.swing.JLabel();
        passCu = new javax.swing.JPasswordField();
        jLabel3 = new javax.swing.JLabel();
        passMoi = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblChucVu = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        lblMessage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(309, 70));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐỔI MẬT KHẨU");
        jLabel1.setPreferredSize(new java.awt.Dimension(309, 50));
        jPanel1.add(jLabel1, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 634, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTenDangNhap.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(lblTenDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 230, 40));
        jPanel2.add(passCu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, 260, 40));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setText("Mật khẩu mới:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, -1, 40));
        jPanel2.add(passMoi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 260, 40));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Mật khẩu cũ:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, 40));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setText("Tên đăng nhập:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 40));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Chức vụ:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, 40));

        lblChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel2.add(lblChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, 230, 40));

        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Thoát");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 160, 50));

        jButton3.setBackground(new java.awt.Color(0, 122, 255));
        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Đổi mật khẩu");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 160, 50));

        jCheckBox1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jCheckBox1.setText("Hiện mật khẩu");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, -1, -1));

        lblMessage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jPanel2.add(lblMessage, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 266, 250, 30));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 550, 430));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jButton2MouseClicked

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        setShow = !setShow;
        passWordShow(setShow);
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        String oldPass = new String(passCu.getPassword());
        String newPass = new String(passMoi.getPassword());
        taiKhoanDAO = new TaiKhoanDAO();
        if (!newPass.trim().equals("")) {
            TaiKhoan taiKhoan = taiKhoanDAO.checkAccount(lblTenDangNhap.getText(), DigestUtils.md5Hex(oldPass).toUpperCase());
            if (taiKhoan == null) {
                lblMessage.setText("Mật khẩu cũ không đúng!");
            } else {
                if (taiKhoanDAO.doiMatKhau(lblTenDangNhap.getText(), newPass)) {
                    int result = JOptionPane.showConfirmDialog(null, "Đổi mật khẩu thành công", "Thông báo", JOptionPane.DEFAULT_OPTION);
                    if (result == JOptionPane.OK_OPTION) {
                        Window[] windows = Window.getWindows();
                        for (Window window : windows) {
                            window.dispose();
                        }
                        try {
                            new GiaoDienDangNhap().setVisible(true);
                        } catch (SQLException ex) {
                            Logger.getLogger(Frame_TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Đổi mật khẩu không thành công");
                }

            }
        } else {
            lblMessage.setText("Không được để trống mật khẩu mới");
        }

    }//GEN-LAST:event_jButton3MouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblChucVu;
    private javax.swing.JLabel lblMessage;
    private javax.swing.JLabel lblTenDangNhap;
    private javax.swing.JPasswordField passCu;
    private javax.swing.JPasswordField passMoi;
    // End of variables declaration//GEN-END:variables
}
