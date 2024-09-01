package com.example.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.example.pojo.Result;
import com.example.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {

        // 1. 判断是否是登录页面
        String url = req.getRequestURL().toString(); // 得到请求的url
        log.info("请求的url:{}",url);
        if (url.contains("login")){
            log.info("登录请求,放行");

            return true;
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
            return false;
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
            return false;
        }

        log.info("已登录允许跳转");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("2============================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("3============================");
    }
}
