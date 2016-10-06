/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.List;


/**
 * @author robh
 *
 */
public interface StoreManager {

    public List getProductList();
    public List getProductList(Category category);
    public Product getProduct(int productId);
}
