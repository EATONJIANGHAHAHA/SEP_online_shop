/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import com.uts.sep.entity.ShoppingCartTbl;
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
public class ShoppingCartDAO extends BaseDAO<ShoppingCartTbl>{
    private static SessionFactory factory = null;
    
      public void deleteCartItem(int removeitemid) 
    {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
 
        //List<ItemTbl> list = null;
        String hql = "delete ShoppingCartTbl S where S.itemId = " + Integer.toString(removeitemid);
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery(hql);//using the name from java
            //list = query.list();
            int result = query.executeUpdate();
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
      
      public void checkoutCartItems(int userId) 
    {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
 
        //List<ItemTbl> list = null;
        String hql = "delete ShoppingCartTbl S where S.userId = " + Integer.toString(userId);
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery(hql);//using the name from java
            //list = query.list();
            int result = query.executeUpdate();
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
      
      public void addCartItem(int itemId, int userId) 
    {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
 
        try {
            tx = session.beginTransaction();// open connection
            ShoppingCartTbl newitem = new ShoppingCartTbl(itemId, userId);
            this.insertNew(newitem);
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
