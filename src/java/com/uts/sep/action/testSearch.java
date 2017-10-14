/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.action;

import com.uts.sep.dao.ItemDAO;
import com.uts.sep.entity.ItemTbl;
import java.util.List;

/**
 *
 * @author Edric
 */
public class testSearch {

    public static void main(String[] args) {
        ItemDAO itemDAO = new ItemDAO();
        //itemDAO.addItem("test");
        //ItemTbl item = new ItemTbl(10, "name of the pro", "wtf",10, 2, 2.22);
        //itemDAO.insertNew(item);
        List<ItemTbl> list = itemDAO.getAll(ItemDAO.ITEM_TBL);
        for (ItemTbl oneitem : list) {
            System.out.print(oneitem);
        }
    }

}
