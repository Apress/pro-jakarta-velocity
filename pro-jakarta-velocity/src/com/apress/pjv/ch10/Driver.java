/*
 * Created on May 21, 2004
 */
package com.apress.pjv.ch10;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;


/**
 * @author robh
 *
 */
public class Driver {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Velocity.init("src/velocity.properties");

        Template t = Velocity.getTemplate("imageDirective.vm");

        VelocityContext ctx = new VelocityContext();
        ctx.put("who", "Rob");

        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}
