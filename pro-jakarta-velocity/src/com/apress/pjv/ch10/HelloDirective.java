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
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.Token;
import org.apache.velocity.runtime.parser.node.Node;

/**
 * @author robh
 *  
 */
public class HelloDirective extends Directive {

    private static final String NAME = "hello";

    public String getName() {
        return NAME;
    }

    public int getType() {
        return LINE;
    }

    public boolean render(InternalContextAdapter context, Writer writer,
            Node node) throws IOException, ResourceNotFoundException,
            ParseErrorException, MethodInvocationException {

        if (node.jjtGetNumChildren() != 1) {
            rsvc.error("#hello error - missing first argument");
            return false;
        }

        writer.write("Hello ");
        Node child = node.jjtGetChild(0);

        writer.write(child.value(context).toString());

        Token lastToken = node.getLastToken();

        if (lastToken.image.endsWith("\n")) {
            writer.write("\n");
        }

        return true;
    }
}