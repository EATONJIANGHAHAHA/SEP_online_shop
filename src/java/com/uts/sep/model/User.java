/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import com.uts.sep.dao.BaseDAO;

/**
 *
 * @author lzy
 */
public class User extends BaseDAO{  
  
    String id;
    String name;  
    String password;
    String email;
    int loginStatus;
    int userType;

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
    
    public User() {}
    
    public User(String id, String name, String password, String email, int loginStatus, int userType) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.loginStatus = loginStatus;
        this.userType = userType;
    }
}  
