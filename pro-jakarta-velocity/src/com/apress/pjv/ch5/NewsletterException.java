/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

/**
 * @author robh
 */
public class NewsletterException extends RuntimeException {

    public NewsletterException() {
        super();
    }

    public NewsletterException(String msg) {
        super(msg);
    }

    public NewsletterException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }

    public NewsletterException(Throwable rootCause) {
        super(rootCause);
    }
}
