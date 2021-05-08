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
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
        tx1.commit();
        session.close();
    }

    public void update(Product product) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        tx1.commit();
        session.close();
    }

    public void delete(Product product) {
        Session session = SessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

    public List<Product> findAll() {
        List<Product> product = SessionFactoryUtil.getSessionFactory().openSession().createQuery("From Product").list();
        return product;
    }
}
