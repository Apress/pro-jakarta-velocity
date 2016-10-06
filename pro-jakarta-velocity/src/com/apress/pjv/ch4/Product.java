/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;


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
    
    /**
     * @return Returns the name.
     */
    public String getName() {
        return name;
    }
    /**
     * @param name The name to set.
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * @return Returns the price.
     */
    public double getPrice() {
        return price;
    }
    /**
     * @param price The price to set.
     */
    public void setPrice(double price) {
        this.price = price;
    }
}
