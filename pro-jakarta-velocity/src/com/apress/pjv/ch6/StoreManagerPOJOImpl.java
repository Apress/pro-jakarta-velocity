/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.List;

/**
 * @author robh
 *  
 */
public class StoreManagerPOJOImpl implements StoreManager {

    private ProductCatalogDAO dao = null;

    public StoreManagerPOJOImpl() {
        dao = DAOFactory.getInstance().getProductCatalogDAO();
    }

    public List getProductList() {
        return dao.getAllProducts();
    }

    public List getProductList(Category category) {
        if (category == null) {
            return getProductList();
        } else {
            return dao.getProductsInCategory(category);
        }
    }

    public Product getProduct(int productId) {
        return dao.getProduct(productId);
    }

}