/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.Action;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import static com.uts.sep.action.ModifyUserDetailAction.ERROR;
import static com.uts.sep.action.ModifyUserDetailAction.NOT_LOGIN_IN_ERROR;
import com.uts.sep.dao.BaseDAO;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.entity.UserTbl;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lzy
 */
public class RegisterAction extends ActionSupport implements SessionAware {
    
    public static final String FORM_NOT_COMPLETE_ERROR = "form not complete";
    public static final String USER_ALREADY_EXIST_ERROR = "user already exist";
    public static final String PASSWORD_NOT_REPEATED_ERROR = "passwords are not correct";
    public static final String ERROR = "error";

    private String username = "";
    private String password = "";
    private String repeatedPassword = "";
    private String email;
    private Map session;
    private String errorName;

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getrepeatedPassword() {
        return repeatedPassword;
    }

    public void setRepeatedPassword(String repeatedPassword) {
        this.repeatedPassword = repeatedPassword;
    }

    @Override
    public String execute() throws Exception {

        UserDAO userDao = new UserDAO();
        List<UserTbl> list = userDao.getAll(BaseDAO.USER_TBL);
        UserTbl usingUser = null;
        boolean isUserExist = false;
        
        if(username.equals("") || password.equals("")){
            this.session.put(ERROR,FORM_NOT_COMPLETE_ERROR);
            return ERROR;
        }
        for (UserTbl user: list){
            if(user.getUserName().equals(username)){
                this.session.put(ERROR,USER_ALREADY_EXIST_ERROR);
                isUserExist = true;
                return ERROR;
            }
        }
        if (!isUserExist) {
            UserTbl user = new UserTbl(username, password, 1, email,0);
            this.session.put("user", user);
            userDao.insertNew(user);
            return SUCCESS;
        } else if(!password.equals(repeatedPassword)){
            this.session.put(ERROR,PASSWORD_NOT_REPEATED_ERROR);
            return ERROR;
        }
        else return ERROR;
    }
}
