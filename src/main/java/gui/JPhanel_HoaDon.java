package gui;

import dao.ChiTietHoaDonDAO;
import dao.HoaDonDAO;
import dao.KhachHangDAO;
import dao.NhanVienDAO;
import dao.SanPhamDAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.SanPham;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JPhanel_HoaDon extends javax.swing.JPanel {

    private DefaultTableModel modelOrder;
    private DefaultTableModel modelOrderDetail;
    private HoaDonDAO hoaDonDAO = new HoaDonDAO();
    private ChiTietHoaDonDAO chiTietHoaDonDAO = new ChiTietHoaDonDAO();
    private SanPhamDAO sanPhamDAO = new SanPhamDAO();
    private NhanVienDAO nhanVienDAO = new NhanVienDAO();
    private KhachHangDAO khachHangDAO = new KhachHangDAO();
    private NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("vi", "VN"));

    public JPhanel_HoaDon() {
        initComponents();
        modelOrder = (DefaultTableModel) tbl_Order.getModel();
        modelOrderDetail = (DefaultTableModel) tbl_OrderDetail.getModel();

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tbl_Order.getColumnModel().getColumn(8).setCellRenderer(rightRenderer);
        tbl_Order.getColumnModel().getColumn(9).setCellRenderer(rightRenderer);
        tbl_OrderDetail.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tbl_OrderDetail.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tbl_OrderDetail.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);

        cb_SearchStatus.setEnabled(false);

        loadData();
    }

    private void loadData() {
        modelOrder.setRowCount(0);
        modelOrderDetail.setRowCount(0);
        for (HoaDon hoaDon : hoaDonDAO.selectAll()) {
            String[] data = {hoaDon.getMaHoaDon(), hoaDon.getNgayLapHoaDon() + "", hoaDon.getMaNV(), nhanVienDAO.searchEmployee(hoaDon.getMaNV()).getTenNV(), hoaDon.getMaKH(), khachHangDAO.searchCustomer(hoaDon.getMaKH()).getTenKH(), hoaDon.getLoaiHoaDon(), hoaDon.getPhuongThucThanhToan(), "", nf.format(hoaDon.getTongTien()), hoaDon.getTrangThai(), hoaDon.getGhiChu()};
            modelOrder.addRow(data);
        }
    }

    private void addDataToTable(ArrayList<HoaDon> danhSachHoaDon) {
        modelOrder.setRowCount(0);
        modelOrderDetail.setRowCount(0);
        for (HoaDon hoaDon : danhSachHoaDon) {
            String[] data = {hoaDon.getMaHoaDon(), hoaDon.getNgayLapHoaDon() + "", hoaDon.getMaNV(), nhanVienDAO.searchEmployee(hoaDon.getMaNV()).getTenNV(), hoaDon.getMaKH(), khachHangDAO.searchCustomer(hoaDon.getMaKH()).getTenKH(), hoaDon.getLoaiHoaDon(), hoaDon.getPhuongThucThanhToan(), "", nf.format(hoaDon.getTongTien()), hoaDon.getTrangThai(), hoaDon.getGhiChu()};
            modelOrder.addRow(data);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel_Order = new javax.swing.JPanel();
        txt_SearchOrder = new javax.swing.JTextField();
        pnl_SearchByTime = new javax.swing.JPanel();
        jDateChooser_SearchByTimeTo = new com.toedter.calendar.JDateChooser();
        jDateChooser_SearchByTimeFrom = new com.toedter.calendar.JDateChooser();
        lbl_SearchSearchByTimeFrom = new javax.swing.JLabel();
        lbl_SearchByTimeTo = new javax.swing.JLabel();
        pnl_SearchStatus = new javax.swing.JPanel();
        cb_SearchStatus = new javax.swing.JComboBox<>();
        pnl_SearchTotalAmount = new javax.swing.JPanel();
        cb_SearchTotalAmount = new javax.swing.JComboBox<>();
        lbl_SearchOrder1 = new javax.swing.JLabel();
        scr_Order = new javax.swing.JScrollPane();
        tbl_Order = new javax.swing.JTable();
        pnl_SearchOrderCategory = new javax.swing.JPanel();
        cb_SearchOrderCategory = new javax.swing.JComboBox<>();
        jPanel_OrderDetail = new javax.swing.JPanel();
        scr_OrderDetail = new javax.swing.JScrollPane();
        tbl_OrderDetail = new javax.swing.JTable();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel_Order.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel_Order.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_SearchOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SearchOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchOrderActionPerformed(evt);
            }
        });
        txt_SearchOrder.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchOrderKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchOrderKeyReleased(evt);
            }
        });
        jPanel_Order.add(txt_SearchOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 30, 440, 30));

        pnl_SearchByTime.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thời gian", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchByTime.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jDateChooser_SearchByTimeTo.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser_SearchByTimeToPropertyChange(evt);
            }
        });
        pnl_SearchByTime.add(jDateChooser_SearchByTimeTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 120, 33));

        jDateChooser_SearchByTimeFrom.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jDateChooser_SearchByTimeFromMouseReleased(evt);
            }
        });
        jDateChooser_SearchByTimeFrom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                jDateChooser_SearchByTimeFromCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        jDateChooser_SearchByTimeFrom.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jDateChooser_SearchByTimeFromPropertyChange(evt);
            }
        });
        jDateChooser_SearchByTimeFrom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jDateChooser_SearchByTimeFromKeyReleased(evt);
            }
        });
        pnl_SearchByTime.add(jDateChooser_SearchByTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 110, 33));

        lbl_SearchSearchByTimeFrom.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SearchSearchByTimeFrom.setText("Từ");
        pnl_SearchByTime.add(lbl_SearchSearchByTimeFrom, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 30, 30));

        lbl_SearchByTimeTo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbl_SearchByTimeTo.setText("Đến");
        pnl_SearchByTime.add(lbl_SearchByTimeTo, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, 30, 30));

        jPanel_Order.add(pnl_SearchByTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 90, 320, 87));

        pnl_SearchStatus.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Trạng thái", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchStatus.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchStatus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_SearchStatus.setSelectedIndex(-1);
        cb_SearchStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_SearchStatusItemStateChanged(evt);
            }
        });
        cb_SearchStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchStatusActionPerformed(evt);
            }
        });
        pnl_SearchStatus.add(cb_SearchStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 33));

        jPanel_Order.add(pnl_SearchStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 90, 170, 87));

        pnl_SearchTotalAmount.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tổng tiền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchTotalAmount.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchTotalAmount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_SearchTotalAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0 - 200.000VNĐ", "200.000 - 500.000VNĐ", "500.000 - 1.000.000VNĐ", "Trên 1.000.000 VNĐ" }));
        cb_SearchTotalAmount.setSelectedIndex(-1);
        cb_SearchTotalAmount.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_SearchTotalAmountItemStateChanged(evt);
            }
        });
        cb_SearchTotalAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchTotalAmountActionPerformed(evt);
            }
        });
        pnl_SearchTotalAmount.add(cb_SearchTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 170, 33));

        jPanel_Order.add(pnl_SearchTotalAmount, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 211, 87));

        lbl_SearchOrder1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_SearchOrder1.setText("Tìm kiếm hóa đơn:");
        jPanel_Order.add(lbl_SearchOrder1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 130, 30));

        tbl_Order.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã hóa đơn", "Ngày lập", "Mã nhân viên", "Tên nhân viên", "Mã khách hàng", "Tên khách hàng", "Loại hóa đơn", "Phương thức thanh toán", "Giảm giá", "Tổng tiền", "Trạng thái", "Ghi chú"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl_Order.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_OrderMouseClicked(evt);
            }
        });
        scr_Order.setViewportView(tbl_Order);

        jPanel_Order.add(scr_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 960, 230));

        pnl_SearchOrderCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Loại hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12))); // NOI18N
        pnl_SearchOrderCategory.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cb_SearchOrderCategory.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cb_SearchOrderCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bán hàng", "Đặt hàng" }));
        cb_SearchOrderCategory.setSelectedIndex(-1);
        cb_SearchOrderCategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cb_SearchOrderCategoryItemStateChanged(evt);
            }
        });
        cb_SearchOrderCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cb_SearchOrderCategoryMouseClicked(evt);
            }
        });
        cb_SearchOrderCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_SearchOrderCategoryActionPerformed(evt);
            }
        });
        pnl_SearchOrderCategory.add(cb_SearchOrderCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 130, 33));

        jPanel_Order.add(pnl_SearchOrderCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 170, 87));

        add(jPanel_Order, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1000, 450));

        jPanel_OrderDetail.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa đơn chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 14))); // NOI18N
        jPanel_OrderDetail.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_OrderDetail.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Giá", "Số lượng", "Thành tiền"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scr_OrderDetail.setViewportView(tbl_OrderDetail);

        jPanel_OrderDetail.add(scr_OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 960, 200));

        add(jPanel_OrderDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 1000, 250));
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchOrderActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchOrderActionPerformed

    private void cb_SearchStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchStatusActionPerformed

    private void cb_SearchTotalAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchTotalAmountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchTotalAmountActionPerformed

    private void cb_SearchOrderCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_SearchOrderCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_SearchOrderCategoryActionPerformed

    private void tbl_OrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_OrderMouseClicked
        int row = tbl_Order.getSelectedRow();
        modelOrderDetail.setRowCount(0);
        for (ChiTietHoaDon chiTietHoaDon : chiTietHoaDonDAO.selectbyId(modelOrder.getValueAt(row, 0) + "")) {
            String[] data = {chiTietHoaDon.getMaSanPham(), sanPhamDAO.selectbyId(new SanPham(chiTietHoaDon.getMaSanPham())).getTenSanPham(), nf.format(chiTietHoaDon.getGia()), chiTietHoaDon.getSoLuong() + "", nf.format(chiTietHoaDon.getGia() * chiTietHoaDon.getSoLuong())};
            modelOrderDetail.addRow(data);
        }
    }//GEN-LAST:event_tbl_OrderMouseClicked

    private void txt_SearchOrderKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchOrderKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchOrderKeyPressed

    private void txt_SearchOrderKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchOrderKeyReleased
        cb_SearchOrderCategory.setSelectedIndex(-1);
        cb_SearchStatus.setSelectedIndex(-1);
        cb_SearchTotalAmount.setSelectedIndex(-1);
        jDateChooser_SearchByTimeTo.setDate(null);
        jDateChooser_SearchByTimeFrom.setDate(null);
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonDAO.selectAll()) {
            if (txt_SearchOrder.getText().equals(hoaDon.getMaHoaDon())) {
                danhSachHoaDon.add(hoaDon);
            }
        }
        if (danhSachHoaDon.size() > 0) {
            addDataToTable(danhSachHoaDon);
        } else {
            loadData();
        }
    }//GEN-LAST:event_txt_SearchOrderKeyReleased

    private void cb_SearchOrderCategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_SearchOrderCategoryItemStateChanged
        if (cb_SearchOrderCategory.getSelectedIndex() == -1) {
            cb_SearchStatus.setEnabled(false);
        } else {
            cb_SearchStatus.setEnabled(true);

            if (cb_SearchOrderCategory.getSelectedItem().equals("Bán hàng")) {
                cb_SearchStatus.removeAllItems();
                cb_SearchStatus.addItem("Chờ thanh toán");
                cb_SearchStatus.addItem("Đã thanh toán");
                cb_SearchStatus.addItem("Đã hủy");
                cb_SearchStatus.setSelectedIndex(-1);
            } else {
                cb_SearchStatus.removeAllItems();
                cb_SearchStatus.addItem("Đang giao");
                cb_SearchStatus.addItem("Đã thanh toán");
                cb_SearchStatus.addItem("Đã hủy");
                cb_SearchStatus.setSelectedIndex(-1);
            }
            cb_SearchTotalAmount.setSelectedIndex(-1);
            jDateChooser_SearchByTimeTo.setDate(null);
            jDateChooser_SearchByTimeFrom.setDate(null);
            txt_SearchOrder.setText("");
            ArrayList<HoaDon> danhSachHoaDon = getListOrderByCategory(cb_SearchOrderCategory.getSelectedItem() + "");
            if (danhSachHoaDon.size() > 0) {
                addDataToTable(danhSachHoaDon);
            }
        }
    }//GEN-LAST:event_cb_SearchOrderCategoryItemStateChanged

    private void cb_SearchOrderCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cb_SearchOrderCategoryMouseClicked
        // TODO add  your handling code here:
    }//GEN-LAST:event_cb_SearchOrderCategoryMouseClicked

    private void cb_SearchStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_SearchStatusItemStateChanged
        if (cb_SearchStatus.getSelectedIndex() >= 0) {
            ArrayList<HoaDon> danhSachHoaDon = getListOrderByCategory(cb_SearchOrderCategory.getSelectedItem() + "");
            cb_SearchTotalAmount.setSelectedIndex(-1);
            jDateChooser_SearchByTimeTo.setDate(null);
            jDateChooser_SearchByTimeFrom.setDate(null);
            txt_SearchOrder.setText("");
            addDataToTable(getListOrderByStatus(danhSachHoaDon, cb_SearchStatus.getSelectedItem() + ""));
        }
    }//GEN-LAST:event_cb_SearchStatusItemStateChanged

    private void cb_SearchTotalAmountItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cb_SearchTotalAmountItemStateChanged
        if (cb_SearchTotalAmount.getSelectedIndex() >= 0) {
            jDateChooser_SearchByTimeTo.setDate(null);
            jDateChooser_SearchByTimeFrom.setDate(null);
            txt_SearchOrder.setText("");

            if (cb_SearchOrderCategory.getSelectedIndex() < 0) {
                addDataToTable(getListOrderByTotalAmount(hoaDonDAO.selectAll(), cb_SearchTotalAmount.getSelectedIndex()));
            } else {
                ArrayList<HoaDon> danhSachHoaDon = getListOrderByCategory(cb_SearchOrderCategory.getSelectedItem() + "");
                danhSachHoaDon = getListOrderByStatus(danhSachHoaDon, cb_SearchStatus.getSelectedItem() + "");
                addDataToTable(getListOrderByTotalAmount(danhSachHoaDon, cb_SearchTotalAmount.getSelectedIndex()));
            }
        }
    }//GEN-LAST:event_cb_SearchTotalAmountItemStateChanged

    private void jDateChooser_SearchByTimeFromCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_jDateChooser_SearchByTimeFromCaretPositionChanged
    }//GEN-LAST:event_jDateChooser_SearchByTimeFromCaretPositionChanged

    private void jDateChooser_SearchByTimeFromKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jDateChooser_SearchByTimeFromKeyReleased
    }//GEN-LAST:event_jDateChooser_SearchByTimeFromKeyReleased

    private void jDateChooser_SearchByTimeFromMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jDateChooser_SearchByTimeFromMouseReleased
    }//GEN-LAST:event_jDateChooser_SearchByTimeFromMouseReleased

    private void jDateChooser_SearchByTimeFromPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser_SearchByTimeFromPropertyChange
        if (jDateChooser_SearchByTimeFrom.getDate() != null) {
            if (cb_SearchOrderCategory.getSelectedIndex() < 0) {
                cb_SearchTotalAmount.setSelectedIndex(-1);
                txt_SearchOrder.setText("");
                if (jDateChooser_SearchByTimeTo.getDate() != null) {
                    addDataToTable(getListOrderByTime(hoaDonDAO.selectAll()));
                }
            } else {
                if (jDateChooser_SearchByTimeTo.getDate() != null) {
                    ArrayList<HoaDon> danhSachHoaDon = getListOrderByCategory(cb_SearchOrderCategory.getSelectedItem() + "");
                    danhSachHoaDon = getListOrderByStatus(danhSachHoaDon, cb_SearchStatus.getSelectedItem() + "");
                    danhSachHoaDon = getListOrderByTotalAmount(danhSachHoaDon, cb_SearchTotalAmount.getSelectedIndex());
                    addDataToTable(getListOrderByTime(danhSachHoaDon));
                }
            }

        }
    }//GEN-LAST:event_jDateChooser_SearchByTimeFromPropertyChange

    private void jDateChooser_SearchByTimeToPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jDateChooser_SearchByTimeToPropertyChange
        if (jDateChooser_SearchByTimeTo.getDate() != null) {
            if (cb_SearchOrderCategory.getSelectedIndex() < 0) {
                cb_SearchTotalAmount.setSelectedIndex(-1);
                txt_SearchOrder.setText("");
                if (jDateChooser_SearchByTimeFrom.getDate() != null) {
                    addDataToTable(getListOrderByTime(hoaDonDAO.selectAll()));
                }
            } else {
                if (jDateChooser_SearchByTimeFrom.getDate() != null) {
                    ArrayList<HoaDon> danhSachHoaDon = getListOrderByCategory(cb_SearchOrderCategory.getSelectedItem() + "");
                    danhSachHoaDon = getListOrderByStatus(danhSachHoaDon, cb_SearchStatus.getSelectedItem() + "");
                    danhSachHoaDon = getListOrderByTotalAmount(danhSachHoaDon, cb_SearchTotalAmount.getSelectedIndex());
                    addDataToTable(getListOrderByTime(danhSachHoaDon));
                }
            }

        }
    }//GEN-LAST:event_jDateChooser_SearchByTimeToPropertyChange

    public ArrayList<HoaDon> getListOrderByCategory(String loaiHoaDon) {
        ArrayList<HoaDon> danhSachHoaDon = new ArrayList<>();
        for (HoaDon hoaDon : hoaDonDAO.selectAll()) {
            if (loaiHoaDon.equals(hoaDon.getLoaiHoaDon())) {
                danhSachHoaDon.add(hoaDon);
            }
        }
        return danhSachHoaDon;
    }

    public ArrayList<HoaDon> getListOrderByStatus(ArrayList<HoaDon> danhSachHoaDon, String status) {
        ArrayList<HoaDon> danhSachHoaDonNew = new ArrayList<>();
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getTrangThai().equals(status)) {
                danhSachHoaDonNew.add(hoaDon);
            }
        }
        return danhSachHoaDonNew;
    }

    public ArrayList<HoaDon> getListOrderByTotalAmount(ArrayList<HoaDon> danhSachHoaDon, int index) {
        ArrayList<HoaDon> danhSachHoaDonNew = new ArrayList<>();
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (index == 0 && hoaDon.getTongTien() >= 0 && hoaDon.getTongTien() <= 200000) {
                danhSachHoaDonNew.add(hoaDon);
            } else if (index == 1 && hoaDon.getTongTien() >= 200000 && hoaDon.getTongTien() <= 500000) {
                danhSachHoaDonNew.add(hoaDon);
            } else if (index == 2 && hoaDon.getTongTien() >= 500000 && hoaDon.getTongTien() <= 1000000) {
                danhSachHoaDonNew.add(hoaDon);
            } else if (index == 3 && hoaDon.getTongTien() > 1000000) {
                danhSachHoaDonNew.add(hoaDon);
            }
        }
        return danhSachHoaDonNew;
    }

    public ArrayList<HoaDon> getListOrderByTime(ArrayList<HoaDon> danhSachHoaDon) {
        ArrayList<HoaDon> danhSachHoaDonNew = new ArrayList<>();
        Date dateFrom = jDateChooser_SearchByTimeFrom.getDate();
        Date dateTo = jDateChooser_SearchByTimeTo.getDate();
        // Chuyển đổi ngày thành đầu ngày và cuối ngày tương ứng
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dateFrom);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        dateFrom = calendar.getTime();

        calendar.setTime(dateTo);
        calendar.set(calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 999);
        dateTo = calendar.getTime();
        for (HoaDon hoaDon : danhSachHoaDon) {
            if (hoaDon.getNgayLapHoaDon().compareTo(dateFrom) >= 0 && hoaDon.getNgayLapHoaDon().compareTo(dateTo) <= 0) {
                danhSachHoaDonNew.add(hoaDon);
            }
        }
        return danhSachHoaDonNew;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_SearchOrderCategory;
    private javax.swing.JComboBox<String> cb_SearchStatus;
    private javax.swing.JComboBox<String> cb_SearchTotalAmount;
    private com.toedter.calendar.JDateChooser jDateChooser_SearchByTimeFrom;
    private com.toedter.calendar.JDateChooser jDateChooser_SearchByTimeTo;
    private javax.swing.JPanel jPanel_Order;
    private javax.swing.JPanel jPanel_OrderDetail;
    private javax.swing.JLabel lbl_SearchByTimeTo;
    private javax.swing.JLabel lbl_SearchOrder1;
    private javax.swing.JLabel lbl_SearchSearchByTimeFrom;
    private javax.swing.JPanel pnl_SearchByTime;
    private javax.swing.JPanel pnl_SearchOrderCategory;
    private javax.swing.JPanel pnl_SearchStatus;
    private javax.swing.JPanel pnl_SearchTotalAmount;
    private javax.swing.JScrollPane scr_Order;
    private javax.swing.JScrollPane scr_OrderDetail;
    private javax.swing.JTable tbl_Order;
    private javax.swing.JTable tbl_OrderDetail;
    private javax.swing.JTextField txt_SearchOrder;
    // End of variables declaration//GEN-END:variables
}
