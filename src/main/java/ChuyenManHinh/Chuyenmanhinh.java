
package controller;

import DanhMuc.DanhMuc;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import gui.jpannelTrangChu;
import gui.jpannelAccount;
import gui.jpannelEmployee;

/**
 *
 * @author VONG VINH LOI
 */
public class Chuyenmanhinh {
    private JPanel root;
    private String kindselected = "";
    private List<DanhMuc> listiteam= null;

    public Chuyenmanhinh(JPanel jpnRoot) {
        this.root = jpnRoot;
    }

    
    public void setView(JPanel jpnIteam, JLabel jlbiteam)
    {
        kindselected = "TrangChu";
        jpnIteam.setBackground(new Color(96,100,191));
        jlbiteam.setBackground(new Color(96,100,191));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new jpannelTrangChu());
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMuc> listiteam)
    {
        this.listiteam = listiteam;
        for(DanhMuc iteam : listiteam)
        {
            iteam.getJlb().addMouseListener(new LabelEvent(iteam.getKind(), iteam.getJpn(), iteam.getJlb()));
        }
    }
    

        
            
    class LabelEvent implements MouseListener
    {
        

         private JPanel node;
         private String kind;    
         private JPanel jpnItem;
         private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
         
        public void mouseClicked(MouseEvent e) {
            switch (kind) {
                case "Home":
                    node = new jpannelTrangChu();
                    break; 
                case "Account":
                    node = new jpannelAccount();
                    break; 
                case "Employee":
                    node = new jpannelEmployee();
                    break; 
                default:
                    node = new jpannelTrangChu();
                   break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
//            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            kindselected = kind;
//            
//            jpnItem.setBackground(new Color(96,100,191));
//            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            
        }

        @Override
        public void mouseExited(MouseEvent e) 
        {
//            if(kindselected.equalsIgnoreCase(kind))
//            {
//              jpnItem.setBackground(new Color(96,100,191));
//              jlbItem.setBackground(new Color(96,100,191));  
//            }
        }
        

        }
//        private void setChangeBackgroud(String kind)
//        {
//            for(DanhMuc item : listiteam)
//            {
//                if(item.getKind().equalsIgnoreCase(kind))
//                {
//                    item.getJpn().setBackground(new Color(96,100,191));
//                    item.getJlb().setBackground(new Color(96,100,191));
//                }
//                else 
//                {
//                   item.getJpn().setBackground(new Color(76,175,80));
//                   item.getJlb().setBackground(new Color(76,175,80)); 
//                }
//            }
//        }
    }
   
