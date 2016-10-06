/*
 * Created on Feb 13, 2004
 * Author: robh
 */

package com.apress.pjv.ch2;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

public class ResourceLoaders {

    private static final String FILE_RESOURCE_LOADER_TEMPLATE =
        "ResourceLoader1.vm";
    private static final String JAR_RESOURCE_LOADER_TEMPLATE =
        "ResourceLoader2.vm";
    private static final String CLASSPATH_RESOURCE_LOADER_TEMPLATE =
        "ResourceLoader3.vm";

    public static void main(String[] args) throws Exception {
        processTemplate(FILE_RESOURCE_LOADER_TEMPLATE);
        processTemplate(FILE_RESOURCE_LOADER_TEMPLATE);
        processTemplate(JAR_RESOURCE_LOADER_TEMPLATE);
        processTemplate(JAR_RESOURCE_LOADER_TEMPLATE);
        processTemplate(CLASSPATH_RESOURCE_LOADER_TEMPLATE);
        processTemplate(CLASSPATH_RESOURCE_LOADER_TEMPLATE);
    }

    private static void processTemplate(String templateName) throws Exception {
        // initalize Velocity 
        Velocity.init("src/velocity.properties");

        // get the template
        Template template = Velocity.getTemplate(templateName);

        // create a context for Velocity
        VelocityContext context = new VelocityContext();

        // create the output 
        Writer writer = new StringWriter();
        template.merge(context, writer);

        // write out
        System.out.println(writer.toString());
    }

}
