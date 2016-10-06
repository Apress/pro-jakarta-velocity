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
public class InstanceDriver {

    public static void main(String[] args) throws Exception {

        VelocityEngine ve = new VelocityEngine();
        // 1. Initlization Phase
        ve.init("src/velocity.properties");

        // 2. Locate and Load Phase
        // and
        // 3. Parse Phase
        Template t = ve.getTemplate("sample.vm");

        // create context
        VelocityContext ctx = new VelocityContext();
        ctx.put("who", "Rob");

        Writer writer = new StringWriter();

        // 4. Merge Phase
        t.merge(ctx, writer);

        // output
        System.out.println(writer);
    }
}