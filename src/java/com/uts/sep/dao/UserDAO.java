/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.UserTbl;
import java.util.*;
import org.hibernate.SessionFactory;

/**
 *
 * @author eaton
 */
public class UserDAO extends BaseDAO<UserTbl>{
    private static SessionFactory factory = null;
    
    public static final short LOGING_IN = 1;
    public static final short LOGED_OUT = 0;

    List<UserTbl> users = getAll(USER_TBL);

    
    interface Updater {
        
        void onUpdate(UserTbl user);
    }
    
    private class updateHelper {
        
        private void beginUpdate(Integer userId, Updater updater){
            
            UserTbl usingUser = findById(userId);
            updater.onUpdate(usingUser);
            update(usingUser);
        }
    }
    
    public void updateLoginStatus(Integer userId, int status){
        new updateHelper().beginUpdate(userId, (UserTbl user) -> {
            user.setLoginStatus(status);
        });
    }
    
    public void updatePassword(Integer userId, String password){
        new updateHelper().beginUpdate(userId, (UserTbl user) -> {
            user.setUserPassword(password);
        });
    }
    
    public void updateUserName(Integer userId, String userName){
        new updateHelper().beginUpdate(userId, (UserTbl user) -> {
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
        for(UserTbl user: users){
            if(user.getLoginStatus() == loginStatus){
                return user;
            }
        }
        return null;
    }
    
    public UserTbl findByUserType(int userType){
        for(UserTbl user: users){
            if(user.getUserType() == userType){
                return user;
            }
        }
        return null;
    }
    
    public List<UserTbl> getUsersById(int id){
        List<UserTbl> usingList = new ArrayList<UserTbl>();
        for(UserTbl user: users){
            if(user.getUserId()== id){
                usingList.add(user);
            }
        }
        return usingList;
    }
}
