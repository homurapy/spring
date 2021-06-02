package com.vasilev.dao;

import com.vasilev.model.Product;
import com.vasilev.util.SessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.List;

public class ProductDao {
    private static SessionFactory factory;

    public Product findById(Long id) {
        return SessionFactoryUtil.getSessionFactory().openSession().get(Product.class, id);
    }

    public void save(Product product) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            try {
                session.save(product);
                tx1.commit();
                session.close();
            } catch (Exception e) {
                tx1.rollback();
                e.printStackTrace();
            }
        }
    }

    public void update(Product product) {
        try (Session session = SessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction tx1 = session.beginTransaction();
            try {
                session.update(product);
                tx1.commit();
            } catch (Exception e) {
                tx1.rollback();
                e.printStackTrace();
            }
        }
    }

    public void delete(Product product) {
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

    public List<Product> findAll() {
        List<Product> product = SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return product;
    }
}
