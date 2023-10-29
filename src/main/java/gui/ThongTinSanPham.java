package gui;

import dao.SanPhamDAO;
import entity.SanPham;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import org.imgscalr.Scalr;
import util.JPanelRounded;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ThongTinSanPham extends javax.swing.JFrame {

    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private String maSanPham;

    public ThongTinSanPham(String maSanPham) {
        initComponents();
        svgAdd.setSvgImage("add.svg", 25, 25);
        svgCancel.setSvgImage("delete.svg", 25, 25);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.maSanPham = maSanPham;
        loadData();
    }

    public void loadData() {
        SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(maSanPham));
        lbl_ProductImage.setIcon(createImageIcon(sanPham.getHinhAnh(), lbl_ProductImage));
        lbl_productName.setText(sanPham.getTenSanPham());
        lbl_quantityValue.setText(sanPham.getSoLuong() + "");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        lbl_priceValue.setText(decimalFormat.format(sanPham.getGia()));
        lbl_descriptionValue.setText(sanPham.getMoTa());
    }

    public ImageIcon createImageIcon(String url, JLabel label) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            return null;
        }

        // Scale ảnh để vừa với JLabel
        BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, label.getWidth(), label.getHeight());
        return new ImageIcon(scaledImage);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_productName = new javax.swing.JLabel();
        lbl_inputQuantity = new javax.swing.JLabel();
        lbl_price = new javax.swing.JLabel();
        jpCancel = new util.JPanelRounded();
        lblCancel = new javax.swing.JLabel();
        svgCancel = new util.SVGImage();
        jpAdd = new util.JPanelRounded();
        lblAdd = new javax.swing.JLabel();
        svgAdd = new util.SVGImage();
        lbl_description = new javax.swing.JLabel();
        txt_quantity = new javax.swing.JTextField();
        lbl_quantity = new javax.swing.JLabel();
        lbl_descriptionValue = new javax.swing.JLabel();
        lbl_quantityValue = new javax.swing.JLabel();
        lbl_priceUnit = new javax.swing.JLabel();
        lbl_priceValue = new javax.swing.JLabel();
        pnl_ProductImage = new javax.swing.JPanel();
        lbl_ProductImage = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbl_productName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_productName.setText("Đệ nhất kiếm tiền");
        jPanel1.add(lbl_productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 40));

        lbl_inputQuantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_inputQuantity.setText("Nhập số lượng:");
        jPanel1.add(lbl_inputQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, 30));

        lbl_price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_price.setText("Đơn giá:");
        jPanel1.add(lbl_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jpCancel.setBackground(new java.awt.Color(255, 255, 255));
        jpCancel.setRoundedBottomLeft(10);
        jpCancel.setRoundedBottomRight(10);
        jpCancel.setRoundedTopLeft(10);
        jpCancel.setRoundedTopRight(10);
        jpCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpCancelMouseClicked(evt);
            }
        });
        jpCancel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCancel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCancel.setText("Hủy");
        jpCancel.add(lblCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgCancel.setText(" ");
        jpCancel.add(svgCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel1.add(jpCancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        jpAdd.setBackground(new java.awt.Color(255, 255, 255));
        jpAdd.setRoundedBottomLeft(10);
        jpAdd.setRoundedBottomRight(10);
        jpAdd.setRoundedTopLeft(10);
        jpAdd.setRoundedTopRight(10);
        jpAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpAddMouseClicked(evt);
            }
        });
        jpAdd.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAdd.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblAdd.setText("Thêm");
        jpAdd.add(lblAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgAdd.setText(" ");
        jpAdd.add(svgAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        jPanel1.add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, -1, -1));

        lbl_description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_description.setText("Mô tả:");
        jPanel1.add(lbl_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        txt_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_quantity.setText("1");
        txt_quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_quantityActionPerformed(evt);
            }
        });
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 190, 30));

        lbl_quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_quantity.setText("Số lượng tồn:");
        jPanel1.add(lbl_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        lbl_descriptionValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_descriptionValue.setText("Có làm thì mới có ăn");
        jPanel1.add(lbl_descriptionValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 190, -1));

        lbl_quantityValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_quantityValue.setText("69");
        jPanel1.add(lbl_quantityValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 100, -1));

        lbl_priceUnit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_priceUnit.setText("VNĐ");
        jPanel1.add(lbl_priceUnit, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, -1));

        lbl_priceValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_priceValue.setText("800.000");
        jPanel1.add(lbl_priceValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 110, 120, -1));

        pnl_ProductImage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_ProductImage.setLayout(new java.awt.BorderLayout());

        lbl_ProductImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnl_ProductImage.add(lbl_ProductImage, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(pnl_ProductImage, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnl_ProductImage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpCancelMouseClicked
        this.setVisible(false);
    }//GEN-LAST:event_jpCancelMouseClicked

    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked

    }//GEN-LAST:event_jpAddMouseClicked

    private void txt_quantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_quantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_quantityActionPerformed

//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new ThongTinSanPham().setVisible(true);
//            }
//        });
//    }
    public JPanelRounded getJpAdd() {
        return jpAdd;
    }

    public JTextField getTxt_quantity() {
        return txt_quantity;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpCancel;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lblCancel;
    private javax.swing.JLabel lbl_ProductImage;
    private javax.swing.JLabel lbl_description;
    private javax.swing.JLabel lbl_descriptionValue;
    private javax.swing.JLabel lbl_inputQuantity;
    private javax.swing.JLabel lbl_price;
    private javax.swing.JLabel lbl_priceUnit;
    private javax.swing.JLabel lbl_priceValue;
    private javax.swing.JLabel lbl_productName;
    private javax.swing.JLabel lbl_quantity;
    private javax.swing.JLabel lbl_quantityValue;
    private javax.swing.JPanel pnl_ProductImage;
    private util.SVGImage svgAdd;
    private util.SVGImage svgCancel;
    private javax.swing.JTextField txt_quantity;
    // End of variables declaration//GEN-END:variables
}
