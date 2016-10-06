/*
 * Created on Feb 20, 2004
 */
package com.apress.pjv.ch3;


/**
 * @author robh
 */
public class Product {
    
    private String name;
    private double price;
        
    public Product(String aName, double aPrice) {
        name = aName;
        price = aPrice;
    }    
    
    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String val) {
        name = val;
    }

    public void setPrice(double val) {
        price = val;
    }
} 

