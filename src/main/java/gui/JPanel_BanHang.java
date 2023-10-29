package gui;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.PlanarYUVLuminanceSource;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.common.HybridBinarizer;
import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.SanPhamDAO;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.imgscalr.Scalr;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JPanel_BanHang extends javax.swing.JPanel {

    private String maNhanVien;
    private DefaultTableModel modelCart;
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));
    private DecimalFormat decimalFormat = new DecimalFormat("#,###");
    private int infoPage = 1;
    private int infoPageCategory;

    public JPanel_BanHang(String maNhanVien) {
        this.maNhanVien = maNhanVien;
        initComponents();
        modelCart = (DefaultTableModel) tbl_Cart.getModel();
        modelCart.setRowCount(0);
        svgPay2.setSvgImage("pay.svg", 30, 30);
        svgPay1.setSvgImage("pay.svg", 30, 30);
        svgSearch.setSvgImage("search.svg", 20, 20);
        svgCreateInvoice.setSvgImage("add.svg", 20, 20);
        svgDelete.setSvgImage("delete.svg", 20, 20);
        svgDeleteAll.setSvgImage("delete.svg", 20, 20);
        svgReload.setSvgImage("refresh.svg", 20, 20);

        jpPaySale.setEnabled(false);
        txt_customerMoneyGive.setEnabled(false);
        txa_noteSale.setEnabled(false);
        cb_customerIdSale.setEnabled(false);

        jpDelivery.setEnabled(false);
        txt_customerPhone.setEnabled(false);
        txa_customerDeliveryAddress.setEnabled(false);
        txa_noteOrder.setEnabled(false);

        Thread thread = new Thread(
                () -> scanCode()
        );
        thread.start();
        loadData();
    }

    public void scanCode() {
        Webcam webcam = Webcam.getDefault();
        webcam.open();

        WebcamPanel webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setFPSDisplayed(true);
        webcamPanel.setDisplayDebugInfo(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(false); // Đừng đảo ngược hình ảnh

        jPanelScanCode.add(webcamPanel, BorderLayout.CENTER);
        jPanelScanCode.repaint();
        jPanelScanCode.revalidate();
        while (true) {
            BufferedImage image = webcam.getImage();
            Result result = decodeBarcode(image);
            if (result != null) {
                SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(result.getText()));
                if (sanPham != null) {
                    ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
                    thongTinSanPham.setVisible(true);
                    thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (!thongTinSanPham.getTxt_quantity().getText().matches("^\\d+$")) {
                                JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                            } else {
                                int quantity = Integer.parseInt(thongTinSanPham.getTxt_quantity().getText());
                                if (quantity > 0) {
                                    if (quantity > sanPham.getSoLuong()) {
                                        JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                                        return;
                                    }
                                    addProductToCart(sanPham, quantity);
                                    thongTinSanPham.setVisible(false);
                                } else {
                                    JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                                }
                            }
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                        }
                    });
                    try {
                        Thread.sleep(3000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private static Result decodeBarcode(BufferedImage image) {
        try {
            int width = image.getWidth();
            int height = image.getHeight();
            int[] pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);

            LuminanceSource source = new PlanarYUVLuminanceSource(
                    toByteArray(pixels, width, height),
                    width,
                    height,
                    0,
                    0,
                    width,
                    height,
                    false
            );

            BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
            Reader reader = new MultiFormatReader();
            return reader.decode(bitmap);
        } catch (NotFoundException e) {
            // Không tìm thấy mã vạch
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static byte[] toByteArray(int[] pixels, int width, int height) {
        byte[] byteArray = new byte[width * height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int pixel = pixels[i * width + j];
                byteArray[i * width + j] = (byte) ((pixel >> 16) & 0xFF);
            }
        }
        return byteArray;
    }

    public ArrayList<SanPham> getAvailableProduct() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        for (SanPham sanPham : sanPhamDAO.selectAll()) {
            if (sanPham.isTrangThai()) {
                danhSachSanPham.add(sanPham);
            }
        }
        return danhSachSanPham;
    }

    public void loadData() {
        if (cb_category.getSelectedIndex() < 0) {
            int totalProduct = getAvailableProduct().size();
            lbl_infoPage.setText(infoPage + "/" + (int) Math.ceil(totalProduct / 4.0));
            loadListProduct(infoPage * 4);
            if (infoPage == 1 && infoPage == (int) Math.ceil(totalProduct / 4.0)) {
                btn_previous.setEnabled(false);
                btn_next.setEnabled(false);
            } else if (infoPage == 1) {
                btn_previous.setEnabled(false);
                btn_next.setEnabled(true);
            } else if (infoPage == (int) Math.ceil(totalProduct / 4.0)) {
                btn_next.setEnabled(false);
                btn_previous.setEnabled(true);
            } else {
                btn_previous.setEnabled(true);
                btn_next.setEnabled(true);
            }
        } else {
            loadDataByCategory();
        }
    }

    private void loadListProduct(int start) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        for (int i = start - 4; i < start; i++) {
            if (i < getAvailableProduct().size()) {
                danhSachSanPham.add(getAvailableProduct().get(i));
            }
        }
        loadProductItem(danhSachSanPham);
    }

    private void loadProductItem(ArrayList<SanPham> danhSachSanPham) {
        lbl_productImage1.setIcon(createImageIcon(danhSachSanPham.get(0).getHinhAnh()));
        lbl_productImage1.putClientProperty("maSanPham", danhSachSanPham.get(0).getMaSanPham());
        lbl_productItemName1.setText(danhSachSanPham.get(0).getTenSanPham());
        lbl_productItemQuantity1.setText(danhSachSanPham.get(0).getSoLuong() + "");
        lbl_productItemPrice1.setText(decimalFormat.format(danhSachSanPham.get(0).getGia()));

        if (danhSachSanPham.size() <= 1) {
            pnl_productItem2.setVisible(false);
        } else {
            pnl_productItem2.setVisible(true);
            lbl_productImage2.setIcon(createImageIcon(danhSachSanPham.get(1).getHinhAnh()));
            lbl_productImage2.putClientProperty("maSanPham", danhSachSanPham.get(1).getMaSanPham());
            lbl_productItemName2.setText(danhSachSanPham.get(1).getTenSanPham());
            lbl_productItemQuantity2.setText(danhSachSanPham.get(1).getSoLuong() + "");
            lbl_productItemPrice2.setText(decimalFormat.format(danhSachSanPham.get(1).getGia()));
        }

        if (danhSachSanPham.size() <= 2) {
            pnl_productItem3.setVisible(false);
        } else {
            pnl_productItem3.setVisible(true);
            lbl_productImage3.setIcon(createImageIcon(danhSachSanPham.get(2).getHinhAnh()));
            lbl_productImage3.putClientProperty("maSanPham", danhSachSanPham.get(2).getMaSanPham());
            lbl_productItemName3.setText(danhSachSanPham.get(2).getTenSanPham());
            lbl_productItemQuantity3.setText(danhSachSanPham.get(2).getSoLuong() + "");
            lbl_productItemPrice3.setText(decimalFormat.format(danhSachSanPham.get(2).getGia()));
        }

        if (danhSachSanPham.size() <= 3) {
            pnl_productItem4.setVisible(false);
        } else {
            pnl_productItem4.setVisible(true);
            lbl_productImage4.setIcon(createImageIcon(danhSachSanPham.get(3).getHinhAnh()));
            lbl_productImage4.putClientProperty("maSanPham", danhSachSanPham.get(3).getMaSanPham());
            lbl_productItemName4.setText(danhSachSanPham.get(3).getTenSanPham());
            lbl_productItemQuantity4.setText(danhSachSanPham.get(3).getSoLuong() + "");
            lbl_productItemPrice4.setText(decimalFormat.format(danhSachSanPham.get(3).getGia()));
        }

    }

    private void addProductToCart(SanPham sanPham, int quantity) {
        for (int i = 0; i < modelCart.getRowCount(); i++) {
            if (sanPham.getMaSanPham().equals(modelCart.getValueAt(i, 1))) {
                modelCart.setValueAt(quantity + Integer.valueOf(modelCart.getValueAt(i, 3) + "") + "", i, 3);
                modelCart.setValueAt(nf.format(Integer.valueOf(modelCart.getValueAt(i, 3) + "") * sanPham.getGia()), i, 5);
                SanPham sanPhamNew = sanPhamDAO.selectbyId(sanPham);
                sanPhamNew.setSoLuong(sanPham.getSoLuong() - quantity);
                sanPhamDAO.update(sanPhamNew);
                loadData();
                return;
            }
        }
        String[] data = {modelCart.getRowCount() + 1 + "", sanPham.getMaSanPham(), sanPham.getTenSanPham(), quantity + "", nf.format(sanPham.getGia()), nf.format(sanPham.getGia() * quantity)};
        modelCart.addRow(data);
        SanPham sanPhamNew = sanPhamDAO.selectbyId(sanPham);
        sanPhamNew.setSoLuong(sanPham.getSoLuong() - quantity);
        sanPhamDAO.update(sanPhamNew);
        loadData();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelScanCode = new javax.swing.JPanel();
        jPanelCart = new javax.swing.JPanel();
        scr_Cart = new javax.swing.JScrollPane();
        tbl_Cart = new javax.swing.JTable();
        txt_SearchProduct = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        lbl_infoPage = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        btn_next = new javax.swing.JButton();
        lbl_ = new javax.swing.JTabbedPane();
        tb_Sale = new javax.swing.JPanel();
        jpPaySale = new util.JPanelRounded();
        lblPay1 = new javax.swing.JLabel();
        svgPay1 = new util.SVGImage();
        jPanel2 = new javax.swing.JPanel();
        lblTotalAmount = new javax.swing.JLabel();
        lblDiscount = new javax.swing.JLabel();
        lblMustPay = new javax.swing.JLabel();
        lblCustomerMoneyGive = new javax.swing.JLabel();
        lblReturnMoneyToCustomer = new javax.swing.JLabel();
        txt_customerMoneyGive = new javax.swing.JTextField();
        lblreturnMoneyToCustomerSale = new javax.swing.JLabel();
        lblUnit5 = new javax.swing.JLabel();
        lblUnit4 = new javax.swing.JLabel();
        lblUnit3 = new javax.swing.JLabel();
        lblUnit2 = new javax.swing.JLabel();
        lblUnit1 = new javax.swing.JLabel();
        lbl_totalAmountSale = new javax.swing.JLabel();
        lbl_discountSale = new javax.swing.JLabel();
        lbl_mustPaySale = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_noteSale = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lblOrderId = new javax.swing.JLabel();
        lbl_orderIdSale = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        lblEmployeeIdSale = new javax.swing.JLabel();
        lblCustomerId = new javax.swing.JLabel();
        cb_customerIdSale = new javax.swing.JComboBox<>();
        lblCustomerName = new javax.swing.JLabel();
        lbl_customerNameSale = new javax.swing.JLabel();
        lblOrderDate1 = new javax.swing.JLabel();
        lblEmployeeId1 = new javax.swing.JLabel();
        tb_Order = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblOrderId2 = new javax.swing.JLabel();
        lbl_orderIdOrder = new javax.swing.JLabel();
        lblOrderDate2 = new javax.swing.JLabel();
        lblEmployeeIdOrder = new javax.swing.JLabel();
        lblCustomerName3 = new javax.swing.JLabel();
        lblNote3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txa_customerDeliveryAddress = new javax.swing.JTextArea();
        lbl_orderDateOrder = new javax.swing.JLabel();
        lblEmployeeId3 = new javax.swing.JLabel();
        lblCustomerName4 = new javax.swing.JLabel();
        txt_customerPhone = new javax.swing.JTextField();
        lbl_customerNameOrder = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalAmount1 = new javax.swing.JLabel();
        lblDiscount1 = new javax.swing.JLabel();
        lblMustPay1 = new javax.swing.JLabel();
        lblUnit10 = new javax.swing.JLabel();
        lblUnit11 = new javax.swing.JLabel();
        lblUnit12 = new javax.swing.JLabel();
        lbl_totalAmountOrder = new javax.swing.JLabel();
        lbl_discountOrder = new javax.swing.JLabel();
        lbl_mustPayOrder = new javax.swing.JLabel();
        lblNote2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txa_noteOrder = new javax.swing.JTextArea();
        jpDelivery = new util.JPanelRounded();
        lblPay2 = new javax.swing.JLabel();
        svgPay2 = new util.SVGImage();
        pnlDeleteAll = new util.JPanelRounded();
        lblDeleteAll = new javax.swing.JLabel();
        svgDeleteAll = new util.SVGImage();
        lbl_listProduct = new javax.swing.JPanel();
        pnl_productItem1 = new javax.swing.JPanel();
        lbl_productItemPrice1 = new javax.swing.JLabel();
        lblProductPrice1 = new javax.swing.JLabel();
        lbl_product = new javax.swing.JLabel();
        lbl_productItemQuantity1 = new javax.swing.JLabel();
        lbl_productItemName1 = new javax.swing.JLabel();
        lbl_productImage1 = new javax.swing.JLabel();
        pnl_productItem2 = new javax.swing.JPanel();
        lbl_productItemPrice2 = new javax.swing.JLabel();
        lblProductPrice2 = new javax.swing.JLabel();
        lblProductQuantity2 = new javax.swing.JLabel();
        lbl_productItemQuantity2 = new javax.swing.JLabel();
        lbl_productItemName2 = new javax.swing.JLabel();
        lbl_productImage2 = new javax.swing.JLabel();
        pnl_productItem3 = new javax.swing.JPanel();
        lbl_productItemPrice3 = new javax.swing.JLabel();
        lblProductPrice4 = new javax.swing.JLabel();
        lblProductQuantity4 = new javax.swing.JLabel();
        lbl_productItemQuantity3 = new javax.swing.JLabel();
        lbl_productItemName3 = new javax.swing.JLabel();
        lbl_productImage3 = new javax.swing.JLabel();
        pnl_productItem4 = new javax.swing.JPanel();
        lbl_productItemPrice4 = new javax.swing.JLabel();
        lblProductPrice3 = new javax.swing.JLabel();
        lblProductQuantity3 = new javax.swing.JLabel();
        lbl_productItemQuantity4 = new javax.swing.JLabel();
        lbl_productItemName4 = new javax.swing.JLabel();
        lbl_productImage4 = new javax.swing.JLabel();
        btn_previous = new javax.swing.JButton();
        lblSearchProduct1 = new javax.swing.JLabel();
        chkOrder = new javax.swing.JCheckBox();
        jpSearch = new util.JPanelRounded();
        lblSearch = new javax.swing.JLabel();
        svgSearch = new util.SVGImage();
        pnlDelete = new util.JPanelRounded();
        lblDelete = new javax.swing.JLabel();
        svgDelete = new util.SVGImage();
        pnlCreateInvoice = new util.JPanelRounded();
        lblCreateInvoice = new javax.swing.JLabel();
        svgCreateInvoice = new util.SVGImage();
        jp_reload = new util.JPanelRounded();
        svgReload = new util.SVGImage();

        setPreferredSize(new java.awt.Dimension(1040, 711));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelScanCode.setLayout(new java.awt.BorderLayout());
        add(jPanelScanCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        jPanelCart.setLayout(new java.awt.BorderLayout());

        tbl_Cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_Cart.setViewportView(tbl_Cart);

        jPanelCart.add(scr_Cart, java.awt.BorderLayout.CENTER);

        add(jPanelCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 700, 190));

        txt_SearchProduct.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_SearchProduct.setText("8900767778797");
        txt_SearchProduct.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txt_SearchProductInputMethodTextChanged(evt);
            }
        });
        txt_SearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchProductActionPerformed(evt);
            }
        });
        txt_SearchProduct.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchProductKeyReleased(evt);
            }
        });
        add(txt_SearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 380, 140, 30));

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCategory.setText("Danh mục:");
        add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 380, -1, 30));

        lbl_infoPage.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_infoPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_infoPage.setText("1/4");
        add(lbl_infoPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 710, 40, 30));

        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Dụng cụ học tập", "Văn phòng phẩm", "Đồ chơi", "Quà lưu niệm" }));
        cb_category.setSelectedIndex(-1);
        cb_category.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_categoryItemStateChanged(evt);
            }
        });
        cb_category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_categoryActionPerformed(evt);
            }
        });
        add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 140, 30));

        btn_next.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_next.setText(">>");
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 710, 60, 30));

        tb_Sale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jpPaySale.setBackground(new java.awt.Color(255, 255, 255));
        jpPaySale.setRoundedBottomLeft(10);
        jpPaySale.setRoundedBottomRight(10);
        jpPaySale.setRoundedTopLeft(10);
        jpPaySale.setRoundedTopRight(10);
        jpPaySale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpPaySaleMouseClicked(evt);
            }
        });
        jpPaySale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPay1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPay1.setText("Thanh toán");
        jpPaySale.add(lblPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, 40));

        svgPay1.setText(" ");
        jpPaySale.add(svgPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        tb_Sale.add(jpPaySale, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 130, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalAmount.setText("Tổng tiền:");
        jPanel2.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        lblDiscount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDiscount.setText("Giảm giá:");
        jPanel2.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        lblMustPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMustPay.setText("Phải trả:");
        jPanel2.add(lblMustPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        lblCustomerMoneyGive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerMoneyGive.setText("Tiền khách đưa:");
        jPanel2.add(lblCustomerMoneyGive, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, 30));

        lblReturnMoneyToCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblReturnMoneyToCustomer.setText("Trả lại khách:");
        jPanel2.add(lblReturnMoneyToCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, -1, 30));

        txt_customerMoneyGive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_customerMoneyGive.setText("0");
        txt_customerMoneyGive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerMoneyGiveActionPerformed(evt);
            }
        });
        jPanel2.add(txt_customerMoneyGive, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, 30));

        lblreturnMoneyToCustomerSale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblreturnMoneyToCustomerSale.setText("0");
        jPanel2.add(lblreturnMoneyToCustomerSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 30));

        lblUnit5.setText("VNĐ");
        jPanel2.add(lblUnit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 30, 30));

        lblUnit4.setText("VNĐ");
        jPanel2.add(lblUnit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 30, 30));

        lblUnit3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUnit3.setForeground(new java.awt.Color(255, 51, 51));
        lblUnit3.setText("VNĐ");
        jPanel2.add(lblUnit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 30, 30));

        lblUnit2.setText("VNĐ");
        jPanel2.add(lblUnit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 30, 30));

        lblUnit1.setText("VNĐ");
        jPanel2.add(lblUnit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 30, 30));

        lbl_totalAmountSale.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_totalAmountSale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_totalAmountSale.setText("0");
        jPanel2.add(lbl_totalAmountSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, 30));

        lbl_discountSale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_discountSale.setText("0");
        jPanel2.add(lbl_discountSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, 30));

        lbl_mustPaySale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_mustPaySale.setForeground(new java.awt.Color(255, 51, 51));
        lbl_mustPaySale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_mustPaySale.setText("0");
        jPanel2.add(lbl_mustPaySale, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 100, 30));

        lblNote.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNote.setText("Ghi chú:");
        jPanel2.add(lblNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 90, 30));

        txa_noteSale.setColumns(20);
        txa_noteSale.setRows(5);
        jScrollPane1.setViewportView(txa_noteSale);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 140, 100));

        tb_Sale.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 300, 340));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chung"));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrderId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderId.setText("Mã đơn hàng:");
        jPanel4.add(lblOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        lbl_orderIdSale.setText("Vui lòng tạo hóa đơn!");
        jPanel4.add(lbl_orderIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 160, 30));
        jPanel4.add(lblOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, 30));
        jPanel4.add(lblEmployeeIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, 30));

        lblCustomerId.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerId.setText("Mã khách hàng:");
        jPanel4.add(lblCustomerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 90, 30));

        cb_customerIdSale.setSelectedIndex(-1);
        cb_customerIdSale.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_customerIdSaleItemStateChanged(evt);
            }
        });
        cb_customerIdSale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_customerIdSaleActionPerformed(evt);
            }
        });
        jPanel4.add(cb_customerIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 30));

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerName.setText("Tên khách hàng:");
        jPanel4.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));
        jPanel4.add(lbl_customerNameSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, 30));

        lblOrderDate1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderDate1.setText("Ngày tạo:");
        jPanel4.add(lblOrderDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));

        lblEmployeeId1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmployeeId1.setText("Mã nhân viên:");
        jPanel4.add(lblEmployeeId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

        tb_Sale.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 250));

        lbl_.addTab("Đơn hàng", tb_Sale);

        tb_Order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông tin chung"));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrderId2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderId2.setText("Mã đơn hàng:");
        jPanel12.add(lblOrderId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 30));

        lbl_orderIdOrder.setText("Vui lòng tạo hóa đơn!");
        jPanel12.add(lbl_orderIdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, 160, 30));

        lblOrderDate2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblOrderDate2.setText("Ngày tạo:");
        jPanel12.add(lblOrderDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 30));
        jPanel12.add(lblEmployeeIdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 90, 30));

        lblCustomerName3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerName3.setText("Tên khách hàng:");
        jPanel12.add(lblCustomerName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, 30));

        lblNote3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNote3.setText("Địa chỉ:");
        jPanel12.add(lblNote3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 90, 30));

        txa_customerDeliveryAddress.setColumns(20);
        txa_customerDeliveryAddress.setRows(5);
        jScrollPane4.setViewportView(txa_customerDeliveryAddress);

        jPanel12.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 220, 160, 90));
        jPanel12.add(lbl_orderDateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 160, 30));

        lblEmployeeId3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblEmployeeId3.setText("Mã nhân viên:");
        jPanel12.add(lblEmployeeId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 90, 30));

        lblCustomerName4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCustomerName4.setText("Số điện thoại:");
        jPanel12.add(lblCustomerName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, 30));

        txt_customerPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerPhoneActionPerformed(evt);
            }
        });
        jPanel12.add(txt_customerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 180, 160, 30));

        lbl_customerNameOrder.setText("Khách hàng bán lẻ");
        jPanel12.add(lbl_customerNameOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 160, 30));

        tb_Order.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 300, 320));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Chi tiết"));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotalAmount1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblTotalAmount1.setText("Tổng tiền:");
        jPanel3.add(lblTotalAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, 30));

        lblDiscount1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDiscount1.setText("Giảm giá:");
        jPanel3.add(lblDiscount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 30));

        lblMustPay1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblMustPay1.setText("Phải trả:");
        jPanel3.add(lblMustPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, -1, 30));

        lblUnit10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblUnit10.setForeground(new java.awt.Color(255, 51, 51));
        lblUnit10.setText("VNĐ");
        jPanel3.add(lblUnit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 30, 30));

        lblUnit11.setText("VNĐ");
        jPanel3.add(lblUnit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 30, 30));

        lblUnit12.setText("VNĐ");
        jPanel3.add(lblUnit12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 30, 30));

        lbl_totalAmountOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_totalAmountOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_totalAmountOrder.setText("0");
        jPanel3.add(lbl_totalAmountOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 100, 30));

        lbl_discountOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_discountOrder.setText("0");
        jPanel3.add(lbl_discountOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 100, 30));

        lbl_mustPayOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_mustPayOrder.setForeground(new java.awt.Color(255, 51, 51));
        lbl_mustPayOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_mustPayOrder.setText("0");
        jPanel3.add(lbl_mustPayOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 100, 30));

        lblNote2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblNote2.setText("Ghi chú:");
        jPanel3.add(lblNote2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 90, 30));

        txa_noteOrder.setColumns(20);
        txa_noteOrder.setRows(5);
        jScrollPane3.setViewportView(txa_noteOrder);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 140, 100));

        tb_Order.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 300, 260));

        jpDelivery.setBackground(new java.awt.Color(255, 255, 255));
        jpDelivery.setRoundedBottomLeft(10);
        jpDelivery.setRoundedBottomRight(10);
        jpDelivery.setRoundedTopLeft(10);
        jpDelivery.setRoundedTopRight(10);
        jpDelivery.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpDeliveryMouseClicked(evt);
            }
        });
        jpDelivery.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPay2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblPay2.setText("Giao hàng");
        jpDelivery.add(lblPay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, 40));

        svgPay2.setText(" ");
        jpDelivery.add(svgPay2, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        tb_Order.add(jpDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 620, 130, 40));

        lbl_.addTab("Đặt hàng", tb_Order);

        add(lbl_, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, 320, 720));

        pnlDeleteAll.setBackground(new java.awt.Color(255, 255, 255));
        pnlDeleteAll.setRoundedBottomLeft(10);
        pnlDeleteAll.setRoundedBottomRight(10);
        pnlDeleteAll.setRoundedTopLeft(10);
        pnlDeleteAll.setRoundedTopRight(10);
        pnlDeleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeleteAllMouseClicked(evt);
            }
        });
        pnlDeleteAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDeleteAll.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDeleteAll.setText("Xóa tất cả");
        pnlDeleteAll.add(lblDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 60, 30));

        svgDeleteAll.setText(" ");
        pnlDeleteAll.add(svgDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        add(pnlDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 110, 90, 30));

        lbl_listProduct.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        lbl_listProduct.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_productItem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemPrice1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice1.setText("2.000.000");
        pnl_productItem1.add(lbl_productItemPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 90, 30));

        lblProductPrice1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductPrice1.setText("Giá:");
        pnl_productItem1.add(lblProductPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 30));

        lbl_product.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_product.setText("Số lượng:");
        pnl_productItem1.add(lbl_product, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 30));

        lbl_productItemQuantity1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemQuantity1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity1.setText("1.000");
        pnl_productItem1.add(lbl_productItemQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, 30));

        lbl_productItemName1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemName1.setText("Đệ nhất kiếm tiền");
        pnl_productItem1.add(lbl_productItemName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 30));

        lbl_productImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage1MouseClicked(evt);
            }
        });
        pnl_productItem1.add(lbl_productImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 150));

        lbl_listProduct.add(pnl_productItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 160, 250));

        pnl_productItem2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemPrice2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice2.setText("2.000.000");
        pnl_productItem2.add(lbl_productItemPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 90, 30));

        lblProductPrice2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductPrice2.setText("Giá:");
        pnl_productItem2.add(lblProductPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 30));

        lblProductQuantity2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductQuantity2.setText("Số lượng:");
        pnl_productItem2.add(lblProductQuantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 30));

        lbl_productItemQuantity2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemQuantity2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity2.setText("1.000");
        pnl_productItem2.add(lbl_productItemQuantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, 30));

        lbl_productItemName2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemName2.setText("Đệ nhất kiếm tiền");
        pnl_productItem2.add(lbl_productItemName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 30));

        lbl_productImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage2MouseClicked(evt);
            }
        });
        pnl_productItem2.add(lbl_productImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 150));

        lbl_listProduct.add(pnl_productItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, 160, -1));

        pnl_productItem3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemPrice3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice3.setText("2.000.000");
        pnl_productItem3.add(lbl_productItemPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 90, 30));

        lblProductPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductPrice4.setText("Giá:");
        pnl_productItem3.add(lblProductPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 30));

        lblProductQuantity4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductQuantity4.setText("Số lượng:");
        pnl_productItem3.add(lblProductQuantity4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 30));

        lbl_productItemQuantity3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemQuantity3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity3.setText("1.000");
        pnl_productItem3.add(lbl_productItemQuantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, 30));

        lbl_productItemName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemName3.setText("Đệ nhất kiếm tiền");
        pnl_productItem3.add(lbl_productItemName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 30));

        lbl_productImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage3MouseClicked(evt);
            }
        });
        pnl_productItem3.add(lbl_productImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 150));

        lbl_listProduct.add(pnl_productItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 160, -1));

        pnl_productItem4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemPrice4.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice4.setText("2.000.000");
        pnl_productItem4.add(lbl_productItemPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 90, 30));

        lblProductPrice3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductPrice3.setText("Giá:");
        pnl_productItem4.add(lblProductPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, 30));

        lblProductQuantity3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblProductQuantity3.setText("Số lượng:");
        pnl_productItem4.add(lblProductQuantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 30));

        lbl_productItemQuantity4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_productItemQuantity4.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity4.setText("1.000");
        pnl_productItem4.add(lbl_productItemQuantity4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 50, 30));

        lbl_productItemName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemName4.setText("Đệ nhất kiếm tiền");
        pnl_productItem4.add(lbl_productItemName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 160, 30));

        lbl_productImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage4MouseClicked(evt);
            }
        });
        pnl_productItem4.add(lbl_productImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 150));

        lbl_listProduct.add(pnl_productItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 20, 160, -1));

        add(lbl_listProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 420, 700, 280));

        btn_previous.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_previous.setText("<<");
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });
        add(btn_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 710, 60, 30));

        lblSearchProduct1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearchProduct1.setText("Tìm kiếm sản phẩm:");
        add(lblSearchProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, 30));

        chkOrder.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chkOrder.setText("Đặt hàng");
        chkOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOrderActionPerformed(evt);
            }
        });
        add(chkOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, -1, 30));

        jpSearch.setBackground(new java.awt.Color(255, 255, 255));
        jpSearch.setRoundedBottomLeft(10);
        jpSearch.setRoundedBottomRight(10);
        jpSearch.setRoundedTopLeft(10);
        jpSearch.setRoundedTopRight(10);
        jpSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpSearchMouseClicked(evt);
            }
        });
        jpSearch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblSearch.setText("Tìm");
        jpSearch.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        svgSearch.setText(" ");
        jpSearch.add(svgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        add(jpSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, -1, 30));

        pnlDelete.setBackground(new java.awt.Color(255, 255, 255));
        pnlDelete.setRoundedBottomLeft(10);
        pnlDelete.setRoundedBottomRight(10);
        pnlDelete.setRoundedTopLeft(10);
        pnlDelete.setRoundedTopRight(10);
        pnlDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlDeleteMouseClicked(evt);
            }
        });
        pnlDelete.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblDelete.setText("Xóa");
        pnlDelete.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        svgDelete.setText(" ");
        pnlDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        add(pnlDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, -1, 30));

        pnlCreateInvoice.setBackground(new java.awt.Color(255, 255, 255));
        pnlCreateInvoice.setRoundedBottomLeft(10);
        pnlCreateInvoice.setRoundedBottomRight(10);
        pnlCreateInvoice.setRoundedTopLeft(10);
        pnlCreateInvoice.setRoundedTopRight(10);
        pnlCreateInvoice.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlCreateInvoiceMouseClicked(evt);
            }
        });
        pnlCreateInvoice.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCreateInvoice.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblCreateInvoice.setText("Tạo hóa đơn");
        pnlCreateInvoice.add(lblCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 30));

        svgCreateInvoice.setText(" ");
        pnlCreateInvoice.add(svgCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        add(pnlCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 110, 30));

        jp_reload.setBackground(new java.awt.Color(255, 255, 255));
        jp_reload.setRoundedBottomLeft(10);
        jp_reload.setRoundedBottomRight(10);
        jp_reload.setRoundedTopLeft(10);
        jp_reload.setRoundedTopRight(10);
        jp_reload.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jp_reloadMouseClicked(evt);
            }
        });
        jp_reload.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgReload.setText(" ");
        jp_reload.add(svgReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 6, 20, 20));

        add(jp_reload, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 710, 40, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void cb_customerIdSaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_customerIdSaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_customerIdSaleActionPerformed

    private void txt_customerMoneyGiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerMoneyGiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customerMoneyGiveActionPerformed

    private void txt_SearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchProductActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchProductActionPerformed

    private void cb_categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_categoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_categoryActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        if (cb_category.getSelectedIndex() < 0) {
            this.infoPage = this.infoPage + 1;
            loadData();
        } else {
            this.infoPageCategory = this.infoPageCategory + 1;
            loadDataByCategory();
        }
    }//GEN-LAST:event_btn_nextActionPerformed

    private void pnlDeleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeleteAllMouseClicked
        if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa toàn bộ giỏ hàng?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
            for (int i = 0; i < modelCart.getRowCount(); i++) {
                SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(modelCart.getValueAt(i, 1) + ""));
                sanPham.setSoLuong(sanPham.getSoLuong() + Integer.valueOf((modelCart.getValueAt(i, 3) + "")));
                sanPhamDAO.update(sanPham);
            }
            JOptionPane.showMessageDialog(this, "Đã xóa thành công!");
            modelCart.setRowCount(0);
            loadData();
        }
    }//GEN-LAST:event_pnlDeleteAllMouseClicked

    private void jpPaySaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPaySaleMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpPaySaleMouseClicked

    private void btn_previousActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_previousActionPerformed
        if (cb_category.getSelectedIndex() < 0) {
            this.infoPage = this.infoPage - 1;
            loadData();
        } else {
            this.infoPageCategory = this.infoPageCategory - 1;
            loadDataByCategory();
        }
    }//GEN-LAST:event_btn_previousActionPerformed

    private void jpDeliveryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpDeliveryMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpDeliveryMouseClicked

    private void chkOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkOrderActionPerformed

    private void jpSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpSearchMouseClicked

    private void pnlDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeleteMouseClicked
        int row = tbl_Cart.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa khỏi giỏ hàng!");
        } else {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(modelCart.getValueAt(row, 1) + ""));
            sanPham.setSoLuong(sanPham.getSoLuong() + Integer.valueOf((modelCart.getValueAt(row, 3) + "")));
            sanPhamDAO.update(sanPham);
            if (row + 1 == modelCart.getRowCount()) {
                modelCart.removeRow(row);
            } else {
                modelCart.removeRow(row);
                for (int i = 0; i < modelCart.getRowCount(); i++) {
                    modelCart.setValueAt(i + 1, i, 0);
                }
            }
            loadData();
        }
    }//GEN-LAST:event_pnlDeleteMouseClicked

    private void pnlCreateInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCreateInvoiceMouseClicked
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
        if (!chkOrder.isSelected()) {
            // Set enable fields
            jpPaySale.setEnabled(true);
            txt_customerMoneyGive.setEnabled(true);
            txa_noteSale.setEnabled(true);
            cb_customerIdSale.setEnabled(true);
            lbl_orderIdSale.setText(hoaDonDAO.createOrderId());
            lblOrderDate.setText(formatter.format(LocalDateTime.now()));
            lblEmployeeIdSale.setText(maNhanVien);
            cb_customerIdSale.removeAllItems();
            for (KhachHang khachHang : khachHangDAO.getAllKhachHang()) {
                cb_customerIdSale.addItem(khachHang.getMaKH());
            }
        } else {
            jpDelivery.setEnabled(true);
            txt_customerPhone.setEnabled(true);
            txa_customerDeliveryAddress.setEnabled(true);
            txa_noteOrder.setEnabled(true);
            lbl_orderIdOrder.setText(hoaDonDAO.createOrderId());
            lbl_orderDateOrder.setText(formatter.format(LocalDateTime.now()));
            lblEmployeeIdOrder.setText(maNhanVien);
        }

    }//GEN-LAST:event_pnlCreateInvoiceMouseClicked

    private void txt_SearchProductInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txt_SearchProductInputMethodTextChanged

    }//GEN-LAST:event_txt_SearchProductInputMethodTextChanged

    private void txt_SearchProductKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchProductKeyReleased
        if (txt_SearchProduct.getText().equals("") && cb_category.getSelectedIndex() < 0) {
            loadData();
        } else if (txt_SearchProduct.getText().matches("^\\d+$")) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(txt_SearchProduct.getText()));
            if (sanPham != null) {
                addDataToListProduct(sanPham);
            } else {
                loadData();
            }
            cb_category.setSelectedIndex(-1);
        } else {
            ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
            for (SanPham sanPham : getAvailableProduct()) {
                if (sanPham.getTenSanPham().contains(txt_SearchProduct.getText())) {
                    if (danhSachSanPham.size() < 4) {
                        if (cb_category.getSelectedIndex() > -1) {
                            if (sanPham.getDanhMuc().equals(cb_category.getSelectedItem())) {
                                danhSachSanPham.add(sanPham);
                            }
                        } else {
                            danhSachSanPham.add(sanPham);
                        }

                    }
                }
            }
            if (danhSachSanPham.size() > 0) {
                loadProductItem(danhSachSanPham);
            } else {
                if (cb_category.getSelectedIndex() < 0) {
                    loadData();
                }
            }
        }
    }//GEN-LAST:event_txt_SearchProductKeyReleased

    private void cb_categoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_categoryItemStateChanged
        if (cb_category.getSelectedIndex() > -1) {
            txt_SearchProduct.setText("");
            this.infoPageCategory = 1;
            loadDataByCategory();
        } else {
            loadData();
        }
    }//GEN-LAST:event_cb_categoryItemStateChanged

    private void lbl_productImage1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productImage1MouseClicked
        if (evt.getClickCount() == 2) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(lbl_productImage1.getClientProperty("maSanPham") + ""));
            ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
            thongTinSanPham.setVisible(true);
            thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!thongTinSanPham.getTxt_quantity().getText().matches("^\\d+$")) {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                    } else {
                        int quantity = Integer.parseInt(thongTinSanPham.getTxt_quantity().getText());
                        if (quantity > 0) {
                            if (quantity > sanPham.getSoLuong()) {
                                JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                                return;
                            }
                            addProductToCart(sanPham, quantity);
                            thongTinSanPham.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }//GEN-LAST:event_lbl_productImage1MouseClicked

    private void lbl_productImage2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productImage2MouseClicked
        if (evt.getClickCount() == 2) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(lbl_productImage2.getClientProperty("maSanPham") + ""));
            ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
            thongTinSanPham.setVisible(true);
            thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!thongTinSanPham.getTxt_quantity().getText().matches("^\\d+$")) {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                    } else {
                        int quantity = Integer.parseInt(thongTinSanPham.getTxt_quantity().getText());
                        if (quantity > 0) {
                            if (quantity > sanPham.getSoLuong()) {
                                JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                                return;
                            }
                            addProductToCart(sanPham, quantity);
                            thongTinSanPham.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }//GEN-LAST:event_lbl_productImage2MouseClicked

    private void lbl_productImage3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productImage3MouseClicked
        if (evt.getClickCount() == 2) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(lbl_productImage3.getClientProperty("maSanPham") + ""));
            ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
            thongTinSanPham.setVisible(true);
            thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!thongTinSanPham.getTxt_quantity().getText().matches("^\\d+$")) {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                    } else {
                        int quantity = Integer.parseInt(thongTinSanPham.getTxt_quantity().getText());
                        if (quantity > 0) {
                            if (quantity > sanPham.getSoLuong()) {
                                JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                                return;
                            }
                            addProductToCart(sanPham, quantity);
                            thongTinSanPham.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }//GEN-LAST:event_lbl_productImage3MouseClicked

    private void lbl_productImage4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_productImage4MouseClicked
        if (evt.getClickCount() == 2) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(lbl_productImage4.getClientProperty("maSanPham") + ""));
            ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
            thongTinSanPham.setVisible(true);
            thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!thongTinSanPham.getTxt_quantity().getText().matches("^\\d+$")) {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                    } else {
                        int quantity = Integer.parseInt(thongTinSanPham.getTxt_quantity().getText());
                        if (quantity > 0) {
                            if (quantity > sanPham.getSoLuong()) {
                                JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                                return;
                            }
                            addProductToCart(sanPham, quantity);
                            thongTinSanPham.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(thongTinSanPham, "Số lượng phải là số dương!");
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                }

                @Override
                public void mouseExited(MouseEvent e) {
                }
            });
        }
    }//GEN-LAST:event_lbl_productImage4MouseClicked

    private void cb_customerIdSaleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_customerIdSaleItemStateChanged
        if (cb_customerIdSale.getSelectedIndex() > -1) {
            for (KhachHang khachHang : khachHangDAO.getAllKhachHang()) {
                if (cb_customerIdSale.getSelectedItem().equals(khachHang.getMaKH())) {
                    lbl_customerNameSale.setText(khachHang.getTenKH());
                    return;
                }
            }
        }
    }//GEN-LAST:event_cb_customerIdSaleItemStateChanged

    private void txt_customerPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customerPhoneActionPerformed

    private void jp_reloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_reloadMouseClicked
        txt_SearchProduct.setText("");
        cb_category.setSelectedIndex(-1);
        loadData();
    }//GEN-LAST:event_jp_reloadMouseClicked

    private void addDataToListProduct(SanPham sanPham) {
        lbl_productImage1.setIcon(createImageIcon(sanPham.getHinhAnh()));
        lbl_productItemName1.setText(sanPham.getTenSanPham());
        lbl_productItemQuantity1.setText(sanPham.getSoLuong() + "");
        lbl_productItemPrice1.setText(decimalFormat.format(sanPham.getGia()));
        pnl_productItem2.setVisible(false);
        pnl_productItem3.setVisible(false);
        pnl_productItem4.setVisible(false);
    }

    public ImageIcon createImageIcon(String url) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(url));
        } catch (IOException e) {
            return null;
        }

        // Scale ảnh để vừa với JLabel
        BufferedImage scaledImage = Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, 160, 150);
        return new ImageIcon(scaledImage);
    }

    public ArrayList<SanPham> getProductListByCategory() {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        for (SanPham sanPham : getAvailableProduct()) {
            if (sanPham.getDanhMuc().equals(cb_category.getSelectedItem())) {
                danhSachSanPham.add(sanPham);
            }
        }
        return danhSachSanPham;
    }

    public void loadDataByCategory() {
        int totalProduct = getProductListByCategory().size();
        lbl_infoPage.setText(infoPageCategory + "/" + (int) Math.ceil(totalProduct / 4.0));
        loadListProductByCategory(infoPageCategory * 4);
        if (infoPageCategory == 1 && infoPageCategory == (int) Math.ceil(totalProduct / 4.0)) {
            btn_previous.setEnabled(false);
            btn_next.setEnabled(false);
        } else if (infoPageCategory == 1) {
            btn_previous.setEnabled(false);
            btn_next.setEnabled(true);
        } else if (infoPageCategory == (int) Math.ceil(totalProduct / 4.0)) {
            btn_next.setEnabled(false);
            btn_previous.setEnabled(true);
        } else {
            btn_previous.setEnabled(true);
            btn_next.setEnabled(true);
        }
    }

    private void loadListProductByCategory(int start) {
        ArrayList<SanPham> danhSachSanPham = new ArrayList<>();
        for (int i = start - 4; i < start; i++) {
            if (i < getProductListByCategory().size()) {
                danhSachSanPham.add(getProductListByCategory().get(i));
            }
        }
        loadProductItem(danhSachSanPham);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JComboBox<String> cb_customerIdSale;
    private javax.swing.JCheckBox chkOrder;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelCart;
    private javax.swing.JPanel jPanelScanCode;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private util.JPanelRounded jpDelivery;
    private util.JPanelRounded jpPaySale;
    private util.JPanelRounded jpSearch;
    private util.JPanelRounded jp_reload;
    private javax.swing.JLabel lblCategory;
    private javax.swing.JLabel lblCreateInvoice;
    private javax.swing.JLabel lblCustomerId;
    private javax.swing.JLabel lblCustomerMoneyGive;
    private javax.swing.JLabel lblCustomerName;
    private javax.swing.JLabel lblCustomerName3;
    private javax.swing.JLabel lblCustomerName4;
    private javax.swing.JLabel lblDelete;
    private javax.swing.JLabel lblDeleteAll;
    private javax.swing.JLabel lblDiscount;
    private javax.swing.JLabel lblDiscount1;
    private javax.swing.JLabel lblEmployeeId1;
    private javax.swing.JLabel lblEmployeeId3;
    private javax.swing.JLabel lblEmployeeIdOrder;
    private javax.swing.JLabel lblEmployeeIdSale;
    private javax.swing.JLabel lblMustPay;
    private javax.swing.JLabel lblMustPay1;
    private javax.swing.JLabel lblNote;
    private javax.swing.JLabel lblNote2;
    private javax.swing.JLabel lblNote3;
    private javax.swing.JLabel lblOrderDate;
    private javax.swing.JLabel lblOrderDate1;
    private javax.swing.JLabel lblOrderDate2;
    private javax.swing.JLabel lblOrderId;
    private javax.swing.JLabel lblOrderId2;
    private javax.swing.JLabel lblPay1;
    private javax.swing.JLabel lblPay2;
    private javax.swing.JLabel lblProductPrice1;
    private javax.swing.JLabel lblProductPrice2;
    private javax.swing.JLabel lblProductPrice3;
    private javax.swing.JLabel lblProductPrice4;
    private javax.swing.JLabel lblProductQuantity2;
    private javax.swing.JLabel lblProductQuantity3;
    private javax.swing.JLabel lblProductQuantity4;
    private javax.swing.JLabel lblReturnMoneyToCustomer;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchProduct1;
    private javax.swing.JLabel lblTotalAmount;
    private javax.swing.JLabel lblTotalAmount1;
    private javax.swing.JLabel lblUnit1;
    private javax.swing.JLabel lblUnit10;
    private javax.swing.JLabel lblUnit11;
    private javax.swing.JLabel lblUnit12;
    private javax.swing.JLabel lblUnit2;
    private javax.swing.JLabel lblUnit3;
    private javax.swing.JLabel lblUnit4;
    private javax.swing.JLabel lblUnit5;
    private javax.swing.JTabbedPane lbl_;
    private javax.swing.JLabel lbl_customerNameOrder;
    private javax.swing.JLabel lbl_customerNameSale;
    private javax.swing.JLabel lbl_discountOrder;
    private javax.swing.JLabel lbl_discountSale;
    private javax.swing.JLabel lbl_infoPage;
    private javax.swing.JPanel lbl_listProduct;
    private javax.swing.JLabel lbl_mustPayOrder;
    private javax.swing.JLabel lbl_mustPaySale;
    private javax.swing.JLabel lbl_orderDateOrder;
    private javax.swing.JLabel lbl_orderIdOrder;
    private javax.swing.JLabel lbl_orderIdSale;
    private javax.swing.JLabel lbl_product;
    private javax.swing.JLabel lbl_productImage1;
    private javax.swing.JLabel lbl_productImage2;
    private javax.swing.JLabel lbl_productImage3;
    private javax.swing.JLabel lbl_productImage4;
    private javax.swing.JLabel lbl_productItemName1;
    private javax.swing.JLabel lbl_productItemName2;
    private javax.swing.JLabel lbl_productItemName3;
    private javax.swing.JLabel lbl_productItemName4;
    private javax.swing.JLabel lbl_productItemPrice1;
    private javax.swing.JLabel lbl_productItemPrice2;
    private javax.swing.JLabel lbl_productItemPrice3;
    private javax.swing.JLabel lbl_productItemPrice4;
    private javax.swing.JLabel lbl_productItemQuantity1;
    private javax.swing.JLabel lbl_productItemQuantity2;
    private javax.swing.JLabel lbl_productItemQuantity3;
    private javax.swing.JLabel lbl_productItemQuantity4;
    private javax.swing.JLabel lbl_totalAmountOrder;
    private javax.swing.JLabel lbl_totalAmountSale;
    private javax.swing.JLabel lblreturnMoneyToCustomerSale;
    private util.JPanelRounded pnlCreateInvoice;
    private util.JPanelRounded pnlDelete;
    private util.JPanelRounded pnlDeleteAll;
    private javax.swing.JPanel pnl_productItem1;
    private javax.swing.JPanel pnl_productItem2;
    private javax.swing.JPanel pnl_productItem3;
    private javax.swing.JPanel pnl_productItem4;
    private javax.swing.JScrollPane scr_Cart;
    private util.SVGImage svgCreateInvoice;
    private util.SVGImage svgDelete;
    private util.SVGImage svgDeleteAll;
    private util.SVGImage svgPay1;
    private util.SVGImage svgPay2;
    private util.SVGImage svgReload;
    private util.SVGImage svgSearch;
    private javax.swing.JPanel tb_Order;
    private javax.swing.JPanel tb_Sale;
    private javax.swing.JTable tbl_Cart;
    private javax.swing.JTextArea txa_customerDeliveryAddress;
    private javax.swing.JTextArea txa_noteOrder;
    private javax.swing.JTextArea txa_noteSale;
    private javax.swing.JTextField txt_SearchProduct;
    private javax.swing.JTextField txt_customerMoneyGive;
    private javax.swing.JTextField txt_customerPhone;
    // End of variables declaration//GEN-END:variables
}
