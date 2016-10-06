/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch10;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

/**
 * @author robh
 */
public class EventHandlerTest {

    public static void main(String[] args) throws Exception {
        // init
        Velocity.init("src/velocity.properties");
       
        // get the template
        Template t = Velocity.getTemplate("eventHandler.vm");

        // create context
        Context ctx = new VelocityContext();
        ctx.put("person", "Gandalf Stormcrow");
        ctx.put("horse", "Shadowfax");
        ctx.put("rnd", new RandomExceptionGenerator());

        // create the event handler
        EventHandler hdl = new EventHandler(ctx);
        
        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}
