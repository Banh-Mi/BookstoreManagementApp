
package dao;

import entity.Account;

public interface AccountDAO {
    public Account login(String userName, String password);
}
