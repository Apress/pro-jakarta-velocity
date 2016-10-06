/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;


/**
 * @author robh
 */
public class UserProfileGenerator {

    public static void main(String[] args) throws TemplateException{
        UserProfile up = new UserProfile();
        up.setFirstName("Rob");
        up.setLastName("Harrop");
        up.setEmailAddress("rob@cakesolutions.net");
        
        UserProfileTemplate upt = TemplateFactory.getUserProfileTemplate();
        upt.setUserProfile(up);
        
        System.out.println(upt.generate());
    }
}
