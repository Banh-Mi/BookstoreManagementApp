/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import screenSwitch.ScreenSwitch;
import customLib.JPanelRounded;
import screen.Screen;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
        setupImage();
        minIconSlide();
        if (!minSlide) {
            slideBar.remove(pnMinLogo);
            slideBar.remove(pnMinMenuItem);
            slideBar.remove(pnStaffIcon);
        } else {
            slideBar.remove(pnLogo);
            slideBar.remove(pnMenuItem);
            slideBar.remove(pnStaffInfo);
        }
        this.controller = new ScreenSwitch(pnView);

        chuyenManHinh();
        controller.setView();

    }

    public void setupImage() {
        svgLogo.setSvgImage("logo.svg", 154, 65);
        svgHome.setSvgImage("menuItems/home.svg", 24, 22);
        svgSell.setSvgImage("menuItems/sell.svg", 24, 22);
        svgProduct.setSvgImage("menuItems/product.svg", 24, 22);
        svgEmployee.setSvgImage("menuItems/employee.svg", 25, 23);
        svgCustomer.setSvgImage("menuItems/customer.svg", 24, 22);
        svgDiscount.setSvgImage("menuItems/discount.svg", 24, 22);
        svgStatistical.setSvgImage("menuITems/statistical.svg", 24, 22);
        svgAccount.setSvgImage("menuITems/account.svg", 24, 22);
        svgSupplier.setSvgImage("menuITems/supplier.svg", 24, 22);
        svgLogout.setSvgImage("menuITems/logout.svg", 24, 22);
    }

    public void minIconSlide() {
        svgMinLogo.setSvgImage("minLogo.svg", 40, 40);
        svgMinHome.setSvgImage("menuItems/home.svg", 24, 22);
        svgMinSell.setSvgImage("menuItems/sell.svg", 24, 22);
        svgMinProduct.setSvgImage("menuItems/product.svg", 24, 22);
        svgMinEmployee.setSvgImage("menuItems/employee.svg", 24, 22);
        svgMinCustomer.setSvgImage("menuItems/customer.svg", 24, 22);
        svgMinDiscount.setSvgImage("menuItems/discount.svg", 24, 22);
        svgMinStatistical.setSvgImage("menuITems/statistical.svg", 24, 22);
        svgMinAccount.setSvgImage("menuITems/account.svg", 24, 22);
        svgMinSupplier.setSvgImage("menuITems/supplier.svg", 24, 22);
        svgMinLogout.setSvgImage("menuITems/logout.svg", 24, 22);
        svgStaff.setSvgImage("ql.svg", 40, 40);
    }
    private ScreenSwitch controller;

    public void chuyenManHinh() {

        List<Screen> listItem = new ArrayList<>();
        listItem.add(new Screen("Home", pnItem1));
        listItem.add(new Screen("Home", miniItem1));
        listItem.add(new Screen("Account", pnItem8));
        listItem.add(new Screen("Account", miniItem8));
        listItem.add(new Screen("Employee", pnItem4));
        listItem.add(new Screen("Employee", miniItem4));
        listItem.add(new Screen("Discount", pnItem6));
        listItem.add(new Screen("Statistical", pnItem7));
        controller.setEvent(listItem);

    }

    public void bgMouseEntered(JPanelRounded panel) {
        panel.setBackground(new java.awt.Color(255, 255, 255, 80));
    }

    public void bgMouseExited(JPanelRounded panel) {
        panel.setBackground(new java.awt.Color(0, 122, 255));
    }

    private boolean minSlide;

    public void minSlide() {
        minSlide = slideBar.getSize().width == 60;
    }

    public void logout() throws SQLException {
        this.setVisible(false);
        LoginForm loginForm = null;
        try {
            loginForm = new LoginForm();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        loginForm.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        slideBar = new customLib.JPanelRounded();
        pnMinMenuItem = new javax.swing.JPanel();
        miniItem3 = new customLib.JPanelRounded();
        svgMinProduct = new customLib.SVGImage();
        miniItem1 = new customLib.JPanelRounded();
        svgMinHome = new customLib.SVGImage();
        miniItem2 = new customLib.JPanelRounded();
        svgMinSell = new customLib.SVGImage();
        miniItem5 = new customLib.JPanelRounded();
        svgMinCustomer = new customLib.SVGImage();
        miniItem6 = new customLib.JPanelRounded();
        svgMinDiscount = new customLib.SVGImage();
        miniItem4 = new customLib.JPanelRounded();
        svgMinEmployee = new customLib.SVGImage();
        miniItem9 = new customLib.JPanelRounded();
        svgMinSupplier = new customLib.SVGImage();
        miniItem7 = new customLib.JPanelRounded();
        svgMinStatistical = new customLib.SVGImage();
        miniItem8 = new customLib.JPanelRounded();
        svgMinAccount = new customLib.SVGImage();
        miniItem10 = new customLib.JPanelRounded();
        svgMinLogout = new customLib.SVGImage();
        pnMenuItem = new javax.swing.JPanel();
        pnItem10 = new customLib.JPanelRounded();
        svgLogout = new customLib.SVGImage();
        lbLogout = new javax.swing.JLabel();
        pnItem5 = new customLib.JPanelRounded();
        svgCustomer = new customLib.SVGImage();
        lbCustomer = new javax.swing.JLabel();
        pnItem9 = new customLib.JPanelRounded();
        svgSupplier = new customLib.SVGImage();
        lbSupplier = new javax.swing.JLabel();
        pnItem1 = new customLib.JPanelRounded();
        svgHome = new customLib.SVGImage();
        lbHome1 = new javax.swing.JLabel();
        pnItem2 = new customLib.JPanelRounded();
        svgSell = new customLib.SVGImage();
        lbSell = new javax.swing.JLabel();
        pnItem3 = new customLib.JPanelRounded();
        lbProduct = new javax.swing.JLabel();
        svgProduct = new customLib.SVGImage();
        pnItem4 = new customLib.JPanelRounded();
        svgEmployee = new customLib.SVGImage();
        lbEmployee = new javax.swing.JLabel();
        pnItem7 = new customLib.JPanelRounded();
        svgStatistical = new customLib.SVGImage();
        lbStatistical = new javax.swing.JLabel();
        pnItem6 = new customLib.JPanelRounded();
        svgDiscount = new customLib.SVGImage();
        lbDiscount = new javax.swing.JLabel();
        pnItem8 = new customLib.JPanelRounded();
        svgAccount = new customLib.SVGImage();
        lbAccount = new javax.swing.JLabel();
        pnMinLogo = new javax.swing.JPanel();
        svgMinLogo = new customLib.SVGImage();
        pnLogo = new javax.swing.JPanel();
        svgLogo = new customLib.SVGImage();
        jSeparator1 = new javax.swing.JSeparator();
        pnStaffIcon = new customLib.JPanelRounded();
        svgStaff = new customLib.SVGImage();
        pnStaffInfo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        pnView = new customLib.JPanelRounded();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setPreferredSize(new java.awt.Dimension(1300, 780));
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slideBar.setBackground(new java.awt.Color(0, 122, 255));
        slideBar.setRoundedBottomLeft(15);
        slideBar.setRoundedBottomRight(15);
        slideBar.setRoundedTopLeft(15);
        slideBar.setRoundedTopRight(15);
        slideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnMinMenuItem.setBackground(new java.awt.Color(0, 122, 255));
        pnMinMenuItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        miniItem3.setBackground(new java.awt.Color(0, 122, 255));
        miniItem3.setRoundedBottomLeft(8);
        miniItem3.setRoundedBottomRight(8);
        miniItem3.setRoundedTopLeft(8);
        miniItem3.setRoundedTopRight(8);
        miniItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem3MouseExited(evt);
            }
        });
        miniItem3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem3.add(svgMinProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 40, 40));

        miniItem1.setBackground(new java.awt.Color(0, 122, 255));
        miniItem1.setRoundedBottomLeft(8);
        miniItem1.setRoundedBottomRight(8);
        miniItem1.setRoundedTopLeft(8);
        miniItem1.setRoundedTopRight(8);
        miniItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem1MouseExited(evt);
            }
        });
        miniItem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem1.add(svgMinHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        miniItem2.setBackground(new java.awt.Color(0, 122, 255));
        miniItem2.setRoundedBottomLeft(8);
        miniItem2.setRoundedBottomRight(8);
        miniItem2.setRoundedTopLeft(8);
        miniItem2.setRoundedTopRight(8);
        miniItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem2MouseExited(evt);
            }
        });
        miniItem2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem2.add(svgMinSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, 40, 40));
        miniItem2.getAccessibleContext().setAccessibleParent(pnMinMenuItem);

        miniItem5.setBackground(new java.awt.Color(0, 122, 255));
        miniItem5.setRoundedBottomLeft(8);
        miniItem5.setRoundedBottomRight(8);
        miniItem5.setRoundedTopLeft(8);
        miniItem5.setRoundedTopRight(8);
        miniItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem5MouseExited(evt);
            }
        });
        miniItem5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem5.add(svgMinCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, 40, 40));

        miniItem6.setBackground(new java.awt.Color(0, 122, 255));
        miniItem6.setRoundedBottomLeft(8);
        miniItem6.setRoundedBottomRight(8);
        miniItem6.setRoundedTopLeft(8);
        miniItem6.setRoundedTopRight(8);
        miniItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem6MouseExited(evt);
            }
        });
        miniItem6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem6.add(svgMinDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, 40, 40));

        miniItem4.setBackground(new java.awt.Color(0, 122, 255));
        miniItem4.setRoundedBottomLeft(8);
        miniItem4.setRoundedBottomRight(8);
        miniItem4.setRoundedTopLeft(8);
        miniItem4.setRoundedTopRight(8);
        miniItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem4MouseExited(evt);
            }
        });
        miniItem4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem4.add(svgMinEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, 40, 40));

        miniItem9.setBackground(new java.awt.Color(0, 122, 255));
        miniItem9.setRoundedBottomLeft(8);
        miniItem9.setRoundedBottomRight(8);
        miniItem9.setRoundedTopLeft(8);
        miniItem9.setRoundedTopRight(8);
        miniItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem9MouseExited(evt);
            }
        });
        miniItem9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem9.add(svgMinSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 40, 40));

        miniItem7.setBackground(new java.awt.Color(0, 122, 255));
        miniItem7.setRoundedBottomLeft(8);
        miniItem7.setRoundedBottomRight(8);
        miniItem7.setRoundedTopLeft(8);
        miniItem7.setRoundedTopRight(8);
        miniItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem7MouseExited(evt);
            }
        });
        miniItem7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem7.add(svgMinStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 40, 40));

        miniItem8.setBackground(new java.awt.Color(0, 122, 255));
        miniItem8.setRoundedBottomLeft(8);
        miniItem8.setRoundedBottomRight(8);
        miniItem8.setRoundedTopLeft(8);
        miniItem8.setRoundedTopRight(8);
        miniItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem8MouseExited(evt);
            }
        });
        miniItem8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem8.add(svgMinAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, 40, 40));

        miniItem10.setBackground(new java.awt.Color(0, 122, 255));
        miniItem10.setRoundedBottomLeft(8);
        miniItem10.setRoundedBottomRight(8);
        miniItem10.setRoundedTopLeft(8);
        miniItem10.setRoundedTopRight(8);
        miniItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                miniItem10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                miniItem10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                miniItem10MouseExited(evt);
            }
        });
        miniItem10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        miniItem10.add(svgMinLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 24, 22));

        pnMinMenuItem.add(miniItem10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 495, 40, 40));

        slideBar.add(pnMinMenuItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, 40, 530));
        pnMinMenuItem.getAccessibleContext().setAccessibleParent(slideBar);

        pnMenuItem.setBackground(new java.awt.Color(0, 122, 255));
        pnMenuItem.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnItem10.setBackground(new java.awt.Color(0, 122, 255));
        pnItem10.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem10.setRoundedBottomLeft(10);
        pnItem10.setRoundedBottomRight(10);
        pnItem10.setRoundedTopLeft(10);
        pnItem10.setRoundedTopRight(10);
        pnItem10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnItem10MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem10MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem10MouseExited(evt);
            }
        });
        pnItem10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgLogout.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem10.add(svgLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbLogout.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbLogout.setForeground(new java.awt.Color(255, 255, 255));
        lbLogout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLogout.setText("Đăng xuất");
        lbLogout.setVerifyInputWhenFocusTarget(false);
        pnItem10.add(lbLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 495, -1, -1));

        pnItem5.setBackground(new java.awt.Color(0, 122, 255));
        pnItem5.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem5.setRoundedBottomLeft(10);
        pnItem5.setRoundedBottomRight(10);
        pnItem5.setRoundedTopLeft(10);
        pnItem5.setRoundedTopRight(10);
        pnItem5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem5MouseExited(evt);
            }
        });
        pnItem5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgCustomer.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem5.add(svgCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbCustomer.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbCustomer.setForeground(new java.awt.Color(255, 255, 255));
        lbCustomer.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCustomer.setText("Khách hàng");
        lbCustomer.setVerifyInputWhenFocusTarget(false);
        pnItem5.add(lbCustomer, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        pnItem9.setBackground(new java.awt.Color(0, 122, 255));
        pnItem9.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem9.setRoundedBottomLeft(10);
        pnItem9.setRoundedBottomRight(10);
        pnItem9.setRoundedTopLeft(10);
        pnItem9.setRoundedTopRight(10);
        pnItem9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem9MouseExited(evt);
            }
        });
        pnItem9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgSupplier.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem9.add(svgSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbSupplier.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbSupplier.setForeground(new java.awt.Color(255, 255, 255));
        lbSupplier.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSupplier.setText("Đối tác");
        lbSupplier.setVerifyInputWhenFocusTarget(false);
        pnItem9.add(lbSupplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, -1, -1));

        pnItem1.setBackground(new java.awt.Color(0, 122, 255));
        pnItem1.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem1.setRoundedBottomLeft(10);
        pnItem1.setRoundedBottomRight(10);
        pnItem1.setRoundedTopLeft(10);
        pnItem1.setRoundedTopRight(10);
        pnItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnItem1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem1MouseExited(evt);
            }
        });
        pnItem1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgHome.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem1.add(svgHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbHome1.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbHome1.setForeground(new java.awt.Color(255, 255, 255));
        lbHome1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHome1.setText("Trang chủ");
        lbHome1.setVerifyInputWhenFocusTarget(false);
        pnItem1.add(lbHome1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pnItem2.setBackground(new java.awt.Color(0, 122, 255));
        pnItem2.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem2.setRoundedBottomLeft(10);
        pnItem2.setRoundedBottomRight(10);
        pnItem2.setRoundedTopLeft(10);
        pnItem2.setRoundedTopRight(10);
        pnItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem2MouseExited(evt);
            }
        });
        pnItem2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgSell.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem2.add(svgSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbSell.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbSell.setForeground(new java.awt.Color(255, 255, 255));
        lbSell.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbSell.setText("Bán hàng");
        lbSell.setVerifyInputWhenFocusTarget(false);
        pnItem2.add(lbSell, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 55, -1, -1));

        pnItem3.setBackground(new java.awt.Color(0, 122, 255));
        pnItem3.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem3.setRoundedBottomLeft(10);
        pnItem3.setRoundedBottomRight(10);
        pnItem3.setRoundedTopLeft(10);
        pnItem3.setRoundedTopRight(10);
        pnItem3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem3MouseExited(evt);
            }
        });
        pnItem3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbProduct.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbProduct.setForeground(new java.awt.Color(255, 255, 255));
        lbProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProduct.setText("Sản phẩm");
        lbProduct.setVerifyInputWhenFocusTarget(false);
        pnItem3.add(lbProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        svgProduct.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem3.add(svgProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        pnMenuItem.add(pnItem3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, -1, -1));

        pnItem4.setBackground(new java.awt.Color(0, 122, 255));
        pnItem4.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem4.setRoundedBottomLeft(10);
        pnItem4.setRoundedBottomRight(10);
        pnItem4.setRoundedTopLeft(10);
        pnItem4.setRoundedTopRight(10);
        pnItem4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem4MouseExited(evt);
            }
        });
        pnItem4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgEmployee.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem4.add(svgEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbEmployee.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbEmployee.setForeground(new java.awt.Color(255, 255, 255));
        lbEmployee.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbEmployee.setText("Nhân viên");
        lbEmployee.setVerifyInputWhenFocusTarget(false);
        pnItem4.add(lbEmployee, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 165, -1, -1));

        pnItem7.setBackground(new java.awt.Color(0, 122, 255));
        pnItem7.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem7.setRoundedBottomLeft(10);
        pnItem7.setRoundedBottomRight(10);
        pnItem7.setRoundedTopLeft(10);
        pnItem7.setRoundedTopRight(10);
        pnItem7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem7MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem7MouseExited(evt);
            }
        });
        pnItem7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgStatistical.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem7.add(svgStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbStatistical.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbStatistical.setForeground(new java.awt.Color(255, 255, 255));
        lbStatistical.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbStatistical.setText("Thống kê");
        lbStatistical.setVerifyInputWhenFocusTarget(false);
        pnItem7.add(lbStatistical, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        pnItem6.setBackground(new java.awt.Color(0, 122, 255));
        pnItem6.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem6.setRoundedBottomLeft(10);
        pnItem6.setRoundedBottomRight(10);
        pnItem6.setRoundedTopLeft(10);
        pnItem6.setRoundedTopRight(10);
        pnItem6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem6MouseExited(evt);
            }
        });
        pnItem6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgDiscount.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem6.add(svgDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbDiscount.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbDiscount.setForeground(new java.awt.Color(255, 255, 255));
        lbDiscount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbDiscount.setText("Giảm giá");
        lbDiscount.setVerifyInputWhenFocusTarget(false);
        pnItem6.add(lbDiscount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 275, -1, -1));

        pnItem8.setBackground(new java.awt.Color(0, 122, 255));
        pnItem8.setPreferredSize(new java.awt.Dimension(190, 40));
        pnItem8.setRoundedBottomLeft(10);
        pnItem8.setRoundedBottomRight(10);
        pnItem8.setRoundedTopLeft(10);
        pnItem8.setRoundedTopRight(10);
        pnItem8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pnItem8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pnItem8MouseExited(evt);
            }
        });
        pnItem8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgAccount.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem8.add(svgAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbAccount.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbAccount.setForeground(new java.awt.Color(255, 255, 255));
        lbAccount.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAccount.setText("Tài khoản");
        lbAccount.setVerifyInputWhenFocusTarget(false);
        pnItem8.add(lbAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, -1, -1));

        slideBar.add(pnMenuItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 115, 190, 540));

        pnMinLogo.setBackground(new java.awt.Color(0, 122, 255));
        pnMinLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnMinLogoMouseClicked(evt);
            }
        });
        pnMinLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnMinLogo.add(svgMinLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 40, 40));

        slideBar.add(pnMinLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 40));

        pnLogo.setBackground(new java.awt.Color(0, 122, 255));
        pnLogo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnLogoMouseClicked(evt);
            }
        });
        pnLogo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgLogo.setText(" ");
        pnLogo.add(svgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 154, 66));

        slideBar.add(pnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 154, 66));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        slideBar.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 230, 5));

        pnStaffIcon.setBackground(new java.awt.Color(255, 255, 255));
        pnStaffIcon.setRoundedBottomLeft(40);
        pnStaffIcon.setRoundedBottomRight(40);
        pnStaffIcon.setRoundedTopLeft(40);
        pnStaffIcon.setRoundedTopRight(40);
        pnStaffIcon.setLayout(new java.awt.BorderLayout());
        pnStaffIcon.add(svgStaff, java.awt.BorderLayout.CENTER);

        slideBar.add(pnStaffIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 40, 40));

        pnStaffInfo.setBackground(new java.awt.Color(0, 122, 255));
        pnStaffInfo.setLayout(new java.awt.GridLayout(2, 1));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("NGUYỄN VĂN A");
        pnStaffInfo.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Chức vụ");
        pnStaffInfo.add(jLabel2);

        slideBar.add(pnStaffInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 685, 190, 60));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        slideBar.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 105, 230, 560));

        pnMain.add(slideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 230, 760));

        pnView.setBackground(new java.awt.Color(255, 0, 0));
        pnView.setRoundedBottomLeft(15);
        pnView.setRoundedBottomRight(15);
        pnView.setRoundedTopLeft(15);
        pnView.setRoundedTopRight(15);
        pnView.setLayout(new java.awt.BorderLayout());
        pnMain.add(pnView, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 12, 1040, 760));

        getContentPane().add(pnMain, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseClicked
        try {
            logout();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_pnItem10MouseClicked

    private void pnItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem1MouseEntered
        bgMouseEntered(pnItem1);
    }//GEN-LAST:event_pnItem1MouseEntered

    private void pnItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem1MouseExited
        bgMouseExited(pnItem1);
    }//GEN-LAST:event_pnItem1MouseExited

    private void pnItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem2MouseEntered
        bgMouseEntered(pnItem2);
    }//GEN-LAST:event_pnItem2MouseEntered

    private void pnItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem2MouseExited
        bgMouseExited(pnItem2);
    }//GEN-LAST:event_pnItem2MouseExited

    private void pnItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem3MouseEntered
        bgMouseEntered(pnItem3);
    }//GEN-LAST:event_pnItem3MouseEntered

    private void pnItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem3MouseExited
        bgMouseExited(pnItem3);
    }//GEN-LAST:event_pnItem3MouseExited

    private void pnItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem4MouseEntered
        bgMouseEntered(pnItem4);
    }//GEN-LAST:event_pnItem4MouseEntered

    private void pnItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem4MouseExited
        bgMouseExited(pnItem4);
    }//GEN-LAST:event_pnItem4MouseExited

    private void pnItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem5MouseEntered
        bgMouseEntered(pnItem5);
    }//GEN-LAST:event_pnItem5MouseEntered

    private void pnItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem5MouseExited
        bgMouseExited(pnItem5);
    }//GEN-LAST:event_pnItem5MouseExited

    private void pnItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem6MouseExited
        bgMouseExited(pnItem6);
    }//GEN-LAST:event_pnItem6MouseExited

    private void pnItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem6MouseEntered
        bgMouseEntered(pnItem6);
    }//GEN-LAST:event_pnItem6MouseEntered

    private void pnItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem7MouseEntered
        bgMouseEntered(pnItem7);
    }//GEN-LAST:event_pnItem7MouseEntered

    private void pnItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem7MouseExited
        bgMouseExited(pnItem7);
    }//GEN-LAST:event_pnItem7MouseExited

    private void pnItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem8MouseEntered
        bgMouseEntered(pnItem8);
    }//GEN-LAST:event_pnItem8MouseEntered

    private void pnItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem8MouseExited
        bgMouseExited(pnItem8);
    }//GEN-LAST:event_pnItem8MouseExited

    private void pnItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem9MouseEntered
        bgMouseEntered(pnItem9);
    }//GEN-LAST:event_pnItem9MouseEntered

    private void pnItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem9MouseExited
        bgMouseExited(pnItem9);
    }//GEN-LAST:event_pnItem9MouseExited

    private void pnItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseExited
        bgMouseExited(pnItem10);
    }//GEN-LAST:event_pnItem10MouseExited

    private void pnItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseEntered
        bgMouseEntered(pnItem10);
    }//GEN-LAST:event_pnItem10MouseEntered


    private void miniItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem3MouseEntered
        bgMouseEntered(miniItem3);
    }//GEN-LAST:event_miniItem3MouseEntered

    private void miniItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem3MouseExited
        bgMouseExited(miniItem3);
    }//GEN-LAST:event_miniItem3MouseExited

    private void miniItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem1MouseEntered
        bgMouseEntered(miniItem1);
    }//GEN-LAST:event_miniItem1MouseEntered

    private void miniItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem1MouseExited
        bgMouseExited(miniItem1);
    }//GEN-LAST:event_miniItem1MouseExited

    private void miniItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem2MouseEntered
        bgMouseEntered(miniItem2);
    }//GEN-LAST:event_miniItem2MouseEntered

    private void miniItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem2MouseExited
        bgMouseExited(miniItem2);
    }//GEN-LAST:event_miniItem2MouseExited

    private void miniItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem4MouseEntered
        bgMouseEntered(miniItem4);
    }//GEN-LAST:event_miniItem4MouseEntered

    private void miniItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem4MouseExited
        bgMouseExited(miniItem4);
    }//GEN-LAST:event_miniItem4MouseExited

    private void miniItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem5MouseEntered
        bgMouseEntered(miniItem5);
    }//GEN-LAST:event_miniItem5MouseEntered

    private void miniItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem5MouseExited
        bgMouseExited(miniItem5);
    }//GEN-LAST:event_miniItem5MouseExited

    private void miniItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem6MouseEntered
        bgMouseEntered(miniItem6);
    }//GEN-LAST:event_miniItem6MouseEntered

    private void miniItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem6MouseExited
        bgMouseExited(miniItem6);
    }//GEN-LAST:event_miniItem6MouseExited

    private void miniItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem7MouseEntered
        bgMouseEntered(miniItem7);
    }//GEN-LAST:event_miniItem7MouseEntered

    private void miniItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem7MouseExited
        bgMouseExited(miniItem7);
    }//GEN-LAST:event_miniItem7MouseExited

    private void miniItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem8MouseEntered
        bgMouseEntered(miniItem8);
    }//GEN-LAST:event_miniItem8MouseEntered

    private void miniItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem8MouseExited
        bgMouseExited(miniItem8);
    }//GEN-LAST:event_miniItem8MouseExited

    private void miniItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem9MouseEntered
        bgMouseEntered(miniItem9);
    }//GEN-LAST:event_miniItem9MouseEntered

    private void miniItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem9MouseExited
        bgMouseExited(miniItem9);
    }//GEN-LAST:event_miniItem9MouseExited

    private void miniItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem10MouseEntered
        bgMouseEntered(miniItem10);
    }//GEN-LAST:event_miniItem10MouseEntered

    private void miniItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem10MouseExited
        bgMouseExited(miniItem10);
    }//GEN-LAST:event_miniItem10MouseExited

    private void miniItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_miniItem10MouseClicked
        try {
            logout();
        } catch (SQLException ex) {
            Logger.getLogger(ApplicationFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_miniItem10MouseClicked

    private void pnLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnLogoMouseClicked
        minSlideBar();
        slideBar.repaint();
    }//GEN-LAST:event_pnLogoMouseClicked

    private void pnMinLogoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnMinLogoMouseClicked
        fullSlideBar();
        slideBar.repaint();
    }//GEN-LAST:event_pnMinLogoMouseClicked

    private void pnItem1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_pnItem1MouseClicked

    public void fullSlideBar() {

        new Thread(() -> {
            slideBar.remove(pnMinMenuItem);
            slideBar.remove(pnMinLogo);
            slideBar.remove(pnStaffIcon);
            slideBar.add(pnMenuItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, 540));
            slideBar.add(pnLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, pnMenuItem.getWidth(), pnMenuItem.getHeight()));
            slideBar.add(pnStaffInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 685, 190, 60));
            for (int i = 60; i <= 230; i += 10) {
                slideBar.setSize(i, slideBar.getHeight());

                try {
                    Thread.sleep(1);
                } catch (InterruptedException ex) {

                }
            }
            pnView.setBounds(250, pnView.getY(), 1040, pnView.getHeight());
             controller.setView();
            minSlide();
        }).start();

    }

    public void minSlideBar() {
        new Thread(() -> {
            slideBar.remove(pnMenuItem);
            slideBar.remove(pnLogo);
            slideBar.remove(pnStaffInfo);
            slideBar.add(pnMinLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 40, 40));
            slideBar.add(pnMinMenuItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, pnMinMenuItem.getWidth(), pnMinMenuItem.getHeight()));
            slideBar.add(pnStaffIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 690, 40, 40));

            for (int i = 230; i >= 60; i -= 10) {

                slideBar.setSize(i, slideBar.getHeight());
                try {
                    Thread.sleep(1);

                } catch (InterruptedException ex) {

                }
            }

            pnView.setBounds(80, pnView.getY(), 1210, pnView.getHeight());

            controller.setView();
            minSlide();
        }).start();

    }

    public static void main(String args[]) {
   
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbAccount;
    private javax.swing.JLabel lbCustomer;
    private javax.swing.JLabel lbDiscount;
    private javax.swing.JLabel lbEmployee;
    private javax.swing.JLabel lbHome1;
    private javax.swing.JLabel lbLogout;
    private javax.swing.JLabel lbProduct;
    private javax.swing.JLabel lbSell;
    private javax.swing.JLabel lbStatistical;
    private javax.swing.JLabel lbSupplier;
    private customLib.JPanelRounded miniItem1;
    private customLib.JPanelRounded miniItem10;
    private customLib.JPanelRounded miniItem2;
    private customLib.JPanelRounded miniItem3;
    private customLib.JPanelRounded miniItem4;
    private customLib.JPanelRounded miniItem5;
    private customLib.JPanelRounded miniItem6;
    private customLib.JPanelRounded miniItem7;
    private customLib.JPanelRounded miniItem8;
    private customLib.JPanelRounded miniItem9;
    private customLib.JPanelRounded pnItem1;
    private customLib.JPanelRounded pnItem10;
    private customLib.JPanelRounded pnItem2;
    private customLib.JPanelRounded pnItem3;
    private customLib.JPanelRounded pnItem4;
    private customLib.JPanelRounded pnItem5;
    private customLib.JPanelRounded pnItem6;
    private customLib.JPanelRounded pnItem7;
    private customLib.JPanelRounded pnItem8;
    private customLib.JPanelRounded pnItem9;
    private javax.swing.JPanel pnLogo;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenuItem;
    private javax.swing.JPanel pnMinLogo;
    private javax.swing.JPanel pnMinMenuItem;
    private customLib.JPanelRounded pnStaffIcon;
    private javax.swing.JPanel pnStaffInfo;
    private customLib.JPanelRounded pnView;
    private customLib.JPanelRounded slideBar;
    private customLib.SVGImage svgAccount;
    private customLib.SVGImage svgCustomer;
    private customLib.SVGImage svgDiscount;
    private customLib.SVGImage svgEmployee;
    private customLib.SVGImage svgHome;
    private customLib.SVGImage svgLogo;
    private customLib.SVGImage svgLogout;
    private customLib.SVGImage svgMinAccount;
    private customLib.SVGImage svgMinCustomer;
    private customLib.SVGImage svgMinDiscount;
    private customLib.SVGImage svgMinEmployee;
    private customLib.SVGImage svgMinHome;
    private customLib.SVGImage svgMinLogo;
    private customLib.SVGImage svgMinLogout;
    private customLib.SVGImage svgMinProduct;
    private customLib.SVGImage svgMinSell;
    private customLib.SVGImage svgMinStatistical;
    private customLib.SVGImage svgMinSupplier;
    private customLib.SVGImage svgProduct;
    private customLib.SVGImage svgSell;
    private customLib.SVGImage svgStaff;
    private customLib.SVGImage svgStatistical;
    private customLib.SVGImage svgSupplier;
    // End of variables declaration//GEN-END:variables
}
