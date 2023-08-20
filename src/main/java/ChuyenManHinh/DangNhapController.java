package ChuyenManHinh;

import entity.taikhoan;
import service.taikhoanservice;
import service.taikhoanserviceimpl;
import gui.ApplicationFrame;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class DangNhapController {

    private final JFrame jframe;
    private final JButton btnSubmit;
    private final JTextField jtfTenDangNhap;
    private final JTextField jtfMatKhau;
    private final JLabel jlbMsg;

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
                performLogin();
            }
        });

        // Bắt sự kiện nhấn Enter cho btnSubmit
        btnSubmit.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("ENTER"), "enterPressed");
        btnSubmit.getActionMap().put("enterPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });
    }

    private void performLogin() {
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

}
