package screenSwitch;

import entity.Account;
import service.AccountServiceImpl;
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

        accountService = new AccountServiceImpl();
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
            if (txtUserName.getText().length() == 0
                    || txtPassword.getText().length() == 0) {
                jbMessage.setText("Vui lòng nhập dữ liệu bắt buộc!");
            } else {
                Account taiKhoan = accountService.login(txtUserName.getText(), txtPassword.getText());
                if (taiKhoan == null) {
                    jbMessage.setText("Tên đăng nhập và mật khẩu không đúng!");
                } else {
                    if (!taiKhoan.isStatus()) {
                        jbMessage.setText("Tài khoản của bạn đang bị tạm khóa!");
                    } else {
                        frame.dispose();
                        new ApplicationFrame().setVisible(true);
                    }
                }
            }
        } catch (Exception ex) {
            jbMessage.setText(ex.toString());
        }
    }

}
