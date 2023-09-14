package com.example.email.service.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class GlobalInterceptor implements HandlerInterceptor {

    private final List<String> list = Arrays.asList("Thể thao", "Thời Sự", "Hài Kịch", "Đô vật");

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler
    ) {
        request.setAttribute("uri", request.getRequestURI());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView
    ) {
        request.setAttribute("categories", list);
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex
    ) {
        System.out.println("afterCompletion()->" + request.getRequestURI());
    }
}
