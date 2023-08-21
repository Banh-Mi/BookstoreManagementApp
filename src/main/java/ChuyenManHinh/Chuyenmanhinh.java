
package ChuyenManHinh;

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
import gui.jpannelgiamgia;

/**
 *
 * @author VONG VINH LOI
 */
public class Chuyenmanhinh {
    private final JPanel root;
    private final DanhMuc item;
    public Chuyenmanhinh(JPanel jpnRoot) {
        this.root = jpnRoot;
        this.item = new DanhMuc("Home", new jpannelTrangChu());
    }

    public void setView()
    {
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(item.getJpn(),BorderLayout.CENTER);
        root.validate();
        root.repaint();
    }
    public void setEvent(List<DanhMuc> listiteam)
    {
        for(DanhMuc pnItem : listiteam)
        {
            pnItem.getJpn().addMouseListener(new PanelEvent(pnItem.getKind(), pnItem.getJpn()));
        }
    }
    
   
        
    
            
    class PanelEvent implements MouseListener
    {
        

         private JPanel node;
         private final String kind ;    

        public PanelEvent(String kind, JPanel jpnItem) {
            this.kind = kind;
        }
         
         @Override
        public void mouseClicked(MouseEvent e) {
            item.setKind(kind);
            switch (kind) {
                case "Home" -> {
                    node = new jpannelTrangChu();
                    item.setJpn(node);
                 }
                case "Account" -> {
                    try {
                        node = new jpannelAccount();
                        item.setJpn(node);
                    } catch (SQLException ex) {
                        Logger.getLogger(Chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
 
                case "Employee" -> {
                    node = new jpannelEmployee();
                    item.setJpn(node);
                 }
                case "Discount" -> {
                try {
                    node = new jpannelgiamgia();
                } catch (SQLException ex) {
                    Logger.getLogger(Chuyenmanhinh.class.getName()).log(Level.SEVERE, null, ex);
                }
                    item.setJpn(node);
                 }
                default -> {
                    node = new jpannelTrangChu();
                    item.setJpn(node);
                 }
            }
            root.removeAll();
//            root.setLayout(new BorderLayout());
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
   
