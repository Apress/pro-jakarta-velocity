/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

/**
 * @author robh
 */
public class Subscriber {

    private String firstName = null;

    private String lastName = null;

    private String emailAddress = null;

    private Format preferredFormat = Format.PLAIN_TEXT;

    private Category[] subscribedCategories = null;

    public Subscriber(String firstName, String lastName, String emailAddress,
            Category[] subscribedCategories, Format preferredFormat) {
        
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.subscribedCategories = subscribedCategories;
        this.preferredFormat = preferredFormat;
    }

    /**
     * @return Returns the emailAddress.
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * @param emailAddress
     *            The emailAddress to set.
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * @return Returns the firstName.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName
     *            The firstName to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return Returns the lastName.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName
     *            The lastName to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return Returns the preferredFormat.
     */
    public Format getPreferredFormat() {
        return preferredFormat;
    }

    /**
     * @param preferredFormat
     *            The preferredFormat to set.
     */
    public void setPreferredFormat(Format preferredFormat) {
        this.preferredFormat = preferredFormat;
    }

    /**
     * @return Returns the subscribedCategories.
     */
    public Category[] getSubscribedCategories() {
        return subscribedCategories;
    }

    /**
     * @param subscribedCategories
     *            The subscribedCategories to set.
     */
    public void setSubscribedCategories(Category[] subscribedCategories) {
        this.subscribedCategories = subscribedCategories;
    }
}
