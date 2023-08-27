package entity;

public class Account {

    private String accountID;
    private String userName;
    private String password;
    private String role;
    private boolean status;

    public Account(String accountID, String userName, String password, String role, boolean status) {
        this.accountID = accountID;
        this.userName = userName;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Account() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
