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
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.imgscalr.Scalr;
import util.Email;
import util.ExportPDF;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JPanel_BanHang extends javax.swing.JPanel {

    private Webcam webcam = Webcam.getDefault();
    private WebcamPanel webcamPanel = new WebcamPanel(webcam);
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
    private int totalAmount = 0;
    private int discount = 0;

    public JPanel_BanHang(String maNhanVien) {
        this.maNhanVien = maNhanVien;
        initComponents();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                scanCode();
            }
        });
        thread.start();

        modelCart = (DefaultTableModel) tbl_Cart.getModel();
        modelCart.setRowCount(0);

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl_Cart.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tbl_Cart.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tbl_Cart.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
        tbl_Cart.setEnabled(false);
        svgDelivery.setSvgImage("delivery.svg", 30, 30);
        svgPay1.setSvgImage("pay.svg", 30, 30);
        svgSearch.setSvgImage("search.svg", 20, 20);
        svgCreateInvoice.setSvgImage("add.svg", 30, 30);
        svgDelete.setSvgImage("delete.svg", 30, 30);
        svgDeleteAll.setSvgImage("delete.svg", 30, 30);
        svgReload.setSvgImage("refresh.svg", 20, 20);
        svgSelectCustomer.setSvgImage("select.svg", 15, 15);

        setCursor();
        refreshOrderSale();
        refreshOrder();

        loadData();
    }

    private void refreshOrderSale() {
        this.totalAmount = 0;
        this.discount = 0;
        pnlSelectCustomer.setEnabled(false);
        jpPaySale.setEnabled(false);
        txt_customerMoneyGive.setEnabled(false);
        txa_noteSale.setEnabled(false);
        lbl_orderIdSale.setText("");
        lblOrderDate.setText("");
        lbl_employeeIdSale.setText("");
        lbl_customerIdSale.setText("");
        lbl_customerNameSale.setText("");
        lbl_totalAmountSale.setText("0");
        lbl_mustPay.setText("0");
        txt_customerMoneyGive.setText("0");
        lbl_returnMoneyToCustomer.setText("0");
        txa_noteSale.setText("");
        pnlCreateInvoice.setEnabled(true);
        webcamPanel.pause(); // Tạm dừng hoạt động của panel webcam
        webcam.close();
    }

    private void refreshOrder() {
        this.totalAmount = 0;
        this.discount = 0;
        jpDelivery.setEnabled(false);
        txt_customerPhone.setEnabled(false);
        txa_customerDeliveryAddress.setEnabled(false);
        txa_noteOrder.setEnabled(false);
        lbl_orderIdOrder.setText("");
        lbl_orderDateOrder.setText("");
        lbl_employeeIdOrder.setText("");
        lbl_customerNameOrder.setText("");
        txt_customerPhone.setText("");
        txa_customerDeliveryAddress.setText("");
        lbl_totalAmountOrder.setText("0");
        lbl_discountOrder.setText("0");
        lbl_mustPayOrder.setText("0");
        txa_noteOrder.setText("");
        pnlCreateInvoice.setEnabled(true);
        webcamPanel.pause(); // Tạm dừng hoạt động của panel webcam
        webcam.close();
    }

    public void scanCode() {

        webcamPanel.setFPSDisplayed(true);
//        webcamPanel.setDisplayDebugInfo(true);
        webcamPanel.setImageSizeDisplayed(true);
        webcamPanel.setMirrored(false); // Đừng đảo ngược hình ảnh

        pnl_scanCode.add(webcamPanel, BorderLayout.CENTER);
        pnl_scanCode.repaint();
        pnl_scanCode.revalidate();
        while (true) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
            }
            if (!pnlCreateInvoice.isEnabled()) {
                BufferedImage image = webcam.getImage();
                Result result = decodeBarcode(image);
                if (result != null) {
                    System.out.println(result.getText());
                    SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(result.getText()));
                    if (sanPham != null) {
                        ThongTinSanPham thongTinSanPham = new ThongTinSanPham(sanPham.getMaSanPham());
                        thongTinSanPham.setVisible(true);
                        thongTinSanPham.getJpAdd().addMouseListener(new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                if (!pnlCreateInvoice.isEnabled()) {
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
                                } else {
                                    JOptionPane.showMessageDialog(thongTinSanPham, "Vui lòng tạo hóa đơn để thêm sản phẩm vào giỏ hàng!");
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
        totalAmount = (int) (totalAmount + sanPham.getGia() * quantity);
        if (!lbl_orderIdSale.getText().equals("")) {
            lbl_totalAmountSale.setText(decimalFormat.format(totalAmount));
            lbl_mustPay.setText(decimalFormat.format(totalAmount - discount));
            if (!txt_customerMoneyGive.getText().equals("0")) {
                txt_customerMoneyGive.setText(txt_customerMoneyGive.getText().replace(",", ""));
                try {
                    lbl_returnMoneyToCustomer.setText(decimalFormat.format(Integer.valueOf(txt_customerMoneyGive.getText()) - (totalAmount - discount)));
                    txt_customerMoneyGive.setText(decimalFormat.format((Integer.valueOf(txt_customerMoneyGive.getText()))));

                } catch (Exception e) {
                    lbl_returnMoneyToCustomer.setText("Lỗi!");
                }
            }
        } else {
            lbl_totalAmountOrder.setText(decimalFormat.format(totalAmount));
            lbl_mustPayOrder.setText(decimalFormat.format(totalAmount - discount));
        }
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_scanCode = new javax.swing.JPanel();
        jPanelCart = new javax.swing.JPanel();
        scr_cart = new javax.swing.JScrollPane();
        tbl_Cart = new javax.swing.JTable();
        txt_SearchProduct = new javax.swing.JTextField();
        lblCategory = new javax.swing.JLabel();
        lbl_infoPage = new javax.swing.JLabel();
        cb_category = new javax.swing.JComboBox<>();
        btn_next = new javax.swing.JButton();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnl_salePay = new javax.swing.JPanel();
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
        lbl_returnMoneyToCustomer = new javax.swing.JLabel();
        lblUnit5 = new javax.swing.JLabel();
        lblUnit4 = new javax.swing.JLabel();
        lblUnit3 = new javax.swing.JLabel();
        lblUnit2 = new javax.swing.JLabel();
        lblUnit1 = new javax.swing.JLabel();
        lbl_totalAmountSale = new javax.swing.JLabel();
        lblValueDiscount = new javax.swing.JLabel();
        lbl_mustPay = new javax.swing.JLabel();
        lblNote = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txa_noteSale = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lblOrderId = new javax.swing.JLabel();
        lbl_orderIdSale = new javax.swing.JLabel();
        lbl_employeeIdSale = new javax.swing.JLabel();
        lblEmployeeId = new javax.swing.JLabel();
        lblCustomerId = new javax.swing.JLabel();
        lblCustomerName = new javax.swing.JLabel();
        lbl_customerNameSale = new javax.swing.JLabel();
        lblOrderDate1 = new javax.swing.JLabel();
        lblOrderDate = new javax.swing.JLabel();
        lbl_customerIdSale = new javax.swing.JLabel();
        pnlSelectCustomer = new util.JPanelRounded();
        lblSelectCustomer = new javax.swing.JLabel();
        svgSelectCustomer = new util.SVGImage();
        chk_waitPay = new javax.swing.JCheckBox();
        pnl_orderPage = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        lblOrderId2 = new javax.swing.JLabel();
        lbl_orderIdOrder = new javax.swing.JLabel();
        lblOrderDate2 = new javax.swing.JLabel();
        lblEmployeeId2 = new javax.swing.JLabel();
        lblCustomerName3 = new javax.swing.JLabel();
        lblNote3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txa_customerDeliveryAddress = new javax.swing.JTextArea();
        lbl_orderDateOrder = new javax.swing.JLabel();
        lblCustomerName4 = new javax.swing.JLabel();
        txt_customerPhone = new javax.swing.JTextField();
        lbl_employeeIdOrder = new javax.swing.JLabel();
        lbl_customerNameOrder = new javax.swing.JLabel();
        s = new javax.swing.JPanel();
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
        svgDelivery = new util.SVGImage();
        pnl_deleteAll = new util.JPanelRounded();
        lblDeleteAll = new javax.swing.JLabel();
        svgDeleteAll = new util.SVGImage();
        jPanel5 = new javax.swing.JPanel();
        pnl_productItem1 = new javax.swing.JPanel();
        lbl_productItemPrice1 = new javax.swing.JLabel();
        lblProductPrice1 = new javax.swing.JLabel();
        lblProductQuantity1 = new javax.swing.JLabel();
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

        pnl_scanCode.setLayout(new java.awt.BorderLayout());
        add(pnl_scanCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 250, 140));
        pnl_scanCode.getAccessibleContext().setAccessibleName("");

        jPanelCart.setLayout(new java.awt.BorderLayout());

        tbl_Cart.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_Cart.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_Cart.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tbl_Cart.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_CartMouseClicked(evt);
            }
        });
        scr_cart.setViewportView(tbl_Cart);

        jPanelCart.add(scr_cart, java.awt.BorderLayout.CENTER);

        add(jPanelCart, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 850, 230));

        txt_SearchProduct.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_SearchProduct.setText("8900767778797");
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
        add(txt_SearchProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 420, 130, 30));

        lblCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCategory.setText("Danh mục:");
        add(lblCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 420, -1, 30));

        lbl_infoPage.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_infoPage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_infoPage.setText("1/4");
        add(lbl_infoPage, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 820, 40, 30));

        cb_category.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        cb_category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sách", "Dụng cụ học tập", "Văn phòng phẩm", "Đồ chơi", "Quà lưu niệm" }));
        cb_category.setSelectedIndex(-1);
        cb_category.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        add(cb_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 420, 150, 30));

        btn_next.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_next.setText(">>");
        btn_next.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });
        add(btn_next, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 820, 60, 30));

        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        pnl_salePay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jpPaySale.add(lblPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgPay1.setText(" ");
        jpPaySale.add(svgPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        pnl_salePay.add(jpPaySale, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 730, 120, 40));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalAmount.setText("Tổng tiền:");
        jPanel2.add(lblTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 110, 30));

        lblDiscount.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiscount.setText("Giảm giá:");
        jPanel2.add(lblDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 110, 30));

        lblMustPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMustPay.setText("Phải trả:");
        jPanel2.add(lblMustPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 30));

        lblCustomerMoneyGive.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerMoneyGive.setText("Tiền khách đưa:");
        jPanel2.add(lblCustomerMoneyGive, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, 30));

        lblReturnMoneyToCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblReturnMoneyToCustomer.setText("Trả lại khách:");
        jPanel2.add(lblReturnMoneyToCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 110, 30));

        txt_customerMoneyGive.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_customerMoneyGive.setText("0");
        txt_customerMoneyGive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerMoneyGiveActionPerformed(evt);
            }
        });
        txt_customerMoneyGive.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_customerMoneyGiveKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_customerMoneyGiveKeyTyped(evt);
            }
        });
        jPanel2.add(txt_customerMoneyGive, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 190, 140, 30));

        lbl_returnMoneyToCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_returnMoneyToCustomer.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_returnMoneyToCustomer.setText("0");
        jPanel2.add(lbl_returnMoneyToCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 140, 30));

        lblUnit5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit5.setText("VNĐ");
        jPanel2.add(lblUnit5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 30, 30));

        lblUnit4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit4.setText("VNĐ");
        jPanel2.add(lblUnit4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 30, 30));

        lblUnit3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUnit3.setForeground(new java.awt.Color(255, 51, 51));
        lblUnit3.setText("VNĐ");
        jPanel2.add(lblUnit3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 40, 30));

        lblUnit2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit2.setText("VNĐ");
        jPanel2.add(lblUnit2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 90, 30, 30));

        lblUnit1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit1.setText("VNĐ");
        jPanel2.add(lblUnit1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 30, 30));

        lbl_totalAmountSale.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_totalAmountSale.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_totalAmountSale.setText("0");
        jPanel2.add(lbl_totalAmountSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 140, 30));

        lblValueDiscount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblValueDiscount.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblValueDiscount.setText("0");
        jPanel2.add(lblValueDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 140, 30));

        lbl_mustPay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_mustPay.setForeground(new java.awt.Color(255, 51, 51));
        lbl_mustPay.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_mustPay.setText("0");
        jPanel2.add(lbl_mustPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, 140, 30));

        lblNote.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote.setText("Ghi chú:");
        jPanel2.add(lblNote, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 110, 30));

        txa_noteSale.setColumns(20);
        txa_noteSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txa_noteSale.setRows(5);
        jScrollPane1.setViewportView(txa_noteSale);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, 180, 100));

        pnl_salePay.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 340, 410));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrderId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOrderId.setText("Mã đơn hàng:");
        jPanel4.add(lblOrderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 30));

        lbl_orderIdSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lbl_orderIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 160, 30));

        lbl_employeeIdSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lbl_employeeIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 160, 30));

        lblEmployeeId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeId.setText("Mã nhân viên:");
        jPanel4.add(lblEmployeeId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 30));

        lblCustomerId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerId.setText("Mã khách hàng:");
        jPanel4.add(lblCustomerId, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        lblCustomerName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerName.setText("Tên khách hàng:");
        jPanel4.add(lblCustomerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 30));

        lbl_customerNameSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lbl_customerNameSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 160, 30));

        lblOrderDate1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOrderDate1.setText("Ngày tạo:");
        jPanel4.add(lblOrderDate1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        lblOrderDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lblOrderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 160, 30));

        lbl_customerIdSale.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel4.add(lbl_customerIdSale, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 80, 30));

        pnlSelectCustomer.setBackground(new java.awt.Color(255, 255, 255));
        pnlSelectCustomer.setRoundedBottomLeft(10);
        pnlSelectCustomer.setRoundedBottomRight(10);
        pnlSelectCustomer.setRoundedTopLeft(10);
        pnlSelectCustomer.setRoundedTopRight(10);
        pnlSelectCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlSelectCustomerMouseClicked(evt);
            }
        });
        pnlSelectCustomer.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblSelectCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSelectCustomer.setText("Chọn");
        pnlSelectCustomer.add(lblSelectCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 40, 30));

        svgSelectCustomer.setText(" ");
        pnlSelectCustomer.add(svgSelectCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        jPanel4.add(pnlSelectCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 180, 70, 30));

        pnl_salePay.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 290));

        chk_waitPay.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        chk_waitPay.setText("Chờ thanh toán");
        chk_waitPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk_waitPayActionPerformed(evt);
            }
        });
        pnl_salePay.add(chk_waitPay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 730, 110, 40));

        jTabbedPane2.addTab("Đơn hàng", pnl_salePay);

        pnl_orderPage.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chung", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOrderId2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOrderId2.setText("Mã đơn hàng:");
        jPanel12.add(lblOrderId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 30));

        lbl_orderIdOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel12.add(lbl_orderIdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 170, 30));

        lblOrderDate2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblOrderDate2.setText("Ngày tạo:");
        jPanel12.add(lblOrderDate2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 120, 30));

        lblEmployeeId2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblEmployeeId2.setText("Mã nhân viên:");
        jPanel12.add(lblEmployeeId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 120, 30));

        lblCustomerName3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerName3.setText("Tên khách hàng:");
        jPanel12.add(lblCustomerName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 120, 30));

        lblNote3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote3.setText("Địa chỉ:");
        jPanel12.add(lblNote3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 120, 30));

        txa_customerDeliveryAddress.setColumns(20);
        txa_customerDeliveryAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txa_customerDeliveryAddress.setRows(5);
        jScrollPane4.setViewportView(txa_customerDeliveryAddress);

        jPanel12.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 170, 90));

        lbl_orderDateOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel12.add(lbl_orderDateOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 170, 30));

        lblCustomerName4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCustomerName4.setText("Số điện thoại:");
        jPanel12.add(lblCustomerName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 120, 30));

        txt_customerPhone.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_customerPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_customerPhoneActionPerformed(evt);
            }
        });
        txt_customerPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_customerPhoneKeyReleased(evt);
            }
        });
        jPanel12.add(txt_customerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 170, 30));

        lbl_employeeIdOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel12.add(lbl_employeeIdOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 170, 30));

        lbl_customerNameOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel12.add(lbl_customerNameOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, 30));

        pnl_orderPage.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, 380));

        s.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        s.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTotalAmount1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotalAmount1.setText("Tổng tiền:");
        s.add(lblTotalAmount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, 30));

        lblDiscount1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDiscount1.setText("Giảm giá:");
        s.add(lblDiscount1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        lblMustPay1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblMustPay1.setText("Phải trả:");
        s.add(lblMustPay1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, 30));

        lblUnit10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblUnit10.setForeground(new java.awt.Color(255, 51, 51));
        lblUnit10.setText("VNĐ");
        s.add(lblUnit10, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 40, 30));

        lblUnit11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit11.setText("VNĐ");
        s.add(lblUnit11, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 30, 30));

        lblUnit12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblUnit12.setText("VNĐ");
        s.add(lblUnit12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 30, 30, 30));

        lbl_totalAmountOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_totalAmountOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_totalAmountOrder.setText("0");
        s.add(lbl_totalAmountOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 120, 30));

        lbl_discountOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_discountOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_discountOrder.setText("0");
        s.add(lbl_discountOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 120, 30));

        lbl_mustPayOrder.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_mustPayOrder.setForeground(new java.awt.Color(255, 51, 51));
        lbl_mustPayOrder.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbl_mustPayOrder.setText("0");
        s.add(lbl_mustPayOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 120, 30));

        lblNote2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblNote2.setText("Ghi chú:");
        s.add(lblNote2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 90, 30));

        txa_noteOrder.setColumns(20);
        txa_noteOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txa_noteOrder.setRows(5);
        jScrollPane3.setViewportView(txa_noteOrder);

        s.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 170, 100));

        pnl_orderPage.add(s, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 340, 300));

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

        svgDelivery.setText(" ");
        jpDelivery.add(svgDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 30, 30));

        pnl_orderPage.add(jpDelivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 720, 130, 40));

        jTabbedPane2.addTab("Đặt hàng", pnl_orderPage);

        add(jTabbedPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 360, 820));

        pnl_deleteAll.setBackground(new java.awt.Color(255, 255, 255));
        pnl_deleteAll.setRoundedBottomLeft(10);
        pnl_deleteAll.setRoundedBottomRight(10);
        pnl_deleteAll.setRoundedTopLeft(10);
        pnl_deleteAll.setRoundedTopRight(10);
        pnl_deleteAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_deleteAllMouseClicked(evt);
            }
        });
        pnl_deleteAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblDeleteAll.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDeleteAll.setText("Xóa tất cả");
        pnl_deleteAll.add(lblDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 80, 40));

        svgDeleteAll.setText(" ");
        pnl_deleteAll.add(svgDeleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 30, 30));

        add(pnl_deleteAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 100, 120, 40));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách sản phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_productItem1.setPreferredSize(new java.awt.Dimension(171, 250));
        pnl_productItem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemPrice1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice1.setText("2.000.000");
        pnl_productItem1.add(lbl_productItemPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        lblProductPrice1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductPrice1.setText("Giá:");
        pnl_productItem1.add(lblProductPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblProductQuantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductQuantity1.setText("Số lượng:");
        pnl_productItem1.add(lblProductQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        lbl_productItemQuantity1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemQuantity1.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity1.setText("1.000");
        pnl_productItem1.add(lbl_productItemQuantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 50, 30));

        lbl_productItemName1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_productItemName1.setText("Đệ nhất kiếm tiền");
        pnl_productItem1.add(lbl_productItemName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 30));

        lbl_productImage1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_productImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage1MouseClicked(evt);
            }
        });
        pnl_productItem1.add(lbl_productImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 170));

        jPanel5.add(pnl_productItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, 290));

        pnl_productItem2.setPreferredSize(new java.awt.Dimension(171, 250));
        pnl_productItem2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemPrice2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice2.setText("2.000.000");
        pnl_productItem2.add(lbl_productItemPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        lblProductPrice2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductPrice2.setText("Giá:");
        pnl_productItem2.add(lblProductPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblProductQuantity2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductQuantity2.setText("Số lượng:");
        pnl_productItem2.add(lblProductQuantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        lbl_productItemQuantity2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemQuantity2.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity2.setText("1.000");
        pnl_productItem2.add(lbl_productItemQuantity2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 50, 30));

        lbl_productItemName2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_productItemName2.setText("Đệ nhất kiếm tiền");
        pnl_productItem2.add(lbl_productItemName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 30));

        lbl_productImage2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_productImage2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage2MouseClicked(evt);
            }
        });
        pnl_productItem2.add(lbl_productImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 170));

        jPanel5.add(pnl_productItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 190, 290));

        pnl_productItem3.setPreferredSize(new java.awt.Dimension(171, 250));
        pnl_productItem3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemPrice3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice3.setText("2.000.000");
        pnl_productItem3.add(lbl_productItemPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        lblProductPrice4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductPrice4.setText("Giá:");
        pnl_productItem3.add(lblProductPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblProductQuantity4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductQuantity4.setText("Số lượng:");
        pnl_productItem3.add(lblProductQuantity4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        lbl_productItemQuantity3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemQuantity3.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity3.setText("1.000");
        pnl_productItem3.add(lbl_productItemQuantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 50, 30));

        lbl_productItemName3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_productItemName3.setText("Đệ nhất kiếm tiền");
        pnl_productItem3.add(lbl_productItemName3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 30));

        lbl_productImage3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_productImage3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage3MouseClicked(evt);
            }
        });
        pnl_productItem3.add(lbl_productImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 170));

        jPanel5.add(pnl_productItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, 190, 290));

        pnl_productItem4.setPreferredSize(new java.awt.Dimension(171, 250));
        pnl_productItem4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_productItemPrice4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemPrice4.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemPrice4.setText("2.000.000");
        pnl_productItem4.add(lbl_productItemPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 260, 90, 30));

        lblProductPrice3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductPrice3.setText("Giá:");
        pnl_productItem4.add(lblProductPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, 30));

        lblProductQuantity3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblProductQuantity3.setText("Số lượng:");
        pnl_productItem4.add(lblProductQuantity3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, 30));

        lbl_productItemQuantity4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_productItemQuantity4.setForeground(new java.awt.Color(255, 51, 51));
        lbl_productItemQuantity4.setText("1.000");
        pnl_productItem4.add(lbl_productItemQuantity4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 230, 50, 30));

        lbl_productItemName4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_productItemName4.setText("Đệ nhất kiếm tiền");
        pnl_productItem4.add(lbl_productItemName4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 30));

        lbl_productImage4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_productImage4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_productImage4MouseClicked(evt);
            }
        });
        pnl_productItem4.add(lbl_productImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 170, 170));

        jPanel5.add(pnl_productItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 30, 190, 290));

        add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 830, 340));

        btn_previous.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_previous.setText("<<");
        btn_previous.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_previous.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_previousActionPerformed(evt);
            }
        });
        add(btn_previous, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 820, 60, 30));

        lblSearchProduct1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearchProduct1.setText("Tìm kiếm sản phẩm:");
        add(lblSearchProduct1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 420, -1, 30));

        chkOrder.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        chkOrder.setText("Đặt hàng");
        chkOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        chkOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkOrderActionPerformed(evt);
            }
        });
        add(chkOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 100, 40));

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

        lblSearch.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblSearch.setText("Tìm");
        jpSearch.add(lblSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 30, 30));

        svgSearch.setText(" ");
        jpSearch.add(svgSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 20, 20));

        add(jpSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 420, -1, 30));

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

        lblDelete.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblDelete.setText("Xóa");
        pnlDelete.add(lblDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 50, 40));

        svgDelete.setText(" ");
        pnlDelete.add(svgDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 30, 30));

        add(pnlDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 100, 80, 40));

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

        lblCreateInvoice.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblCreateInvoice.setText("Tạo hóa đơn");
        pnlCreateInvoice.add(lblCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 0, 90, 40));

        svgCreateInvoice.setText(" ");
        pnlCreateInvoice.add(svgCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 30, 30));

        add(pnlCreateInvoice, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 40, 130, 40));

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
        jp_reload.add(svgReload, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 6, 20, 20));

        add(jp_reload, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 820, 50, 30));
    }// </editor-fold>//GEN-END:initComponents

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

    private void pnl_deleteAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_deleteAllMouseClicked
        if (tbl_Cart.getRowCount() > 0) {
            this.totalAmount = 0;
            this.discount = 0;
            if (JOptionPane.showConfirmDialog(this, "Bạn chắc chắn muốn xóa toàn bộ giỏ hàng?", "Cảnh báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                for (int i = 0; i < modelCart.getRowCount(); i++) {
                    SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(modelCart.getValueAt(i, 1) + ""));
                    sanPham.setSoLuong(sanPham.getSoLuong() + Integer.valueOf((modelCart.getValueAt(i, 3) + "")));
                    sanPhamDAO.update(sanPham);
                    if (!lbl_orderIdSale.getText().equals("")) {
                        lbl_totalAmountSale.setText(totalAmount + "");
                        lbl_mustPay.setText((totalAmount - discount) + "");
                    } else {
                        lbl_totalAmountOrder.setText(decimalFormat.format(totalAmount));
                        lbl_mustPayOrder.setText(decimalFormat.format(totalAmount - discount));
                    }
                }
                JOptionPane.showMessageDialog(this, "Đã xóa thành công!");
                modelCart.setRowCount(0);
                loadData();
            }
        }
    }//GEN-LAST:event_pnl_deleteAllMouseClicked

    private void jpPaySaleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpPaySaleMouseClicked
        if (jpPaySale.isEnabled()) {
            if (lbl_totalAmountSale.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm để thanh toán!");
            } else if (lbl_returnMoneyToCustomer.getText().charAt(0) == '-' || txt_customerMoneyGive.getText().equals("0")) {
                JOptionPane.showMessageDialog(this, "Không thể thanh toán. Tiền khách đưa chưa đủ!");
            } else {
                String maHoaDon = lbl_orderIdSale.getText();
                String maKH = lbl_customerIdSale.getText();
                String maNV = lbl_employeeIdSale.getText();
                String maKhuyenMai = null;
                String phuongThucThanhToan = "Tiền mặt";
                Date ngayLapHoaDon = Date.valueOf(LocalDateTime.parse(lblOrderDate.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a")).toLocalDate());
                String loaiHoaDon = "Bán hàng";
                String soDienThoai = (maKH.equals("KH000") ? null : khachHangDAO.search(maKH).getSoDienThoai());
                String diaChiGiaoHang = null;
                String trangThai = "Đã thanh toán";
                String ghiChu = txa_noteSale.getText();
                if (chk_waitPay.isSelected()) {
                    trangThai = "Chờ thanh toán";
                }

                HoaDon hoaDon = new HoaDon(maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, loaiHoaDon, soDienThoai, diaChiGiaoHang, trangThai, ghiChu);

                if (hoaDonDAO.insert(hoaDon) > 0) {
                    for (int i = 0; i < modelCart.getRowCount(); i++) {
                        String maSanPham = modelCart.getValueAt(i, 1) + "";
                        int soLuong = Integer.valueOf(modelCart.getValueAt(i, 3) + "");
                        double gia = sanPhamDAO.selectbyId(new SanPham(maSanPham)).getGia();
                        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, gia);
                        chiTietHoaDonDAO.insert(chiTietHoaDon);
                    }
                    if (JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không?", "Nhận hóa đơn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ThongTinHoaDon thongTinHoaDon = new ThongTinHoaDon(hoaDon);
                        thongTinHoaDon.setVisible(true);
                        ExportPDF.exportPDF(thongTinHoaDon, "D:\\" + hoaDon.getMaHoaDon() + ".pdf");
                        thongTinHoaDon.setVisible(false);
                    }
                    if (!hoaDon.getMaKH().equals("KH000")) {
                        Email.sendEmail(khachHangDAO.search(maKH).getEmail(), "Cảm ơn bạn đã mua hàng tại cửa hàng!", getEmailContentSale(hoaDon));
                    }
                    JOptionPane.showMessageDialog(this, "Thanh toán thành công");
                    refreshOrderSale();

                    modelCart.setRowCount(0);
                } else {
                    JOptionPane.showMessageDialog(this, "Thanh toán thất bại vui lòng thử lại sau!");
                    refreshOrderSale();
                }
            }
        }
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
        if (txt_customerPhone.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng số điện thoại khách hàng");
        } else if (txa_customerDeliveryAddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập địa chỉ của khách hàng");
        } else {
            String maHoaDon = lbl_orderIdOrder.getText();
            String maKH = (lbl_customerNameOrder.getText().equals("Khách hàng bán lẻ")) ? "KH000" : khachHangDAO.searchByPhone(txt_customerPhone.getText()).getMaKH();
            String maNV = lbl_employeeIdOrder.getText();
            String maKhuyenMai = null;
            String phuongThucThanhToan = "Tiền mặt";
            Date ngayLapHoaDon = Date.valueOf(LocalDateTime.parse(lbl_orderDateOrder.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a")).toLocalDate());
            String loaiHoaDon = "Đặt hàng";
            String soDienThoai = txt_customerPhone.getText();
            String diaChiGiaoHang = txa_customerDeliveryAddress.getText();
            String trangThai = "Đang giao";
            String ghiChu = txa_noteSale.getText();
            if (JOptionPane.showConfirmDialog(this, "Bạn đã gọi điện và xác nhận với khách hàng?", "Xác nhận", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {

                HoaDon hoaDon = new HoaDon(maHoaDon, maKH, maNV, maKhuyenMai, phuongThucThanhToan, ngayLapHoaDon, loaiHoaDon, soDienThoai, diaChiGiaoHang, trangThai, ghiChu);

                if (hoaDonDAO.insert(hoaDon) > 0) {
                    for (int i = 0; i < modelCart.getRowCount(); i++) {
                        String maSanPham = modelCart.getValueAt(i, 1) + "";
                        int soLuong = Integer.valueOf(modelCart.getValueAt(i, 3) + "");
                        double gia = sanPhamDAO.selectbyId(new SanPham(maSanPham)).getGia();
                        ChiTietHoaDon chiTietHoaDon = new ChiTietHoaDon(maHoaDon, maSanPham, soLuong, gia);
                        chiTietHoaDonDAO.insert(chiTietHoaDon);
                    }
                    if (JOptionPane.showConfirmDialog(this, "Bạn có muốn in hóa đơn không?", "Nhận hóa đơn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ThongTinHoaDon thongTinHoaDon = new ThongTinHoaDon(hoaDon);
                        thongTinHoaDon.setVisible(true);
                        ExportPDF.exportPDF(thongTinHoaDon, "D:\\" + hoaDon.getMaHoaDon() + ".pdf");
                        thongTinHoaDon.setVisible(false);
                    }
                    if (!hoaDon.getMaKH().equals("KH000")) {
                        Email.sendEmail(khachHangDAO.search(maKH).getEmail(), "Thông báo về đơn hàng", getEmailContentOrder(hoaDon));
                    }
                    JOptionPane.showMessageDialog(this, "Hóa đơn đặt hàng đã được tạo thành công và sẵn sàng để giao hàng!");
                    refreshOrder();

                    modelCart.setRowCount(0);

                } else {
                    JOptionPane.showMessageDialog(this, "Tạo hóa đơn thất bại vui lòng thử lại sau!");
                    refreshOrderSale();
                }
            }
        }
    }//GEN-LAST:event_jpDeliveryMouseClicked

    private void chkOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkOrderActionPerformed

    private void jpSearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpSearchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jpSearchMouseClicked

    private void pnlDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlDeleteMouseClicked
        if (tbl_Cart.getRowCount() > 0) {
            int row = tbl_Cart.getSelectedRow();
            if (row < 0) {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn sản phẩm cần xóa khỏi giỏ hàng!");
            } else {
                SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(modelCart.getValueAt(row, 1) + ""));
                sanPham.setSoLuong(sanPham.getSoLuong() + Integer.valueOf((modelCart.getValueAt(row, 3) + "")));

                totalAmount = (int) (totalAmount - (int) Integer.valueOf((modelCart.getValueAt(row, 3) + "")) * sanPham.getGia());
                if (!lbl_orderIdSale.getText().equals("")) {
                    lbl_totalAmountSale.setText(decimalFormat.format(totalAmount));
                    lbl_mustPay.setText(decimalFormat.format(totalAmount - discount));
                } else {
                    lbl_totalAmountOrder.setText(decimalFormat.format(totalAmount));
                    lbl_mustPayOrder.setText(decimalFormat.format(totalAmount - discount));
                }

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
        }
    }//GEN-LAST:event_pnlDeleteMouseClicked

    private void pnlCreateInvoiceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlCreateInvoiceMouseClicked
        if (pnlCreateInvoice.isEnabled()) {
            webcam.open(); // Mở webcam trước khi hiển thị
            webcamPanel.start();
            webcamPanel.resume();
            pnlCreateInvoice.setEnabled(false);
            tbl_Cart.setEnabled(true);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm a");
            if (!chkOrder.isSelected()) {
                // Set enable fields
                pnlSelectCustomer.setEnabled(true);
                jpPaySale.setEnabled(true);
                txt_customerMoneyGive.setEnabled(true);
                txa_noteSale.setEnabled(true);
                lbl_orderIdSale.setText(hoaDonDAO.createOrderId());
                lblOrderDate.setText(formatter.format(LocalDateTime.now()));
                lbl_employeeIdSale.setText(maNhanVien);
                lbl_customerIdSale.setText("KH000");
                lbl_customerNameSale.setText("Khách hàng bán lẻ");
            } else {
                jpDelivery.setEnabled(true);
                txt_customerPhone.setEnabled(true);
                txa_customerDeliveryAddress.setEnabled(true);
                txa_noteOrder.setEnabled(true);
                lbl_orderIdOrder.setText(hoaDonDAO.createOrderId());
                lbl_orderDateOrder.setText(formatter.format(LocalDateTime.now()));
                lbl_employeeIdOrder.setText(maNhanVien);
                lbl_customerNameOrder.setText("Khách hàng bán lẻ");
            }
        }
    }//GEN-LAST:event_pnlCreateInvoiceMouseClicked

    private void jp_reloadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jp_reloadMouseClicked
        txt_SearchProduct.setText("");
        cb_category.setSelectedIndex(-1);
        loadData();
    }//GEN-LAST:event_jp_reloadMouseClicked

    private void txt_customerPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_customerPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_customerPhoneActionPerformed

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
                    if (!pnlCreateInvoice.isEnabled()) {
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
                    } else {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Vui lòng tạo hóa đơn để thêm sản phẩm vào giỏ hàng!");
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
                    if (!pnlCreateInvoice.isEnabled()) {
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
                    } else {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Vui lòng tạo hóa đơn để thêm sản phẩm vào giỏ hàng!");
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
                    if (!pnlCreateInvoice.isEnabled()) {
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
                    } else {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Vui lòng tạo hóa đơn để thêm sản phẩm vào giỏ hàng!");
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
                    if (!pnlCreateInvoice.isEnabled()) {
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
                    } else {
                        JOptionPane.showMessageDialog(thongTinSanPham, "Vui lòng tạo hóa đơn để thêm sản phẩm vào giỏ hàng!");
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

    private void pnlSelectCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlSelectCustomerMouseClicked
        if (pnlSelectCustomer.isEnabled()) {
            ThongTinKhachHang thongTinKhachHang = new ThongTinKhachHang();
            thongTinKhachHang.setVisible(true);
            thongTinKhachHang.getBtn_select().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = thongTinKhachHang.getTbl_customerList().getSelectedRow();
                    if (row < 0) {
                        JOptionPane.showMessageDialog(thongTinKhachHang, "Vui lòng chọn khách hàng!");
                    } else {
                        lbl_customerIdSale.setText(thongTinKhachHang.getModelKhachHang().getValueAt(row, 0) + "");
                        lbl_customerNameSale.setText(thongTinKhachHang.getModelKhachHang().getValueAt(row, 1) + "");
                        thongTinKhachHang.setVisible(false);
                    }
                }
            });
        }
    }//GEN-LAST:event_pnlSelectCustomerMouseClicked

    private void txt_customerMoneyGiveKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customerMoneyGiveKeyReleased
        if (txt_customerMoneyGive.getText().matches("^\\d[\\d\\,]*$")) {
            txt_customerMoneyGive.setText(txt_customerMoneyGive.getText().replace(",", ""));
            try {
                lbl_returnMoneyToCustomer.setText(decimalFormat.format(Integer.valueOf(txt_customerMoneyGive.getText()) - (totalAmount - discount)));
                txt_customerMoneyGive.setText(decimalFormat.format((Integer.valueOf(txt_customerMoneyGive.getText()))));

            } catch (Exception e) {
                lbl_returnMoneyToCustomer.setText("Lỗi!");
            }
        } else {
            lbl_returnMoneyToCustomer.setText("Lỗi!");
        }
    }//GEN-LAST:event_txt_customerMoneyGiveKeyReleased

    private void txt_customerMoneyGiveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customerMoneyGiveKeyTyped

    }//GEN-LAST:event_txt_customerMoneyGiveKeyTyped

    private void chk_waitPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk_waitPayActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chk_waitPayActionPerformed

    private void txt_customerPhoneKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_customerPhoneKeyReleased
        if (txt_customerPhone.getText().matches("^\\d+$")) {
            if (txt_customerPhone.getText().matches("^(\\d{10})|(\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4})$")) {
                for (KhachHang khachHang : khachHangDAO.getAllKhachHang()) {
                    if (khachHang.getSoDienThoai().equals(txt_customerPhone.getText())) {
                        lbl_customerNameOrder.setText(khachHang.getTenKH());
                        txa_customerDeliveryAddress.setText(khachHang.getDiaChi());
                        return;
                    }
                }
                lbl_customerNameOrder.setText("Khách hàng bán lẻ");
                txa_customerDeliveryAddress.setText("");
            }
        } else {
            lbl_customerNameOrder.setText("Lỗi");
        }
    }//GEN-LAST:event_txt_customerPhoneKeyReleased

    private void tbl_CartMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_CartMouseClicked
        if (evt.getClickCount() == 2) {
            int row = tbl_Cart.getSelectedRow();
            String quanity = JOptionPane.showInputDialog(this, "Nhập số lượng bạn muốn thay đổi");
            if (quanity != null) {
                if (!quanity.matches("^\\d+$")) {
                    JOptionPane.showMessageDialog(this, "Số lượng phải là số dương!");
                } else {
                    int oldValue = Integer.valueOf(modelCart.getValueAt(row, 3) + "");
                    int newValue = Integer.valueOf(quanity);
                    if (newValue > 0) {
                        SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(modelCart.getValueAt(row, 1) + ""));
                        if (newValue - oldValue > sanPham.getSoLuong()) {
                            JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                        } else {
                            if (newValue < oldValue) {
                                int changeValue = oldValue - newValue;
                                sanPham.setSoLuong(sanPham.getSoLuong() + changeValue);
                                sanPhamDAO.update(sanPham);
                                modelCart.setValueAt(newValue, row, 3);
                                modelCart.setValueAt(nf.format(newValue * sanPham.getGia()), row, 5);

                                totalAmount = (int) totalAmount - changeValue * (int) sanPham.getGia();

                                if (!lbl_orderIdSale.getText().equals("")) {
                                    lbl_totalAmountSale.setText(decimalFormat.format(totalAmount));
                                    lbl_mustPay.setText(decimalFormat.format(totalAmount - discount));
                                } else {
                                    lbl_totalAmountOrder.setText(decimalFormat.format(totalAmount));
                                    lbl_mustPayOrder.setText(decimalFormat.format(totalAmount - discount));
                                }
                                JOptionPane.showMessageDialog(this, "Cập nhật số lượng thành công");
                                loadData();
                            } else if (newValue > oldValue) {
                                int changeValue = newValue - oldValue;
                                sanPham.setSoLuong(sanPham.getSoLuong() - changeValue);
                                sanPhamDAO.update(sanPham);
                                modelCart.setValueAt(newValue, row, 3);
                                modelCart.setValueAt(nf.format(newValue * sanPham.getGia()), row, 5);

                                totalAmount = (int) totalAmount + changeValue * (int) sanPham.getGia();

                                if (!lbl_orderIdSale.getText().equals("")) {
                                    lbl_totalAmountSale.setText(decimalFormat.format(totalAmount));
                                    lbl_mustPay.setText(decimalFormat.format(totalAmount - discount));
                                } else {
                                    lbl_totalAmountOrder.setText(decimalFormat.format(totalAmount));
                                    lbl_mustPayOrder.setText(decimalFormat.format(totalAmount - discount));
                                }

                                JOptionPane.showMessageDialog(this, "Cập nhật số lượng thành công");
                                loadData();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Số lượng sản phẩm trong kho không đủ để đáp ứng yêu cầu của bạn. Vui lòng nhập số lượng nhỏ hơn!");
                    }
                }
            }
        }
    }//GEN-LAST:event_tbl_CartMouseClicked

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

    public String getEmailContentSale(HoaDon hoaDon) {
        KhachHang khachHang = khachHangDAO.search(hoaDon.getMaKH());
        String emailContent = "<html> <head> <style> table { border-collapse: collapse; width: 100%; } th, td { border: 1px solid black; padding: 8px; text-align: left; } </style> </head> <body><p>Xin chào <strong>" + khachHang.getTenKH() + "</strong></p><p>Cảm ơn bạn đã mua hàng tại cửa hàng của chúng tôi. Dưới đây là chi tiết đơn hàng của bạn:</p><table><tr><th>Sản phẩm</th><th>Số lượng</th><th>Giá</th></tr>";
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonDAO.selectbyId(hoaDon.getMaHoaDon())) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(chiTietHoaDon.getMaSanPham()));
            emailContent += "<tr><td>" + sanPham.getTenSanPham() + "</td><td>" + chiTietHoaDon.getSoLuong() + "</td><td>" + nf.format(sanPham.getGia()) + "</td></tr>";
        }
        emailContent += "</table><p>Tổng tiền: " + nf.format(hoaDon.getTongTien()) + "</p><p>Hãy liên hệ với chúng tôi nếu bạn có bất kỳ câu hỏi hoặc yêu cầu hỗ trợ nào khác.</p><p>Trân trọng,</p><p><b>Nhà Sách Thuận Lợi</b></p></body></html>";
        return emailContent;
    }

    public String getEmailContentOrder(HoaDon hoaDon) {
        KhachHang khachHang = khachHangDAO.search(hoaDon.getMaKH());
        String emailContent = "<html> <head> <style> table { border-collapse: collapse; width: 100%; } th, td { border: 1px solid black; padding: 8px; text-align: left; } </style> </head> <body><p>Cảm ơn bạn đã đặt hàng! Đơn hàng của bạn đã được xác nhận và đang được giao đến bạn.</p><p>Xin vui lòng kiểm tra email hoặc hệ thống thông báo để cập nhật trạng thái vận chuyển của đơn hàng.</p> Dưới đây là chi tiết đơn hàng của bạn:</p><table><tr><th>Sản phẩm</th><th>Số lượng</th><th>Giá</th></tr>";
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonDAO.selectbyId(hoaDon.getMaHoaDon())) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(chiTietHoaDon.getMaSanPham()));
            emailContent += "<tr><td>" + sanPham.getTenSanPham() + "</td><td>" + chiTietHoaDon.getSoLuong() + "</td><td>" + nf.format(sanPham.getGia()) + "</td></tr>";
        }
        emailContent += "</table><p>Tổng tiền: " + nf.format(hoaDon.getTongTien()) + "</p><p>Nếu bạn có bất kỳ câu hỏi hoặc thắc mắc nào, xin vui lòng liên hệ với chúng tôi.</p><p>Cảm ơn bạn đã tin tưởng và sử dụng dịch vụ của chúng tôi!</p><p>Trân trọng,</p><p><b>Nhà Sách Thuận Lợi</b></p></body></html>";
        return emailContent;
    }

    private void setCursor() {
        pnlCreateInvoice.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (pnlCreateInvoice.isEnabled()) {
                    pnlCreateInvoice.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                pnlCreateInvoice.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        pnlSelectCustomer.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (pnlSelectCustomer.isEnabled()) {
                    pnlSelectCustomer.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                pnlSelectCustomer.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        jpPaySale.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (jpPaySale.isEnabled()) {
                    jpPaySale.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                pnl_salePay.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        jpDelivery.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (jpDelivery.isEnabled()) {
                    jpDelivery.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                jpDelivery.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        pnlDelete.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (tbl_Cart.getRowCount() > 0) {
                    pnlDelete.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                pnlDelete.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        pnl_deleteAll.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                if (tbl_Cart.getRowCount() > 0) {
                    pnl_deleteAll.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }
            }

            public void mouseExited(MouseEvent e) {
                pnl_deleteAll.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
        jp_reload.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                jp_reload.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            public void mouseExited(MouseEvent e) {
                jp_reload.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_next;
    private javax.swing.JButton btn_previous;
    private javax.swing.JComboBox<String> cb_category;
    private javax.swing.JCheckBox chkOrder;
    private javax.swing.JCheckBox chk_waitPay;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelCart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
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
    private javax.swing.JLabel lblEmployeeId;
    private javax.swing.JLabel lblEmployeeId2;
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
    private javax.swing.JLabel lblProductQuantity1;
    private javax.swing.JLabel lblProductQuantity2;
    private javax.swing.JLabel lblProductQuantity3;
    private javax.swing.JLabel lblProductQuantity4;
    private javax.swing.JLabel lblReturnMoneyToCustomer;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JLabel lblSearchProduct1;
    private javax.swing.JLabel lblSelectCustomer;
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
    private javax.swing.JLabel lblValueDiscount;
    private javax.swing.JLabel lbl_customerIdSale;
    private javax.swing.JLabel lbl_customerNameOrder;
    private javax.swing.JLabel lbl_customerNameSale;
    private javax.swing.JLabel lbl_discountOrder;
    private javax.swing.JLabel lbl_employeeIdOrder;
    private javax.swing.JLabel lbl_employeeIdSale;
    private javax.swing.JLabel lbl_infoPage;
    private javax.swing.JLabel lbl_mustPay;
    private javax.swing.JLabel lbl_mustPayOrder;
    private javax.swing.JLabel lbl_orderDateOrder;
    private javax.swing.JLabel lbl_orderIdOrder;
    private javax.swing.JLabel lbl_orderIdSale;
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
    private javax.swing.JLabel lbl_returnMoneyToCustomer;
    private javax.swing.JLabel lbl_totalAmountOrder;
    private javax.swing.JLabel lbl_totalAmountSale;
    private util.JPanelRounded pnlCreateInvoice;
    private util.JPanelRounded pnlDelete;
    private util.JPanelRounded pnlSelectCustomer;
    private util.JPanelRounded pnl_deleteAll;
    private javax.swing.JPanel pnl_orderPage;
    private javax.swing.JPanel pnl_productItem1;
    private javax.swing.JPanel pnl_productItem2;
    private javax.swing.JPanel pnl_productItem3;
    private javax.swing.JPanel pnl_productItem4;
    private javax.swing.JPanel pnl_salePay;
    private javax.swing.JPanel pnl_scanCode;
    private javax.swing.JPanel s;
    private javax.swing.JScrollPane scr_cart;
    private util.SVGImage svgCreateInvoice;
    private util.SVGImage svgDelete;
    private util.SVGImage svgDeleteAll;
    private util.SVGImage svgDelivery;
    private util.SVGImage svgPay1;
    private util.SVGImage svgReload;
    private util.SVGImage svgSearch;
    private util.SVGImage svgSelectCustomer;
    private javax.swing.JTable tbl_Cart;
    private javax.swing.JTextArea txa_customerDeliveryAddress;
    private javax.swing.JTextArea txa_noteOrder;
    private javax.swing.JTextArea txa_noteSale;
    private javax.swing.JTextField txt_SearchProduct;
    private javax.swing.JTextField txt_customerMoneyGive;
    private javax.swing.JTextField txt_customerPhone;
    // End of variables declaration//GEN-END:variables
}
