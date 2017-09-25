/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.List;

/**
 * This class will help updating database and getting data from the database
 * for ItemTbl type.
 * @author yichen jiang
 */
public class ItemDAO extends BaseDAO<ItemTbl> {
    
    public static final String CATEGORY_BOOK = "book";
    public static final String CATEGORY_COMPUTER = "computer";
    public static final String CATEGORY_PHONE = "phone";
    public static final String CATEGORY_GAME_CONSOLES = "game consoles";

    public void updateItemName(Integer itemId, String itemName) {
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemName(itemName);
        update(usingItem);
    }

    public void updateItemDescription(Integer itemId, String itemDescription) {
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemDescription(itemDescription);
        update(usingItem);
    }

    public void updateItemStock(Integer itemId, Integer stock) {
        ItemTbl usingItem = findById(itemId);
        usingItem.setStock(stock);
        update(usingItem);
    }

    public void updateItemStatus(Integer itemId, Integer itemStatus) {
        ItemTbl usingItem = findById(itemId);
        usingItem.setItemStatus(itemStatus);
        update(usingItem);
    }

    public void updatePrice(Integer itemId, Double price) {
        ItemTbl usingItem = findById(itemId);
        usingItem.setPrice(price);
        update(usingItem);
    }

    public boolean updateItemPicUrl(Integer itemId, String Url) {
        ItemTbl usingItem = findById(itemId);
        List<ItemTbl> items = getAll(ITEM_TBL);
        boolean UrlIsUsed = false;
        for(ItemTbl item :items){
            if(item.getItemPicUrl().equals(Url)) {
                UrlIsUsed = true;
                return false;
            }
        }
        if (!UrlIsUsed) {
            usingItem.setItemPicUrl(Url);
            update(usingItem);
            return true;
        }
        else return false;
    }
    
    /**
     * This method will update the category of an item.
     * Please do notice that I statically put four existing category string
     * inside this class, use those as for now. Please DO NOT use any other
     * Strings. 
     * @param itemId 
     * @param category 
     */
    public void updateCategory(Integer itemId, String category){
        ItemTbl usingItem = findById(itemId);
        usingItem.setCategory(category);
        update(usingItem);
    }
}
