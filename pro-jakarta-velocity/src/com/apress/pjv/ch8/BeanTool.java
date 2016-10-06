/*
 * Created on Apr 18, 2004
 */
package com.apress.pjv.ch8;

/**
 * @author robh
 *  
 */
public class BeanTool {

    public String initCap(String beanName) {
        return beanName.substring(0, 1).toUpperCase() + beanName.substring(1);
    }
}