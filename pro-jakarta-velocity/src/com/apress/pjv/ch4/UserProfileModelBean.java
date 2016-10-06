/*
 * Created on Mar 7, 2004
 */
package com.apress.pjv.ch4;


/**
 * @author robh
 */
public class UserProfileModelBean implements ModelBean {

    private UserProfile profile;
    private String timestamp;

    public UserProfileModelBean(UserProfile aProfile, String aTimestamp) {
        profile = aProfile;
        timestamp = aTimestamp;
    }

    public String getModelName() {
        return "userProfileModel";
    }

    public UserProfile getUserProfile() {
        return profile;
    }

    public void setUserProfile(UserProfile aProfile) {
        profile = aProfile;
    }
    
    public String getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(String aTimestamp) {
        timestamp = aTimestamp;
    }
    
    public String toString() {
        return profile.getFirstName();
    }
}
