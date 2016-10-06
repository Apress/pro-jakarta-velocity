/*
 * Created on Feb 20, 2004
 */
package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.generic.NumberTool;

/**
 * @author robh
 */
public class NumberToolExample {

    public static void main(String[] args) throws Exception{
        // init
        Velocity.init("src/velocity.properties");

        // get the template
        Template t = Velocity.getTemplate("numberTool.vm");

        // create context
        VelocityContext ctx = new VelocityContext();
        ctx.put("number", new NumberTool());
        ctx.put("aNumber", new Double(0.95));
        ctx.put("aLocale", Locale.UK);

        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}
