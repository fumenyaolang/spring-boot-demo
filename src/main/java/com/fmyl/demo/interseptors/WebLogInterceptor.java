package com.fmyl.demo.interseptors;

import com.fmyl.demo.handers.RequestLogHander;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by fuzq on 17/7/4.
 */
public class WebLogInterceptor implements HandlerInterceptor {

    private Logger logger = LoggerFactory.getLogger(WebLogInterceptor.class);
    private RequestLogHander requestModel;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        requestModel = new RequestLogHander(request);
        requestModel.setStateDate(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("post handle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        requestModel.setEndDate(System.currentTimeMillis());
        requestModel.outLog();
    }

}
