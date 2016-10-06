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
import org.apache.velocity.tools.generic.MathTool;


/**
 * @author robh
 */
public class ProductList1 {

    public static void main(String[] args) throws Exception {
        // init
        Velocity.init("src/velocity.properties");
        
        // get the template
        Template t = Velocity.getTemplate("productList-calcintemp.vm");
        
        // create context
        VelocityContext ctx = new VelocityContext();
       
        // add products collection to the context
        Collection products = new ArrayList();
        products.add(new Product("Widget", 12.99));
        products.add(new Product("Wotsit", 13.99));
        products.add(new Product("Thingy", 11.99));
        ctx.put("productList", products);

        // need MathTool to do in template calculation
        ctx.put("math", new MathTool());

        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);
        
        // output
        System.out.println(writer);
    }
}
