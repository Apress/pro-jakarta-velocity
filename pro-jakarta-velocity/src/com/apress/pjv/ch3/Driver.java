package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class Driver {
	public static void main(String[] args) throws Exception{
        
        // init
        Velocity.init("src/velocity.properties");
        
        // get the template
        Template t = Velocity.getTemplate("mapProperty.vm");
        
        // create context
        VelocityContext ctx = new VelocityContext();
        ctx.put("myName", new Date());
        ctx.put("aDate", new Date());
        ctx.put("userType", "elf");
        
        // add products collection to the context
        Collection products = new ArrayList();
        products.add(new Product("Widget", 12.99));
        products.add(new Product("Wotsit", 13.99));
        products.add(new Product("Thingy", 11.99));
        ctx.put("products", products);
        
        // add a Map to the context
        Map map = new HashMap();
        map.put("firstName", "Rob");
        map.put("lastName", "Harrop");
        ctx.put("map", map);
                
        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);
        
        // output
        System.out.println(writer);
        
	}
}
