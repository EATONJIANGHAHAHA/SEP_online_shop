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

/**
 *
 * @author lzy
 */
public class testDAO {

    public static void main(String[] args) {

        ItemDAO dao = new ItemDAO();
        ArrayList<ItemTbl> list = (ArrayList<ItemTbl>) dao.getItemsFiltedByName("iphone 7");
        System.out.print(list.get(0).getItemName());

//        List<ItemTbl> list = dao.getAll(BaseDAO.ITEM_TBL);
//        for(ItemTbl item : list){
//            System.out.print(item.getItemName());
//        }
    }

}
