package com.uts.sep.entity;
// Generated Sep 25, 2017 3:26:28 PM by Hibernate Tools 4.3.1

/**
 * UserTbl generated by hbm2java
 */
public class UserTbl implements java.io.Serializable {

    private Integer userId;
    private String userName;
    private String userPassword;
    private int loginStatus;

    public UserTbl() {
    }

    public UserTbl(String userName, String userPassword, int loginStatus) {
        this.userName = userName;
        this.userPassword = userPassword;
        this.loginStatus = loginStatus;
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

}
