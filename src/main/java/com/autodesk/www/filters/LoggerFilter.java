package com.autodesk.www.filters;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(3)
public class LoggerFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("====>Fileter Start: start logger filter!");
        chain.doFilter(request, response);
        System.out.println("=====>Filter End: end logger filter!");
    }
    @Override
    public void destroy() {
    }
}