/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.AdminTbl;
import org.hibernate.SessionFactory;

/**
 *
 * @author eaton
 */
public class AdminDAO extends BaseDAO<AdminTbl>{
    
    public void updataName(Integer adminid, String name){
        AdminTbl usingAdmin = findById(adminid);
        usingAdmin.getUserTbl().setUserName(name);
        update(usingAdmin);
    }
    
    public void updateAuthorityLevel(Integer userId, int authorityLevel){
        AdminTbl usingAdmin = findById(userId);
        usingAdmin.setAuthorityLevel(authorityLevel);
        update(usingAdmin);
    }
}
