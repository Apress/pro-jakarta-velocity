/*
 * Created on Feb 20, 2004
 */
package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.generic.MathTool;


/**
 * @author robh
 */
public class MathToolExample {

    public static void main(String[] args) throws Exception {
        // init
        Velocity.init("src/velocity.properties");

        // get the template
        Template t = Velocity.getTemplate("mathTool.vm");

        // create context
        VelocityContext ctx = new VelocityContext();
        ctx.put("math", new MathTool());
        ctx.put("aNumber", new Double(5.5));
       

        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}
