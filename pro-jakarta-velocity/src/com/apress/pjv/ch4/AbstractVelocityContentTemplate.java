/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;

import java.io.StringWriter;
import java.io.Writer;

import org.apache.velocity.Template;

import org.apache.velocity.context.Context;


/**
 * @author robh
 */
public abstract class AbstractVelocityContentTemplate {
    
    public void generate(Writer writer) throws TemplateException {
        try {
            VelocityManager.init("src/velocity.properties");
            
            Template t = VelocityManager.getTemplate(getResourceName());
            
            // create the context
            Context ctx = ContextFactory.getInstance();
            
            // populate with model data
            ModelBean model = getModel();
            ctx.put(model.getModelName(), model);
            
            t.merge(ctx, writer);
            
        } catch(Exception ex) {
            throw new TemplateException("Unable to generate output", ex);
        }
    }
    
    public String generate() throws TemplateException {
        Writer w = new StringWriter();
        generate(w);
        return w.toString();
    }
    
    protected abstract ModelBean getModel();
    protected abstract String getResourceName();
}
