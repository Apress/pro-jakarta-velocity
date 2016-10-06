/*
 * Created on Apr 8, 2004
 */
package com.apress.pjv.ch7;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author robh
 *  
 */
public class HelloWorldJAXP {

    public static void main(String[] args) throws Exception {

        DocumentBuilder builder = DocumentBuilderFactory.newInstance()
                .newDocumentBuilder();

        Document doc = builder.parse("src/xml/ch7/helloWorld/helloWorld.xml");

        Element jaxpRoot = doc.getDocumentElement();

        // Can't use root.getFirstChild() in case
        // of whitespace!
        NodeList nodes = jaxpRoot.getElementsByTagName("msg");

        Element msgElement = (Element) nodes.item(0);

        // can't use msgElement.getNodeValue()
        // it returns null!

        nodes = msgElement.getChildNodes();

        for (int x = 0; x < nodes.getLength(); x++) {
            Node node = nodes.item(x);

            if (node.getNodeType() == Node.TEXT_NODE) {
                System.out.println(node.getNodeValue());
                break;
            }
        }
    }
}