package com.fmyl.demo.handers;

import com.fmyl.demo.utils.LoggerUtils;
import com.fmyl.demo.utils.StackUtils;

import java.util.Vector;

/**
 * service result hander
 * Created by fuzq on 17/7/7.
 */
public class ServiceResultHander<T> {

    public static boolean RESULT_FAIL = false;
    public static boolean RESULT_SUCCESS = true;

    private boolean flag;
    /**
     * 受影响的行数
     */
    private int size;
    private Vector error;
    private T result;

    private ServiceResultHander() {
    }

    /**
     * @param flag   执行是否成功
     * @param size   受影响的行数
     * @param error  错误信息
     * @param result 返回前台的结果
     */
    public ServiceResultHander(boolean flag, int size, Vector error, T result) {
        this.flag = flag;
        this.size = size;
        this.error = error;
        this.result = result;
        outLog();
    }

    private void outLog() {
        LoggerUtils.getInstance().info("{},{},{},{},{}", StackUtils.outOneStack(), flag, size, error, result);
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Vector getError() {
        return error;
    }

    public void setError(Vector error) {
        this.error = error;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
