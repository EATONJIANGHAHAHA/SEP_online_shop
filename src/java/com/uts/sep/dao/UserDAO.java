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
    
    public static final short LOGING_IN = 1;
    public static final short LOGED_OUT = 0;
    
    interface Updater {
        
        void onUpdate(UserTbl user);
    }
    
    private class UpdateHelper {
        
        private void beginUpdate(Integer userId, Updater updater){
            
            UserTbl usingUser = findById(userId);
            updater.onUpdate(usingUser);
            update(usingUser);
        }
    }

    public void updateLoginStatus(Integer userId, int status){
        new UpdateHelper().beginUpdate(userId, (UserTbl user) -> {
            user.setLoginStatus(status);
        });
    }
    
    public void updatePassword(Integer userId, String password){
        new UpdateHelper().beginUpdate(userId, new Updater() {
            @Override
            public void onUpdate(UserTbl user) {
                user.setUserPassword(password);
            }
        });
    }
    
    public void updateUserName(Integer userId, String userName){
        new UpdateHelper().beginUpdate(userId, (UserTbl user) -> {
            user.setUserName(userName);
        });
    }
    
    public boolean isPasswordCorrect(Integer userId, String checkpassword){
        UserTbl user = findById(userId);
        if(user.getUserPassword().equals(checkpassword)){
            return true;
        }
        else return false;
    }
    
    public UserTbl findByLoginStatus(int loginStatus){
        List<UserTbl> lists = getAll(USER_TBL);
        for(UserTbl user: lists){
            if(user.getLoginStatus() == loginStatus){
                return user;
            }
        }
        return null;
    }
}
