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
        dao.updatePrice(1, 230.25);
        ItemTbl usingItem = dao.findById(1);
        System.out.print(usingItem.getPrice());
    }

}
