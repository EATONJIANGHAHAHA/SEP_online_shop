/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.ItemDAO;
import com.uts.sep.dao.UserDAO;
import com.uts.sep.dao.ShoppingCartDAO;
import com.uts.sep.entity.UserTbl;
import com.uts.sep.entity.ItemTbl;
import com.uts.sep.entity.ShoppingCartTbl;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author Edric
 */
public class SelectUserCart extends ActionSupport implements SessionAware{
    private Map session;
    private int selectedUserId;
    private int selectedItemId;
    private List<UserTbl> itemowner = new ArrayList<UserTbl>();
    private List<ItemTbl> itemlist = new ArrayList<ItemTbl>();
    private ItemTbl itemToAdd;

    public int getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(int selectedItemId) {
        this.selectedItemId = selectedItemId;
    }
    
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
        ShoppingCartDAO cartDAO = new ShoppingCartDAO();
        List<ShoppingCartTbl> cartlist = cartDAO.getAll("ShoppingCartTbl");
        boolean itemExists = true;
        if(selectedItemId != 0){
            //add entry into shopping_cart_tbl
            //ShoppingCartTbl cartItem = new ShoppingCartTbl(selectedItemId, selectedUserId);
            itemExists = false;
            if(cartlist.size() == 0) {
                cartDAO.addCartItem(selectedItemId, selectedUserId);
            }
            else {
                for(ShoppingCartTbl s : cartlist){
                    if(s.getItemId() == selectedItemId) {
                        //item exists
                        itemExists = true;
                    }
                }
                if (itemExists == false) {
                    cartDAO.addCartItem(selectedItemId, selectedUserId);
                }
            }

            //get a list of all itemIds from shopping_tbl_cart with selectedUserId
            //List<ShoppingCartTbl> cartlist = cartDAO.getAll("ShoppingCartTbl");
            
            //cartlist.clear();
            //put these items in the session list
    //        itemToAdd = itemDao.findById(selectedItemId);
             //itemlist[0].ownerId
    //        itemlist = //all items in users cart
    //        
            
        }
        else {
            this.session.put("isItemAdded", 0);
        }
        List<ShoppingCartTbl> displaylist = cartDAO.getAll("ShoppingCartTbl");
        for(ShoppingCartTbl c : displaylist) {
            if(c.getUserId() == selectedUserId) {
                itemlist.add(itemDao.findById(c.getItemId()));
            }
        }
        
        itemowner = userDao.getUserById(selectedUserId);
        
        this.session.put("itemowner", itemowner);
        this.session.put("itemlist", itemlist);
        
        return SUCCESS;
    }
}
