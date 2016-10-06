/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.context.Context;

/**
 * @author robh
 */
public class ContextUtils {

    private static Map propertyCache = null;

    static {
        propertyCache = new HashMap();
    }

    public static void addPropertiesToContext(Context ctx, Object bean)
            throws IntrospectionException, IllegalAccessException,
            InvocationTargetException {

        // try to retreive the properties from the cache
        PropertyDescriptor[] props = (PropertyDescriptor[]) propertyCache
                .get(bean.getClass());

        // no properties in the cache - find them and add them to the cache
        if (props == null) {
            BeanInfo inf = Introspector.getBeanInfo(bean.getClass());
            props = inf.getPropertyDescriptors();

            synchronized (propertyCache) {
                propertyCache.put(bean.getClass(), props);
            }
        }

        // retreive the property values and add them to context
        for (int x = 0; x < props.length; x++) {
            PropertyDescriptor prop = props[x];

            ctx.put(prop.getName(), prop.getReadMethod().invoke(bean, null));
        }

    }
}