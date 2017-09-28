/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

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
public class LoginAction extends ActionSupport implements SessionAware {
    
    public final static String USER_NOT_EXIST_ERROR = "user not exist error";

    private String username = "";
    private String password = "";
    private Map session;
    private UserTbl user;
    private String errorName;

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

    @Override
    public String execute() throws Exception {

        this.session.put("user_name", username);

        UserDAO userDao = new UserDAO();
        List<UserTbl> list = userDao.getAll(BaseDAO.USER_TBL);
        UserTbl usingUser = null;
        
        
        for (UserTbl user : list) {
            if (user.getUserName().equals(username)) {
                usingUser = user;
                this.user = user;
                this.session.put("user", this.user);
                break;
            }

        }
        if (usingUser == null) {
            return ERROR;
        } else if (usingUser.getUserName().equals(username) && usingUser.getUserPassword().equals(password)){
            System.out.println(usingUser.getUserName());
            System.out.println(usingUser.getUserPassword());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
