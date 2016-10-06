/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

/**
 * @author robh
 */
public class NewsletterTemplateFactory {

    private static NewsletterTemplateFactory instance;

    static {
        instance = new NewsletterTemplateFactory();
    }

    private NewsletterTemplateFactory() {
        // no-op
    }

    public static NewsletterTemplateFactory getInstance() {
        return instance;
    }

    public NewsletterTemplate getNewsletterTemplate(Format format) {
        if (format == Format.HTML) {
            return new HtmlNewsletterTemplate();
        } else {
            return new PlainTextNewsletterTemplate();
        }
    }
}
