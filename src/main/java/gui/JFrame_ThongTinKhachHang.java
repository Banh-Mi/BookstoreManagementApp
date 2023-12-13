package gui;

import dao.KhachHangDAO;
import entity.KhachHang;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;

/**
 * @author Nguyễn Thanh Nhứt
 */
public class JFrame_ThongTinKhachHang extends javax.swing.JFrame {

    private DefaultTableModel modelKhachHang;
    private KhachHangDAO khachHangDao = new KhachHangDAO();

    public JFrame_ThongTinKhachHang() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        modelKhachHang = (DefaultTableModel) tbl_customerList.getModel();
        loadData();
        if(ngonNgu==2)
        {
            lbl_SearchCustomer.setText("Search Customer:");
            btn_select.setText("Choose");
        }
    }

    public void loadData() {
        modelKhachHang.setRowCount(0);
        for (KhachHang kh : khachHangDao.getAllKhachHang()) {
            Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(), kh.getEmail(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getTheVip(), kh.getNgayDangKy()};
            modelKhachHang.addRow(row);
        }
    }

    public DefaultTableModel getModelKhachHang() {
        return modelKhachHang;
    }

    public JTable getTbl_customerList() {
        return tbl_customerList;
    }

    public JButton getBtn_select() {
        return btn_select;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_customerList = new javax.swing.JPanel();
        scr_customerList = new javax.swing.JScrollPane();
        tbl_customerList = new javax.swing.JTable();
        txt_SearchCustomer = new javax.swing.JTextField();
        lbl_SearchCustomer = new javax.swing.JLabel();
        btn_select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_customerList.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scr_customerList.setPreferredSize(new java.awt.Dimension(452, 460));

        if(ngonNgu==2)
        {
            tbl_customerList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Customer ID", "Customer Name", "Phone Number", "Email", "Date of Birth", "Address", "Gender", "Membership Card", "Registration Date"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });
        }
        else
        {
            tbl_customerList.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Mã khách hàng", "Tên khách hàng", "SĐT", "Email", "Ngày sinh", "Địa chỉ", "Giới tính", "Thẻ thành viên", "Ngày Đăng ký"
                }
            ) {
                Class[] types = new Class [] {
                    java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
                };

                public Class getColumnClass(int columnIndex) {
                    return types [columnIndex];
                }
            });

        }
        scr_customerList.setViewportView(tbl_customerList);

        pnl_customerList.add(scr_customerList, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 880, 280));

        txt_SearchCustomer.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txt_SearchCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_SearchCustomerActionPerformed(evt);
            }
        });
        txt_SearchCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_SearchCustomerKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_SearchCustomerKeyReleased(evt);
            }
        });
        pnl_customerList.add(txt_SearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 40, 350, 30));

        lbl_SearchCustomer.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbl_SearchCustomer.setText("Tìm kiếm khách hàng:");
        pnl_customerList.add(lbl_SearchCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 160, 30));

        btn_select.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_select.setText("Chọn");
        btn_select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_selectMouseClicked(evt);
            }
        });
        pnl_customerList.add(btn_select, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 400, 80, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_customerList, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 462, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnl_customerList, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_SearchCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_SearchCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchCustomerActionPerformed

    private void txt_SearchCustomerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchCustomerKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_SearchCustomerKeyPressed

    private void txt_SearchCustomerKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_SearchCustomerKeyReleased
        ArrayList<KhachHang> danhSachKhachHang = new ArrayList<>();
        for (KhachHang khachHang : khachHangDao.getAllKhachHang()) {
            if (khachHang.getTenKH().contains(txt_SearchCustomer.getText())) {
                danhSachKhachHang.add(khachHang);
            }
        }
        if (danhSachKhachHang.size() > 0) {
            modelKhachHang.setRowCount(0);
            for (KhachHang kh : danhSachKhachHang) {
                Object[] row = {kh.getMaKH(), kh.getTenKH(), kh.getSoDienThoai(), kh.getEmail(), kh.getNgaySinh(), kh.getDiaChi(), kh.getGioiTinh(), kh.getTheVip(), kh.getNgayDangKy()};
                modelKhachHang.addRow(row);
            }
        } else {
            loadData();
        }
    }//GEN-LAST:event_txt_SearchCustomerKeyReleased

    private void btn_selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_selectMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_selectMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_select;
    private javax.swing.JLabel lbl_SearchCustomer;
    private javax.swing.JPanel pnl_customerList;
    private javax.swing.JScrollPane scr_customerList;
    private javax.swing.JTable tbl_customerList;
    private javax.swing.JTextField txt_SearchCustomer;
    // End of variables declaration//GEN-END:variables
}
