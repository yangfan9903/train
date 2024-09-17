package com.example.day15template.config;

import com.example.day15template.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginCheckInterceptor loginCheckInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginCheckInterceptor).addPathPatterns("/**").excludePathPatterns("/employee/login").excludePathPatterns("/front/**").excludePathPatterns("/backend/**").excludePathPatterns("/common/**")
                .excludePathPatterns("/user/sendMsg").excludePathPatterns("/user/login");
    }
}
