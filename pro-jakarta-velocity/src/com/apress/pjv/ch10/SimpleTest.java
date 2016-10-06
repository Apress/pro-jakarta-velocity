/*
 * Created on May 21, 2004
 */
package com.apress.pjv.ch10;

import java.io.File;
import java.net.URL;

/**
 * @author robh
 *  
 */
public class SimpleTest {

    private static final String PATH = "src/templates/ch10/customLoader.vm";

    private static final String URL = "templates/ch10/customLoader.vm";

    public static void main(String[] args) throws Exception {
        long before, after;
        int numTimes = 10000;
        ClassLoader cl = SimpleTest.class.getClassLoader();

        System.out.println("Testing File");

        before = System.currentTimeMillis();
        for (int x = 0; x < numTimes; x++) {
            File file = new File(PATH);
            long lm = file.lastModified();
        }
        after = System.currentTimeMillis();

        System.out.println("Took: " + (after - before) + " ms");

        System.out.println("Testing URL");
        before = System.currentTimeMillis();

        for (int x = 0; x < numTimes; x++) {
            URL url = cl.getResource(URL);
            long lm = url.openConnection().getLastModified();
        }
        after = System.currentTimeMillis();

        System.out.println("Took: " + (after - before) + " ms");

        System.out.println("Testing  Cached URL");

        before = System.currentTimeMillis();
        URL url = cl.getResource(URL);

        for (int x = 0; x < numTimes; x++) {
            long lm = url.openConnection().getLastModified();
        }
        after = System.currentTimeMillis();

        System.out.println("Took: " + (after - before) + " ms");
    }
}