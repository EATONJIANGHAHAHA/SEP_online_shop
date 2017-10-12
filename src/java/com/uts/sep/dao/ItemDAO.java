/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import java.util.*;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import com.uts.sep.model.Item; //dont need?
import java.io.File;
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{

    private static SessionFactory factory = null;
    
    public List<ItemTbl> getItemByID(String itemId) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
        
        List<ItemTbl> list = null;
        String hql = "from ItemTbl I where I.itemId = " + itemId;
        //String hql = "from ItemTbl";
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery(hql);//using the name from java
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
    
    public List<ItemTbl> searchItems(String itemName) 
    {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
        
        List<ItemTbl> list = null;
        String hql = "from ItemTbl I where I.itemDescription like :search";
        //String hql = "from ItemTbl";
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery(hql);//using the name from java
            query.setParameter("search", "%"+itemName+"%");
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
    
    public void addItem(String itemname, String itemdescription, double itemprice, String itemimage, int ownerid) 
    {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
 
        try {
            tx = session.beginTransaction();// open connection
            ItemTbl newitem = new ItemTbl(itemname, itemdescription,1, 1, itemprice, itemimage, ownerid);
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
    //private static SessionFactory factory;
    
    //method to get all the items
//    public List<ItemTbl> getAllItems() {
//        factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;
//        List<ItemTbl> list = null;
//        try {
//            tx = session.beginTransaction();
//            list = session.createQuery("FROM ItemTbl").list();
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }
//
//    //method to upadte stock
//    public void updateStock(Integer itemId, int stock) {
//        factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;
//        try {
//            tx = session.beginTransaction();
//            ItemTbl item = (ItemTbl) session.get(ItemTbl.class, itemId);
//            item.setStock(stock);
//            session.update(item);
//            tx.commit();
//        } catch (HibernateException e) {
//            if (tx != null) {
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//    }
}