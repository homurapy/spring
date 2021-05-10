package com.vasilev.dao;

import com.vasilev.model.Buyer;
import com.vasilev.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class BuyerDao {
    private static SessionFactory factory;

    public Buyer findById(Long id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Buyer.class, id);
    }

    public void save(Buyer product) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            try {
                ;
                session.save(product);
                tx1.commit();
            } catch (Exception e) {
                tx1.rollback();
                e.printStackTrace();
            }
        }
    }

    public void update(Buyer product) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            try {
                session.update(product);
                tx1.commit();
                session.close();
            } catch (Exception e) {
                tx1.rollback();
                e.printStackTrace();
            }
        }
    }


    public void delete(Buyer product) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            try {
        session.delete(product);
        tx1.commit();
    } catch (Exception e) {
        tx1.rollback();
        e.printStackTrace();
    }
  }
 }

    public List<Buyer> findAll() {
        List<Buyer> product = SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Buyer ").list();
        return product;
    }
}
