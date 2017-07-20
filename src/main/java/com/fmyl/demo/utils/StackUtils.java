package com.fmyl.demo.utils;

/**
 * Created by fuzq on 17/7/12.
 */
public class StackUtils {

    /**
     * 打印线程
     */
    public static void outStack() {
        int i;
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        for (i = 0; i < stack.length; i++) {
            StackTraceElement ste = stack[i];
            LoggerUtils.getInstance().info("{}.{}:{}", ste.getClassName(), ste.getMethodName(), ste.getLineNumber());
        }
    }

    /**
     * 打印前一个线程数
     **/
    public static String outOneStack() {
        StackTraceElement stack[] = (new Throwable()).getStackTrace();
        if (stack.length > 1) {
            StackTraceElement ste = stack[1];
            return ste.getClassName() + "." + ste.getMethodName() + ":" + ste.getLineNumber();
        }
        return "";
    }

    public static void main(String[] args) {
        outStack();
    }
}
