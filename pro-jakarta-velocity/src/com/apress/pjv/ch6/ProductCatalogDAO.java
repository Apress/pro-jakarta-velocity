/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.List;


/**
 * @author robh
 *
 */
public interface ProductCatalogDAO {

    public List getAllProducts();
    public List getProductsInCategory(Category category);
    public Product getProduct(int productId);
}
