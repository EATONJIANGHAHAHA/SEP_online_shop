/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.CustomerTbl;
import com.uts.sep.entity.UserTbl;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author eaton
 */
public class UserDAO extends BaseDAO<UserTbl>{

    public void updateLoginStatus(Integer userId, int status){
        UserTbl usingUser = findById(userId);
        usingUser.setLoginStatus(status);
        update(usingUser);
    }
    
    public void updatePassword(Integer userId, String password){
        UserTbl usingUser = (UserTbl) findById(userId);
        usingUser.setUserPassword(password);
        update(usingUser);
    }
    
}
