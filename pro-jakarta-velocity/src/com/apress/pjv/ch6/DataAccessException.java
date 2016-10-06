/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;


/**
 * @author robh
 *
 */
public class DataAccessException extends RuntimeException {

    
    /**
     * 
     */
    public DataAccessException() {
        super();
    }
    /**
     * @param arg0
     */
    public DataAccessException(String msg) {
        super(msg);
    }
    /**
     * @param arg0
     * @param arg1
     */
    public DataAccessException(String msg, Throwable rootCause) {
        super(msg, rootCause);
    }
    /**
     * @param arg0
     */
    public DataAccessException(Throwable rootCause) {
        super(rootCause);
    }
}
