/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.UserTbl;
import java.util.*;

/**
 *
 * @author eaton
 */
public class UserDAO extends BaseDAO<UserTbl>{
    
    public static final short LOGING_IN = 1;
    public static final short LOGED_OUT = 0;
    List<UserTbl> users = getAll(USER_TBL);
    
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
}
