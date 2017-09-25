/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.UserTbl;
import java.lang.reflect.ParameterizedType;
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
public abstract class BaseDAO<T> {
    
    public static final String ADMIN_TBL = "AdminTbl";
    public static final String CUSTOMER_TBL = "CustomerTbl";
    public static final String ITEM_TBL = "ItemTbl";
    public static final String ORDER_TBL = "OrderTbl";
    public static final String ORDER_DETAIL_TBL = "OrderDetailTbl";
    public static final String SELLER_TBL = "SellerTbl";
    public static final String SHIPPING_TBL = "ShippingTbl";
    public static final String SHIPPING_CART_TBL = "ShippingCartTbl";
    public static final String USER_TBL = "UserTbl";

    private Class<T> ClassType;

    private static SessionFactory factory = null;

    /**
     * the constructor will check for related class
     */
    @SuppressWarnings("unchecked")
    public BaseDAO() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        ClassType = (Class<T>) type.getActualTypeArguments()[0];
    }

    /**
     * this method will return all the required type of model
     * @param tableNameStr
     * @return 
     */
    public List<T> getAll(String tableNameStr) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;//operation
        List<T> list = null;
        try {
            tx = session.beginTransaction();// open connection
            Query query = session.createQuery("from " + tableNameStr);//using the name from java
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

    /**
     * this method is to update the current existing instance into the database.
     *
     * @param model
     * @return
     */
    @SuppressWarnings("deprecation")
    public boolean update(T model) {
        if (model != null) {
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(model);
                tx.commit();
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return false;
            } finally {
                session.close();
            }
            return true;
        }
        return false;
    }

    /**
     * this method is to new instance to the database.
     * @param model
     * @return 
     */
    public boolean insertNew(T model) {
       if (model != null){
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(model);
                tx.commit();
            } catch (HibernateException e){
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return false;
            } finally {
                session.close();
            }
            return true;
       }
       return true;
    }

    /**
     * this method will return the a checked instance.
     * @param id
     * @return 
     */
    @SuppressWarnings("unchecked")
    public T findById(Integer id) {
        Object object = new Object();
        if (id != null) {
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                object = (T) session.get(ClassType, id);
                tx.commit();
                return (T) object;
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
            } finally {
                session.close();
            }
        }
        return null;
    }

    public boolean delete(T model) {
        if (model != null) {
            factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.delete(model);
            } catch (HibernateException e) {
                if (tx != null) {
                    tx.rollback();
                }
                e.printStackTrace();
                return false;
            } finally {
                session.close();
            }
            return true;
        }
        return false;
    }

}
