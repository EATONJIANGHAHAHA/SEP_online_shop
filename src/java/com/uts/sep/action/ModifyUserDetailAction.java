/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.BaseDAO;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.entity.UserTbl;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import java.util.List;

/**
 *
 * @author eaton
 */
public class ModifyUserDetailAction extends ActionSupport implements SessionAware {

    public static final String MODIFY_USER_DETAIL_TABLE = "modify user detail table";
    public static final String PASSWORD_NOT_MATCH_ERROR = "password not match";
    public static final String NOT_LOGIN_IN_ERROR = "user not login in";
    
    private Map session;
    private UserTbl user;
    private String checkPassword;
    private String newPassword;
    private String newName;
    private String errorName;

    public String getErrorName() {
        return errorName;
    }

    public void setErrorName(String errorName) {
        this.errorName = errorName;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }

    public void setUser(UserTbl user) {
        this.user = user;
    }

    public UserTbl getUser(UserTbl user) {
        return this.user;
    }

    @Override
    public void validate() {
        super.validate();
    }

    @Override
    public String execute() {
        UserDAO dao = new UserDAO();
        List<UserTbl> list = dao.getAll(BaseDAO.USER_TBL);
        UserTbl usingUser = (UserTbl) session.get("user");
        if(null == usingUser){
            errorName = NOT_LOGIN_IN_ERROR;
            return ERROR;
        } else if (dao.isPasswordCorrect(user.getUserId(), checkPassword)) {
            dao.updateUserName(usingUser.getUserId(), newName);
            dao.updatePassword(usingUser.getUserId(), newPassword);
            this.session.put(MODIFY_USER_DETAIL_TABLE, SUCCESS);
            return SUCCESS;
        } else if(!dao.isPasswordCorrect(user.getUserId(), checkPassword)){
            errorName = PASSWORD_NOT_MATCH_ERROR;
            return ERROR;
        } 
        else return ERROR;
    }
}
