/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.AdminTbl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author eaton
 */
public class AdminDAO extends BaseDAO<AdminTbl>{
    
    private static SessionFactory factory = null;
    
    public void updataAdminName(Integer adminid, String name){
        AdminTbl usingAdminTbl = super.findById(adminid);
        usingAdminTbl.setAdminName(name);
        super.update(usingAdminTbl);
    }
}
