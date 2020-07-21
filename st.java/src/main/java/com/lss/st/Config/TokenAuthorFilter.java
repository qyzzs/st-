package com.lss.st.Config;

import javax.servlet.annotation.WebFilter;

import com.lss.st.Config.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//import springfox.documentation.spring.web.json.Json;

//import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/***************
 * token验证拦截
 * @author bamboo zjcjava@163.com
 * @time 2017-08-01
 */
@Component
//@WebFilter(urlPatterns = { "/api/v/*" }, filterName = "tokenAuthorFilter")
public class TokenAuthorFilter implements Filter {
    @Autowired
    private RedisUtil redisUtil;
    private static Logger logger = LoggerFactory
            .getLogger(TokenAuthorFilter.class);

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse rep = (HttpServletResponse) response;
        String path =req.getRequestURI();
        System.out.println(req.getMethod());
        String token=((HttpServletRequest) request).getHeader("Authorization");
        System.out.println("token："+token);
//        Integer uid = (Integer)session.getAttribute("")
        if(path.indexOf("/login")>-1){
            chain.doFilter(request,response);
        }
        if(path.indexOf("/findall")>-1){
            chain.doFilter(request,response);
        }
        if(path.indexOf("/menus")>-1){
            chain.doFilter(request,response);
        }
        if(token==redisUtil.get("token")){
            chain.doFilter(request,response);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}

