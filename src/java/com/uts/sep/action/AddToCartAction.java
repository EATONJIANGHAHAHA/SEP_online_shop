/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.opensymphony.xwork2.ActionSupport;
import com.uts.sep.dao.ShoppingCartDAO;
import com.uts.sep.entity.ItemTbl;
import com.uts.sep.entity.ShoppingCartTbl;
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
    private ShoppingCartTbl shoppingCart;
    private ShoppingCartDAO shoppingCartDao = new ShoppingCartDAO();
    private ItemTbl item;

    public ItemTbl getItem() {
        return item;
    }

    public void setItem(ItemTbl item) {
        this.item = item;
    }

    public ShoppingCartTbl getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCartTbl shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    @Override
    public void setSession(Map session) {
        this.session = session;
    }

    @Override
    public String execute() throws Exception {
        if (null == item) {
            this.session.put(ERROR, UNKNOWN_ERROR);
            return ERROR;
        } else {
            addToCart((ItemTbl)this.session.get("item_to_add"));
            this.session.put(SHOPPING_CART, shoppingCart);
            return SUCCESS;
        }
    }

    private void addToCart(ItemTbl item) {
        Set<ItemTbl> items = (Set<ItemTbl>) shoppingCart.getShoppingCartItemTbls();
        item.setIsAdded(1);
        items.add(item);
        shoppingCart.setShoppingCartItemTbls(items);
        updateDatabase();
    }
    
    private void updateDatabase(){
        shoppingCartDao.update(shoppingCart);
    }

}
