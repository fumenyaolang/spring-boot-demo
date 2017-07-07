package com.fmyl.demo.handers;

import com.fmyl.demo.utils.DateUtils;
import com.fmyl.demo.utils.LoggerUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by fuzq on 17/7/4.
 */
public class RequestLogHander {

    private LoggerUtils logger = LoggerUtils.getInstance(RequestLogHander.class);

    private String url;
    private Vector<String> parameters;
    private String method;
    private Long stateDate;
    private Long endDate;

    private RequestLogHander() {
    }

    public RequestLogHander(HttpServletRequest request) {
        method = request.getMethod();
        url = request.getScheme() + "://" + request.getLocalAddr() + ":" + request.getLocalPort() + request.getContextPath() + request.getRequestURI();
        Enumeration<String> parameterNames = request.getParameterNames();
        parameters = new Vector<String>();
        while (parameterNames.hasMoreElements()) {
            String element = parameterNames.nextElement();
            parameters.add(element + "=" + request.getParameter(element));
        }
    }

    public void setStateDate(Long stateDate) {
        this.stateDate = stateDate;
    }

    public void setEndDate(Long endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "RequestModel{" +
                "url='" + url + '\'' +
                ", parameters=" + parameters +
                ", method='" + method + '\'' +
                '}';
    }

    public void outLog() {
        logger.info("request.log: {},{},{},{}", url, method, parameters, DateUtils.between(stateDate, endDate));
    }
}
