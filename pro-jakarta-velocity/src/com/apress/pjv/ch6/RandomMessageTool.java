/*
 * Created on Apr 2, 2004
 */
package com.apress.pjv.ch6;

import java.util.Random;

/**
 * @author robh
 *  
 */
public class RandomMessageTool {

    private static String[] MESSAGES = new String[] { "Hello World!",
            "May the Force be with you",
            "If I'm reading this right, and I'd to think that I am...",
            "Core Purge!",
            "Welcome back Mr. Anderson - we missed you...",
            "I will fong you!",
            "One Ring to rule them all!"};

    private Random rnd = null;
    
    public RandomMessageTool() {
        rnd = new Random();
    }
    
    public String generateMessage() {
        int index = rnd.nextInt(MESSAGES.length);
        return MESSAGES[index];
    }
}