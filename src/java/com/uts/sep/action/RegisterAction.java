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
    
    public static final String ERROR_NAME = "error_name";
    public static final String USER_NAME = "user_name";
    public static final String FORM_NOT_COMPLETE_ERROR = "form not complete";
    public static final String USER_ALREADY_EXIST_ERROR = "user already exist";
    public static final String PASSWORD_NOT_REPEATED_ERROR = "passwords are not correct";

    private String username = "";
    private String password = "";
    private String repeatedPassword = "";
    private Map session;

    @Override
    public void setSession(Map session) {
        this.session = session;
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
        
        if(username.equals("") || password.equals("")){
            this.session.put(ERROR_NAME, FORM_NOT_COMPLETE_ERROR);
            return ERROR;
        }
        for (UserTbl user: list){
            if(user.getUserName().equals(username)){
                this.session.put(ERROR_NAME, USER_ALREADY_EXIST_ERROR);
                return ERROR;
            }
        }
        if (1==1) {
            this.session.put(USER_NAME, username);
            UserTbl user = new UserTbl(username, password, 1);
            userDao.insertNew(user);
            return SUCCESS;
        } else if(!password.equals(repeatedPassword)){
            this.session.put(ERROR_NAME, PASSWORD_NOT_REPEATED_ERROR);
            return ERROR;
        }
        else return ERROR;
    }
}
