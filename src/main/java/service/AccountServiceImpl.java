/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.AccountDAOImpl;
import entity.Account;
import Dao.AccountDAO;

/**
 *
 * @author VONG VINH LOI
 */
public class AccountServiceImpl implements AccountService{

    private AccountDAO accountDAO = null;

    public AccountServiceImpl() {
        accountDAO = new AccountDAOImpl();
    }
    
    @Override
    public Account login(String userName, String password) {
        return accountDAO.login(userName, password);
    }
    
}
