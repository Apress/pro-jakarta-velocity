/*
 * Created on May 21, 2004
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
 *  
 */
public class TestCustomResourceLoader {

    public static void main(String[] args) throws Exception {
        Velocity.init("src/velocity.properties");

        VelocityContext ctx = new VelocityContext();
        ctx.put("who", "Rob");

        // create the output the first time
        Template t = getTemplate();
        write(t, ctx);

        // wait for 10 seconds
        Thread.sleep(10000);

        // get template again and write
        t = getTemplate();
        write(t, ctx);
    }

    private static Template getTemplate() throws Exception {
        return Velocity.getTemplate("templates/ch10/customLoader.vm");
    }

    private static void write(Template template, Context ctx) throws Exception {
        Writer writer = new StringWriter();
        template.merge(ctx, writer);
        System.out.println(writer.toString());
    }
}