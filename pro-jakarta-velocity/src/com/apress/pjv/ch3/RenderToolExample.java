/*
 * Created on 21-Feb-2004
 *
 */
package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.generic.RenderTool;

/**
 * @author robh
 *
 */
public class RenderToolExample {

	public static void main(String[] args) throws Exception {
		// init
		Velocity.init("src/velocity.properties");

		// get the template
		Template t = Velocity.getTemplate("renderTool.vm");

		// create context
		VelocityContext ctx = new VelocityContext();
		ctx.put("render", new RenderTool());
		ctx.put("str", new String("The One Ring"));
		ctx.put("ctx", ctx);
      
		// create the output
		Writer writer = new StringWriter();
		t.merge(ctx, writer);

		// output
		System.out.println(writer);
	}
}
