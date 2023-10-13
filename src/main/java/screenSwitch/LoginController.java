package screenSwitch;

import dao.NhanVienDAO;
import entity.TaiKhoan;
import entity.NhanVien;
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
import service.AccountService;

public class LoginController {

    private final JFrame frame;
    private final JButton btnSubmit;
    private final JTextField txtUserName;
    private final JTextField txtPassword;
    private final JLabel jbMessage;

    private AccountService accountService = null;

    public LoginController(JFrame frame, JButton btnSubmit,
            JTextField txtUserName, JTextField txtPassword, JLabel jbMessage) {
        this.frame = frame;
        this.btnSubmit = btnSubmit;
        this.txtUserName = txtUserName;
        this.txtPassword = txtPassword;
        this.jbMessage = jbMessage;

        accountService = new AccountService();
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
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        try {
            if (userName.length() == 0
                    || password.length() == 0) {
                jbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
            } else {
                TaiKhoan taiKhoan = accountService.login(userName,password );
                System.out.println(taiKhoan.getTrangThaiTaiKhoan());
                if (taiKhoan == null) {
                    jbMessage.setText("Tên đăng nhập và mật khẩu không đúng!");
                } else {
                    if (taiKhoan.getTrangThaiTaiKhoan().equals("Tạm khoá")) {
                        jbMessage.setText("Tài khoản của bạn đang bị tạm khóa!");
                    } else {
                        frame.dispose();
                        ApplicationFrame aplFrame = new ApplicationFrame();
                        NhanVienDAO nhanVienDao = new NhanVienDAO();
                        NhanVien nhanVien = nhanVienDao.searchEmployee(userName);
                        aplFrame.setThongTin(nhanVien.getTenNV(), nhanVien.getChucVu());
                        aplFrame.setVisible(true);
                        
                    }
                }
            }
        } catch (Exception ex) {
            jbMessage.setText(ex.toString());
        }
    }

}
