/*
 * Created on Apr 8, 2004
 */
package com.apress.pjv.ch7;

import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

/**
 * @author robh
 *  
 */
public class HelloPeopleJDOM {

    public static void main(String[] args) throws Exception {
        SAXBuilder builder = new SAXBuilder();
        Document doc = builder.build("src/xml/ch7/helloPeople/helloPeople.xml");

        StringBuffer output = new StringBuffer();

        // create the basic HTML output
        output.append("<html>\n").append(
                "<head>\n<title>\nPerson List</title>\n</head>\n").append(
                "<body>\n").append("<ul>\n");

        Iterator itr = doc.getRootElement().getChildren().iterator();

        while (itr.hasNext()) {
            Element elem = (Element) itr.next();

            output.append("<li>");
            output.append(elem.getAttribute("lastName").getValue());
            output.append(", ");
            output.append(elem.getAttribute("firstName").getValue());
            output.append("</li>\n");
        }

        // create the end of the HTML output
        output.append("</ul>\n</body>\n</html>");

        System.out.println(output.toString());
    }
}