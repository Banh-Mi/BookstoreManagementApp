package gui;

import dao.NhaCungCapDAO;
import dao.SanPhamDAO;
import entity.NhaCungCap;
import entity.SanPham;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.imgscalr.Scalr;
import org.jfree.ui.DateCellRenderer;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JPanel_SanPham extends javax.swing.JPanel {

    private DefaultTableModel modelSanPham;
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private NhaCungCapDAO nhaCungCapDAO = new NhaCungCapDAO();
    private String selectedImagePath;
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public JPanel_SanPham() {
        initComponents();
        svgAdd.setSvgImage("add.svg", 30, 30);
        svgEdit.setSvgImage("edit.svg", 25, 25);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgRefresh.setSvgImage("refresh.svg", 25, 25);
        modelSanPham = (DefaultTableModel) tbl_ListProduct.getModel();
        loadData();

    }

    public void loadData() {
        ArrayList<SanPham> danhSachSanPham = sanPhamDAO.selectAll();
        addDataToTable(danhSachSanPham);

        // Thiết lập giá trị của cột giá nằm bên phải
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl_ListProduct.getColumnModel().getColumn(10).setCellRenderer(rightRenderer);

        cb_Category.removeAllItems();
        cb_Category.addItem("Sách");
        cb_Category.addItem("Dụng cụ học tập");
        cb_Category.addItem("Văn phòng phẩm");
        cb_Category.addItem("Đồ chơi");
        cb_Category.addItem("Quà lưu niệm");
        cb_Category.setSelectedIndex(-1);

        cb_Supplier.removeAllItems();
        for (NhaCungCap nhaCungCap : nhaCungCapDAO.getAllNhaCungCap()) {
            cb_Supplier.addItem(nhaCungCap.getTenNhaCC());
        }
        cb_Supplier.setSelectedIndex(-1);

        txt_ProductId.setEnabled(false);

    }

    public void addDataToTable(ArrayList<SanPham> danhSachSanPham) {
        modelSanPham.setRowCount(0);
        for (SanPham sanPham : danhSachSanPham) {
            if (sanPham.isTrangThai()) {
                String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), sanPham.getDanhMuc(), (nhaCungCapDAO.searchNhaCungCap(sanPham.getMaNhaCC())).getTenNhaCC(), sanPham.getDonViTinh(), sanPham.getTacGia(), sanPham.getNhaXuatBan(), sanPham.getNamXuatBan() == 0 ? "" : sanPham.getNamXuatBan() + "", sanPham.getSoTrang() == 0 ? "" : sanPham.getSoTrang() + "", sanPham.getSoLuong() + "", nf.format(sanPham.getGia()), sanPham.getHinhAnh(), sanPham.getMoTa()};
                modelSanPham.addRow(data);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        pnl_ProductInfomation = new javax.swing.JPanel();
        lbl_Category = new javax.swing.JLabel();
        txt_ProductId = new javax.swing.JTextField();
        lbl_ProductId = new javax.swing.JLabel();
        cb_Category = new javax.swing.JComboBox<>();
        lbl_ProductName = new javax.swing.JLabel();
        txt_ProductName = new javax.swing.JTextField();
        lbl_Supplier = new javax.swing.JLabel();
        lbl_Quantity = new javax.swing.JLabel();
        txt_Quantity = new javax.swing.JTextField();
        txt_Price = new javax.swing.JTextField();
        lbl_Price = new javax.swing.JLabel();
        lbl_Author = new javax.swing.JLabel();
        txt_Author = new javax.swing.JTextField();
        txt_Publisher = new javax.swing.JTextField();
        lbl_Publisher = new javax.swing.JLabel();
        txt_PublishingYear = new javax.swing.JTextField();
        lbl_PublishingYear = new javax.swing.JLabel();
        txt_PageCount = new javax.swing.JTextField();
        lbl_PageCount = new javax.swing.JLabel();
        pnl_ProductImage = new javax.swing.JPanel();
        lbl_ProductImage = new javax.swing.JLabel();
        btn_chooseImage = new javax.swing.JButton();
        lbl_Unit = new javax.swing.JLabel();
        txt_Unit = new javax.swing.JTextField();
        lbl_Description = new javax.swing.JLabel();
        scr_Description = new javax.swing.JScrollPane();
        txa_Description = new javax.swing.JTextArea();
        cb_Supplier = new javax.swing.JComboBox<>();
        pnl_ProductInfomation1 = new javax.swing.JPanel();
        scr_LisrProduct = new javax.swing.JScrollPane();
        tbl_ListProduct = new javax.swing.JTable();
        jpAdd = new util.JPanelRounded();
        lblAdd = new javax.swing.JLabel();
        svgAdd = new util.SVGImage();
        jpEdit = new util.JPanelRounded();
        jbEdit = new javax.swing.JLabel();
        svgEdit = new util.SVGImage();
        jpDelete = new util.JPanelRounded();
        jbDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        jpRefresh = new util.JPanelRounded();
        jbRefresh = new javax.swing.JLabel();
        svgRefresh = new util.SVGImage();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_ProductInfomation.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnl_ProductInfomation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_Category.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Category.setText("Danh mục:");
        pnl_ProductInfomation.add(lbl_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 80, 30));

        txt_ProductId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_ProductId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ProductIdActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_ProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 130, 30));

        lbl_ProductId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ProductId.setText("Mã sản phẩm:");
        pnl_ProductInfomation.add(lbl_ProductId, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 100, 30));

        cb_Category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_Category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_CategoryItemStateChanged(evt);
            }
        });
        cb_Category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_CategoryActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(cb_Category, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 180, 30));

        lbl_ProductName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_ProductName.setText("Tên sản phẩm:");
        pnl_ProductInfomation.add(lbl_ProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 100, 30));

        txt_ProductName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_ProductName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_ProductNameActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_ProductName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 350, 30));

        lbl_Supplier.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Supplier.setText("Nhà cung cấp:");
        pnl_ProductInfomation.add(lbl_Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, 100, 30));

        lbl_Quantity.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Quantity.setText("Số lượng:");
        pnl_ProductInfomation.add(lbl_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 40, 70, 30));

        txt_Quantity.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Quantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_QuantityActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_Quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 40, 80, 30));

        txt_Price.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Price.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PriceActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 140, 100, 30));

        lbl_Price.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Price.setText("Giá:");
        pnl_ProductInfomation.add(lbl_Price, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 140, 40, 30));

        lbl_Author.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Author.setText("Tác giả:");
        pnl_ProductInfomation.add(lbl_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 30));

        txt_Author.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Author.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AuthorActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_Author, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 180, 30));

        txt_Publisher.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Publisher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PublisherActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_Publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 230, 30));

        lbl_Publisher.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Publisher.setText("Nhà xuất bản:");
        pnl_ProductInfomation.add(lbl_Publisher, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, 100, 30));

        txt_PublishingYear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_PublishingYear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PublishingYearActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_PublishingYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, 60, 30));

        lbl_PublishingYear.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PublishingYear.setText("Năm xuất  bản:");
        pnl_ProductInfomation.add(lbl_PublishingYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 190, 110, 30));

        txt_PageCount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_PageCount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PageCountActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_PageCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 240, 50, 30));

        lbl_PageCount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_PageCount.setText("Số trang:");
        pnl_ProductInfomation.add(lbl_PageCount, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, 70, 30));

        pnl_ProductImage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ảnh", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_ProductImage.setLayout(new java.awt.BorderLayout());

        lbl_ProductImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pnl_ProductImage.add(lbl_ProductImage, java.awt.BorderLayout.CENTER);

        pnl_ProductInfomation.add(pnl_ProductImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 210, 270));

        btn_chooseImage.setText("Chọn");
        btn_chooseImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chooseImageActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(btn_chooseImage, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 300, -1, -1));

        lbl_Unit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Unit.setText("Đơn vị tính:");
        pnl_ProductInfomation.add(lbl_Unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 90, 90, 30));

        txt_Unit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_Unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_UnitActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(txt_Unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 80, 30));

        lbl_Description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_Description.setText("Mô tả:");
        pnl_ProductInfomation.add(lbl_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 140, 50, 30));

        txa_Description.setColumns(20);
        txa_Description.setRows(5);
        scr_Description.setViewportView(txa_Description);

        pnl_ProductInfomation.add(scr_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 190, 100));

        cb_Supplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_Supplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SupplierActionPerformed(evt);
            }
        });
        pnl_ProductInfomation.add(cb_Supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 160, 30));

        add(pnl_ProductInfomation, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 6, 1020, 340));

        pnl_ProductInfomation1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        pnl_ProductInfomation1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_ListProduct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Danh mục", "Nhà cung cấp", "Đơn vị tính", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số trang", "Số lượng", "Giá", "Hình ảnh", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_ListProduct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ListProductMouseClicked(evt);
            }
        });
        scr_LisrProduct.setViewportView(tbl_ListProduct);

        pnl_ProductInfomation1.add(scr_LisrProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 1010, 290));

        add(pnl_ProductInfomation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 1030, 330));

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

        add(jpAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 370, -1, -1));

        jpEdit.setBackground(new java.awt.Color(255, 255, 255));
        jpEdit.setRoundedBottomLeft(10);
        jpEdit.setRoundedBottomRight(10);
        jpEdit.setRoundedTopLeft(10);
        jpEdit.setRoundedTopRight(10);
        jpEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpEditMouseClicked(evt);
            }
        });
        jpEdit.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbEdit.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbEdit.setText("Sửa");
        jpEdit.add(jbEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgEdit.setText(" ");
        jpEdit.add(svgEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        add(jpEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        jpDelete.setBackground(new java.awt.Color(255, 255, 255));
        jpDelete.setRoundedBottomLeft(10);
        jpDelete.setRoundedBottomRight(10);
        jpDelete.setRoundedTopLeft(10);
        jpDelete.setRoundedTopRight(10);
        jpDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpDeleteMouseClicked(evt);
            }
        });
        jpDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbDelete.setText("Xoá");
        jpDelete.add(jbDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgDelete.setText(" ");
        jpDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        add(jpDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 370, -1, -1));

        jpRefresh.setBackground(new java.awt.Color(255, 255, 255));
        jpRefresh.setRoundedBottomLeft(10);
        jpRefresh.setRoundedBottomRight(10);
        jpRefresh.setRoundedTopLeft(10);
        jpRefresh.setRoundedTopRight(10);
        jpRefresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpRefreshMouseClicked(evt);
            }
        });
        jpRefresh.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbRefresh.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbRefresh.setText("Làm mới");
        jpRefresh.add(jbRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 60, 40));

        svgRefresh.setText(" ");
        jpRefresh.add(svgRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        add(jpRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 370, 110, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_ProductIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ProductIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ProductIdActionPerformed

    private void cb_CategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_CategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_CategoryActionPerformed

    private void txt_ProductNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_ProductNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_ProductNameActionPerformed

    private void txt_QuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_QuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_QuantityActionPerformed

    private void txt_PriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PriceActionPerformed

    private void txt_AuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AuthorActionPerformed

    private void txt_PublisherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PublisherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PublisherActionPerformed

    private void txt_PublishingYearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PublishingYearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PublishingYearActionPerformed

    private void txt_PageCountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PageCountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PageCountActionPerformed

    private void jpAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpAddMouseClicked
        if (lblAdd.getText().equals("Thêm")) {
            txt_ProductId.setEnabled(true);
            lblAdd.setText("Lưu");
        } else if (lblAdd.getText().equals("Lưu")) {
            if (checkEmpty(cb_Category.getSelectedItem() + "")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            } else {
                if (checkCondition(cb_Category.getSelectedItem() + "")) {
                    if (checkDuplicateCode(txt_ProductId.getText()) && sanPhamDAO.selectbyId(new SanPham(txt_ProductId.getText())).isTrangThai() == false) {
                        if (sanPhamDAO.update(getInfoFromView()) == 1) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thành công!");
                            loadData();
                            lblAdd.setText("Thêm");
                        } else if (sanPhamDAO.update(getInfoFromView()) == 0) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại vui lòng thử lại sau!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Hệ thống đang gặp trục trặc, Vui lòng liên hệ bộ phận kỹ thuật!");
                        }
                    } else if (checkDuplicateCode(txt_ProductId.getText())) {
                        JOptionPane.showMessageDialog(this, "Sản phẩm này đã tồn tại!");
                    } else {
                        SanPham sanPham = getInfoFromView();
                        int result = sanPhamDAO.insert(sanPham);
                        if (result == 1) {
                            lblAdd.setText("Thêm");
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm mới thành công!");
                            loadData();
                        } else if (result == 0) {
                            JOptionPane.showMessageDialog(this, "Thêm sản phẩm thất bại vui lòng thử lại sau!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Hệ thống đang gặp trục trặc, Vui lòng liên hệ bộ phận kỹ thuật!");
                        }
                    }
                }
            }
        }

    }//GEN-LAST:event_jpAddMouseClicked

    public boolean checkEmpty(String category) {
        boolean result = false;
        if (txt_ProductId.getText().equals("") || cb_Category.getSelectedIndex() == -1 || txt_Quantity.getText().equals("") || txt_ProductName.getText().equals("") || txt_Unit.equals("") || cb_Supplier.getSelectedIndex() == -1 || txt_Price.getText().equals("")) {
            result = true;
        }
        if (category.equals("Sách")) {
            if (txt_Author.getText().equals("") || txt_Publisher.equals("") || txt_PublishingYear.getText().equals("") || txt_PageCount.getText().equals("")) {
                result = true;
            }
        }
        return result;
    }

    public boolean checkDuplicateCode(String productId) {
        for (SanPham sanPham : sanPhamDAO.selectAll()) {
            if (sanPham.getMaSanPham().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkCondition(String category) {
        boolean result = true;
        if (!txt_ProductId.getText().matches("^[0-9]{13}$")) {
            JOptionPane.showMessageDialog(this, "Mã sản phẩm phải là mã vạch sản phẩm với 13 ký tự số!");
            result = false;
        } else if (!txt_Quantity.getText().matches("^[1-9]\\d*$")) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số nguyên dương!");
            result = false;
        } else if (!txt_ProductName.getText().matches("^[\\p{L}0-9.,:\\s'-]{1,100}$")) {
            JOptionPane.showMessageDialog(this, "Tên sản phẩm không hợp lệ!");
            result = false;
        } else if (!txt_Unit.getText().matches("^[\\p{L} ]+$")) {
            JOptionPane.showMessageDialog(this, "Đơn vị tính phải là chữ cái!");
            result = false;
        } else if (!txt_Price.getText().matches("^\\d+$")) {
            JOptionPane.showMessageDialog(this, "Giá phải là số dương!");
            result = false;
        }
        if (category.equals("Sách")) {
            if (!txt_Author.getText().matches("^[\\p{L}][\\p{L}.\\s]*[\\p{L}]")) {
                JOptionPane.showMessageDialog(this, "Tên tác giả phải là chữ cái!");
                result = false;
            } else if (!txt_Publisher.getText().matches("^[\\p{L}0-9.&\\s'-]{1,100}$")) {
                JOptionPane.showMessageDialog(this, "Nhà xuất bản không hợp lệ!");
                result = false;
            } else if (!txt_PublishingYear.getText().matches("^(18[3-9]\\d|19\\d\\d|20[0-1]\\d|202[0-3])$")) {
                JOptionPane.showMessageDialog(this, "Năm xuất bản phải bằng hoặc trước năm hiện tại!");
                result = false;
            } else if (!txt_PageCount.getText().matches("^[1-9]\\d*$")) {
                JOptionPane.showMessageDialog(this, "Số trang sách phải lớn hơn 0!");
                result = false;
            }
        }
        return result;
    }

    public String searchSupplierId(String supplierName) {
        for (NhaCungCap nhaCungCap : nhaCungCapDAO.getAllNhaCungCap()) {
            if (nhaCungCap.getTenNhaCC().equals(supplierName)) {
                return nhaCungCap.getMaNhaCC();
            }
        }
        return null;
    }

    public SanPham getInfoFromView() {
        String maSanPham = txt_ProductId.getText();
        String tenSanPham = txt_ProductName.getText();
        String danhMuc = cb_Category.getSelectedItem() + "";
        String maNhaCC = searchSupplierId(cb_Supplier.getSelectedItem() + "");
        System.out.println(cb_Category.getSelectedItem() + "");
        double gia = Double.valueOf(txt_Price.getText());
        String donViTinh = txt_Unit.getText();
        int soLuong = Integer.valueOf(txt_Quantity.getText());
        String hinhAnh = selectedImagePath;
        String moTa = txa_Description.getText();
        String tacGia = "";
        int soTrang = 0;
        int namXuatBan = 0;
        String nhaXuatBan = "";

        // Kiểm tra nếu là danh mục là sách thì lưu cách thông tin riêng của sách
        if (cb_Category.getSelectedItem().equals("Sách")) {
            tacGia = txt_Author.getText();
            soTrang = Integer.valueOf(txt_PageCount.getText());
            namXuatBan = Integer.valueOf(txt_PublishingYear.getText());
            nhaXuatBan = txt_Publisher.getText();
        }

        SanPham sanPham = new SanPham(maSanPham, tenSanPham, danhMuc, maNhaCC, donViTinh, tacGia, nhaXuatBan, namXuatBan, soTrang, soLuong, gia, hinhAnh, moTa);
        return sanPham;
    }

    private void jpEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpEditMouseClicked
        int row = tbl_ListProduct.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần chỉnh sửa thông tin!");
            return;
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn thay đổi thông tin sản phẩm này?", "Edit", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (checkEmpty(cb_Category.getSelectedItem() + "")) {
                    JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
                } else {
                    if (checkCondition(cb_Category.getSelectedItem() + "")) {
                        if (sanPhamDAO.update(getInfoFromView()) == 1) {
                            JOptionPane.showMessageDialog(this, "Cập nhật thông tin sản phẩm thành công!");
                            loadData();
                        } else if (sanPhamDAO.update(getInfoFromView()) == 0) {
                            JOptionPane.showMessageDialog(this, "Cập nhật thất bại, Vui lòng thử lại sau!");
                        } else {
                            JOptionPane.showMessageDialog(this, "Hệ thống đang gặp trục trặc, Vui lòng liên hệ bộ phận kỹ thuật!");
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_jpEditMouseClicked

    private void jpDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeleteMouseClicked
        int row = tbl_ListProduct.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa!");
            return;
        } else {
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa sản phẩm này?", "Delete", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                if (sanPhamDAO.delete(new SanPham(modelSanPham.getValueAt(row, 0) + "")) == 1) {
                    JOptionPane.showMessageDialog(this, "Đã xóa thành công");
                    clearInput();
                    loadData();
                } else {
                    JOptionPane.showMessageDialog(this, "Hệ thống đang gặp trục trặc, Vui lòng liên hệ bộ phận kỹ thuật!");
                }
            }
        }
    }//GEN-LAST:event_jpDeleteMouseClicked

    private void jpRefreshMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpRefreshMouseClicked
        clearInput();
        txt_ProductId.setEnabled(false);
        lblAdd.setText("Thêm");
        loadData();
    }//GEN-LAST:event_jpRefreshMouseClicked

    public void clearInput() {
        txt_ProductId.setText("");
        cb_Category.setSelectedIndex(-1);
        txt_Quantity.setText("");
        txt_ProductName.setText("");
        txt_Unit.setText("");
        cb_Supplier.setSelectedIndex(-1);
        txt_Price.setText("");
        txt_Author.setText("");
        txt_PublishingYear.setText("");
        txt_Publisher.setText("");
        txt_PageCount.setText("");
        txa_Description.setText("");
        lbl_ProductImage.setIcon(null);
        tbl_ListProduct.clearSelection();
    }
    
    private void btn_chooseImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chooseImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        int returnValue = chooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = chooser.getSelectedFile();
            lbl_ProductImage.setIcon(createImageIcon(selectedFile.getAbsolutePath(), lbl_ProductImage));
            selectedImagePath = selectedFile.getAbsolutePath();
        }
    }//GEN-LAST:event_btn_chooseImageActionPerformed

    private void txt_UnitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_UnitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_UnitActionPerformed

    private void tbl_ListProductMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ListProductMouseClicked
        int row = tbl_ListProduct.getSelectedRow();
        txt_ProductId.setText(modelSanPham.getValueAt(row, 0) + "");
        txt_ProductName.setText(modelSanPham.getValueAt(row, 1) + "");
        cb_Category.setSelectedItem(modelSanPham.getValueAt(row, 2) + "");
        cb_Supplier.setSelectedItem(modelSanPham.getValueAt(row, 3) + "");
        txt_Unit.setText(modelSanPham.getValueAt(row, 4) + "");
        txt_Author.setText(modelSanPham.getValueAt(row, 5) + "");
        txt_Publisher.setText(modelSanPham.getValueAt(row, 6) + "");
        txt_PublishingYear.setText(modelSanPham.getValueAt(row, 7) + "");
        txt_PageCount.setText(modelSanPham.getValueAt(row, 8) + "");
        txt_Quantity.setText(modelSanPham.getValueAt(row, 9) + "");
        String price = sanPhamDAO.selectbyId(new SanPham(modelSanPham.getValueAt(row, 0)+"")).getGia()+"";
        txt_Price.setText(price.substring(0, price.lastIndexOf(".")));
        lbl_ProductImage.setIcon(createImageIcon(modelSanPham.getValueAt(row, 11) + "", lbl_ProductImage));
        txa_Description.setText(modelSanPham.getValueAt(row, 12) + "");

    }//GEN-LAST:event_tbl_ListProductMouseClicked

    public ImageIcon createImageIcon(String url, JLabel label) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
