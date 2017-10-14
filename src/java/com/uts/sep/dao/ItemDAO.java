/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{
    
    List<ItemTbl> items = getAll(ITEM_TBL);
    SessionFactory factory = new Configuration().configure().buildSessionFactory();;

    public List<ItemTbl> getItems() {
        return items;
    }

    public void setItems(List<ItemTbl> items) {
        this.items = items;
    }
    public void addItem(String itemName){
        ItemTbl newitem = new ItemTbl(itemName, 20, 1, 50, 0);
        items.add(newitem);
        insertNew(newitem);
    }
    
    public void removeItem(Integer id){
        ItemTbl item = findById(id);
        items.remove(item);
    }
    
    public List<ItemTbl> getItemByOwner(String ownerId) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
        
        List<ItemTbl> list = null;
        String hql = "from ItemTbl I where I.ownerId = " + ownerId;
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
        String hql = "from ItemTbl I where I.itemDescription like :search order by I.itemId desc";
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
        }
    }
}