/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;


/**
 * @author robh
 *
 */
public class StoreManagerFactory {

    private static StoreManagerFactory instance = null;
    private StoreManager impl = null;
    
    static {
        instance = new StoreManagerFactory();
    }
    
    private StoreManagerFactory() {
        impl = new StoreManagerPOJOImpl();
    }
    
    public StoreManager getStoreManager() {
        return impl;
    }
    
    public static StoreManagerFactory getInstance() {
        return instance;
    }
}
