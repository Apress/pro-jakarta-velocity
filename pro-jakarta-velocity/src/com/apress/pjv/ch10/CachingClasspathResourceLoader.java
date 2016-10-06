/*
 * Created on May 21, 2004
 */
package com.apress.pjv.ch10;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections.ExtendedProperties;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.resource.Resource;
import org.apache.velocity.runtime.resource.loader.ResourceLoader;

/**
 * @author robh
 *  
 */
public class CachingClasspathResourceLoader extends ResourceLoader {

    private Map urlMap = new HashMap();

    public void init(ExtendedProperties configuration) {

    }

    public synchronized InputStream getResourceStream(String resourceName)
            throws ResourceNotFoundException {
        try {
            URL url = getURL(resourceName);

            if (url == null) { throw new ResourceNotFoundException(
                    "Can not find resource: " + resourceName); }
            return url.openStream();
        } catch (IOException e) {
            throw new ResourceNotFoundException("Can not find resource: "
                    + resourceName + " - Reason: " + e.getMessage());
        }
    }

    public long getLastModified(Resource resource) {
        try {
            URL url = getURL(resource.getName());
            long lm = url.openConnection().getLastModified();
            return lm;
        } catch (Exception e) {
            rsvc.error(e);
            return 0;
        }
    }

    public boolean isSourceModified(Resource resource) {
        long lm = getLastModified(resource);
        return (lm != resource.getLastModified());
    }

    private URL getURL(String resourceName) {
        if (urlMap.containsKey(resourceName)) { return (URL) urlMap
                .get(resourceName); }

        ClassLoader cl = this.getClass().getClassLoader();
        URL url = cl.getResource(resourceName);

        if (url != null) {
            urlMap.put(resourceName, url);
        }

        return url;
    }
}