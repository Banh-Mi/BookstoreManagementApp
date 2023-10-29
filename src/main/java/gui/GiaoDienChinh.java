/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entity.NhanVien;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author BanhMi88
 */
public final class GiaoDienChinh extends javax.swing.JFrame {

    private NhanVien nhanVien;

    public GiaoDienChinh(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        initComponents();
        setThongTin();
        svgLogo.setSvgImage("logo.svg", 154, 65);
        execute();

    }

    public void setThongTin() {
        lbTen.setText(nhanVien.getTenNV());
        lbChucVu.setText(nhanVien.getChucVu());
    }

    private void execute() {
        String iconHome = "/menuItems/home.svg";
        String iconEmployee = "/menuItems/employee.svg";
        String iconCustomer = "/menuItems/customer.svg";
        String iconProduct = "/menuItems/product.svg";
        String iconSupplier = "/menuItems/supplier.svg";
        String iconInvoice = "/menuItems/invoice.svg";
        String iconLogout = "/menuItems/logout.svg";
        String iconAccount = "/menuItems/account.svg";
        String iconDiscount = "/menuItems/discount.svg";
        pnView.add(new JPanel_TrangChu());

        MenuItem menuQuanLyNV = new MenuItem(null, "Quản lý NV", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_NhanVien());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuTimNV = new MenuItem(null, "Tìm kiếm NV", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuPhanCa = new MenuItem(null, "Phân ca", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                  pnView.add(new JPanel_PhanCa());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuBanHang = new MenuItem(null, "Bán hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_BanHang(nhanVien.getMaNV()));
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuQuanLyKH = new MenuItem(null, "Quản lý KH", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhachHang());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuTimKiemKH = new MenuItem(null, "Tìm kiếm KH", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhachHangTK());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuQuanLySP = new MenuItem(null, "Quản lý SP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_SanPham());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuTimKiemSP = new MenuItem(null, "Tìm kiếm SP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemSanPham());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuQLNhaCC = new MenuItem(null, "Quản lý NCC", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_NhaCungCap());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuTimKiemNCC = new MenuItem(null, "Tìm kiếm NCC", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemNhaCungCap());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuQuanLyHD = new MenuItem(null, "Quản lý HĐ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPhanel_HoaDon());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuQuanLyTK = new MenuItem(null, "Quản lý tài khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                try {
                    pnView.add(new JPanel_TaiKhoan());
                } catch (SQLException ex) {
                    Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
                }
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuTimKiemTK = new MenuItem(null, "Tìm kiếm tài khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuQuanLyKM = new MenuItem(null, "Quản lý KM", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhuyenMai());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuTimKiemKM = new MenuItem(null, "Tìm kiếm KM", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhuyenMaiTK());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuHome = new MenuItem(iconHome, "Trang chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TrangChu());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuThongKe = new MenuItem(null, "Thống kê", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_ThongKeDoanhThu());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuDangXuat = new MenuItem(iconLogout, "Đăng Xuất", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    dangXuat();
                    new GiaoDienDangNhap().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

//        MenuItem menuThongKeDT = new MenuItem(null, "Thống kê DT", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                pnView.removeAll();
//                pnView.add(new JPanel_ThongKe());
//                pnView.repaint();
//                pnView.revalidate();
//            }
//        });
//        MenuItem menuThongKeKH = new MenuItem(null, "Thống kê KH", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                pnView.removeAll();
//                pnView.add(new JPanel_ThongKeKhachHang());
//                pnView.repaint();
//                pnView.revalidate();
//            }
//        });
//        MenuItem menuThongKeSP = new MenuItem(null, "Thống kê SP", new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                pnView.removeAll();
//                pnView.add(new JPanel_ThongKeSanPham());
//                pnView.repaint();
//                pnView.revalidate();
//            }
//        });
        if (nhanVien.getChucVu().equals("Quản lý")) {
            MenuItem menuEmployee = new MenuItem(iconEmployee, "Nhân viên", null, menuQuanLyNV, menuTimNV, menuPhanCa, menuBanHang, menuThongKe, menuQuanLyKM, menuTimKiemKM);
            MenuItem menuCustomer = new MenuItem(iconCustomer, "Khách hàng", null, menuQuanLyKH, menuTimKiemKH);
            MenuItem menuProduct = new MenuItem(iconProduct, "Sản phẩm", null, menuQuanLySP, menuTimKiemSP);
            MenuItem menuSupplier = new MenuItem(iconSupplier, "Nhà cung cấp", null, menuQLNhaCC, menuTimKiemNCC);
            MenuItem menuInvoice = new MenuItem(iconInvoice, "Hoá đơn", null, menuQuanLyHD);
            MenuItem menuAccount = new MenuItem(iconAccount, "Tài khoản", null, menuQuanLyTK, menuTimKiemTK);
            addMenu(menuHome, menuEmployee, menuCustomer, menuProduct, menuSupplier, menuInvoice, menuAccount, menuDangXuat);
        } else {
            MenuItem menuEmployee = new MenuItem(iconEmployee, "Nhân viên", null, menuBanHang, menuThongKe, menuQuanLyKM, menuTimKiemKM);
            MenuItem menuCustomer = new MenuItem(iconCustomer, "Khách hàng", null, menuQuanLyKH, menuTimKiemKH);
            MenuItem menuProduct = new MenuItem(iconProduct, "Sản phẩm", null, menuTimKiemSP);
            MenuItem menuInvoice = new MenuItem(iconInvoice, "Hoá đơn", null, menuQuanLyHD);
            addMenu(menuHome, menuEmployee, menuCustomer, menuProduct, menuInvoice, menuDangXuat);
        }

    }

    private void dangXuat() {
        this.setVisible(false);
    }

    private void addMenu(MenuItem... menu) {
        for (MenuItem menu1 : menu) {
            menus.add(menu1);
            ArrayList<MenuItem> subMenu = menu1.getSubMenu();
            for (MenuItem m : subMenu) {
                addMenu(m);
            }
        }
        menus.revalidate();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        pnView = new util.JPanelRounded();
        jPanelRounded1 = new util.JPanelRounded();
        svgLogo = new util.SVGImage();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        lbTen = new javax.swing.JLabel();
        lbChucVu = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setPreferredSize(new java.awt.Dimension(1300, 780));
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnView.setBackground(new java.awt.Color(255, 0, 0));
        pnView.setRoundedBottomLeft(15);
        pnView.setRoundedBottomRight(15);
        pnView.setRoundedTopLeft(15);
        pnView.setRoundedTopRight(15);
        pnView.setLayout(new java.awt.BorderLayout());
        pnMain.add(pnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 12, 1040, 760));

        jPanelRounded1.setBackground(new java.awt.Color(0, 122, 255));
        jPanelRounded1.setRoundedBottomLeft(15);
        jPanelRounded1.setRoundedBottomRight(15);
        jPanelRounded1.setRoundedTopLeft(15);
        jPanelRounded1.setRoundedTopRight(15);

        panelMenu.setBackground(new java.awt.Color(115, 120, 230));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 384));

        jScrollPane1.setBorder(null);

        menus.setBackground(new java.awt.Color(0, 122, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
        );

        lbTen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTen.setForeground(new java.awt.Color(255, 255, 255));

        lbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lbChucVu.setText("Chức vụ");

        javax.swing.GroupLayout jPanelRounded1Layout = new javax.swing.GroupLayout(jPanelRounded1);
        jPanelRounded1.setLayout(jPanelRounded1Layout);
        jPanelRounded1Layout.setHorizontalGroup(
            jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRounded1Layout.createSequentialGroup()
                .addGroup(jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRounded1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(svgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelRounded1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbChucVu, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelRounded1Layout.createSequentialGroup()
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanelRounded1Layout.setVerticalGroup(
            jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRounded1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(svgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 586, Short.MAX_VALUE)
                .addComponent(lbTen, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRounded1Layout.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 543, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(115, Short.MAX_VALUE)))
        );

        pnMain.add(jPanelRounded1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 12, 230, 760));

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        FlatLaf.registerCustomDefaultsSource("resources.themes");

        FlatMacLightLaf.setup();
        UIManager.put("Button.arc", 5);
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new GiaoDienChinh().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.JPanelRounded jPanelRounded1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lbTen;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel pnMain;
    private util.JPanelRounded pnView;
    private util.SVGImage svgLogo;
    // End of variables declaration//GEN-END:variables
}
