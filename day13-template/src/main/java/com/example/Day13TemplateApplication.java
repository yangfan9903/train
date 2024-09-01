package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 当天项目已经开启了filter的支持
@SpringBootApplication
public class Day13TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day13TemplateApplication.class, args);
    }

}
