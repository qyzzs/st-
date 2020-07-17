package com.lss.st.Config;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*" ,filterName = "log")
@Order(1)
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse rep= (HttpServletResponse) servletResponse;
        String token=req.getHeader("Authorization");
        System.out.println("token:"+token);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("开始过滤");
    }

    @Override
    public void destroy() {

    }
}
