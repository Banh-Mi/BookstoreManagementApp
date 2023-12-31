/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
/**
 *
 * @author VONG VINH LOI
 */
public class JFrame_ChiTietSanPham extends javax.swing.JFrame {

    /**
     * Creates new form JFrame_ChiTietSanPham
     */
    public JFrame_ChiTietSanPham() {
        setResizable(false);
        setLocationRelativeTo(null);
        initComponents();
        if(ngonNgu==2)
        {
            chuyenNN();
        }
    }
    public void chuyenNN()
    {
        lbl_ProductId.setText("Product ID:");
        lbl_ProductName.setText("Product Name:");
        lbl_Supplier.setText("Supplier:");
        lbl_Author.setText("Author:");
        lbl_Publisher.setText("Publisher:");
        lbl_Unit.setText("Unit:");
        lbl_PageCount.setText("PageCount:");
        lbl_Category.setText("Category:");
        lbl_Quantity.setText("Quantity:");
        lbl_Price1.setText("Pricel");
        lbl_Price2.setText("Total amount:");
        lbl_PublishingYear.setText("Publishing Year:");
        thoat.setText("Exit");
        jLabel1.setText("DETAILED PRODUCT INFORMATION");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_PageCount = new javax.swing.JLabel();
        txtSoTrang = new javax.swing.JTextField();
        lbl_Category = new javax.swing.JLabel();
        txtDanhMuc = new javax.swing.JTextField();
        lbl_Quantity = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        lbl_Price1 = new javax.swing.JLabel();
        txtGia = new javax.swing.JTextField();
        lbl_Price2 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        lbl_PublishingYear = new javax.swing.JLabel();
        txtNamXuatBan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbl_ProductId = new javax.swing.JLabel();
        txtmaSanPham = new javax.swing.JTextField();
        lbl_ProductName = new javax.swing.JLabel();
        txtTenSanPham = new javax.swing.JTextField();
        lbl_Supplier = new javax.swing.JLabel();
        txtNhaCungCap = new javax.swing.JTextField();
        lbl_Author = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        lbl_Publisher = new javax.swing.JLabel();
        txtNhaXuatBan = new javax.swing.JTextField();
        lbl_Unit = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        thoat = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setForeground(new java.awt.Color(0, 255, 204));

        lbl_PageCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PageCount.setText("Số trang:");

        txtSoTrang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoTrangActionPerformed(evt);
            }
        });

        lbl_Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Category.setText("Danh mục:");

        txtDanhMuc.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDanhMucActionPerformed(evt);
            }
        });

        lbl_Quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Quantity.setText("Số lượng:");

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        lbl_Price1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Price1.setText("Giá:");

        txtGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtGiaActionPerformed(evt);
            }
        });

        lbl_Price2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Price2.setText("Tổng tiền:");

        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTienActionPerformed(evt);
            }
        });

        lbl_PublishingYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PublishingYear.setText("Năm xuất  bản:");

        txtNamXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNamXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamXuatBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbl_Price2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_PublishingYear, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lbl_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbl_Price1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lbl_PageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(10, 10, 10))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(lbl_PageCount, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(lbl_Category, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(lbl_Price1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_Price2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lbl_PublishingYear, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(txtDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(68, 68, 68)
                                .addComponent(txtNamXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50))))))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 255, 204));

        lbl_ProductId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ProductId.setText("Mã sản phẩm:");

        txtmaSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtmaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaSanPhamActionPerformed(evt);
            }
        });

        lbl_ProductName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ProductName.setText("Tên sản phẩm:");

        txtTenSanPham.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTenSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenSanPhamActionPerformed(evt);
            }
        });

        lbl_Supplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Supplier.setText("Nhà cung cấp:");

        txtNhaCungCap.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhaCungCapActionPerformed(evt);
            }
        });

        lbl_Author.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Author.setText("Tác giả:");

        txtTacGia.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTacGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTacGiaActionPerformed(evt);
            }
        });

        lbl_Publisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Publisher.setText("Nhà xuất bản:");

        txtNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtNhaXuatBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNhaXuatBanActionPerformed(evt);
            }
        });

        lbl_Unit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Unit.setText("Đơn vị tính:");

        txtDonViTinh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtDonViTinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonViTinhActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_Author, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addComponent(lbl_ProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtmaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ProductId, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmaSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_ProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Supplier, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Author, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Publisher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Unit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("THÔNG TIN CHI TIẾT SẢN PHẨM");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(196, 196, 196)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(thoat, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaSanPhamActionPerformed

    private void txtTenSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenSanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenSanPhamActionPerformed

    private void txtNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhaCungCapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhaCungCapActionPerformed

    private void txtTacGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTacGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTacGiaActionPerformed

    private void txtNhaXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNhaXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNhaXuatBanActionPerformed

    private void txtDonViTinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonViTinhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonViTinhActionPerformed

    private void txtDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDanhMucActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDanhMucActionPerformed

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed

    private void txtGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtGiaActionPerformed

    private void txtNamXuatBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamXuatBanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamXuatBanActionPerformed

    private void txtTongTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTienActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTienActionPerformed

    private void txtSoTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoTrangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoTrangActionPerformed

    private void thoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_thoatMouseClicked
        setVisible(false);
    }//GEN-LAST:event_thoatMouseClicked

  
    public void chuyenDoiChu(String maSP,String tenSP,String nhaCC,String tacGia,String nhaXuatBan,String donViTinh,String danhMuc,String soLuong,String gia,String tongTien,String soTrang,String namXuatBan)
    {
        txtmaSanPham.setText(maSP);
        txtTenSanPham.setText(tenSP);
        txtNhaCungCap.setText(nhaCC);
        txtTacGia.setText(tacGia);
        txtNhaXuatBan.setText(nhaXuatBan);
        txtDonViTinh.setText(donViTinh);
        txtDanhMuc.setText(danhMuc);
        txtSoLuong.setText(soLuong);
        txtGia.setText(gia);
        txtTongTien.setText(tongTien);
        txtSoTrang.setText(soTrang);
        txtNamXuatBan.setText(namXuatBan);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Author;
    private javax.swing.JLabel lbl_Category;
    private javax.swing.JLabel lbl_PageCount;
    private javax.swing.JLabel lbl_Price1;
    private javax.swing.JLabel lbl_Price2;
    private javax.swing.JLabel lbl_ProductId;
    private javax.swing.JLabel lbl_ProductName;
    private javax.swing.JLabel lbl_Publisher;
    private javax.swing.JLabel lbl_PublishingYear;
    private javax.swing.JLabel lbl_Quantity;
    private javax.swing.JLabel lbl_Supplier;
    private javax.swing.JLabel lbl_Unit;
    private javax.swing.JButton thoat;
    private javax.swing.JTextField txtDanhMuc;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNhaCungCap;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtSoTrang;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenSanPham;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtmaSanPham;
    // End of variables declaration//GEN-END:variables
}
