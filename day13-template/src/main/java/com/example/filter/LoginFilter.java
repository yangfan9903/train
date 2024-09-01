package com.example.filter;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import com.github.pagehelper.util.StringUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        // 1. 判断是否是登录页面
        String url = req.getRequestURL().toString(); // 得到请求的url
        log.info("请求的url:{}",url);
        if (url.contains("login")){
            log.info("登录请求,放行");
            chain.doFilter(request,response);
            return;
        }

        // 2. 非登录请求，判断请求头令牌是否合法
        // 判断jwt令牌是否存在
        String jwt = req.getHeader("token");
        if (!StringUtils.hasLength(jwt)){
            log.info("未登录，请登录");
            String msg = "NOT_LOGIN";
            Result error = Result.error(msg);
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }
        // 解析token,看是否解析成功
        try {
            JwtUtils.parseJWT(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            log.info("解析令牌失败,返回未登录信息");
            String msg = "NOT_LOGIN";
            Result error = Result.error(msg);
            String notLogin = JSONObject.toJSONString(error);
            resp.getWriter().write(notLogin);
            return;
        }

        log.info("已登录允许跳转");
        chain.doFilter(request,response);


    }
}
