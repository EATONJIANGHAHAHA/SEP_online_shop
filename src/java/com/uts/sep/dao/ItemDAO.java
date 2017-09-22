/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ItemTbl;
/**
 *
 * @author lzy
 */
public class ItemDAO extends BaseDAO<ItemTbl>{

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
