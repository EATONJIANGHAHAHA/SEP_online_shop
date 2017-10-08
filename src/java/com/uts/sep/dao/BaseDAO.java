/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

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
    public static final String SEARCH_BY_ITEM_DESCRIPTION = "from ItemTbl I where I.itemDescription like :search";

    private Class<T> ClassType;
    
    public BaseDAO() {
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        ClassType = (Class<T>) type.getActualTypeArguments()[0];
    }

    interface DatabaseConnector<T> {
        Object onDatabaseConnect(Session session);
    }

    private class DatabaseConnectHelper {

        private Object beginDatabaseConnection(
                DatabaseConnector<T> connector) {
            SessionFactory factory = new Configuration().configure().buildSessionFactory();
            Session session = factory.openSession();
            Transaction tx = null;
            List<T> list = null;
            try {
                tx = session.beginTransaction();
                list = (List<T>) connector.onDatabaseConnect(session);
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
    }
    
    public List<T> getAll(String tableNameStr) {
        return (List<T>) new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            Query query = session.createQuery("from " + tableNameStr);
            List<T> list1 = query.list();
            return list1;
        });
    }

    public void update(T model) {
        new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            session.update(model);
            return null;
        });
    }

    public void insertNew(T model) {
        new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            session.save(model);
            return null; 
        });
    }

    public T findById(Integer id) {
        return (T) new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            return (T) session.get(ClassType,id);
        });
    }

    public void delete(T model) {
        new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            session.delete(model);
            return null;
        });
    }

    public List<T> searchModels(String hql, String name) {
        return (List<T>) new DatabaseConnectHelper().beginDatabaseConnection((session) -> {
            Query query = session.createQuery(hql);
            query.setParameter("search", "%" + name + "%");
            return query.list(); 
        });
    }
}
