/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


/**
 * @author robh
 */
public class ProductList3 {

    public static void main(String[] args) throws Exception {
        // init
        Velocity.init("src/velocity.properties");
        
        // get the template
        Template t = Velocity.getTemplate("productList-model.vm");
        
        // create context
        VelocityContext ctx = new VelocityContext();
       
        // create the product list model
        Collection products = new ArrayList();
        products.add(new Product("Widget", 12.99));
        products.add(new Product("Wotsit", 13.99));
        products.add(new Product("Thingy", 11.99));

        ProductListModel model = new ProductListModel(products);
        ctx.put("model", model);
        
        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);
        
        // output
        System.out.println(writer);
    }
}
