
package model;


public class Account {
    private int accountID;
    private String userName;
    private String password;
    private boolean status;

    public int getMataikhoan() {
        return accountID;
    }

    public void setMataikhoan(int accountID) {
        this.accountID = accountID;
    }

    public String getTendangnhap() {
        return userName;
    }

    public void setTendangnhap(String userName) {
        this.userName = userName;
    }

    public String getMatkhau() {
        return password;
    }

    public void setMatkhau(String password) {
        this.password = password;
    }

    public boolean isTinhtrang() {
        return status;
    }

    public void setTinhtrang(boolean status) {
        this.status = status;
    }
    
}
