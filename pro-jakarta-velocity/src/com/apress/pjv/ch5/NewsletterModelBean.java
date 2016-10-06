/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import com.apress.pjv.ch4.ModelBean;

/**
 * @author robh
 */
public class NewsletterModelBean implements ModelBean {

    private NewsletterSection[] sections = null;

    private Subscriber subscriber = null;

    public NewsletterModelBean(NewsletterSection[] sections,
            Subscriber subscriber) {
        this.sections = sections;
        this.subscriber = subscriber;
    }

    public String getModelName() {
        return "newsletter";
    }

    /**
     * @return Returns the sections.
     */
    public NewsletterSection[] getSections() {
        return sections;
    }

    /**
     * @param sections
     *            The sections to set.
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
     * @param subscriber
     *            The subscriber to set.
     */
    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }
}
