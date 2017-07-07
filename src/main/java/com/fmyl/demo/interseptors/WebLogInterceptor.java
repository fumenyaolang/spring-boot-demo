package com.fmyl.demo.interseptors;

import com.fmyl.demo.handers.RequestLogHander;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Created by fuzq on 17/7/4.
 */
public class WebLogInterceptor implements HandlerInterceptor {

    private RequestLogHander requestLogHander;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        requestLogHander = new RequestLogHander(request);
        requestLogHander.setStateDate(System.currentTimeMillis());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        requestLogHander.setEndDate(System.currentTimeMillis());
        requestLogHander.outLog();
    }

}
