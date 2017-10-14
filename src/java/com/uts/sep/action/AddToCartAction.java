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
import java.util.Set;
import org.apache.struts2.interceptor.SessionAware;

/**
 *
 * @author eaton
 */
public class AddToCartAction extends ActionSupport implements SessionAware {

    public static final String SHOPPING_CART = "shopping cart";
    public static final String ERROR = "error";
    public static final String UNKNOWN_ERROR = "unknown error";

    private Map session;
    private ItemDAO itemDao = new ItemDAO();
    private ItemTbl item;
    private String itemId = "";

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public ItemTbl getItem() {
        return item;
    }

    public void setItem(ItemTbl item) {
        this.item = item;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        if (itemId.equals("")) {
            this.session.put(ERROR, UNKNOWN_ERROR);
            return ERROR;
        } else if (!itemId.equals("")) {
            item = itemDao.findById(Integer.valueOf(itemId));
        } else if (null == item) {
            return ERROR;
        }
        addToCart();
        return SUCCESS;

    }

    private void addToCart() {
        updateDatabase();
    }

    private void updateDatabase() {
        //shoppingCartDao.update(shoppingCart);
        itemDao.update(item);
    }

}
