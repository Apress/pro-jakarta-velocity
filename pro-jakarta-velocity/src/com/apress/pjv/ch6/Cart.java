/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;


/**
 * @author robh
 *
 */
public class Cart implements Serializable {

    private Map items = null;
    
    private static final String SESSION_KEY = "__CART";
    
    private Cart() {
        items = new HashMap(8);
    }
    
    public void addItem(Product product, int quantity) {
        addItem(new CartItem(product, quantity));
    }
    
    public void addItem(CartItem cartItem) {
        Integer key = cartItem.getProduct().getProductId();
        
        if(items.containsKey(key)) {
          CartItem currItem = (CartItem)items.get(key);
          cartItem.setQuantity(cartItem.getQuantity() + currItem.getQuantity());
        } 
        
        items.put(key, cartItem);
    }
    
    public void removeItem(Product product) {
        removeItem(product.getProductId());
    }
    
    public void removeItem(int productId) {
        removeItem(new Integer(productId));
    }
    
    private void removeItem(Integer productId) {
        items.remove(productId);
    }
    
    public Collection getItems() {
        return items.values();
    }
    
    public static Cart fromSession(HttpSession session) {
        Cart c = (Cart)session.getAttribute(SESSION_KEY);
        
        if(c == null) c = new Cart();

        return c;
    }
    
    public static void storeInSession(HttpSession session, Cart cart) {
        session.setAttribute(SESSION_KEY, cart);
    }
}
