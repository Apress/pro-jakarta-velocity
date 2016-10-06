/*
 * Created on Feb 6, 2004
 * Author: robh
 */

package com.apress.pjv.ch2;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class HelloWorldProperties {

    public static void main(String[] args) throws Exception {
        // set some properties
        Properties props = new Properties();
        props.put("input.encoding", "utf-8");

        // initalize Velocity
        Velocity.init(props);

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
