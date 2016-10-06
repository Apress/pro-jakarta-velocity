/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;

/**
 * @author robh
 */
public abstract class VelocityTemplateIntrospectionSupport extends
        AbstractVelocityContentTemplate {

    protected Context getContext() throws TemplateException {
        try {
            Context ctx = new VelocityContext();

            BeanInfo inf = Introspector.getBeanInfo(this.getClass());
            PropertyDescriptor[] props = inf.getPropertyDescriptors();
            
            for(int x = 0; x < props.length; x++) {
                PropertyDescriptor prop = props[x];
                
                ctx.put(prop.getName(), prop.getReadMethod().invoke(this, null));
            }
            
            extendContext(ctx);
            
            return ctx;
        } catch (Exception e) {
            throw new TemplateException("Template Generation Exception", e);
        }
    }
    
    protected void extendContext(Context ctx) throws TemplateException{
        // null
    }
}
