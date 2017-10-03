/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.CustomerTbl;
import com.uts.sep.entity.ItemTbl;
import com.uts.sep.entity.UserTbl;
import java.util.*;
import javax.print.DocFlavor;

/**
 *
 * @author lzy
 */
public class testDAO {

    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAO();
        ItemTbl item = new ItemTbl(5,"fire", "fire sale", 1, 2, 3);
        itemDAO.insertNew(item);
        
        List<ItemTbl> items = itemDAO.getAll(ItemDAO.ITEM_TBL);
        for (ItemTbl oneItem: items){
            System.out.print(oneItem);
        }
    }

}
