/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uts.sep.dao;

import com.uts.sep.entity.AdminTbl;
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
public class AdminDAO extends BaseDAO<AdminTbl>{
    
    private static SessionFactory factory = null;
    
//    public List<AdminTbl> getAllAdmins(){
//        factory = new Configuration().configure().buildSessionFactory();
//        Session session = factory.openSession();
//        Transaction tx = null;
//        List<AdminTbl> list = null;
//        try {
//            tx = session.beginTransaction();
//            Query query = session.createQuery("from AdminTbl");
//            list = query.list();
//            tx.commit();
//        } catch (HibernateException e){
//            if (tx != null){
//                tx.rollback();
//            }
//            e.printStackTrace();
//        } finally {
//            session.close();
//        }
//        return list;
//    }
    
    public void updateAdminName(Integer adminId, String name){
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            AdminTbl admin = (AdminTbl) session.get(AdminDAO.class, adminId);
            admin.setAdminName(name);
            session.update(admin);
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
