/*
 * Created on Apr 16, 2004
 */
package com.apress.pjv.ch8;

import java.io.FileInputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.context.Context;
import org.apache.velocity.texen.ant.TexenTask;

/**
 * @author robh
 *  
 */
public class NameCardTask extends TexenTask {

    private String peopleProperties = "people.properties";

    private static final String NAME_PROPERTY = "name";

    private static final String EMAILADDRESS_PROPERTY = "emailAddress";

    public void setPeopleProperties(String peopleProperties) {
        this.peopleProperties = peopleProperties;
    }

    protected void populateInitialContext(Context ctx) throws Exception {
        super.populateInitialContext(ctx);

        ctx.put("people", loadPeople());
    }

    private Collection loadPeople() throws Exception {
        ExtendedProperties props = new ExtendedProperties();
        props.load(new FileInputStream(peopleProperties));

        Map people = new HashMap();
        Iterator itr = props.getKeys();

        while (itr.hasNext()) {
            String key = (String) itr.next();

            // find the id of the person
            int index = key.indexOf('.');
            String id = key.substring(0, key.indexOf('.'));

            Person p = null;

            if (people.containsKey(id)) {
                p = (Person) people.get(id);
            } else {
                p = new Person(id);
            }

            // find which property this is
            String prop = key.substring(index + 1);

            if (NAME_PROPERTY.equals(prop)) {
                p.setName(props.getString(key));
            } else if (EMAILADDRESS_PROPERTY.equals(prop)) {
                p.setEmailAddress(props.getString(key));
            }

            people.put(id, p);
        }

        return people.values();
    }
}