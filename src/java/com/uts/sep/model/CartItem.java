/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.model;

import com.uts.sep.dao.BaseDAO;

/**
 *
 * @author tomat
 */
public class CartItem extends BaseDAO{
    int quantity;
    String size;
    int itemID;
    int shoppingCartID;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public int getShoppingCartID() {
        return shoppingCartID;
    }

    public void setShoppingCartID(int shoppingCartID) {
        this.shoppingCartID = shoppingCartID;
    }

    public CartItem(int quantity, String size, int itemID, int shoppingCartID) {
        this.quantity = quantity;
        this.size = size;
        this.itemID = itemID;
        this.shoppingCartID = shoppingCartID;
    }

    public CartItem() {
    }
}