//            e.printStackTrace();
            return null;
        }

        // Scale ảnh để vừa với JLabel
        BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, label.getWidth(), label.getHeight());
        return new ImageIcon(scaledImage);
    }

    private void cb_SupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SupplierActionPerformed

    private void cb_CategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_CategoryItemStateChanged
        if (cb_Category.getSelectedIndex() != 0) {
            lbl_Author.setVisible(false);
            txt_Author.setVisible(false);
            lbl_Publisher.setVisible(false);
            txt_Publisher.setVisible(false);
            lbl_PublishingYear.setVisible(false);
            txt_PublishingYear.setVisible(false);
            lbl_PageCount.setVisible(false);
            txt_PageCount.setVisible(false);
        } else {
            lbl_Author.setVisible(true);
            txt_Author.setVisible(true);
            lbl_Publisher.setVisible(true);
            txt_Publisher.setVisible(true);
            lbl_PublishingYear.setVisible(true);
            txt_PublishingYear.setVisible(true);
            lbl_PageCount.setVisible(true);
            txt_PageCount.setVisible(true);
        }
    }//GEN-LAST:event_cb_CategoryItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_chooseImage;
    private javax.swing.JComboBox<String> cb_Category;
    private javax.swing.JComboBox<String> cb_Supplier;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel jbDelete;
    private javax.swing.JLabel jbEdit;
    private javax.swing.JLabel jbRefresh;
    private util.JPanelRounded jpAdd;
    private util.JPanelRounded jpDelete;
    private util.JPanelRounded jpEdit;
    private util.JPanelRounded jpRefresh;
    private javax.swing.JLabel lblAdd;
    private javax.swing.JLabel lbl_Author;
    private javax.swing.JLabel lbl_Category;
    private javax.swing.JLabel lbl_Description;
    private javax.swing.JLabel lbl_PageCount;
    private javax.swing.JLabel lbl_Price;
    private javax.swing.JLabel lbl_ProductId;
    private javax.swing.JLabel lbl_ProductImage;
    private javax.swing.JLabel lbl_ProductName;
    private javax.swing.JLabel lbl_Publisher;
    private javax.swing.JLabel lbl_PublishingYear;
    private javax.swing.JLabel lbl_Quantity;
    private javax.swing.JLabel lbl_Supplier;
    private javax.swing.JLabel lbl_Unit;
    private javax.swing.JPanel pnl_ProductImage;
    private javax.swing.JPanel pnl_ProductInfomation;
    private javax.swing.JPanel pnl_ProductInfomation1;
    private javax.swing.JScrollPane scr_Description;
    private javax.swing.JScrollPane scr_LisrProduct;
    private util.SVGImage svgAdd;
    private util.SVGImage svgDelete;
    private util.SVGImage svgEdit;
    private util.SVGImage svgRefresh;
    private javax.swing.JTable tbl_ListProduct;
    private javax.swing.JTextArea txa_Description;
    private javax.swing.JTextField txt_Author;
    private javax.swing.JTextField txt_PageCount;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_ProductId;
    private javax.swing.JTextField txt_ProductName;
    private javax.swing.JTextField txt_Publisher;
    private javax.swing.JTextField txt_PublishingYear;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JTextField txt_Unit;
    // End of variables declaration//GEN-END:variables
}
