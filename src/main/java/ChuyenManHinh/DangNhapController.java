package ChuyenManHinh;

import entity.taikhoan;
import service.taikhoanservice;
import service.taikhoanserviceimpl;
import gui.ApplicationFrame;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DangNhapController {

    private JFrame jframe;
    private JButton btnSubmit;
    private JTextField jtfTenDangNhap;
    private JTextField jtfMatKhau;
    private JLabel jlbMsg;

    private taikhoanservice taiKhoanService = null;

    public DangNhapController(JFrame jframe, JButton btnSubmit,
            JTextField jtfTenDangNhap, JTextField jtfMatKhau, JLabel jlbMsg) {
        this.jframe = jframe;
        this.btnSubmit = btnSubmit;
        this.jtfTenDangNhap = jtfTenDangNhap;
        this.jtfMatKhau = jtfMatKhau;
        this.jlbMsg = jlbMsg;

        taiKhoanService = new taikhoanserviceimpl();
    }

    public void setEvent() {
        btnSubmit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (jtfTenDangNhap.getText().length() == 0
                            || jtfMatKhau.getText().length() == 0) {
                        jlbMsg.setText("Vui lòng nhập dữ liệu bắt buộc!");
                    } else {
                        taikhoan taiKhoan = taiKhoanService.login(jtfTenDangNhap.getText(), jtfMatKhau.getText());
                        if (taiKhoan == null) {
                            jlbMsg.setText("Tên đăng nhập và mật khẩu không đúng!");
                        } else {
                            if (!taiKhoan.isTinhtrang()) {
                                jlbMsg.setText("Tài khoản của bạn đang bị tạm khóa!");
                            } else {
                                jframe.dispose();
                                new ApplicationFrame().setVisible(true);
                            }
                        }
                    }
                } catch (Exception ex) {
                    jlbMsg.setText(ex.toString());
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
//                btnSubmit.setBackground(new Color(0, 200, 83));
            }

            @Override
            public void mouseExited(MouseEvent e) {
//                btnSubmit.setBackground(new Color(100, 221, 23));
            }
        });

    }

}
