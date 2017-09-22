/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.UserTbl;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author lzy
 */
public class UserDAO extends BaseDAO<UserTbl>{

    private static SessionFactory factory = null;
//    private static ServiceRegistry serviceRegistry = null;
//    private static Configuration configuration = null;

    /**
     * this method is to get all users
     *
     * @return
     */
    public List<UserTbl> getAllUsers() {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
        List<UserTbl> list = null;
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery("from UserTbl");//using the name from java
            list = query.list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

//    public UserTbl getUser(Integer userID) {
//        ArrayList<UserTbl> users = getAllUsers();
//        for (UserTbl user:users){
//            if(Objects.equals(userID, user.getUserId())){
//                return user;
//            }
//        }
//        return null;
//    }

    /**
     *
     * @param userId
     * @param status
     */
    public void updateLoginStatus(Integer userId, int status) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserTbl user = (UserTbl) session.get(UserTbl.class, userId);
            user.setLoginStatus(status);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //method to upadte password
    public void updatePassword(Integer userId, String pwd) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserTbl user = (UserTbl) session.get(UserTbl.class, userId);
            user.setUserPassword(pwd);
            session.update(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    //method to add users
    public void insertUser(String name, String pwd) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserTbl user = new UserTbl(name, pwd, 0);
            session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

    }

    //method to delete users
    public void deleteUser(Integer userId) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            UserTbl user = (UserTbl) session.get(UserTbl.class, userId);
            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
