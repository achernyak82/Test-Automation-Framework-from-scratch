package com.epam.cdp.designpatterns.logging;

import org.apache.log4j.Logger;

public class MyLogger {
    public static Logger logger = Logger.getLogger(MyLogger.class);

    public static void error(String message) {
        logger.error(message);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}
