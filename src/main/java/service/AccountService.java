/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import entity.TaiKhoan;
import dao.TaiKhoanDAO;

/**
 *
 * @author VONG VINH LOI
 */
public class AccountService{

    private TaiKhoanDAO accountDAO = null;

    public AccountService() {
        accountDAO = new TaiKhoanDAO();
    }

    public TaiKhoan login(String userName, String password) {
        return accountDAO.login(userName, password);
    }
    
}
