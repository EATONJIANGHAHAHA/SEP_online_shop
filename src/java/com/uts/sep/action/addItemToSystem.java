/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.ItemDAO;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author eaton
 */
public class addItemToSystem extends ActionSupport implements SessionAware{

    private ItemDAO itemDAO = new ItemDAO();
    private Map session;
    private String itemName;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() throws Exception {
        itemDAO.addItem(itemName);
        this.session.put("itemlist", itemDAO.getItems());
        return SUCCESS;
    }
}
