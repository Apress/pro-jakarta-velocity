/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch4;

import java.io.Writer;


/**
 * @author robh
 */
public interface ContentTemplate {

    public String generate() throws TemplateException;
    public void generate(Writer writer) throws TemplateException;
}
