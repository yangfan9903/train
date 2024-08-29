package com.example.controller;

import com.example.mapper.DeptMapper;
import com.example.pojo.Dept;
import com.example.pojo.Result;
import com.example.service.impl.DeptServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController  // 是组合注解包括responsebody 会将返回值转成json
public class DeptController {
    @Autowired
    private DeptServiceImpl deptServiceImpl;

    @GetMapping("/depts")
    public Result selectAll(){
        log.info("正在调用接口");
        List<Dept> deptList = deptServiceImpl.selectAll();
        return Result.success(deptList);
    }
}
