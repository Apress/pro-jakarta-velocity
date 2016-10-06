/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.util.Map;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.context.Context;


/**
 * @author robh
 */
public class ContextFactory {

    public static Context getInstance() {
        return new VelocityContext();
    }
    
    public static Context getInstance(Map map) {
        return new VelocityContext(map);
    }
    
    public static Context getInstance(Context innerContext) {
        return new VelocityContext(innerContext);
    }
    
    public static Context getInstance(Map map, Context innerContext) {
        return new VelocityContext(map, innerContext);
    }
}