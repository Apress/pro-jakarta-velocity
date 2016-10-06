/*
 * Created on Feb 14, 2004
 * Author: robh
 */

package com.apress.pjv.ch2;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class VelocityEngineTest {

    private static final String TEMPLATE_NAME = "VelocityEngineTest.vm";

    public static void main(String[] args) throws Exception {

        // create the properties for each engine
        Properties p1 = new Properties();
        p1.put("resource.loader", "file");
        p1.put(
            "file.resource.loader.class",
            "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        p1.put("file.resource.loader.path", "src/templates/ch2/ve1");

        Properties p2 = new Properties();
        p2.put("resource.loader", "file");
        p2.put(
            "file.resource.loader.class",
            "org.apache.velocity.runtime.resource.loader.FileResourceLoader");
        p2.put("file.resource.loader.path", "src/templates/ch2/ve2");

        //now create the engines
        VelocityEngine ve1 = new VelocityEngine();
        ve1.init(p1);

        VelocityEngine ve2 = new VelocityEngine();
        ve2.init(p2);

        // now get the output for each engine
        writeTemplateOutput(ve1);
        writeTemplateOutput(ve2);

    }

    public static void writeTemplateOutput(VelocityEngine ve) throws Exception {
        Template t = ve.getTemplate(TEMPLATE_NAME);

        Writer writer = new StringWriter();
        t.merge(new VelocityContext(), writer);

        System.out.println(writer.toString());
    }
}
