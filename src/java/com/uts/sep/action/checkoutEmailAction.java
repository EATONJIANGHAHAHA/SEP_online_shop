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
import com.uts.sep.entity.ShoppingCartTbl;
import java.util.List;

/**
 *
 * @author Edric
 */
public class checkoutEmailAction /*extends ActionSupport implements SessionAware*/{
    private UserTbl user;
    //private List<ShoppingCartTbl> cart; //dont need?
    //private List<ItemTbl> items = ItemDAO.getAll("ItemTbl");
    
    //ShoppingCartDAO cartDAO = new ShoppingCartDAO(); //dont need?
    ItemDAO itemDAO = new ItemDAO();
    UserDAO userDAO = new UserDAO();
    
    public static void SendEmail (int userId, List<ShoppingCartTbl> checkoutItems) {
        //get user details from userdao using _userId
        
        
        //get list of items from itemdao using itemIds from checkoutItems
        
        
        //construct email
    }

// MAYBE USE THIS
//    private Map session;
//    
//    //establish session info
//    @Override
//    public void setSession(Map session) {
//        this.session = session;
//    }
//    
//    //actions and methods
//    @Override
//    public String execute() throws Exception {
//        
//        
//        return SUCCESS;
//    }
    
}
