/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.ShippingTbl;
import com.uts.sep.entity.UserTbl;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author tomat
 */
public class ShippingDAO extends BaseDAO<ShippingTbl>{
    
//    private static SessionFactory factory = null;
    
//    public List<ShippingTbl> getAllShipping() {
//        factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;//operation
//        List<ShippingTbl> list = null;
//        try {
//            tx = session.beginTransaction();// open connection
//            Query query = session.createQuery("from UserTbl");//using the name from java
//            list = query.list();
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
    
}
