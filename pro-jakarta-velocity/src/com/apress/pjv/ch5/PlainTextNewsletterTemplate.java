/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;


/**
 * @author robh
 */
public class PlainTextNewsletterTemplate extends AbstractNewsletterTemplate {

    /* (non-Javadoc)
     * @see com.apress.pjv.ch4.AbstractVelocityContentTemplate#getResourceName()
     */
    protected String getResourceName() {
        return "plainText/newsletter.vm";
    }
}
