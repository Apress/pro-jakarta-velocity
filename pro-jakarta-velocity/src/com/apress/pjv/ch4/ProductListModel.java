/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author robh
 */
public class ProductListModel {

    private Collection productList = null;

    private double totalPrice = Double.MIN_VALUE;

    public ProductListModel(Collection aProductList) {
        productList = aProductList;
    }

    public Collection getProductList() {
        return productList;
    }

    public void setProductList(Collection aProductList) {
        productList = aProductList;
    }

    public double getTotalPrice() {
        if (totalPrice == Double.MIN_VALUE) {

            totalPrice = 0;
            Iterator itr = productList.iterator();

            while (itr.hasNext()) {
                Product p = (Product) itr.next();
                totalPrice += p.getPrice();
            }
        }

        return totalPrice;
    }
}
