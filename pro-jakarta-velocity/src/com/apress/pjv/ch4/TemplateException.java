/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;

/**
 * @author robh
 */
public class TemplateException extends RuntimeException {

    /**
     *  
     */
    public TemplateException() {
        super();
    }

    /**
     * @param arg0
     */
    public TemplateException(String msg) {
        super(msg);
    }

    /**
     * @param arg0
     * @param arg1
     */
    public TemplateException(String msg, Throwable cause) {
        super(msg, cause);
    }

    /**
     * @param arg0
     */
    public TemplateException(Throwable cause) {
        super(cause);
    }

}
