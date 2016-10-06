/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.Template;
import org.apache.velocity.context.Context;
import org.apache.velocity.servlet.VelocityServlet;

/**
 * @author robh
 *  
 */
public class HelloWorldServlet extends VelocityServlet {

    public Template handleRequest(HttpServletRequest request,
            HttpServletResponse response, Context context) {

        String name = "World";

        if (request.getParameter("name") != null) {
            name = request.getParameter("name").toString();
        }

        context.put("name", name);

        Template t = null;

        try {
            t = getTemplate("helloWorld.vm");
        } catch (Exception ex) {
            log("Unable to find the template helloWorld.vm");
        }

        return t;
    }
}