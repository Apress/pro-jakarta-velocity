/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;


/**
 * @author robh
 */
public class TemplateFactory {
    
    public static UserProfileTemplate getUserProfileTemplate() {
        return new UserProfileTemplateImpl();
    }
}
