/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

/**
 *
 * @author VONG VINH LOI
 */
public class JFrame_ChiTietKhachHang extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_ChiTietKhachHang
     */
    public JFrame_ChiTietKhachHang() {
        setLocationRelativeTo(null);
        initComponents();
    }

    public void chuyenDoiChu1(String maKH,String hoTen,String Email,String ngaySinh,String thevip,String ngayDangKy,String sDT,String gioiTinh,String sLNDK,String sLDonHang,String sLSanPham,String tongTien)
    {
        txtMaKH.setText(maKH);
        txtHT.setText(hoTen);
        txtEmail.setText(ngaySinh);
        txtNgaySinh.setText(ngaySinh);
        txtTheThanhVien.setText(thevip);
        txtNgayDangKy.setText(ngayDangKy);
        txtSDT.setText(sDT);
        txtGT.setText(gioiTinh);
        txtDiaChi.setText(sLNDK);
        txtSLDonHang.setText(sLDonHang);
        txtSLSanPham.setText(sLSanPham);
        txtTongTien.setText(tongTien);
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lblPhone = new javax.swing.JLabel();
        lblGender2 = new javax.swing.JLabel();
        lblSoLuongHoaDonKH = new javax.swing.JLabel();
        lblSoLuongHoaDonKH1 = new javax.swing.JLabel();
        lblDoanhThuKH = new javax.swing.JLabel();
        lblDoanhThuKH1 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        txtGT = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        txtSLDonHang = new javax.swing.JTextField();
        txtSLSanPham = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        lblEmail = new javax.swing.JLabel();
        lblFullName = new javax.swing.JLabel();
        lblCustomerID = new javax.swing.JLabel();
        lblDob = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        lblGender1 = new javax.swing.JLabel();
        txtHT = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtNgayDangKy = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtTheThanhVien = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        thoat1 = new javax.swing.JButton();
        thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 255, 204));

        lblPhone.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblPhone.setText("Số điện thoại:");

        lblGender2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender2.setText("Giới tính:");

        lblSoLuongHoaDonKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDonKH.setText("Số lượng sản phẩm:");

        lblSoLuongHoaDonKH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSoLuongHoaDonKH1.setText("Số lượng đơn hàng:");

        lblDoanhThuKH.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThuKH.setText("Tổng tiền:");

        lblDoanhThuKH1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDoanhThuKH1.setText("Địa chỉ:");

        txtSDT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtGT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtGT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGTActionPerformed(evt);
            }
        });

        txtDiaChi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtDiaChi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDiaChiActionPerformed(evt);
            }
        });

        txtSLDonHang.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSLDonHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLDonHangActionPerformed(evt);
            }
        });

        txtSLSanPham.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtSLSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSLSanPhamActionPerformed(evt);
            }
        });

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSoLuongHoaDonKH1)
                            .addComponent(lblPhone)
                            .addComponent(lblGender2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblSoLuongHoaDonKH)
                    .addComponent(lblDoanhThuKH1)
                    .addComponent(lblDoanhThuKH))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLDonHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGender2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDoanhThuKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuongHoaDonKH1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLDonHang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuongHoaDonKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSLSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblDoanhThuKH, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 255, 204));

        lblEmail.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEmail.setText("Email:");

        lblFullName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFullName.setText("Họ và tên:");

        lblCustomerID.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblCustomerID.setText("Mã khách hàng:");

        lblDob.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblDob.setText("Ngày sinh:");

        lblGender.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender.setText("Thẻ TV:");

        lblGender1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblGender1.setText("Ngày đăng ký:");

        txtHT.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtHT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHTActionPerformed(evt);
            }
        });

        txtMaKH.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKHActionPerformed(evt);
            }
        });

        txtNgayDangKy.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNgayDangKy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgayDangKyActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtNgaySinh.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNgaySinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNgaySinhActionPerformed(evt);
            }
        });

        txtTheThanhVien.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtTheThanhVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTheThanhVienActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerID)
                    .addComponent(lblFullName)
                    .addComponent(lblDob)
                    .addComponent(lblEmail)
                    .addComponent(lblGender)
                    .addComponent(lblGender1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHT, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTheThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCustomerID, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDob, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTheThanhVien, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblGender1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayDangKy, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN CHI TIẾT KHÁCH HÀNG");

        thoat1.setText("In khách hàng");
        thoat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thoat1ActionPerformed(evt);
            }
        });

        thoat.setText("Thoát");
        thoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                thoatMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(thoat1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thoat1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void thoat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thoat1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_thoat1ActionPerformed

    private void thoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thoatMouseClicked
        setVisible(false);   
    }//GEN-LAST:event_thoatMouseClicked

    private void txtHTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHTActionPerformed

    private void txtMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKHActionPerformed

    private void txtNgayDangKyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgayDangKyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgayDangKyActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtNgaySinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNgaySinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNgaySinhActionPerformed

    private void txtTheThanhVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTheThanhVienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTheThanhVienActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtGTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGTActionPerformed

    private void txtDiaChiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDiaChiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDiaChiActionPerformed

    private void txtSLDonHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLDonHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLDonHangActionPerformed

    private void txtSLSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSLSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSLSanPhamActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

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
            java.util.logging.Logger.getLogger(JFrame_ChiTietKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_ChiTietKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_ChiTietKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_ChiTietKhachHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_ChiTietKhachHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblCustomerID;
    private javax.swing.JLabel lblDoanhThuKH;
    private javax.swing.JLabel lblDoanhThuKH1;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGender1;
    private javax.swing.JLabel lblGender2;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JLabel lblSoLuongHoaDonKH;
    private javax.swing.JLabel lblSoLuongHoaDonKH1;
    private javax.swing.JButton thoat;
    private javax.swing.JButton thoat1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtGT;
    private javax.swing.JTextField txtHT;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtNgayDangKy;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtSLDonHang;
    private javax.swing.JTextField txtSLSanPham;
    private javax.swing.JTextField txtTheThanhVien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
