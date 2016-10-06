/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.List;

import junit.framework.TestCase;


/**
 * @author robh
 *
 */
public class TestProductCatalogDAO extends TestCase {

    private ProductCatalogDAO dao = null;

    public TestProductCatalogDAO(String name) {
        super(name);
        dao = DAOFactory.getInstance().getProductCatalogDAO();
    }
    
    public void testGetAllProducts() {
        List result = dao.getAllProducts();
        
        assertNotNull("Result should not be null", result);
        
        assertTrue("There should be 15 products in the result list", result.size() == 15);
    }
    
    public void testGetProduct() {
        Product p = dao.getProduct(1);
        
        assertNotNull("Product 1 should not be null", p);
    }
    
    public void testGetProductsInCategory() {
        List result = dao.getProductsInCategory(Category.WIDGET);
        
        assertNotNull("Result should not be null", result);
        
        assertTrue("Each category should have five products", result.size() == 5);
    }

}
