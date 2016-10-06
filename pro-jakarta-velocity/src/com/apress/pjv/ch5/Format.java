/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;


/**
 * @author robh
 */
public class Format {

    public static final Format PLAIN_TEXT = new Format("text/plain");
    public static final Format HTML = new Format("text/html");

    private String contentType = null;
    
    private Format(String contentType) {
        this.contentType = contentType;
    }
    
    public String getContentType() {
        return contentType;
    }
}
