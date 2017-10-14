/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.entity.ItemTbl;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.entity.UserTbl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
/**
 *
 * @author Edric
 */
public class SelectUser extends ActionSupport implements SessionAware{
    private Map session;
    private int selectedUserId;
//variables returned
    private List<ItemTbl> itemlist = new ArrayList<ItemTbl>();
    private List<UserTbl> itemowner = new ArrayList<UserTbl>();
    
    public int getSelectedUserId() {
        return selectedUserId;
    }

    public void setSelectedUserId(int selectedUserId) {
        this.selectedUserId = selectedUserId;
    }
    
    //establish session info
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    //actions and methods
    @Override
    public String execute() throws Exception {
        ItemDAO itemDao = new ItemDAO();
        UserDAO userDao = new UserDAO();
        
        itemlist = itemDao.getItemByOwner(Integer.toString(selectedUserId));
        itemowner = userDao.getUsersById(selectedUserId); //itemlist[0].ownerId
        
        this.session.put("itemlist", itemlist);
        this.session.put("itemowner", itemowner);
        
        return SUCCESS;
    }
}
