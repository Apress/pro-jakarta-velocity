/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import com.apress.pjv.ch4.ContentTemplate;


/**
 * @author robh
 */
public interface NewsletterTemplate extends ContentTemplate {

    public NewsletterSection[] getSections();
    public void setSections(NewsletterSection[] sections);
    
    public Subscriber getSubscriber();
    public void setSubscriber(Subscriber subscriber);
}
