/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{
    
    List<ItemTbl> items = getAll(ITEM_TBL);

    public List<ItemTbl> getItems() {
        return items;
    }

    public void setItems(List<ItemTbl> items) {
        this.items = items;
    }
    
    public void addItem(String itemName){
        ItemTbl newitem = new ItemTbl(itemName, 20, 1, 50, 0);
        items.add(newitem);
        insertNew(newitem);
    }
    
    public void removeItem(Integer id){
        ItemTbl item = findById(id);
        items.remove(item);
    }
    
    public List<ItemTbl> getAllAddedItems(){
        List<ItemTbl> newList = new ArrayList<>();
        for(ItemTbl item: items){
            if(item.getIsAdded()==1){
                newList.add(item);
            }
        }
        return newList;
    }
}