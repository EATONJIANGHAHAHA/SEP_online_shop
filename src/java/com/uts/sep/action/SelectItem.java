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
public class SelectItem extends ActionSupport implements SessionAware{
    //class variables
    private Map session;
    private int selectedId; //number is not being sent to this class
    //variables returned
    private List<ItemTbl> itemlist = new ArrayList<ItemTbl>();
    private List<UserTbl> itemowner = new ArrayList<UserTbl>();;

    //establish session info
    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    //getters and setters
    public int getselectedId() {
        return this.selectedId;
    }

    public void setSelectedId(int selectedId) {
        this.selectedId = selectedId;
    }
    
    //actions and methods
    @Override
    public String execute() throws Exception {
        String test = String.valueOf(selectedId);
        
        ItemDAO itemDao = new ItemDAO();
        UserDAO userDao = new UserDAO();
        
        itemlist = itemDao.getItemByID(test);
        itemowner = userDao.getUserById(itemlist.get(0).getOwnerId()); //itemlist[0].ownerId
        
        this.session.put("itemlist", itemlist);
        this.session.put("itemowner", itemowner);
        return SUCCESS; 
    }
}
