/*
 * Created on Apr 16, 2004
 */
package com.apress.pjv.ch8;

/**
 * @author robh
 *  
 */
public class Person {

    private String id;

    private String name;

    private String emailAddress;

    public Person(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}