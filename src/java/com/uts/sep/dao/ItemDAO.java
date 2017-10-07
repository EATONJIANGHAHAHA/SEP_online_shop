/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.uts.sep.model.Item; //dont need?
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{
    
    public void addItem(String itemName) 
    {
        ItemTbl newitem = new ItemTbl(itemName, 20, 1, 50, 0);
        insertNew(newitem);
    }
    
    public List<ItemTbl> getAllAddedItems(){
        List<ItemTbl> items = getAll(ITEM_TBL);
        List<ItemTbl> newList = new ArrayList<>();
        for(ItemTbl item: items){
            if(item.getIsAdded()==1){
                newList.add(item);
            }
        }
        return newList;
    }
}