/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
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
public final class ApplicationFrame extends javax.swing.JFrame {

    public ApplicationFrame() {
        initComponents();
        svgLogo.setSvgImage("logo.svg", 154, 65);
        execute();
    }

    private void execute() {
        String iconHome = "/menuItems/home.svg";
        String iconEmployee = "/menuItems/employee.svg";
        String iconCustomer = "/menuItems/customer.svg";
        String iconProduct = "/menuItems/product.svg";
        String iconSupplier = "/menuItems/supplier.svg";
        String iconInvoice = "/menuItems/invoice.svg";
        String iconStatistical = "/menuItems/statistical.svg";
        String iconAccount = "/menuItems/account.svg";
        String iconDiscount = "/menuItems/discount.svg";
        pnView.add(new JPanelHome());

        MenuItem menuEmployee1 = new MenuItem(null, "Quản lý NV", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanelEmployee());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuEmployee2 = new MenuItem(null, "Tìm kiếm NV", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanelStatistical());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuEmployee3 = new MenuItem(null, "Phân ca", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuEmployee4 = new MenuItem(null, "Bán hàng", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanelSell());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuCustomer1 = new MenuItem(null, "Quản lý KH", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                try {
                    pnView.add(new JPanelCustomer());
                } catch (SQLException ex) {
                    Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuCustomer2 = new MenuItem(null, "Tìm kiếm KH", null);

        MenuItem menuProduct1 = new MenuItem(null, "Quản lý SP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuProduct2 = new MenuItem(null, "Tìm kiếm SP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuSupplier1 = new MenuItem(null, "Quản lý NCC", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuSupplier2 = new MenuItem(null, "Tìm kiếm NCC", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuInvoice1 = new MenuItem(null, "Quản lý HĐ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuAccount1 = new MenuItem(null, "Quản lý tài khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuAccount2 = new MenuItem(null, "Tìm kiếm tài khoản", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuDiscount1 = new MenuItem(null, "Quản lý giảm giá", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuDiscount2 = new MenuItem(null, "Tìm kiếm giảm giá", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuHome = new MenuItem(iconHome, "Trang chủ", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanelHome());
                pnView.repaint();
                pnView.revalidate();
            }
        });
            MenuItem menuStatistical1 = new MenuItem(null, "Thống kê DT", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPannelStatisticaldoanhthu());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuStatistical2 = new MenuItem(null, "Thống kê KH", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPannelStatisticalkhachhang());
                pnView.repaint();
                pnView.revalidate();
            }
        });
        MenuItem menuStatistical3 = new MenuItem(null, "Thống kê SP", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pnView.removeAll();
                pnView.add(new JPanelStatisticalsanpham());
                pnView.repaint();
                pnView.revalidate();
            }
        });

        MenuItem menuEmployee = new MenuItem(iconEmployee, "Nhân viên", null, menuEmployee1, menuEmployee2, menuEmployee3, menuEmployee4);
        MenuItem menuCustomer = new MenuItem(iconCustomer, "Khách hàng", null, menuCustomer1, menuCustomer2);
        MenuItem menuProduct = new MenuItem(iconProduct, "Sản phẩm", null, menuProduct1, menuProduct2);
        MenuItem menuSupplier = new MenuItem(iconSupplier, "Nhà cung cấp", null, menuSupplier1, menuSupplier2);
        MenuItem menuInvoice = new MenuItem(iconInvoice, "Hoá đơn", null, menuInvoice1);
        MenuItem menuStatistical = new MenuItem(iconStatistical, "Thống kê",null,menuStatistical1,menuStatistical2,menuStatistical3 );  
        MenuItem menuAccount = new MenuItem(iconAccount, "Tài khoản", null, menuAccount1, menuAccount2);
        MenuItem menuDiscount = new MenuItem(iconDiscount, "Giảm giá", null, menuDiscount1, menuDiscount2);
        addMenu(menuHome, menuEmployee, menuCustomer, menuProduct, menuSupplier, menuInvoice, menuStatistical, menuAccount, menuDiscount);
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
        pnView = new customLib.JPanelRounded();
        jPanelRounded1 = new customLib.JPanelRounded();
        svgLogo = new customLib.SVGImage();
        panelMenu = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();

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
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanelRounded1Layout = new javax.swing.GroupLayout(jPanelRounded1);
        jPanelRounded1.setLayout(jPanelRounded1Layout);
        jPanelRounded1Layout.setHorizontalGroup(
            jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRounded1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(svgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
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
                .addContainerGap(678, Short.MAX_VALUE))
            .addGroup(jPanelRounded1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRounded1Layout.createSequentialGroup()
                    .addContainerGap(102, Short.MAX_VALUE)
                    .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(96, Short.MAX_VALUE)))
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private customLib.JPanelRounded jPanelRounded1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel pnMain;
    private customLib.JPanelRounded pnView;
    private customLib.SVGImage svgLogo;
    // End of variables declaration//GEN-END:variables
}
