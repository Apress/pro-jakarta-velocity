/*
 * Created on Feb 26, 2004
 */
package com.apress.pjv.ch10;

import java.util.Random;


/**
 * @author robh
 */
public class RandomExceptionGenerator {

    public String generate() throws Exception {
        Random rnd = new Random();
        
        int x = rnd.nextInt(5);
        
        if(x == 2) {
            throw new Exception("Unlucky!");
        } else {
            return "Whew! That was close";
        }
    }
}
