package com.example.day15template.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.day15template.common.R;
import com.example.day15template.utils.JwtUtils;
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
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String jwt = (String)request.getSession().getAttribute("employee");
        log.info(jwt);
        if (!StringUtils.hasLength(jwt)){
            log.info("未登录，请登录");
            String msg = "NOTLOGIN";
            R error = R.error(msg);
            System.out.println(error);
            String notLogin = JSON.toJSONString(error);
            log.info(notLogin);
            response.getWriter().write(notLogin); // 为了前端跳转
            return false;// 为了不访问页面
        }
        try {
            JwtUtils.parseJwt(jwt);
        } catch (Exception e) {
            e.printStackTrace();
            String msg = "NOTLOGIN";
            R error = R.error(msg);
            String notLogin = JSON.toJSONString(error);
            response.getWriter().write(notLogin);
            return false;
        }
        log.info("已登录允许跳转");
        return true;
    }
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
//        System.out.println("2============================");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
//        System.out.println("3============================");
    }
}
