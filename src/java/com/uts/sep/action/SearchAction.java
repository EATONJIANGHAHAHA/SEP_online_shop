/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.BaseDAO;
import com.uts.sep.dao.ItemDAO;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author lzy
 */
public class SearchAction extends ActionSupport implements SessionAware {

    private ItemDAO itemDAO = new ItemDAO();
    
    private String keyword = "";
    private Map session;

    @Override
    public void setSession(Map session) {
        this.session = session;
    }
    
    //keyword functions needed to link to view keyword
    public String getKeyword() {
        return keyword; 
    }
    
    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
    
    public String searchItems() throws Exception {
        
        itemDAO.setItems(itemDAO.searchModels(BaseDAO.SEARCH_BY_ITEM_DESCRIPTION,keyword));
        this.session.put("itemlist", itemDAO.getItems());
        return SUCCESS;
    }
}

