/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.List;

import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.SessionFactory;
import net.sf.hibernate.cfg.Configuration;

/**
 * @author robh
 *  
 */
public class ProductCatalogDAOHibernateImpl implements ProductCatalogDAO {

    private SessionFactory sessionFactory = null;

    public ProductCatalogDAOHibernateImpl() {
        try {
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        } catch (HibernateException e) {
            throw new DataAccessException(
                    "Unable to configure hibernate framework", e);
        }
    }

    private Session getSession() throws DataAccessException {
        try {
            return sessionFactory.openSession();
        } catch (HibernateException e) {
            throw new DataAccessException("Could not create session", e);
        }
    }

    private void closeSession(Session session) throws DataAccessException {
        try {
            session.close();
        } catch (HibernateException e) {
            throw new DataAccessException("Unable to close hibernate session",
                    e);
        }
    }

    public List getAllProducts() {
        Session session = getSession();
        try {
            Query query = session
                    .createQuery("SELECT p FROM Product AS p ORDER BY p.name");
            return query.list();
        } catch (HibernateException ex) {
            throw new DataAccessException("Unable to retrieve all products", ex);
        } finally {
            closeSession(session);
        }
    }

    public List getProductsInCategory(Category category) {
        Session session = getSession();
        try {
            Query query = session
                    .createQuery("SELECT p FROM Product AS p WHERE p.category = :category ORDER BY p.name");
            query.setEnum("category", category);

            return query.list();
        } catch (HibernateException ex) {
            throw new DataAccessException("Unable to retrieve products", ex);
        } finally {
            closeSession(session);
        }
    }

    public Product getProduct(int productId) {
        Session session = getSession();
        try {
            Query query = session
                    .createQuery("SELECT p FROM Product AS p WHERE p.productId = :productId");
            query.setInteger("productId", productId);
            return (Product) query.uniqueResult();
        } catch (HibernateException ex) {
            throw new DataAccessException("Unable to retrieve product", ex);
        } finally {
            closeSession(session);
        }
    }
}