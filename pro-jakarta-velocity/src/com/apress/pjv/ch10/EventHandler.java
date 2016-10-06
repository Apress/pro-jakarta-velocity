/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch10;

import org.apache.velocity.app.event.EventCartridge;
import org.apache.velocity.app.event.MethodExceptionEventHandler;
import org.apache.velocity.app.event.NullSetEventHandler;
import org.apache.velocity.app.event.ReferenceInsertionEventHandler;
import org.apache.velocity.context.Context;

/**
 * @author robh
 */
public class EventHandler implements ReferenceInsertionEventHandler,
        NullSetEventHandler, MethodExceptionEventHandler {

    public EventHandler(Context ctx) {
        EventCartridge ec = new EventCartridge();
        ec.addEventHandler(this);
        ec.attachToContext(ctx);
    }

    public Object referenceInsert(String reference, Object data) {
        System.out.println("referenceInsert: " + reference + " data: " + data);

        if ("$horse".equals(reference.trim())) { return "The Mighty " + data; }

        return data;
    }

    public boolean shouldLogOnNullSet(String lhs, String rhs) {
        System.out.println("shouldLogOnNullSet");
        System.out.println("lhs:" + lhs + " rhs:" + rhs);

        if ("$validNull".equals(rhs.trim())) {
            return false;
        } else {
            return true;
        }
    }

    public Object methodException(Class cls, String method, Exception e)
            throws Exception {
        return "An " + e.getClass().getName() + " was thrown by the " + method
                + " method of the " + cls.getName() + " class ["
                + e.getMessage() + "]";
    }
}