package util;

import dao.NhanVienDAO;
import dao.TaiKhoanDAO;
import entity.TaiKhoan;
import entity.NhanVien;
import gui.JFrame_GiaoDienChinh;
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
import org.apache.commons.codec.digest.DigestUtils;

public class LoginController {

    private final JFrame frame;
    private final JButton btnSubmit;
    private final JTextField txtUserName;
    private final JTextField txtPassword;
    private final JLabel jbMessage;

    public LoginController(JFrame frame, JButton btnSubmit,
            JTextField txtUserName, JTextField txtPassword, JLabel jbMessage) {
        this.frame = frame;
        this.btnSubmit = btnSubmit;
        this.txtUserName = txtUserName;
        this.txtPassword = txtPassword;
        this.jbMessage = jbMessage;
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
        String userName = txtUserName.getText().trim();
        String password = txtPassword.getText().trim();

        try {
            if (userName.length() == 0
                    || password.length() == 0) {
                jbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
            } else {
                TaiKhoanDAO taiKhoanDAO = new TaiKhoanDAO();
                TaiKhoan taiKhoan = taiKhoanDAO.checkAccount(userName, DigestUtils.md5Hex(password).toUpperCase());
                if (taiKhoan == null) {
                    jbMessage.setText("Tên đăng nhập hoặc mật khẩu không đúng!");
                } else {
                    if (taiKhoan.getTrangThaiTaiKhoan().equals("Tạm khoá")) {
                        jbMessage.setText("Tài khoản của bạn đang bị tạm khóa!");
                    } else if(taiKhoanDAO.checkCaLamViec(userName)) {
                        frame.dispose();
                        NhanVienDAO nhanVienDao = new NhanVienDAO();
                        NhanVien nhanVien = nhanVienDao.searchEmployee(userName);
                        JFrame_GiaoDienChinh aplFrame = new JFrame_GiaoDienChinh(nhanVien);
                        aplFrame.setVisible(true);

                    }else {
                         jbMessage.setText("Chưa đến giờ làm việc!");
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
            jbMessage.setText(ex.toString());
        }
    }

}
