/*
 * Created on Apr 7, 2004
 */
package com.apress.pjv.ch7;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * @author robh
 *  
 */
public class HelloWorldJDOM {

    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build("src/xml/ch7/helloWorld/helloWorld.xml");

        Element jdomRoot = doc.getRootElement();
        System.out.println(jdomRoot.getChild("msg").getText());
    }
}