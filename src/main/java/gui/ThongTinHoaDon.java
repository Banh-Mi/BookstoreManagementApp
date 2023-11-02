package gui;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.SanPham;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class ThongTinHoaDon extends javax.swing.JFrame {

    private HoaDon hoaDon;
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private DefaultTableModel modelListProduct;
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public ThongTinHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
        initComponents();
        modelListProduct = (DefaultTableModel)tbl_productList.getModel();
        generateValue(hoaDon);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);
    }

    private void generateValue(HoaDon hoaDon) {
        if(hoaDon.getLoaiHoaDon().equals("Đặt hàng")){
            lbl_title.setText("HÓA ĐƠN ĐẶT HÀNG");
            lbl_pay.setVisible(false);
            jLabel20.setVisible(false);
        }
        KhachHang khachHang = khachHangDAO.search(hoaDon.getMaKH());
        lbl_orderId.setText(hoaDon.getMaHoaDon());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
        lbl_orderDate.setText(dateFormat.format(hoaDon.getNgayLapHoaDon()));
        lbl_customerName.setText(khachHang.getTenKH());
        if (khachHang.getMaKH().equals("KH000") && hoaDon.getLoaiHoaDon().equals("Bán hàng")) {
            lbl_customerPhone.setVisible(false);
            jLabel9.setVisible(false);
            jLabel2.setVisible(false);
            lbl_customerAddress.setVisible(false);
        } else {
            lbl_customerPhone.setText(hoaDon.getSoDienThoai());
            if (hoaDon.getLoaiHoaDon().equals("Đặt hàng")) {
                lbl_customerAddress.setText(hoaDon.getDiaChiGiaoHang());
            } else {
                lbl_customerAddress.setText(khachHang.getDiaChi());
            }
        }
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonDAO.selectbyId(hoaDon.getMaHoaDon())) {
            SanPham sanPham = sanPhamDAO.selectbyId(new SanPham(chiTietHoaDon.getMaSanPham()));
            String[] data = {sanPham.getMaSanPham(), sanPham.getTenSanPham(), chiTietHoaDon.getSoLuong()+"", nf.format(sanPham.getGia()), nf.format(sanPham.getGia() * chiTietHoaDon.getSoLuong())};
            modelListProduct.addRow(data);
        }
        lbl_employeeName.setText(nhanVienDAO.searchEmployee(hoaDon.getMaNV()).getTenNV());
        lbl_totalAmount.setText(nf.format(hoaDon.getTongTien()));
        lbl_discount.setText("0");
        lbl_pay.setText(nf.format(hoaDon.getTongTien()));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbl_title = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lbl_customerPhone = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        lbl_orderId = new javax.swing.JLabel();
        lbl_orderDate = new javax.swing.JLabel();
        lbl_customerName = new javax.swing.JLabel();
        lbl_customerAddress = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        lbl_totalAmount = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_discount = new javax.swing.JLabel();
        lbl_pay = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_employeeName = new javax.swing.JLabel();
        pnl_productList = new javax.swing.JPanel();
        scr_prosuctList = new javax.swing.JScrollPane();
        tbl_productList = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbl_title.setText("HÓA ĐƠN BÁN HÀNG");
        getContentPane().add(lbl_title, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, 40));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Số điện thoại:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 100, 30));

        jLabel3.setText("Số 12 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, Thành phố Hồ Chí Minh");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 60, 390, 30));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setText("Nhà Sách Thuận Lợi");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, 230, 40));

        lbl_customerPhone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_customerPhone.setText("0343098508");
        getContentPane().add(lbl_customerPhone, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 90, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Số hóa đơn: ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 100, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setText("Ngày tạo: ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("Khách hàng: ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 100, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Địa chỉ: ");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 100, 30));

        jLabel10.setText("Điện thoại: 0283.8940 390");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 90, 140, 30));

        lbl_orderId.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_orderId.setText("HD001");
        getContentPane().add(lbl_orderId, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 100, 30));

        lbl_orderDate.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_orderDate.setText("12/10/2023 12: 30 AM");
        getContentPane().add(lbl_orderDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 160, 30));

        lbl_customerName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_customerName.setText("Nguyễn Văn A");
        getContentPane().add(lbl_customerName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 160, 30));

        lbl_customerAddress.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_customerAddress.setText("Số 4, Nguyễn Văn Bảo, P.4, TP.HCM");
        getContentPane().add(lbl_customerAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 260, 30));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Tổng tiền:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 630, 80, 30));

        lbl_totalAmount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_totalAmount.setText("690.000");
        getContentPane().add(lbl_totalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 630, 130, 30));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Đã giảm:");
        getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 660, 100, 30));

        lbl_discount.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_discount.setText("0");
        getContentPane().add(lbl_discount, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 660, 130, 30));

        lbl_pay.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        lbl_pay.setText("0343098508");
        getContentPane().add(lbl_pay, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 690, 130, 30));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel20.setText("Thanh toán:");
        getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 690, 100, 30));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setText("Nhân viên lập hóa đơn");
        getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 630, 180, 30));

        lbl_employeeName.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbl_employeeName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_employeeName.setText("Nguyễn Thị B");
        getContentPane().add(lbl_employeeName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 660, 160, 30));

        pnl_productList.setLayout(new java.awt.BorderLayout());

        tbl_productList.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_prosuctList.setViewportView(tbl_productList);
        if (tbl_productList.getColumnModel().getColumnCount() > 0) {
            tbl_productList.getColumnModel().getColumn(0).setResizable(false);
        }

        pnl_productList.add(scr_prosuctList, java.awt.BorderLayout.CENTER);

        getContentPane().add(pnl_productList, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 720, 280));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_customerAddress;
    private javax.swing.JLabel lbl_customerName;
    private javax.swing.JLabel lbl_customerPhone;
    private javax.swing.JLabel lbl_discount;
    private javax.swing.JLabel lbl_employeeName;
    private javax.swing.JLabel lbl_orderDate;
    private javax.swing.JLabel lbl_orderId;
    private javax.swing.JLabel lbl_pay;
    private javax.swing.JLabel lbl_title;
    private javax.swing.JLabel lbl_totalAmount;
    private javax.swing.JPanel pnl_productList;
    private javax.swing.JScrollPane scr_prosuctList;
    private javax.swing.JTable tbl_productList;
    // End of variables declaration//GEN-END:variables
}
