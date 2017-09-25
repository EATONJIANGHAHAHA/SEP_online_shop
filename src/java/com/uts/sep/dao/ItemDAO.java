/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{
    
    public void updateItemName(Integer itemId, String itemName){
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemName(itemName);
        super.update(usingItem);
    }
    
    public void updateItemDescription(Integer itemId, String itemDescription){
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemDescription(itemDescription);
        super.update(usingItem);
    }
    
    public void updateItemStock(Integer itemId, int stock){
        ItemTbl usingItem = findById(itemId);
        usingItem.setStock(stock);
        super.update(usingItem);
    }
    
    public void updateItemStatus(Integer itemId, int itemStatus){
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemStatus(itemStatus);
        super.update(usingItem);
    }
}
