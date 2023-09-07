/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.sql.Date;

public class Customer {
    private String customer_id,fullName,phone,email,gender;
    private int  total_spending;
    private Date dayOfBirth;
    private String address,country;

    public Customer(String customer_id, String fullName, String phone, String email, String gender, int total_spending, Date dayOfBirth, String address, String country) {
        this.customer_id = customer_id;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.gender = gender;
        this.total_spending = total_spending;
        this.dayOfBirth = dayOfBirth;
        this.address = address;
        this.country = country;
    }

    public Customer() {
    }

    public String getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(String customer_id) {
        this.customer_id = customer_id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getTotal_spending() {
        return total_spending;
    }

    public void setTotal_spending(int total_spending) {
        this.total_spending = total_spending;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
    
}
