/*
 * Created on Mar 25, 2004
 */
package com.apress.pjv.ch5;

import java.util.ArrayList;
import java.util.List;

/**
 * @author robh
 */
public class SubscriberManager {

    public List getSubscribers() {
        List subscribers = new ArrayList();

        subscribers.add(new Subscriber("Rob", "Harrop",
                "rob@cakesolutions.net", new Category[] { Category.JAVA,
                        Category.DATABASE_SQL, Category.LEGO_MINDSTORMS},
                Format.HTML));
        subscribers.add(new Subscriber("Rob", "Harrop", "robh@robharrop.com",
                new Category[] { Category.JAVA, Category.DATABASE_SQL,
                        Category.OPEN_SOURCE}, Format.HTML));
        subscribers.add(new Subscriber("Rob", "Harrop", "robh@robharrop.com",
                new Category[] { Category.JAVA}, Format.PLAIN_TEXT));

        return subscribers;
    }
}
