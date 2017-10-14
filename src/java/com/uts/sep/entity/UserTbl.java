package com.uts.sep.entity;
// Generated Oct 14, 2017 5:40:16 PM by Hibernate Tools 4.3.1

import java.util.List;




/**
 * UserTbl generated by hbm2java
 */
public class UserTbl  implements java.io.Serializable {


     private Integer userId;
     private String userName;
     private String userPassword;
     private int loginStatus;
     private String userEmail;
     private int userType;

    public UserTbl() {
    }

    public UserTbl(String userName, String userPassword, int loginStatus, String userEmail, int userType) {
       this.userName = userName;
       this.userPassword = userPassword;
       this.loginStatus = loginStatus;
       this.userEmail = userEmail;
       this.userType = userType;
    }
   
    public Integer getUserId() {
        return this.userId;
    }
    
    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getUserName() {
        return this.userName;
    }
    
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserPassword() {
        return this.userPassword;
    }
    
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    public int getLoginStatus() {
        return this.loginStatus;
    }
    
    public void setLoginStatus(int loginStatus) {
        this.loginStatus = loginStatus;
    }
    public String getUserEmail() {
        return this.userEmail;
    }
    
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public int getUserType() {
        return this.userType;
    }
    
    public void setUserType(int userType) {
        this.userType = userType;
    }
}


