/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import entity.NhanVien;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import static gui.JFrame_GiaoDienDangNhap.ngonNgu;
import javax.swing.JOptionPane;

/**
 *
 * @author BanhMi88
 */
public final class JFrame_GiaoDienChinh extends javax.swing.JFrame {

    private NhanVien nhanVien;
    private JPanel jpanel_banHang;

    public JFrame_GiaoDienChinh(NhanVien nhanVien) {
        this.nhanVien = nhanVien;
        jpanel_banHang = new JPanel_BanHang(nhanVien.getMaNV());
        initComponents();

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setThongTin();
        svgLogo.setSvgImage("logo.svg", 170, 74);
        execute();

    }

    public void setThongTin() {
        lblTen.setText(nhanVien.getTenNV());
        lbChucVu.setText(nhanVien.getChucVu());
    }

    public String chuyenNN(String kiTu, String ngonNgu1) {
        if (ngonNgu == 2) {
            return ngonNgu1;
        } else {
            return kiTu;
        }
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
        pnView.add(new JPanel_TrangChu());

        JPanel_MenuItem menuQuanLyNV = new JPanel_MenuItem(null, chuyenNN("Quản lý NV", "Employee Manager"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_NhanVien());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuTimNV = new JPanel_MenuItem(null, chuyenNN("Tìm kiếm NV", "Search for employees"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemNhanVien());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuPhanCa = new JPanel_MenuItem(null, chuyenNN("Phân ca", "Shift assignment"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_PhanCa());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuBanHang = new JPanel_MenuItem(null, chuyenNN("Bán hàng", "Sell"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(jpanel_banHang);
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuQuanLyKH = new JPanel_MenuItem(null, chuyenNN("Quản lý KH", "Customer management"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhachHang());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuTimKiemKH = new JPanel_MenuItem(null, chuyenNN("Tìm kiếm KH", "Search for customers"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemKhachHang());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuQuanLySP = new JPanel_MenuItem(null, chuyenNN("Quản lý SP", "Product management"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_SanPham());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuTimKiemSP = new JPanel_MenuItem(null, chuyenNN("Tìm kiếm SP", "Search for products"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemSanPham());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuQLNhaCC = new JPanel_MenuItem(null, chuyenNN("Quản lý NCC", "Supplier management"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_NhaCungCap());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuTimKiemNCC = new JPanel_MenuItem(null, chuyenNN("Tìm kiếm NCC", "Search for suppliers"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TimKiemNhaCungCap());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuTimKiemHD = new JPanel_MenuItem(null, chuyenNN("Tìm kiếm HĐ", "Invoice managemen"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_HoaDon());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuQuanLyTK = new JPanel_MenuItem(null, chuyenNN("Quản lý tài khoản", "Account management"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                JFrame jf = null;
                jf = new Frame_TaiKhoan(nhanVien.getMaNV(), nhanVien.getChucVu());
                jf.setLocationRelativeTo(null);
                jf.setVisible(true);
            }
        });

        JPanel_MenuItem menuQuanLyKM = new JPanel_MenuItem(null, chuyenNN("Quản lý KM", "Discount management"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_KhuyenMai());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuHome = new JPanel_MenuItem(iconHome, chuyenNN("Trang chủ", "Home"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_TrangChu());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        JPanel_MenuItem menuThongKe = new JPanel_MenuItem(null, chuyenNN("Thống kê", "Statistics"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanel_ThongKe());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        JPanel_MenuItem menuDangXuat = new JPanel_MenuItem(iconLogout, chuyenNN("Đăng Xuất", "Log out"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                int result=0;
                if (ngonNgu == 2) {
                    result = JOptionPane.showConfirmDialog(null, "Are you sure you want to log out?", "Confirm Logout", JOptionPane.YES_NO_OPTION);
                } else {
                    result = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn đăng xuất?", "Xác nhận đăng xuất", JOptionPane.YES_NO_OPTION);
                }
                if (result == JOptionPane.YES_OPTION) {
                    try {
                        dangXuat();
                        new JFrame_GiaoDienDangNhap().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(JFrame_GiaoDienChinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        });

        //----------------------------------------------------------------------------------------------------------------------
        if (nhanVien.getChucVu().equals("Quản lý")) {
            JPanel_MenuItem menuEmployee = new JPanel_MenuItem(iconEmployee, chuyenNN("Nhân viên", "Employee"), null, menuQuanLyNV, menuTimNV, menuPhanCa, menuBanHang, menuThongKe, menuQuanLyKM);
            JPanel_MenuItem menuCustomer = new JPanel_MenuItem(iconCustomer, chuyenNN("Khách hàng", "Customer"), null, menuQuanLyKH, menuTimKiemKH);
            JPanel_MenuItem menuProduct = new JPanel_MenuItem(iconProduct, chuyenNN("Sản phẩm", "Product"), null, menuQuanLySP, menuTimKiemSP);
            JPanel_MenuItem menuSupplier = new JPanel_MenuItem(iconSupplier, chuyenNN("Nhà cung cấp", "Supplier"), null, menuQLNhaCC, menuTimKiemNCC);
            JPanel_MenuItem menuInvoice = new JPanel_MenuItem(iconInvoice, chuyenNN("Hoá đơn", "Invoice"), null, menuTimKiemHD);
            JPanel_MenuItem menuAccount = new JPanel_MenuItem(iconAccount, chuyenNN("Tài khoản", "Account"), null, menuQuanLyTK);
            addMenu(menuHome, menuEmployee, menuCustomer, menuProduct, menuSupplier, menuInvoice, menuAccount, menuDangXuat);
        } else {
            JPanel_MenuItem menuEmployee = new JPanel_MenuItem(iconEmployee, chuyenNN("Nhân viên", "Employee"), null, menuBanHang, menuThongKe);
            JPanel_MenuItem menuCustomer = new JPanel_MenuItem(iconCustomer, chuyenNN("Khách hàng", "Customer"), null, menuQuanLyKH, menuTimKiemKH);
            JPanel_MenuItem menuProduct = new JPanel_MenuItem(iconProduct, chuyenNN("Sản phẩm", "Product"), null, menuTimKiemSP);
            JPanel_MenuItem menuInvoice = new JPanel_MenuItem(iconInvoice, chuyenNN("Hoá đơn", "Invoice"), null, menuTimKiemHD);
            JPanel_MenuItem menuAccount = new JPanel_MenuItem(iconAccount, chuyenNN("Tài khoản", "Account"), null, menuQuanLyTK);
            addMenu(menuHome, menuEmployee, menuCustomer, menuProduct, menuInvoice, menuAccount, menuDangXuat);
        }

    }

    private void dangXuat() {
        this.setVisible(false);
    }

    private void addMenu(JPanel_MenuItem... menu) {
        for (JPanel_MenuItem menu1 : menu) {
            menus.add(menu1);
            ArrayList<JPanel_MenuItem> subMenu = menu1.getSubMenu();
            for (JPanel_MenuItem m : subMenu) {
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
        pnLogo = new javax.swing.JPanel();
        svgLogo = new util.SVGImage();
        panelMenu = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        pnInfo = new javax.swing.JPanel();
        lbChucVu = new javax.swing.JLabel();
        lblTen = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(0, 0));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setPreferredSize(new java.awt.Dimension(1300, 780));
        pnMain.setLayout(new java.awt.BorderLayout());

        pnView.setBackground(new java.awt.Color(255, 0, 0));
        pnView.setPreferredSize(new java.awt.Dimension(1200, 950));
        pnView.setLayout(new java.awt.BorderLayout());
        pnMain.add(pnView, java.awt.BorderLayout.CENTER);

        jPanelRounded1.setBackground(new java.awt.Color(0, 122, 255));
        jPanelRounded1.setPreferredSize(new java.awt.Dimension(300, 780));
        jPanelRounded1.setLayout(new java.awt.BorderLayout());

        pnLogo.setBackground(new java.awt.Color(0, 122, 255));
        pnLogo.setPreferredSize(new java.awt.Dimension(300, 130));
        pnLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnLogo.add(svgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 170, 74));

        jPanelRounded1.add(pnLogo, java.awt.BorderLayout.PAGE_START);

        panelMenu.setBackground(new java.awt.Color(0, 122, 255));
        panelMenu.setPreferredSize(new java.awt.Dimension(250, 380));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator2.setOpaque(true);
        jSeparator2.setPreferredSize(new java.awt.Dimension(0, 2));
        panelMenu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 2));

        jScrollPane1.setBackground(new java.awt.Color(0, 122, 255));
        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        menus.setBackground(new java.awt.Color(0, 122, 255));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        jScrollPane1.setViewportView(menus);

        panelMenu.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 7, 320, 660));

        jPanelRounded1.add(panelMenu, java.awt.BorderLayout.CENTER);

        pnInfo.setBackground(new java.awt.Color(0, 122, 255));
        pnInfo.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pnInfo.setPreferredSize(new java.awt.Dimension(300, 130));
        pnInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbChucVu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbChucVu.setForeground(new java.awt.Color(255, 255, 255));
        lbChucVu.setText("Chức vụ");
        pnInfo.add(lbChucVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, 34));

        lblTen.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblTen.setForeground(new java.awt.Color(255, 255, 255));
        pnInfo.add(lblTen, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, 240, 42));

        jSeparator3.setOpaque(true);
        pnInfo.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 300, -1));

        jPanelRounded1.add(pnInfo, java.awt.BorderLayout.PAGE_END);

        pnMain.add(jPanelRounded1, java.awt.BorderLayout.WEST);

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
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lbChucVu;
    private javax.swing.JLabel lblTen;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel pnInfo;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPanel pnMain;
    private util.JPanelRounded pnView;
    private util.SVGImage svgLogo;
    // End of variables declaration//GEN-END:variables
}
