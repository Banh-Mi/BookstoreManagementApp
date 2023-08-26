package screenSwitch;

import screen.Screen;
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import gui.JpannelHome;
import gui.JpannelAccount;
import gui.JpannelDiscount;
import gui.JpanelEmployee;
import gui.JpannelStatistical;

/**
 *
 * @author VONG VINH LOI
 */
public class ScreenSwitch {

    private final JPanel root;
    private final Screen item;

    public ScreenSwitch(JPanel jpnRoot) {
        this.root = jpnRoot;
        this.item = new Screen("Home", new JpannelHome());
    }

    public void setView() {
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(item.getJpn(), BorderLayout.CENTER);
        root.validate();
        root.repaint();
    }

    public void setEvent(List<Screen> listiteam) {
        for (Screen pnItem : listiteam) {
            pnItem.getJpn().addMouseListener(new PanelEvent(pnItem.getType(), pnItem.getJpn()));
        }
    }

    class PanelEvent implements MouseListener {

        private JPanel node;
        private final String type;

        public PanelEvent(String type, JPanel jpnItem) {
            this.type = type;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            item.setType(type);
            switch (type) {
                case "Home" -> {
                    node = new JpannelHome();
                    item.setJpn(node);
                }
                case "Account" -> {
                    try {
                        node = new JpannelAccount();
                        item.setJpn(node);
                    } catch (SQLException ex) {
                        Logger.getLogger(ScreenSwitch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case "Employee" -> {
                    node = new JpanelEmployee();
                    item.setJpn(node);
                }
                case "Statistical" -> {
                    node = new JpannelStatistical();
                    item.setJpn(node);
                }
                case "Discount" -> {
                    try {
                        node = new JpannelDiscount();
                         item.setJpn(node);
                    } catch (SQLException ex) {
                        Logger.getLogger(ScreenSwitch.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
                }
                default -> {
                    node = new JpannelHome();
                    item.setJpn(node);
                }


            }
            root.removeAll();
//            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
//            setChangeBackgroud(type);
        }

        @Override
        public void mousePressed(MouseEvent e) {
//            typeselected = type;
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
        public void mouseExited(MouseEvent e) {
//            if(typeselected.equalsIgnoreCase(type))
//            {
//              jpnItem.setBackground(new Color(96,100,191));
//              jlbItem.setBackground(new Color(96,100,191));  
//            }
        }

    }
//        private void setChangeBackgroud(String type)
//        {
//            for(DanhMuc item : listiteam)
//            {
//                if(item.getKind().equalsIgnoreCase(type))
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
