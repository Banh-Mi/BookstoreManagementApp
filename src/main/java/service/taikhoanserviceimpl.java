/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import Dao.TaiKhoanDAO;
import Dao.TaiKhoanDAOImpl;
import entity.taikhoan;

/**
 *
 * @author VONG VINH LOI
 */
public class taikhoanserviceimpl implements taikhoanservice{

    private TaiKhoanDAO taikhoandao = null;

    public taikhoanserviceimpl() {
        taikhoandao = new TaiKhoanDAOImpl();
    }
    
    @Override
    public taikhoan login(String tdn, String mk) {
        return taikhoandao.login(tdn, mk);
    }
    
}
