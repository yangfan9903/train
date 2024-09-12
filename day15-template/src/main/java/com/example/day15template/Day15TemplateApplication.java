package com.example.day15template;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Day15TemplateApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day15TemplateApplication.class, args);
    }

}
