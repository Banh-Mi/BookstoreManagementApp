/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author VONG VINH LOI
 */
public class ThongKeSanPham {
    private String ma;
    private String ten;
    private Double soLuong;
    private Double thanhtien;

    public ThongKeSanPham(String ma, String ten, Double soLuong, Double thanhtien) {
        this.ma = ma;
        this.ten = ten;
        this.soLuong = soLuong;
        this.thanhtien = thanhtien;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Double soLuong) {
        this.soLuong = soLuong;
    }

    public Double getThanhtien() {
        return thanhtien;
    }

    public void setThanhtien(Double thanhtien) {
        this.thanhtien = thanhtien;
    }
    
}
