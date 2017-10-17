/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.dao.ShoppingCartDAO;
import com.uts.sep.entity.UserTbl;
import com.uts.sep.entity.ItemTbl;

/**
 *
 * @author Edric
 */
public class CheckoutAction extends ActionSupport implements SessionAware{
    private Map session;
    private int selectedUserId;
    
    //establish session info
    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    public int getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(int selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
    
    //actions and methods
    @Override
    public String execute() throws Exception {
        

        //
        
    
        return SUCCESS;
    }
    
}
