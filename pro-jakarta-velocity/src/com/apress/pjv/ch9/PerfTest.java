/*
 * Created on Apr 24, 2004
 */
package com.apress.pjv.ch9;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

/**
 * @author robh
 *  
 */
public class PerfTest {

    private static final String TEMPLATE_NAME = "sample.vm";

    public static void main(String[] args) throws Exception {
        // context for both tests
        VelocityContext ctx = new VelocityContext();
        ctx.put("who", "Rob");

        // test 1 - single instance
        VelocityEngine ve = new VelocityEngine();
        ve.init("src/velocity.properties");

        long before = System.currentTimeMillis();

        for (int x = 0; x < 250; x++) {
            Writer writer = new StringWriter();
            Template t = ve.getTemplate(TEMPLATE_NAME);
            t.merge(ctx, writer);
        }

        System.out.println("Time Taken: "
                + (System.currentTimeMillis() - before));

        // test 2 - many instances
        before = System.currentTimeMillis();

        for (int x = 0; x < 250; x++) {
            VelocityEngine ve2 = new VelocityEngine();
            ve2.init("src/velocity.properties");

            Writer writer = new StringWriter();
            Template t = ve2.getTemplate(TEMPLATE_NAME);
            t.merge(ctx, writer);
        }

        System.out.println("Time Taken: "
                + (System.currentTimeMillis() - before));
    }
}