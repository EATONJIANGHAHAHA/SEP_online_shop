/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import java.sql.Date;

/**
 *
 * @author tomat
 */
public class Customer extends User{
    int creditCardNumber;
    Date creditCardExpireDate;
    int orderID;

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getCreditCardExpireDate() {
        return creditCardExpireDate;
    }

    public void setCreditCardExpireDate(Date creditCardExpireDate) {
        this.creditCardExpireDate = creditCardExpireDate;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public Customer() {
    }

    public Customer(int creditCardNumber, Date creditCardExpireDate, int orderID) {
        this.creditCardNumber = creditCardNumber;
        this.creditCardExpireDate = creditCardExpireDate;
        this.orderID = orderID;
    }
    
}
