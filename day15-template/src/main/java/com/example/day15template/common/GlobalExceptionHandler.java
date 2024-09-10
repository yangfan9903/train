package com.example.day15template.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

/**
 * 全局宜昌处理
 */
@ControllerAdvice(annotations = {RestController.class})
@ResponseBody // 为了输出是Json数据
@Slf4j
public class GlobalExceptionHandler {
    /**
     * 查询异常处理方法(唯一性异常)
     * @return
     */
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public R<String> excetionHandler(SQLIntegrityConstraintViolationException ex){
        log.error(ex.getMessage());
        if (ex.getMessage().contains("Duplicate entry")){
            String[] split = ex.getMessage().split(" ");
            String msg = split[2]+"已存在";
            return R.error(msg);
        }

        return R.error("未知错误");
    }


    @ExceptionHandler(CustomException.class)
    public R<String> excetionHandler(CustomException ex){
        log.error(ex.getMessage());

        return R.error(ex.getMessage());
    }
}
