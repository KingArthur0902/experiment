package com.threadblocked.experiment.spring.common.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

/**
 * 这是一个spring的拦截器，拦截请求，请求前先判断一个时间范围
 * 参考自spring 官方文档
 * Created by ArthurTsang on 7/12/16.
 */
public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {
    private int openingTime;
    private int closingTime;


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if( openingTime <= hour && hour <= closingTime){
            return true;
        }
        response.sendRedirect("http://www.google.com");
        return false;
    }

    public int getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(int openingTime) {
        this.openingTime = openingTime;
    }

    public int getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(int closingTime) {
        this.closingTime = closingTime;
    }
}
