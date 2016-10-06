/*
 * Created on Feb 6, 2004
 * Author: robh
 */

package com.apress.pjv.ch2;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class HelloWorldExternalProperties {

    public static void main(String[] args) throws Exception{
        // initalize Velocity
        Velocity.init("src/velocity.properties");

        // get the template
        Template template =
            Velocity.getTemplate("src/templates/ch2/HelloWorld.vm");

        // create a context for Velocity
        VelocityContext context = new VelocityContext();

        // create the output 
        Writer writer = new StringWriter();
        template.merge(context, writer);

        // write out
        System.out.println(writer.toString());
    }
}
