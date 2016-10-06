/*
 * Created on Feb 20, 2004
 */
package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.generic.DateTool;


/**
 * @author robh
 */
public class DateToolExample {

    public static void main(String[] args) throws Exception {
        // init
        Velocity.init("src/velocity.properties");

        // get the template
        Template t = Velocity.getTemplate("dateTool.vm");

        // create context
        VelocityContext ctx = new VelocityContext();
        ctx.put("date", new DateTool());
       
        Calendar aDate = Calendar.getInstance(TimeZone.getTimeZone("PST"));
        aDate.set(2040, 11, 25);
        
        ctx.put("aDate", aDate);


        // create the output
        Writer writer = new StringWriter();
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}
