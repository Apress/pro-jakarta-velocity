/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author robh
 */
public class UserProfileTemplateImpl extends AbstractVelocityContentTemplate
        implements UserProfileTemplate {

    private UserProfile userProfile;

    public UserProfile getUserProfile() {
        return userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }

    protected String getResourceName() {
        return "userProfile.vm";
    }

    protected ModelBean getModel() {
        String timestamp = DateFormat.getDateTimeInstance().format(new Date());
        return new UserProfileModelBean(userProfile, timestamp);
    }
}
