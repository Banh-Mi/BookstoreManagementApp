/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import javax.swing.UIManager;

/**
 *
 * @author BanhMi88
 */
public class ApplicationFrame extends javax.swing.JFrame {

    /**
     * Creates new form ApplicationFrame
     */
    public ApplicationFrame() {
        initComponents();
        setupImage();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnMain = new javax.swing.JPanel();
        slideBar = new customLib.roundedPanel();
        svgLogo = new customLib.SVGImage();
        pnMenuItem = new javax.swing.JPanel();
        pnItem10 = new customLib.roundedPanel();
        svgLogout = new customLib.SVGImage();
        lbLogout = new javax.swing.JLabel();
        pnItem5 = new customLib.roundedPanel();
        svgCustomer = new customLib.SVGImage();
        lbCustomer = new javax.swing.JLabel();
        pnItem9 = new customLib.roundedPanel();
        svgSupplier = new customLib.SVGImage();
        lbSupplier = new javax.swing.JLabel();
        pnItem1 = new customLib.roundedPanel();
        svgHome = new customLib.SVGImage();
        lbHome1 = new javax.swing.JLabel();
        pnItem2 = new customLib.roundedPanel();
        svgSell = new customLib.SVGImage();
        lbSell = new javax.swing.JLabel();
        pnItem3 = new customLib.roundedPanel();
        svgProduct = new customLib.SVGImage();
        lbProduct = new javax.swing.JLabel();
        pnItem4 = new customLib.roundedPanel();
        svgEmployee = new customLib.SVGImage();
        lbEmployee = new javax.swing.JLabel();
        pnItem7 = new customLib.roundedPanel();
        svgStatistical = new customLib.SVGImage();
        lbStatistical = new javax.swing.JLabel();
        pnItem6 = new customLib.roundedPanel();
        svgDiscount = new customLib.SVGImage();
        lbDiscount = new javax.swing.JLabel();
        pnItem8 = new customLib.roundedPanel();
        svgAccount = new customLib.SVGImage();
        lbAccount = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        pnMain.setBackground(new java.awt.Color(255, 255, 255));
        pnMain.setPreferredSize(new java.awt.Dimension(1280, 720));
        pnMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        slideBar.setBackground(new java.awt.Color(0, 122, 255));
        slideBar.setRoundedBottomLeft(15);
        slideBar.setRoundedBottomRight(15);
        slideBar.setRoundedTopLeft(15);
        slideBar.setRoundedTopRight(15);
        slideBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        svgLogo.setText(" ");
        slideBar.add(svgLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 154, 66));

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
        lbLogout.setText("Logout");
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
        lbCustomer.setText("Customer");
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
        lbSupplier.setText("Supplier");
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
        lbHome1.setText("Home");
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
        lbSell.setText("Sell");
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

        svgProduct.setPreferredSize(new java.awt.Dimension(35, 35));
        pnItem3.add(svgProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 0, 40, 40));

        lbProduct.setFont(new java.awt.Font("Nunito Medium", 0, 20)); // NOI18N
        lbProduct.setForeground(new java.awt.Color(255, 255, 255));
        lbProduct.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbProduct.setText("Product");
        lbProduct.setVerifyInputWhenFocusTarget(false);
        pnItem3.add(lbProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

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
        lbEmployee.setText("Employee");
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
        lbStatistical.setText("Statistical");
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
        lbDiscount.setText("Discount");
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
        lbAccount.setText("Account");
        lbAccount.setVerifyInputWhenFocusTarget(false);
        pnItem8.add(lbAccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, -1, 40));

        pnMenuItem.add(pnItem8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 385, -1, -1));

        slideBar.add(pnMenuItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 190, 540));

        pnMain.add(slideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 15, 230, 690));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnMain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pnItem10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseClicked
        this.setVisible(false);
         LoginForm  loginForm = new LoginForm();
        loginForm.setVisible(true);
    }//GEN-LAST:event_pnItem10MouseClicked

    private void pnItem1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem1MouseEntered
        pnItem1.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem1MouseEntered

    private void pnItem1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem1MouseExited
        pnItem1.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem1MouseExited

    private void pnItem2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem2MouseEntered
        pnItem2.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem2MouseEntered

    private void pnItem2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem2MouseExited
        pnItem2.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem2MouseExited

    private void pnItem3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem3MouseEntered
        pnItem3.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem3MouseEntered

    private void pnItem3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem3MouseExited
        pnItem3.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem3MouseExited

    private void pnItem4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem4MouseEntered
        pnItem4.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem4MouseEntered

    private void pnItem4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem4MouseExited
        pnItem4.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem4MouseExited

    private void pnItem5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem5MouseEntered
        pnItem5.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem5MouseEntered

    private void pnItem5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem5MouseExited
        pnItem5.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem5MouseExited

    private void pnItem6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem6MouseExited
        pnItem6.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem6MouseExited

    private void pnItem6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem6MouseEntered

        pnItem6.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem6MouseEntered

    private void pnItem7MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem7MouseEntered
        pnItem7.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem7MouseEntered

    private void pnItem7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem7MouseExited
        pnItem7.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem7MouseExited

    private void pnItem8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem8MouseEntered
        pnItem8.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem8MouseEntered

    private void pnItem8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem8MouseExited
        pnItem8.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem8MouseExited

    private void pnItem9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem9MouseEntered
        pnItem9.setBackground(new java.awt.Color(255, 255, 255, 60));
    }//GEN-LAST:event_pnItem9MouseEntered

    private void pnItem9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem9MouseExited
        pnItem9.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem9MouseExited

    private void pnItem10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseExited
        pnItem10.setBackground(new java.awt.Color(0, 122, 255));
    }//GEN-LAST:event_pnItem10MouseExited

    private void pnItem10MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnItem10MouseEntered
        pnItem10.setBackground(new java.awt.Color(255, 255, 255, 60));

    }//GEN-LAST:event_pnItem10MouseEntered

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        FlatLaf.registerCustomDefaultsSource("resources.themes");
        FlatMacLightLaf.setup();

        UIManager.put("Panel.arc", 20);
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicationFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
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
    private customLib.roundedPanel pnItem1;
    private customLib.roundedPanel pnItem10;
    private customLib.roundedPanel pnItem2;
    private customLib.roundedPanel pnItem3;
    private customLib.roundedPanel pnItem4;
    private customLib.roundedPanel pnItem5;
    private customLib.roundedPanel pnItem6;
    private customLib.roundedPanel pnItem7;
    private customLib.roundedPanel pnItem8;
    private customLib.roundedPanel pnItem9;
    private javax.swing.JPanel pnMain;
    private javax.swing.JPanel pnMenuItem;
    private customLib.roundedPanel slideBar;
    private customLib.SVGImage svgAccount;
    private customLib.SVGImage svgCustomer;
    private customLib.SVGImage svgDiscount;
    private customLib.SVGImage svgEmployee;
    private customLib.SVGImage svgHome;
    private customLib.SVGImage svgLogo;
    private customLib.SVGImage svgLogout;
    private customLib.SVGImage svgProduct;
    private customLib.SVGImage svgSell;
    private customLib.SVGImage svgStatistical;
    private customLib.SVGImage svgSupplier;
    // End of variables declaration//GEN-END:variables
}
