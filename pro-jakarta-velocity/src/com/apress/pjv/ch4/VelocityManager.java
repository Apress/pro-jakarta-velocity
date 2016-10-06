/*
 * Created on Mar 6, 2004
 */
package com.apress.pjv.ch4;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.context.Context;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

/**
 * @author robh
 */
public class VelocityManager {

    private static VelocityEngine engine;

    static {
        engine = new VelocityEngine();
    }

    private VelocityManager() {
        // prevent instantiation
    }
    
    public static void init() throws Exception {
        engine.init();
    }

    public static void init(Properties props) throws Exception {
        engine.init(props);
    }

    public static void init(String fileName) throws Exception {
        engine.init(fileName);
    }

    public static void addProperty(String key, Object value) {
        engine.addProperty(key, value);
    }

    public static void clearProperty(String key) {
        engine.clearProperty(key);
    }

    public static Object getProperty(String key) {
        return engine.getProperty(key);
    }

    public static void setProperty(String key, Object value) {
        engine.setProperty(key, value);
    }

    public static void evaluate(Context ctx, Writer writer, String logTag,
            Reader reader) throws IOException, MethodInvocationException,
            ParseErrorException, ResourceNotFoundException {
        engine.evaluate(ctx, writer, logTag, reader);
    }

    public static void evaluate(Context ctx, Writer writer, String logTag,
            String inString) throws IOException, MethodInvocationException,
            ParseErrorException, ResourceNotFoundException {
        engine.evaluate(ctx, writer, logTag, inString);
    }

    public static Template getTemplate(String name) throws Exception,
            ParseErrorException, ResourceNotFoundException {
        return engine.getTemplate(name);
    }

    public static Template getTemplate(String name, String encoding)
            throws Exception, ParseErrorException, ResourceNotFoundException {
        return engine.getTemplate(name, encoding);
    }

    public static boolean mergeTemplate(String name, Context ctx, Writer writer)
            throws Exception {
        return engine.mergeTemplate(name, ctx, writer);
    }

    public static boolean mergeTemplate(String name, String encoding,
            Context ctx, Writer writer) throws Exception {
        return engine.mergeTemplate(name, encoding, ctx, writer);
    }

}
