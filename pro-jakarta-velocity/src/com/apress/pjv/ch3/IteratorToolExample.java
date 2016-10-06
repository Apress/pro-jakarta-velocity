/*
 * Created on 21-Feb-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package com.apress.pjv.ch3;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.tools.generic.IteratorTool;

/**
 * @author robh
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class IteratorToolExample {

	public static void main(String[] args) throws Exception {
		// init
		Velocity.init("src/velocity.properties");

		// get the template
		Template t = Velocity.getTemplate("iteratorTool.vm");

		// create context
		VelocityContext ctx = new VelocityContext();
		ctx.put("mill", new IteratorTool());
      
		// create the output
		Writer writer = new StringWriter();
		t.merge(ctx, writer);

		// output
		System.out.println(writer);
	}
}
