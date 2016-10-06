/*
 * Created on Apr 16, 2004
 */
package com.apress.pjv.ch8;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author robh
 *  
 */
public class FooServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        process(request, response);
    }

    private void process(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // add a Foo to the request scope
        Foo foo = new Foo();
        foo.setValue("I am a request scope bean");
        request.setAttribute("servletFoo", foo);

        // add a Foo to the session scope
        foo = new Foo();
        foo.setValue("I am a session scope bean");
        request.getSession().setAttribute("servletFoo", foo);

        // now display the view page
        String viewName = this.getInitParameter("viewName");
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewName);
        dispatcher.forward(request, response);
    }
}