package com.fmyl.demo.utils;

import org.slf4j.Logger;

/**
 * Created by fuzq on 17/7/7.
 */
public class LoggerUtils {

    private Logger logger;

    private LoggerUtils() {
        this.logger = org.slf4j.LoggerFactory.getLogger("");
    }

    private LoggerUtils(Class clazz) {
        this.logger = org.slf4j.LoggerFactory.getLogger(clazz);
    }

    public static LoggerUtils getInstance() {
        return LoggerFactory.instance();
    }

    public static LoggerUtils getInstance(Class clazz) {
        return LoggerFactory.instance(clazz);
    }

    public void info(String var1) {
        logger.info(var1);
    }

    public void info(String var1, Object... var2) {
        logger.info(var1, var2);
    }

    public void error(String var1) {
        logger.info(var1);
    }

    public void error(String var1, Object... var2) {
        logger.info(var1, var2);
    }

    public static void getCaller() {
        int i;
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (i = 0; i < stack.length; i++) {
            StackTraceElement ste = stack[i];
            LoggerUtils.getInstance().info("{}.{}:{}", ste.getClassName(), ste.getMethodName(), ste.getLineNumber());
        }
    }

    public static String getCaller(int step) {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        if (step < stack.length) {
            StackTraceElement ste = stack[step];
            return ste.getClassName() + "." + ste.getMethodName() + ":" + ste.getLineNumber();
        }
        return "";
    }

    private static class LoggerFactory {
        private static LoggerUtils instance() {
            return new LoggerUtils();
        }

        private static LoggerUtils instance(Class clazz) {
            return new LoggerUtils(clazz);
        }
    }

    public static void main(String[] args) {
        getCaller();
    }
}
