/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ShoppingCartTbl;

/**
 *
 * @author eaton
 */
public class ShoppingCartDAO extends BaseDAO<ShoppingCartTbl>{
    
    ShoppingCartTbl shoppingCart = new ShoppingCartTbl();

    public ShoppingCartTbl getShoppingCart() {
        return shoppingCart;
    }
    
}
