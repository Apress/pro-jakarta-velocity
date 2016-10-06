/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;


/**
 * @author robh
 *
 */
public class DAOFactory {

    private static DAOFactory instance = null;
    private ProductCatalogDAO productCatalogDAO = null;
    
    static {
        instance = new DAOFactory();
    }
    
    private DAOFactory() {
        this.productCatalogDAO = new ProductCatalogDAOHibernateImpl();
    }
    
    public static DAOFactory getInstance() {
        return instance;
    }
    
    public ProductCatalogDAO getProductCatalogDAO() {
        return this.productCatalogDAO;
    }
}
