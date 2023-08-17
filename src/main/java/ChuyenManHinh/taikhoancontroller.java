
package ChuyenManHinh;

import gui.ApplicationFrame;
import java.awt.Frame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import model.taikhoan;
import service.taikhoanservice;
import service.taikhoanserviceimpl;



public class taikhoancontroller {
    private JFrame jframe;
    private JButton btnsubmit;
    private JTextField jtftendangnhap;
    private JTextField jtfmatkhau;
    private JLabel jlbmsg;
    private taikhoanservice taikhoanservice1 = null;
    public taikhoancontroller(JFrame jframe, JButton btnsubmit, JTextField jtftendangnhap, JTextField jtfmatkhau, JLabel jlbmsg) {
        this.jframe =jframe ;
        this.btnsubmit = btnsubmit;
        this.jtftendangnhap = jtftendangnhap;
        this.jtfmatkhau = jtfmatkhau;
        this.jlbmsg = jlbmsg;
        taikhoanservice1 = new taikhoanserviceimpl();
    }
    public void setEvent()
    {
       btnsubmit.addMouseListener(new MouseAdapter() {
       @Override
       public void mouseClicked(MouseEvent e)
       {
           if(jtftendangnhap.getText().length()==0||jtfmatkhau.getText().length()==0)
           {
               jlbmsg.setText("Vui long nhap du lieu bat buoc");
           }
           else 
           {
               taikhoan taikhoan1 = taikhoanservice1.login(jtftendangnhap.getText(), jtfmatkhau.getText());
               if(taikhoan1 == null)
               {
                   jlbmsg.setText("ten dang nhap hoac mat khau khong dung");
               }
               else 
               {
                   if(taikhoan1.isTinhtrang()==false)
                   {
                         jlbmsg.setText("tai khoan dang bi tam khoa");
                   }
                   else 
                   {
                       jframe.dispose();
                       new ApplicationFrame();
                   }
               }
           }
       }
           
       });
    }
}
