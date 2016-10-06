/*
 * Created on May 21, 2004
 */
package com.apress.pjv.ch10;

import org.apache.velocity.runtime.RuntimeServices;
import org.apache.velocity.runtime.log.LogSystem;

/**
 * @author robh
 *  
 */
public class ConsoleLogSystem implements LogSystem {

    private RuntimeServices rs;
    
    private int maxLevel = LogSystem.INFO_ID;

    private static final String[] LEVEL_NAMES = new String[] { "ERROR", "WARN", "INFO",
            "DEBUG"};

    private static final int[] LEVELS = new int[] { LogSystem.ERROR_ID, LogSystem.WARN_ID,
            LogSystem.INFO_ID, LogSystem.DEBUG_ID};

    public void init(RuntimeServices rs) throws Exception {
        System.out.println("ConsoleLogSystem.init() called");

        this.rs = rs;
        configure();

        System.out.println("ConsoleLogSystem.init() finished");
    }

    public void logVelocityMessage(int level, String message) {

        if(level >= maxLevel) {
            System.out.println("[" + getLevelName(level) + "] " + message);
        }
    }

    private void configure() {
        String maxLevelName = rs.getString("console.logsystem.max.level");
        
        int level = getLevelFromString(maxLevelName);
        
        if(level > -1) {
            System.out.println("Using log level: " + maxLevelName);
            maxLevel = level;
        }
    }

    private int getLevelFromString(String levelName) {
        for(int x = 0; x < LEVEL_NAMES.length; x++) {
            if(LEVEL_NAMES[x].equals(levelName)) {
                return LEVELS[x];
            }
        }
        
        return -1; // couldn't find the level
    }
    
    private String getLevelName(int level) {
        for(int x = 0; x < LEVELS.length; x++) {
            if(LEVELS[x] == level) {
                return LEVEL_NAMES[x];
            }
        }
        
        return "UNKNOWN";
    }
}