/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class JPanel_MenuItem extends javax.swing.JPanel {

    public void setShowing(boolean showing) {
        this.showing = showing;
    }

    public ArrayList<JPanel_MenuItem> getSubMenu() {
        return subMenu;
    }

    /**
     * Creates new form MenuItem
     */
    private final ArrayList<JPanel_MenuItem> subMenu = new ArrayList<>();
    private ActionListener act;

    public JPanel_MenuItem(String icon, String menuName, ActionListener act, JPanel_MenuItem... subMenu) {
        initComponents();
        if(icon!= null) {
              iconSVG.setSvgImage(icon, 28, 25);
        }
      
        lbName.setText(menuName);
        if (act != null) {
            this.act = act;
        }
        this.setSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        this.setMinimumSize(new Dimension(Integer.MAX_VALUE, 45));
        for (JPanel_MenuItem subMenu1 : subMenu) {
            this.subMenu.add(subMenu1);
            subMenu1.setVisible(false);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbName = new javax.swing.JLabel();
        iconSVG = new util.SVGImage();

        setBackground(new java.awt.Color(0, 122, 255));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbName.setBackground(new java.awt.Color(0, 122, 255));
        lbName.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbName.setForeground(new java.awt.Color(255, 255, 255));
        add(lbName, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 180, 40));
        add(iconSVG, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 46, 40));
    }// </editor-fold>//GEN-END:initComponents

    private boolean showing = false;
    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (showing) {
            hideMenu();
        } else {
            showMenu();
        }
        if (act != null) {
            act.actionPerformed(null);
        }
    }//GEN-LAST:event_formMousePressed

    private void showMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < subMenu.size(); i++) {
                    sleep();
                    subMenu.get(i).setVisible(true);
                }
                showing = true;
                getParent().repaint();
                getParent().revalidate();
            }
        }).start();
    }

    private void hideMenu() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = subMenu.size() - 1; i >= 0; i--) {
                    sleep();
                    subMenu.get(i).setVisible(false);
                    subMenu.get(i).hideMenu();
                }
                getParent().repaint();
                getParent().revalidate();
                showing = false;
            }
        }).start();
    }

    private void sleep() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private util.SVGImage iconSVG;
    private javax.swing.JLabel lbName;
    // End of variables declaration//GEN-END:variables
}
