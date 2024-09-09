package com.vn.ShopService.configuration;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;

@Component
@Order(Ordered.LOWEST_PRECEDENCE)
public class LogTimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        String url = ((HttpServletRequest) request).getRequestURI();
        chain.doFilter(request, response);
        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        if (duration > 100) {
            System.out.println("---------------------");
            System.out.println("Request url " + url
                    + " start at " + new Date(startTime) + " end at " + new Date(endTime) + " duration: " + duration + " ms");
            System.out.println("---------------------");
        }
    }

    @Override
    public void destroy() {

    }
}