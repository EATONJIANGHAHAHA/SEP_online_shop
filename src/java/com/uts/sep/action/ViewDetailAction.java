/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.entity.ItemTbl;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author eaton
 */
public class ViewDetailAction extends ActionSupport implements SessionAware{
    
    private ItemTbl item;
    private String itemId = "";
    private Map session;

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public int getItemIdInt(){
        return Integer.valueOf(itemId);
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    @Override
    public String execute() throws Exception {
        ItemDAO itemDao = new ItemDAO();
        item = itemDao.findById(getItemIdInt());
        this.session.put("viewing_item", item);
        return SUCCESS;
    }
}
