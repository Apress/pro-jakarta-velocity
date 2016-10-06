/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.io.Serializable;

/**
 * @author robh
 *  
 */
public class CartItem implements Serializable {

    private Product product = null;

    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return this.product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int newQuantity) {
        this.quantity = newQuantity;
    }

    public double getSubTotal() {
        return product.getPrice().doubleValue() * this.quantity;
    }
}