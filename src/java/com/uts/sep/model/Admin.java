/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

/**
 *
 * @author tomat
 */
public class Admin extends User{
    String adminName;
    String password;
    /*
    ther are three levels for admin levels, 
    1 is the highest, 
    2 is the midiem, 
    3 is the lowest. 
    before we construct the specific authentication system, 
    please be noticed for this. 
    */
    int adminLevel;
    
    public int getAdminLevel() {
        return adminLevel;
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

    public void setAdminLevel(int adminLevel) {
        this.adminLevel = adminLevel;
    }
    

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public Admin(){};

    public Admin(String adminName, String email, String password, int adminLevel) {
        this.adminName = adminName;
        this.password = password;
        this.adminLevel = adminLevel;
    }
}
