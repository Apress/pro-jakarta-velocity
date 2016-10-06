/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import com.apress.pjv.ch4.AbstractVelocityContentTemplate;
import com.apress.pjv.ch4.ModelBean;


/**
 * @author robh
 */
public abstract class AbstractNewsletterTemplate extends AbstractVelocityContentTemplate
        implements NewsletterTemplate {

    private NewsletterSection[] sections;
    private Subscriber subscriber;
    
    /**
     * @return Returns the sections.
     */
    public NewsletterSection[] getSections() {
        return sections;
    }
    /**
     * @param sections The sections to set.
     */
    public void setSections(NewsletterSection[] sections) {
        this.sections = sections;
    }
    /**
     * @return Returns the subscriber.
     */
    public Subscriber getSubscriber() {
        return subscriber;
    }
    /**
     * @param subscriber The subscriber to set.
     */
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
    
    protected ModelBean getModel() {
        return new NewsletterModelBean(sections, subscriber);
    }
}
