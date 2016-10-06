/*
 * Created on May 21, 2004
 */
package com.apress.pjv.ch10;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;

/**
 * @author robh
 *  
 */
public class ImageDirective extends Directive {

    private static final String NAME = "image";

    private static final int ARG_PATH = 0;

    private static final int ARG_ALT = 1;

    private static final int ARG_WIDTH = 2;

    private static final int ARG_HEIGHT = 3;

    private String baseUrl = "";

    public String getName() {
        return NAME;
    }

    public int getType() {
        return LINE;
    }

    public void init(RuntimeServices rs, InternalContextAdapter context,
            Node node) throws Exception {
        super.init(rs, context, node);

        baseUrl = rs.getString("image.directive.base", baseUrl);
    }

    public boolean render(InternalContextAdapter context, Writer writer,
            Node node) throws IOException, ResourceNotFoundException,
            ParseErrorException, MethodInvocationException {

        int numChildren = node.jjtGetNumChildren();

        // must have at least two arguments
        if (numChildren < 2) {
            rsvc.error(
                "#image directive specified with invalid number of arguments");
            return false;
        }

        // write the opening tag
        writer.write("<img");

        // now write the path
        writeAttribute(writer, "src", baseUrl
                + node.jjtGetChild(ARG_PATH).value(context).toString());

        // now write the alt text
        writeAttribute(writer, "alt", node.jjtGetChild(ARG_ALT).value(context)
                .toString());

        // see if the width is specified
        if (ARG_WIDTH < numChildren) {
            writeAttribute(writer, "width", node.jjtGetChild(ARG_WIDTH).value(
                    context).toString());
        }

        // see if the height is specified
        if (ARG_HEIGHT < numChildren) {
            writeAttribute(writer, "height", node.jjtGetChild(ARG_HEIGHT)
                    .value(context).toString());
        }

        // write the close
        writer.write(">");
        return true;
    }

    private void writeAttribute(Writer writer, String attributeName,
            String value) throws IOException {
        writer.write(" ");
        writer.write(attributeName);
        writer.write("=\"");
        writer.write(value);
        writer.write("\"");
    }
}