/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.*;

/**
 *
 * @author lzy
 */
public class testDAO {

    public static void main(String[] args) {
        ItemDAO dao = new ItemDAO();
        List<ItemTbl> list = dao.getAll(BaseDAO.ITEM_TBL);

        //dao.insertUser("ZheyiLu", "123456");
        for (int i = 0; i < list.size(); i++) {
            ItemTbl item = new ItemTbl();
            item = list.get(i);
            System.out.print(item.getItemName());
            System.out.print(item.getStock());
            System.out.print(item.getPrice());

        }
        
//        AdminDAO dao = new AdminDAO();
//        dao.getAll("from AdminTbl");
    }

}
