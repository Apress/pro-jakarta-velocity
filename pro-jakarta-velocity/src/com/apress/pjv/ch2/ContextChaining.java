/*
 * Created on Feb 14, 2004
 * Author: robh
 */

package com.apress.pjv.ch2;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ContextChaining {

    public static void main(String[] args) throws Exception {
        // initalize Velocity
        Velocity.init();

        // get the template
        Template template =
            Velocity.getTemplate("src/templates/ch2/ContextChaining.vm");

        // create two separate contexts
        VelocityContext context1 = new VelocityContext();
        VelocityContext context2 = new VelocityContext(context1);

        // set the firstName variable
        context1.put("firstName", "Rob");
        context2.put("lastName", "Harrop");

        // create the output 
        Writer writer = new StringWriter();
        template.merge(context2, writer);

        // write out
        System.out.println(writer.toString());
    }
}
